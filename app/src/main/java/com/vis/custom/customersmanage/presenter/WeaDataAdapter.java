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
import com.vis.custom.customersmanage.model.WeatherDaily;
import com.vis.custom.customersmanage.util.base.ToDate;
import com.vis.custom.customersmanage.view.base.WeatherLineView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/12.
 */
public class WeaDataAdapter extends RecyclerView.Adapter<WeaDataAdapter.WeatherDataViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<WeatherDaily.RowsBean> mDatas;
    private int mLowestTem;
    private int mHighestTem;

    public WeaDataAdapter(Context context, List<WeatherDaily.RowsBean> datats, int lowtem, int hightem) {
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
        WeatherDaily.RowsBean weatherModel = mDatas.get(position);

        String date=ToDate.getMonthByTimeStamp(weatherModel.getEffDate())+"/"+ToDate.getDayByTimeStamp(weatherModel.getEffDate());
        holder.dateText.setText(date);
        String first=weatherModel.getWeatherPhen();
        String[] weather=null;
        if(first.indexOf("转")>=0){
            weather=first.split("转");
            holder.dayText.setText(weather[0]);
            holder.nightText.setText(weather[1]);
        }else{
            holder.dayText.setText(first);
            holder.nightText.setText(first);
        }

        int iconday = resources.getIdentifier("ico_" + weatherModel.getWeatherPhenVal1(), "drawable", mContext.getPackageName());
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
        int iconight = resources.getIdentifier("ico_" + weatherModel.getWeatherPhenVal2(), "drawable", mContext.getPackageName());
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

        int low[] = new int[3];
        int high[] = new int[3];
        low[1] = (int)weatherModel.getTempVal2();
        high[1] = (int)weatherModel.getTempVal1();
        if (position <= 0) {
            low[0] = 0;
            high[0] = 0;
        } else {
            WeatherDaily.RowsBean weatherModelLeft = mDatas.get(position - 1);
            low[0] = (int)(weatherModelLeft.getTempVal2() + weatherModel.getTempVal2()) / 2;
            high[0] =(int) (weatherModelLeft.getTempVal1() + weatherModel.getTempVal1()) / 2;
        }
        if (position >= mDatas.size() - 1) {
            low[2] = 0;
            high[2] = 0;
        } else {
            WeatherDaily.RowsBean weatherModelRight = mDatas.get(position + 1);
            low[2] = (int)(weatherModel.getTempVal2() + weatherModelRight.getTempVal2()) / 2;
            high[2] = (int)(weatherModel.getTempVal1() + weatherModelRight.getTempVal1()) / 2;
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