package com.vis.weather.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.vis.weather.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    public Context mContext;
    public String [] mData;
    public List<String> mId;
    public LayoutInflater mLayoutinflater;
    public OnItemClickListener mOnitemclicklistener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnitemclicklistener = listener;
    }

    public  RecyclerViewAdapter(Context mContext,String [] mData){
        this.mContext = mContext;
        mLayoutinflater = LayoutInflater.from(mContext);
      this.mData=mData;
//        this.mId=mId;
        //数据源


    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView=mLayoutinflater.inflate(R.layout.item,parent,false);
        RecyclerViewHolder holder=new RecyclerViewHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        if(mOnitemclicklistener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    mOnitemclicklistener.onItemClick(holder.itemView,position);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){


                @Override
                public boolean onLongClick(View view) {
                    mOnitemclicklistener.onItemLongClick(holder.itemView,position);
                    return true;
                }
            });
        }
//        try {
////            JSONObject ob=new JSONObject(mData.get(position));
////            String str = String.format("%03d", position+1);
            holder.mTextView.setText(mData[position]);
        Resources resources = mContext.getResources();
        int png = resources.getIdentifier("list_" + (position+1), "drawable", mContext.getPackageName());
        if(png==0){
            png=R.drawable.list_3;
        }
//        holder.mImageView.setImageResource(png);
        Glide.with(mContext)
                .load(png)
                .placeholder(R.drawable.list_3)
                //  .dontAnimate()
                .into(holder.mImageView);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

    }


    @Override
    public int getItemCount() {
        if(mData!=null){
        return mData.length;
     }
        return 0;
    }

    public interface  OnItemClickListener{
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);

    }
}
