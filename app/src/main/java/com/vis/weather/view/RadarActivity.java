package com.vis.weather.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vis.weather.R;
import com.vis.weather.presenter.PhotoViewPagerAdapter;
import com.vis.weather.util.Constant;
import com.vis.weather.util.ScreenUtil;
import com.vis.weather.view.base.BaseActivity;

import java.util.ArrayList;

public class RadarActivity extends BaseActivity  {

    private ViewPager vp;
    private LinearLayout ll_point;
    private ArrayList<String> mImages;
    //用于存放ImageView
    private ArrayList<ImageView> imageViewsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoviewlayout);
        TextView title=setToolbar();
        title.setText("温湿压图");
        initViews();
        initImageUrl();
        getImageData();
    }

    private void initImageUrl() {
        //要显示的图片地址添加到集合里面
        mImages = new ArrayList<String>();
        mImages.add(Constant.url7);
        mImages.add(Constant.url8);
        mImages.add(Constant.url1);
        mImages.add(Constant.url2);
    mImages.add(Constant.url4);
        mImages.add(Constant.url5);
//        mImages.add(Constant.url6);

        imageViewsList = new ArrayList<>();
    }

    private void initViews() {
        vp = (ViewPager) findViewById(R.id.viewPager);
        ll_point = (LinearLayout) findViewById(R.id.ll_point);

        //让图片正方形显示
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ScreenUtil.getScreenWidth(this));
        vp.setLayoutParams(params);

    }

    public void getImageData() {
        if (mImages.size() == 1) {
            // 只有一张图片   就不显示圆点
        } else {
            for (int i = 0; i < mImages.size(); i++) {
                View point = new View(this);
                //point.setId(i);//设置Id
                point.setTag(i);//设置Tag
                //设置背景
                point.setBackgroundResource(R.drawable.background_7);
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
            ImageView iv = new ImageView(this);
            //设置iv的宽高
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtil.getScreenWidth(this));
            iv.setLayoutParams(params);
            //设置iv的填充样式--->可能导致图片变形
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            String url = mImages.get(i);
            Glide.with(this).load(url).into(iv);

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

        vp.setAdapter(new PhotoViewPagerAdapter(imageViewsList,vp) );
        vp.setOnPageChangeListener(new MyOnPageChangeListener());
        vp.setOffscreenPageLimit(10);
    }

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

}
