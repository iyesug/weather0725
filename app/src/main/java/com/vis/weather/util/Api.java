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
    Observable<WeatherHour> searchHour(@Query("station") int number, @Query("startDataTime") String fromTime, @Query("endDataTime") String toTime);


    @GET("queryForecast")
    Observable<WeatherDaily> searchDaily(@Query("station") int number, @Query("startDataTime") String fromTime, @Query("endDataTime") String toTime);

//    http://192.168.10.75:8080/hadoop-hbase-web-demo/rest/queryPicture?imgtype=rad&station=50001&startDateTime=20160911200000&endDateTime=20160912160000
    @GET("queryPicture")
    Observable<ListPicture> queryPicture(@Query("imgtype") String imgType, @Query("startDataTime") String fromTime, @Query("endDataTime") String toTime
                                          , @Query("station") int number);

    @GET("queryShiKuangStation")
    Observable<ListPicture> queryShiKuangStation(@Query("lmId") String imgType, @Query("parentId") String fromTime, @Query("sid") String toTime);

    @GET("queryTyphoon")
    Observable<TyphoonPath> queryTyphoon(@Query("typhoonNo") String typhoonNo, @Query("startDataTime") String fromTime, @Query("endDataTime") String toTime);

    @GET("queryTyphoonList")
    Observable<TyphoonList> queryTyphoonList(@Query("typhoonNo") String typhoonNo, @Query("yearNo") String yearNo, @Query("typhoonName") String typhoonName);


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
