package com.vis.weather.popularization;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.vis.weather.R;
import com.vis.weather.notification.NotificationListActivity;
import com.vis.weather.view.base.BaseActivity;

import java.util.List;

/**
 * Created by GaoYu on 2016/9/7.
 */
public class PopularMainActivity extends BaseActivity {
    @BindViews({R.id.iv_1, R.id.iv_2, R.id.iv_3, R.id.iv_4, R.id.iv_5, R.id.iv_6})
    List<TextView> imageViewList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_main);
        ButterKnife.bind(this);
        TextView tv;

        for (int i = 0; i < imageViewList.size(); i++) {
            int icon = getResources().getIdentifier("list_" + (i + 1), "drawable", getPackageName());
            tv = imageViewList.get(i);


//            tv.setBackgroundResource(icon);
        }

        TextView title = setToolbar();
        title.setText("气象科普");
        imageViewList.get(0);

    }

    @OnClick(R.id.iv_1)
    void unscramble() {
        startActivity(new Intent(this, NotificationListActivity.class));
    }

    @OnClick(R.id.iv_2)
    void prevent() {
        startActivity(new Intent(this, NotificationListActivity.class));
    }

    @OnClick(R.id.iv_3)
    void picture() {
        startActivity(new Intent(this, NotificationListActivity.class));
    }

    @OnClick(R.id.iv_4)
    void health() {
        startActivity(new Intent(this, NotificationListActivity.class));
    }

    @OnClick(R.id.iv_5)
    void encyclopedia() {
        startActivity(new Intent(this, NotificationListActivity.class));
    }

    @OnClick(R.id.iv_6)
    void astronomy() {
        startActivity(new Intent(this, NotificationListActivity.class));
    }
}
