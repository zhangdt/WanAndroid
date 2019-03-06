package com.abner.wanandroid.module.pastime.view

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.abner.wanandroid.R
import com.abner.wanandroid.base.BaseFragment
import com.abner.wanandroid.module.pastime.adapter.GirlAdapter
import com.abner.wanandroid.module.pastime.vm.PastimeVm
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_pastime.*
import java.util.concurrent.Executors

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/14
 */
class PastimeFragment: BaseFragment() {
    lateinit var pastimeVm:PastimeVm
    lateinit var adapter:GirlAdapter
    override fun onVisible() {
        Logger.i("onVisible")
        pastimeVm.getGrils()
    }

    override fun initView(args: Bundle?) {
        rv_girl.layoutManager = GridLayoutManager(mContext, 2)
        adapter = GirlAdapter()
        rv_girl.adapter = adapter

        rv_girl.showShimmerAdapter()
    }

    override fun initViewModel(savedInstanceState: Bundle?) {
        pastimeVm = ViewModelProviders
                .of(this@PastimeFragment)
                .get(PastimeVm::class.java)
                .apply {
                    girls.observe(this@PastimeFragment, Observer {
                        adapter.setNewData(it)
                        rv_girl.hideShimmerAdapter()
                    })
                }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_pastime
    }
}