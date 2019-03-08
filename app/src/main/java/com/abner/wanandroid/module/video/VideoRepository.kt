package com.abner.wanandroid.module.video

import com.abner.wanandroid.BuildConfig
import com.abner.wanandroid.module.video.api.EyepetizerApi
import com.abner.wanandroid.module.video.bean.EyepetizerIndexTab
import com.abner.wanandroid.module.video.bean.VideoListTemp
import com.sise.abner.abaselib.net.RetrofitClient
import com.sise.abner.abaselib.net.RxSchedulers
import io.reactivex.Observable

/**
 *
 *
 * @author zhangduntai
 * @date 2019/3/6
 */
class VideoRepository {
    companion object {

        fun getEyepetizerIndex(): Observable<EyepetizerIndexTab>
        {
            return RetrofitClient.get(BuildConfig.EYE_URL)
                    .create(EyepetizerApi::class.java)
                    .getEyepetizerIndex()
                    .compose(RxSchedulers.ioMain())
        }

        fun getVideoList(url:String):Observable<VideoListTemp>
        {
            return RetrofitClient.get(BuildConfig.EYE_URL)
                    .create(EyepetizerApi::class.java)
                    .getVideoList(url)
                    .compose(RxSchedulers.ioMain())
        }

    }
}