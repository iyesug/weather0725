package com.vis.weather.view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.vis.weather.R;
import com.vis.weather.view.base.MyPhotoView;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

import java.util.ArrayList;


/**
 * Created by GaoYu on 2016/7/28.
 */
public class PhotoShowActivity extends Activity {

    private int position;
    private ArrayList<String> mDatas;
    private MyPhotoView hViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);

        getFrontPageData();
        initViews();

    }

    private void initViews() {
        hViewPager = (MyPhotoView) findViewById(R.id.hViewPager);
        hViewPager.setAdapter(new ImageAdapter());
        //为ViewPager当前page的数字
        hViewPager.setCurrentItem(position);
        hViewPager.setOffscreenPageLimit(10);
    }

    public void getFrontPageData() {
        //点击图片的位置
        position = getIntent().getIntExtra("position", 0);
        //获取传递过来的图片地址
        mDatas = getIntent().getStringArrayListExtra("mImages");
    }


    public class ImageAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return null == mDatas ? 0 : mDatas.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //创建显示图片的控件
            PhotoView photoView = new PhotoView(container.getContext());
            //设置背景颜色
            photoView.setBackgroundColor(Color.BLACK);
            photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            //把photoView添加到viewpager中，并设置布局参数
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            //加载当前PhtotoView要显示的数据
            String url = mDatas.get(position);

            if (!TextUtils.isEmpty(url)) {
                //使用使用Glide进行加载图片进行加载图片
                Glide.clear(photoView);
                Glide.with(PhotoShowActivity.this).load(url).placeholder(R.drawable.anim_typoon).into(photoView);
            }

            //图片单击事件的处理
            photoView.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
                @Override
                public void onViewTap(View view, float x, float y) {
                    finish();
                }
            });
            return photoView;
        }

    }
}