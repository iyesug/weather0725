package com.vis.weather.qurey;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.reflect.TypeToken;
import com.inqbarna.tablefixheaders.TableFixHeaders;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.orhanobut.logger.Logger;
import com.vis.weather.R;
import com.vis.weather.model.StationList;
import com.vis.weather.model.StationRange;
import com.vis.weather.model.WeatherDaily;
import com.vis.weather.model.WeatherHour;
import com.vis.weather.presenter.GetOnlineData;
import com.vis.weather.table.TableAdapter;
import com.vis.weather.util.DialogPlusUtil;
import com.vis.weather.util.ShareUtil;
import com.vis.weather.util.base.GsonUtil;
import com.vis.weather.util.base.ToDate;
import com.vis.weather.view.base.BaseActivity;
import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.*;
import lecho.lib.hellocharts.view.LineChartView;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;

public class QueryMainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query_main);
        ButterKnife.bind(this);
        TextView title = setToolbar();
        title.setText("风雨查询");

        tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        tableFixHeaders.setAdapter(new MyAdapter(QueryMainActivity.this));

        GetOnlineData.getOnlinehour(observerHour, null, station);

        GetOnlineData.getStationList(observerParentList, "3", null);
        waitDialog.show();
    }

    TableFixHeaders tableFixHeaders;
    List<WeatherDaily.RowsBean> sevenDay;
    List<WeatherHour.RowsBean> hour;
    String sevenDayToString;
    String station = "58847";
    String stationParent = null;
    int type = 0;
    @BindView(R.id.id_textview_d6)
    TextView textView;
    @BindView(R.id.id_textview_d5)
    TextView textViewParent;
    @BindView(R.id.id_textview_d4)
    TextView textViewRange;
    public class MyAdapter extends TableAdapter {

        private final int width;
        private final int height;

        public MyAdapter(Context context) {
            super(context);

            Resources resources = context.getResources();

            width = resources.getDimensionPixelSize(R.dimen.table_width);
            height = resources.getDimensionPixelSize(R.dimen.table_height);
        }

        @Override
        public int getRowCount() {
            int count = 0;
//            if (type == 0 &sevenDay != null) {
//                count = sevenDay.size();
          if (hour != null) {
                count = hour.size();
            }
            return count;
        }

        @Override
        public int getColumnCount() {

            if (type == 1) {
                return 4;
            }
            return 1;
        }

        @Override
        public int getWidth(int column) {
            return width;
        }

        @Override
        public int getHeight(int row) {
            return height;
        }

        @Override
        public String getCellString(int row, int column) {
            String s = "";

            if (type == 1) {
                if (row < 0) {
                    switch (column) {
                        case -1:
                            s = "风况";
                            break;
                        case 0:
                            s = "瞬时风速(米/秒)";
                            break;
                        case 1:
                            s = "瞬时风向(米/秒)";
                            break;

                        case 2:
                            s = "小时最大风速";
                            break;
                        case 3:
                            s = "小时最大风向";
                            break;

                        default:
                            throw new RuntimeException("wtf?");
                    }
                } else {
                    if (hour != null) {
                        WeatherHour.RowsBean day = hour.get(row);
                        switch (column) {
                            case -1:
                                s =ToDate.getMonthByDate(day.getObserveTime() + "") + "月"+ ToDate.getDayByDate(day.getObserveTime() + "") + "日"+ ToDate.getHourByDate(day.getObserveTime() + "")+ "时";
                                break;
                            case 0:
                                s = day.getWindSpeed();
                                break;
                            case 1:
                                s = day.getWindDirectDisp();
                                break;

                            case 2:
                                s =  day.getMaxWindSpeed();
                                break;

                            case 3:
                                s = day.getMaxWindDirectDisp();
                                break;


                            default:
                                throw new RuntimeException("wtf?");
                        }
                    }
                }
            } else if (type == 0) {
                if (row < 0) {
                    switch (column) {
                        case -1:
                            s = "雨量";
                            break;
                        case 0:
                            s = "小时总量(毫米)";
                            break;

                        default:
                            throw new RuntimeException("wtf?");
                    }
                } else {
                    if (hour != null) {
                        WeatherHour.RowsBean day = hour.get(row);
                        switch (column) {
                            case -1:
                                s =ToDate.getMonthByDate(day.getObserveTime() + "") + "月"+ ToDate.getDayByDate(day.getObserveTime() + "") + "日"+ ToDate.getHourByDate(day.getObserveTime() + "")+ "时";

                                break;
                            case 0:
                                String rain=day.getRainfallPerHour();
                                if("".equals(rain)){
                                    s="0";
                                }else{
                                s = rain;}
                                break;

                            default:
                                throw new RuntimeException("wtf?");
                        }
                    }
                }
            }
            return s;
        }

        @Override
        public int getLayoutResource(int row, int column) {
            final int layoutResource;
            switch (getItemViewType(row, column)) {
                case 0:
                    layoutResource = R.layout.item_table1_header;
                    break;
                case 1:
                    layoutResource = R.layout.item_table1;
                    break;

                case -1:
                    layoutResource = R.layout.item_table1;
                    break;
                default:
                    throw new RuntimeException("wtf?");
            }
            return layoutResource;
        }

        @Override
        public int getItemViewType(int row, int column) {
            if (row < 0) {
                return 0;
            } else if (column < 0) {
                return -1;
            } else {
                return 1;
            }
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }
    }


    Observer<WeatherDaily> observerDaily = new Observer<WeatherDaily>() {
        @Override
        public void onCompleted() {
            waitDialog.dismiss();
        }

        @Override
        public void onError(Throwable e) {
            waitDialog.dismiss();
            Logger.e("onError" + e);
            //     Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
//            SnackbarUtil.show(view, "网络连接失败", 0);


            if (sevenDay == null || sevenDay.size() == 0) {

                ShareUtil shareUtil = new ShareUtil(QueryMainActivity.this);
                String daylistS = shareUtil.get("sevenDay", "");

                java.lang.reflect.Type type = new TypeToken<List<WeatherDaily.RowsBean>>() {
                }.getType();

                sevenDay = (List<WeatherDaily.RowsBean>) GsonUtil.StringToObject(daylistS, type);
            }
        }

        @Override
        public void onNext(WeatherDaily dh) {

            Logger.i("Day Total():" + dh.getTotal());
            if(dh.getTotal()==0){
                Toast.makeText(QueryMainActivity.this, "没有查询到数据", Toast.LENGTH_SHORT).show();
            }
            if (dh.getRows() != null) {
                int count = dh.getRows().size();
                sevenDay = dh.getRows();


                if (sevenDay == null || sevenDay.size() == 0) {

                    ShareUtil shareUtil = new ShareUtil(QueryMainActivity.this);
                    String daylistS = shareUtil.get("sevenDay", "");

                    java.lang.reflect.Type type = new TypeToken<List<WeatherDaily.RowsBean>>() {
                    }.getType();

                    sevenDay = (List<WeatherDaily.RowsBean>) GsonUtil.StringToObject(daylistS, type);
                }

                tableFixHeaders.setAdapter(new QueryMainActivity.MyAdapter(QueryMainActivity.this));

                //保存数据到本机
                ShareUtil shareUtil = new ShareUtil(QueryMainActivity.this);
                sevenDayToString = GsonUtil.ObjectToString(sevenDay);
                shareUtil.put("sevenDay", sevenDayToString);


            } else {
                Toast.makeText(QueryMainActivity.this, "没有查询到数据", Toast.LENGTH_SHORT).show();
            }
        }
    };

    /*
     * 获取省份列表
     * */
    private List<StationList.RowsBean> stationParentList;
    private List<String> mParentTitles;
    Observer<StationList> observerParentList = new Observer<StationList>() {
        @Override
        public void onCompleted() {
            waitDialog.dismiss();
        }

        @Override
        public void onError(Throwable e) {
            waitDialog.dismiss();
            Logger.e("onError" + e);
            Toast.makeText(QueryMainActivity.this, "服务器连接超时", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(StationList lp) {
            Logger.i(lp.toString());
            if (lp != null && lp.getRows() != null && lp.getRows().size() != 0) {
                stationParentList = new ArrayList<>();
                mParentTitles = new ArrayList<>();
                for(int i=0;i<lp.getRows().size();i++){
                    if("".equals(lp.getRows().get(i).getParentId())){
                        stationParentList.add(lp.getRows().get(i));
                        mParentTitles.add(lp.getRows().get(i).getCityName());
                    }

                }
                Logger.i("stationParentList:"+stationParentList.size()+";;;mParentTitles:"+mParentTitles.size());

                //保存数据到本机
                ShareUtil shareUtil = new ShareUtil(QueryMainActivity.this);
                String stationListS = GsonUtil.ObjectToString(stationParentList);
                shareUtil.put("stationListShx", stationListS);

            } else {
                Toast.makeText(QueryMainActivity.this, "没有查询到数据", Toast.LENGTH_SHORT).show();
            }
        }
    };
    /*
    * 获取站点列表
    * */
    private List<StationList.RowsBean> stationList;
    private List<String> mTitles;
    Observer<StationList> observerList = new Observer<StationList>() {
        @Override
        public void onCompleted() {
waitDialog.dismiss();
        }

        @Override
        public void onError(Throwable e) {
            waitDialog.dismiss();
            Logger.e("onError" + e);
            Toast.makeText(QueryMainActivity.this, "服务器连接超时", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(StationList lp) {
            Logger.i(lp.toString());
            if (lp != null && lp.getRows() != null && lp.getRows().size() != 0) {
                stationList = lp.getRows();
                mTitles = new ArrayList<>();
                for (int i = 0; i < lp.getRows().size(); i++) {
                    mTitles.add(stationList.get(i).getCityName());
                }


                //保存数据到本机
                ShareUtil shareUtil = new ShareUtil(QueryMainActivity.this);
                String stationListS = GsonUtil.ObjectToString(stationList);
                shareUtil.put("stationListShx", stationListS);

            } else {
                Toast.makeText(QueryMainActivity.this, "没有查询到数据", Toast.LENGTH_SHORT).show();
            }
        }
    };
    /*
    * 获取站点实况
    * */
    Observer<WeatherHour> observerHour = new Observer<WeatherHour>() {
        @Override
        public void onCompleted() {
waitDialog.dismiss();
        }

        @Override
        public void onError(Throwable e) {
            waitDialog.dismiss();
            Logger.e("onError" + e);
            Toast.makeText(QueryMainActivity.this, "服务器连接超时", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onNext(WeatherHour dh) {

            Logger.i("WeatherHour Total():" + dh.getTotal());
            if (dh.getRows() != null) {
                int count = dh.getRows().size();
                hour = dh.getRows();
            }
            tableFixHeaders.setAdapter(new QueryMainActivity.MyAdapter(QueryMainActivity.this));
            lineChart.setVisibility(View.VISIBLE);
            getAxisPoints();//获取坐标点

            initLineChart();//初始化

        }

    };
    private List<StationRange> stationRangeList;
    private List<String> rangeTitles;

    /**
     * 范围选择
     *
     * @param view
     */
    public void range(View view) {
//        <item>10:skallcounties:各县市天气实况</item>
//        <item>9:skautostation:自动站实况监测</item>
//        <item>14:skcountry:全国天气实况</item>
//        <item>13:skfujian:福建天气实况</item>
//        <item>12:skquanzhou:泉州天气实况</item>
//        <item>5:skquanzhouhaiyang:泉州海洋气象实况</item>
//        <item>11:sktaiwanstrait:台湾海峡天气实况</item>
        stationRangeList= new ArrayList<>();
        stationRangeList.add(new StationRange("10","县市范围","skallcounties"));
        stationRangeList.add(new StationRange("11","台湾海峡","sktaiwanstrait"));
        stationRangeList.add(new StationRange("12","泉州地区","skquanzhou"));
        stationRangeList.add(new StationRange("13","福建范围","skfujian"));
        stationRangeList.add(new StationRange("14","全国范围","skcountry"));

        rangeTitles=new ArrayList<>();
        for(int i=0;i<stationRangeList.size();i++){
            rangeTitles.add(stationRangeList.get(i).getName());
        }



        DialogPlusUtil dialogPlusUtil = new DialogPlusUtil(this);
        dialogPlusUtil.setGravity(Gravity.TOP);
//        mTitles=getResources().getStringArray(R.array.typhoon);
            dialogPlusUtil.showdialog(rangeTitles, "选择范围", itemClickListenerRange);


    }
          /*
    * 范围选择监听
    * */
    String rangeId;
    OnItemClickListener itemClickListenerRange = new OnItemClickListener() {
        @Override
        public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
            rangeId = stationRangeList.get(position).getId();
            textViewRange.setText(rangeTitles.get(position));
            type = 0;
            if("14".equals(rangeId)) {
                GetOnlineData.getStationList(observerList, "14", stationParent);
                textView.setVisibility(View.VISIBLE);
            }else {
                GetOnlineData.getStationList(observerList, rangeId, null);
                textView.setVisibility(View.GONE);
            }
            waitDialog.show();
            dialog.dismiss();
        }
    };

    /**
     * 省份菜单
     *
     * @param view
     */
    public void dropdownParent(View view) {

        DialogPlusUtil dialogPlusUtil = new DialogPlusUtil(this);
        dialogPlusUtil.setGravity(Gravity.TOP);
//        mTitles=getResources().getStringArray(R.array.typhoon);
        if (mParentTitles != null && mParentTitles.size() != 0) {
            dialogPlusUtil.showdialog(mParentTitles, "选择省份", itemClickListenerParent);

        }else {
            Toast.makeText(QueryMainActivity.this, "正在获取省份列表", Toast.LENGTH_SHORT).show();
            GetOnlineData.getStationList(observerParentList, "3", null);
            waitDialog.show();
        }
    }
    /**
     * 站点菜单
     *
     * @param view
     */
    public void dropdown(View view) {

        DialogPlusUtil dialogPlusUtil = new DialogPlusUtil(this);
        dialogPlusUtil.setGravity(Gravity.TOP);
//        mTitles=getResources().getStringArray(R.array.typhoon);
        if (mTitles != null && mTitles.size() != 0) {
            dialogPlusUtil.showdialog(mTitles, "选择站点", itemClickListener);

        }else{
            Toast.makeText(QueryMainActivity.this, "请先选择省份", Toast.LENGTH_SHORT).show();

        }
    }
        /*
    * 列表选择监听
    * */

    OnItemClickListener itemClickListenerParent = new OnItemClickListener() {
        @Override
        public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
            stationParent = stationParentList.get(position).getSid();
            textView.setText(mParentTitles.get(position));
            type = 0;
            GetOnlineData.getStationList(observerList, "3", stationParent);
       waitDialog.show();
            dialog.dismiss();
        }
    };


    /*
    * 列表选择监听
    * */

    OnItemClickListener itemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
            station = stationList.get(position).getStationCode();
            textViewParent.setText(mTitles.get(position));
            type = 0;
            GetOnlineData.getOnlinehour(observerHour, null, station);
            waitDialog.show();
            dialog.dismiss();
        }
    };

    /**
     * 风况
     *
     * @param view
     */
    public void autoStation(View view) {
        type = 1;
        tableFixHeaders.setAdapter(new QueryMainActivity.MyAdapter(QueryMainActivity.this));
        getAxisPoints();//获取坐标点

        initLineChart();//初始化

//        GetOnlineData.getOnlinehour(observerHour, null, station);waitDialog.show();
    }

    /**
     * 雨量
     *
     * @param view
     */
    public void forecast(View view) {
        type = 0;
        tableFixHeaders.setAdapter(new QueryMainActivity.MyAdapter(QueryMainActivity.this));
        getAxisPoints();//获取坐标点

        initLineChart();//初始化

//        GetOnlineData.getOnline7Day(observerDaily, null, station);waitDialog.show();
    }



    @BindView(R.id.line_chart)
    LineChartView lineChart;
    private List<PointValue> mPointValues;
    private List<AxisValue> mAxisXValues;
    private float max,min;
    /**
     * 图表的每个点的显示
     */
    private void getAxisPoints() {
        mPointValues = new ArrayList<PointValue>();
        mAxisXValues = new ArrayList<AxisValue>();
        float point=0;
        if(hour==null){
            lineChart.setVisibility(View.GONE);
        }
        if(hour!=null) {
            for (int i = 0; i < hour.size(); i++) {
                WeatherHour.RowsBean oneHour = hour.get(i);

                switch (type) {

                    case 0:
                        point = Float.valueOf(oneHour.getRainfallPerHour()) ;
                        break;
                    case 1:
                        point =Float.valueOf(oneHour.getWindSpeed());
                        break;
                    default:
                        break;
                }
                mAxisXValues.add(new AxisValue(i).setLabel(ToDate.getHourByDate(oneHour.getObserveTime() + "")));
                mPointValues.add(new PointValue(i, point));
                if (i == 0) {
                    max = min = point;
                }
                if (i > 0) {
                    max = point >= max ? point : max;
                    min = point <= min ? point : min;

                }


            }
        }else{
//            if("气温".equals(flag)){
//                Toast.makeText(this, "无数据，请稍后再试", Toast.LENGTH_SHORT).show();

            }
        }


    private void initLineChart() {
        Line line = new Line(mPointValues).setColor(Color.parseColor("#FFCD41"));  //折线的颜色（橙色）
        List<Line> lines = new ArrayList<Line>();
        line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状  这里是圆形 （有三种 ：ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.DIAMOND）
        line.setCubic(true);//曲线是否平滑，即是曲线还是折线
        line.setFilled(true);//是否填充曲线的面积
        line.setHasLabels(true);//曲线的数据坐标是否加上备注
        line.setHasLabelsOnlyForSelected(true);//点击数据坐标提示数据（设置了这个line.setHasLabels(true);就无效）
        line.setHasLines(true);//是否用线显示。如果为false 则没有曲线只有点显示
        line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示（每个数据点都是个大的圆点）
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setHasTiltedLabels(false);  //X坐标轴字体是斜的显示还是直的，true是斜的显示
        axisX.setTextColor(Color.WHITE);  //设置字体颜色
        axisX.setName("小时");  //表格名称
        axisX.setTextSize(10);//设置字体大小
//        axisX.setMaxLabelChars(24); //最多几个X轴坐标，意思就是你的缩放让X轴上数据的个数7<=x<=mAxisXValues.length
        axisX.setValues(mAxisXValues);  //填充X轴的坐标名称
        data.setAxisXBottom(axisX); //x 轴在底部
        //data.setAxisXTop(axisX);  //x 轴在顶部
        // axisX.setHasLines(true); //x 轴分割线

        // Y轴是根据数据的大小自动设置Y轴上限(在下面我会给出固定Y轴数据个数的解决方案)
        Axis axisY = new Axis();//Y轴
        axisY.setHasLines(true);

        axisY.setInside(true);
        if(type==0){
            axisY.setName("雨量(毫米)");//y轴标注
        }else{
            axisY.setName("风况(米/秒)");//y轴标注
        }
        axisY.setTextSize(12);//设置字体大小
        data.setAxisYLeft(axisY);  //Y轴设置在左边
        //data.setAxisYRight(axisY);  //y轴设置在右边


        //设置行为属性，支持缩放、滑动以及平移
        lineChart.setValueSelectionEnabled(true);
        lineChart.setInteractive(true);
        lineChart.setZoomType(ZoomType.HORIZONTAL);
        lineChart.setMaxZoom((float) 5);//最大方法比例
        lineChart.setContainerScrollEnabled(true, ContainerScrollType.VERTICAL);
        lineChart.setLineChartData(data);

        lineChart.setVisibility(View.VISIBLE);
        /**注：下面的7，10只是代表一个数字去类比而已
         * 当时是为了解决X轴固定数据个数。见（http://forum.xda-developers.com/tools/programming/library-hellocharts-charting-library-t2904456/page2）;
         */
        Viewport v = new Viewport(lineChart.getMaximumViewport());
        v.left = 0;
        v.right = 1;
        v.top=max*2;
        v.bottom=min-(max-min);
        lineChart.setCurrentViewport(v);



    }

}
