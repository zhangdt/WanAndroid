package com.abner.wanandroid

import com.sise.abner.abaselib.base.BaseApp
import com.sise.abner.abaselib.net.RetrofitClient
import com.sise.abner.abaselib.util.LoggingUtil
import com.squareup.leakcanary.LeakCanary
import com.sise.abner.abaselib.base.AppBlockCanaryContext
import com.github.moduth.blockcanary.BlockCanary



/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/11
 */
class App: BaseApp() {
    override fun onCreate() {
        super.onCreate()
        var wanAndroidConfig = RetrofitClient.Config().init{
            baseUrl = BuildConfig.BASE_URL
            timeOut = 3000
            enableLog = true
        }
        var gankConfig = RetrofitClient.Config().init{
            baseUrl = BuildConfig.GANK_URL
            timeOut = 3000
            enableLog = true
        }

        var eyepetizerConfig =  RetrofitClient.Config().init {
            baseUrl = BuildConfig.EYE_URL
            timeOut = 3000
            enableLog = true
        }
        RetrofitClient.init(wanAndroidConfig)
        RetrofitClient.init(gankConfig)
        RetrofitClient.init(eyepetizerConfig)

        LoggingUtil.init(BuildConfig.ISDEBUG)

        if (LeakCanary.isInAnalyzerProcess(this)) {//1
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)
//        BlockCanary.install(this, AppBlockCanaryContext()).start()
    }
}