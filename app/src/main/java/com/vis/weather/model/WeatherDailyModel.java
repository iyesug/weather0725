package com.vis.weather.model;

/**
 * Created by Administrator on 2016/7/12.
 */
public  class WeatherDailyModel {
    /**
     * date : 2016-05-30
     * text_day : 多云
     * code_day : 4
     * text_night : 阴
     * code_night : 9
     * high : 34
     * low : 22
     */

    private String date;
    private String text_day;
    private int code_day;
    private String text_night;
    private int code_night;
    private int high;
    private int low;

    private String lacation;
    private String humidity;
    private String speed;
    private String visibility;
    private String rain;
    private String AQI;

    private String from;
    private String update;

    private String comfort;
    private String exercise;
    private String sunstroke;
    private String ultraviolet;

    public WeatherDailyModel() {
    }

    public WeatherDailyModel(String date, String text_day, int code_day, String text_night, int code_night, int high, int low) {
        this.date = date;
        this.text_day = text_day;
        this.code_day = code_day;
        this.text_night = text_night;
        this.code_night = code_night;
        this.high = high;
        this.low = low;
    }

    @Override
    public String toString() {
        return "WeatherDailyModel{" +
                "date='" + date + '\'' +
                ", text_day='" + text_day + '\'' +
                ", code_day=" + code_day +
                ", text_night='" + text_night + '\'' +
                ", code_night=" + code_night +
                ", high=" + high +
                ", low=" + low +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText_day() {
        return text_day;
    }

    public void setText_day(String text_day) {
        this.text_day = text_day;
    }

    public int getCode_day() {
        return code_day;
    }

    public void setCode_day(int code_day) {
        this.code_day = code_day;
    }

    public String getText_night() {
        return text_night;
    }

    public void setText_night(String text_night) {
        this.text_night = text_night;
    }

    public int getCode_night() {
        return code_night;
    }

    public void setCode_night(int code_night) {
        this.code_night = code_night;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }


    public String getLacation() {
        return lacation;
    }

    public void setLacation(String lacation) {
        this.lacation = lacation;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getAQI() {
        return AQI;
    }

    public void setAQI(String AQI) {
        this.AQI = AQI;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getComfort() {
        return comfort;
    }

    public void setComfort(String comfort) {
        this.comfort = comfort;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getSunstroke() {
        return sunstroke;
    }

    public void setSunstroke(String sunstroke) {
        this.sunstroke = sunstroke;
    }

    public String getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(String ultraviolet) {
        this.ultraviolet = ultraviolet;
    }


    public WeatherDailyModel(String date, String text_day, int code_day, String text_night, int code_night, int high, int low,
                             String lacation, String humidity, String speed, String visibility, String rain, String AQI, String from,
                             String update, String comfort, String exercise, String sunstroke, String ultraviolet) {
        this.date = date;
        this.text_day = text_day;
        this.code_day = code_day;
        this.text_night = text_night;
        this.code_night = code_night;
        this.high = high;
        this.low = low;
        this.lacation = lacation;
        this.humidity = humidity;
        this.speed = speed;
        this.visibility = visibility;
        this.rain = rain;
        this.AQI = AQI;
        this.from = from;
        this.update = update;
        this.comfort = comfort;
        this.exercise = exercise;
        this.sunstroke = sunstroke;
        this.ultraviolet = ultraviolet;
    }
}
