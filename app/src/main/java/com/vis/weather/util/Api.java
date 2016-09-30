// (c)2016 Flipboard Inc, All Rights Reserved.

package com.vis.weather.util;

import com.vis.weather.model.*;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {
//    queryForecast?station=59132&startDateTime=20160911160000&endDateTime=20160912160000
    @GET("servlet")
    Observable<DayAndHour> search(@Query("q") String query);

    @GET("queryAutoStation")
    Observable<WeatherHour> searchMinute(@Query("station") String number, @Query("startDataTime") String fromTime, @Query("endDataTime") String toTime);

    @GET("queryAutoStationHour")
    Observable<WeatherHour> searchHour(@Query("station") String number, @Query("startDataTime") String fromTime, @Query("endDataTime") String toTime);
    @GET("queryAutoStationLast")
    Observable<WeatherHour> queryAutoStationLast(@Query("station") String number);


    @GET("queryForecastFor7Days")
    Observable<WeatherDaily> queryForecastFor7Days(@Query("station") String station, @Query("dataTime") String dataTime);
    @GET("queryForecast")
    Observable<WeatherDaily> searchDaily(@Query("station") String number, @Query("startDataTime") String fromTime, @Query("endDataTime") String toTime);

//    http://192.168.10.75:8080/hadoop-hbase-web-demo/rest/queryPicture?imgtype=rad&station=50001&startDateTime=20160911200000&endDateTime=20160912160000
    @GET("queryPicture")
    Observable<ListPicture> queryPicture(@Query("imgtype") String imgType, @Query("startDataTime") String fromTime, @Query("endDataTime") String toTime
                                          , @Query("station") String number);

    @GET("queryShiKuangStation")
    Observable<StationList> queryShiKuangStation(@Query("lmId") String lmId, @Query("parentId") String parentId, @Query("sid") String sid);

    @GET("queryTyphoon")
    Observable<TyphoonPath> queryTyphoon(@Query("typhoonNo") String typhoonNo, @Query("startDataTime") String fromTime, @Query("endDataTime") String toTime);

    @GET("queryTyphoonList")
    Observable<TyphoonList> queryTyphoonList(@Query("typhoonNo") String typhoonNo,
                                             @Query("nyear") String yearNo, @Query("typhoonName") String typhoonName);


    @GET("queryStationInfo")
    Observable<StationInfo> queryStationInfo(@Query("station") String station);

//    /**
//     * 查询自动气象站最新一条实况数据
//     * @param stati	on 站点
//     * @return
//     * @throws ParseException
//     */
//    @RequestMapping(value="/queryAutoStationLast",method= RequestMethod.GET)
//    @ResponseBody
//    public Map<String,Object> queryAutoStationLast(String station) {
//    /**
//     * 查询站点信息
//     * @param station 站点编号
//     * @return
//     */
//    @RequestMapping(value="/queryStationInfo",method= RequestMethod.GET)
//    @ResponseBody
//    public Map<String,Object> queryStationInfo(String station) {

//    /**
//     * 查询实况站点归类表
//     * @param lmId 实况分类ID
//     * @param parentId 上级实况站ID
//     * @param sid 实况站ID
//     * @return
//     * @throws ParseException
//     */
//    @RequestMapping(value="/queryShiKuangStation",method= RequestMethod.GET)
//    @ResponseBody
//    public Map<String,Object> queryShiKuangStation(String lmId, String parentId, String sid) {
//
//        徐景建  开发部副经理 2016/9/23 10:55:54
//        /**
//         * 查询台风
//         * @param typhoonNo 台风编号
//         * @param startDataTime 开始时间(精确查询只要输入开始时间)
//         * @param endDataTime 结束时间(按时段查询才要输入结束时间)
//         * @return
//         * @throws ParseException
//         */
//        @RequestMapping(value="/queryTyphoon",method=RequestMethod.GET)
//        @ResponseBody
//        public Map<String,Object> queryTyphoon(String typhoonNo,String startDataTime,String endDataTime) {
//
//    /**
//     * 查询台风列表
//     * @param startDataTime 开始时间(精确查询只要输入开始时间)
//     * @param endDataTime 结束时间(按时段查询才要输入结束时间)
//     * @return
//     * @throws ParseException
//     */
//    @RequestMapping(value="/queryTyphoonList",method= RequestMethod.GET)
//    @ResponseBody
//    public Map<String,Object> queryTyphoonList(String startDataTime, String endDataTime) {


//
//    @GET("efzintf/visappautostationinfo.act")
//    Observable<WeatherHour> searchHour(@Query("station") int number, @Query("fromTime") String fromTime, @Query("toTime") String toTime);
//
//
//    @GET("ybintf/visappforecastinfo.act")
//    Observable<WeatherDaily> searchDaily(@Query("station") int number, @Query("fromTime") String fromTime, @Query("toTime") String toTime);
}
