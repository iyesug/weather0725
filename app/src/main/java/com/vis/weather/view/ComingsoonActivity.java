package com.vis.weather.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.vis.weather.R;


public class ComingsoonActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comingsoon);



    }
    /**
     * 返回
     *
     * @param view
     */
    public void back(View view) {
      finish();

    }



}