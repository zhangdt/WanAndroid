package com.sise.abner.abaselib.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * Created by Abner on 2017/9/20.
 */
abstract class ABaseViewModel(application: Application) : AndroidViewModel(application) {

     var errEvent:ASingleLiveEvent<String> = ASingleLiveEvent()

    protected  var compositeDisposable: CompositeDisposable?= CompositeDisposable()

    /**
     * 添加事件监听处理到 事件管理类
     *
     * @param disposable 上流事件
     */
    protected fun addSubscription(disposable: Disposable) {

        compositeDisposable?.let {
            compositeDisposable=CompositeDisposable()
        }

        compositeDisposable?.add(disposable)
    }

    /**
     * RxJava取消注册，避免内存泄露
     * 取消以后就只能重新新建一个了
     */
    protected fun onUnsubscribe() {
        if (compositeDisposable != null) {
            // Using clear will clear all, but can accept new disposable
            compositeDisposable?.clear()
            // Using dispose will clear all and set isDisposed = true, so it will not accept any new disposable
            compositeDisposable?.dispose()
            compositeDisposable = null
        }
    }

    override fun onCleared() {
        super.onCleared()
        onUnsubscribe()
    }
    fun isErrCall(eNo: String, e: String): Boolean {
        if (!eNo.equals("0")) {
            errEvent.value = e
            return true
        }
        return false
    }
}