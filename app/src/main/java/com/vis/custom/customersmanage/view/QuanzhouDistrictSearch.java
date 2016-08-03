/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.vis.custom.customersmanage.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
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
    List<LatLng> polyLines;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_search);
        mDistrictSearch = com.baidu.mapapi.search.district.DistrictSearch.newInstance();
        mDistrictSearch.setOnDistrictSearchListener(this);
        polyLines = new ArrayList<>();
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

        mSearchButton = (Button) findViewById(R.id.districSearch);
        mSearchButton.setOnClickListener(this);
    }

    @Override
    public void onGetDistrictResult(DistrictResult districtResult) {
//        mBaiduMap.clear();
        if (districtResult == null) {
            return;
        }
        if (districtResult.error == SearchResult.ERRORNO.NO_ERROR) {
            List<LatLng> polyLine = districtResult.getPolylines();

            for (LatLng latLng : polyLine) {
                polyLines.add(latLng);

            }
            if (polyLines == null) {
                return;
            }

                OverlayOptions ooPolyline11 = new PolylineOptions().width(5)
                        .points(polyLines).dottedLine(true).color(color);
                mBaiduMap.addOverlay(ooPolyline11);


            OverlayOptions ooPolygon = new PolygonOptions().points(polyLines)
                    .stroke(new Stroke(2, 0xAA00FF88)).fillColor(0x55FFFF00);
            mBaiduMap.addOverlay(ooPolygon);
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
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mDistrictSearch.destroy();
        super.onDestroy();
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
}
