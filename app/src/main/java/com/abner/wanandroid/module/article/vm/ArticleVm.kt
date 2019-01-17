package com.abner.wanandroid.module.article.vm

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.abner.wanandroid.module.article.ArticleRepository
import com.abner.wanandroid.module.article.bean.TreeRoot
import com.orhanobut.logger.Logger
import com.sise.abner.abaselib.base.ABaseViewModel

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/16
 */
class ArticleVm(application: Application) : ABaseViewModel(application) {
    var treeRoots:MutableLiveData<List<TreeRoot>> = MutableLiveData()
    fun getTree():ArticleVm {
        ArticleRepository.getTree()?.subscribe(
                {
                    Logger.d(it[1].children[0].name)
                    treeRoots.value = it
                },
                {
                    Logger.d(it)
                }
        )?.let { addSubscription(it) }
        return this
    }

    fun getArticlesById():ArticleVm{

    }

}