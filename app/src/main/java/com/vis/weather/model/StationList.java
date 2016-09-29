package com.vis.weather.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */

public class StationList {


    /**
     * total : 10
     * rows : [{"leftPos":255,"subLmId":"","stationCode":"59134","lmNa":"福建天气预报","norder":10,"latitude":"","sdesc":"","showOnMap":1,"lmId":"2","parentId":"","showFlag":1,"sid":"ybfujian12","lmNo":"ybfujian","cityName":"厦门","stationCode2":"59134","topPos":370,"longitude":""},{"leftPos":290,"subLmId":"","stationCode":"59132","lmNa":"福建天气预报","norder":20,"latitude":24.5358,"sdesc":"","showOnMap":1,"lmId":"2","parentId":"","showFlag":1,"sid":"ybfujian13","lmNo":"ybfujian","cityName":"泉州","stationCode2":"59132","topPos":320,"longitude":118.3731},{"leftPos":200,"subLmId":"","stationCode":"59126","lmNa":"福建天气预报","norder":30,"latitude":"","sdesc":"","showOnMap":1,"lmId":"2","parentId":"","showFlag":1,"sid":"ybfujian14","lmNo":"ybfujian","cityName":"漳州","stationCode2":"59126","topPos":380,"longitude":""},{"leftPos":320,"subLmId":"","stationCode":"58946","lmNa":"福建天气预报","norder":40,"latitude":"","sdesc":"","showOnMap":1,"lmId":"2","parentId":"","showFlag":1,"sid":"ybfujian15","lmNo":"ybfujian","cityName":"莆田","stationCode2":"58946","topPos":265,"longitude":""},{"leftPos":130,"subLmId":"","stationCode":"58927","lmNa":"福建天气预报","norder":50,"latitude":"","sdesc":"","showOnMap":1,"lmId":"2","parentId":"","showFlag":1,"sid":"ybfujian16","lmNo":"ybfujian","cityName":"龙岩","stationCode2":"58927","topPos":320,"longitude":""},{"leftPos":335,"subLmId":"","stationCode":"58847","lmNa":"福建天气预报","norder":60,"latitude":"","sdesc":"","showOnMap":1,"lmId":"2","parentId":"","showFlag":1,"sid":"ybfujian17","lmNo":"ybfujian","cityName":"福州","stationCode2":"58847","topPos":183,"longitude":""},{"leftPos":350,"subLmId":"","stationCode":"58846","lmNa":"福建天气预报","norder":70,"latitude":"","sdesc":"","showOnMap":1,"lmId":"2","parentId":"","showFlag":1,"sid":"ybfujian18","lmNo":"ybfujian","cityName":"宁德","stationCode2":"58846","topPos":120,"longitude":""},{"leftPos":230,"subLmId":"","stationCode":"58834","lmNa":"福建天气预报","norder":80,"latitude":"","sdesc":"","showOnMap":1,"lmId":"2","parentId":"","showFlag":1,"sid":"ybfujian19","lmNo":"ybfujian","cityName":"南平","stationCode2":"58834","topPos":140,"longitude":""},{"leftPos":180,"subLmId":"","stationCode":"58828","lmNa":"福建天气预报","norder":90,"latitude":"","sdesc":"","showOnMap":1,"lmId":"2","parentId":"","showFlag":1,"sid":"ybfujian20","lmNo":"ybfujian","cityName":"三明","stationCode2":"58828","topPos":200,"longitude":""},{"leftPos":200,"subLmId":"","stationCode":"58730","lmNa":"福建天气预报","norder":100,"latitude":"","sdesc":"","showOnMap":1,"lmId":"2","parentId":"","showFlag":1,"sid":"ybfujian21","lmNo":"ybfujian","cityName":"武夷山市","stationCode2":"58730","topPos":30,"longitude":""}]
     */

    private int total;
    /**
     * leftPos : 255
     * subLmId :
     * stationCode : 59134
     * lmNa : 福建天气预报
     * norder : 10
     * latitude :
     * sdesc :
     * showOnMap : 1
     * lmId : 2
     * parentId :
     * showFlag : 1
     * sid : ybfujian12
     * lmNo : ybfujian
     * cityName : 厦门
     * stationCode2 : 59134
     * topPos : 370
     * longitude :
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
        private String leftPos;
        private String subLmId;
        private String stationCode;
        private String lmNa;
        private String norder;
        private String latitude;
        private String sdesc;
        private String showOnMap;
        private String lmId;
        private String parentId;
        private String showFlag;
        private String sid;
        private String lmNo;
        private String cityName;
        private String stationCode2;
        private String topPos;
        private String longitude;

        public String getLeftPos() {
            return leftPos;
        }

        public void setLeftPos(String leftPos) {
            this.leftPos = leftPos;
        }

        public String getSubLmId() {
            return subLmId;
        }

        public void setSubLmId(String subLmId) {
            this.subLmId = subLmId;
        }

        public String getStationCode() {
            return stationCode;
        }

        public void setStationCode(String stationCode) {
            this.stationCode = stationCode;
        }

        public String getLmNa() {
            return lmNa;
        }

        public void setLmNa(String lmNa) {
            this.lmNa = lmNa;
        }

        public String getNorder() {
            return norder;
        }

        public void setNorder(String norder) {
            this.norder = norder;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getSdesc() {
            return sdesc;
        }

        public void setSdesc(String sdesc) {
            this.sdesc = sdesc;
        }

        public String getShowOnMap() {
            return showOnMap;
        }

        public void setShowOnMap(String showOnMap) {
            this.showOnMap = showOnMap;
        }

        public String getLmId() {
            return lmId;
        }

        public void setLmId(String lmId) {
            this.lmId = lmId;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getShowFlag() {
            return showFlag;
        }

        public void setShowFlag(String showFlag) {
            this.showFlag = showFlag;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getLmNo() {
            return lmNo;
        }

        public void setLmNo(String lmNo) {
            this.lmNo = lmNo;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getStationCode2() {
            return stationCode2;
        }

        public void setStationCode2(String stationCode2) {
            this.stationCode2 = stationCode2;
        }

        public String getTopPos() {
            return topPos;
        }

        public void setTopPos(String topPos) {
            this.topPos = topPos;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }
    }
}
