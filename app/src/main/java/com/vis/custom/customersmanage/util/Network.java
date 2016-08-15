// (c)2016 Flipboard Inc, All Rights Reserved.

package com.vis.custom.customersmanage.util;


import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private static Api api;

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    public static String my="http://192.168.56.1:8080/V-Weather/";
    public static String quanzhou="http://192.168.10.215:8080/qxbase/qb/";


    public static Api getApi() {
        if (api == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(quanzhou)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            api = retrofit.create(Api.class);
        }
        return api;
    }

}
