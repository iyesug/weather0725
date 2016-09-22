package com.vis.weather.presenter;

import com.orhanobut.logger.Logger;
import com.vis.weather.util.Config;
import com.vis.weather.util.Network;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by GaoYu on 2016/8/15.
 */
public class GetOnlineData {


    public static void getOnlineData(Observer observerHour, Observer observerDaily, String time) {
        getOnlinehour(observerHour,time);
        getOnlineDay(observerDaily,time);
        Logger.i("getOnlineDay :time:::::::::::::"+time);

    }
    public static void getOnlineDay( Observer observerDaily, String time) {


        Subscription subscription;
        subscription = Network.getApi()
                .searchDaily(Config.quanzhou,time,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerDaily);



    }
    public static void getOnlinehour(Observer observerHour, String time) {
        Subscription subscription;
        subscription = Network.getApi()
                .searchHour(Config.quanzhou,time,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerHour);


    }
    public static void getPic(Observer observerHour, String type, String startDateTime, String endDateTime, int station) {
        Subscription subscription;
        subscription = Network.getApi()
                .queryPicture(type,startDateTime,endDateTime,station)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerHour);


    }
}
