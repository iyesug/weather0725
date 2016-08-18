package com.vis.custom.customersmanage.util;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;

/**
 * Created by GaoYu on 2016/8/18.
 */
public class GeoCode {


    public  static void getGeo(LatLng latLng,OnGetGeoCoderResultListener onGetGeoCodeResultListener){

        //实例化一个地理编码查询对象
        GeoCoder geoCoder = GeoCoder.newInstance();
        //设置反地理编码位置坐标
        ReverseGeoCodeOption op = new ReverseGeoCodeOption();
        op.location(latLng);
        //发起反地理编码请求(经纬度->地址信息)
        geoCoder.reverseGeoCode(op);
        geoCoder.setOnGetGeoCodeResultListener(onGetGeoCodeResultListener);


    }

}
