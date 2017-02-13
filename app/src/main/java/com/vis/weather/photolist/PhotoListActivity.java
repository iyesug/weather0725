package com.vis.weather.photolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.vis.weather.R;
import com.vis.weather.view.base.BaseActivity;

/**
 * Created by GaoYu on 2016/8/25.
 */
public class PhotoListActivity extends BaseActivity{

    private RecyclerView mRecyclerView;
    private PhotoListAdapter adapter;
    private String[] URLs = new String[]{
            "http://pic3.nipic.com/20090617/1242397_083514091_2.jpg",
            "http://pic28.nipic.com/20130422/12457151_164027506188_2.jpg",

            "http://pica.nipic.com/2007-11-15/20071115103157516_2.jpg",
            "http://pic6.nipic.com/20100427/4365846_231110093316_2.jpg",
            "http://a2.att.hudong.com/79/22/01000000000000119062273272179.jpg",
            "http://img4.duitang.com/uploads/item/201209/20/20120920165508_EuenZ.jpeg"
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photolist_activity);
        TextView title=setToolbar();
        title.setText("天气图像");
        mRecyclerView = (RecyclerView) findViewById(R.id.myrecycler_layout);
        adapter = new PhotoListAdapter(this, URLs);
        mRecyclerView.setAdapter(adapter);
        //瀑布流样式，在adapter里要添加随机高度
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        //GridView样式,在adapter中不要随机高度
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));
//        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        //ListView样式，在adapter中不要随机高度
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        // 设置item动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickLitener(new PhotoListAdapter.OnItemClickLitener(){
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(PhotoListActivity.this, PhotoViewActivity.class);
                String url = URLs[position];
                intent.putExtra("URL", url);
                intent.putExtra("URLs", URLs);
                intent.putExtra("position", position);
                startActivity(intent);

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(PhotoListActivity.this, "长按事件", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
