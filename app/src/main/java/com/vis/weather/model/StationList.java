package com.vis.weather.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */

public class StationList {
    /**
     * total : 12
     * rows : [{"leftPos":245,"subLmId":"","stationCode":"F5604","lmNa":"泉州海洋气象实况","norder":100,"sdesc":"","showOnMap":1,"lmId":"5","parentId":"","showFlag":1,"sid":"skquanzhouhaiyang10","lmNo":"skquanzhouhaiyang","cityName":"深沪","stationCode2":"58929","topPos":400},{"leftPos":90,"subLmId":"","stationCode":"F5607","lmNa":"泉州海洋气象实况","norder":110,"sdesc":"","showOnMap":1,"lmId":"5","parentId":"","showFlag":1,"sid":"skquanzhouhaiyang11","lmNo":"skquanzhouhaiyang","cityName":"东石","stationCode2":"15706","topPos":340},{"leftPos":380,"subLmId":"","stationCode":"59133","lmNa":"泉州海洋气象实况","norder":20,"sdesc":"","showOnMap":1,"lmId":"5","parentId":"","showFlag":1,"sid":"skquanzhouhaiyang2","lmNo":"skquanzhouhaiyang","cityName":"崇武","stationCode2":"59137","topPos":215},{"leftPos":190,"subLmId":"","stationCode":"F2288","lmNa":"泉州海洋气象实况","norder":30,"sdesc":"","showOnMap":1,"lmId":"5","parentId":"","showFlag":1,"sid":"skquanzhouhaiyang3","lmNo":"skquanzhouhaiyang","cityName":"围头","stationCode2":"15708","topPos":430},{"leftPos":250,"subLmId":"","stationCode":"F5603","lmNa":"泉州海洋气象实况","norder":40,"sdesc":"","showOnMap":1,"lmId":"5","parentId":"","showFlag":1,"sid":"skquanzhouhaiyang4","lmNo":"skquanzhouhaiyang","cityName":"石湖","stationCode2":"15751","topPos":280},{"leftPos":253,"subLmId":"","stationCode":"F5113","lmNa":"泉州海洋气象实况","norder":50,"sdesc":"","showOnMap":1,"lmId":"5","parentId":"","showFlag":1,"sid":"skquanzhouhaiyang5","lmNo":"skquanzhouhaiyang","cityName":"洛阳","stationCode2":"59133","topPos":183},{"leftPos":315,"subLmId":"","stationCode":"F5605","lmNa":"泉州海洋气象实况","norder":60,"sdesc":"","showOnMap":1,"lmId":"5","parentId":"","showFlag":1,"sid":"skquanzhouhaiyang6","lmNo":"skquanzhouhaiyang","cityName":"祥芝","stationCode2":"15103","topPos":325},{"leftPos":45,"subLmId":"","stationCode":"59140","lmNa":"泉州海洋气象实况","norder":120,"sdesc":"","showOnMap":1,"lmId":"5","parentId":"","showFlag":1,"sid":"skquanzhouhaiyang61","lmNo":"skquanzhouhaiyang","cityName":"大嶝岛","stationCode2":"58931","topPos":395},{"leftPos":300,"subLmId":"","stationCode":"59136","lmNa":"泉州海洋气象实况","norder":130,"sdesc":"","showOnMap":1,"lmId":"5","parentId":"","showFlag":1,"sid":"skquanzhouhaiyang62","lmNo":"skquanzhouhaiyang","cityName":"大坠岛","stationCode2":"15603","topPos":250},{"leftPos":455,"subLmId":"","stationCode":"58957","lmNa":"泉州海洋气象实况","norder":70,"sdesc":"","showOnMap":1,"lmId":"5","parentId":"","showFlag":1,"sid":"skquanzhouhaiyang7","lmNo":"skquanzhouhaiyang","cityName":"大竹岛","stationCode2":"59131","topPos":115},{"leftPos":110,"subLmId":"","stationCode":"59138","lmNa":"泉州海洋气象实况","norder":80,"sdesc":"","showOnMap":1,"lmId":"5","parentId":"","showFlag":1,"sid":"skquanzhouhaiyang8","lmNo":"skquanzhouhaiyang","cityName":"大佰岛","stationCode2":"58935","topPos":390},{"leftPos":445,"subLmId":"","stationCode":"F5720","lmNa":"泉州海洋气象实况","norder":90,"sdesc":"","showOnMap":1,"lmId":"5","parentId":"","showFlag":1,"sid":"skquanzhouhaiyang9","lmNo":"skquanzhouhaiyang","cityName":"大岞","stationCode2":"58934","topPos":232}]
     */

    private int total;
    /**
     * leftPos : 245
     * subLmId :
     * stationCode : F5604
     * lmNa : 泉州海洋气象实况
     * norder : 100
     * sdesc :
     * showOnMap : 1
     * lmId : 5
     * parentId :
     * showFlag : 1
     * sid : skquanzhouhaiyang10
     * lmNo : skquanzhouhaiyang
     * cityName : 深沪
     * stationCode2 : 58929
     * topPos : 400
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
        private int leftPos;
        private String subLmId;
        private String stationCode;
        private String lmNa;
        private int norder;
        private String sdesc;
        private int showOnMap;
        private String lmId;
        private String parentId;
        private int showFlag;
        private String sid;
        private String lmNo;
        private String cityName;
        private String stationCode2;
        private int topPos;

        public int getLeftPos() {
            return leftPos;
        }

        public void setLeftPos(int leftPos) {
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

        public int getNorder() {
            return norder;
        }

        public void setNorder(int norder) {
            this.norder = norder;
        }

        public String getSdesc() {
            return sdesc;
        }

        public void setSdesc(String sdesc) {
            this.sdesc = sdesc;
        }

        public int getShowOnMap() {
            return showOnMap;
        }

        public void setShowOnMap(int showOnMap) {
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

        public int getShowFlag() {
            return showFlag;
        }

        public void setShowFlag(int showFlag) {
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

        public int getTopPos() {
            return topPos;
        }

        public void setTopPos(int topPos) {
            this.topPos = topPos;
        }
    }
}
