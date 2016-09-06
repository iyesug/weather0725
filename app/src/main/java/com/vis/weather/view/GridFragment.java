package com.vis.weather.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vis.weather.R;
import com.vis.weather.notification.NotificationListActivity;
import com.vis.weather.photolist.PhotoListActivity;
import com.vis.weather.presenter.RecyclerViewAdapter;
import com.vis.weather.presenter.StaggeredViewAdapter;
import com.vis.weather.util.Config;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GridFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, RecyclerViewAdapter.OnItemClickListener,
        StaggeredViewAdapter.OnItemClickListener{
    @BindView (R.id.easy_recyclerview)
    RecyclerView mEasyRecyclerView;
    private View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,mView);


        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mEasyRecyclerView = (RecyclerView) mView.findViewById(R.id.easy_recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), Config.SPAN_COUNT, GridLayoutManager.VERTICAL, false);


        String[] mTitles=getResources().getStringArray(R.array.list);
        RecyclerViewAdapter mRecyclerviewadapter = new RecyclerViewAdapter(getActivity(),mTitles);
        mRecyclerviewadapter.setOnItemClickListener(this);
        mEasyRecyclerView.setAdapter(mRecyclerviewadapter);
        mEasyRecyclerView.setLayoutManager(mLayoutManager);
//        mEasyRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
//

    }


    private void setView() {}


    @Override
    public void onItemClick(View view, int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(getActivity(), TodayActivity.class));
                break;
            case 1:
                startActivity(new Intent(getActivity(), RadarActivity.class));
                break;
            case 2:
                startActivity(new Intent(getActivity(), QuanzhouDistrictSearch.class));
                break;
            case 3:
                startActivity(new Intent(getActivity(),LocationActivity.class));
                break;
            case 4:
                startActivity(new Intent(getActivity(), TyphoonActivity.class));
                break;
            case 5:
                startActivity(new Intent(getActivity(), VideoFileActivity.class));
                break;
            case 6:
                startActivity(new Intent(getActivity(), OceanActivity.class));
                break;
            case 7:
                startActivity(new Intent(getActivity(), PhotoListActivity.class));
                break;
            case 8:
                startActivity(new Intent(getActivity(), NotificationListActivity.class));
                break;
            case 9:
                startActivity(new Intent(getActivity(), TodayActivity.class));
                break;
            case 10:
                startActivity(new Intent(getActivity(), VideoFileActivity.class));
                break;
            case 11:
                startActivity(new Intent(getActivity(), OceanActivity.class));
                break;
            case 12:
                startActivity(new Intent(getActivity(), PhotoListActivity.class));
                break;
            case 13:
                startActivity(new Intent(getActivity(), NotificationListActivity.class));
                break;
            case 14:
                startActivity(new Intent(getActivity(), TodayActivity.class));
                break;
        }
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        RefWatcher refWatcher = Application.getRefWatcher(getActivity());
//        refWatcher.watch(this);
    }
}
