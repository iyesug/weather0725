package com.vis.weather.popularization;

import android.os.Bundle;

import com.vis.weather.R;
import com.vis.weather.view.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by GaoYu on 2016/9/7.
 */
public class PopularMainActivity extends BaseActivity {




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
    }
}
