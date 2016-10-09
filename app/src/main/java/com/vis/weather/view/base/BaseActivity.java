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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.vis.weather.R;
import com.vis.weather.presenter.ViewPagerAdapter;
import com.vis.weather.util.CallServer;
import com.vis.weather.util.Config;
import com.vis.weather.util.HttpListener;
import com.vis.weather.util.base.SnackbarUtil;
import com.vis.weather.view.GridFragment;
import com.vis.weather.view.RecyclerFragment;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity  implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private DrawerLayout mDrawerl;
    private TabLayout mTabl;
    private ViewPager mViewpager;
    private FloatingActionButton mFloating;
    private NavigationView mNavigation;

    private String [] mTitles;
    private List<Fragment> mFragments;
    private ViewPagerAdapter mViewpageradapter;
public WaitDialog waitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waitDialog=new WaitDialog(this);


    }


    private void initView() {
        mDrawerl= (DrawerLayout) findViewById(R.id.id_drawerlayout);

        mTabl= (TabLayout) findViewById(R.id.id_tablayout);
//        mToolbar= (Toolbar) findViewById(R.id.id_toolbar);
        mViewpager= (ViewPager) findViewById(R.id.id_viewpager);
        mFloating= (FloatingActionButton) findViewById(R.id.id_floatingactionbutton);
        mNavigation= (NavigationView) findViewById(R.id.id_navigationview);

    }


    private void initdata() {
        mTitles=getResources().getStringArray(R.array.titles);
        mFragments=new ArrayList<>();

            Bundle mBundle=new Bundle();
            mBundle.putInt("flag",0);
            RecyclerFragment fragment=new RecyclerFragment();
            fragment.setArguments(mBundle);
            mFragments.add(0,fragment);

        Bundle mBundle1=new Bundle();
        mBundle.putInt("flag",1);
        GridFragment fragment1=new GridFragment();
        fragment1.setArguments(mBundle1);
        mFragments.add(1,fragment1);
    }
    public TextView setToolbar(){

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

        mViewpageradapter=new ViewPagerAdapter(getSupportFragmentManager(),mFragments,mTitles);

        mViewpager.setAdapter(mViewpageradapter);

        mViewpager.addOnPageChangeListener(this);

        mTabl.setTabMode(TabLayout.MODE_FIXED);
        mTabl.setupWithViewPager(mViewpager);
        mFloating.setOnClickListener(this);

    }
    private void itemSelected(NavigationView mNav) {
        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(MenuItem menuItem) {

                String msgString = "";

                switch (menuItem.getItemId()) {
                    case R.id.nav_menu_home:
                        msgString = (String) menuItem.getTitle();
                        break;
                    case R.id.nav_menu_categories:


                        // 创建请求对象。
                        Request<String> request = NoHttp.createStringRequest(Config.URL, RequestMethod.POST);

                        // 添加请求参数。
                        request.add("do", 3);
                        request.add("what", "c");

                        CallServer.getRequestInstance().add(BaseActivity.this, 0, request, httpListener, true, true);



                        break;
                    case R.id.nav_menu_feedback:

                        Request<String> request1 = NoHttp.createStringRequest(Config.URL, RequestMethod.POST);
                        // 添加请求参数。
                        request1.add("do", 3);
                        request1.add("what", "c");
                        // 添加到请求队列
                        CallServer.getRequestInstance().add(BaseActivity.this, 0, request1, httpListener, true, true);



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



    private HttpListener<String> httpListener = new HttpListener<String>() {

        @Override
        public void onSucceed(int what, Response<String> response) {
            int responseCode = response.getHeaders().getResponseCode();// 服务器响应码
            if (responseCode == 200) {
                if (RequestMethod.HEAD == response.getRequestMethod())// 请求方法为HEAD时没有响应内容
                    showMessageDialog(R.string.request_succeed, R.string.request_method_head);
                else{
                    String res=response.get();
                    showMessageDialog(R.string.request_succeed, res);
                    System.out.print(res);
                    Log.i("Json",res);
                    try {
                        JSONArray js=new JSONArray(res);
                        JSONObject jo=js.getJSONObject(0);
                        res=jo.getString("c_adr");
                        Log.i("Json",res);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

        @Override
        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
            showMessageDialog(R.string.request_failed, exception.getMessage());
            SnackbarUtil.show(mViewpager, "请求失败: " + exception.getMessage(), 0);
        }
    };



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
