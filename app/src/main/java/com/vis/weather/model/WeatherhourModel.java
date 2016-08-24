package com.vis.weather.model;

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
     * 降雨
     * 风速
     * 湿度
     * 能见
     * 气压
     *
     */
    private int id;
    private String date;
    private String hour;
    private String weather;
    private String temp;
    private String rain;
    private String speed;
    private String humidity;
    private String visibility;
    private String pressure;



    public WeatherhourModel() {

    }

    public WeatherhourModel(String date, String hour, String weather, String temp) {

        this.date = date;
        this.hour = hour;
        this.weather = weather;
        this.temp = temp;
    }

    public WeatherhourModel(String date, String hour, String weather, String temp,
                            String rain, String speed, String humidity, String visibility, String pressure) {

        this.date = date;
        this.hour = hour;
        this.weather = weather;
        this.temp = temp;
        this.rain = rain;
        this.speed = speed;
        this.humidity = humidity;
        this.visibility = visibility;
        this.pressure = pressure;
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

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }
}
