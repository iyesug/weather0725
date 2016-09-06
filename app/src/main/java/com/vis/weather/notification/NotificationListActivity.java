package com.vis.weather.notification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vis.weather.R;
import com.vis.weather.model.Report;
import com.vis.weather.photolist.PhotoViewActivity;
import com.vis.weather.util.DataSimulate;
import com.vis.weather.view.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by GaoYu on 2016/9/5.
 */
public class NotificationListActivity extends BaseActivity {
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private ReportAdapter adapter;
    private List<Report> list;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        TextView title=setToolbar();
        title.setText("天气通报");
        list= DataSimulate.getreport();
        adapter = new ReportAdapter(this, list);
        mRecyclerView.setAdapter(adapter);
        //瀑布流样式，在adapter里要添加随机高度
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        //GridView样式,在adapter中不要随机高度
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));
//        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        //ListView样式，在adapter中不要随机高度
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        // 设置item动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickLitener(new ReportAdapter.OnItemClickLitener(){
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(NotificationListActivity.this, PhotoViewActivity.class);
                Report report = list.get(position);
                Bundle bundle=new Bundle();

                intent.putExtra("position", position);
                startActivity(intent);

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(NotificationListActivity.this, "长按事件", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
