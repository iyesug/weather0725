package com.vis.weather.model;

import java.util.List;

/**
 * Created by GaoYu on 2016/8/15.
 */
public class WeatherHour {

    @Override
    public String toString() {
        return "WeatherHour{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    /**
     * total : 424
     * rows : [{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181568919de0156891f662a00e4","station":"59132","dataTime":1471168800000,"timeFlag":0,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471168800000,"windDirectDisp2m":"东东北","windDirection2m":72,"windSpeed2m":6.2,"windDirectDisp10m":"东东北","windDirection10m":68,"windSpeed10m":5.7,"maxWindDirectDisp":"东东北","maxWindDirection":66,"maxWindSpeed":6.8,"maxWindSpeedTime":32580000,"windDirectDisp":"东东北","windDirection":74,"windSpeed":5.8,"maxJdWindDirectDisp":"东","maxJdWindDirection":82,"maxJdWindSpeed":10.2,"maxJdWindSpeedTime":35940000,"rainfallPerHour":0,"temp":29.3,"maxTemp":29.7,"maxTempTime":32460000,"minTemp":29.3,"minTempTime":36000000,"humidity":77,"minHumidity":73,"minHumidityTime":32460000,"waterPress":null,"dewTemp":null,"stationPress":989.1,"maxStationPress":989.1,"maxStationPressTime":36000000,"minStationPress":988.5,"minStationPressTime":32760000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181568919de0156891fdb28123f","station":"59132","dataTime":1471172400000,"timeFlag":0,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471172400000,"windDirectDisp2m":"东东北","windDirection2m":75,"windSpeed2m":5.3,"windDirectDisp10m":"东东北","windDirection10m":74,"windSpeed10m":5.9,"maxWindDirectDisp":"东东北","maxWindDirection":72,"maxWindSpeed":6.3,"maxWindSpeedTime":39240000,"windDirectDisp":"东东北","windDirection":58,"windSpeed":4.4,"maxJdWindDirectDisp":"东东北","maxJdWindDirection":74,"maxJdWindSpeed":9.9,"maxJdWindSpeedTime":38340000,"rainfallPerHour":0,"temp":28.7,"maxTemp":29.3,"maxTempTime":36060000,"minTemp":28.7,"minTempTime":39600000,"humidity":82,"minHumidity":77,"minHumidityTime":36060000,"waterPress":null,"dewTemp":null,"stationPress":989.7,"maxStationPress":989.7,"maxStationPressTime":39540000,"minStationPress":989.1,"minStationPressTime":36120000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181568919de01568920545323a0","station":"59132","dataTime":1471174800000,"timeFlag":40,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471174800000,"windDirectDisp2m":"东","windDirection2m":81,"windSpeed2m":4.2,"windDirectDisp10m":"东东北","windDirection10m":77,"windSpeed10m":4.3,"maxWindDirectDisp":"东东北","maxWindDirection":75,"maxWindSpeed":5.9,"maxWindSpeedTime":39660000,"windDirectDisp":"东","windDirection":88,"windSpeed":4.1,"maxJdWindDirectDisp":"东东南","maxJdWindDirection":102,"maxJdWindSpeed":7.7,"maxJdWindSpeedTime":39900000,"rainfallPerHour":0,"temp":28,"maxTemp":28.7,"maxTempTime":39660000,"minTemp":27.9,"minTempTime":41280000,"humidity":89,"minHumidity":83,"minHumidityTime":39660000,"waterPress":null,"dewTemp":null,"stationPress":990.3,"maxStationPress":990.3,"maxStationPressTime":42000000,"minStationPress":989.7,"minStationPressTime":39960000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181568919de01568920bb633417","station":"59132","dataTime":1471175100000,"timeFlag":45,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471175100000,"windDirectDisp2m":"东","windDirection2m":85,"windSpeed2m":3.6,"windDirectDisp10m":"东","windDirection10m":79,"windSpeed10m":4,"maxWindDirectDisp":"东东北","maxWindDirection":75,"maxWindSpeed":5.9,"maxWindSpeedTime":39660000,"windDirectDisp":"东","windDirection":97,"windSpeed":5.3,"maxJdWindDirectDisp":"东东南","maxJdWindDirection":102,"maxJdWindSpeed":7.7,"maxJdWindSpeedTime":39900000,"rainfallPerHour":0,"temp":28,"maxTemp":28.7,"maxTempTime":39660000,"minTemp":27.9,"minTempTime":41280000,"humidity":88,"minHumidity":83,"minHumidityTime":39660000,"waterPress":null,"dewTemp":null,"stationPress":990.4,"maxStationPress":990.4,"maxStationPressTime":42300000,"minStationPress":989.7,"minStationPressTime":39960000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181568919de015689212650444e","station":"59132","dataTime":1471175400000,"timeFlag":50,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471175400000,"windDirectDisp2m":"东","windDirection2m":85,"windSpeed2m":3.5,"windDirectDisp10m":"东","windDirection10m":82,"windSpeed10m":3.7,"maxWindDirectDisp":"东东北","maxWindDirection":75,"maxWindSpeed":5.9,"maxWindSpeedTime":39660000,"windDirectDisp":"东东北","windDirection":77,"windSpeed":3.7,"maxJdWindDirectDisp":"东东南","maxJdWindDirection":102,"maxJdWindSpeed":7.7,"maxJdWindSpeedTime":39900000,"rainfallPerHour":0,"temp":27.9,"maxTemp":28.7,"maxTempTime":39660000,"minTemp":27.9,"minTempTime":41280000,"humidity":89,"minHumidity":83,"minHumidityTime":39660000,"waterPress":null,"dewTemp":null,"stationPress":990.4,"maxStationPress":990.4,"maxStationPressTime":42480000,"minStationPress":989.7,"minStationPressTime":39960000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181568919de01568921a33054d9","station":"59132","dataTime":1471175700000,"timeFlag":55,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471175700000,"windDirectDisp2m":"东","windDirection2m":86,"windSpeed2m":3.3,"windDirectDisp10m":"东","windDirection10m":83,"windSpeed10m":3.5,"maxWindDirectDisp":"东东北","maxWindDirection":75,"maxWindSpeed":5.9,"maxWindSpeedTime":39660000,"windDirectDisp":"东东南","windDirection":105,"windSpeed":3.1,"maxJdWindDirectDisp":"东东南","maxJdWindDirection":102,"maxJdWindSpeed":7.7,"maxJdWindSpeedTime":39900000,"rainfallPerHour":0,"temp":27.9,"maxTemp":28.7,"maxTempTime":39660000,"minTemp":27.9,"minTempTime":42900000,"humidity":89,"minHumidity":83,"minHumidityTime":39660000,"waterPress":null,"dewTemp":null,"stationPress":990.4,"maxStationPress":990.4,"maxStationPressTime":42900000,"minStationPress":989.7,"minStationPressTime":39960000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181568919de01568922259d64da","station":"59132","dataTime":1471176000000,"timeFlag":0,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471176000000,"windDirectDisp2m":"东","windDirection2m":92,"windSpeed2m":3.6,"windDirectDisp10m":"东","windDirection10m":88,"windSpeed10m":3.3,"maxWindDirectDisp":"东东北","maxWindDirection":75,"maxWindSpeed":5.9,"maxWindSpeedTime":39660000,"windDirectDisp":"东","windDirection":92,"windSpeed":4,"maxJdWindDirectDisp":"东东南","maxJdWindDirection":102,"maxJdWindSpeed":7.7,"maxJdWindSpeedTime":39900000,"rainfallPerHour":0,"temp":27.8,"maxTemp":28.7,"maxTempTime":39660000,"minTemp":27.8,"minTempTime":43200000,"humidity":90,"minHumidity":83,"minHumidityTime":39660000,"waterPress":null,"dewTemp":null,"stationPress":990.4,"maxStationPress":990.5,"maxStationPressTime":43140000,"minStationPress":989.7,"minStationPressTime":39960000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181568919de01568922a68475e3","station":"59132","dataTime":1471176300000,"timeFlag":5,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471176300000,"windDirectDisp2m":"东","windDirection2m":83,"windSpeed2m":3.5,"windDirectDisp10m":"东","windDirection10m":86,"windSpeed10m":3.3,"maxWindDirectDisp":"东","maxWindDirection":86,"maxWindSpeed":3.3,"maxWindSpeedTime":43500000,"windDirectDisp":"东","windDirection":85,"windSpeed":4.3,"maxJdWindDirectDisp":"东东南","maxJdWindDirection":110,"maxJdWindSpeed":4.6,"maxJdWindSpeedTime":43320000,"rainfallPerHour":0,"temp":27.8,"maxTemp":27.8,"maxTempTime":43260000,"minTemp":27.8,"minTempTime":43440000,"humidity":90,"minHumidity":90,"minHumidityTime":43320000,"waterPress":null,"dewTemp":null,"stationPress":990.4,"maxStationPress":990.5,"maxStationPressTime":43440000,"minStationPress":990.4,"minStationPressTime":43320000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181568919de015689230d2b05f2","station":"59132","dataTime":1471176600000,"timeFlag":10,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471176600000,"windDirectDisp2m":"东东北","windDirection2m":73,"windSpeed2m":3.7,"windDirectDisp10m":"东","windDirection10m":80,"windSpeed10m":3.5,"maxWindDirectDisp":"东","maxWindDirection":80,"maxWindSpeed":3.5,"maxWindSpeedTime":43800000,"windDirectDisp":"东","windDirection":88,"windSpeed":3.4,"maxJdWindDirectDisp":"东东北","maxJdWindDirection":74,"maxJdWindSpeed":4.9,"maxJdWindSpeedTime":43740000,"rainfallPerHour":0,"temp":27.8,"maxTemp":27.8,"maxTempTime":43260000,"minTemp":27.8,"minTempTime":43740000,"humidity":90,"minHumidity":90,"minHumidityTime":43320000,"waterPress":null,"dewTemp":null,"stationPress":990.4,"maxStationPress":990.5,"maxStationPressTime":43440000,"minStationPress":990.4,"minStationPressTime":43740000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181568919de0156892376241685","station":"59132","dataTime":1471176900000,"timeFlag":15,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471176900000,"windDirectDisp2m":"东东北","windDirection2m":76,"windSpeed2m":3.3,"windDirectDisp10m":"东东北","windDirection10m":78,"windSpeed10m":3.7,"maxWindDirectDisp":"东","maxWindDirection":79,"maxWindSpeed":3.9,"maxWindSpeedTime":43980000,"windDirectDisp":"东东北","windDirection":63,"windSpeed":2.6,"maxJdWindDirectDisp":"东东北","maxJdWindDirection":63,"maxJdWindSpeed":6.2,"maxJdWindSpeedTime":43860000,"rainfallPerHour":0,"temp":27.9,"maxTemp":27.9,"maxTempTime":44100000,"minTemp":27.8,"minTempTime":43740000,"humidity":89,"minHumidity":89,"minHumidityTime":44100000,"waterPress":null,"dewTemp":null,"stationPress":990.6,"maxStationPress":990.6,"maxStationPressTime":44040000,"minStationPress":990.4,"minStationPressTime":43740000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181568919de01568923fed026bc","station":"59132","dataTime":1471177200000,"timeFlag":20,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471177200000,"windDirectDisp2m":"东","windDirection2m":81,"windSpeed2m":3.5,"windDirectDisp10m":"东东北","windDirection10m":78,"windSpeed10m":3.6,"maxWindDirectDisp":"东","maxWindDirection":79,"maxWindSpeed":3.9,"maxWindSpeedTime":43980000,"windDirectDisp":"东","windDirection":85,"windSpeed":3.3,"maxJdWindDirectDisp":"东东北","maxJdWindDirection":63,"maxJdWindSpeed":6.2,"maxJdWindSpeedTime":43860000,"rainfallPerHour":0,"temp":27.9,"maxTemp":27.9,"maxTempTime":44220000,"minTemp":27.8,"minTempTime":43740000,"humidity":90,"minHumidity":89,"minHumidityTime":44160000,"waterPress":null,"dewTemp":null,"stationPress":990.6,"maxStationPress":990.6,"maxStationPressTime":44340000,"minStationPress":990.4,"minStationPressTime":43740000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181568919de0156892486d53759","station":"59132","dataTime":1471177500000,"timeFlag":25,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471177500000,"windDirectDisp2m":"东东北","windDirection2m":75,"windSpeed2m":2.8,"windDirectDisp10m":"东东北","windDirection10m":77,"windSpeed10m":3.2,"maxWindDirectDisp":"东","maxWindDirection":79,"maxWindSpeed":3.9,"maxWindSpeedTime":43980000,"windDirectDisp":"东","windDirection":92,"windSpeed":1.6,"maxJdWindDirectDisp":"东东北","maxJdWindDirection":63,"maxJdWindSpeed":6.2,"maxJdWindSpeedTime":43860000,"rainfallPerHour":0,"temp":27.8,"maxTemp":27.9,"maxTempTime":44220000,"minTemp":27.8,"minTempTime":43740000,"humidity":90,"minHumidity":89,"minHumidityTime":44160000,"waterPress":null,"dewTemp":null,"stationPress":990.7,"maxStationPress":990.7,"maxStationPressTime":44640000,"minStationPress":990.4,"minStationPressTime":43740000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"40287181568919de0156892520784752","station":"59132","dataTime":1471177800000,"timeFlag":30,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471177800000,"windDirectDisp2m":"东东北","windDirection2m":73,"windSpeed2m":3.3,"windDirectDisp10m":"东东北","windDirection10m":76,"windSpeed10m":3.2,"maxWindDirectDisp":"东","maxWindDirection":79,"maxWindSpeed":3.9,"maxWindSpeedTime":43980000,"windDirectDisp":"东东北","windDirection":71,"windSpeed":3.9,"maxJdWindDirectDisp":"东东北","maxJdWindDirection":63,"maxJdWindSpeed":6.2,"maxJdWindSpeedTime":43860000,"rainfallPerHour":0,"temp":27.8,"maxTemp":27.9,"maxTempTime":44220000,"minTemp":27.8,"minTempTime":43740000,"humidity":90,"minHumidity":89,"minHumidityTime":44160000,"waterPress":null,"dewTemp":null,"stationPress":990.8,"maxStationPress":990.8,"maxStationPressTime":45000000,"minStationPress":990.4,"minStationPressTime":43740000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"402871815689319d01568931d2ec00ef","station":"59132","dataTime":1471178400000,"timeFlag":40,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471178400000,"windDirectDisp2m":"东东北","windDirection2m":69,"windSpeed2m":2.3,"windDirectDisp10m":"东东北","windDirection10m":72,"windSpeed10m":2.8,"maxWindDirectDisp":"东","maxWindDirection":79,"maxWindSpeed":3.9,"maxWindSpeedTime":43980000,"windDirectDisp":"东东南","windDirection":113,"windSpeed":1.6,"maxJdWindDirectDisp":"东东北","maxJdWindDirection":63,"maxJdWindSpeed":6.2,"maxJdWindSpeedTime":43860000,"rainfallPerHour":0,"temp":27.9,"maxTemp":27.9,"maxTempTime":44220000,"minTemp":27.8,"minTempTime":43740000,"humidity":89,"minHumidity":89,"minHumidityTime":45540000,"waterPress":null,"dewTemp":null,"stationPress":990.8,"maxStationPress":990.8,"maxStationPressTime":45600000,"minStationPress":990.4,"minStationPressTime":43740000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"402871815689319d0156893284911170","station":"59132","dataTime":1471178700000,"timeFlag":45,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471178700000,"windDirectDisp2m":"东东北","windDirection2m":70,"windSpeed2m":2.5,"windDirectDisp10m":"东东北","windDirection10m":66,"windSpeed10m":2.7,"maxWindDirectDisp":"东","maxWindDirection":79,"maxWindSpeed":3.9,"maxWindSpeedTime":43980000,"windDirectDisp":"东东南","windDirection":119,"windSpeed":2.3,"maxJdWindDirectDisp":"东东北","maxJdWindDirection":63,"maxJdWindSpeed":6.2,"maxJdWindSpeedTime":43860000,"rainfallPerHour":0,"temp":27.9,"maxTemp":27.9,"maxTempTime":44220000,"minTemp":27.8,"minTempTime":43740000,"humidity":90,"minHumidity":89,"minHumidityTime":45540000,"waterPress":null,"dewTemp":null,"stationPress":990.8,"maxStationPress":990.8,"maxStationPressTime":45900000,"minStationPress":990.4,"minStationPressTime":43740000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"402871815689319d01568933406e21ed","station":"59132","dataTime":1471179000000,"timeFlag":50,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471179000000,"windDirectDisp2m":"东东北","windDirection2m":76,"windSpeed2m":3.5,"windDirectDisp10m":"东东北","windDirection10m":71,"windSpeed10m":3.1,"maxWindDirectDisp":"东","maxWindDirection":79,"maxWindSpeed":3.9,"maxWindSpeedTime":43980000,"windDirectDisp":"东东南","windDirection":113,"windSpeed":3.1,"maxJdWindDirectDisp":"东东北","maxJdWindDirection":63,"maxJdWindSpeed":6.2,"maxJdWindSpeedTime":43860000,"rainfallPerHour":0,"temp":27.8,"maxTemp":27.9,"maxTempTime":44220000,"minTemp":27.8,"minTempTime":43740000,"humidity":90,"minHumidity":89,"minHumidityTime":45540000,"waterPress":null,"dewTemp":null,"stationPress":990.9,"maxStationPress":990.9,"maxStationPressTime":46200000,"minStationPress":990.4,"minStationPressTime":43740000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"402871815689319d01568934078a324c","station":"59132","dataTime":1471179300000,"timeFlag":55,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471179300000,"windDirectDisp2m":"东东北","windDirection2m":68,"windSpeed2m":2.8,"windDirectDisp10m":"东东北","windDirection10m":70,"windSpeed10m":3.1,"maxWindDirectDisp":"东","maxWindDirection":79,"maxWindSpeed":3.9,"maxWindSpeedTime":43980000,"windDirectDisp":"东","windDirection":84,"windSpeed":1.7,"maxJdWindDirectDisp":"东东北","maxJdWindDirection":63,"maxJdWindSpeed":6.2,"maxJdWindSpeedTime":43860000,"rainfallPerHour":0,"temp":27.8,"maxTemp":27.9,"maxTempTime":44220000,"minTemp":27.8,"minTempTime":43740000,"humidity":90,"minHumidity":89,"minHumidityTime":45540000,"waterPress":null,"dewTemp":null,"stationPress":990.9,"maxStationPress":990.9,"maxStationPressTime":46440000,"minStationPress":990.4,"minStationPressTime":43740000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"402871815689319d01568934c8c94253","station":"59132","dataTime":1471179600000,"timeFlag":0,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471179600000,"windDirectDisp2m":"东","windDirection2m":79,"windSpeed2m":2.6,"windDirectDisp10m":"东东北","windDirection10m":74,"windSpeed10m":2.9,"maxWindDirectDisp":"东","maxWindDirection":79,"maxWindSpeed":3.9,"maxWindSpeedTime":43980000,"windDirectDisp":"东","windDirection":85,"windSpeed":3.1,"maxJdWindDirectDisp":"东东北","maxJdWindDirection":63,"maxJdWindSpeed":6.2,"maxJdWindSpeedTime":43860000,"rainfallPerHour":0,"temp":27.8,"maxTemp":27.9,"maxTempTime":44220000,"minTemp":27.8,"minTempTime":43740000,"humidity":90,"minHumidity":89,"minHumidityTime":45540000,"waterPress":null,"dewTemp":null,"stationPress":991,"maxStationPress":991,"maxStationPressTime":46800000,"minStationPress":990.4,"minStationPressTime":43740000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"402871815689319d01568935824252e0","station":"59132","dataTime":1471179900000,"timeFlag":5,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471179900000,"windDirectDisp2m":"东","windDirection2m":88,"windSpeed2m":2.4,"windDirectDisp10m":"东","windDirection10m":80,"windSpeed10m":2.7,"maxWindDirectDisp":"东东北","maxWindDirection":74,"maxWindSpeed":3,"maxWindSpeedTime":46860000,"windDirectDisp":"东","windDirection":91,"windSpeed":3.3,"maxJdWindDirectDisp":"东东北","maxJdWindDirection":74,"maxJdWindSpeed":4.9,"maxJdWindSpeedTime":46860000,"rainfallPerHour":0,"temp":27.8,"maxTemp":27.8,"maxTempTime":46920000,"minTemp":27.8,"minTempTime":47100000,"humidity":90,"minHumidity":90,"minHumidityTime":46920000,"waterPress":null,"dewTemp":null,"stationPress":991.1,"maxStationPress":991.1,"maxStationPressTime":47100000,"minStationPress":991,"minStationPressTime":46860000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null},{"uid":null,"voParams":null,"params":null,"voList":null,"itemList":null,"sid":"402871815689319d0156893625b362e5","station":"59132","dataTime":1471180200000,"timeFlag":10,"longitude":118.3731,"latitude":24.5358,"pressureAltitude":107.2,"observeAltitude":106,"observeMode":4,"observeTime":1471180200000,"windDirectDisp2m":"东","windDirection2m":92,"windSpeed2m":2.4,"windDirectDisp10m":"东","windDirection10m":87,"windSpeed10m":2.6,"maxWindDirectDisp":"东东北","maxWindDirection":74,"maxWindSpeed":3,"maxWindSpeedTime":46860000,"windDirectDisp":"东","windDirection":79,"windSpeed":2.9,"maxJdWindDirectDisp":"东东北","maxJdWindDirection":74,"maxJdWindSpeed":4.9,"maxJdWindSpeedTime":46860000,"rainfallPerHour":0,"temp":27.7,"maxTemp":27.8,"maxTempTime":46920000,"minTemp":27.7,"minTempTime":47400000,"humidity":90,"minHumidity":90,"minHumidityTime":47160000,"waterPress":null,"dewTemp":null,"stationPress":991.1,"maxStationPress":991.2,"maxStationPressTime":47340000,"minStationPress":991,"minStationPressTime":46860000,"grassTemp":null,"grassMaxTemp":null,"grassMaxTempTime":null,"grassMinTemp":null,"grassMinTempTime":null,"groundTemp":null,"groundMaxTemp":null,"groundMaxTempTime":null,"groundMinTemp":null,"groundMinTempTime":null,"groundTemp5cm":null,"groundTemp10cm":null,"groundTemp15cm":null,"groundTemp20cm":null,"groundTemp40cm":null,"groundTemp80cm":null,"groundTemp160cm":null,"groundTemp320cm":null,"evaporation":null,"seaPress":null,"visibility":null,"minVis":null,"minVisTime":null,"totalRainfall1":null,"totalRainfall2":null,"totalRainfall3":null,"totalRainfall4":null,"totalRainfall5":null,"totalRainfall6":null,"totalRainfall7":null,"totalRainfall8":null,"totalRainfall9":null,"totalRainfall10":null,"totalRainfall11":null,"totalRainfall12":null,"totalRainfall13":null,"totalRainfall14":null,"totalRainfall15":null,"totalRainfall16":null,"totalRainfall17":null,"totalRainfall18":null,"totalRainfall19":null,"totalRainfall20":null,"totalRainfall21":null,"totalRainfall22":null,"totalRainfall23":null,"totalRainfall24":null,"totalRainfall25":null,"totalRainfall26":null,"totalRainfall27":null,"totalRainfall28":null,"totalRainfall29":null,"totalRainfall30":null,"totalRainfall31":null,"totalRainfall32":null,"totalRainfall33":null,"totalRainfall34":null,"totalRainfall35":null,"totalRainfall36":null,"totalRainfall37":null,"totalRainfall38":null,"totalRainfall39":null,"totalRainfall40":null,"totalRainfall41":null,"totalRainfall42":null,"totalRainfall43":null,"totalRainfall44":null,"totalRainfall45":null,"totalRainfall46":null,"totalRainfall47":null,"totalRainfall48":null,"totalRainfall49":null,"totalRainfall50":null,"totalRainfall51":null,"totalRainfall52":null,"totalRainfall53":null,"totalRainfall54":null,"totalRainfall55":null,"totalRainfall56":null,"totalRainfall57":null,"totalRainfall58":null,"totalRainfall59":null,"totalRainfall60":null}]
     */

    private int total;
    /**
     * uid : null
     * voParams : null
     * params : null
     * voList : null
     * itemList : null
     * sid : 40287181568919de0156891f662a00e4
     * station : 59132
     * dataTime : 1471168800000
     * timeFlag : 0
     * longitude : 118.3731
     * latitude : 24.5358
     * pressureAltitude : 107.2
     * observeAltitude : 106.0
     * observeMode : 4
     * observeTime : 1471168800000
     * windDirectDisp2m : 东东北
     * windDirection2m : 72.0
     * windSpeed2m : 6.2
     * windDirectDisp10m : 东东北
     * windDirection10m : 68.0
     * windSpeed10m : 5.7
     * maxWindDirectDisp : 东东北
     * maxWindDirection : 66.0
     * maxWindSpeed : 6.8
     * maxWindSpeedTime : 32580000
     * windDirectDisp : 东东北
     * windDirection : 74.0
     * windSpeed : 5.8
     * maxJdWindDirectDisp : 东
     * maxJdWindDirection : 82.0
     * maxJdWindSpeed : 10.2
     * maxJdWindSpeedTime : 35940000
     * rainfallPerHour : 0.0
     * temp : 29.3
     * maxTemp : 29.7
     * maxTempTime : 32460000
     * minTemp : 29.3
     * minTempTime : 36000000
     * humidity : 77.0
     * minHumidity : 73.0
     * minHumidityTime : 32460000
     * waterPress : null
     * dewTemp : null
     * stationPress : 989.1
     * maxStationPress : 989.1
     * maxStationPressTime : 36000000
     * minStationPress : 988.5
     * minStationPressTime : 32760000
     * grassTemp : null
     * grassMaxTemp : null
     * grassMaxTempTime : null
     * grassMinTemp : null
     * grassMinTempTime : null
     * groundTemp : null
     * groundMaxTemp : null
     * groundMaxTempTime : null
     * groundMinTemp : null
     * groundMinTempTime : null
     * groundTemp5cm : null
     * groundTemp10cm : null
     * groundTemp15cm : null
     * groundTemp20cm : null
     * groundTemp40cm : null
     * groundTemp80cm : null
     * groundTemp160cm : null
     * groundTemp320cm : null
     * evaporation : null
     * seaPress : null
     * visibility : null
     * minVis : null
     * minVisTime : null
     * totalRainfall1 : null
     * totalRainfall2 : null
     * totalRainfall3 : null
     * totalRainfall4 : null
     * totalRainfall5 : null
     * totalRainfall6 : null
     * totalRainfall7 : null
     * totalRainfall8 : null
     * totalRainfall9 : null
     * totalRainfall10 : null
     * totalRainfall11 : null
     * totalRainfall12 : null
     * totalRainfall13 : null
     * totalRainfall14 : null
     * totalRainfall15 : null
     * totalRainfall16 : null
     * totalRainfall17 : null
     * totalRainfall18 : null
     * totalRainfall19 : null
     * totalRainfall20 : null
     * totalRainfall21 : null
     * totalRainfall22 : null
     * totalRainfall23 : null
     * totalRainfall24 : null
     * totalRainfall25 : null
     * totalRainfall26 : null
     * totalRainfall27 : null
     * totalRainfall28 : null
     * totalRainfall29 : null
     * totalRainfall30 : null
     * totalRainfall31 : null
     * totalRainfall32 : null
     * totalRainfall33 : null
     * totalRainfall34 : null
     * totalRainfall35 : null
     * totalRainfall36 : null
     * totalRainfall37 : null
     * totalRainfall38 : null
     * totalRainfall39 : null
     * totalRainfall40 : null
     * totalRainfall41 : null
     * totalRainfall42 : null
     * totalRainfall43 : null
     * totalRainfall44 : null
     * totalRainfall45 : null
     * totalRainfall46 : null
     * totalRainfall47 : null
     * totalRainfall48 : null
     * totalRainfall49 : null
     * totalRainfall50 : null
     * totalRainfall51 : null
     * totalRainfall52 : null
     * totalRainfall53 : null
     * totalRainfall54 : null
     * totalRainfall55 : null
     * totalRainfall56 : null
     * totalRainfall57 : null
     * totalRainfall58 : null
     * totalRainfall59 : null
     * totalRainfall60 : null
     */

    private List<RowsBean> rows;


    public WeatherHour(int total, List<RowsBean> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {

        @Override
        public String toString() {
            return "RowsBean{" +
                    "uid=" + uid +
                    ", voParams=" + voParams +
                    ", params=" + params +
                    ", voList=" + voList +
                    ", itemList=" + itemList +
                    ", sid='" + sid + '\'' +
                    ", station='" + station + '\'' +
                    ", dataTime=" + dataTime +
                    ", timeFlag=" + timeFlag +
                    ", longitude=" + longitude +
                    ", latitude=" + latitude +
                    ", pressureAltitude=" + pressureAltitude +
                    ", observeAltitude=" + observeAltitude +
                    ", observeMode=" + observeMode +
                    ", observeTime=" + observeTime +
                    ", windDirectDisp2m='" + windDirectDisp2m + '\'' +
                    ", windDirection2m=" + windDirection2m +
                    ", windSpeed2m=" + windSpeed2m +
                    ", windDirectDisp10m='" + windDirectDisp10m + '\'' +
                    ", windDirection10m=" + windDirection10m +
                    ", windSpeed10m=" + windSpeed10m +
                    ", maxWindDirectDisp='" + maxWindDirectDisp + '\'' +
                    ", maxWindDirection=" + maxWindDirection +
                    ", maxWindSpeed=" + maxWindSpeed +
                    ", maxWindSpeedTime=" + maxWindSpeedTime +
                    ", windDirectDisp='" + windDirectDisp + '\'' +
                    ", windDirection=" + windDirection +
                    ", windSpeed=" + windSpeed +
                    ", maxJdWindDirectDisp='" + maxJdWindDirectDisp + '\'' +
                    ", maxJdWindDirection=" + maxJdWindDirection +
                    ", maxJdWindSpeed=" + maxJdWindSpeed +
                    ", maxJdWindSpeedTime=" + maxJdWindSpeedTime +
                    ", rainfallPerHour=" + rainfallPerHour +
                    ", temp=" + temp +
                    ", maxTemp=" + maxTemp +
                    ", maxTempTime=" + maxTempTime +
                    ", minTemp=" + minTemp +
                    ", minTempTime=" + minTempTime +
                    ", humidity=" + humidity +
                    ", minHumidity=" + minHumidity +
                    ", minHumidityTime=" + minHumidityTime +
                    ", waterPress=" + waterPress +
                    ", dewTemp=" + dewTemp +
                    ", stationPress=" + stationPress +
                    ", maxStationPress=" + maxStationPress +
                    ", maxStationPressTime=" + maxStationPressTime +
                    ", minStationPress=" + minStationPress +
                    ", minStationPressTime=" + minStationPressTime +
                    ", grassTemp=" + grassTemp +
                    ", grassMaxTemp=" + grassMaxTemp +
                    ", grassMaxTempTime=" + grassMaxTempTime +
                    ", grassMinTemp=" + grassMinTemp +
                    ", grassMinTempTime=" + grassMinTempTime +
                    ", groundTemp=" + groundTemp +
                    ", groundMaxTemp=" + groundMaxTemp +
                    ", groundMaxTempTime=" + groundMaxTempTime +
                    ", groundMinTemp=" + groundMinTemp +
                    ", groundMinTempTime=" + groundMinTempTime +
                    ", groundTemp5cm=" + groundTemp5cm +
                    ", groundTemp10cm=" + groundTemp10cm +
                    ", groundTemp15cm=" + groundTemp15cm +
                    ", groundTemp20cm=" + groundTemp20cm +
                    ", groundTemp40cm=" + groundTemp40cm +
                    ", groundTemp80cm=" + groundTemp80cm +
                    ", groundTemp160cm=" + groundTemp160cm +
                    ", groundTemp320cm=" + groundTemp320cm +
                    ", evaporation=" + evaporation +
                    ", seaPress=" + seaPress +
                    ", visibility=" + visibility +
                    ", minVis=" + minVis +
                    ", minVisTime=" + minVisTime +
                    ", totalRainfall1=" + totalRainfall1 +
                    ", totalRainfall2=" + totalRainfall2 +
                    ", totalRainfall3=" + totalRainfall3 +
                    ", totalRainfall4=" + totalRainfall4 +
                    ", totalRainfall5=" + totalRainfall5 +
                    ", totalRainfall6=" + totalRainfall6 +
                    ", totalRainfall7=" + totalRainfall7 +
                    ", totalRainfall8=" + totalRainfall8 +
                    ", totalRainfall9=" + totalRainfall9 +
                    ", totalRainfall10=" + totalRainfall10 +
                    ", totalRainfall11=" + totalRainfall11 +
                    ", totalRainfall12=" + totalRainfall12 +
                    ", totalRainfall13=" + totalRainfall13 +
                    ", totalRainfall14=" + totalRainfall14 +
                    ", totalRainfall15=" + totalRainfall15 +
                    ", totalRainfall16=" + totalRainfall16 +
                    ", totalRainfall17=" + totalRainfall17 +
                    ", totalRainfall18=" + totalRainfall18 +
                    ", totalRainfall19=" + totalRainfall19 +
                    ", totalRainfall20=" + totalRainfall20 +
                    ", totalRainfall21=" + totalRainfall21 +
                    ", totalRainfall22=" + totalRainfall22 +
                    ", totalRainfall23=" + totalRainfall23 +
                    ", totalRainfall24=" + totalRainfall24 +
                    ", totalRainfall25=" + totalRainfall25 +
                    ", totalRainfall26=" + totalRainfall26 +
                    ", totalRainfall27=" + totalRainfall27 +
                    ", totalRainfall28=" + totalRainfall28 +
                    ", totalRainfall29=" + totalRainfall29 +
                    ", totalRainfall30=" + totalRainfall30 +
                    ", totalRainfall31=" + totalRainfall31 +
                    ", totalRainfall32=" + totalRainfall32 +
                    ", totalRainfall33=" + totalRainfall33 +
                    ", totalRainfall34=" + totalRainfall34 +
                    ", totalRainfall35=" + totalRainfall35 +
                    ", totalRainfall36=" + totalRainfall36 +
                    ", totalRainfall37=" + totalRainfall37 +
                    ", totalRainfall38=" + totalRainfall38 +
                    ", totalRainfall39=" + totalRainfall39 +
                    ", totalRainfall40=" + totalRainfall40 +
                    ", totalRainfall41=" + totalRainfall41 +
                    ", totalRainfall42=" + totalRainfall42 +
                    ", totalRainfall43=" + totalRainfall43 +
                    ", totalRainfall44=" + totalRainfall44 +
                    ", totalRainfall45=" + totalRainfall45 +
                    ", totalRainfall46=" + totalRainfall46 +
                    ", totalRainfall47=" + totalRainfall47 +
                    ", totalRainfall48=" + totalRainfall48 +
                    ", totalRainfall49=" + totalRainfall49 +
                    ", totalRainfall50=" + totalRainfall50 +
                    ", totalRainfall51=" + totalRainfall51 +
                    ", totalRainfall52=" + totalRainfall52 +
                    ", totalRainfall53=" + totalRainfall53 +
                    ", totalRainfall54=" + totalRainfall54 +
                    ", totalRainfall55=" + totalRainfall55 +
                    ", totalRainfall56=" + totalRainfall56 +
                    ", totalRainfall57=" + totalRainfall57 +
                    ", totalRainfall58=" + totalRainfall58 +
                    ", totalRainfall59=" + totalRainfall59 +
                    ", totalRainfall60=" + totalRainfall60 +
                    '}';
        }

        private Object uid;
        private Object voParams;
        private Object params;
        private Object voList;
        private Object itemList;
        private String sid;
        private String station;
        private long dataTime;
        private int timeFlag;
        private double longitude;
        private double latitude;
        private double pressureAltitude;
        private double observeAltitude;
        private int observeMode;
        private long observeTime;
        private String windDirectDisp2m;
        private double windDirection2m;
        private double windSpeed2m;
        private String windDirectDisp10m;
        private double windDirection10m;
        private double windSpeed10m;
        private String maxWindDirectDisp;
        private double maxWindDirection;
        private double maxWindSpeed;
        private int maxWindSpeedTime;
        private String windDirectDisp;
        private double windDirection;
        private double windSpeed;
        private String maxJdWindDirectDisp;
        private double maxJdWindDirection;
        private double maxJdWindSpeed;
        private int maxJdWindSpeedTime;
        private double rainfallPerHour;
        private double temp;
        private double maxTemp;
        private int maxTempTime;
        private double minTemp;
        private int minTempTime;
        private double humidity;
        private double minHumidity;
        private int minHumidityTime;
        private Object waterPress;
        private Object dewTemp;
        private double stationPress;
        private double maxStationPress;
        private int maxStationPressTime;
        private double minStationPress;
        private int minStationPressTime;
        private Object grassTemp;
        private Object grassMaxTemp;
        private Object grassMaxTempTime;
        private Object grassMinTemp;
        private Object grassMinTempTime;
        private Object groundTemp;
        private Object groundMaxTemp;
        private Object groundMaxTempTime;
        private Object groundMinTemp;
        private Object groundMinTempTime;
        private Object groundTemp5cm;
        private Object groundTemp10cm;
        private Object groundTemp15cm;
        private Object groundTemp20cm;
        private Object groundTemp40cm;
        private Object groundTemp80cm;
        private Object groundTemp160cm;
        private Object groundTemp320cm;
        private Object evaporation;
        private Object seaPress;
        private Object visibility;
        private Object minVis;
        private Object minVisTime;
        private Object totalRainfall1;
        private Object totalRainfall2;
        private Object totalRainfall3;
        private Object totalRainfall4;
        private Object totalRainfall5;
        private Object totalRainfall6;
        private Object totalRainfall7;
        private Object totalRainfall8;
        private Object totalRainfall9;
        private Object totalRainfall10;
        private Object totalRainfall11;
        private Object totalRainfall12;
        private Object totalRainfall13;
        private Object totalRainfall14;
        private Object totalRainfall15;
        private Object totalRainfall16;
        private Object totalRainfall17;
        private Object totalRainfall18;
        private Object totalRainfall19;
        private Object totalRainfall20;
        private Object totalRainfall21;
        private Object totalRainfall22;
        private Object totalRainfall23;
        private Object totalRainfall24;
        private Object totalRainfall25;
        private Object totalRainfall26;
        private Object totalRainfall27;
        private Object totalRainfall28;
        private Object totalRainfall29;
        private Object totalRainfall30;
        private Object totalRainfall31;
        private Object totalRainfall32;
        private Object totalRainfall33;
        private Object totalRainfall34;
        private Object totalRainfall35;
        private Object totalRainfall36;
        private Object totalRainfall37;
        private Object totalRainfall38;
        private Object totalRainfall39;
        private Object totalRainfall40;
        private Object totalRainfall41;
        private Object totalRainfall42;
        private Object totalRainfall43;
        private Object totalRainfall44;
        private Object totalRainfall45;
        private Object totalRainfall46;
        private Object totalRainfall47;
        private Object totalRainfall48;
        private Object totalRainfall49;
        private Object totalRainfall50;
        private Object totalRainfall51;
        private Object totalRainfall52;
        private Object totalRainfall53;
        private Object totalRainfall54;
        private Object totalRainfall55;
        private Object totalRainfall56;
        private Object totalRainfall57;
        private Object totalRainfall58;
        private Object totalRainfall59;
        private Object totalRainfall60;


        public RowsBean() {
        }

        public Object getUid() {
            return uid;
        }

        public void setUid(Object uid) {
            this.uid = uid;
        }

        public Object getVoParams() {
            return voParams;
        }

        public void setVoParams(Object voParams) {
            this.voParams = voParams;
        }

        public Object getParams() {
            return params;
        }

        public void setParams(Object params) {
            this.params = params;
        }

        public Object getVoList() {
            return voList;
        }

        public void setVoList(Object voList) {
            this.voList = voList;
        }

        public Object getItemList() {
            return itemList;
        }

        public void setItemList(Object itemList) {
            this.itemList = itemList;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getStation() {
            return station;
        }

        public void setStation(String station) {
            this.station = station;
        }

        public long getDataTime() {
            return dataTime;
        }

        public void setDataTime(long dataTime) {
            this.dataTime = dataTime;
        }

        public int getTimeFlag() {
            return timeFlag;
        }

        public void setTimeFlag(int timeFlag) {
            this.timeFlag = timeFlag;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getPressureAltitude() {
            return pressureAltitude;
        }

        public void setPressureAltitude(double pressureAltitude) {
            this.pressureAltitude = pressureAltitude;
        }

        public double getObserveAltitude() {
            return observeAltitude;
        }

        public void setObserveAltitude(double observeAltitude) {
            this.observeAltitude = observeAltitude;
        }

        public int getObserveMode() {
            return observeMode;
        }

        public void setObserveMode(int observeMode) {
            this.observeMode = observeMode;
        }

        public long getObserveTime() {
            return observeTime;
        }

        public void setObserveTime(long observeTime) {
            this.observeTime = observeTime;
        }

        public String getWindDirectDisp2m() {
            return windDirectDisp2m;
        }

        public void setWindDirectDisp2m(String windDirectDisp2m) {
            this.windDirectDisp2m = windDirectDisp2m;
        }

        public double getWindDirection2m() {
            return windDirection2m;
        }

        public void setWindDirection2m(double windDirection2m) {
            this.windDirection2m = windDirection2m;
        }

        public double getWindSpeed2m() {
            return windSpeed2m;
        }

        public void setWindSpeed2m(double windSpeed2m) {
            this.windSpeed2m = windSpeed2m;
        }

        public String getWindDirectDisp10m() {
            return windDirectDisp10m;
        }

        public void setWindDirectDisp10m(String windDirectDisp10m) {
            this.windDirectDisp10m = windDirectDisp10m;
        }

        public double getWindDirection10m() {
            return windDirection10m;
        }

        public void setWindDirection10m(double windDirection10m) {
            this.windDirection10m = windDirection10m;
        }

        public double getWindSpeed10m() {
            return windSpeed10m;
        }

        public void setWindSpeed10m(double windSpeed10m) {
            this.windSpeed10m = windSpeed10m;
        }

        public String getMaxWindDirectDisp() {
            return maxWindDirectDisp;
        }

        public void setMaxWindDirectDisp(String maxWindDirectDisp) {
            this.maxWindDirectDisp = maxWindDirectDisp;
        }

        public double getMaxWindDirection() {
            return maxWindDirection;
        }

        public void setMaxWindDirection(double maxWindDirection) {
            this.maxWindDirection = maxWindDirection;
        }

        public double getMaxWindSpeed() {
            return maxWindSpeed;
        }

        public void setMaxWindSpeed(double maxWindSpeed) {
            this.maxWindSpeed = maxWindSpeed;
        }

        public int getMaxWindSpeedTime() {
            return maxWindSpeedTime;
        }

        public void setMaxWindSpeedTime(int maxWindSpeedTime) {
            this.maxWindSpeedTime = maxWindSpeedTime;
        }

        public String getWindDirectDisp() {
            return windDirectDisp;
        }

        public void setWindDirectDisp(String windDirectDisp) {
            this.windDirectDisp = windDirectDisp;
        }

        public double getWindDirection() {
            return windDirection;
        }

        public void setWindDirection(double windDirection) {
            this.windDirection = windDirection;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }

        public String getMaxJdWindDirectDisp() {
            return maxJdWindDirectDisp;
        }

        public void setMaxJdWindDirectDisp(String maxJdWindDirectDisp) {
            this.maxJdWindDirectDisp = maxJdWindDirectDisp;
        }

        public double getMaxJdWindDirection() {
            return maxJdWindDirection;
        }

        public void setMaxJdWindDirection(double maxJdWindDirection) {
            this.maxJdWindDirection = maxJdWindDirection;
        }

        public double getMaxJdWindSpeed() {
            return maxJdWindSpeed;
        }

        public void setMaxJdWindSpeed(double maxJdWindSpeed) {
            this.maxJdWindSpeed = maxJdWindSpeed;
        }

        public int getMaxJdWindSpeedTime() {
            return maxJdWindSpeedTime;
        }

        public void setMaxJdWindSpeedTime(int maxJdWindSpeedTime) {
            this.maxJdWindSpeedTime = maxJdWindSpeedTime;
        }

        public double getRainfallPerHour() {
            return rainfallPerHour;
        }

        public void setRainfallPerHour(double rainfallPerHour) {
            this.rainfallPerHour = rainfallPerHour;
        }

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getMaxTemp() {
            return maxTemp;
        }

        public void setMaxTemp(double maxTemp) {
            this.maxTemp = maxTemp;
        }

        public int getMaxTempTime() {
            return maxTempTime;
        }

        public void setMaxTempTime(int maxTempTime) {
            this.maxTempTime = maxTempTime;
        }

        public double getMinTemp() {
            return minTemp;
        }

        public void setMinTemp(double minTemp) {
            this.minTemp = minTemp;
        }

        public int getMinTempTime() {
            return minTempTime;
        }

        public void setMinTempTime(int minTempTime) {
            this.minTempTime = minTempTime;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public double getMinHumidity() {
            return minHumidity;
        }

        public void setMinHumidity(double minHumidity) {
            this.minHumidity = minHumidity;
        }

        public int getMinHumidityTime() {
            return minHumidityTime;
        }

        public void setMinHumidityTime(int minHumidityTime) {
            this.minHumidityTime = minHumidityTime;
        }

        public Object getWaterPress() {
            return waterPress;
        }

        public void setWaterPress(Object waterPress) {
            this.waterPress = waterPress;
        }

        public Object getDewTemp() {
            return dewTemp;
        }

        public void setDewTemp(Object dewTemp) {
            this.dewTemp = dewTemp;
        }

        public double getStationPress() {
            return stationPress;
        }

        public void setStationPress(double stationPress) {
            this.stationPress = stationPress;
        }

        public double getMaxStationPress() {
            return maxStationPress;
        }

        public void setMaxStationPress(double maxStationPress) {
            this.maxStationPress = maxStationPress;
        }

        public int getMaxStationPressTime() {
            return maxStationPressTime;
        }

        public void setMaxStationPressTime(int maxStationPressTime) {
            this.maxStationPressTime = maxStationPressTime;
        }

        public double getMinStationPress() {
            return minStationPress;
        }

        public void setMinStationPress(double minStationPress) {
            this.minStationPress = minStationPress;
        }

        public int getMinStationPressTime() {
            return minStationPressTime;
        }

        public void setMinStationPressTime(int minStationPressTime) {
            this.minStationPressTime = minStationPressTime;
        }

        public Object getGrassTemp() {
            return grassTemp;
        }

        public void setGrassTemp(Object grassTemp) {
            this.grassTemp = grassTemp;
        }

        public Object getGrassMaxTemp() {
            return grassMaxTemp;
        }

        public void setGrassMaxTemp(Object grassMaxTemp) {
            this.grassMaxTemp = grassMaxTemp;
        }

        public Object getGrassMaxTempTime() {
            return grassMaxTempTime;
        }

        public void setGrassMaxTempTime(Object grassMaxTempTime) {
            this.grassMaxTempTime = grassMaxTempTime;
        }

        public Object getGrassMinTemp() {
            return grassMinTemp;
        }

        public void setGrassMinTemp(Object grassMinTemp) {
            this.grassMinTemp = grassMinTemp;
        }

        public Object getGrassMinTempTime() {
            return grassMinTempTime;
        }

        public void setGrassMinTempTime(Object grassMinTempTime) {
            this.grassMinTempTime = grassMinTempTime;
        }

        public Object getGroundTemp() {
            return groundTemp;
        }

        public void setGroundTemp(Object groundTemp) {
            this.groundTemp = groundTemp;
        }

        public Object getGroundMaxTemp() {
            return groundMaxTemp;
        }

        public void setGroundMaxTemp(Object groundMaxTemp) {
            this.groundMaxTemp = groundMaxTemp;
        }

        public Object getGroundMaxTempTime() {
            return groundMaxTempTime;
        }

        public void setGroundMaxTempTime(Object groundMaxTempTime) {
            this.groundMaxTempTime = groundMaxTempTime;
        }

        public Object getGroundMinTemp() {
            return groundMinTemp;
        }

        public void setGroundMinTemp(Object groundMinTemp) {
            this.groundMinTemp = groundMinTemp;
        }

        public Object getGroundMinTempTime() {
            return groundMinTempTime;
        }

        public void setGroundMinTempTime(Object groundMinTempTime) {
            this.groundMinTempTime = groundMinTempTime;
        }

        public Object getGroundTemp5cm() {
            return groundTemp5cm;
        }

        public void setGroundTemp5cm(Object groundTemp5cm) {
            this.groundTemp5cm = groundTemp5cm;
        }

        public Object getGroundTemp10cm() {
            return groundTemp10cm;
        }

        public void setGroundTemp10cm(Object groundTemp10cm) {
            this.groundTemp10cm = groundTemp10cm;
        }

        public Object getGroundTemp15cm() {
            return groundTemp15cm;
        }

        public void setGroundTemp15cm(Object groundTemp15cm) {
            this.groundTemp15cm = groundTemp15cm;
        }

        public Object getGroundTemp20cm() {
            return groundTemp20cm;
        }

        public void setGroundTemp20cm(Object groundTemp20cm) {
            this.groundTemp20cm = groundTemp20cm;
        }

        public Object getGroundTemp40cm() {
            return groundTemp40cm;
        }

        public void setGroundTemp40cm(Object groundTemp40cm) {
            this.groundTemp40cm = groundTemp40cm;
        }

        public Object getGroundTemp80cm() {
            return groundTemp80cm;
        }

        public void setGroundTemp80cm(Object groundTemp80cm) {
            this.groundTemp80cm = groundTemp80cm;
        }

        public Object getGroundTemp160cm() {
            return groundTemp160cm;
        }

        public void setGroundTemp160cm(Object groundTemp160cm) {
            this.groundTemp160cm = groundTemp160cm;
        }

        public Object getGroundTemp320cm() {
            return groundTemp320cm;
        }

        public void setGroundTemp320cm(Object groundTemp320cm) {
            this.groundTemp320cm = groundTemp320cm;
        }

        public Object getEvaporation() {
            return evaporation;
        }

        public void setEvaporation(Object evaporation) {
            this.evaporation = evaporation;
        }

        public Object getSeaPress() {
            return seaPress;
        }

        public void setSeaPress(Object seaPress) {
            this.seaPress = seaPress;
        }

        public Object getVisibility() {
            return visibility;
        }

        public void setVisibility(Object visibility) {
            this.visibility = visibility;
        }

        public Object getMinVis() {
            return minVis;
        }

        public void setMinVis(Object minVis) {
            this.minVis = minVis;
        }

        public Object getMinVisTime() {
            return minVisTime;
        }

        public void setMinVisTime(Object minVisTime) {
            this.minVisTime = minVisTime;
        }

        public Object getTotalRainfall1() {
            return totalRainfall1;
        }

        public void setTotalRainfall1(Object totalRainfall1) {
            this.totalRainfall1 = totalRainfall1;
        }

        public Object getTotalRainfall2() {
            return totalRainfall2;
        }

        public void setTotalRainfall2(Object totalRainfall2) {
            this.totalRainfall2 = totalRainfall2;
        }

        public Object getTotalRainfall3() {
            return totalRainfall3;
        }

        public void setTotalRainfall3(Object totalRainfall3) {
            this.totalRainfall3 = totalRainfall3;
        }

        public Object getTotalRainfall4() {
            return totalRainfall4;
        }

        public void setTotalRainfall4(Object totalRainfall4) {
            this.totalRainfall4 = totalRainfall4;
        }

        public Object getTotalRainfall5() {
            return totalRainfall5;
        }

        public void setTotalRainfall5(Object totalRainfall5) {
            this.totalRainfall5 = totalRainfall5;
        }

        public Object getTotalRainfall6() {
            return totalRainfall6;
        }

        public void setTotalRainfall6(Object totalRainfall6) {
            this.totalRainfall6 = totalRainfall6;
        }

        public Object getTotalRainfall7() {
            return totalRainfall7;
        }

        public void setTotalRainfall7(Object totalRainfall7) {
            this.totalRainfall7 = totalRainfall7;
        }

        public Object getTotalRainfall8() {
            return totalRainfall8;
        }

        public void setTotalRainfall8(Object totalRainfall8) {
            this.totalRainfall8 = totalRainfall8;
        }

        public Object getTotalRainfall9() {
            return totalRainfall9;
        }

        public void setTotalRainfall9(Object totalRainfall9) {
            this.totalRainfall9 = totalRainfall9;
        }

        public Object getTotalRainfall10() {
            return totalRainfall10;
        }

        public void setTotalRainfall10(Object totalRainfall10) {
            this.totalRainfall10 = totalRainfall10;
        }

        public Object getTotalRainfall11() {
            return totalRainfall11;
        }

        public void setTotalRainfall11(Object totalRainfall11) {
            this.totalRainfall11 = totalRainfall11;
        }

        public Object getTotalRainfall12() {
            return totalRainfall12;
        }

        public void setTotalRainfall12(Object totalRainfall12) {
            this.totalRainfall12 = totalRainfall12;
        }

        public Object getTotalRainfall13() {
            return totalRainfall13;
        }

        public void setTotalRainfall13(Object totalRainfall13) {
            this.totalRainfall13 = totalRainfall13;
        }

        public Object getTotalRainfall14() {
            return totalRainfall14;
        }

        public void setTotalRainfall14(Object totalRainfall14) {
            this.totalRainfall14 = totalRainfall14;
        }

        public Object getTotalRainfall15() {
            return totalRainfall15;
        }

        public void setTotalRainfall15(Object totalRainfall15) {
            this.totalRainfall15 = totalRainfall15;
        }

        public Object getTotalRainfall16() {
            return totalRainfall16;
        }

        public void setTotalRainfall16(Object totalRainfall16) {
            this.totalRainfall16 = totalRainfall16;
        }

        public Object getTotalRainfall17() {
            return totalRainfall17;
        }

        public void setTotalRainfall17(Object totalRainfall17) {
            this.totalRainfall17 = totalRainfall17;
        }

        public Object getTotalRainfall18() {
            return totalRainfall18;
        }

        public void setTotalRainfall18(Object totalRainfall18) {
            this.totalRainfall18 = totalRainfall18;
        }

        public Object getTotalRainfall19() {
            return totalRainfall19;
        }

        public void setTotalRainfall19(Object totalRainfall19) {
            this.totalRainfall19 = totalRainfall19;
        }

        public Object getTotalRainfall20() {
            return totalRainfall20;
        }

        public void setTotalRainfall20(Object totalRainfall20) {
            this.totalRainfall20 = totalRainfall20;
        }

        public Object getTotalRainfall21() {
            return totalRainfall21;
        }

        public void setTotalRainfall21(Object totalRainfall21) {
            this.totalRainfall21 = totalRainfall21;
        }

        public Object getTotalRainfall22() {
            return totalRainfall22;
        }

        public void setTotalRainfall22(Object totalRainfall22) {
            this.totalRainfall22 = totalRainfall22;
        }

        public Object getTotalRainfall23() {
            return totalRainfall23;
        }

        public void setTotalRainfall23(Object totalRainfall23) {
            this.totalRainfall23 = totalRainfall23;
        }

        public Object getTotalRainfall24() {
            return totalRainfall24;
        }

        public void setTotalRainfall24(Object totalRainfall24) {
            this.totalRainfall24 = totalRainfall24;
        }

        public Object getTotalRainfall25() {
            return totalRainfall25;
        }

        public void setTotalRainfall25(Object totalRainfall25) {
            this.totalRainfall25 = totalRainfall25;
        }

        public Object getTotalRainfall26() {
            return totalRainfall26;
        }

        public void setTotalRainfall26(Object totalRainfall26) {
            this.totalRainfall26 = totalRainfall26;
        }

        public Object getTotalRainfall27() {
            return totalRainfall27;
        }

        public void setTotalRainfall27(Object totalRainfall27) {
            this.totalRainfall27 = totalRainfall27;
        }

        public Object getTotalRainfall28() {
            return totalRainfall28;
        }

        public void setTotalRainfall28(Object totalRainfall28) {
            this.totalRainfall28 = totalRainfall28;
        }

        public Object getTotalRainfall29() {
            return totalRainfall29;
        }

        public void setTotalRainfall29(Object totalRainfall29) {
            this.totalRainfall29 = totalRainfall29;
        }

        public Object getTotalRainfall30() {
            return totalRainfall30;
        }

        public void setTotalRainfall30(Object totalRainfall30) {
            this.totalRainfall30 = totalRainfall30;
        }

        public Object getTotalRainfall31() {
            return totalRainfall31;
        }

        public void setTotalRainfall31(Object totalRainfall31) {
            this.totalRainfall31 = totalRainfall31;
        }

        public Object getTotalRainfall32() {
            return totalRainfall32;
        }

        public void setTotalRainfall32(Object totalRainfall32) {
            this.totalRainfall32 = totalRainfall32;
        }

        public Object getTotalRainfall33() {
            return totalRainfall33;
        }

        public void setTotalRainfall33(Object totalRainfall33) {
            this.totalRainfall33 = totalRainfall33;
        }

        public Object getTotalRainfall34() {
            return totalRainfall34;
        }

        public void setTotalRainfall34(Object totalRainfall34) {
            this.totalRainfall34 = totalRainfall34;
        }

        public Object getTotalRainfall35() {
            return totalRainfall35;
        }

        public void setTotalRainfall35(Object totalRainfall35) {
            this.totalRainfall35 = totalRainfall35;
        }

        public Object getTotalRainfall36() {
            return totalRainfall36;
        }

        public void setTotalRainfall36(Object totalRainfall36) {
            this.totalRainfall36 = totalRainfall36;
        }

        public Object getTotalRainfall37() {
            return totalRainfall37;
        }

        public void setTotalRainfall37(Object totalRainfall37) {
            this.totalRainfall37 = totalRainfall37;
        }

        public Object getTotalRainfall38() {
            return totalRainfall38;
        }

        public void setTotalRainfall38(Object totalRainfall38) {
            this.totalRainfall38 = totalRainfall38;
        }

        public Object getTotalRainfall39() {
            return totalRainfall39;
        }

        public void setTotalRainfall39(Object totalRainfall39) {
            this.totalRainfall39 = totalRainfall39;
        }

        public Object getTotalRainfall40() {
            return totalRainfall40;
        }

        public void setTotalRainfall40(Object totalRainfall40) {
            this.totalRainfall40 = totalRainfall40;
        }

        public Object getTotalRainfall41() {
            return totalRainfall41;
        }

        public void setTotalRainfall41(Object totalRainfall41) {
            this.totalRainfall41 = totalRainfall41;
        }

        public Object getTotalRainfall42() {
            return totalRainfall42;
        }

        public void setTotalRainfall42(Object totalRainfall42) {
            this.totalRainfall42 = totalRainfall42;
        }

        public Object getTotalRainfall43() {
            return totalRainfall43;
        }

        public void setTotalRainfall43(Object totalRainfall43) {
            this.totalRainfall43 = totalRainfall43;
        }

        public Object getTotalRainfall44() {
            return totalRainfall44;
        }

        public void setTotalRainfall44(Object totalRainfall44) {
            this.totalRainfall44 = totalRainfall44;
        }

        public Object getTotalRainfall45() {
            return totalRainfall45;
        }

        public void setTotalRainfall45(Object totalRainfall45) {
            this.totalRainfall45 = totalRainfall45;
        }

        public Object getTotalRainfall46() {
            return totalRainfall46;
        }

        public void setTotalRainfall46(Object totalRainfall46) {
            this.totalRainfall46 = totalRainfall46;
        }

        public Object getTotalRainfall47() {
            return totalRainfall47;
        }

        public void setTotalRainfall47(Object totalRainfall47) {
            this.totalRainfall47 = totalRainfall47;
        }

        public Object getTotalRainfall48() {
            return totalRainfall48;
        }

        public void setTotalRainfall48(Object totalRainfall48) {
            this.totalRainfall48 = totalRainfall48;
        }

        public Object getTotalRainfall49() {
            return totalRainfall49;
        }

        public void setTotalRainfall49(Object totalRainfall49) {
            this.totalRainfall49 = totalRainfall49;
        }

        public Object getTotalRainfall50() {
            return totalRainfall50;
        }

        public void setTotalRainfall50(Object totalRainfall50) {
            this.totalRainfall50 = totalRainfall50;
        }

        public Object getTotalRainfall51() {
            return totalRainfall51;
        }

        public void setTotalRainfall51(Object totalRainfall51) {
            this.totalRainfall51 = totalRainfall51;
        }

        public Object getTotalRainfall52() {
            return totalRainfall52;
        }

        public void setTotalRainfall52(Object totalRainfall52) {
            this.totalRainfall52 = totalRainfall52;
        }

        public Object getTotalRainfall53() {
            return totalRainfall53;
        }

        public void setTotalRainfall53(Object totalRainfall53) {
            this.totalRainfall53 = totalRainfall53;
        }

        public Object getTotalRainfall54() {
            return totalRainfall54;
        }

        public void setTotalRainfall54(Object totalRainfall54) {
            this.totalRainfall54 = totalRainfall54;
        }

        public Object getTotalRainfall55() {
            return totalRainfall55;
        }

        public void setTotalRainfall55(Object totalRainfall55) {
            this.totalRainfall55 = totalRainfall55;
        }

        public Object getTotalRainfall56() {
            return totalRainfall56;
        }

        public void setTotalRainfall56(Object totalRainfall56) {
            this.totalRainfall56 = totalRainfall56;
        }

        public Object getTotalRainfall57() {
            return totalRainfall57;
        }

        public void setTotalRainfall57(Object totalRainfall57) {
            this.totalRainfall57 = totalRainfall57;
        }

        public Object getTotalRainfall58() {
            return totalRainfall58;
        }

        public void setTotalRainfall58(Object totalRainfall58) {
            this.totalRainfall58 = totalRainfall58;
        }

        public Object getTotalRainfall59() {
            return totalRainfall59;
        }

        public void setTotalRainfall59(Object totalRainfall59) {
            this.totalRainfall59 = totalRainfall59;
        }

        public Object getTotalRainfall60() {
            return totalRainfall60;
        }

        public void setTotalRainfall60(Object totalRainfall60) {
            this.totalRainfall60 = totalRainfall60;
        }
    }
}
