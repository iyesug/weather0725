package com.vis.weather;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.Toast;
import com.orhanobut.logger.Logger;
import com.vis.weather.model.WeatherDaily;
import com.vis.weather.model.WeatherHour;
import com.vis.weather.presenter.GetOnlineData;
import com.vis.weather.util.ShareUtil;
import com.vis.weather.util.base.GsonUtil;
import com.vis.weather.util.base.Network;
import com.vis.weather.util.base.ToDate;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;


public class SplashActivity extends Activity {
    static int version;
    public static String time;
    public static String preDayTime;
    public static String pre2DayTime;
    public static List<WeatherDaily.RowsBean> sevenDay;
    public static WeatherHour.RowsBean lastHour;
    public static List<WeatherHour.RowsBean> hourlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!this.isTaskRoot()) {
            finish();
            return;
        }
        setContentView(R.layout.activity_splash);

        if (!Network.isConnected(this.getApplicationContext())) {
            Toast.makeText(this, "无网络连接", Toast.LENGTH_SHORT)
                    .show();
        }

        time = ToDate.timeStamp2Date2(ToDate.timeStamp(), null);
        preDayTime = ToDate.timeStamp2DatePreDay(ToDate.timeStamp(), null);
        pre2DayTime = ToDate.timeStamp2DatePreDay(ToDate.timeStamp(), null);

        version = getVersionCode();

        ShareUtil shareUtil = new ShareUtil(this);
        shareUtil.put("version", version + "");

        GetOnlineData.getOnlineData(observerHour, observerDaily, null, null);

        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {

                    sleep(3000);

                } catch (InterruptedException e) {
                    // do nothing
                } finally {


                }
            }
        };
        splashTread.start();


    }


    /**
     * 获取本地app的版本号
     *
     * @return
     */
    private int getVersionCode() {
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    getPackageName(), 0);// 获取包的信息

            int versionCode = packageInfo.versionCode;
            return versionCode;
        } catch (NameNotFoundException e) {
            // 没有找到包名的时候会走此异常
            e.printStackTrace();
        }

        return -1;
    }

    Observer<WeatherHour> observerHour = new Observer<WeatherHour>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

            Logger.e("onError" + e);
            Toast.makeText(SplashActivity.this, "服务器连接超时", Toast.LENGTH_SHORT).show();

            //     Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
//            SnackbarUtil.show(view, "网络连接失败", 0);

//			ShareUtil shareUtil=new ShareUtil(SplashActivity.this);
//			String hourlistS=shareUtil.get("lastHour",null);
//			String lastHourS=shareUtil.get("lastHour",null);
//			java.lang.reflect.Type type = new TypeToken<List<WeatherHour.RowsBean>>() {
//			}.getType();
//			java.lang.reflect.Type typel = new TypeToken<WeatherHour.RowsBean>() {
//			}.getType();
//			lastHour = (List<WeatherHour.RowsBean>) GsonUtil.StringToObject(hourlistS, type);
//			lastHour=(WeatherHour.RowsBean) GsonUtil.StringToObject(lastHourS, typel);
//			Logger.i("Hour Total():"+lastHour.size());
            // 启动主应用
            finish();
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);

            startActivity(intent);
        }

        @Override
        public void onNext(WeatherHour dh) {

            if (dh != null) {
                int count = dh.getRows().size();
                hourlist = new ArrayList<>();
                if (count >= 54) {
                    for (int i = count - 24; i < count; i++) {
                        hourlist.add(dh.getRows().get(i));
                    }

                } else {
                    hourlist = dh.getRows();
                }


                if (hourlist != null && hourlist.size() != 0) {
                    lastHour = hourlist.get(hourlist.size() - 1);
                }
                //保存数据到本机
                ShareUtil shareUtil = new ShareUtil(SplashActivity.this);
                String hourlistS = GsonUtil.ObjectToString(hourlist);
                String lastHourS = GsonUtil.ObjectToString(lastHour);
                shareUtil.put("hourlist", hourlistS);
                shareUtil.put("lastHour", lastHourS);
                Logger.i("Hour Total():" + hourlist.size());
                // 启动主应用
                finish();
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);

                startActivity(intent);


                //SnackbarUtil.show(SplashActivity.this,"数据获取成功！", 0);
            }
        }
    };
    int connect;
    Observer<WeatherDaily> observerDaily = new Observer<WeatherDaily>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

            Logger.e("onError" + e);
            //     Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
//            SnackbarUtil.show(view, "网络连接失败", 0);


        }

        @Override
        public void onNext(WeatherDaily dh) {

            connect++;
            Logger.i("Day Total():" + dh.getTotal());
            if (dh.getRows().size() >= 7) {
                int count = dh.getRows().size();
                sevenDay = dh.getRows();
//
//				sevenDay = new ArrayList<>();
//
//				for (int i = 0; i < count; i++) {
//					sevenDay.add(9,dh.getRows().get(i));
//				}
                //保存数据到本机
                ShareUtil shareUtil = new ShareUtil(SplashActivity.this);
                String sevenDayToString = GsonUtil.ObjectToString(sevenDay);
                shareUtil.put("sevenDay", sevenDayToString);


            } else if (connect < 5) {


                GetOnlineData.getOnline7Day(observerDaily, null, null);

            }

            //SnackbarUtil.show(view,"数据获取成功！", 0);
        }
    };


}