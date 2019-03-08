package com.abner.wanandroid.module.video.vm

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abner.wanandroid.BuildConfig
import com.abner.wanandroid.module.video.VideoRepository
import com.abner.wanandroid.module.video.bean.EyepetizerIndexTab
import com.abner.wanandroid.module.video.bean.VideoListTemp
import com.orhanobut.logger.Logger
import com.sise.abner.abaselib.base.ABaseViewModel

/**
 *
 *
 * @author zhangduntai
 * @date 2019/3/7
 */
class EyeVm(application: Application) : ABaseViewModel(application) {
    var eyeTabInfo: MutableLiveData<EyepetizerIndexTab> = MutableLiveData()
    var videos:MutableLiveData<VideoListTemp> = MutableLiveData()
    fun getIndexTabInfo() {
        VideoRepository.getEyepetizerIndex().subscribe(
                {
                    eyeTabInfo.value = it
                },
                {

                }
        )?.let { addSubscription(it) }
    }

    fun getVideoList(url: String) {
        var realUrl = url.substring(BuildConfig.EYE_URL.length,url.length);
        Logger.e(realUrl)
        VideoRepository.getVideoList(realUrl).subscribe {
            videos.value = it
        }?.let { addSubscription(it) }
    }
}