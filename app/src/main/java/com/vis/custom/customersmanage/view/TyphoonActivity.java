package com.vis.custom.customersmanage.view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerDragListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.InfoWindow.OnInfoWindowClickListener;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MarkerOptions.MarkerAnimateType;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.utils.DistanceUtil;
import com.google.gson.reflect.TypeToken;
import com.vis.custom.customersmanage.R;
import com.vis.custom.customersmanage.util.Location;
import com.vis.custom.customersmanage.util.ShareUtil;
import com.vis.custom.customersmanage.util.base.GsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示覆盖物的用法
 */
public class TyphoonActivity extends Activity {

    /**
     * MapView 是地图主控件
     */
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private Marker mMarkerA;
    private Marker mMarkerB;
    private Marker mMarkerC;
    private Marker mMarkerD;
    private InfoWindow mInfoWindow;
    private boolean isRun=true;
    private SeekBar alphaSeekBar = null;
    private CheckBox animationBox = null;
    public MyLocationListenner myListener = new MyLocationListenner();
    private LatLng latLng;
    private  boolean isMove=false;
    Polyline   mPolyline;
    MarkerOptions ooA;
    Thread path;
    List<LatLng> line;
    Handler handler=new Handler();
    // 初始化全局 bitmap 信息，不用时及时 recycle
    BitmapDescriptor bd = BitmapDescriptorFactory
            .fromResource(R.drawable.maker);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typhoon);
        alphaSeekBar = (SeekBar) findViewById(R.id.alphaBar);
        alphaSeekBar.setOnSeekBarChangeListener(new SeekBarListener());
        animationBox = (CheckBox) findViewById(R.id.animation);
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();

        initOverlay();
        setListener();
        Location.getLocation(this, mBaiduMap,myListener);


        ShareUtil shareUtil=new ShareUtil(TyphoonActivity.this);
        String s=shareUtil.get("line","");
        java.lang.reflect.Type type = new TypeToken<ArrayList<LatLng>>() {
        }.getType();
        System.out.print(s);
        line = (ArrayList<LatLng>) GsonUtil.StringToObject(s, type);


        OverlayOptions ooPolyline11 = new PolylineOptions().width(5)
                .points(line).dottedLine(true).color(Color.BLUE);
        mBaiduMap.addOverlay(ooPolyline11);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng latLng : line) {
            builder.include(latLng);
        }
        mBaiduMap.setMapStatus(MapStatusUpdateFactory
                .newLatLngBounds(builder.build()));
        MapStatusUpdate u = MapStatusUpdateFactory.zoomTo(10.0f);
        mBaiduMap.animateMapStatus(u);
    }

    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // map view 销毁后不在处理新接收的位置
            if (location == null || mMapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);

//            if (isFirstLoc) {
//                isFirstLoc = false;
            latLng= new LatLng(location.getLatitude(),
                        location.getLongitude());
//                MapStatus.Builder builder = new MapStatus.Builder();
//                builder.target(ll).zoom(18.0f);
//                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
//            }
        }

    }

    public void setListener() {
        mBaiduMap.setOnMarkerClickListener(new OnMarkerClickListener() {
            public boolean onMarkerClick(final Marker marker) {
                 final Button button = new Button(getApplicationContext());
                button.setBackgroundResource(R.drawable.popp);
                OnInfoWindowClickListener listener = null;
                if (marker == mMarkerA || marker == mMarkerD) {
                    button.setText("测量台风距离");

                    listener = new OnInfoWindowClickListener() {
                        public void onInfoWindowClick() {
                            List<LatLng> points = new ArrayList<LatLng>();
                            points.add(mMarkerA.getPosition());
                            points.add(latLng);
                            if(mPolyline!=null){
                                mPolyline.remove();
                            }

                            OverlayOptions ooPolyline = new PolylineOptions().width(5)
                                    .color(0xaa00ff00).points(points);
                             mPolyline = (Polyline) mBaiduMap.addOverlay(ooPolyline);
                            mPolyline.setDottedLine(true);
                            double distance= DistanceUtil.getDistance(mMarkerA.getPosition(),latLng);
                            int dis=(int)(distance/1000);
                            Toast.makeText(TyphoonActivity.this, "台风距离您："+dis+"公里", Toast.LENGTH_SHORT).show();
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
                            marker.setIcon(bd);
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
                }
                return true;
            }
        });
    }
    public void initOverlay() {
        // add marker overlay25.27191707528107,longitude=118.5676855820092
        LatLng llA = new LatLng(25.27191707528107, 118.5676855820092);

        List<LatLng> line= new ArrayList<>();
       line.add(llA);
        List<Marker> markers= new ArrayList<>();

        for(int i=0;i<line.size();i++){

            ooA = new MarkerOptions().position(line.get(i)).icon(bd)
                    .zIndex(i).draggable(true);
            if (animationBox.isChecked()) {
                // 掉下动画
                ooA.animateType(MarkerAnimateType.drop);
            }


                    mMarkerA = (Marker) (mBaiduMap.addOverlay(ooA));



            markers.add(mMarkerA);
        }

//
//
//        MarkerOptions ooB = new MarkerOptions().position(llB).icon(bd)
//                .zIndex(5);
//        if (animationBox.isChecked()) {
//            // 掉下动画
//            ooB.animateType(MarkerAnimateType.drop);
//        }
//        mMarkerB = (Marker) (mBaiduMap.addOverlay(ooB));
//        MarkerOptions ooC = new MarkerOptions().position(llC).icon(bd)
//                .perspective(true).anchor(0.9f, 0.9f).rotate(30).zIndex(1117);
//        if (animationBox.isChecked()) {
//            // 生长动画
//            ooC.animateType(MarkerAnimateType.grow);
//        }
//        mMarkerC = (Marker) (mBaiduMap.addOverlay(ooC));
//        ArrayList<BitmapDescriptor> giflist = new ArrayList<BitmapDescriptor>();
//        giflist.add(bd);
//        giflist.add(bd);
//        giflist.add(bd);
//        MarkerOptions ooD = new MarkerOptions().position(llD).icons(giflist)
//                .zIndex(0).period(10);
//        if (animationBox.isChecked()) {
//            // 生长动画
//            ooD.animateType(MarkerAnimateType.drop);
//        }
//        mMarkerD = (Marker) (mBaiduMap.addOverlay(ooD));


        // add ground overlay
//        LatLng southwest = new LatLng(30.82235, 116.380338);
//        LatLng northeast = new LatLng(39.947246, 116.914977);
//        LatLngBounds bounds = new LatLngBounds.Builder().include(northeast)
//                .include(southwest).build();
//
//        OverlayOptions ooGround = new GroundOverlayOptions()
//                .positionFromBounds(bounds).image(bdGround).transparency(0.8f);
//        mBaiduMap.addOverlay(ooGround);
//
//        MapStatusUpdate u = MapStatusUpdateFactory
//                         .newLatLng(bounds.getCenter());
//        mBaiduMap.setMapStatus(u);

        mBaiduMap.setOnMarkerDragListener(new OnMarkerDragListener() {
            public void onMarkerDrag(Marker marker) {
            }

            public void onMarkerDragEnd(Marker marker) {
                Toast.makeText(
                        TyphoonActivity.this,
                        "拖拽结束，新位置：" + marker.getPosition().latitude + ", "
                                + marker.getPosition().longitude,
                        Toast.LENGTH_LONG).show();
            }

            public void onMarkerDragStart(Marker marker) {
            }
        });
    }

    /**
     * 台风移动动画
     *
     * @param view
     */
    public void move(View view) {
        if(!isMove) {
            isMove=true;
            path = new Thread(new Runnable() {
                public void run() {
                    mBaiduMap.hideInfoWindow();

                    for (int i = 0; i < line.size(); i++) {
                        if (isRun) {
                            mMarkerA.setPosition(line.get(i));
                            try {
                                path.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    isMove=false;
                }
            });
            path.start();
        }
    }

    /**
     * 重新添加Overlay
     *
     * @param view
     */
    public void distance(View view) {
//        clearOverlay(null);
//        initOverlay();
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
        isRun=false;
    }

    @Override
    protected void onResume() {
        // MapView的生命周期与Activity同步，当activity恢复时需调用MapView.onResume()
        mMapView.onResume();
        super.onResume();
        isRun=true;
    }

    @Override
    protected void onDestroy() {
        // MapView的生命周期与Activity同步，当activity销毁时需调用MapView.destroy()
        Location.stop(mBaiduMap);
        mMapView.onDestroy();
        super.onDestroy();
        // 回收 bitmap 资源
        isRun=false;
        bd.recycle();

    }

}
