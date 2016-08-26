package com.vis.weather.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.squareup.leakcanary.RefWatcher;
import com.vis.weather.R;
import com.vis.weather.SplashActivity;
import com.vis.weather.model.WeatherHour;
import com.vis.weather.util.Application;
import com.vis.weather.util.ShareUtil;
import com.vis.weather.util.base.GsonUtil;
import com.vis.weather.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.listener.ViewportChangeListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PreviewLineChartView;


public class TodayFragment extends BaseFragment {

    @BindView(R.id.line_chart)
    LineChartView lineChart;
    @BindView(R.id.chart_preview)
    PreviewLineChartView chartPreview;
    private View mView;
    String flag;


    String[] hour = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12", "13",
            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};//X轴的标注
//    int[] value = {24, 22, 18, 19, 20, 24, 20, 24, 22, 20, 24, 22, 20, 10, 22, 20, 23, 10, 14, 22, 18, 19, 20, 17};//图表的数据
    private List<PointValue> mPointValues = new ArrayList<PointValue>();
    private List<AxisValue> mAxisXValues = new ArrayList<AxisValue>();
    private float max,min;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.re_item_24, container, false);
        ButterKnife.bind(this,mView);

        flag = (String) getArguments().get("flag");

        getAxisXLables();//获取x轴的标注
        getAxisPoints();//获取坐标点

        initLineChart();//初始化

        return mView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    /**
     * 设置X 轴的显示
     */
    private void getAxisXLables() {
     int now=Integer.parseInt(RecyclerFragment.mDateAndHour[3]);

        int count=0;

        for (int i = now-1; i < hour.length+(now-1); i++) {
            count++;
            if(i<hour.length-1){
                mAxisXValues.add(new AxisValue(count).setLabel(hour[i+1]));

            }else{
                mAxisXValues.add(new AxisValue(count).setLabel(hour[i+1-hour.length]));

            }

        }


    }

    /**
     * 图表的每个点的显示
     */
    private void getAxisPoints() {
        float point=0;
        if(SplashActivity.hourlist==null){
            ShareUtil shareUtil=new ShareUtil(getActivity().getApplicationContext());
            String hourlistS=shareUtil.get("hourlist",null);
            java.lang.reflect.Type type = new TypeToken<List<WeatherHour.RowsBean>>() {}.getType();
            SplashActivity.hourlist = (List<WeatherHour.RowsBean>) GsonUtil.StringToObject(hourlistS, type);
        }
        if(SplashActivity.hourlist!=null) {
            for (int i = 0; i < SplashActivity.hourlist.size(); i++) {
                WeatherHour.RowsBean hour = SplashActivity.hourlist.get(i);

                switch (flag) {

                    case "降雨":
                        point = (float) hour.getRainfallPerHour();
                        break;
                    case "风速":
                        point = (float) hour.getWindSpeed();
                        break;
                    case "湿度":
                        point = (float) hour.getHumidity();
                        break;
                    case "能见":
                        point = hour.getVisibility() != null ? (float) hour.getVisibility() : 0;
                        break;
                    case "气压":
                        point = (float) hour.getStationPress();

                        break;
                    case "气温":
                        point = (float) hour.getTemp();
                        break;
                    default:
                        break;
                }
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
            if("气温".equals(flag)){
                Toast.makeText(getContext(), "无数据，请稍后再试", Toast.LENGTH_SHORT).show();

            }
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
        axisX.setTextSize(14);//设置字体大小
       // axisX.setMaxLabelChars(24); //最多几个X轴坐标，意思就是你的缩放让X轴上数据的个数7<=x<=mAxisXValues.length
        axisX.setValues(mAxisXValues);  //填充X轴的坐标名称
        data.setAxisXBottom(axisX); //x 轴在底部
        //data.setAxisXTop(axisX);  //x 轴在顶部
       // axisX.setHasLines(true); //x 轴分割线

        // Y轴是根据数据的大小自动设置Y轴上限(在下面我会给出固定Y轴数据个数的解决方案)
        Axis axisY = new Axis();//Y轴
        axisY.setHasLines(true);
        axisY.setName(flag);//y轴标注
        axisY.setTextSize(12);//设置字体大小
        data.setAxisYLeft(axisY);  //Y轴设置在左边
        //data.setAxisYRight(axisY);  //y轴设置在右边


        //设置行为属性，支持缩放、滑动以及平移
        lineChart.setValueSelectionEnabled(true);
        lineChart.setInteractive(true);
        lineChart.setZoomType(ZoomType.HORIZONTAL);
        lineChart.setMaxZoom((float) 2);//最大方法比例
        lineChart.setContainerScrollEnabled(true, ContainerScrollType.VERTICAL);
        lineChart.setLineChartData(data);
        LineChartData previewData = new LineChartData(data);
        previewData.getLines().get(0).setColor(ChartUtils.DEFAULT_DARKEN_COLOR);
        chartPreview.setLineChartData(previewData);
        chartPreview.setViewportChangeListener(new ViewportListener());
        lineChart.setVisibility(View.VISIBLE);
        /**注：下面的7，10只是代表一个数字去类比而已
         * 当时是为了解决X轴固定数据个数。见（http://forum.xda-developers.com/tools/programming/library-hellocharts-charting-library-t2904456/page2）;
         */
        Viewport v = new Viewport(lineChart.getMaximumViewport());
        v.left = 0;
     //   v.right = 7;
        v.top=max*2;
        v.bottom=min-(max-min);
        lineChart.setCurrentViewport(v);
        previewX(false);


    }

    private void previewX(boolean animate) {
        Viewport tempViewport = new Viewport(lineChart.getMaximumViewport());
        float dx = tempViewport.width() / 4;
        tempViewport.inset(dx, 0);
        if (animate) {
            chartPreview.setCurrentViewportWithAnimation(tempViewport);
        } else {
            chartPreview.setCurrentViewport(tempViewport);
        }
        chartPreview.setZoomType(ZoomType.HORIZONTAL);
    }



    @Override
    public void onItemClick(View view, int position) {


    }


    @Override
    public void onItemLongClick(View view, int position) {


    }

    private class ViewportListener implements ViewportChangeListener {

        @Override
        public void onViewportChanged(Viewport newViewport) {
            // don't use animation, it is unnecessary when using preview chart.
            lineChart.setCurrentViewportWithAnimation(newViewport);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = Application.getRefWatcher(getActivity());
        refWatcher.watch(this);
        lineChart=null;
        chartPreview=null;
    }
}
