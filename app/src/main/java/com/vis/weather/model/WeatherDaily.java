package com.vis.weather.model;

import java.util.List;

/**
 * Created by GaoYu on 2016/8/15.
 */
public class WeatherDaily {


    /**
     * total : 19
     * rows : [{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181567d576401567d578b9b0328","station":"59132","dataTime":1470952800000,"effDate":1470931200000,"weatherPhen":"阵雨转中雨","weatherPhenVal1":3,"weatherPhenVal2":8,"temp":"26到31度","tempVal1":31,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181567d576401567d578b9b0329","station":"59132","dataTime":1470952800000,"effDate":1471017600000,"weatherPhen":"阵雨","weatherPhenVal1":3,"weatherPhenVal2":3,"temp":"26到30度","tempVal1":30,"tempVal2":26,"wind":"东北风3-4级","windDirectionVal1":0,"windDirectionVal2":1,"windSpeedVal1":0,"windSpeedVal2":1},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181567d576401567d578b9b032a","station":"59132","dataTime":1470952800000,"effDate":1471104000000,"weatherPhen":"阴转阵雨","weatherPhenVal1":2,"weatherPhenVal2":3,"temp":"27到32度","tempVal1":32,"tempVal2":27,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181567d576401567d58daa62b51","station":"59132","dataTime":1470967200000,"effDate":1470931200000,"weatherPhen":"阵雨转中雨","weatherPhenVal1":3,"weatherPhenVal2":8,"temp":"26到31度","tempVal1":31,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181567d576401567d58daa72b52","station":"59132","dataTime":1470967200000,"effDate":1471017600000,"weatherPhen":"阵雨","weatherPhenVal1":3,"weatherPhenVal2":3,"temp":"26到30度","tempVal1":30,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181567d576401567d58daa72b53","station":"59132","dataTime":1470967200000,"effDate":1471104000000,"weatherPhen":"阴转阵雨","weatherPhenVal1":2,"weatherPhenVal2":3,"temp":"27到32度","tempVal1":32,"tempVal2":27,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"4028718156890ff60156891036a50330","station":"59132","dataTime":1471140000000,"effDate":1471104000000,"weatherPhen":"阵雨","weatherPhenVal1":3,"weatherPhenVal2":3,"temp":"26到32度","tempVal1":32,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"4028718156890ff60156891036a50331","station":"59132","dataTime":1471140000000,"effDate":1471190400000,"weatherPhen":"阵雨转多云","weatherPhenVal1":3,"weatherPhenVal2":1,"temp":"26到32度","tempVal1":32,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"4028718156890ff60156891036a60332","station":"59132","dataTime":1471140000000,"effDate":1471276800000,"weatherPhen":"多云","weatherPhenVal1":1,"weatherPhenVal2":1,"temp":"26到33度","tempVal1":33,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"4028718156890ff6015689114ee92f78","station":"59132","dataTime":1471161600000,"effDate":1471190400000,"weatherPhen":"阵雨转阴","weatherPhenVal1":3,"weatherPhenVal2":2,"temp":"27到33度","tempVal1":33,"tempVal2":27,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"4028718156890ff6015689114ee92f79","station":"59132","dataTime":1471161600000,"effDate":1471276800000,"weatherPhen":"阵雨","weatherPhenVal1":3,"weatherPhenVal2":3,"temp":"26到32度","tempVal1":32,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"4028718156890ff6015689114ee92f7a","station":"59132","dataTime":1471161600000,"effDate":1471363200000,"weatherPhen":"阵雨转阴","weatherPhenVal1":3,"weatherPhenVal2":2,"temp":"26到32度","tempVal1":32,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"4028718156890ff6015689114ee92f7b","station":"59132","dataTime":1471161600000,"effDate":1471449600000,"weatherPhen":"阴转阵雨","weatherPhenVal1":2,"weatherPhenVal2":3,"temp":"26到32度","tempVal1":32,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"4028718156890ff6015689114ee92f7c","station":"59132","dataTime":1471161600000,"effDate":1471536000000,"weatherPhen":"多云","weatherPhenVal1":1,"weatherPhenVal2":1,"temp":"26到34度","tempVal1":34,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"4028718156890ff6015689114ee92f7d","station":"59132","dataTime":1471161600000,"effDate":1471622400000,"weatherPhen":"多云","weatherPhenVal1":1,"weatherPhenVal2":1,"temp":"27到33度","tempVal1":33,"tempVal2":27,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"4028718156890ff6015689114ee92f7e","station":"59132","dataTime":1471161600000,"effDate":1471708800000,"weatherPhen":"阴转多云","weatherPhenVal1":2,"weatherPhenVal2":1,"temp":"26到33度","tempVal1":33,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"402880ea56894238015689476d810347","station":"59132","dataTime":1471125600000,"effDate":1471104000000,"weatherPhen":"阵雨","weatherPhenVal1":3,"weatherPhenVal2":3,"temp":"26到32度","tempVal1":32,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"402880ea56894238015689476d820348","station":"59132","dataTime":1471125600000,"effDate":1471190400000,"weatherPhen":"阵雨转多云","weatherPhenVal1":3,"weatherPhenVal2":1,"temp":"26到32度","tempVal1":32,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"402880ea56894238015689476d820349","station":"59132","dataTime":1471125600000,"effDate":1471276800000,"weatherPhen":"多云","weatherPhenVal1":1,"weatherPhenVal2":1,"temp":"26到33度","tempVal1":33,"tempVal2":26,"wind":"静风","windDirectionVal1":0,"windDirectionVal2":0,"windSpeedVal1":0,"windSpeedVal2":0}]
     */

    private int total;
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

    private List<RowsBean> rows;


    public WeatherDaily(List<RowsBean> rows, int total) {
        this.rows = rows;
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        private Object uid;
        private Object voParams;
        private Object params;
        private Object voList;
        private Object itemList;
        private String sid;
        private String station;
        private long dataTime;
        private long effDate;
        private String weatherPhen;
        private int weatherPhenVal1;
        private int weatherPhenVal2;
        private String temp;
        private double tempVal1;
        private double tempVal2;
        private String wind;
        private int windDirectionVal1;
        private int windDirectionVal2;
        private int windSpeedVal1;
        private int windSpeedVal2;


        public RowsBean() {
        }

        public Object getUid() {
            return uid;
        }

        public void setUid(Object uid) {
            this.uid = uid;
        }

        public Object getVoParams() {
            return voParams;
        }

        public void setVoParams(Object voParams) {
            this.voParams = voParams;
        }

        public Object getParams() {
            return params;
        }

        public void setParams(Object params) {
            this.params = params;
        }

        public Object getVoList() {
            return voList;
        }

        public void setVoList(Object voList) {
            this.voList = voList;
        }

        public Object getItemList() {
            return itemList;
        }

        public void setItemList(Object itemList) {
            this.itemList = itemList;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
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

        public long getEffDate() {
            return effDate;
        }

        public void setEffDate(long effDate) {
            this.effDate = effDate;
        }

        public String getWeatherPhen() {
            return weatherPhen;
        }

        public void setWeatherPhen(String weatherPhen) {
            this.weatherPhen = weatherPhen;
        }

        public int getWeatherPhenVal1() {
            return weatherPhenVal1;
        }

        public void setWeatherPhenVal1(int weatherPhenVal1) {
            this.weatherPhenVal1 = weatherPhenVal1;
        }

        public int getWeatherPhenVal2() {
            return weatherPhenVal2;
        }

        public void setWeatherPhenVal2(int weatherPhenVal2) {
            this.weatherPhenVal2 = weatherPhenVal2;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public double getTempVal1() {
            return tempVal1;
        }

        public void setTempVal1(double tempVal1) {
            this.tempVal1 = tempVal1;
        }

        public double getTempVal2() {
            return tempVal2;
        }

        public void setTempVal2(double tempVal2) {
            this.tempVal2 = tempVal2;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public int getWindDirectionVal1() {
            return windDirectionVal1;
        }

        public void setWindDirectionVal1(int windDirectionVal1) {
            this.windDirectionVal1 = windDirectionVal1;
        }

        public int getWindDirectionVal2() {
            return windDirectionVal2;
        }

        public void setWindDirectionVal2(int windDirectionVal2) {
            this.windDirectionVal2 = windDirectionVal2;
        }

        public int getWindSpeedVal1() {
            return windSpeedVal1;
        }

        public void setWindSpeedVal1(int windSpeedVal1) {
            this.windSpeedVal1 = windSpeedVal1;
        }

        public int getWindSpeedVal2() {
            return windSpeedVal2;
        }

        public void setWindSpeedVal2(int windSpeedVal2) {
            this.windSpeedVal2 = windSpeedVal2;
        }
    }
}
