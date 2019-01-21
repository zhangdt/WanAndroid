package com.abner.wanandroid.module.article.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.abner.wanandroid.R
import com.abner.wanandroid.base.BaseFragment
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_article.*
import android.support.v7.widget.GridLayoutManager
import com.abner.wanandroid.module.article.adapter.ArticleAdapter
import com.abner.wanandroid.module.article.adapter.TreeRootAdapter
import com.abner.wanandroid.module.article.bean.TreeRoot
import com.abner.wanandroid.module.article.vm.ArticleVm
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.abner.wanandroid.R.id.toolbar


/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/14
 */
class ArticleFragment : BaseFragment() {

    var _onDrawerListener: (Boolean) -> Unit = {}
    lateinit var treeAdapter: TreeRootAdapter
    lateinit var articleAdapter: ArticleAdapter
    lateinit var articleVm: ArticleVm
    lateinit var mDrawerToggle: ActionBarDrawerToggle


    var mCid = 0
    var isErr = false
    private var isOver = false


    override fun onVisible() {
        Logger.i("onVisible")
    }

    fun setOnDrawerListener(onDrawerListener: (Boolean) -> Unit): ArticleFragment {
        _onDrawerListener = onDrawerListener
        return this
    }

    override fun initView(args: Bundle?) {

        var activity = activity as AppCompatActivity
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }

        //抽屉和按钮的结合  三杆变箭头
        mDrawerToggle = ActionBarDrawerToggle(activity, article_dl, toolbar, R.string.drawer_open, R.string.drawer_close)
        mDrawerToggle.syncState()
        article_dl.setDrawerListener(mDrawerToggle)


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

        var manager = GridLayoutManager(mContext, 2)
        treeAdapter = TreeRootAdapter(ArrayList())
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (treeAdapter.getItemViewType(position) == treeAdapter.TYPE_NODE) 1 else manager.spanCount
            }
        }
        article_rv.adapter = treeAdapter
        article_rv.layoutManager = manager



        articleAdapter = ArticleAdapter()
        rv_article.layoutManager = LinearLayoutManager(context)
        rv_article.adapter = articleAdapter

        treeAdapter.setNodeClickListener { id, name ->
            toolbar.title = name
            mCid = id
            articleVm.getArticlesById(mCid)
            article_dl.closeDrawers()
            isOver = false
        }

        toolbar.title = "最新"


        articleVm.getTree()
        articleVm.getArticlesById(mCid)

        articleAdapter.setOnLoadMoreListener {
            rv_article.postDelayed({
                when {
                    isOver -> articleAdapter.loadMoreEnd()
                    else -> {
                        articleVm.getArticlesById(mCid)
                    }
                }
            },500)
        }
    }

    /**
     * 对数据进行变化
     */
    fun transformTreeData(treeRoots: List<TreeRoot>): List<MultiItemEntity> {
        var data = ArrayList<MultiItemEntity>()
        var treeRoot = TreeRoot()
        treeRoot.name = "最新"  //在第一位加上最新
        data.add(treeRoot)
        for (root in treeRoots) {
            var treeRoot: TreeRoot = root
            for (node in treeRoot.children) {
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
                .apply {
                    treeRoots.observe(this@ArticleFragment, Observer {
                        Logger.d(it)
                        if (it != null) {
                            treeAdapter.setNewData(transformTreeData(it))
                        }
                    })

                    articles.observe(this@ArticleFragment, Observer {
                        isErr = false
                        articleAdapter.setNewData(it?.datas!!)
                    })

                    addArticles.observe(this@ArticleFragment, Observer {
                        isErr = false
                        articleAdapter.addData(it?.datas!!)
                        articleAdapter.loadMoreComplete()
                    })

                    isError.observe(this@ArticleFragment, Observer {
                        articleAdapter.loadMoreFail()
                    })

                    isOver.observe(this@ArticleFragment, Observer {
                        this@ArticleFragment.isOver = it!!
                    })
                }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_article
    }


}