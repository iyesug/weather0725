package com.vis.weather.view;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.mapapi.map.*;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerDragListener;
import com.baidu.mapapi.map.InfoWindow.OnInfoWindowClickListener;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.baidu.mapapi.utils.DistanceUtil;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.orhanobut.logger.Logger;
import com.vis.weather.R;
import com.vis.weather.model.TyphoonList;
import com.vis.weather.model.TyphoonPath;
import com.vis.weather.presenter.GetOnlineData;
import com.vis.weather.util.DialogPlusUtil;
import com.vis.weather.util.Location;
import com.vis.weather.util.ShareUtil;
import com.vis.weather.util.base.GsonUtil;
import com.vis.weather.view.base.BaseActivity;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示覆盖物的用法
 */
public class TyphoonActivity extends BaseActivity {

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
    private boolean isRun=true;
    private SeekBar alphaSeekBar = null;
    private CheckBox animationBox = null;
    public MyLocationListenner myListener = new MyLocationListenner();
    private LatLng latLng;
    private  boolean isMove=false;
    @BindView(R.id.id_textview_d6)
    TextView tv_typhoon;
    Polyline   mPolyline;
    MarkerOptions ooA;
    Thread path;
    List<LatLng> line;
    List<LatLng> lineNext;
    List<Integer> colors;
    Handler handler=new Handler();
    // 初始化全局 bitmap 信息，不用时及时 recycle
    BitmapDescriptor bd = BitmapDescriptorFactory
            .fromResource(R.drawable.typhoon_1 );
    BitmapDescriptor bd1 = BitmapDescriptorFactory
            .fromResource(R.drawable.typhoon_2);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typhoon);
        ButterKnife.bind(this);
        GetOnlineData.getTyphoonList(observerList, "2016");
        GetOnlineData.getTyphoonPath(observerPath, "201501");
        TextView title=setToolbar();
        title.setText("台风路径");
//        alphaSeekBar = (SeekBar) findViewById(R.id.alphaBar);
//        alphaSeekBar.setOnSeekBarChangeListener(new SeekBarListener());
//        animationBox = (CheckBox) findViewById(R.id.animation);
        mMapView = (TextureMapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();

//        initOverlay();
        setListener();
        Location.getLocation(this, mBaiduMap,myListener);





    }

    private void setPath() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng latLng : line) {
            builder.include(latLng);
        }
        LatLng ll = new LatLng(RecyclerFragment.location.getLatitude(),
                RecyclerFragment.location.getLongitude());
//            builder.include(ll);
        mBaiduMap.setMapStatus(MapStatusUpdateFactory
                .newLatLngBounds(builder.build()));
//            MapStatusUpdate u = MapStatusUpdateFactory.zoomTo(5.5f);
//            mBaiduMap.animateMapStatus(u);
//        GetOnlineData.getPic(observerList, "rad", dateStart, dateEnd, station);
        if(line==null){
            ShareUtil shareUtil=new ShareUtil(TyphoonActivity.this);
            String s=shareUtil.get("line","");
            java.lang.reflect.Type type = new TypeToken<ArrayList<LatLng>>() {
            }.getType();
            System.out.print(s);
            line = (ArrayList<LatLng>) GsonUtil.StringToObject(s, type);

        }

        if(line!=null){

            mBaiduMap.clear();
            initOverlay();
            OverlayOptions ooPolyline11 = new PolylineOptions().width(10)
                    .points(line).color(Color.BLUE);
//            OverlayOptions ooPolylinenext = new PolylineOptions().width(5).dottedLine(true)
//                    .points(lineNext).color(Color.BLUE);

            mBaiduMap.addOverlay(ooPolyline11);


            // 添加圆点
            for(int i=0;i<line.size();i++){
                LatLng llCircle =  line.get(i);
                OverlayOptions ooCircle = new CircleOptions().fillColor(colors.get(i))
                        .center(llCircle).stroke(new Stroke(1, 0xAAffad04))
                        .radius(20000);
                mBaiduMap.addOverlay(ooCircle);


            }


//            mBaiduMap.addOverlay(ooPolylinenext);

        }
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
                button.setBackgroundResource(R.drawable.button_down);

                OnInfoWindowClickListener listener = null;
                if (marker == mMarkerA || marker == mMarkerD) {
                    button.setText("测量台风距离");
                    button.setTextColor(getResources().getColor(R.color.cardview_dark_background));

                    listener = new OnInfoWindowClickListener() {
                        public void onInfoWindowClick() {
                            distance();
                            mBaiduMap.hideInfoWindow();





                        }
                    };
                    LatLng ll = marker.getPosition();
                    mInfoWindow = new InfoWindow(BitmapDescriptorFactory.fromView(button), ll, -47, listener);
                        //使用自定义信息窗口
//                    View view = LayoutInflater.from(TyphoonActivity.this).inflate(R.layout.item_weather, null);
//                    mInfoWindow = new InfoWindow(view, ll, -47);
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

    private void distance() {
        List<LatLng> points = new ArrayList<LatLng>();
        points.add(mMarkerA.getPosition());
        points.add(latLng);
        if(mPolyline!=null){
            mPolyline.remove();
        }

        OverlayOptions ooPolyline = new PolylineOptions().dottedLine(false).width(5)
                .color(0xaa00ff00).points(points);
        mPolyline = (Polyline) mBaiduMap.addOverlay(ooPolyline);
        mPolyline.setDottedLine(true);
        double distance= DistanceUtil.getDistance(mMarkerA.getPosition(),latLng);
        int dis=(int)(distance/1000);
        Toast.makeText(TyphoonActivity.this, "台风距离您："+dis+"公里", Toast.LENGTH_SHORT).show();
    }

    public void initOverlay() {
        // add marker overlay25.27191707528107,longitude=118.5676855820092
//        LatLng ll = new LatLng(26.05,119.17);
        LatLng ll=line.get(0);
// 将GPS设备采集的原始GPS坐标转换成百度坐标
        CoordinateConverter converter  = new CoordinateConverter();
        converter.from(CoordinateConverter.CoordType.GPS);
        converter.coord(ll);
        LatLng llA = converter.convert();



        List<LatLng> line= new ArrayList<>();
       line.add(llA);
        List<Marker> markers= new ArrayList<>();

        for(int i=0;i<line.size();i++){
        ArrayList<BitmapDescriptor> giflist = new ArrayList<BitmapDescriptor>();
        giflist.add(bd);
        giflist.add(bd1);
        MarkerOptions ooA = new MarkerOptions().anchor(0.5f,0.5f).position(line.get(i)).icons(giflist)
                .zIndex(i).period(2);
//            ooA = new MarkerOptions().position(line.get(i)).icon(bd)
//                    .zIndex(i).draggable(true);
//            if (animationBox.isChecked()) {
//                // 掉下动画
//                ooA.animateType(MarkerAnimateType.drop);
//            }


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
    int count=0;
    /**
     * 台风移动动画
     *
     * @param view
     */
    public void move(View view) {
        if(!isMove) {
            isRun=true;
            isMove=true;

            path = new Thread(new Runnable() {
                public void run() {
                    mBaiduMap.hideInfoWindow();
                    if(line!=null){
                    for (int i = count; i < line.size(); i++) {
                        if (isRun) {
                            mMarkerA.setPosition(line.get(i));
                            MapStatus ms = new MapStatus.Builder().target(line.get(i)).build();
                            mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(ms));
                            try {
                                path.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            count = i;
                            break;
                        }
                    }
                    isMove = false;
                        count=0;
                }
                }
            });
            path.start();
        }else{
            Logger.i("stop");
            isRun=false;
            isMove=false;

        }
    }

//    /**
//     * 重新添加Overlay
//     *
//     * @param view
//     */
//    public void distance(View view) {
////        clearOverlay(null);
////        initOverlay();
//    }
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
    List<String> mTitles;

    //台风下拉菜单
    public void dropdown(View v) {

          DialogPlusUtil dialogPlusUtil=new DialogPlusUtil(this);
        dialogPlusUtil.setGravity(Gravity.TOP);
//        mTitles=getResources().getStringArray(R.array.typhoon);
        if(mTitles!=null&&mTitles.size()!=0){
            dialogPlusUtil.showdialog(mTitles,"选择台风",itemClickListener);

        }

//       mTitles=getResources().getStringArray(R.array.deci);
//        new MaterialDialog.Builder(this)
//                .title("选择台风")
//                .items(mTitles)
//                .itemsCallback(new MaterialDialog.ListCallback() {
//                    @Override
//                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
//                        textView.setText(mTitles[which]);
//                    }
//                })
//                .positiveText(android.R.string.cancel)
//                .show();
    }
/*
* 列表选择监听
* */
OnItemClickListener itemClickListener = new OnItemClickListener() {
    @Override
    public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        String clickedAppName = textView.getText().toString();
        String id=mTitles.get(position).substring(1,7);
        tv_typhoon.setText(mTitles.get(position));
        GetOnlineData.getTyphoonPath(observerPath, id);
        dialog.dismiss();
    }
};
    //台风测距
    public void distance(View v) {
       distance();
    }


    boolean checked = false;

    public void setMapMode(View view) {


                if (checked) {
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                    checked=true;

                }else{
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                    checked=false;
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
        bd1.recycle();
    }


/*
* 获取台风列表
* */
    Observer<TyphoonList> observerList = new Observer<TyphoonList>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

            Logger.e("onError" + e);
            Toast.makeText(TyphoonActivity.this, "服务器连接超时", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onNext(TyphoonList lp) {
            Logger.i(lp.toString());
            if(lp!=null&&lp.getRows()!=null&&lp.getRows().size()!=0){
                mTitles=new ArrayList<>();
                for(int i=0;i<lp.getRows().size();i++){
                    String s="第"+lp.getRows().get(i).getTyphoonNo()+"号台风："+lp.getRows().get(i).getTyphoonName();
                    Logger.i(s);
                    mTitles.add(s);
                }


                //保存数据到本机
                ShareUtil shareUtil = new ShareUtil(TyphoonActivity.this);
                String mTitlesS = GsonUtil.ObjectToString(mTitles);
                shareUtil.put("mTitles", mTitlesS);

            }else{
                Toast.makeText(TyphoonActivity.this,"没有查询台风列表", Toast.LENGTH_SHORT).show();

            }




        }
    };


/*
* 获取台风路径
* */

    Observer<TyphoonPath> observerPath = new Observer<TyphoonPath>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

            Logger.e("onError" + e);
            Toast.makeText(TyphoonActivity.this, "服务器连接超时", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onNext(TyphoonPath lp) {
            Logger.i(lp.toString());
            if(lp!=null&&lp.getRows()!=null&&lp.getRows().size()!=0){
                tv_typhoon.setText(lp.getRows().get(0).getTyphoonName());
                line = new ArrayList<>();
                colors=new ArrayList<>();
                for(int i=0;i<lp.getRows().size();i++){
                    LatLng latLng=new LatLng(Double.valueOf(lp.getRows().get(i).getLat()),Double.valueOf(lp.getRows().get(i).getLon()));
                    line.add(latLng);
                    String level=lp.getRows().get(i).getTyphoonLevel();
                    if("TD".equals(level)){
                        colors.add(0xff02ff02);}
                    else if("TS".equals(level)){
                        colors.add(0xff0264ff);}
                    else if("STS".equals(level)){
                        colors.add(0xfffffb04);}
                    else if("TY".equals(level)){
                        colors.add(0xFFffad04);}
                    else if("STY".equals(level)){
                        colors.add(0xFFf170f9);}
                    else if("SuperTY".equals(level)){
                        colors.add(0xFFff0202);}
                }
////                预测路径
//                TyphoonPath.RowsBean last=lp.getRows().get(lp.getRows().size()-1);
//                LatLng latlng6=new LatLng(Double.valueOf(last.getLat6()),Double.valueOf(last.getLon6()));
//                LatLng latlng12=new LatLng(Double.valueOf(last.getLat12()),Double.valueOf(last.getLon12()));
//                LatLng latlng18=new LatLng(Double.valueOf(last.getLat18()),Double.valueOf(last.getLon18()));
//                LatLng latlng24=new LatLng(Double.valueOf(last.getLat24()),Double.valueOf(last.getLon24()));
//                LatLng latlng36=new LatLng(Double.valueOf(last.getLat36()),Double.valueOf(last.getLon36()));
//                LatLng latlng48=new LatLng(Double.valueOf(last.getLat48()),Double.valueOf(last.getLon48()));
//                LatLng latlng60=new LatLng(Double.valueOf(last.getLat60()),Double.valueOf(last.getLon60()));
//                LatLng latlng72=new LatLng(Double.valueOf(last.getLat72()),Double.valueOf(last.getLon72()));
//                LatLng latlng84=new LatLng(Double.valueOf(last.getLat84()),Double.valueOf(last.getLon84()));
//                LatLng latlng96=new LatLng(Double.valueOf(last.getLat96()),Double.valueOf(last.getLon96()));
//                LatLng latlng120=new LatLng(Double.valueOf(last.getLat120()),Double.valueOf(last.getLon120()));
//                lineNext=new ArrayList<>();
//                lineNext.add(latlng6);lineNext.add(latlng12);lineNext.add(latlng18);lineNext.add(latlng24);lineNext.add(latlng36);
//                lineNext.add(latlng48);lineNext.add(latlng60);lineNext.add(latlng72);lineNext.add(latlng84);lineNext.add(latlng96);
//                lineNext.add(latlng120);

                setPath();
                //保存数据到本机
                ShareUtil shareUtil = new ShareUtil(TyphoonActivity.this);
                String lineS = GsonUtil.ObjectToString(line);
                shareUtil.put("lineS", lineS);

            }else{
                Toast.makeText(TyphoonActivity.this,"没有查询到台风", Toast.LENGTH_SHORT).show();

            }




        }
    };
}
