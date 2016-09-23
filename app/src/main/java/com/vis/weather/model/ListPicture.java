package com.vis.weather.model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */

public class ListPicture {

//
//    {
//        "total" : 4,
//            "rows" : [ {
//        "filepath" : "/qx/rad/50001/201609112000.PNG",
//                "dataTime" : "201609112000",
//                "station" : "50001",
//                "imgtype" : "rad"
//    }, {
//        "filepath" : "/qx/rad/50001/201609112006.PNG",
//                "dataTime" : "201609112006",
//                "station" : "50001",
//                "imgtype" : "rad"
//    }, {
//        "filepath" : "/qx/rad/50001/201609112012.PNG",
//                "dataTime" : "201609112012",
//                "station" : "50001",
//                "imgtype" : "rad"
//    }, {
//        "filepath" : "/qx/rad/50001/201609112018.PNG",
//                "dataTime" : "201609112018",
//                "station" : "50001",
//                "imgtype" : "rad"
//    } ]
//    }

    private int total;
    /**
     * filepath : /qx/rad/50001/201609072324.PNG
     * dataTime : 201609072324
     * station : 50001
     * imgtype : rad
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
        private String filepath;
        private String dataTime;
        private String station;
        private String imgtype;

        public String getFilepath() {
            return filepath;
        }

        public void setFilepath(String filepath) {
            this.filepath = filepath;
        }

        public String getDataTime() {
            return dataTime;
        }

        public void setDataTime(String dataTime) {
            this.dataTime = dataTime;
        }

        public String getStation() {
            return station;
        }

        public void setStation(String station) {
            this.station = station;
        }

        public String getImgtype() {
            return imgtype;
        }

        public void setImgtype(String imgtype) {
            this.imgtype = imgtype;
        }
    }
}
