package com.abner.wanandroid.module.article.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.abner.wanandroid.R
import com.abner.wanandroid.base.BaseFragment
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_article.*
import android.support.v7.widget.GridLayoutManager
import com.abner.wanandroid.module.article.adapter.TreeRootAdapter
import com.abner.wanandroid.module.article.bean.TreeRoot
import com.abner.wanandroid.module.article.vm.ArticleVm
import com.chad.library.adapter.base.entity.MultiItemEntity


/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/14
 */
class ArticleFragment : BaseFragment() {

    var _onDrawerListener: (Boolean) -> Unit = {}
    lateinit var adapter: TreeRootAdapter
    lateinit var articleVm: ArticleVm

    override fun onVisible() {
        Logger.i("onVisible")
    }

    fun setOnDrawerListener(onDrawerListener: (Boolean) -> Unit): ArticleFragment {
        _onDrawerListener = onDrawerListener
        return this
    }

    override fun initView(args: Bundle?) {
        article_dl.addDrawerListener(object : DrawerLayout.DrawerListener {
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

        var manager = GridLayoutManager(mContext, 3)
        adapter = TreeRootAdapter(ArrayList())
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (adapter.getItemViewType(position) == adapter.TYPE_NODE) 1 else manager.spanCount
            }
        }
        article_rv.adapter = adapter
        article_rv.layoutManager = manager

        articleVm.getTree().apply {
            treeRoots.observe(this@ArticleFragment, Observer {
                Logger.d(it)
                if (it != null) {
                    adapter.setNewData(transformTreeData(it))
                }
            })
        }

        adapter.setNodeClickListener {

        }


    }

    /**
     * 对数据进行变化
     */
    fun transformTreeData(treeRoots:List<TreeRoot>):List<MultiItemEntity>{
        var data  = ArrayList<MultiItemEntity>()
        for(root in treeRoots)
        {
            var treeRoot:TreeRoot = root;
            for (node in treeRoot.children)
            {
                treeRoot.addSubItem(node)
            }
            data.add(treeRoot)
        }
        return data

    }

    override fun initViewModel(savedInstanceState: Bundle?) {
        articleVm = ViewModelProviders
                .of(this@ArticleFragment)
                .get(ArticleVm::class.java)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_article
    }


}