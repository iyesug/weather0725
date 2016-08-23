package com.vis.custom.customersmanage.view;

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

import com.squareup.leakcanary.RefWatcher;
import com.vis.custom.customersmanage.R;
import com.vis.custom.customersmanage.presenter.RecyclerViewAdapter;
import com.vis.custom.customersmanage.presenter.StaggeredViewAdapter;
import com.vis.custom.customersmanage.util.Application;
import com.vis.custom.customersmanage.util.Config;

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
                startActivity(new Intent(getActivity(), TodayActivity.class));
                break;
            case 8:
                startActivity(new Intent(getActivity(), TodayActivity.class));
                break;
            case 9:
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
        RefWatcher refWatcher = Application.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
