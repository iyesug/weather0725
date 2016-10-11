// (c)2016 Flipboard Inc, All Rights Reserved.

package com.vis.weather.util;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class Network {
    private static Api api;

    private static OkHttpClient okHttpClient ;
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    public static String my="http://192.168.56.1:8080/V-Weather/";
    public static String quanzhou="http://192.168.10.215:8080/qxbase/qb/";
    public static String quanzhou1="http://192.168.10.223:8084/qb/qb/";
    public static String quanzhou2="http://192.168.10.215:8080/qb/qxbase/";
    public static String inIp ="http://192.168.10.205:8080/hadoop-hbase-web-demo/rest/";
    public static String        outIp="http://112.5.90.103:28080/hadoop-hbase-web-demo/rest/";
    public static String        IP=inIp;
    public static String picFront= IP +"downloadFile?fileName=";

    //    http://192.168.10.158:8080/hadoop-hbase-web-demo/rest/downloadFile?fileName=
//    http://192.168.10.173:8080/hadoop-hbase-web-demo/rest/queryForecast?station=59132&startDateTime=20160911160000&endDateTime=20160912160000
    public static Api getApi() {
        if (api == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            httpClientBuilder.addInterceptor(logging);
            httpClientBuilder.connectTimeout(60, TimeUnit.SECONDS);
            httpClientBuilder.readTimeout(60, TimeUnit.SECONDS);
            httpClientBuilder.writeTimeout(60, TimeUnit.SECONDS);
            Retrofit retrofit = new Retrofit.Builder()

                    .client(httpClientBuilder.build())
                    .baseUrl(IP)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            api = retrofit.create(Api.class);
        }
        return api;
    }

}
