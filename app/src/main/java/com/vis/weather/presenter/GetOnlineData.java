package com.vis.weather.presenter;

import com.orhanobut.logger.Logger;
import com.vis.weather.util.Config;
import com.vis.weather.util.Network;
import com.vis.weather.util.base.ToDate;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by GaoYu on 2016/8/15.
 */
public class GetOnlineData {


    public static void getOnlineData(Observer observerHour, Observer observerDaily, String time,String station) {
        getOnlinehour(observerHour,time,station);
        getOnline7Day(observerDaily,time,station);
        Logger.i("getOnlineDay :time:::::::::::::"+time);

    }
    public static void getOnlineDay( Observer observerDaily, String time,String station) {

        String totime=ToDate.getDate();
        Subscription subscription;
        subscription = Network.INSTANCE.getApi()
                .searchDaily(station!=""&station!=null?station:Config.quanzhou,time,totime)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerDaily);
    }

    public static void getOnline7Day( Observer observerDaily, String time,String station) {

        String totime=ToDate.getDate();
        Subscription subscription;
        subscription = Network.INSTANCE.getApi()
                .queryForecastFor7Days(station!=""&station!=null?station:Config.quanzhou,"20160911180500")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerDaily);
    }


    public static void getOnlinehour(Observer observerHour, String time,String station) {

        String totime=ToDate.getDate();
        Subscription subscription;
        subscription = Network.INSTANCE.getApi()
                .searchHour(station!=""&station!=null?station:Config.quanzhou,"20160911100500","20160927140600")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerHour);


    }

    public static void getOnlineminute(Observer observerHour, String time,String station) {

        String totime=ToDate.getDate();
        Subscription subscription;
        subscription = Network.INSTANCE.getApi()
                .searchMinute(station!=""&station!=null?station:Config.quanzhou,"20160911100500","20160927140600")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerHour);


    }

    public static void getOnlineminuteLast(Observer observerHour, String station) {

        Subscription subscription;
        subscription = Network.INSTANCE.getApi()
                .queryAutoStationLast(station!=""&station!=null?station:Config.quanzhou)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerHour);


    }
    public static void getPic(Observer observerHour, String type, String startDateTime, String endDateTime, String station) {

        Subscription subscription;
        subscription = Network.INSTANCE.getApi()
                .queryPicture(type,startDateTime,endDateTime,station)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerHour);


    }

    public static void getTyphoonList(Observer observerHour, String yearNo) {

        Subscription subscription;
        subscription = Network.INSTANCE.getApi()
                .queryTyphoonList(null,yearNo,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerHour);
    }

    public static void getTyphoonPath(Observer observerPath, String typhoonNo) {

        Subscription subscription;
        subscription = Network.INSTANCE.getApi()
                .queryTyphoon(typhoonNo,null,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerPath);
    }



    public static void queryTyphoonLast(Observer observerPath, String nyear) {

        Subscription subscription;
        subscription = Network.INSTANCE.getApi()
                .queryTyphoonLast(nyear)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerPath);
    }


    public static void getStationList(Observer observerPath, String lmId,String parentId) {

        Subscription subscription;
        subscription = Network.INSTANCE.getApi()
                .queryShiKuangStation(lmId,parentId,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerPath);
    }
    public static void getStationInfo(Observer observerPath, String station) {

        Subscription subscription;
        subscription = Network.INSTANCE.getApi()
                .queryStationInfo(station)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerPath);
    }


    public static void queryLastUpdateAPK(Observer observerCheckLastUpdateAPK) {

        Subscription subscription;
        subscription = Network.INSTANCE.getApi()
                .queryLastUpdateAPK()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerCheckLastUpdateAPK);
    }
}
