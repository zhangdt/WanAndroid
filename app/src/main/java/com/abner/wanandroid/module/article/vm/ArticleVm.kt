package com.abner.wanandroid.module.article.vm

import android.app.Application
import com.abner.wanandroid.module.article.ArticleRepository
import com.orhanobut.logger.Logger
import com.sise.abner.abaselib.base.ABaseViewModel

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/16
 */
class ArticleVm(application: Application) : ABaseViewModel(application) {
    fun getTree():ArticleVm {
        ArticleRepository.getTree()?.subscribe(
                {
                    Logger.d(it[1].children[0].name)
                },
                {
                    Logger.d(it)
                }
        )?.let { addSubscription(it) }
        return this
    }

}