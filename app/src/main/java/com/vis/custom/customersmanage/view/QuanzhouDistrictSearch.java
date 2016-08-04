/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.vis.custom.customersmanage.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.vis.custom.customersmanage.R;

import java.util.ArrayList;
import java.util.List;

public class QuanzhouDistrictSearch extends Activity implements OnGetDistricSearchResultListener, Button.OnClickListener {

    private com.baidu.mapapi.search.district.DistrictSearch mDistrictSearch;
    private EditText mCity;
    private EditText mDistrict;
    private MapView mMapView;
    private final int color = 0xAA00FF00;
    private BaiduMap mBaiduMap;
    private Button mSearchButton;
    private UiSettings mUiSettings;
    private BitmapDescriptor bitmap;
    private String address= "";
    LatLng point;
    MarkerOptions options;
    List<OverlayOptions> list;
    OverlayOptions quanzhou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_search);
        mDistrictSearch = com.baidu.mapapi.search.district.DistrictSearch.newInstance();
        mDistrictSearch.setOnDistrictSearchListener(this);

        mMapView = (MapView) findViewById(R.id.map);
        mBaiduMap = mMapView.getMap();
        mCity = (EditText) findViewById(R.id.city);
        mDistrict = (EditText) findViewById(R.id.district);
        mDistrictSearch.searchDistrict(new DistrictSearchOption().cityName("泉州").districtName("洛江"));
     mDistrictSearch.searchDistrict(new DistrictSearchOption().cityName("泉州").districtName("泉州"));
        //设置是否显示比例尺控件
        mMapView.showScaleControl(true);
        //设置是否显示缩放控件
        mMapView.showZoomControls(true);
        // 删除百度地图LoGo
        mMapView.removeViewAt(1);
        mUiSettings = mBaiduMap.getUiSettings();
//        mUiSettings.setAllGesturesEnabled(false);
//        mUiSettings.setScrollGesturesEnabled(false);
        mSearchButton = (Button) findViewById(R.id.districSearch);
        mSearchButton.setOnClickListener(this);
        // 设置marker图标
        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.maker);
        setListener();

    }

    private void setListener() {

        mBaiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {

            @Override
            public boolean onMapPoiClick(MapPoi arg0) {
                // TODO Auto-generated method stub
                return false;
            }

            //此方法就是点击地图监听
            @Override
            public void onMapClick(LatLng latLng) {
                //获取经纬度
                double latitude = latLng.latitude;
                double longitude = latLng.longitude;
                mBaiduMap.clear();
                mBaiduMap.addOverlay(quanzhou);

                System.out.println("latitude=" + latitude + ",longitude=" + longitude);

                // 定义Maker坐标点
                point = new LatLng(latitude, longitude);
                // 构建MarkerOption，用于在地图上添加Marker
                options = new MarkerOptions().position(point)
                        .icon(bitmap);

                mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        displayInfoWindow(marker.getPosition());

                        return true;
                    }
                });

                //实例化一个地理编码查询对象
                GeoCoder geoCoder = GeoCoder.newInstance();
                //设置反地理编码位置坐标
                ReverseGeoCodeOption op = new ReverseGeoCodeOption();
                op.location(latLng);
                //发起反地理编码请求(经纬度->地址信息)
                geoCoder.reverseGeoCode(op);
                geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {

                    @Override
                    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult arg0) {
                        //获取点击的坐标地址
                        address = arg0.getAddress();
                        if(address.contains("泉州市")){
                            String dis=address.substring(6,8);
                            System.out.println("dis="+dis);
                            mDistrictSearch.searchDistrict(new DistrictSearchOption().cityName("泉州").districtName(dis));
                            // 在地图上添加Marker，并显示
                            mBaiduMap.addOverlay(options);

                            Toast.makeText(QuanzhouDistrictSearch.this, address, Toast.LENGTH_SHORT).show();
                        }
                        System.out.println("address="+address);
                    }

                    @Override
                    public void onGetGeoCodeResult(GeoCodeResult arg0) {
                    }
                });
            }
        });
    }

    @Override
    public void onGetDistrictResult(DistrictResult districtResult) {
//        mBaiduMap.clear();
        if (districtResult == null) {
            return;
        }
        if (districtResult.error == SearchResult.ERRORNO.NO_ERROR) {
            List<LatLng> polyLines = districtResult.getPolylines();


            if (polyLines == null) {
                return;
            }

            OverlayOptions ooPolyline11 = new PolylineOptions().width(5)
                        .points(polyLines).dottedLine(true).color(color);
                mBaiduMap.addOverlay(ooPolyline11);


            OverlayOptions ooPolygon = new PolygonOptions().points(polyLines)
                    .stroke(new Stroke(2, 0xAA00FF88)).fillColor(0x55FFFF00);
            mBaiduMap.addOverlay(ooPolygon);
            System.out.println("CityName="+districtResult.getCityName());

            if(districtResult.getCityName().startsWith("泉州")){
                quanzhou=ooPolygon;
            }

            list=new ArrayList<>();
            list.add(ooPolyline11);list.add(ooPolygon);
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (LatLng latLng : polyLines) {
                builder.include(latLng);
            }
            mBaiduMap.setMapStatus(MapStatusUpdateFactory
                    .newLatLngBounds(builder.build()));

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onDestroy() {
        mDistrictSearch.destroy();
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onClick(View v) {
        String city = "";
        String district = "";
        if (mCity.getText() != null && !"".equals(mCity.getText()) ) {
            city = mCity.getText().toString();
        }
        if (mDistrict.getText() != null && !"".equals(mDistrict.getText()) ) {
            district = mDistrict.getText().toString();
        }
        mDistrictSearch.searchDistrict(new DistrictSearchOption().cityName(city).districtName(district));
    }

    /**
     * 显示弹出窗口覆盖物
     */
    private void displayInfoWindow(final LatLng latLng) {
        // 创建infowindow展示的view
        Button btn = new Button(getApplicationContext());
        btn.setBackgroundResource(R.drawable.ico_1);

        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory
                .fromView(btn);
        // infowindow点击事件
        InfoWindow.OnInfoWindowClickListener infoWindowClickListener = new InfoWindow.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick() {

//                reverseGeoCode(latLng);
                //隐藏InfoWindow
                mBaiduMap.hideInfoWindow();
            }
        };
        // 创建infowindow
        InfoWindow infoWindow = new InfoWindow(bitmapDescriptor, latLng, -47,
                infoWindowClickListener);

        // 显示InfoWindow
        mBaiduMap.showInfoWindow(infoWindow);
    }

}
