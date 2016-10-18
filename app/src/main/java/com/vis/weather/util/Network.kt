// (c)2016 Flipboard Inc, All Rights Reserved.

package com.vis.weather.util


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Network {
    private var api: Api? = null

    private val okHttpClient: OkHttpClient? = null
    private val gsonConverterFactory = GsonConverterFactory.create()
    private val rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create()
    var my = "http://192.168.56.1:8080/V-Weather/"
    var quanzhou = "http://192.168.10.215:8080/qxbase/qb/"
    var quanzhou1 = "http://192.168.10.223:8084/qb/qb/"
    var quanzhou2 = "http://192.168.10.215:8080/qb/qxbase/"
    var inIp = "http://192.168.10.205:8080/hadoop-hbase-web-demo/rest/"
    var outIp = "http://112.5.90.103:5858/hadoop-hbase-web-demo/rest/"
    var IP = inIp
    var picFront = IP + "downloadFile?fileName="

    //    http://192.168.10.158:8080/hadoop-hbase-web-demo/rest/downloadFile?fileName=
    //    http://192.168.10.173:8080/hadoop-hbase-web-demo/rest/queryForecast?station=59132&startDateTime=20160911160000&endDateTime=20160912160000
    fun getApi(): Api? {
        if (api == null) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val httpClientBuilder = OkHttpClient.Builder()
            httpClientBuilder.addInterceptor(logging)
            httpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
            httpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
            httpClientBuilder.writeTimeout(60, TimeUnit.SECONDS)
            val retrofit = Retrofit.Builder().client(httpClientBuilder.build()).baseUrl(IP).addConverterFactory(gsonConverterFactory).addCallAdapterFactory(rxJavaCallAdapterFactory).build()
            api = retrofit.create(Api::class.java)
        }
        return api
    }

}
