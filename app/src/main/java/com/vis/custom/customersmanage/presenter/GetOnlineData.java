package com.vis.custom.customersmanage.presenter;

import com.orhanobut.logger.Logger;
import com.vis.custom.customersmanage.util.Config;
import com.vis.custom.customersmanage.util.Network;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by GaoYu on 2016/8/15.
 */
public class GetOnlineData {

    public static Subscription subscription;

    public static void getOnlineData(Observer observerHour, Observer observerDaily, String time) {
        getOnlinehour(observerHour,time);
        getOnlineDay(observerDaily,time);

    }
    public static void getOnlineDay( Observer observerDaily, String time) {

        Logger.i("getOnlineDay :time:::::::::::::"+time);


        subscription = Network.getApi()
                .searchDaily(Config.quanzhou,time,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerDaily);



    }
    public static void getOnlinehour(Observer observerHour, String time) {
        Logger.i("getOnlinehour :time:::::::::::::"+time);

        subscription = Network.getApi()
                .searchHour(Config.quanzhou,time,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerHour);


    }

}
