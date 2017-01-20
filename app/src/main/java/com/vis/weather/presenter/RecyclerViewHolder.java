package com.vis.weather.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vis.weather.R;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView mTextView;
    public ImageView mImageView;
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.id_textview);
        mImageView = (ImageView) itemView.findViewById(R.id.id_img);
    }
}
