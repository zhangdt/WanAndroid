package com.abner.wanandroid.module.home

import com.abner.wanandroid.bean.Navi
import com.abner.wanandroid.module.home.api.HomeApi
import com.sise.abner.abaselib.net.RetrofitClient
import com.sise.abner.abaselib.net.RxSchedulers
import io.reactivex.Observable

/**
 * @author zhangduntai
 * @date 2019/1/11
 */
class HomeRepository {
    companion object {
        fun getNavi(): Observable<Navi>? {
            return RetrofitClient.get("http://www.wanandroid.com/")
                    .create(HomeApi::class.java)
                    .getNavi()
                    .compose(RxSchedulers.ioMain())
        }
    }
}