package com.abner.wanandroid.module.pastime.vm

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abner.wanandroid.module.pastime.PastimeRepository
import com.abner.wanandroid.module.pastime.bean.Girl
import com.orhanobut.logger.Logger
import com.sise.abner.abaselib.base.ABaseViewModel

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/28
 */
class PastimeVm(application: Application) : ABaseViewModel(application) {
    var girls:MutableLiveData<List<Girl>> = MutableLiveData()
    fun getGrils(){
        PastimeRepository.getGirls().subscribe(
                {
                    Logger.i(""+it.isError)
                    girls.value = it.results
                },
                {
                    Logger.d(it)
                }
        )?.let {
            addSubscription(it)
        }
    }

}