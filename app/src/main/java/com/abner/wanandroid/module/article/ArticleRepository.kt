package com.abner.wanandroid.module.article

import com.abner.wanandroid.BuildConfig
import com.abner.wanandroid.bean.Article
import com.abner.wanandroid.bean.PageResp
import com.abner.wanandroid.module.article.api.ArticleApi
import com.abner.wanandroid.module.article.bean.TreeNode
import com.abner.wanandroid.module.article.bean.TreeRoot
import com.sise.abner.abaselib.net.RetrofitClient
import com.sise.abner.abaselib.net.RxSchedulers
import io.reactivex.Observable

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/15
 */
class ArticleRepository {
    companion object {
        fun getTree(): Observable<List<TreeRoot>>? {
            return RetrofitClient.get(BuildConfig.BASE_URL)
                    .create(ArticleApi::class.java)
                    .getTree()
                    .compose(RxSchedulers.responseTransform())

        }

        fun getArticlesById(cid:Int,page:Int):Observable<PageResp<Article>>
        {
            return RetrofitClient.get(BuildConfig.BASE_URL)
                    .create(ArticleApi::class.java)
                    .getArtcleById(page,cid)
                    .compose(RxSchedulers.responseTransform())
        }

    }
}