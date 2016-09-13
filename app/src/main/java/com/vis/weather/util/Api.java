// (c)2016 Flipboard Inc, All Rights Reserved.

package com.vis.weather.util;

import com.vis.weather.model.DayAndHour;
import com.vis.weather.model.WeatherDaily;
import com.vis.weather.model.WeatherHour;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {
    @GET("servlet")
    Observable<DayAndHour> search(@Query("q") String query);


    @GET("efzintf/visappautostationinfo.act")
    Observable<WeatherHour> searchHour(@Query("station") int number, @Query("fromTime") String fromTime, @Query("toTime") String toTime);


    @GET("ybintf/visappforecastinfo.act")
    Observable<WeatherDaily> searchDaily(@Query("station") int number, @Query("fromTime") String fromTime, @Query("toTime") String toTime);
}
