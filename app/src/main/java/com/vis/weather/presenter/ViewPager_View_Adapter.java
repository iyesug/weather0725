package com.vis.weather.presenter;


import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 */
public class ViewPager_View_Adapter extends PagerAdapter {

    private String[] mTitles;
    private List<View> mViewList;

    public ViewPager_View_Adapter(List<View> mViewList, String[] mTitles) {
        this.mViewList = mViewList;
        this.mTitles = mTitles;
    }

    @Override
    public int getCount() {
        return mViewList.size();//页卡数
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;//官方推荐写法
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewList.get(position));//添加页卡
        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.get(position));//删除页卡
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];//页卡标题
    }


}
