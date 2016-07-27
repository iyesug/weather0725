// (c)2016 Flipboard Inc, All Rights Reserved.

package com.vis.custom.customersmanage.util;

import com.vis.custom.customersmanage.model.DayAndHour;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {
    @GET("servlet")
    Observable<DayAndHour> search(@Query("q") String query);
}
