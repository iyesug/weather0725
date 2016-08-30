package com.vis.weather.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.igexin.sdk.PushManager;
import com.vis.weather.R;
import com.vis.weather.util.ShareUtil;
import com.vis.weather.view.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {
    android.support.v7.widget.SwitchCompat compat;
    ShareUtil shareUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
      shareUtil=new ShareUtil(this);
        ButterKnife.bind(this);
        compat = (android.support.v7.widget.SwitchCompat)findViewById(R.id.setting_switch);
        if(shareUtil.get("shouldPush","1").equals("1")){
            compat.setChecked(true);
        }else{
            compat.setChecked(false);
        }
        TextView title=setToolbar();
        title.setText("设置");

    }
    @OnClick(R.id.setting_response)
    public void response(){
        startActivity(new Intent(this, Advice_Activity.class));
    }
    @OnClick(R.id.setting_update)
    public void update(){

    }
    @OnClick(R.id.setting_switch)
    public void openSwitch(){
//        PushAgent mPushAgent = PushAgent.getInstance(this);
        if(!compat.isChecked()){
//            mPushAgent.disable();
            PushManager.getInstance().turnOffPush(this.getApplicationContext());

            shareUtil.put("shouldPush","0");
        }else{
//            mPushAgent.enable();
            PushManager.getInstance().turnOnPush(this.getApplicationContext());

            shareUtil.put("shouldPush","1");
        }
    }


}
