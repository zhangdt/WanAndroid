package com.abner.wanandroid.module.article.adapter

import com.abner.wanandroid.R
import com.abner.wanandroid.bean.Article
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * @author zhangduntai
 * @date 2019/1/17
 */
class ArticleAdapter:BaseQuickAdapter<Article,BaseViewHolder>(R.layout.item_article) {
    override fun convert(helper: BaseViewHolder?, item: Article?) {
        helper?.setText(R.id.tv_title,item?.title)
    }
}