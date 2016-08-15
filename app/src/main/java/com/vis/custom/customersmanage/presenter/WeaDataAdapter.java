package com.vis.custom.customersmanage.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vis.custom.customersmanage.R;
import com.vis.custom.customersmanage.model.WeatherDailyModel;
import com.vis.custom.customersmanage.view.base.WeatherLineView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/12.
 */
public class WeaDataAdapter extends RecyclerView.Adapter<WeaDataAdapter.WeatherDataViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<WeatherDailyModel> mDatas;
    private int mLowestTem;
    private int mHighestTem;

    public WeaDataAdapter(Context context, List<WeatherDailyModel> datats, int lowtem, int hightem) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDatas = datats;
        mLowestTem = lowtem;
        mHighestTem = hightem;
    }

    @Override
    public WeatherDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.re_item, parent, false);
        WeatherDataViewHolder viewHolder = new WeatherDataViewHolder(view);
        viewHolder.dayText = (TextView) view.findViewById(R.id.id_day_text_tv);
        viewHolder.dayIcon = (ImageView) view.findViewById(R.id.id_day_icon_iv);
        viewHolder.weatherLineView = (WeatherLineView) view.findViewById(R.id.wea_line);
        viewHolder.nighticon = (ImageView) view.findViewById(R.id.id_night_icon_iv);
        viewHolder.nightText = (TextView) view.findViewById(R.id.id_night_text_tv);
        viewHolder.dateText = (TextView) view.findViewById(R.id.id_date_text_tv);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherDataViewHolder holder, int position) {
        // 最低温度设置为15，最高温度设置为30
        Resources resources = mContext.getResources();
        WeatherDailyModel weatherModel = mDatas.get(position);
        String[] s=weatherModel.getDate().split("-");
        String date=s[1]+"/"+s[2];
        holder.dateText.setText(date);
        holder.dayText.setText(weatherModel.getText_day());
        int iconday = resources.getIdentifier("ico_" + weatherModel.getCode_day(), "drawable", mContext.getPackageName());
        if (iconday == 0) {
            Glide.with(mContext)
                    .load(R.drawable.ico_1)
                    //  .dontAnimate()
                    .into(holder.dayIcon);
          //  holder.dayIcon.setImageResource(R.drawable.ico_1);
        } else {
            Glide.with(mContext)
                    .load(iconday)
                   // .dontAnimate()
                    .into(holder.dayIcon);
           // holder.dayIcon.setImageResource(iconday);
        }
        holder.weatherLineView.setLowHighestData(mLowestTem, mHighestTem);
        int iconight = resources.getIdentifier("ico_" + weatherModel.getCode_night(), "drawable", mContext.getPackageName());
        if (iconight == 0) {
            Glide.with(mContext)
                    .load(R.drawable.ico_1)
                  //  .dontAnimate()
                    .into(holder.nighticon);

          //  holder.nighticon.setImageResource(R.drawable.ico_1);
        } else {
            Glide.with(mContext)
                    .load(iconight)
                   // .dontAnimate()
                    .into(holder.nighticon);
            holder.nighticon.setImageResource(iconight);
        }
        holder.nightText.setText(weatherModel.getText_night());
        int low[] = new int[3];
        int high[] = new int[3];
        low[1] = weatherModel.getLow();
        high[1] = weatherModel.getHigh();
        if (position <= 0) {
            low[0] = 0;
            high[0] = 0;
        } else {
            WeatherDailyModel weatherModelLeft = mDatas.get(position - 1);
            low[0] = (weatherModelLeft.getLow() + weatherModel.getLow()) / 2;
            high[0] = (weatherModelLeft.getHigh() + weatherModel.getHigh()) / 2;
        }
        if (position >= mDatas.size() - 1) {
            low[2] = 0;
            high[2] = 0;
        } else {
            WeatherDailyModel weatherModelRight = mDatas.get(position + 1);
            low[2] = (weatherModel.getLow() + weatherModelRight.getLow()) / 2;
            high[2] = (weatherModel.getHigh() + weatherModelRight.getHigh()) / 2;
        }
        holder.weatherLineView.setLowHighData(low, high);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class WeatherDataViewHolder extends RecyclerView.ViewHolder {

        TextView dayText;
        ImageView dayIcon;
        WeatherLineView weatherLineView;
        ImageView nighticon;
        TextView nightText;
        TextView dateText;
        public WeatherDataViewHolder(View itemView) {
            super(itemView);
        }
    }
}