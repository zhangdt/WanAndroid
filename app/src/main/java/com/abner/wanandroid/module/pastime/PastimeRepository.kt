package com.abner.wanandroid.module.pastime

import com.abner.wanandroid.BuildConfig
import com.abner.wanandroid.module.pastime.api.PastimeApi
import com.abner.wanandroid.module.pastime.bean.Girl
import com.sise.abner.abaselib.net.RetrofitClient
import com.sise.abner.abaselib.net.RxSchedulers
import com.sise.abner.abaselib.net.base.GankBaseResp
import io.reactivex.Observable

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/28
 */
class PastimeRepository {

    companion object {
        fun getGirls():Observable<GankBaseResp<List<Girl>>>{
            return RetrofitClient.get(BuildConfig.GANK_URL)
                    .create(PastimeApi::class.java)
                    .getGirls(10,1)
                    .compose(RxSchedulers.ioMain())
        }
    }
}