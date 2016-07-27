package com.vis.custom.customersmanage.model;

/**
 * Created by Administrator on 2016/7/12.
 */
public  class WeatherhourModel {
    /**
     * 逐时预报
     * id
     * 日期
     * 小时
     * 天气
     * 温度
     * 日期
     */
    private int id;
    private String date;
    private String hour;
    private String weather;
    private String temp;


    public WeatherhourModel() {

    }

    public WeatherhourModel(String date, String hour, String weather, String temp) {

        this.date = date;
        this.hour = hour;
        this.weather = weather;
        this.temp = temp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
