package com.abner.wanandroid.module.article.view

import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.view.View
import com.abner.wanandroid.R
import com.abner.wanandroid.base.BaseFragment
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_article.*

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/14
 */
class ArticleFragment: BaseFragment() {

    var _onDrawerListener: (Boolean) -> Unit = {}
    override fun onVisible() {
        Logger.i("onVisible")
    }

    fun setOnDrawerListener(onDrawerListener: (Boolean) -> Unit):ArticleFragment{
        _onDrawerListener = onDrawerListener
        return this
    }

    override fun initView(args: Bundle?) {
        article_dl.addDrawerListener(object :DrawerLayout.DrawerListener{
            override fun onDrawerStateChanged(newState: Int) {
            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
            }

            override fun onDrawerClosed(drawerView: View) {
                _onDrawerListener(false)
            }

            override fun onDrawerOpened(drawerView: View) {
                _onDrawerListener(true)
            }
        })
    }



    override fun initViewModel(savedInstanceState: Bundle?) {
    }

    override fun getLayout(): Int {
        return R.layout.fragment_article
    }


}