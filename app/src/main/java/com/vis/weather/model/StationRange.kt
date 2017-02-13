package com.vis.weather.model

/**
 * Created by Administrator on 2016/10/27.
 */

class StationRange(var id: String?, var name: String?, var nickName: String?) {

    override fun toString(): String {
        return "StationRange{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}'
    }
}
