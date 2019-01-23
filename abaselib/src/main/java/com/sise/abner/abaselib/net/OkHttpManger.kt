package com.sise.abner.abaselib.net

import android.os.RecoverySystem
import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Okhttp管理类
 *
 * @author zhangduntai
 * @date 2019/1/11
 */
class OkHttpManger {
    companion object {
         var okHttpClient:OkHttpClient? = null
        fun getInstance(enableLog:Boolean,timeOut:Long,vararg interceptors: Interceptor): OkHttpClient {

            if (okHttpClient == null) {
                synchronized(OkHttpManger) {
                    val builder  = OkHttpClient.Builder()

                    //是否提供日志
                    if (enableLog) {
                        val logInterceptor = HttpLoggingInterceptor()
                        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
                        builder.addInterceptor(logInterceptor)
                    }
                    builder .readTimeout(timeOut, TimeUnit.SECONDS)
                            .connectTimeout(timeOut, TimeUnit.SECONDS)
                    okHttpClient = builder.build()
                    return okHttpClient!!
                }
            }
            return okHttpClient!!
        }
    }
}