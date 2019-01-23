package com.abner.wanandroid.module.article.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData

import com.abner.wanandroid.bean.Article
import com.abner.wanandroid.bean.PageResp
import com.abner.wanandroid.module.article.ArticleRepository
import com.abner.wanandroid.module.article.bean.TreeRoot
import com.orhanobut.logger.Logger
import com.sise.abner.abaselib.base.ABaseViewModel
import com.sise.abner.abaselib.base.ASingleLiveEvent

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/16
 */
class ArticleVm(application: Application) : ABaseViewModel(application) {
    var treeRoots: MutableLiveData<List<TreeRoot>> = MutableLiveData()
    var articles: MutableLiveData<PageResp<Article>> = MutableLiveData()
    var addArticles: MutableLiveData<PageResp<Article>> = MutableLiveData()
    var isOver: ASingleLiveEvent<Boolean> = ASingleLiveEvent()
    var isError: ASingleLiveEvent<Void> = ASingleLiveEvent()
    private var mCid = -1
    private var mPage = 0
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

        if (cid == mCid) mPage++ else mPage = 0
        ArticleRepository.getArticlesById(cid, mPage).subscribe(
                {
                    Logger.d(it)
                    mCid = cid
                    if (mPage == 0) {
                        articles.value = it  //如果已经结束了  要提升最后一页了
                    } else {
                        addArticles.value = it
                    }
                    if (it.isOver) {
                        isOver.value = it.isOver
                    }
                },
                {
                    isError.call()
                    Logger.e(it, it.message!!)
                }
        )?.let {
            addSubscription(it)
        }
        return this
    }

    private fun getAllArticle() {
        ArticleRepository.getAllArticle(mPage).subscribe(
                {
                    Logger.d(it)
//                    Logger.d(it.datas[0].title)
                    articles.value = it
                    if (it.isOver) {
                        isOver.call()
                    }
                },
                {
                    Logger.e(it, it.message!!)
                }
        )?.let {
            addSubscription(it)
        }
    }

}