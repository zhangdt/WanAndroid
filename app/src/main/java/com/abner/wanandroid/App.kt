package com.abner.wanandroid

import com.sise.abner.abaselib.base.BaseApp
import com.sise.abner.abaselib.net.RetrofitClient

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
            baseUrl = "http://www.wanandroid.com/"
            timeOut = 3000
            enableLog = true
        }
        RetrofitClient.init(config)
    }
}