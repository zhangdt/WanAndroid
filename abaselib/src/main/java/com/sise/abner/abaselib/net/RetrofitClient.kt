package com.sise.abner.abaselib.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.ConcurrentHashMap

/**
 * retrofit 封装
 *
 * @author zhangduntai
 * @date 2019/1/11
 */
class RetrofitClient {

    companion object {
        var retrofitFactory: ConcurrentHashMap<String, Retrofit> = ConcurrentHashMap()

        fun init(config: Config) {
            val retrofit = Retrofit.Builder()
                    .baseUrl(config.baseUrl)
                    .client(OkHttpManger.getInstance(config.enableLog, config.timeOut))
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            retrofitFactory[config.baseUrl] = retrofit
        }


        fun get(baseUrl: String): Retrofit {
            if (retrofitFactory.get(baseUrl)!=null) {
                return retrofitFactory.get(baseUrl)!!
            } else {
                throw RuntimeException("初始化retrofit")
            }
        }
    }

 class Config() {
    lateinit var baseUrl: String
    var timeOut: Long = 0
    var enableLog: Boolean = false


     fun init(init:Config.()->Unit):Config
     {
         init()
         return this
     }

    fun setBaseUrl(baseUrl: String): Config {
        this.baseUrl = baseUrl
        return this
    }

    fun setTimeOut(timeOut: Long): Config {
        this.timeOut = timeOut
        return this
    }
//        fun setInterceptor(vararg interceptors: Interceptor):Config {
//            this.interceptors = interceptors
//            return this
//        }

}
//    init {
//        if (!(retrofitFactory.containsKey(baseUrl))) {
//            val retrofit = Retrofit.Builder()
//                    .baseUrl(baseUrl)
//                    .client(okHttpClient)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .build()
//            retrofitFactory.put(baseUrl, retrofit)
//        }
//    }

}