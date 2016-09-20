// (c)2016 Flipboard Inc, All Rights Reserved.

package com.vis.weather.util;

import com.vis.weather.model.DayAndHour;
import com.vis.weather.model.WeatherDaily;
import com.vis.weather.model.WeatherHour;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {
//    queryForecast?station=59132&startDateTime=20160911160000&endDateTime=20160912160000
    @GET("servlet")
    Observable<DayAndHour> search(@Query("q") String query);

    @GET("queryAutoStation")
    Observable<WeatherHour> searchHour(@Query("station") int number, @Query("startDateTime") String fromTime, @Query("endDateTime") String toTime);


    @GET("queryForecast")
    Observable<WeatherDaily> searchDaily(@Query("station") int number, @Query("startDateTime") String fromTime, @Query("endDateTime") String toTime);
//
//    @GET("efzintf/visappautostationinfo.act")
//    Observable<WeatherHour> searchHour(@Query("station") int number, @Query("fromTime") String fromTime, @Query("toTime") String toTime);
//
//
//    @GET("ybintf/visappforecastinfo.act")
//    Observable<WeatherDaily> searchDaily(@Query("station") int number, @Query("fromTime") String fromTime, @Query("toTime") String toTime);
}
