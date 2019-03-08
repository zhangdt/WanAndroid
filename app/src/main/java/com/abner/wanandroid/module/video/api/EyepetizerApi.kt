package com.abner.wanandroid.module.video.api

import com.abner.wanandroid.module.video.bean.EyepetizerIndexTab
import com.abner.wanandroid.module.video.bean.VideoListTemp
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

/**
 *
 *
 * @author zhangduntai
 * @date 2019/3/6
 */
interface EyepetizerApi {


    /**
     * 获取开眼的首页tab和各页面的请求
     */
    @GET(" api/v7/index/tab/list")
    fun getEyepetizerIndex():Observable<EyepetizerIndexTab>

    @GET
    fun getVideoList(@Url url:String):Observable<VideoListTemp>












}