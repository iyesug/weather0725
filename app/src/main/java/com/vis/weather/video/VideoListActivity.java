package com.vis.weather.video;

import android.app.Activity;
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
import com.vis.weather.util.DataSimulate;
import com.vis.weather.util.DialogPlusUtil;
import com.vis.weather.view.PLVideoTextureActivity;
import com.vis.weather.view.base.BaseActivity;

import java.util.List;

/**
 * Created by GaoYu on 2016/9/5.
 */
public class VideoListActivity extends BaseActivity {
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private ReportAdapter adapter;
    private List<Report> list;
    private DialogPlusUtil dialogPlusUtil;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videolist);
        ButterKnife.bind(this);
        dialogPlusUtil=new DialogPlusUtil(this);
        TextView title=setToolbar();
        title.setText("视频预报");
        list= DataSimulate.getVideo();
        adapter = new ReportAdapter(this, list);
        mRecyclerView.setAdapter(adapter)
        ;
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
                Intent intent = new Intent(VideoListActivity.this,PLVideoTextureActivity.class);
//                Intent intent = new Intent(VideoFileActivity.this,VideoViewActivity.class);
                intent.putExtra("videoPath",list.get(position).getContent() );
                setResult(Activity.RESULT_OK, intent);
                startActivity(intent);

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(VideoListActivity.this, "长按事件", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
