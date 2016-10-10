package com.vis.weather.flood;

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
import com.vis.weather.model.Report;
import com.vis.weather.util.DialogPlusUtil;
import com.vis.weather.view.base.BaseActivity;

import java.util.List;

/**
 * Created by GaoYu on 2016/9/5.
 */
public class FloodListActivity extends BaseActivity {
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private FloodAdapter adapter;
    private List<Report> list;
    private DialogPlusUtil dialogPlusUtil;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        dialogPlusUtil = new DialogPlusUtil(this);
        TextView title = setToolbar();
        title.setText("汛情简报");
        //获取数据
        list = null;


        adapter = new FloodAdapter(this, list);
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

        adapter.setOnItemClickLitener(new FloodAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                dialogPlusUtil.showMessageDialog(list.get(position).getTitle(), list.get(position).getContent());

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(FloodListActivity.this, "长按事件", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
