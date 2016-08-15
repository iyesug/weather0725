package com.vis.custom.customersmanage;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.Toast;

import com.vis.custom.customersmanage.util.ShareUtil;
import com.vis.custom.customersmanage.util.base.Network;


public class SplashActivity extends Activity {
	static int version;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		if(!Network.isConnected(this)){
			Toast.makeText(this, "无网络连接", Toast.LENGTH_SHORT)
			.show();
		}
		
		version=getVersionCode();

		ShareUtil shareUtil=new ShareUtil(this);
		shareUtil.put("version",version+"");

	        Thread splashTread = new Thread() {
	            @Override
	            public void run() {
	                try {
	                    
	                        sleep(3000);
	                      
	                } catch(InterruptedException e) {
	                    // do nothing
	                } finally {
	                    finish();
	                    // 启动主应用
	            		
	            		Intent intent = new Intent(SplashActivity.this, MainActivity.class);

	            		startActivity(intent);
	                   
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

	
	

}