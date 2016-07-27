package com.vis.custom.customersmanage.util;

import com.orhanobut.logger.Logger;
import com.vis.custom.customersmanage.model.WeatherDailyModel;
import com.vis.custom.customersmanage.model.WeatherhourModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by GaoYu on 2016/7/22.
 */
public class DataSimulate {


    public String [] getDateAndHour(String [] mDateAndHour) {
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy/MM/dd/HH/mm/ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        mDateAndHour=str.split("/");
        Logger.e("date",str);
        //mDateAndHour[1]月
        return mDateAndHour;
    }

    public List<String> gethourList(String hour) {
        List<String> stringHourList=new ArrayList();
        int intHour=Integer.parseInt(hour);
        for(int i=1;i<24;i++){
            if(intHour==24){
                intHour=0;
            }
            intHour++;
            String h=intHour+"";
            stringHourList.add(h);

        }
        return stringHourList;
    }

    public List<String> getdayList(String day) {
        List<String> stringDayList=new ArrayList();
        int intHour=Integer.parseInt(day);
        for(int i=1;i<9;i++){
            if(intHour==30){
                intHour=0;
            }
            intHour++;
            String h=intHour+"";
            stringDayList.add(h);

        }
        return stringDayList;
    }



    public void simulate(List<WeatherDailyModel> daylist,List<WeatherhourModel> hourlist,String [] mDateAndHour) {
        String year=mDateAndHour[0];
        String mounth=mDateAndHour[1];
        String day=mDateAndHour[2];
        String hour=mDateAndHour[3];
        String min=mDateAndHour[4];
        String sec=mDateAndHour[5];
//        daylist =new ArrayList<WeatherDailyModel>() ;
        List<String> stringDayList=getdayList(day);

        //1：晴  2：多云  3：阴  4：雨  5：晴雪  6：冰雹  7：雷电


        daylist.add(new WeatherDailyModel(year+"-"+mounth+"-"+day,"多云",4,"阴",4,19,02,"晋安","55%","6.8m/s","35000m","0mm","32/优",
                "晋安气象站",hour+":"+min,"舒适","适宜","易中暑","强"));
        daylist.add(new WeatherDailyModel(year+"-"+mounth+"-"+stringDayList.get(0),"多云",8,"阴",9,31,18,"晋安","55%","6.8m/s","35000m","0mm","32 优",
                "晋安气象站",hour+":"+min,"舒适","适宜","易中暑","强"));
        daylist.add(new WeatherDailyModel(year+"-"+mounth+"-"+stringDayList.get(1),"多云",2,"阴",5,35,22,"晋安","55%","6.8m/s","35000m","0mm","32 优",
                "晋安气象站",hour+":"+min,"舒适","适宜","易中暑","强"));
        daylist.add(new WeatherDailyModel(year+"-"+mounth+"-"+stringDayList.get(2),"多云",4,"阴",9,34,28,"晋安","55%","6.8m/s","35000m","0mm","32/优",
                "晋安气象站",hour+":"+min,"舒适","适宜","易中暑","强"));
        daylist.add(new WeatherDailyModel(year+"-"+mounth+"-"+stringDayList.get(3),"多云",4,"阴",9,42,21,"晋安","55%","6.8m/s","35000m","0mm","32/优",
                "晋安气象站",hour+":"+min,"舒适","适宜","易中暑","强"));
        daylist.add(new WeatherDailyModel(year+"-"+mounth+"-"+stringDayList.get(4),"多云",1,"阴",2,33,29,"晋安","55%","6.8m/s","35000m","0mm","32/优",
                "晋安气象站",hour+":"+min,"舒适","适宜","易中暑","强"));
        daylist.add(new WeatherDailyModel(year+"-"+mounth+"-"+stringDayList.get(5),"多云",4,"阴",8,35,26,"晋安","55%","6.8m/s","35000m","0mm","32/优",
                "晋安气象站",hour+":"+min,"舒适","适宜","易中暑","强"));
        daylist.add(new WeatherDailyModel(year+"-"+mounth+"-"+stringDayList.get(6),"多云",4,"阴",5,24,20,"晋安","55%","6.8m/s","35000m","0mm","32/优",
                "晋安气象站",hour+":"+min,"舒适","适宜","易中暑","强"));
        daylist.add(new WeatherDailyModel(year+"-"+mounth+"-"+stringDayList.get(7),"多云",4,"阴",4,38,11,"晋安","55%","6.8m/s","35000m","0mm","32 优",
                "晋安气象站",hour+":"+min,"舒适","适宜","易中暑","强"));

//        hourlist=new ArrayList<WeatherhourModel>();
        List<String> stringHourList=gethourList(hour);
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,hour,"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(0),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(1),"阴","30-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(2),"阴","22-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(3),"阴","22-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(4),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(5),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(6),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(7),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(8),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(9),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(10),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(11),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(12),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(13),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(14),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(15),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(16),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(17),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(18),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(19),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(20),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(21),"阴","32-25"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(22),"阴","32-25"));
    }

}
