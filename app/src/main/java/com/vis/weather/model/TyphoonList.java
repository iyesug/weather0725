package com.vis.weather.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */

public class TyphoonList {

    /**
     * total : 18
     * rows : [{"typhoonNo":"201601","yearNo":"2016","typhoonName":"NEPARTAK"},{"typhoonNo":"201602","yearNo":"2016","typhoonName":"Lupit"},{"typhoonNo":"201603","yearNo":"2016","typhoonName":"MIRINAE"},{"typhoonNo":"201604","yearNo":"2016","typhoonName":"Nida"},{"typhoonNo":"201605","yearNo":"2016","typhoonName":"Omais"},{"typhoonNo":"201606","yearNo":"2016","typhoonName":"CONSON"},{"typhoonNo":"201607","yearNo":"2016","typhoonName":"Chanthu"},{"typhoonNo":"201608","yearNo":"2016","typhoonName":"Dianmu"},{"typhoonNo":"201609","yearNo":"2016","typhoonName":"Mindulle"},{"typhoonNo":"201610","yearNo":"2016","typhoonName":"LIONROCK"},{"typhoonNo":"201611","yearNo":"2016","typhoonName":"Kompasu"},{"typhoonNo":"201612","yearNo":"2016","typhoonName":"NAMTHEUN"},{"typhoonNo":"201613","yearNo":"2016","typhoonName":"MALOU"},{"typhoonNo":"201614","yearNo":"2016","typhoonName":"MERANTI"},{"typhoonNo":"201615","yearNo":"2016","typhoonName":"RAI"},{"typhoonNo":"201616","yearNo":"2016","typhoonName":"MALAKAS"},{"typhoonNo":"2016D1","yearNo":"2016","typhoonName":"nameless"},{"typhoonNo":"2016D4","yearNo":"2016","typhoonName":"NAMELESS"}]
     */

    private int total;
    /**
     * typhoonNo : 201601
     * yearNo : 2016
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
        private String yearNo;
        private String typhoonName;

        public String getTyphoonNo() {
            return typhoonNo;
        }

        public void setTyphoonNo(String typhoonNo) {
            this.typhoonNo = typhoonNo;
        }

        public String getYearNo() {
            return yearNo;
        }

        public void setYearNo(String yearNo) {
            this.yearNo = yearNo;
        }

        public String getTyphoonName() {
            return typhoonName;
        }

        public void setTyphoonName(String typhoonName) {
            this.typhoonName = typhoonName;
        }
    }
}
