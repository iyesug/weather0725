package com.vis.weather.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import com.baidu.mapapi.map.*;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerDragListener;
import com.baidu.mapapi.map.InfoWindow.OnInfoWindowClickListener;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.orhanobut.logger.Logger;
import com.vis.weather.R;
import com.vis.weather.model.StationInfo;
import com.vis.weather.model.StationList;
import com.vis.weather.model.WeatherHour;
import com.vis.weather.presenter.GetOnlineData;
import com.vis.weather.util.ShareUtil;
import com.vis.weather.util.base.GsonUtil;
import com.vis.weather.util.base.ToDate;
import com.vis.weather.view.base.BaseActivity;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;


public class OceanActivity extends BaseActivity {

    /**
     * MapView 是地图主控件
     */
    private TextureMapView mMapView;
    private BaiduMap mBaiduMap;
    private Marker mMarkerA;
    private Marker mMarkerB;
    private Marker mMarkerC;
    private Marker mMarkerD;
    private InfoWindow mInfoWindow;
    private SeekBar alphaSeekBar = null;
    private CheckBox animationBox = null;
    private List<StationList.RowsBean> stationList;
    List<WeatherHour.RowsBean> oceanWeatherList=new ArrayList<>();
    List<Marker> makerList;
    // 初始化全局 bitmap 信息，不用时及时 recycle
    BitmapDescriptor bdA = BitmapDescriptorFactory
            .fromResource(R.drawable.maker);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocean);
        TextView title = setToolbar();
        title.setText("海洋气象");

//          查询泉州海洋气象列表
        GetOnlineData.getStationList(observerList, "5", null);
//        oceanWeatherList=DataSimulate.getOceanList();

        mMapView = (TextureMapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(14.0f);
        mBaiduMap.setMapStatus(msu);
//        initOverlay();
        mBaiduMap.setOnMarkerClickListener(new OnMarkerClickListener() {
            public boolean onMarkerClick(final Marker marker) {
                Button button = new Button(getApplicationContext());
                button.setBackgroundResource(R.drawable.button_down);
                OnInfoWindowClickListener listener = null;
                if (marker == mMarkerA || marker == mMarkerD) {
                    button.setText("更改位置");
                    listener = new OnInfoWindowClickListener() {
                        public void onInfoWindowClick() {
                            LatLng ll = marker.getPosition();
                            LatLng llNew = new LatLng(ll.latitude + 0.005,
                                    ll.longitude + 0.005);
                            marker.setPosition(llNew);
                            mBaiduMap.hideInfoWindow();
                        }
                    };
                    LatLng ll = marker.getPosition();

                    mInfoWindow = new InfoWindow(BitmapDescriptorFactory.fromView(button), ll, -47, listener);
                    mBaiduMap.showInfoWindow(mInfoWindow);
                } else if (marker == mMarkerB) {
                    button.setText("更改图标");
                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            marker.setIcon(bdA);
                            mBaiduMap.hideInfoWindow();
                        }
                    });
                    LatLng ll = marker.getPosition();
                    mInfoWindow = new InfoWindow(button, ll, -47);
                    mBaiduMap.showInfoWindow(mInfoWindow);
                } else if (marker == mMarkerC) {
                    button.setText("删除");
                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            marker.remove();
                            mBaiduMap.hideInfoWindow();
                        }
                    });
                    LatLng ll = marker.getPosition();
                    mInfoWindow = new InfoWindow(button, ll, -47);
                    mBaiduMap.showInfoWindow(mInfoWindow);
                } else {
                    for (int i = 0; i < makerList.size(); i++) {
                        if (marker == makerList.get(i)) {

                            button.setTextColor(getResources().getColor(R.color.cardview_dark_background));
                            button.setText(stationList.get(i).getCityName());
                            button.setOnClickListener(new OnClickListener() {
                                public void onClick(View v) {
//                                    marker.remove();
                                    mBaiduMap.hideInfoWindow();
                                }
                            });
                            LatLng ll = marker.getPosition();
//                            mInfoWindow = new InfoWindow(button, ll, -47);
                            View view = LayoutInflater.from(OceanActivity.this).inflate(R.layout.dialog_info, null);
                            TextView name = (TextView) view.findViewById(R.id.name);
                            TextView date = (TextView) view.findViewById(R.id.date);
                            TextView weather = (TextView) view.findViewById(R.id.weather);
                            TextView temp = (TextView) view.findViewById(R.id.temp);
                            TextView wave = (TextView) view.findViewById(R.id.wave);
                            TextView wind = (TextView) view.findViewById(R.id.wind);
                            name.setText(stationList.get(i).getCityName());
                            String dateString=oceanWeatherList.get(i).getObserveTime();
                            date.setText( ToDate.getMonthByDate(dateString)+ "月"+ToDate.getDayByDate(dateString)+ "月");
                            weather.setText("气压："+oceanWeatherList.get(i).getStationPress() + "");
                            wave.setText("水压："+oceanWeatherList.get(i).getWaterPress() + "");
                            wind.setText(oceanWeatherList.get(i).getWindSpeed() + "m/s");
                            temp.setText("，水温：" + oceanWeatherList.get(i).getTemp() + "度");
                            view.setOnClickListener(new OnClickListener() {
                                public void onClick(View v) {

                                    mBaiduMap.hideInfoWindow();
                                }
                            });
                            mInfoWindow = new InfoWindow(view, ll, -147);
                            mBaiduMap.showInfoWindow(mInfoWindow);
                            LatLng ll2 = new LatLng(Double.valueOf(oceanWeatherList.get(i).getLatitude()), Double.valueOf(oceanWeatherList.get(i).getLongitude()));
                            MapStatus ms = new MapStatus.Builder().target(ll2).build();
                            mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(ms));


                        }
                    }

                }
                return true;
            }
        });
    }

    public void initOverlay() {
        // add marker overlay
//        LatLng llA = new LatLng(25.083484, 119.049968);
//        LatLng llB = new LatLng(25.047931, 119.016371);
//        LatLng llC = new LatLng(24.632833, 118.688032);
//        LatLng llD =new LatLng(24.453684, 118.379769);

// 将GPS设备采集的原始GPS坐标转换成百度坐标
        CoordinateConverter converter  = new CoordinateConverter();
        converter.from(CoordinateConverter.CoordType.COMMON);


        MarkerOptions ooA;
        makerList = new ArrayList<>();
        for (int i = 0; i < oceanWeatherList.size(); i++) {
            LatLng ll =new LatLng(Double.valueOf(oceanWeatherList.get(i).getLatitude()), Double.valueOf(oceanWeatherList.get(i).getLongitude()));
            converter.coord(ll);
            LatLng llA = converter.convert();
            ooA = new MarkerOptions().position(llA).icon(bdA)
                    .zIndex(9).draggable(true);
//            if (animationBox.isChecked()) {
//                // 掉下动画
//                ooA.animateType(MarkerAnimateType.drop);
//            }

            makerList.add((Marker) (mBaiduMap.addOverlay(ooA)));
        }


        // add ground overlay
        LatLng southwest = new LatLng(39.92235, 116.380338);
        LatLng northeast = new LatLng(39.947246, 116.414977);
        LatLngBounds bounds = new LatLngBounds.Builder().include(northeast)
                .include(southwest).build();

        OverlayOptions ooGround = new GroundOverlayOptions()
                .positionFromBounds(bounds).image(bdA).transparency(0.8f);
        mBaiduMap.addOverlay(ooGround);


        LatLngBounds bound = new LatLngBounds.Builder().include(new LatLng(Double.valueOf(oceanWeatherList.get(0).getLatitude()), Double.valueOf(oceanWeatherList.get(0).getLongitude())))
                .include(new LatLng(Double.valueOf(oceanWeatherList.get(oceanWeatherList.size() - 1).getLatitude()), Double.valueOf(oceanWeatherList.get(oceanWeatherList.size() - 1).getLongitude()))).build();

        mBaiduMap.setMapStatus(MapStatusUpdateFactory
                .newLatLngBounds(bound));
        MapStatusUpdate u = MapStatusUpdateFactory.zoomTo(11.0f);
        mBaiduMap.animateMapStatus(u);
        mBaiduMap.setOnMarkerDragListener(new OnMarkerDragListener() {
            public void onMarkerDrag(Marker marker) {
            }

            public void onMarkerDragEnd(Marker marker) {
                Toast.makeText(
                        OceanActivity.this,
                        "拖拽结束，新位置：" + marker.getPosition().latitude + ", "
                                + marker.getPosition().longitude,
                        Toast.LENGTH_LONG).show();
            }

            public void onMarkerDragStart(Marker marker) {
            }
        });
    }

    /**
     * 清除所有Overlay
     *
     * @param view
     */
    public void clearOverlay(View view) {
        mBaiduMap.clear();
        mMarkerA = null;
        mMarkerB = null;
        mMarkerC = null;
        mMarkerD = null;
    }

    /**
     * 重新添加Overlay
     *
     * @param view
     */
    public void resetOverlay(View view) {
        clearOverlay(null);
        initOverlay();
    }

    private class SeekBarListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            // TODO Auto-generated method stub
            float alpha = ((float) seekBar.getProgress()) / 10;
            if (mMarkerA != null) {
                mMarkerA.setAlpha(alpha);
            }
            if (mMarkerB != null) {
                mMarkerB.setAlpha(alpha);
            }
            if (mMarkerC != null) {
                mMarkerC.setAlpha(alpha);
            }
            if (mMarkerD != null) {
                mMarkerD.setAlpha(alpha);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
        }

    }

    @Override
    protected void onPause() {
        // MapView的生命周期与Activity同步，当activity挂起时需调用MapView.onPause()
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        // MapView的生命周期与Activity同步，当activity恢复时需调用MapView.onResume()
        mMapView.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        // MapView的生命周期与Activity同步，当activity销毁时需调用MapView.destroy()
        mMapView.onDestroy();
        super.onDestroy();
        // 回收 bitmap 资源
        bdA.recycle();

    }


/*
* 获取海洋站点列表
* */

    Observer<StationList> observerList = new Observer<StationList>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            Logger.e("onError" + e);
            Toast.makeText(OceanActivity.this, "服务器连接超时", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(StationList lp) {
            Logger.i(lp.toString());
            if (lp != null && lp.getRows() != null && lp.getRows().size() != 0) {
                stationList = lp.getRows();
                for (int i = 0; i < lp.getRows().size(); i++) {
                    Logger.i(lp.getRows().get(i).getStationCode());
                    GetOnlineData.getOnlinehour(observerhour, null, lp.getRows().get(i).getStationCode());
                }


                //保存数据到本机
                ShareUtil shareUtil = new ShareUtil(OceanActivity.this);
                String stationListS = GsonUtil.ObjectToString(stationList);
                shareUtil.put("stationListS", stationListS);

            } else {
                Toast.makeText(OceanActivity.this, "没有查询到数据", Toast.LENGTH_SHORT).show();
            }
        }
    };

    /*
    * 获取海洋站点实况
    *
    */

    Observer<WeatherHour> observerhour = new Observer<WeatherHour>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            Logger.e("onError" + e);
            Toast.makeText(OceanActivity.this, "服务器连接超时", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(WeatherHour lp) {

            if (lp != null && lp.getRows() != null && lp.getRows().size() != 0) {
                oceanWeatherList.add(lp.getRows().get(0));
                if(stationList.size()==oceanWeatherList.size()){
                    initOverlay();
                }
//                //保存数据到本机
//                ShareUtil shareUtil = new ShareUtil(OceanActivity.this);
//                String stationListS = GsonUtil.ObjectToString(stationList);
//                shareUtil.put("stationListS", stationListS);

            } else {
                Toast.makeText(OceanActivity.this, "没有查询到数据", Toast.LENGTH_SHORT).show();
            }
        }
    };

    /*
* 获取海洋站点信息
* */

    Observer<StationInfo> observerInfo = new Observer<StationInfo>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            Logger.e("onError" + e);
            Toast.makeText(OceanActivity.this, "服务器连接超时", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(StationInfo lp) {
            Logger.i(lp.toString());
            if (lp != null && lp.getRows() != null && lp.getRows().size() != 0) {
                oceanWeatherList = new ArrayList<>();
                for (int i = 0; i < oceanWeatherList.size(); i++) {


                }

                //保存数据到本机
                ShareUtil shareUtil = new ShareUtil(OceanActivity.this);
                String stationListS = GsonUtil.ObjectToString(stationList);
                shareUtil.put("stationListS", stationListS);

            } else {
                Toast.makeText(OceanActivity.this, "没有查询到数据", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
