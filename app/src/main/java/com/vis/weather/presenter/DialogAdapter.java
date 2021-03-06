package com.vis.weather.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vis.weather.R;

import java.util.List;

public class DialogAdapter extends BaseAdapter {

  private LayoutInflater layoutInflater;
  private boolean isGrid;
  private List mTitles;

  public DialogAdapter(Context context, boolean isGrid,List mTitles) {
    layoutInflater = LayoutInflater.from(context);
    this.isGrid = isGrid;
    this. mTitles=mTitles;
  }

  @Override
  public int getCount() {
    return mTitles.size();
  }

  @Override
  public Object getItem(int position) {
    return position;
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    View view = convertView;

    if (view == null) {
      if (isGrid) {
        view = layoutInflater.inflate(R.layout.simple_grid_item, parent, false);
      } else {
        view = layoutInflater.inflate(R.layout.simple_list_item, parent, false);
      }

      viewHolder = new ViewHolder();
      viewHolder.textView = (TextView) view.findViewById(R.id.text_view);
      viewHolder.imageView = (ImageView) view.findViewById(R.id.image_view);
      view.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) view.getTag();
    }


        viewHolder.textView.setText(mTitles.get(position).toString());
        viewHolder.imageView.setImageResource(R.drawable.ico_0);



    return view;
  }

  static class ViewHolder {
    TextView textView;
    ImageView imageView;
  }
}
