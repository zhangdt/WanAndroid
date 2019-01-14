package com.abner.wanandroid

import com.sise.abner.abaselib.base.BaseApp
import com.sise.abner.abaselib.net.RetrofitClient
import com.sise.abner.abaselib.util.LoggingUtil

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/11
 */
class App: BaseApp() {
    override fun onCreate() {
        super.onCreate()
        var config = RetrofitClient.Config().init{
            baseUrl = BuildConfig.BASE_URL
            timeOut = 3000
            enableLog = true
        }
        RetrofitClient.init(config)
        LoggingUtil.init(BuildConfig.ISDEBUG)
    }
}