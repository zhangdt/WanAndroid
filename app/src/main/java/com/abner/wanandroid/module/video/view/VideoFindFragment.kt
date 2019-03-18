package com.abner.wanandroid.module.video.view

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.abner.wanandroid.R
import com.abner.wanandroid.base.BaseFragment
import com.abner.wanandroid.module.video.adapter.VideoAdapter
import com.abner.wanandroid.module.video.bean.EyepetizerIndexTab
import com.abner.wanandroid.module.video.vm.EyeVm
import kotlinx.android.synthetic.main.fragment_video_daily.*
import kotlinx.android.synthetic.main.fragment_video_find.*

/**
 *
 *
 * @author zhangduntai
 * @date 2019/3/6
 */
class VideoFindFragment :BaseFragment() {


    lateinit var eyeVm: EyeVm
    lateinit var adpter: VideoAdapter
    lateinit var tabinfo: EyepetizerIndexTab.TabInfoBean.TabListBean

    fun setTabInfo(tabinfo: EyepetizerIndexTab.TabInfoBean.TabListBean) {
        this.tabinfo = tabinfo
    }

    override fun onLoadData() {
        eyeVm.getVideoList(tabinfo.apiUrl)
    }
    override fun onVisible() {
    }

    override fun initView(args: Bundle?) {
        rv_find.layoutManager = LinearLayoutManager(mContext)

    }

    override fun initViewModel(savedInstanceState: Bundle?) {
        eyeVm = ViewModelProviders.of(this@VideoFindFragment).get(EyeVm::class.java).apply {
            videos.observe(this@VideoFindFragment, Observer {
                adpter = VideoAdapter(it.itemList)
                rv_find.adapter = adpter
            })
        }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_video_find
    }
}