package com.vis.weather;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
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
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!this.isTaskRoot()) {
            finish();
            return;
        }
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
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

        String loginCount = shareUtil.get("loginCount", "0");
        if (!"0".equals(loginCount)) {
            int i = Integer.parseInt(loginCount) - 1;
            if (i <= 0) {
                i = 0;
            }
            shareUtil.put("loginCount", i + "");
            phone.setVisibility(View.GONE);
            password.setVisibility(View.GONE);
            login.setVisibility(View.GONE);
            start();
        }

    }

    /**
     * 登陆
     *
     * @param view
     */
    public void login(View view) {
        String phoneString = phone.getText().toString().trim();
        String passwordString = password.getText().toString().trim();
        if (!"13600804142".equals(phoneString)) {
            Toast.makeText(SplashActivity.this, "电话号码错误", Toast.LENGTH_SHORT).show();
        } else if (!"123456".equals(passwordString)) {
            Toast.makeText(SplashActivity.this, "密码错误", Toast.LENGTH_SHORT).show();

        } else {
            //保存数据到本机
            ShareUtil shareUtil = new ShareUtil(SplashActivity.this);
            String sevenDayToString = GsonUtil.ObjectToString(sevenDay);
            shareUtil.put("phone", "13600804142");
            shareUtil.put("loginCount", "5");
            Toast.makeText(SplashActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();

            start();
        }
    }


    private void start() {
        // 启动主应用
        finish();
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);

        startActivity(intent);
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