package com.vis.weather.warning;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.vis.weather.R;
import com.vis.weather.flood.FloodAdapter;
import com.vis.weather.model.Report;
import com.vis.weather.notification.ReportAdapter;
import com.vis.weather.util.DataSimulate;
import com.vis.weather.util.DialogPlusUtil;
import com.vis.weather.view.base.BaseActivity;

import java.util.List;

/**
 * Created by GaoYu on 2016/9/5.
 */
public class WarningMainActivity extends BaseActivity {
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private FloodAdapter adapter;
    private ReportAdapter adapterReport;
    private List<Report> list;
    private DialogPlusUtil dialogPlusUtil;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warning_main);
        ButterKnife.bind(this);
        dialogPlusUtil = new DialogPlusUtil(this);
        TextView title = setToolbar();
        title.setText("预警中心");
        //获取数据
        getTyphoon();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    private void getTyphoon() {
        list = null;
        adapter = new FloodAdapter(this, list);
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickLitener(new FloodAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                if(list!=null){
                dialogPlusUtil.showMessageDialog(list.get(position).getTitle(), list.get(position).getContent());
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(WarningMainActivity.this, "长按事件", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void weather(View view) {
        list = DataSimulate.getreport();
        getWeather(list);

    }
    public void publicEvent(View view) {
        list = null;
        getWeather(list);

    }
    private void getWeather(List<Report> lists) {
        this.list = lists;
        adapterReport = new ReportAdapter(this, list);
        mRecyclerView.setAdapter(adapterReport);
        adapterReport.setOnItemClickLitener(new ReportAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                if(list!=null){
                    dialogPlusUtil.showMessageDialog(list.get(position).getTitle(), list.get(position).getContent());
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(WarningMainActivity.this, "长按事件", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void typhoon(View view) {
       getTyphoon();

    }
}
