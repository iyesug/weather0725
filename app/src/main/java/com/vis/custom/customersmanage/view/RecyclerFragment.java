package com.vis.custom.customersmanage.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
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

import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;
import com.vis.custom.customersmanage.MainActivity;
import com.vis.custom.customersmanage.R;
import com.vis.custom.customersmanage.SplashActivity;
import com.vis.custom.customersmanage.model.WeatherDaily;
import com.vis.custom.customersmanage.model.WeatherHour;
import com.vis.custom.customersmanage.presenter.GetOnlineData;
import com.vis.custom.customersmanage.presenter.RecyclerViewAdapter;
import com.vis.custom.customersmanage.presenter.StaggeredViewAdapter;
import com.vis.custom.customersmanage.presenter.WeaDataAdapter;
import com.vis.custom.customersmanage.util.DataSimulate;
import com.vis.custom.customersmanage.util.ShareUtil;
import com.vis.custom.customersmanage.util.base.GsonUtil;
import com.vis.custom.customersmanage.util.base.SnackbarUtil;
import com.vis.custom.customersmanage.util.base.ToDate;
import com.vis.custom.customersmanage.view.Interfa.Mainview;
import com.vis.custom.customersmanage.view.base.BaseFragment;
import com.vis.custom.customersmanage.view.base.WaitDialog;
import com.yolanda.nohttp.rest.RequestQueue;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import rx.Observer;


public class RecyclerFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, RecyclerViewAdapter.OnItemClickListener,
        StaggeredViewAdapter.OnItemClickListener,Mainview{



    private ImageView mImageView_back;
    private CollapsingToolbarLayout mToolbar_title;
    //    @BindView(R.id.toolbar_layout_title)
//    CollapsingToolbarLayout collapsing;
//    @BindView(R.id.imageview_back)
//    ImageView back;

    @BindViews({R.id.t_temp_1,R.id.t_temp_2,R.id.t_humidity,R.id.t_rain,R.id.t_speed,R.id.t_visibility, R.id.t_AQI,R.id.t_from,
            R.id.t_update,R.id.t_date,R.id.t_detail,R.id.t_comfort,R.id.t_exercise,R.id.t_sunstroke,R.id.t_ultraviolet,R.id.t_location})
    List<TextView> textViewList;
    //    private TextView 0t_temp_1,1t_temp_2,2t_humidity,3t_rain,4t_speed,5t_visibility,6t_AQI,7t_from,8t_update,9t_date,10t_detail,
//            11t_comfort,12t_exercise,13t_sunstroke,14t_ultraviolet,15t_location;
    @BindView(R.id.nestedview)
    NestedScrollView view;
    public static String [] mDateAndHour;
    public static List<WeatherDaily.RowsBean> sevenDay;
    public static WeatherHour.RowsBean lastHour;
    private RequestQueue requestQueue;
    private WaitDialog mWaitDialog;
    private String url;
    private  SwipeRefreshLayout  mSwipeRefresh;
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
        ButterKnife.bind(this,mView);
        data=new DataSimulate();
        mDateAndHour=null;


        initView();

        mDateAndHour=data.getDateAndHour(mDateAndHour);
//        data.simulate(sevenDay,lastHour,mDateAndHour);
        setData();

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

    }





    private void initView() {


        mSwipeRefresh= (SwipeRefreshLayout) mView.findViewById(R.id.id_swiperefreshlayout);

        //得到控件
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.id_recyclerview);
        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);

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
        Logger.e("onError"+e);
        Toast.makeText(getActivity(), "服务器连接超时,刷新失败", Toast.LENGTH_SHORT).show();
        //     Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
//            SnackbarUtil.show(view, "网络连接失败", 0);


    }

    @Override
    public void onNext(WeatherHour dh) {

        mSwipeRefresh.setRefreshing(false);

        int count = dh.getRows().size();
        SplashActivity.hourlist = new ArrayList<>();
        if(count>=24) {
            for (int i = count - 24; i < count; i++) {
                SplashActivity.hourlist.add(dh.getRows().get(i));
            }



        }else
        {
            SplashActivity.hourlist=dh.getRows();
            Logger.i("Hour Total():"+SplashActivity.hourlist.size());

        }



        SplashActivity. lastHour=SplashActivity.hourlist.get(SplashActivity.hourlist.size()-1);
        //保存数据到本机
        ShareUtil shareUtil=new ShareUtil(getActivity());
        String hourlistS = GsonUtil.ObjectToString(SplashActivity.hourlist);
        String lastHourS = GsonUtil.ObjectToString(SplashActivity.lastHour);
        shareUtil.put("lastHour",hourlistS);
        shareUtil.put("lastHour",lastHourS);
        Logger.i("Hour Total():"+SplashActivity.hourlist.size());
        setData();

        Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT).show();
    }
};

    Observer<WeatherDaily> observerDaily = new Observer<WeatherDaily>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            mSwipeRefresh.setRefreshing(false);
            Logger.e("onError"+e);
            //     Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
//            SnackbarUtil.show(view, "网络连接失败", 0);


        }

        @Override
        public void onNext(WeatherDaily dh) {
            Logger.wtf("数据获取成功");
            mSwipeRefresh.setRefreshing(false);
            Logger.e("Total:::::::::::::::::::"+dh.getTotal());

            SnackbarUtil.show(view,"数据获取成功！", 0);
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


        //七天预报数据
        sevenDay =SplashActivity.sevenDay ;
       //最近实况
        lastHour =SplashActivity.lastHour;

        if(sevenDay ==null|| sevenDay.size()==0){

			ShareUtil shareUtil=new ShareUtil(getActivity());
			String daylistS=shareUtil.get("sevenDay",null);

			java.lang.reflect.Type type = new TypeToken<List<WeatherDaily.RowsBean>>() {
			}.getType();

            sevenDay = (List<WeatherDaily.RowsBean>) GsonUtil.StringToObject(daylistS, type);
        }
        if(lastHour==null){
            ShareUtil shareUtil=new ShareUtil(getActivity());
            String lastHourS=shareUtil.get("lastHour",null);
            java.lang.reflect.Type type = new TypeToken<WeatherHour.RowsBean>() {
			}.getType();
            lastHour=(WeatherHour.RowsBean) GsonUtil.StringToObject(lastHourS, type);
        }

        fillDatatoRecyclerView(sevenDay);
        WeatherHour.RowsBean now= lastHour;
        if(now!=null){
            String[]temp=(now.getTemp()+"").split("\\.");
            Log.e("temp:::::::::::::::",now.getTemp()+"");
            textViewList.get(0).setText(temp[0]);
            textViewList.get(1).setText("."+temp[1]+" ℃");
            textViewList.get(2).setText(now.getHumidity()+"");
            textViewList.get(3).setText(now.getRainfallPerHour()+"");
            textViewList.get(4).setText(now.getWindSpeed()+"");
            String s=now.getStation();


            textViewList.get(8).setText(ToDate.getHourAndMinuteByTimeStamp(now.getObserveTime())+"更新");

            String date=ToDate.getMonthByTimeStamp(now.getObserveTime())+"月"+ToDate.getDayByTimeStamp(now.getObserveTime())+"日";
            textViewList.get(9).setText(date);

        }

        if(sevenDay.size()!=0){
            WeatherDaily.RowsBean today= sevenDay.get(0);
            String s=today.getStation();
            if("59132".equals(s)){
                s="泉州";
            }
            textViewList.get(7).setText(s+"气象站");
            textViewList.get(10).setText(s+"地区"+today.getWeatherPhen()+",最高气温"+today.getTempVal1()+"℃,夜间至凌晨最低气温"+today.getTempVal2()+"℃.");

            MainActivity main =(MainActivity)getActivity();
            Resources resources = main.getResources();
            int back = resources.getIdentifier("background_" + today.getWeatherPhenVal1(), "drawable", main.getPackageName());
            if(back==0){
                main.setbackground(R.drawable.background_1);
            }else {
                main.setbackground(back);
            }
        }


        textViewList.get(5).setText("");
        textViewList.get(6).setText("优");
        textViewList.get(11).setText(null);
        textViewList.get(12).setText(null);
        textViewList.get(13).setText(null);
        textViewList.get(14).setText(null);
        textViewList.get(15).setText(null);

    }




    private void fillDatatoRecyclerView(List<WeatherDaily.RowsBean> daily) {

        sevenDay =new ArrayList<WeatherDaily.RowsBean>() ;
        if(daily!=null){
            for(int i=0;i<daily.size();i++){
                sevenDay.add(daily.get(i));
            }

            Collections.sort(daily, new Comparator<WeatherDaily.RowsBean>() {
                @Override
                public int compare(WeatherDaily.RowsBean lhs,
                                   WeatherDaily.RowsBean rhs) {
                    // 排序找到温度最低的，按照最低温度升序排列
                    return (int)(lhs.getTempVal2() - rhs.getTempVal2());
                }
            });

            int low =(int) daily.get(0).getTempVal2();

            Collections.sort(daily, new Comparator<WeatherDaily.RowsBean>() {
                @Override
                public int compare(WeatherDaily.RowsBean lhs,
                                   WeatherDaily.RowsBean rhs) {
                    // 排序找到温度最高的，按照最高温度降序排列
                    return (int)(rhs.getTempVal1() - lhs.getTempVal1());
                }
            });
            int high =(int)( daily.get(0).getTempVal1());

            mWeaDataAdapter = new WeaDataAdapter(this.getActivity(), sevenDay, low, high);
            mRecyclerView.setAdapter(mWeaDataAdapter);
        }


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
                GetOnlineData.getOnlinehour(observerHour, SplashActivity.time);
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
       String[] option=getResources().getStringArray(R.array.what);
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


}
