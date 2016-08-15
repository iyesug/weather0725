// (c)2016 Flipboard Inc, All Rights Reserved.

package com.vis.custom.customersmanage.util;

import com.vis.custom.customersmanage.model.DayAndHour;
import com.vis.custom.customersmanage.model.WeatherDaily;
import com.vis.custom.customersmanage.model.WeatherHour;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {
    @GET("servlet")
    Observable<DayAndHour> search(@Query("q") String query);


    @GET("autostation/getData.act")
    Observable<WeatherHour> searchHour(@Query("station") int number, @Query("fromTime") String fromTime, @Query("toTime") String toTime);


    @GET("forecast/getData.act")
    Observable<WeatherDaily> searchDaily(@Query("station") int number, @Query("fromTime") String fromTime, @Query("toTime") String toTime);
}
