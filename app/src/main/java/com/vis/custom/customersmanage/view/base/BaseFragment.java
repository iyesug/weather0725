package com.vis.custom.customersmanage.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.vis.custom.customersmanage.R;
import com.vis.custom.customersmanage.presenter.RecyclerViewAdapter;
import com.vis.custom.customersmanage.presenter.StaggeredViewAdapter;
import com.vis.custom.customersmanage.util.Config;

import butterknife.ButterKnife;
import rx.Subscription;


public class BaseFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, RecyclerViewAdapter.OnItemClickListener,
        StaggeredViewAdapter.OnItemClickListener{
    protected Subscription subscription;
    private EasyRecyclerView mEasyRecyclerView;
    private View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_main, container, false);
        mEasyRecyclerView = (EasyRecyclerView) mView.findViewById(R.id.easy_recyclerview);
        ButterKnife.bind(this,mView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), Config.SPAN_COUNT, GridLayoutManager.VERTICAL, false);


        String[] mTitles=getResources().getStringArray(R.array.list);
        RecyclerViewAdapter mRecyclerviewadapter = new RecyclerViewAdapter(getActivity(),mTitles);
        mRecyclerviewadapter.setOnItemClickListener(this);
        mEasyRecyclerView.setAdapter(mRecyclerviewadapter);

        mEasyRecyclerView.setLayoutManager(mLayoutManager);

        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        mEasyRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));


    }





    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {

    }

    @Override
    public void onRefresh() {

    }
}
