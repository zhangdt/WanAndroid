package com.abner.wanandroid.module.video.view

import android.os.Bundle
import com.abner.wanandroid.R
import com.abner.wanandroid.base.BaseFragment
import com.abner.wanandroid.module.video.bean.EyepetizerIndexTab

/**
 *
 *
 * @author zhangduntai
 * @date 2019/3/6
 */
class VideoRecommendFragment :BaseFragment() {
    lateinit var tabinfo: EyepetizerIndexTab.TabInfoBean.TabListBean
    fun setTabInfo(tabinfo: EyepetizerIndexTab.TabInfoBean.TabListBean){
        this.tabinfo = tabinfo
    }
    override fun onVisible() {
    }

    override fun initView(args: Bundle?) {
    }

    override fun initViewModel(savedInstanceState: Bundle?) {
    }

    override fun getLayout(): Int {
        return R.layout.fragment_video_recommend
    }
}