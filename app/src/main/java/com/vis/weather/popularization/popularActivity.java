package com.vis.weather.popularization;

import android.content.Intent;
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
import com.vis.weather.notification.ReportAdapter;
import com.vis.weather.photolist.PhotoViewActivity;
import com.vis.weather.util.DataSimulate;
import com.vis.weather.util.DialogPlusUtil;
import com.vis.weather.view.base.BaseActivity;

import java.util.List;

/**
 * Created by GaoYu on 2016/9/5.
 */
public class PopularActivity extends BaseActivity {
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private ReportAdapter adapter;
    private List<Report> list;
    private DialogPlusUtil dialogPlusUtil;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        dialogPlusUtil = new DialogPlusUtil(this);
        TextView title = setToolbar();
        title.setText("气象科普");
        list = DataSimulate.getpopular();
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

        adapter.setOnItemClickLitener(new ReportAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                if(position==0){
                    String[] URLs = new String[]{
                            "http://www.sz121.com/ss/attachments/2010/05/17_2010051115323719J0o.jpg",
                            "http://www.sz121.com/ss/attachments/2010/05/17_2010051115323719J0o.jpg",

                            "http://www.sz121.com/ss/attachments/2010/05/17_2010051115323719J0o.jpg",
                            "http://www.sz121.com/ss/attachments/2010/05/17_2010051115323719J0o.jpg",
                            "http://www.sz121.com/ss/attachments/2010/05/17_2010051115323719J0o.jpg",
                            "http://www.sz121.com/ss/attachments/2010/05/17_2010051115323719J0o.jpg"
                    };
                    Intent intent = new Intent(PopularActivity.this, PhotoViewActivity.class);
                    String url = URLs[position];

                    intent.putExtra("URL", url);
                    intent.putExtra("URLs", URLs);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }else {
                    dialogPlusUtil.showMessageDialog(list.get(position).getTitle(), list.get(position).getContent());
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(PopularActivity.this, R.string.longclick, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
