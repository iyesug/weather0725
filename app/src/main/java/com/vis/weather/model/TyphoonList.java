package com.vis.weather.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */

public class TyphoonList {

    /**
     * total : 18
     * rows : [{"typhoonNo":"201601","chinaNo":"201601","chineseName":"尼伯特","yearNo":"01","nyear":2016,"typhoonName":"NEPARTAK"},{"typhoonNo":"201602","chinaNo":"201602","chineseName":"卢碧","yearNo":"02","nyear":2016,"typhoonName":"Lupit"},{"typhoonNo":"201603","chinaNo":"201603","chineseName":"银河","yearNo":"03","nyear":2016,"typhoonName":"MIRINAE"},{"typhoonNo":"201604","chinaNo":"201604","chineseName":"妮妲","yearNo":"04","nyear":2016,"typhoonName":"Nida"},{"typhoonNo":"201605","chinaNo":"201605","chineseName":"奥麦斯","yearNo":"05","nyear":2016,"typhoonName":"Omais"},{"typhoonNo":"201606","chinaNo":"201606","chineseName":"康森","yearNo":"06","nyear":2016,"typhoonName":"CONSON"},{"typhoonNo":"201607","chinaNo":"201607","chineseName":"灿都","yearNo":"07","nyear":2016,"typhoonName":"Chanthu"},{"typhoonNo":"201608","chinaNo":"201608","chineseName":"佚名","yearNo":"08","nyear":2016,"typhoonName":"NAMELESS"},{"typhoonNo":"201609","chinaNo":"201609","chineseName":"蒲公英","yearNo":"09","nyear":2016,"typhoonName":"Mindulle"},{"typhoonNo":"201610","chinaNo":"201610","chineseName":"狮子山","yearNo":"10","nyear":2016,"typhoonName":"LIONROCK"},{"typhoonNo":"201611","chinaNo":"201611","chineseName":"圆规","yearNo":"11","nyear":2016,"typhoonName":"Kompasu"},{"typhoonNo":"201612","chinaNo":"201612","chineseName":"南川","yearNo":"12","nyear":2016,"typhoonName":"NAMTHEUN"},{"typhoonNo":"201613","chinaNo":"201613","chineseName":"玛瑙","yearNo":"13","nyear":2016,"typhoonName":"MALOU"},{"typhoonNo":"201614","chinaNo":"201614","chineseName":"莫兰蒂","yearNo":"14","nyear":2016,"typhoonName":"MERANTI"},{"typhoonNo":"201615","chinaNo":"201615","chineseName":"NO NAME","yearNo":"15","nyear":2016,"typhoonName":"RAI"},{"typhoonNo":"201616","chinaNo":"201616","chineseName":"马勒卡","yearNo":"16","nyear":2016,"typhoonName":"MALAKAS"},{"typhoonNo":"2016D1","chinaNo":"2016D1","chineseName":"佚名","yearNo":"D1","nyear":2016,"typhoonName":"nameless"},{"typhoonNo":"2016D4","chinaNo":"2016D4","chineseName":"佚名","yearNo":"D4","nyear":2016,"typhoonName":"NAMELESS"}]
     */

    private int total;
    /**
     * typhoonNo : 201601
     * chinaNo : 201601
     * chineseName : 尼伯特
     * yearNo : 01
     * nyear : 2016
     * typhoonName : NEPARTAK
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
        private String typhoonNo;
        private String chinaNo;
        private String chineseName;
        private String yearNo;
        private int nyear;
        private String typhoonName;

        public String getTyphoonNo() {
            return typhoonNo;
        }

        public void setTyphoonNo(String typhoonNo) {
            this.typhoonNo = typhoonNo;
        }

        public String getChinaNo() {
            return chinaNo;
        }

        public void setChinaNo(String chinaNo) {
            this.chinaNo = chinaNo;
        }

        public String getChineseName() {
            return chineseName;
        }

        public void setChineseName(String chineseName) {
            this.chineseName = chineseName;
        }

        public String getYearNo() {
            return yearNo;
        }

        public void setYearNo(String yearNo) {
            this.yearNo = yearNo;
        }

        public int getNyear() {
            return nyear;
        }

        public void setNyear(int nyear) {
            this.nyear = nyear;
        }

        public String getTyphoonName() {
            return typhoonName;
        }

        public void setTyphoonName(String typhoonName) {
            this.typhoonName = typhoonName;
        }
    }
}
