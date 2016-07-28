package com.vis.custom.customersmanage.view;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.vis.custom.customersmanage.R;
import com.vis.custom.customersmanage.presenter.ViewPagerAdapter;
import com.vis.custom.customersmanage.util.base.SnackbarUtil;
import com.vis.custom.customersmanage.view.base.BaseActivity;
import com.vis.custom.customersmanage.view.base.WaitDialog;
import com.yolanda.nohttp.rest.RequestQueue;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TodayActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

//
//    @BindView(R.id.id_appbarlayout)
//    AppBarLayout idAppbarlayout;
//


//    @BindView(R.id.id_floatingactionbutton)
//    FloatingActionButton idFloatingactionbutton;
//    @BindView(R.id.id_coordinatorlayout)
//    CoordinatorLayout idCoordinatorlayout;
//    @BindView(R.id.id_navigationview)
//    NavigationView idNavigationview;
//    @BindView(R.id.id_drawerlayout)
    private DrawerLayout mDrawerl;
    private CoordinatorLayout mCoordinatorl;
    private AppBarLayout mAppbarl;
    private Toolbar mToolbar;
    @BindView(R.id.id_tablayout)
    TabLayout mTabl;
    @BindView(R.id.id_viewpager)
    ViewPager mViewpager;
    private FloatingActionButton mFloating;
    private NavigationView mNavigation;

    private String[] mTitles;
    private List<Fragment> mFragments;
    private ViewPagerAdapter mViewpageradapter;
    private WaitDialog mWaitDialog;

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view);
//        ButterKnife.bind(this);
        initView();
        initdata();
        setView();
        mFloating.setVisibility(View.GONE);

    }


    private void initView() {
        mDrawerl = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        mCoordinatorl = (CoordinatorLayout) findViewById(R.id.id_coordinatorlayout);

        mTabl = (TabLayout) findViewById(R.id.id_tablayout);
//        mToolbar= (Toolbar) findViewById(R.id.id_toolbar);
        mViewpager = (ViewPager) findViewById(R.id.id_viewpager);
        mFloating = (FloatingActionButton) findViewById(R.id.id_floatingactionbutton);
        mNavigation = (NavigationView) findViewById(R.id.id_navigationview);
        mWaitDialog = new WaitDialog(this);
    }


    private void initdata() {
        mTitles = getResources().getStringArray(R.array.today);
        mFragments = new ArrayList<>();


        for(int i=0;i<mTitles.length;i++) {

            Bundle mBundle = new Bundle();
            mBundle.putString("flag", mTitles[i]);
            TodayFragment fragment = new TodayFragment();
            fragment.setArguments(mBundle);
            mFragments.add(i, fragment);
        }

    }


    private void setView() {
//        setSupportActionBar(mToolbar);
//        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,mDrawerl,mToolbar,R.string.open,R.string.close);
//        toggle.syncState();
//        mDrawerl.setDrawerListener(toggle);

//        mNavigation.inflateHeaderView(R.layout.header);
//        mNavigation.inflateMenu(R.menu.menu);
//        itemSelected(mNavigation);

        mViewpageradapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragments, mTitles);

        mViewpager.setAdapter(mViewpageradapter);
        mViewpager.setOffscreenPageLimit(60);
        mViewpager.addOnPageChangeListener(this);

        mTabl.setTabMode(TabLayout.MODE_FIXED);
        mTabl.setupWithViewPager(mViewpager);
        // mTabl.setTabsFromPagerAdapter(mViewpageradapter);
        mFloating.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // FloatingActionButton的点击事件
            case R.id.id_floatingactionbutton:
                SnackbarUtil.show(v, getString(R.string.dot), 0);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }




}
