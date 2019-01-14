package com.abner.wanandroid.module.home

import android.graphics.Bitmap
import com.abner.wanandroid.BuildConfig
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
            return RetrofitClient.get(BuildConfig.BASE_URL)
                    .create(HomeApi::class.java)
                    .getNavi()
                    .compose(RxSchedulers.ioMain())
        }
    }
}