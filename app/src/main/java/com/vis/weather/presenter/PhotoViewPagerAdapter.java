package com.vis.weather.presenter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by GaoYu on 2016/7/28.
 */
public class PhotoViewPagerAdapter extends  PagerAdapter {

    ArrayList<ImageView> mImages;
    ViewPager vp;

    public PhotoViewPagerAdapter(ArrayList<ImageView> mImages, ViewPager vp) {
        this.mImages = mImages;
        this.vp = vp;
    }

    @Override
    public int getCount() {
        return null == mImages ? 0 : mImages.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView iv = mImages.get(position);
        vp.removeView(iv);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = mImages.get(position);
        vp.addView(iv);
        return mImages.get(position);
    }
}