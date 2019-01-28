package com.abner.wanandroid.module.article.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import com.abner.wanandroid.R
import com.abner.wanandroid.base.BaseActivity
import com.just.agentweb.AgentWeb
import kotlinx.android.synthetic.main.activity_article_content.*


/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/28
 */
class ArticleContentActivity : BaseActivity() {
    companion object {
        fun start(url:String,context: Context)
        {
            var intent = Intent(context,ArticleContentActivity::class.java)
            intent.putExtra("url",url)
            context.startActivity(intent)

        }
    }
    override fun initView(savedInstanceState: Bundle?) {
        AgentWeb.with(this)
                .setAgentWebParent(ll_root, LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(intent.getStringExtra("url"))
    }

    override fun initViewModel() {
    }

    override fun getLayout(): Int {
        return R.layout.activity_article_content
    }

    override fun initFragment() {
    }
}