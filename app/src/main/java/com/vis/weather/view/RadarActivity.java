package com.vis.weather.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.OptionPicker;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.orhanobut.logger.Logger;
import com.vis.weather.R;
import com.vis.weather.model.ListPicture;
import com.vis.weather.presenter.GetOnlineData;
import com.vis.weather.presenter.PhotoViewPagerAdapter;
import com.vis.weather.util.Config;
import com.vis.weather.util.ScreenUtil;
import com.vis.weather.util.ShareUtil;
import com.vis.weather.util.base.GsonUtil;
import com.vis.weather.view.base.BaseActivity;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;

public class RadarActivity extends BaseActivity {
    boolean isMove = false;
    boolean isRun = true;
    private ViewPager vp;
    private LinearLayout ll_point;
    private ArrayList<String> mImages;
    //用于存放ImageView
    private ArrayList<ImageView> imageViewsList;
    @BindView(R.id.id_textview_1)
    TextView tv_station;
    @BindView(R.id.id_textview_2)
    TextView tv_dateStart;
    @BindView(R.id.id_textview_3)
    TextView tv_dateEnd;

    private String station;
    private String dateStart;
    private String dateEnd;
    List<ListPicture.RowsBean> piclist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoviewlayout);
        ButterKnife.bind(this);
        TextView title = setToolbar();
        title.setText("雷达站图");
        initViews();
        tv_dateStart.setText(2016 + "-" + 9 + "-" + 11);
        tv_dateEnd.setText(2016 + "-" + 9 + "-" + 12);
        tv_station.setText("泉州");
        dateStart="20160911180000";
        dateEnd="20160912310000";
        station= Config.quanzhou;
        GetOnlineData.getPic(observerPic, "rad",dateStart,dateEnd,station );
        waitDialog.show();
    }
    Thread path;
    public void play(View view) {
        if (!isMove) {
            isMove = true;
            isRun = true;

             path = new Thread(new Runnable() {
                public void run() {
                    int i=count;
                    while (isRun&mImages!=null) {
                        count++;
                        if(count>=mImages.size()){
                            count=0;
                        }
                        Message message=handler.obtainMessage();
                        message.arg1=count;
                        message.arg2=i;
                        handler.sendMessage(message);
//                        Glide.with(RadarActivity.this).load(mImages.get(count)).into(imageViewsList.get(i));
                        try {
                            path.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    isMove = false;
                    isRun = true;

                }
            });
            path.start();
        } else {
            isRun=false;
            isMove = false;
        }


    }

    private void initImageUrl() {

        //要显示的图片地址添加到集合里面
        mImages = new ArrayList<String>();
        if(piclist!=null){
        for(int i=0;i<piclist.size();i++){
            if(piclist.get(i).getFilepath().endsWith("gif")||piclist.get(i).getFilepath().endsWith("png")){
                mImages.add(com.vis.weather.util.Network.picFront+ piclist.get(i).getFilepath());


            }

        }}else{
            mImages.add("http://i.weather.com.cn/i/product/share/pic/l/PWCP_AZJ_LDN_S99_SLDAS_AZJ_LNO_P9_20151210011000000.GIF");
            mImages.add("http://i.weather.com.cn/i/product/share/pic/l/PWCP_AZJ_LDN_S99_SLDAS_AZJ_LNO_P9_20151210012000000.GIF");
            mImages.add("http://i.weather.com.cn/i/product/share/pic/l/PWCP_AZJ_LDN_S99_SLDAS_AZJ_LNO_P9_20151210013000000.GIF");
        }
        Toast.makeText(RadarActivity.this,"查询到"+mImages.size()+"张雷达图，正在缓存...", Toast.LENGTH_SHORT).show();

        imageViewsList = new ArrayList<>();
    }

    private void initViews() {
        vp = (ViewPager) findViewById(R.id.viewPager);
        ll_point = (LinearLayout) findViewById(R.id.ll_point);

        //让图片正方形显示
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        vp.setLayoutParams(params);

    }
    int count=0;
    ImageView iv;

    public void getImageData() {
        if (mImages.size() == 1) {
            // 只有一张图片   就不显示圆点
        } else {
            for (int i = 0; i < mImages.size(); i++) {
                View point = new View(this);
                //point.setId(i);//设置Id
                point.setTag(i);//设置Tag
                //设置背景
                point.setBackgroundResource(R.drawable.typhoon_1);
                //布局参数
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(15, 15);
                params.rightMargin = 20;//右边距
                //把点添加到线性布局
                ll_point.addView(point, params);
            }
            View point = ll_point.getChildAt(0);
            point.setEnabled(false);
        }
        for (int i = 0; i < mImages.size(); i++) {
            iv = new ImageView(this);
            //设置iv的宽高
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtil.getScreenWidth(this));
            iv.setLayoutParams(params);
            //设置iv的填充样式--->可能导致图片变形
            iv.setScaleType(ImageView.ScaleType.CENTER);
            count=i;
            String url = mImages.get(i);

            Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.close).dontAnimate().placeholder(R.drawable.rad).fitCenter().into(iv);

            //设置图片的点击事件
            //为每一个ImageView设置单独的标记、图片的位置
            iv.setTag(i);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = (int) view.getTag();
                    Intent intent = new Intent(RadarActivity.this, PhotoShowActivity.class);
                    //传递当前点击的图片的位置、图片路径集合
                    intent.putExtra("position", position);
                    intent.putStringArrayListExtra("mImages", mImages);
                    startActivity(intent);
                }
            });

            // 把图片添加到集合里面
            imageViewsList.add(iv);
        }

        vp.setAdapter(new PhotoViewPagerAdapter(imageViewsList, vp));
        vp.setOnPageChangeListener(new MyOnPageChangeListener());
        vp.setOffscreenPageLimit(10);

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            //super.handleMessage(msg);
            //显示进度条
            vp.setCurrentItem(msg.arg1,false);
        }
    };



    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        //页面选择
        @Override
        public void onPageSelected(int index) {
            changePager(index);
        }
    }

    private void changePager(int index) {
        int childCount = ll_point.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View point = ll_point.getChildAt(i);//获取小圆点
            if (index == i) {
                //当前选择的页面下标
                point.setEnabled(false);
            } else {
                point.setEnabled(true);
            }
        }
    }



    Observer<ListPicture> observerPic = new Observer<ListPicture>() {
        @Override
        public void onCompleted() {
            waitDialog.dismiss();
        }

        @Override
        public void onError(Throwable e) {
            waitDialog.dismiss();
            Logger.e("onError" + e);
            Toast.makeText(RadarActivity.this, "服务器连接超时", Toast.LENGTH_SHORT).show();
            initImageUrl();
            getImageData();
        }

        @Override
        public void onNext(ListPicture lp) {
            Logger.i(lp.toString());
            if(lp!=null&&lp.getRows()!=null&&lp.getRows().size()!=0){
                 piclist=lp.getRows();


                //保存数据到本机
                ShareUtil shareUtil = new ShareUtil(RadarActivity.this);
                String piclistS = GsonUtil.ObjectToString(piclist);
                shareUtil.put("piclist", piclistS);

            }else{
                Toast.makeText(RadarActivity.this,"没有查询到雷达图", Toast.LENGTH_SHORT).show();

            }
            initImageUrl();
            getImageData();



        }
    };

    DatePicker picker;
    public void start(View view) {

        GetOnlineData.getPic(observerPic, "rad", dateStart, dateEnd, station);

    }
    public void dropdownStart(View view) {
        makePicker();
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                Toast.makeText(RadarActivity.this,year + "-" + month + "-" + day, Toast.LENGTH_SHORT).show();
                dateStart=year+month+day+"000000";
                tv_dateStart.setText(year + "-" + month + "-" + day);
            }
        });

        String[] s=tv_dateStart.getText().toString().split("-");
        picker.setSelectedItem(Integer.parseInt(s[0]),Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        picker.show();
    }
    public void dropdownEnd(View view) {
        makePicker();
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                Toast.makeText(RadarActivity.this,year + "-" + month + "-" + day, Toast.LENGTH_SHORT).show();
                dateEnd=year+month+day+"000000";
                tv_dateEnd.setText(year + "-" + month + "-" + day);

            }
        });
        String[] s=tv_dateEnd.getText().toString().split("-");
        picker.setSelectedItem(Integer.parseInt(s[0]),Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        picker.show();
    }
    public void dropdownStation(View view) {
        final String[] stationCN=new String[]{"50001", "58734", "58847", "58927", "59132", "59134"
        };
        OptionPicker picker = new OptionPicker(this, new String[]{
                "福建", "建阳", "长乐", "龙岩", "泉州", "厦门"
        });
        picker.setOffset(2);
        picker.setSelectedIndex(stationCN.length/2);
        picker.setTextSize(17);
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int position, String option) {
            tv_station.setText(option);

            GetOnlineData.getPic(observerPic, "rad", dateStart, dateEnd, station);
            }
        });
        picker.show();
    }
    private void makePicker() {
        picker = new DatePicker(this, DatePicker.YEAR_MONTH_DAY);
        picker.setRangeStart(2010,1, 1);//开始范围
        picker.setRangeEnd(2017,12, 1);//结束范围

    }
}
