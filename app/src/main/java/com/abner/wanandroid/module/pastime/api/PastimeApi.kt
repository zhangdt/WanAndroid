package com.abner.wanandroid.module.pastime.api

import com.abner.wanandroid.module.pastime.bean.Girl
import com.sise.abner.abaselib.net.base.GankBaseResp
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/28
 */
interface PastimeApi {

    @GET("api/data/福利/{size}/{page}")
    fun getGirls(@Path("size")size:Int,@Path("page") page:Int):Observable<GankBaseResp<List<Girl>>>
}