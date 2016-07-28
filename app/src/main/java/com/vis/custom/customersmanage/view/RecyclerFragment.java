package com.vis.custom.customersmanage.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

import com.orhanobut.logger.Logger;
import com.vis.custom.customersmanage.R;
import com.vis.custom.customersmanage.model.DayAndHour;
import com.vis.custom.customersmanage.model.WeatherDailyModel;
import com.vis.custom.customersmanage.model.WeatherhourModel;
import com.vis.custom.customersmanage.presenter.RecyclerViewAdapter;
import com.vis.custom.customersmanage.presenter.StaggeredViewAdapter;
import com.vis.custom.customersmanage.presenter.WeaDataAdapter;
import com.vis.custom.customersmanage.util.DataSimulate;
import com.vis.custom.customersmanage.util.Network;
import com.vis.custom.customersmanage.util.base.SnackbarUtil;
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
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class RecyclerFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, RecyclerViewAdapter.OnItemClickListener,
        StaggeredViewAdapter.OnItemClickListener{



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
    public static List<WeatherDailyModel> daylist;
    public static List<WeatherhourModel> hourlist;
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
        daylist=null;hourlist=null;
        daylist =new ArrayList<WeatherDailyModel>() ;
        hourlist=new ArrayList<WeatherhourModel>();
        initView();

        mDateAndHour=data.getDateAndHour(mDateAndHour);
        data.simulate(daylist,hourlist,mDateAndHour);
        setData();
        getOnlineData(null);
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




    Observer<DayAndHour> observer = new Observer<DayAndHour>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
           mSwipeRefresh.setRefreshing(false);
      //     Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
//            SnackbarUtil.show(view, "网络连接失败", 0);


        }

        @Override
        public void onNext(DayAndHour dh) {
            Logger.wtf("数据获取成功");
            mSwipeRefresh.setRefreshing(false);
            daylist =dh.getDaylist();
            hourlist=dh.getHourlist();
            setData();
            SnackbarUtil.show(view,"数据获取成功！", 0);
        }
    };


    private void getOnlineData(String key) {
        subscription = Network.getApi()
                .search(key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
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
//                        daylist = (ArrayList<WeatherDailyModel>) GsonUtil.StringToObject(res[0], type);
//
//                        java.lang.reflect.Type type1 = new TypeToken<ArrayList<WeatherhourModel>>() {
//                        }.getType();
//                        hourlist = (ArrayList<WeatherhourModel>) GsonUtil.StringToObject(res[1],type1);
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




    private void setData() {
        //        (String hour, String text_day, int code_day, String text_night, int code_night, int high, int low,
//        String lacation, String humidity, String speed, String visibility, String rain, String AQI, String from,
//                String update, String comfort, String exercise, String sunstroke, String ultraviolet)
//        daylist.add(new WeatherDailyModel(year+"-"+mounth+"-"+day,"多云",4,"阴",4,19,02,"晋安","55%","6.8m/s","35000m","0mm","32/优",
//                "晋安气象站",hour+"/"+min,"舒适","适宜","易中暑","强"));
        //    private TextView 0t_temp_1,1t_temp_2,2t_humidity,3t_rain,4t_speed,5t_visibility,6t_AQI,7t_from,8t_update,9t_date,10t_detail,
//            11t_comfort,12t_exercise,13t_sunstroke,14t_ultraviolet,15t_location;
        fillDatatoRecyclerView(daylist);
        WeatherhourModel now=hourlist.get(0);
        WeatherDailyModel today= daylist.get(0);
        String[]temp=now.getTemp().split("\\.");
        Log.e("temp",now.getTemp());
        textViewList.get(0).setText(temp[0]);
        textViewList.get(1).setText("."+temp[1]+" ℃");
        textViewList.get(2).setText(today.getHumidity());
        textViewList.get(3).setText(today.getRain());
        textViewList.get(4).setText(today.getSpeed());
        textViewList.get(5).setText(today.getVisibility());
        textViewList.get(6).setText(today.getAQI());
        textViewList.get(7).setText(today.getFrom());
        textViewList.get(8).setText(today.getUpdate()+"更新");

        String[] date=today.getDate().split("-");
        textViewList.get(9).setText(date[1]+"月"+date[2]+"日");
        textViewList.get(10).setText(today.getLacation()+"白天"+today.getText_day()+",最高气温"+today.getHigh()+"℃,夜间至凌晨"+today.getText_night()+
                ",最低气温"+today.getLow()+"℃.");
        textViewList.get(11).setText(today.getComfort());
        textViewList.get(12).setText(today.getExercise());
        textViewList.get(13).setText(today.getSunstroke());
        textViewList.get(14).setText(today.getUltraviolet());
        textViewList.get(15).setText(today.getLacation());




    }




    private void fillDatatoRecyclerView(List<WeatherDailyModel> daily) {

        daylist =new ArrayList<WeatherDailyModel>() ;
        for(int i=0;i<daily.size();i++){
            daylist.add(daily.get(i));
        }

        Collections.sort(daily, new Comparator<WeatherDailyModel>() {
            @Override
            public int compare(WeatherDailyModel lhs,
                               WeatherDailyModel rhs) {
                // 排序找到温度最低的，按照最低温度升序排列
                return lhs.getLow() - rhs.getLow();
            }
        });

        int low = daily.get(0).getLow();

        Collections.sort(daily, new Comparator<WeatherDailyModel>() {
            @Override
            public int compare(WeatherDailyModel lhs,
                               WeatherDailyModel rhs) {
                // 排序找到温度最高的，按照最高温度降序排列
                return rhs.getHigh() - lhs.getHigh();
            }
        });
        int high = daily.get(0).getHigh();

        mWeaDataAdapter = new WeaDataAdapter(this.getActivity(), daylist, low, high);
        mRecyclerView.setAdapter(mWeaDataAdapter);
    }













//
//
//    private void configRecyclerView() {
//
//        switch (flag) {
//            case config.VERTICAL_LIST:
//                mLayoutManager =
//                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//                break;
//            case config.HORIZONTAL_LIST:
//                mLayoutManager =
//                        new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//                break;
//            case config.VERTICAL_GRID:
//                mLayoutManager =
//                        new GridLayoutManager(getActivity(), config.SPAN_COUNT, GridLayoutManager.VERTICAL, false);
//                break;
//            case config.HORIZONTAL_GRID:
//                mLayoutManager =
//                        new GridLayoutManager(getActivity(), config.SPAN_COUNT, GridLayoutManager.HORIZONTAL, false);
//                break;
//            case config.STAGGERED_GRID:
//                mLayoutManager =
//                        new StaggeredGridLayoutManager(config.SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL);
//                break;
//        }
//
//        if (flag != config.STAGGERED_GRID) {
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
                getOnlineData(null);
                //getOnLinedata();
                mSwipeRefresh.setRefreshing(false);

                //     Toast.makeText(BaseActivity.this, "数据刷新成功", Toast.LENGTH_SHORT).show();

            }
        }, 1000);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override public void run() {
//                mSwipeRefreshl.setRefreshing(false);
//
//
//                if (flag != config.STAGGERED_GRID) {
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
//        if (flag != config.STAGGERED_GRID) {
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
//        Request<String> request = NoHttp.createStringRequest(config.URL, RequestMethod.POST);
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
