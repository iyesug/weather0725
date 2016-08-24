package com.vis.weather.model;

import com.baidu.mapapi.model.LatLng;

/**
 * Created by GaoYu on 2016/8/15.
 */
public class OceanWeather {


    /**
     * uid : null
     * voParams : null
     * params : null
     * voList : null
     * itemList : null
     * sid : 40287181567d576401567d578b9b0328
     * station : 59132
     * dataTime : 1470952800000
     * effDate : 1470931200000
     * weatherPhen : 阵雨转中雨
     * weatherPhenVal1 : 3
     * weatherPhenVal2 : 8
     * temp : 26到31度
     * tempVal1 : 31.0
     * tempVal2 : 26.0
     * wind : 静风
     * windDirectionVal1 : 0
     * windDirectionVal2 : 0
     * windSpeedVal1 : 0
     * windSpeedVal2 : 0
     */

    private LatLng latLng;
    private String name;
    private String date;
    private String weather;
    private int weatherVal;
    private String tempVal1;
    private String tempVal2;
    private String wind;
    private String wave;

    public OceanWeather(LatLng latLng, String name, String date, String weather, int weatherVal, String tempVal1, String tempVal2, String wind, String wave) {
        this.latLng = latLng;
        this.name = name;
        this.date = date;
        this.weather = weather;
        this.weatherVal = weatherVal;
        this.tempVal1 = tempVal1;
        this.tempVal2 = tempVal2;
        this.wind = wind;
        this.wave = wave;
    }

    public OceanWeather() {
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getWeatherVal() {
        return weatherVal;
    }

    public void setWeatherVal(int weatherVal) {
        this.weatherVal = weatherVal;
    }

    public String getTempVal1() {
        return tempVal1;
    }

    public void setTempVal1(String tempVal1) {
        this.tempVal1 = tempVal1;
    }

    public String getTempVal2() {
        return tempVal2;
    }

    public void setTempVal2(String tempVal2) {
        this.tempVal2 = tempVal2;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWave() {
        return wave;
    }

    public void setWave(String wave) {
        this.wave = wave;
    }
}
