package com.abner.wanandroid.module.article.api

import com.sise.abner.abaselib.net.WanAndroidBaseResp
import com.abner.wanandroid.module.article.bean.TreeNode
import com.abner.wanandroid.module.article.bean.TreeRoot
import io.reactivex.Observable
import retrofit2.http.GET

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/15
 */
interface ArticleApi {
    @GET("tree/json")
    fun getTree():Observable<WanAndroidBaseResp<List<TreeRoot>>>
}