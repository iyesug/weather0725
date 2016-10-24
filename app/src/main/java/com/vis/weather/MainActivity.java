package com.vis.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.*;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.igexin.sdk.PushManager;
import com.vis.weather.presenter.ViewPagerAdapter;
import com.vis.weather.util.Network;
import com.vis.weather.util.ShareUtil;
import com.vis.weather.util.base.SnackbarUtil;
import com.vis.weather.util.base.guide.HighLightGuideView;
import com.vis.weather.view.Advice_Activity;
import com.vis.weather.view.GridFragment;
import com.vis.weather.view.RecyclerFragment;
import com.vis.weather.view.SettingActivity;
import com.vis.weather.view.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {


    @BindView(R.id.id_appbarlayout)
    AppBarLayout idAppbarlayout;


    @BindView(R.id.id_floatingactionbutton)
    FloatingActionButton idFloatingactionbutton;
    @BindView(R.id.id_coordinatorlayout)
    CoordinatorLayout idCoordinatorlayout;
    @BindView(R.id.id_navigationview)
    NavigationView idNavigationview;
    @BindView(R.id.id_drawerlayout)
    DrawerLayout mDrawerl;
    private CoordinatorLayout mCoordinatorl;

    private Toolbar mToolbar;
    @BindView(R.id.id_tablayout)
    TabLayout mTabl;
    @BindView(R.id.id_viewpager)
    ViewPager mViewpager;
    private FloatingActionButton mFloating;
    private NavigationView mNavigation;
    GridFragment fragment1;
    private String[] mTitles;
    private List<Fragment> mFragments;
    private ViewPagerAdapter mViewpageradapter;



    private boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ActivityCompat
                .requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION}, 0);

        initView();
        initdata();
        setView();
        PushManager.getInstance().initialize(this.getApplicationContext());

    }

    private void initView() {
        mDrawerl = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        mCoordinatorl = (CoordinatorLayout) findViewById(R.id.id_coordinatorlayout);

        mTabl = (TabLayout) findViewById(R.id.id_tablayout);
//        mToolbar= (Toolbar) findViewById(R.id.id_toolbar);
        mViewpager = (ViewPager) findViewById(R.id.id_viewpager);
        mFloating = (FloatingActionButton) findViewById(R.id.id_floatingactionbutton);
        mNavigation = (NavigationView) findViewById(R.id.id_navigationview);


        ShareUtil shareUtil = new ShareUtil(MainActivity.this);
        isFirst = shareUtil.get("isFirst", true);
        if (isFirst) {
            isFirst = false;
            shareUtil.put("isFirst", isFirst);
            HighLightGuideView.builder(this)
                    .addHighLightGuidView(mTabl, R.drawable.tip)
                    .setHighLightStyle(HighLightGuideView.VIEWSTYLE_RECT)
                    .show();
        }
    }


    private void initdata() {
        mTitles = getResources().getStringArray(R.array.titles);
        mFragments = new ArrayList<>();

        Bundle mBundle = new Bundle();
        mBundle.putString("flag", mTitles[0]);
        RecyclerFragment fragment = new RecyclerFragment();
        fragment.setArguments(mBundle);
        mFragments.add(0, fragment);

        Bundle mBundle1 = new Bundle();
        mBundle.putString("flag", mTitles[1]);
        fragment1 = new GridFragment();

        fragment1.setArguments(mBundle1);
        mFragments.add(1, fragment1);
    }


    private void setView() {
//        setSupportActionBar(mToolbar);
//        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,mDrawerl,mToolbar,R.string.open,R.string.close);
//        toggle.syncState();
//        mDrawerl.setDrawerListener(toggle);

        mNavigation.inflateHeaderView(R.layout.header);
        mNavigation.inflateMenu(R.menu.menu);
        itemSelected(mNavigation);

        mViewpageradapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragments, mTitles);

        mViewpager.setAdapter(mViewpageradapter);
        mViewpager.setOffscreenPageLimit(6);
        mViewpager.addOnPageChangeListener(this);

        mTabl.setTabMode(TabLayout.MODE_FIXED);
        mTabl.setupWithViewPager(mViewpager);
        // mTabl.setTabsFromPagerAdapter(mViewpageradapter);
        mFloating.setOnClickListener(this);

        mFloating.setVisibility(View.GONE);

    }


    public void setbackground(int i) {
        mCoordinatorl.setBackgroundResource(i);

    }


    private void itemSelected(NavigationView mNav) {
        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                String msgString = "";

                switch (menuItem.getItemId()) {
                    case R.id.nav_menu_home:
                        msgString = (String) menuItem.getTitle();
                        break;
                    case R.id.swift:
                        if(Network.INSTANCE.getIP().equals(Network.INSTANCE.getOutIp())){
                            Network.INSTANCE.setIP(Network.INSTANCE.getInIp());
                            System.out.println(Network.INSTANCE.getIP());
                        }else{
                            Network.INSTANCE.setIP(Network.INSTANCE.getOutIp());
                            System.out.println(Network.INSTANCE.getIP());                        }


                        break;
                    case R.id.nav_menu_feedback:

                        startActivity(new Intent(MainActivity.this, Advice_Activity.class));
                        break;
                    case R.id.nav_menu_setting:
                        startActivity(new Intent(MainActivity.this, SettingActivity.class));
                        break;
                    case R.id.nav_menu_share:

                        break;

                }


                menuItem.setChecked(true);
                mDrawerl.closeDrawers();

                SnackbarUtil.show(mViewpager, msgString, 0);

                return true;
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // FloatingActionButton的点击事件
            case R.id.id_floatingactionbutton:
            if(fragment1!=null&&fragment1.getView()!=null){

                RecyclerView mEasyRecyclerView = (RecyclerView) fragment1.getView().findViewById(R.id.easy_recyclerview);
//                mEasyRecyclerView.scrollToPosition(0);
                mEasyRecyclerView.smoothScrollToPosition(0);
            }
//                SnackbarUtil.show(v, getString(R.string.dot), 0);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            mFloating.setVisibility(View.GONE);
        } else if (position == 1) {
            mFloating.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }




}
