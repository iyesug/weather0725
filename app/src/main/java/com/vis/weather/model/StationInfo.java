package com.vis.weather.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */

public class StationInfo {
    /**
     * total : 1
     * rows : [{"latitude":24.29,"station":"59134","stationName":"厦门                           ","longitude":118.04}]
     */

    private int total;
    /**
     * latitude : 24.29
     * station : 59134
     * stationName : 厦门
     * longitude : 118.04
     */

    private List<RowsBean> rows;

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
        private double latitude;
        private String station;
        private String stationName;
        private double longitude;

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getStation() {
            return station;
        }

        public void setStation(String station) {
            this.station = station;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }
}
