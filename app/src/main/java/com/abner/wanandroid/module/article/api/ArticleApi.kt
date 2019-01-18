package com.abner.wanandroid.module.article.api

import com.abner.wanandroid.bean.Article
import com.abner.wanandroid.bean.PageResp
import com.sise.abner.abaselib.net.WanAndroidBaseResp
import com.abner.wanandroid.module.article.bean.TreeNode
import com.abner.wanandroid.module.article.bean.TreeRoot
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/15
 */
interface ArticleApi {

    /**
     * 获取知识体系树
     */
    @GET("tree/json")
    fun getTree():Observable<WanAndroidBaseResp<List<TreeRoot>>>


    /**
     * 获取id对应的文章列表
     */
    @GET("article/list/{page}/json")
    fun getArticleById( @Path("page") page:Int,@Query("cid") cid:Int):Observable<WanAndroidBaseResp<PageResp<Article>>>

    /**
     * 获取最新的文章
     */

    @GET("article/list/{page}/json")
    fun getAllArticle(@Path("page") page:Int ):Observable<WanAndroidBaseResp<PageResp<Article>>>


}