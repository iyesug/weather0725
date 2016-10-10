package com.vis.weather.flood;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
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
import com.vis.weather.model.WeatherDaily;
import com.vis.weather.model.WeatherHour;
import com.vis.weather.presenter.GetOnlineData;
import com.vis.weather.table.TableAdapter;
import com.vis.weather.util.DialogPlusUtil;
import com.vis.weather.util.ShareUtil;
import com.vis.weather.util.base.GsonUtil;
import com.vis.weather.util.base.ToDate;
import com.vis.weather.view.base.BaseActivity;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;

public class ReservoirTableActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        ButterKnife.bind(this);
        TextView title = setToolbar();
        title.setText("水库水位");
        topLinearLayout.setVisibility(View.GONE);
        bottomLinearLayout.setVisibility(View.GONE);
        tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        tableFixHeaders.setAdapter(new MyAdapter(ReservoirTableActivity.this));


        GetOnlineData.getOnline7Day(observerDaily, null, station);
        GetOnlineData.getStationList(observerList, "4", null);
        waitDialog.show();
    }
    @BindView(R.id.top)
    LinearLayout topLinearLayout;
    @BindView(R.id.bottom)
    LinearLayout bottomLinearLayout;
    TableFixHeaders tableFixHeaders;
    List<WeatherDaily.RowsBean> sevenDay;
    List<WeatherHour.RowsBean> hour;
    String sevenDayToString;
    String station = "58847";
    int type = 0;
    @BindView(R.id.id_textview_d6)
    TextView textView;
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
            if (type == 0 &sevenDay != null) {
                count = sevenDay.size();
            } else if (type == 1 & hour != null) {
                count = hour.size();
            }
            return count;
        }

        @Override
        public int getColumnCount() {

            if (type == 1) {
                return 5;
            }
            return 3;
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
                            s = "实况";
                            break;
                        case 0:
                            s = "气温";
                            break;
                        case 1:
                            s = "降雨";
                            break;

                        case 2:
                            s = "气压";
                            break;
                        case 3:
                            s = "风速";
                            break;
                        case 4:
                            s = "风向";
                            break;
                        default:
                            throw new RuntimeException("wtf?");
                    }
                } else {
                    if (hour != null) {
                        WeatherHour.RowsBean day = hour.get(row);
                        switch (column) {
                            case -1:
                                s = ToDate.getMonthByDate(day.getObserveTime() + "") + "月"+ToDate.getDayByDate(day.getObserveTime() + "") + "日"+ ToDate.getHourByDate(day.getObserveTime() + "")+ "时";
                                break;
                            case 0:
                                s = day.getTemp();
                                break;
                            case 1:
                                s = day.getRainfallPerHour();
                                break;

                            case 2:
                                s = day.getStationPress();
                                break;

                            case 3:
                                s = day.getWindSpeed();
                                break;

                            case 4:
                                s = day.getWindDirectDisp();
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
                            s = "水库名称";
                            break;
                        case 0:
                            s = "类别";
                            break;
                        case 1:
                            s = "水位（米）";
                            break;

                        case 2:
                            s = "相应蓄水量（万立方米）";
                            break;
                        default:
                            throw new RuntimeException("wtf?");
                    }
                } else {
                    if (sevenDay != null) {
                        WeatherDaily.RowsBean day = sevenDay.get(row);
                        switch (column) {
                            case -1:
                                s = ToDate.getMonthByDate(day.getEffDate() + "") + "月" + ToDate.getDayByDate(day.getEffDate() + "") + "日";
                                break;
                            case 0:
                                s = day.getTemp();
                                break;
                            case 1:
                                s = day.getWeatherPhen();
                                break;

                            case 2:
                                s = day.getWind();
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
                    layoutResource = R.layout.item_table1;
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
        public void onCompleted() {waitDialog.dismiss();
        }

        @Override
        public void onError(Throwable e) {

            Logger.e("onError" + e);
            //     Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
//            SnackbarUtil.show(view, "网络连接失败", 0);


            if (sevenDay == null || sevenDay.size() == 0) {

                ShareUtil shareUtil = new ShareUtil(ReservoirTableActivity.this);
                String daylistS = shareUtil.get("sevenDay", null);

                java.lang.reflect.Type type = new TypeToken<List<WeatherDaily.RowsBean>>() {
                }.getType();

                sevenDay = (List<WeatherDaily.RowsBean>) GsonUtil.StringToObject(daylistS, type);
            }
        }

        @Override
        public void onNext(WeatherDaily dh) {

            Logger.i("Day Total():" + dh.getTotal());
            if(dh.getTotal()==0){
                Toast.makeText(ReservoirTableActivity.this, "没有查询到数据", Toast.LENGTH_SHORT).show();
            }
            if (dh.getRows() != null) {
                int count = dh.getRows().size();
                sevenDay = dh.getRows();


                if (sevenDay == null || sevenDay.size() == 0) {

                    ShareUtil shareUtil = new ShareUtil(ReservoirTableActivity.this);
                    String daylistS = shareUtil.get("sevenDay", null);

                    java.lang.reflect.Type type = new TypeToken<List<WeatherDaily.RowsBean>>() {
                    }.getType();

                    sevenDay = (List<WeatherDaily.RowsBean>) GsonUtil.StringToObject(daylistS, type);
                }

                tableFixHeaders.setAdapter(new MyAdapter(ReservoirTableActivity.this));

                //保存数据到本机
                ShareUtil shareUtil = new ShareUtil(ReservoirTableActivity.this);
                sevenDayToString = GsonUtil.ObjectToString(sevenDay);
                shareUtil.put("sevenDay", sevenDayToString);


            } else {
                Toast.makeText(ReservoirTableActivity.this, "没有查询到数据", Toast.LENGTH_SHORT).show();
            }
        }
    };


    /*
    * 获取海洋站点列表
    * */
    private List<StationList.RowsBean> stationList;
    private List<String> mTitles;
    Observer<StationList> observerList = new Observer<StationList>() {
        @Override
        public void onCompleted() {waitDialog.dismiss();
        }

        @Override
        public void onError(Throwable e) {
            Logger.e("onError" + e);
            Toast.makeText(ReservoirTableActivity.this, "服务器连接超时", Toast.LENGTH_SHORT).show();
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
                ShareUtil shareUtil = new ShareUtil(ReservoirTableActivity.this);
                String stationListS = GsonUtil.ObjectToString(stationList);
                shareUtil.put("stationListShx", stationListS);

            } else {
                Toast.makeText(ReservoirTableActivity.this, "没有查询到数据", Toast.LENGTH_SHORT).show();
            }
        }
    };
    /*
    * 获取站点实况
    * */
    Observer<WeatherHour> observerHour = new Observer<WeatherHour>() {
        @Override
        public void onCompleted() {waitDialog.dismiss();
        }

        @Override
        public void onError(Throwable e) {

            Logger.e("onError" + e);
            Toast.makeText(ReservoirTableActivity.this, "服务器连接超时", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onNext(WeatherHour dh) {

            Logger.i("WeatherHour Total():" + dh.getTotal());
            if (dh.getRows() != null) {
                int count = dh.getRows().size();
                hour = dh.getRows();
                }
            tableFixHeaders.setAdapter(new MyAdapter(ReservoirTableActivity.this));
            }

    };

    /**
     * 下拉菜单
     *
     * @param view
     */
    public void dropdown(View view) {

        DialogPlusUtil dialogPlusUtil = new DialogPlusUtil(this);
        dialogPlusUtil.setGravity(Gravity.TOP);
//        mTitles=getResources().getStringArray(R.array.typhoon);
        if (mTitles != null && mTitles.size() != 0) {
            dialogPlusUtil.showdialog(mTitles, "选择站点", itemClickListener);

        }else {
            Toast.makeText(ReservoirTableActivity.this, "正在获取列表", Toast.LENGTH_SHORT).show();
        }
    }
    /*
    * 列表选择监听
    * */

    OnItemClickListener itemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
            station = stationList.get(position).getStationCode();
            textView.setText(mTitles.get(position));
            type = 0;
            GetOnlineData.getOnline7Day(observerDaily, null, station);

            waitDialog.show();
        }
    };

    /**
     * 实况
     *
     * @param view
     */
    public void autoStation(View view) {
        type = 1;
        GetOnlineData.getOnlinehour(observerHour, null, station);waitDialog.show();
    }

    /**
     * 预报
     *
     * @param view
     */
    public void forecast(View view) {
        type = 0;
        GetOnlineData.getOnline7Day(observerDaily, null, station);waitDialog.show();
    }
}
