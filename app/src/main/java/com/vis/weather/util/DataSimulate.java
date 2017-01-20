package com.vis.weather.util;

import com.baidu.mapapi.model.LatLng;
import com.vis.weather.model.OceanWeather;
import com.vis.weather.model.Report;
import com.vis.weather.model.WeatherDailyModel;
import com.vis.weather.model.WeatherhourModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by GaoYu on 2016/7/22.
 */
public class DataSimulate {

    public static List<Report> getreport() {
        List<Report> list=new ArrayList<>();
        list.add(new Report("泉州气象台", 1417792627,"暴雨蓝色预警（解除） 9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "R.drawable.background_3"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨蓝色预警 9月1日11时10分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic.yesky.com/imagelist/06/47/985202_5664.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"雷电红色预警（解除） 9月1日01时22分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic.sayingfly.com/Photo/UpLoadFiles/2008-7-24/20087249442527.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"雷电红色预警 9月1日01时00分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic7.nipic.com/20100522/1263764_002013845527_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨黄色预警（解除） 8月22日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://d.3987.com/dgblcsyjgqbz_20130314/001.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨黄色预警 8月22日11时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"雷电蓝色预警（解除）8月21日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"雷电蓝色预警 8月21日01时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic7.nipic.com/20100522/1263764_002013845527_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨黄色预警（解除） 9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic.sayingfly.com/Photo/UpLoadFiles/2008-7-24/20087249442527.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨黄色预警 9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨蓝色预警（解除）9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic7.nipic.com/20100522/1263764_002013845527_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨蓝色预警 9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://d.3987.com/dgblcsyjgqbz_20130314/001.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨红色预警（解除）9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨红色预警 9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"雷电黄色预警（解除）9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"雷电黄色预警 9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic7.nipic.com/20100522/1263764_002013845527_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨蓝色预警（解除）9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic.sayingfly.com/Photo/UpLoadFiles/2008-7-24/20087249442527.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨蓝色预警 9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨黄色预警（解除）9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨黄色预警 9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic.sayingfly.com/Photo/UpLoadFiles/2008-7-24/20087249442527.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"雷电蓝色预警（解除）9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"雷电蓝色预警 9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic7.nipic.com/20100522/1263764_002013845527_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨红色预警（解除） 9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨红色预警 9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"雷电黄色预警（解除）9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic7.nipic.com/20100522/1263764_002013845527_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"雷电黄色预警 9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨黄色预警（解除） 9月2日21时20分", "泉州气象台9月2日21时20分解除蓝色暴雨预警信号。",
                "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"));
        return list;
    }

    public static List<Report> getpopular() {
        List<Report> list=new ArrayList<>();
        list.add(new Report("泉州气象台", 1417792627,"预警信号", "暴雨洪涝是由大暴雨形成的洪涝。气象部门规定24小时降水量≥50毫米称为暴雨，24小时降水量≥l00毫米称为大暴雨，24小时降水量≥250毫米称为特大暴雨。\n" +
                "产生暴雨的基本条件是，大气中要有充沛的水汽和强烈的上升气流；需要较长的持续时间、有利的地形作用。地处四川盆地和青藏高原过渡地带的雅安、峨眉山和北川、安县一带，正当暖湿夏季风的迎风坡，由于地形的抬升作用，成云致雨机会多，是四川的两个多暴雨区，平均全年暴雨日可达5-7天，其余地区一般为3-4天。四川盆地内暴雨多出现在5-9月，由东往西先后开始。大范围的暴雨常引发洪涝灾害，造成山洪暴发、河水泛滥、城市积水、泥石流、山崩、滑波等灾害，严重危害人民生命财产的安全。",
                "R.drawable.background_3"));
        list.add(new Report("泉州气象台", 1417792627,"洪涝灾害的危害", "在各种自然灾害中，洪涝是最常见且又危害最大的一种。洪水出现频率高，波及范围广，来势凶猛，破坏性极大。洪水不但淹没房屋，造成大量人员伤亡，而且还卷走人们居留地的一切物品，包括粮食，并淹没农田，毁坏作物，导致粮食大幅度减产，从而造成饥荒。洪水还会破坏工厂厂房、通讯与交通设施，从而造成对国民经济建设的破坏。\n" +
                "本世纪以来，世界各国曾先后发生过近40次特大洪涝灾害，每次都导致上万人的死亡和千百万人的流离失所。在近几十年中，洪涝发生频次与灾害损失都在逐年增加。根据统计1951－1990年，我国平均每年发生严重洪涝灾害5．9次，平均受灾面积667万公顷，其中成灾面积470万公顷，死亡三四千人，倒塌房屋200余万间。四川盆地是洪涝灾害的多发地区。",
                "http://pic.yesky.com/imagelist/06/47/985202_5664.jpg"));
        list.add(new Report("泉州气象台", 1417792627,"暴雨与泥石流", "暴雨是诱发泥石流的重要因素。凡是山高坡陡，沟壑纵横，植被较差、土层薄，没有高大森林，也没有灌木丛林的山地，当遇有暴雨或大暴雨时，最容易发生泥石流。据调查，在容易发生泥石流的地形和地质条件下，24小时雨量达l 40毫米以上时，就有可能诱发泥石流。降水越强，出现泥石流的机会越多，灾害也越严重。当24小时雨量达300毫米以上时，会诱发形成较重和严重的泥石流。\n" +
                "泥石流并不一定在一次暴雨过程结束以后才发生，而往往在暴雨过程中由于短时间内强集中降水诱发形成。当日雨量达140毫米以上的暴雨过程中，如若出现1小时、3小时和6小时最大降水分别为40毫米，80毫米和100毫米以上就会诱发泥石流发生。而当日雨量达300毫米以上时，若出现1小时、3小时和6小时最大降水量分别为60毫米、l00毫米和200毫米以上，会诱发形成较重或严重的泥石流。通常认为泥石流的发生与前期有较长时间的降水有关。在先有较长时间降水的情况下，由于土层含水饱和，径流系数加大，汇流时间缩短，使地表滑动力和内水压力加大，又遇突发性强暴雨，就更容易发生泥石流。但即使前期少雨的情况下，短时间内强集中暴雨同样也可以诱发泥石流，只是在这种情况下，暴雨的强度比前者要大。因此，汛期是泥石流发生的主要季节。\n" +
                "泥石流是一种危害很大的自然灾害，近年来在我国各地时有发生。因此，积极作好预防泥石流的发生是一项十分重要的工作。为了防止泥石流的发生，必须根据当地地质地貌情况，适宜地植树造林，防止植被破坏以及修建导流堤、拦挡坝和停淤场等。加强对地质条件的调查、分析、研究，加强对天气预报的了解，掌握好雨量情况，及时做出综合分析判断，注意采取早期和应急防范措施，以避免和减少泥石流灾害所造成的损失。\n" +
                " ",
                "http://pic.sayingfly.com/Photo/UpLoadFiles/2008-7-24/20087249442527.jpg"));

        return list;
    }
    public static List<Report> getVideo() {
        List<Report> list=new ArrayList<>();
        list.add(new Report("气象科普", 1417792627,"天气预报", Network.INSTANCE.getPicFront() +"/qx/vedio/xwlb.flv",
                "R.drawable.background_3"));
        list.add(new Report("气象预报", 1417792627,"泉州电视台", "rtmp://live.hkstv.hk.lxdns.com/live/hks",
                "http://pic.yesky.com/imagelist/06/47/985202_5664.jpg"));
        return list;
    }
    public String [] getDateAndHour(String [] mDateAndHour) {
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy/MM/dd/HH/mm/ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        mDateAndHour=str.split("/");

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

    public static List<OceanWeather> getOceanList() {
        List<OceanWeather> oceanWeatherList=new ArrayList();
//        Long time=Long.parseLong(date);
//        String datefomat =ToDate.timeStampToDate(time);
        oceanWeatherList.add(new OceanWeather(new LatLng(25.083484, 119.049968),"大竹岛","2016-08-24 15:33:41",
                "多云",4,"29","12","偏北风4~5级","浪高2~4米中到大浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(25.276361, 119.131462),"秀屿","2016-08-24 15:33:41",
                "小雨",4,"29","07","偏北风4~6级","浪高1~2米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(25.173478, 118.819013),"泉港","2016-08-24 15:33:41",
                "大雨",4,"19","08","偏北风4~5级","浪高1~3米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(25.047931, 119.016371),"青兰山","2016-08-24 15:33:41",
                "多云",4,"19","12","偏北风4~8级","浪高1~4米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(25.083484, 119.049968),"小岞镇","2016-08-24 15:33:41",
                "多云",4,"19","12","偏北风3~6级","浪高1~5米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(25.276361, 119.131462),"大岞村","2016-08-24 15:33:41",
                "雷雨",4,"19","08","偏北风3~5级","浪高2~3米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(25.173478, 118.819013),"崇武镇","2016-08-24 15:33:41",
                "多云",4,"19","09","偏北风2~5级","浪高1~2米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(25.047931, 119.016371),"后渚","2016-08-24 15:33:41",
                "多云",4,"19","12","偏北风1~5级","浪高1~2米轻到中浪"));

        oceanWeatherList.add(new OceanWeather(new LatLng(24.835442, 118.782381),"大坠岛","2016-08-24 15:33:41",
                "多云",4,"19","02","偏北风4~5级","浪高2~3米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(24.963904, 118.700940),"洛阳镇","2016-08-24 15:33:41",
                "晴",4,"19","02","偏北风4~5级","浪高1~5米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(24.809009, 118.724817),"石湖","2016-08-24 15:33:41",
                "多云",4,"19","14","偏北风4~5级","浪高2~4米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(24.776632, 118.783656),"祥芝","2016-08-24 15:33:41",
                "雾",4,"29","14","偏北风1~2级","浪高1~2米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(24.632833, 118.688032),"深沪","2016-08-24 15:33:41",
                "多云",4,"19","02","偏北风4~5级","浪高1~2米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(24.533762, 118.588724),"围头村","2016-08-24 15:33:41",
                "多云",4,"29","22","偏北风1~3级","浪高1~2米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(24.569736, 118.465494),"大百屿","2016-08-24 15:33:41",
                "小雨",4,"19","02","偏北风4~5级","浪高3~6米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(24.665962, 118.465728),"东石镇","2016-08-24 15:33:41",
                "多云",4,"09","02","偏北风1~5级","浪高2~3米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(24.568060, 118.340055),"大嶝","2016-08-24 15:33:41",
                "多云",4,"19","02","偏北风2~5级","浪高3~4米轻到中浪"));
        oceanWeatherList.add(new OceanWeather(new LatLng(24.453684, 118.379769),"金门","2016-08-24 15:33:41",
                "小雨",4,"19","19","偏北风3~5级","浪高1~2米轻到中浪"));


        return oceanWeatherList;
    }

    public void simulate(List<WeatherDailyModel> daylist,List<WeatherhourModel> hourlist,String [] mDateAndHour) {
        String year=mDateAndHour[0];
        String mounth=mDateAndHour[1];
        String day=mDateAndHour[2];
        String hour=mDateAndHour[3];
        String min=mDateAndHour[4];
        String sec=mDateAndHour[5];
//        sevenDay =new ArrayList<WeatherDailyModel>() ;
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

//        lastHour=new ArrayList<WeatherhourModel>();
        List<String> stringHourList=gethourList(hour);
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,hour,"阴","32.25","7","6.5","73","18698","1002.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(0),"阴","32.25","7","6.5","93","11698","1022.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(1),"阴","35.75","22","16.4","75","14698","1022.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(2),"阴","21.25","37","6.5","33","16698","1032.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(3),"阴","22.15","27","26.5","53","14698","702.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(4),"阴","32.25","4","6.3","73","19698","1042.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(5),"阴","22.25","17","26.8","65","22698","1052.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(6),"阴","22.67","7","3.5","87","18698","1012.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(7),"阴","33.75","7","6.6","99","28298","1062.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(8),"阴","22.25","7","7.5","93","18698","1002.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(9),"阴","22.25","5","16.5","73","18628","802.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(10),"阴","12.55","7","6.4","73","18698","1042.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(11),"阴","32.25","21","36.5","73","14698","1002.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(12),"阴","32.25","7","26.5","83","22698","1052.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(13),"阴","32.45","23","16.8","79","12698","1002.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(14),"阴","22.25","7","16.6","63","16698","1002.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(15),"阴","22.35","7","16.5","73","11698","1002.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(16),"阴","28.25","7","6.4","53","18698","902.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(17),"阴","22.25","9","26.5","72","13698","1002.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(18),"阴","22.25","7","9.3","74","18698","1002.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(19),"阴","32.65","11","16.5","73","28698","1302.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(20),"阴","32.25","7","6.8","76","18698","1002.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(21),"阴","18.55","1","26.7","71","16698","1062.6"));
        hourlist.add(new WeatherhourModel(year+"-"+mounth+"-"+day,stringHourList.get(22),"阴","12.25","4","6.5","63","28698","1002.6"));
    }

}
