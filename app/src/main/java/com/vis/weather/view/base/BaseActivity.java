package com.vis.weather.view.base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.vis.weather.R;
import com.vis.weather.presenter.ViewPagerAdapter;
import com.vis.weather.util.Network;
import com.vis.weather.util.base.SnackbarUtil;
import com.vis.weather.view.GridFragment;
import com.vis.weather.view.RecyclerFragment;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private DrawerLayout mDrawerl;
    private TabLayout mTabl;
    private ViewPager mViewpager;
    private FloatingActionButton mFloating;
    private NavigationView mNavigation;
    private String[] mTitles;
    private List<Fragment> mFragments;
    private ViewPagerAdapter mViewpageradapter;
    public WaitDialog waitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waitDialog = new WaitDialog(this);


    }


    private void initView() {
        mDrawerl = (DrawerLayout) findViewById(R.id.id_drawerlayout);

        mTabl = (TabLayout) findViewById(R.id.id_tablayout);
//        mToolbar= (Toolbar) findViewById(R.id.id_toolbar);
        mViewpager = (ViewPager) findViewById(R.id.id_viewpager);
        mFloating = (FloatingActionButton) findViewById(R.id.id_floatingactionbutton);
        mNavigation = (NavigationView) findViewById(R.id.id_navigationview);

    }


    private void initdata() {
        mTitles = getResources().getStringArray(R.array.titles);
        mFragments = new ArrayList<>();

        Bundle mBundle = new Bundle();
        mBundle.putInt("flag", 0);
        RecyclerFragment fragment = new RecyclerFragment();
        fragment.setArguments(mBundle);
        mFragments.add(0, fragment);

        Bundle mBundle1 = new Bundle();
        mBundle.putInt("flag", 1);
        GridFragment fragment1 = new GridFragment();
        fragment1.setArguments(mBundle1);
        mFragments.add(1, fragment1);
    }

    public TextView setToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView title = (TextView) findViewById(R.id.item_name);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

//            toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));
        toolbar.setNavigationIcon(R.drawable.left);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        return title;
    }


    private void setView() {


        mNavigation.inflateHeaderView(R.layout.header);
        mNavigation.inflateMenu(R.menu.menu);
        itemSelected(mNavigation);

        mViewpageradapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragments, mTitles);

        mViewpager.setAdapter(mViewpageradapter);

        mViewpager.addOnPageChangeListener(this);

        mTabl.setTabMode(TabLayout.MODE_FIXED);
        mTabl.setupWithViewPager(mViewpager);
        mFloating.setOnClickListener(this);

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
                        if (Network.INSTANCE.getIP().equals(Network.INSTANCE.getOutIp())) {
                            Network.INSTANCE.setIP(Network.INSTANCE.getInIp());
                        } else {
                            Network.INSTANCE.setIP(Network.INSTANCE.getOutIp());
                        }

                        break;
                    case R.id.nav_menu_feedback:


                        break;
                    case R.id.nav_menu_setting:
                        msgString = (String) menuItem.getTitle();
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




    public void showMessageDialog(int title, int message) {
        showMessageDialog(getText(title), getText(message));
    }

    public void showMessageDialog(int title, CharSequence message) {
        showMessageDialog(getText(title), message);
    }

    public void showMessageDialog(CharSequence title, int message) {
        showMessageDialog(title, getText(message));
    }

    public void showMessageDialog(CharSequence title, CharSequence message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.know, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }


}
