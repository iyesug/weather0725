package com.vis.weather.notification;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vis.weather.R;
import com.vis.weather.model.Report;

import java.util.List;

/**
 * Created by GaoYu on 2016/8/25.
 */
public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.MyViewHolder> {


    private  List<Report> list;
    private LayoutInflater mInflater;
    private List<Integer> mHeights;
    private Context mContext;
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    public ReportAdapter(Context context,  List<Report> list) {
        this.list = list;
        mContext = context;
        mInflater = LayoutInflater.from(context);


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(
                R.layout.notificationlist_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        //设置随机高度
//        ViewGroup.LayoutParams lp = holder.imageView.getLayoutParams();
//        lp.height = mHeights.get(position);
//        holder.imageView.setLayoutParams(lp);
        if(list!=null){

            holder.tv.setText(list.get(position).getTitle());
        }
//        Glide.with(mContext)
//                .load(list.get(position).getPicPath())
////                .centerCrop()
////                .placeholder(R.drawable.loading)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.imageView);

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
//                    removeData(pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();

        }
        return 0;
    }

    //    public void addData(int position)
//    {
//        mDatas.add(position, "Insert One");
//        notifyItemInserted(position);
//    }
//
//
    public void removeData(int position)
    {
//        mDatas.remove(position);//List或ArrayList才有添加移除方法

        notifyItemRemoved(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tv;
        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.pic);
            tv = (TextView) view.findViewById(R.id.title);
        }
    }
}
