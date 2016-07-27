package com.vis.custom.customersmanage.model;

import java.util.List;

/**
 * Created by GaoYu on 2016/7/22.
 */
public class DayAndHour {

    private List<WeatherDailyModel> daylist;
    private List<WeatherhourModel> hourlist;

    public DayAndHour(List<WeatherDailyModel> daylist, List<WeatherhourModel> hourlist) {
        this.daylist = daylist;
        this.hourlist = hourlist;
    }

    public List<WeatherDailyModel> getDaylist() {
        return daylist;
    }

    public void setDaylist(List<WeatherDailyModel> daylist) {
        this.daylist = daylist;
    }

    public List<WeatherhourModel> getHourlist() {
        return hourlist;
    }

    public void setHourlist(List<WeatherhourModel> hourlist) {
        this.hourlist = hourlist;
    }
}
