package com.vis.weather.model;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */

public class UpdateAPK {

    /**
     * total : 1
     * rows : [{"versionno":"3","apk_path":"/qx/apk/20161214014025fjgtgov.apk","versioninfo":"测试","versionname":"0.03","update_date":"Wed Dec 14 13:40:25 CST 2016"}]
     */

    private int total;
    /**
     * versionno : 3
     * apk_path : /qx/apk/20161214014025fjgtgov.apk
     * versioninfo : 测试
     * versionname : 0.03
     * update_date : Wed Dec 14 13:40:25 CST 2016
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
        private String versionno;
        private String apk_path;
        private String versioninfo;
        private String versionname;
        private String update_date;

        public String getVersionno() {
            return versionno;
        }

        public void setVersionno(String versionno) {
            this.versionno = versionno;
        }

        public String getApk_path() {
            return apk_path;
        }

        public void setApk_path(String apk_path) {
            this.apk_path = apk_path;
        }

        public String getVersioninfo() {
            return versioninfo;
        }

        public void setVersioninfo(String versioninfo) {
            this.versioninfo = versioninfo;
        }

        public String getVersionname() {
            return versionname;
        }

        public void setVersionname(String versionname) {
            this.versionname = versionname;
        }

        public String getUpdate_date() {
            return update_date;
        }

        public void setUpdate_date(String update_date) {
            this.update_date = update_date;
        }
    }
}
