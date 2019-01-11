package com.abner.wanandroid.module.home.api

import com.abner.wanandroid.bean.Navi
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/11
 */
interface HomeApi {
    @GET("navi/json")
    fun getNavi(): Observable<Navi>
}