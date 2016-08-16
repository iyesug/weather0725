package com.vis.custom.customersmanage;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.vis.custom.customersmanage.model.WeatherDaily;
import com.vis.custom.customersmanage.model.WeatherHour;
import com.vis.custom.customersmanage.presenter.GetOnlineData;
import com.vis.custom.customersmanage.util.ShareUtil;
import com.vis.custom.customersmanage.util.base.Network;
import com.vis.custom.customersmanage.util.base.ToDate;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;


public class SplashActivity extends Activity {
	static int version;
	public static String time;
	public static String preDayTime;
	public static List<WeatherDaily.RowsBean> SevenDay;
	public static WeatherHour.RowsBean lasthour;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		if(!Network.isConnected(this)){
			Toast.makeText(this, "无网络连接", Toast.LENGTH_SHORT)
			.show();
		}

		time=ToDate.timeStamp2Date(ToDate.timeStamp(),null);
		preDayTime=ToDate.timeStamp2DatePreDay(ToDate.timeStamp(),null);

//		Logger.e("time:::::::::::::"+ToDate.date2TimeStamp("35940","HH:mm"));
		version=getVersionCode();

		ShareUtil shareUtil=new ShareUtil(this);
		shareUtil.put("version",version+"");

		GetOnlineData.getOnlineData(observerHour,observerDaily,preDayTime);

	        Thread splashTread = new Thread() {
	            @Override
	            public void run() {
	                try {
	                    
	                        sleep(3000);
	                      
	                } catch(InterruptedException e) {
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

			Logger.e("onError"+e);
			GetOnlineData.getOnlinehour(observerHour,preDayTime);
			//     Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
//            SnackbarUtil.show(view, "网络连接失败", 0);
			// 启动主应用
			finish();
			Intent intent = new Intent(SplashActivity.this, MainActivity.class);

			startActivity(intent);

		}

		@Override
		public void onNext(WeatherHour dh) {
			if(dh.getTotal()>=1){
				List<WeatherHour.RowsBean> list=dh.getRows();
				lasthour=dh.getRows().get(list.size()-1);
			}

			Logger.i("Hour Total():"+dh.getTotal());

			// 启动主应用
			finish();
			Intent intent = new Intent(SplashActivity.this, MainActivity.class);

			startActivity(intent);
			//SnackbarUtil.show(SplashActivity.this,"数据获取成功！", 0);
		}
	};

	Observer<WeatherDaily> observerDaily = new Observer<WeatherDaily>() {
		@Override
		public void onCompleted() {
		}

		@Override
		public void onError(Throwable e) {

			Logger.e("onError"+e);
			//     Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
//            SnackbarUtil.show(view, "网络连接失败", 0);


		}

		@Override
		public void onNext(WeatherDaily dh) {
			if(dh.getTotal()>=7) {
				int count = dh.getTotal();
				SevenDay = new ArrayList<>();
				for (int i = count - 7; i < count; i++) {
					SevenDay.add(dh.getRows().get(i));
				}
				Logger.i("SevenDay.size():"+SevenDay.size());
			}


			//SnackbarUtil.show(view,"数据获取成功！", 0);
		}
	};
	

}