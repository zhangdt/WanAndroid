package com.abner.wanandroid.module.article.vm

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.abner.wanandroid.bean.Article
import com.abner.wanandroid.bean.PageResp
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
    var treeRoots: MutableLiveData<List<TreeRoot>> = MutableLiveData()
    var articles: MutableLiveData<PageResp<Article>> = MutableLiveData()
    fun getTree(): ArticleVm {
        ArticleRepository.getTree()?.subscribe(
                {
                    Logger.d(it[1].children[0].name)
                    treeRoots.value = it
                },
                {
                    Logger.e(it, it.message!!)
                }
        )?.let { addSubscription(it) }
        return this
    }


    fun getArticlesById(cid: Int): ArticleVm {
        if (cid==0)  //当id == 0 时 用最新的接口
        {
            getAllArticle()
        }
        else {
            ArticleRepository.getArticlesById(cid, 0).subscribe(
                    {
                        Logger.d(it)
//                    Logger.d(it.datas[0].title)
                        articles.value = it
                    },
                    {
                        Logger.e(it, it.message!!)
                    }
            )?.let {
                addSubscription(it)
            }
        }
        return this
    }

    private fun getAllArticle() {
        ArticleRepository.getAllArticle(0).subscribe(
                {
                    Logger.d(it)
//                    Logger.d(it.datas[0].title)
                    articles.value = it
                },
                {
                    Logger.e(it, it.message!!)
                }
        )?.let {
            addSubscription(it)
        }
    }

}