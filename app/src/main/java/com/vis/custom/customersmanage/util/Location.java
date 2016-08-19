package com.vis.custom.customersmanage.util;

import android.content.Context;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;

/**
 * Created by GaoYu on 2016/8/11.
 */
public class Location {
    // 定位相关
    static LocationClient   mLocClient;
    public static void getLocation(Context context, BaiduMap mBaiduMap,BDLocationListener myListener){
        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        // 定位初始化
        if(mLocClient==null) {
            mLocClient = new LocationClient(context);

        }
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        mLocClient.setLocOption(option);
        mLocClient.start();
        mLocClient.requestLocation();
    }

    public static void stop(BaiduMap mBaiduMap){
    // 退出时销毁定位
        if(mLocClient!=null){
    mLocClient.stop();
    mLocClient=null;
        }
    // 关闭定位图层
    mBaiduMap.setMyLocationEnabled(false);
}
}