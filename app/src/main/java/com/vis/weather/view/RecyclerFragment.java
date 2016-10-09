package com.vis.weather.view;

import android.Manifest;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.mapapi.map.*;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;
import com.vis.weather.MainActivity;
import com.vis.weather.R;
import com.vis.weather.SplashActivity;
import com.vis.weather.explosionfield.ExplosionField;
import com.vis.weather.model.WeatherDaily;
import com.vis.weather.model.WeatherHour;
import com.vis.weather.presenter.GetOnlineData;
import com.vis.weather.presenter.RecyclerViewAdapter;
import com.vis.weather.presenter.StaggeredViewAdapter;
import com.vis.weather.presenter.WeaDataAdapter;
import com.vis.weather.util.*;
import com.vis.weather.util.base.GsonUtil;
import com.vis.weather.util.base.SnackbarUtil;
import com.vis.weather.util.base.ToDate;
import com.vis.weather.view.Interfa.Mainview;
import com.vis.weather.view.base.BaseFragment;
import com.vis.weather.view.base.WaitDialog;
import com.yolanda.nohttp.rest.RequestQueue;
import rx.Observer;

import java.io.File;
import java.util.*;


public class RecyclerFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, RecyclerViewAdapter.OnItemClickListener,
        StaggeredViewAdapter.OnItemClickListener, Mainview {
    private ExplosionField mExplosionField;

    String[] mTitles;
    private ImageView mImageView_back;
    private CollapsingToolbarLayout mToolbar_title;
    //    @BindView(R.id.toolbar_layout_title)
//    CollapsingToolbarLayout collapsing;
//    @BindView(R.id.imageview_back)
//    ImageView back;

    @BindViews({R.id.t_temp_1, R.id.t_temp_2, R.id.t_humidity, R.id.t_rain, R.id.t_speed, R.id.t_visibility, R.id.t_location, R.id.t_from,
            R.id.t_update, R.id.t_date, R.id.t_detail, R.id.t_comfort, R.id.t_exercise, R.id.t_sunstroke, R.id.t_ultraviolet})
    List<TextView> textViewList;

    //    private TextView 0t_temp_1,1t_temp_2,2t_humidity,3t_rain,4t_speed,5t_visibility,6t_AQI,7t_from,8t_update,9t_date,10t_detail,
//            11t_comfort,12t_exercise,13t_sunstroke,14t_ultraviolet,15t_location;
    @OnClick(R.id.id_textview_d6)
    void shortHour(View view) {
//        mExplosionField.explode(view);
//        dialogPlusUtil.showMessageDialog("短时预报", R.string.shortHour);
        dialogPlusUtil.showMessageDialog("短时预报", R.string.shortHour);
    }

    @OnClick(R.id.id_textview_d7)
    void shortDay(View view) {
//        mExplosionField.explode(view);
        dialogPlusUtil.showMessageDialog("短期预报", R.string.shortDay);
//        dialogPlusUtil.showMessageDialog("短期预报", R.string.shortDay);
    }

    @OnClick(R.id.id_textview_d8)
    public void decition(View view) {
//        mExplosionField.explode(view);
        mTitles = getResources().getStringArray(R.array.deci);
        dialogPlusUtil.showdialog(Arrays.asList(mTitles), "决策报告",null);

//        new MaterialDialog.Builder(this.getContext())
//                .title("决策报告")
//                .items(mTitles)
//                .itemsCallback(new MaterialDialog.ListCallback() {
//                    @Override
//                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
//                        showMessageDialog(mTitles[which], R.string.shortDay);
//                    }
//                })
//                .positiveText(android.R.string.cancel)
//                .show();
    }

    private DialogPlusUtil dialogPlusUtil;

    @OnClick(R.id.id_textview_d9)
    public void warn() {
//        mExplosionField.explode(view);
        mTitles = getResources().getStringArray(R.array.deci);
        dialogPlusUtil.showdialog(Arrays.asList(mTitles), "预警信息",null);
//        new MaterialDialog.Builder(this.getContext())
//                .title("预警信息")
//                .items(mTitles)
//                .itemsCallback(new MaterialDialog.ListCallback() {
//                    @Override
//                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
//                        showMessageDialog(mTitles[which], R.string.shortDay);
//                    }
//                })
//                .positiveText(android.R.string.cancel)
//                .show();
    }

    @BindView(R.id.nestedview)
    NestedScrollView view;
    @BindView(R.id.bmapView)
    TextureMapView mMapView;
    BaiduMap mBaiduMap;
    public MyLocationListenner myListener = new MyLocationListenner();
    boolean isFirstLoc = true; // 是否首次定位
    private BitmapDescriptor bitmap;
    public static BDLocation location;
    @BindView(R.id.id_address)
    TextView address;
    public static String[] mDateAndHour;
    public static List<WeatherDaily.RowsBean> sevenDay;
    public static WeatherHour.RowsBean lastHour;
    private RequestQueue requestQueue;
    private WaitDialog mWaitDialog;
    private String url;
    private SwipeRefreshLayout mSwipeRefresh;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private FloatingActionButton fab;
    private WeaDataAdapter mWeaDataAdapter;

    private File file;


    private DataSimulate data;
    private View mView;
    private SwipeRefreshLayout mSwipeRefreshl;
    private RecyclerView mRecyclerview;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerViewAdapter mRecyclerviewadapter;
    private StaggeredViewAdapter mStaggeredadapter;
    private String flag;
    private Context context;
    private List<String> mData;
    private List<String> mId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, mView);
        data = new DataSimulate();

        mDateAndHour = null;
        dialogPlusUtil = new DialogPlusUtil(this.getContext());
        initView();
        mExplosionField = ExplosionField.attach2Window(this.getActivity());
        mDateAndHour = data.getDateAndHour(mDateAndHour);
        //        data.simulate(sevenDay,lastHour,mDateAndHour);
        //七天预报数据
        sevenDay = SplashActivity.sevenDay;
        //最近实况
        lastHour = SplashActivity.lastHour;
        setData();
        // 设置marker图标
        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.maker);
        // getOnLinedata();
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mSwipeRefreshl = (SwipeRefreshLayout) mView.findViewById(R.id.id_swiperefreshlayout);
        mRecyclerview = (RecyclerView) mView.findViewById(R.id.id_recyclerview);

        flag = (String) getArguments().get("flag");


        // 指示器旋转颜色
        mSwipeRefreshl.setColorSchemeResources(R.color.main, R.color.main_dark);
        mSwipeRefreshl.setOnRefreshListener(this);


        mBaiduMap = mMapView.getMap();
        if (Build.VERSION.SDK_INT >= 23) {
            showContacts(mMapView);
        } else {
            init();
        }
        ActivityManager activityManager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
        int memClass = activityManager.getMemoryClass();//64，以m为单位
//        Logger.i("Memory:::::::::::"+memClass);
    }


    public void showContacts(View v) {
        Log.i("weather", "检查权限");

        // Verify that all required contact permissions have been granted.
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // Contacts permissions have not been granted.
            Log.i("weather", "没有定位权限，请求权限");
            requestContactsPermissions(v);

        } else {

            // Contact permissions have been granted. Show the contacts fragment.
            Log.i("weather",
                    "已获得定位权限");
            init();
        }
    }

    private void requestContactsPermissions(View v) {
        // BEGIN_INCLUDE(contacts_permission_request)
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION)
                || ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                || ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                || ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.READ_PHONE_STATE)
                ) {

            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // For example, if the request has been denied previously.
            Log.i("weather",
                    "显示权限请求提示1");

            // Display a SnackBar with an explanation and a button to trigger the request.
            Snackbar.make(v, "请授予定位权限",
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction("确定", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ActivityCompat
                                    .requestPermissions(getActivity(),
                                            new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,
                                                    Manifest.permission.READ_PHONE_STATE}, 0);

                        }
                    })
                    .show();
        } else {
            // Display a SnackBar with an explanation and a button to trigger the request.
            Snackbar.make(v, "请授予定位权限",
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction("确定", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ActivityCompat
                                    .requestPermissions(getActivity(),
                                            new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,
                                                    Manifest.permission.READ_PHONE_STATE}, 0);
                        }
                    })
                    .show();
        }
        // END_INCLUDE(contacts_permission_request)
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 0) {
            if (PermissionUtil.verifyPermissions(grantResults)) {

                init();

            } else {

                init();
            }


        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    private void initView() {


        mSwipeRefresh = (SwipeRefreshLayout) mView.findViewById(R.id.id_swiperefreshlayout);

        //得到控件
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.id_recyclerview);
        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);

    }


    private void init() {


        Location.getLocation(getActivity(), mBaiduMap, myListener);


    }


    //    Observer<DayAndHour> observer = new Observer<DayAndHour>() {
//        @Override
//        public void onCompleted() {
//        }
//
//        @Override
//        public void onError(Throwable e) {
//           mSwipeRefresh.setRefreshing(false);
//      //     Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
////            SnackbarUtil.show(view, "网络连接失败", 0);
//
//
//        }
//
//        @Override
//        public void onNext(DayAndHour dh) {
//            Logger.wtf("数据获取成功");
//            mSwipeRefresh.setRefreshing(false);
//            sevenDay =dh.getDaylist();
//            lastHour=dh.getHourlist();
//            setData();
//            SnackbarUtil.show(view,"数据获取成功！", 0);
//        }
//    };
    Observer<WeatherHour> observerHour = new Observer<WeatherHour>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            mSwipeRefresh.setRefreshing(false);
            Logger.e("onError" + e);
            Toast.makeText(getActivity(), "服务器连接超时,刷新失败", Toast.LENGTH_SHORT).show();
            //     Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
//            SnackbarUtil.show(view, "网络连接失败", 0);


        }

        @Override
        public void onNext(WeatherHour dh) {

            mSwipeRefresh.setRefreshing(false);
            if (dh != null) {
                int count = dh.getRows().size();
                SplashActivity.hourlist = new ArrayList<>();
                if (count >= 24) {
                    for (int i = count - 24; i < count; i++) {
                        SplashActivity.hourlist.add(dh.getRows().get(i));
                    }


                } else {
                    SplashActivity.hourlist = dh.getRows();
                    Logger.i("Hour Total():" + SplashActivity.hourlist.size());

                }


                if (SplashActivity.hourlist.size() != 0) {
                    SplashActivity.lastHour = SplashActivity.hourlist.get(SplashActivity.hourlist.size() - 1);
                }

                //保存数据到本机
                ShareUtil shareUtil = new ShareUtil(getActivity());
                String hourlistS = GsonUtil.ObjectToString(SplashActivity.hourlist);
                String lastHourS = GsonUtil.ObjectToString(SplashActivity.lastHour);
                shareUtil.put("lastHour", hourlistS);
                shareUtil.put("lastHour", lastHourS);
                Logger.i("Hour Total():" + SplashActivity.hourlist.size());
                setData();

                Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT).show();
            }
        }
    };

    Observer<WeatherDaily> observerDaily = new Observer<WeatherDaily>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            mSwipeRefresh.setRefreshing(false);
            Logger.e("onError" + e);
            //     Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
//            SnackbarUtil.show(view, "网络连接失败", 0);


        }

        @Override
        public void onNext(WeatherDaily dh) {
            Logger.wtf("数据获取成功");
            mSwipeRefresh.setRefreshing(false);
            Logger.e("Total:::::::::::::::::::" + dh.getTotal());

            SnackbarUtil.show(view, "数据获取成功！", 0);
        }
    };
//    private void getOnlineData(String key) {
//        subscription = Network.getApi()
//                .search(key)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }


//
//    private void getOnLinedata() {
//        url="http://192.168.56.1:8080/V-Weather/servlet";
//
//        requestQueue = NoHttp.newRequestQueue();
//        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.POST);
//        request.add("userName", "yolanda");
//        request.add("userPass", 1);
//        request.add("userAge", 1.25);
//
//        request.setConnectTimeout(NoHttp.getDefaultConnectTimeout());
//        request.setReadTimeout(NoHttp.getDefaultReadTimeout());
//        request.setCancelSign(this);
//        requestQueue.add(0, request, onResponseListener);
//
//    }
//
//    private OnResponseListener<String> onResponseListener = new com.yolanda.nohttp.rest.OnResponseListener<String>() {
//        @SuppressWarnings("unused")
//        @Override
//        public void onSucceed(int what, Response<String> response) {
//            if (what == 0) {
//                int responseCode = response.getHeaders().getResponseCode();
//
//                if (responseCode == 200) {
//                    String ress = response.get();
//                    Logger.json(ress);
//                    String[] res=ress.split("%%");
//                    try {
//
//                        java.lang.reflect.Type type = new TypeToken<ArrayList<WeatherDailyModel>>() {
//                        }.getType();
//                        sevenDay = (ArrayList<WeatherDailyModel>) GsonUtil.StringToObject(res[0], type);
//
//                        java.lang.reflect.Type type1 = new TypeToken<ArrayList<WeatherhourModel>>() {
//                        }.getType();
//                        lastHour = (ArrayList<WeatherhourModel>) GsonUtil.StringToObject(res[1],type1);
//                        setData();
//                        SnackbarUtil.show(view,"数据获取成功！", 0);
//
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        }
//
//        @Override
//        public void onStart(int what) {
//            // 请求开始，这里可以显示一个dialog
//            if (mWaitDialog != null && !mWaitDialog.isShowing())
//                mWaitDialog.show();
//        }
//
//        @Override
//        public void onFinish(int what) {
//            // 请求结束，这里关闭dialog
//            if (mWaitDialog != null && mWaitDialog.isShowing())
//                mWaitDialog.dismiss();
//        }
//
//        @Override
//        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
//            // 请求失败
//            SnackbarUtil.show(view, "网络连接失败", 0);
//            Logger.e(exception);
//            simulate();
//            setData();
//        }
//    };


    @Override
    public void setData() {
        //        (String hour, String text_day, int code_day, String text_night, int code_night, int high, int low,
//        String lacation, String humidity, String speed, String visibility, String rain, String AQI, String from,
//                String update, String comfort, String exercise, String sunstroke, String ultraviolet)
//        sevenDay.add(new WeatherDailyModel(year+"-"+mounth+"-"+day,"多云",4,"阴",4,19,02,"晋安","55%","6.8m/s","35000m","0mm","32/优",
//                "晋安气象站",hour+"/"+min,"舒适","适宜","易中暑","强"));
        //    private TextView 0t_temp_1,1t_temp_2,2t_humidity,3t_rain,4t_speed,5t_visibility,6t_AQI,7t_from,8t_update,9t_date,10t_detail,
//            11t_comfort,12t_exercise,13t_sunstroke,14t_ultraviolet,15t_location;


        if (sevenDay == null || sevenDay.size() == 0) {

            ShareUtil shareUtil = new ShareUtil(getActivity());
            String daylistS = shareUtil.get("sevenDay", null);

            java.lang.reflect.Type type = new TypeToken<List<WeatherDaily.RowsBean>>() {
            }.getType();

            sevenDay = (List<WeatherDaily.RowsBean>) GsonUtil.StringToObject(daylistS, type);
        }
        if (lastHour == null) {
            ShareUtil shareUtil = new ShareUtil(getActivity());
            String lastHourS = shareUtil.get("lastHour", null);
            java.lang.reflect.Type type = new TypeToken<WeatherHour.RowsBean>() {
            }.getType();
            lastHour = (WeatherHour.RowsBean) GsonUtil.StringToObject(lastHourS, type);
        }

//

        fillDatatoRecyclerView(sevenDay);
//        fillDatatoRecyclerView(Compare());

        WeatherHour.RowsBean now = lastHour;
        if (now != null) {
            String[] temp = (now.getTemp() + "").split("\\.");
            Log.e("temp:::::::::::::::", now.getTemp() + "");
            textViewList.get(0).setText(temp[0]);
            textViewList.get(1).setText("." + temp[1] + " ℃");
            textViewList.get(2).setText(now.getHumidity() + "");
            textViewList.get(3).setText(now.getRainfallPerHour() + "");
            textViewList.get(4).setText(now.getWindSpeed() + "");
            String s = now.getStation();

            //更新时间
            textViewList.get(8).setText(ToDate.getDayByDate(now.getObserveTime()) + "日" + ToDate.getHourByDate(now.getObserveTime()) + ":00更新");

            String date =ToDate.getMonthByDate(now.getObserveTime())  + "月" + ToDate.getDayByDate(now.getObserveTime()) + "日";
//            预报时间
            textViewList.get(9).setText(date);

        }

        if (sevenDay.size() != 0) {
            WeatherDaily.RowsBean today = sevenDay.get(0);
            String s = today.getStation();
            if ("59132".equals(s)) {
                s = "泉州";
            }
            textViewList.get(7).setText(s + "气象站");
            textViewList.get(10).setText(s + "地区" + today.getWeatherPhen() + ",最高气温" + today.getTempVal1() + "℃,夜间至凌晨最低气温" + today.getTempVal2() + "℃.");
            textViewList.get(6).setText(s);
            MainActivity main = (MainActivity) getActivity();
            Resources resources = main.getResources();
//            int back = resources.getIdentifier("background_" + today.getWeatherPhenVal1(), "drawable", main.getPackageName());
            int back = resources.getIdentifier("background_3", "drawable", main.getPackageName());

//            if (back == 0) {
//                main.setbackground(R.drawable.background_1);
//            } else {
//                main.setbackground(back);
//            }
        }


        textViewList.get(5).setText("");

        textViewList.get(11).setText(null);
        textViewList.get(12).setText(null);
        textViewList.get(13).setText(null);
        textViewList.get(14).setText(null);
//        textViewList.get(15).setText(null);

    }


    private void fillDatatoRecyclerView(List<WeatherDaily.RowsBean> daily) {

        sevenDay = new ArrayList<WeatherDaily.RowsBean>();
        if (daily != null && daily.size() != 0) {
            Logger.i("daily::::::::"+daily.size());
            for (int i = 0; i < daily.size(); i++) {
                sevenDay.add(daily.get(i));
            }

            Collections.sort(daily, new Comparator<WeatherDaily.RowsBean>() {
                @Override
                public int compare(WeatherDaily.RowsBean lhs,
                                   WeatherDaily.RowsBean rhs) {
                    // 排序找到温度最低的，按照最低温度升序排列
                    return (int) (lhs.getTempVal2() - rhs.getTempVal2());
                }
            });

            int low = (int) daily.get(0).getTempVal2();

            Collections.sort(daily, new Comparator<WeatherDaily.RowsBean>() {
                @Override
                public int compare(WeatherDaily.RowsBean lhs,
                                   WeatherDaily.RowsBean rhs) {
                    // 排序找到温度最高的，按照最高温度降序排列
                    return (int) (rhs.getTempVal1() - lhs.getTempVal1());
                }
            });
            int high = (int) (daily.get(0).getTempVal1());

            mWeaDataAdapter = new WeaDataAdapter(this.getActivity(), sevenDay, low, high);
            mRecyclerView.setAdapter(mWeaDataAdapter);
        } else {
            warn();
        }


    }


    private List<WeatherDaily.RowsBean> Compare() {

        List<WeatherDaily.RowsBean> daily = new ArrayList<WeatherDaily.RowsBean>();
        List<Integer> daylist = ToDate.getSevenDayListByTimeStamp();
        if (sevenDay != null) {

            //移除多余天数
            for (int j = 0; j < daylist.size(); j++) {
                boolean has = false;
                for (int i = sevenDay.size() - 1; i >= 0; i--) {
                    int day = ToDate.getDayByTimeStamp(sevenDay.get(i).getEffDate());
                    if (!daylist.contains(day)) {
                        if (sevenDay.size() >= 7) {
                            sevenDay.remove(i);
                        }

                    }
                    if (day == daylist.get(j)) {
                        if (has) {
                            sevenDay.remove(i);

                        } else {
                            daily.add(j, sevenDay.get(i));
                            has = true;
                        }
                    }

//
                }
            }
            Logger.i("sevenDay+:" + sevenDay.size());

//            //排序
//            for(int j=0;j<daylist.size();j++) {
//                if (day == daylist.get(j)) {
//                    daily.add(j, sevenDay.get(i));
//                    Logger.i("j+:" + j);
//                    Logger.i("daily+:" + daily.size());
//                    break;
//                }
//            }
        }


        return daily;
    }


//
//
//    private void configRecyclerView() {
//
//        switch (flag) {
//            case Config.VERTICAL_LIST:
//                mLayoutManager =
//                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//                break;
//            case Config.HORIZONTAL_LIST:
//                mLayoutManager =
//                        new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//                break;
//            case Config.VERTICAL_GRID:
//                mLayoutManager =
//                        new GridLayoutManager(getActivity(), Config.SPAN_COUNT, GridLayoutManager.VERTICAL, false);
//                break;
//            case Config.HORIZONTAL_GRID:
//                mLayoutManager =
//                        new GridLayoutManager(getActivity(), Config.SPAN_COUNT, GridLayoutManager.HORIZONTAL, false);
//                break;
//            case Config.STAGGERED_GRID:
//                mLayoutManager =
//                        new StaggeredGridLayoutManager(Config.SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL);
//                break;
//        }
//
//        if (flag != Config.STAGGERED_GRID) {
//
//
//            mRecyclerviewadapter = new RecyclerViewAdapter(getActivity(),mData,mId);
//            mRecyclerviewadapter.setOnItemClickListener(this);
//            mRecyclerview.setAdapter(mRecyclerviewadapter);
//        } else {
//            mStaggeredadapter = new StaggeredViewAdapter(getActivity(),mData,mId);
//            mStaggeredadapter.setOnItemClickListener(this);
//            mRecyclerview.setAdapter(mStaggeredadapter);
//        }
//
//        mRecyclerview.setLayoutManager(mLayoutManager);
//
//    }


    //刷新数据
    @Override
    public void onRefresh() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                data.getDateAndHour(mDateAndHour);
                GetOnlineData.getOnlinehour(observerHour, SplashActivity.preDayTime,null);
                //getOnLinedata();
//                mSwipeRefresh.setRefreshing(false);

                //     Toast.makeText(BaseActivity.this, "数据刷新成功", Toast.LENGTH_SHORT).show();

            }
        }, 1000);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override public void run() {
//                mSwipeRefreshl.setRefreshing(false);
//
//
//                if (flag != Config.STAGGERED_GRID) {
//
//
//                    request(0,-1,"c");
//                } else {
//                    request(0,-1,"d");
//                }
//
//
//            }
//        }, 1000);
//        if(mRecyclerviewadapter!=null) {
//
//            mRecyclerviewadapter.notifyDataSetChanged();
//        }
    }

    @Override
    public void onItemClick(View view, int position) {

//
//        if (flag != Config.STAGGERED_GRID) {
//
//
//            request(3,Integer.parseInt(mId.get(position)),"c");
//        } else {
//            request(3,Integer.parseInt(mId.get(position)),"d");
//        }


    }
//
//    private void request(int doo,int id,String what) {
//        // 创建请求对象。
//        Request<String> request = NoHttp.createStringRequest(Config.URL, RequestMethod.POST);
//
//        // 添加请求参数。
//        request.add("do", doo);
//        request.add("what", what);
//        request.add("id", id);
//        CallServer.getRequestInstance().add(this, doo, request, httpListener, true, true);
//    }

    @Override
    public void onItemLongClick(View view, int position) {
        String[] option = getResources().getStringArray(R.array.what);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(R.string.choose);
        builder.setItems(option, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "clicked:" + which, Toast.LENGTH_LONG).show();
            }
        });
        builder.create();
        builder.show();

    }


    //
//    private HttpListener<String> httpListener = new HttpListener<String>() {
//
//        @Override
//        public void onSucceed(int what, Response<String> response) {
//            int responseCode = response.getHeaders().getResponseCode();// 服务器响应码
//            if (responseCode == 200) {
//                if (RequestMethod.HEAD == response.getRequestMethod())// 请求方法为HEAD时没有响应内容
//
//                SnackbarUtil.show(mView, context.getString(R.string.request_succeed), 0);
//                else{
//                    String res=response.get();
//                   Toast.makeText(context, res, Toast.LENGTH_SHORT).show();
//
//                    Log.i("Json",res);
//                    try {
//                        if(what==0) {
//                            JSONArray js = new JSONArray(res);
//                            mData = new ArrayList<>();
//                            mId = new ArrayList<>();
//                            for (int i = 0; i < js.length(); i++) {
//                                JSONObject jo = js.getJSONObject(i);
//                                String data = jo.toString();
//                                int id;
//                                if(jo.has("c_id")){
//                                id = jo.getInt("c_id");}
//                                else{
//                                   id = jo.getInt("d_id");
//                                }
//                                mData.add(data);
//                                mId.add(id + "");
//                                configRecyclerView();
//                            }
//
//                        }
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//
//                }
//            }
//        }
//
//        @Override
//        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
//
//            SnackbarUtil.show(mView, context.getString(R.string.request_failed) + exception.getMessage(), 0);
//        }
//    };
    OnGetGeoCoderResultListener geoListener = new OnGetGeoCoderResultListener() {

        @Override
        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult arg0) {
            //获取点击的坐标地址
            String saddress = arg0.getAddress();
            address.setText("您位于：" + saddress);
            GeoCode.closeGeo();
        }

        @Override
        public void onGetGeoCodeResult(GeoCodeResult arg0) {
        }
    };


    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location == null || mMapView == null) {
                return;
            }
            RecyclerFragment.this.location = location;
            if (isFirstLoc) {
                isFirstLoc = false;

                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());

                GeoCode.getGeo(ll, geoListener);

                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(18.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
            }
            // map view 销毁后不在处理新接收的位置

            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);

            if (mMapView != null) {
                if (mBaiduMap != null) {
                    Location.stop(mBaiduMap);
//                    mMapView.onDestroy();
                }


                mMapView = null;
            }
        }

        public void onReceivePoi(BDLocation poiLocation) {
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mMapView != null) {
            Location.stop(mBaiduMap);
            mMapView.onDestroy();
            mMapView = null;
        }
        bitmap.recycle();
//        RefWatcher refWatcher = Application.getRefWatcher(getActivity());
//        refWatcher.watch(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mMapView != null) {
            mMapView.onPause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mMapView != null) {
            mMapView.onResume();
        }
    }


}
