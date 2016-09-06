package com.vis.weather.model;

/**
 * Created by GaoYu on 2016/9/5.
 */
public class Report {
  //  预警信息	站点编号	时间	标题	预警图像编码	预警内文	防御指南
    private int id;
    private String station;
    private long dataTime;
    private String title;
    private int warning;
    private String picPath;
    private String content;
    private String other;


    public Report() {
    }

    public Report(String station, long dataTime, String title, String content, String picPath) {
        this.station = station;
        this.dataTime = dataTime;
        this.title = title;
        this.content = content;
        this.picPath = picPath;
    }

    public Report(int id, String station, long dataTime, String title, int warning, String picPath, String content, String other) {
        this.id = id;
        this.station = station;
        this.dataTime = dataTime;
        this.title = title;
        this.warning = warning;
        this.picPath = picPath;
        this.content = content;
        this.other = other;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public long getDataTime() {
        return dataTime;
    }

    public void setDataTime(long dataTime) {
        this.dataTime = dataTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWarning() {
        return warning;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", station='" + station + '\'' +
                ", dataTime=" + dataTime +
                ", title='" + title + '\'' +
                ", warning=" + warning +
                ", picPath='" + picPath + '\'' +
                ", content='" + content + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

}
