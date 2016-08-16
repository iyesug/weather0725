package com.vis.custom.customersmanage.presenter;

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


        subscription = Network.getApi()
                .searchHour(Config.quanzhou,time,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerHour);

        subscription = Network.getApi()
                .searchDaily(Config.quanzhou,time,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerDaily);



    }
    public static void getOnlineDay( Observer observerDaily, String time) {




        subscription = Network.getApi()
                .searchDaily(Config.quanzhou,time,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerDaily);



    }
    public static void getOnlinehour(Observer observerHour, String time) {


        subscription = Network.getApi()
                .searchHour(Config.quanzhou,time,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerHour);


    }

}
