package com.abner.wanandroid.module.video.view

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abner.wanandroid.R
import com.abner.wanandroid.base.BaseFragment
import com.abner.wanandroid.module.video.adapter.VideoAdapter
import com.abner.wanandroid.module.video.bean.EyepetizerIndexTab
import com.abner.wanandroid.module.video.vm.EyeVm
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_video_recommend.*

/**
 *
 *
 * @author zhangduntai
 * @date 2019/3/6
 */
class VideoRecommendFragment :BaseFragment() {
    override fun onLoadData() {
        eyeVm.getVideoList(tabinfo.apiUrl)
    }

    lateinit var eyeVm: EyeVm
    lateinit var adpter: VideoAdapter

    lateinit var tabinfo: EyepetizerIndexTab.TabInfoBean.TabListBean
    fun setTabInfo(tabinfo: EyepetizerIndexTab.TabInfoBean.TabListBean){
        this.tabinfo = tabinfo
    }
    override fun onVisible() {
    }


    override fun initView(args: Bundle?) {
        rv_video.layoutManager = LinearLayoutManager(mContext)

        rv_video.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                //0 表示停止滑动的状态 SCROLL_STATE_IDLE
                //1表示正在滚动，用户手指在屏幕上 SCROLL_STATE_TOUCH_SCROLL
                //2表示正在滑动。用户手指已经离开屏幕 SCROLL_STATE_FLING
                when (newState) {
                    2 -> {
                        Glide.with(mContext.applicationContext).pauseRequests()
                    }
                    0 -> {
                        Glide.with(mContext.applicationContext).resumeRequests()
                    }
                    1 -> {
                        Glide.with(mContext.applicationContext).resumeRequests()
                    }
                }

            }
        })
    }

    override fun initViewModel(savedInstanceState: Bundle?) {
        eyeVm = ViewModelProviders.of(this@VideoRecommendFragment).get(EyeVm::class.java).apply {
            videos.observe(this@VideoRecommendFragment, Observer {
                adpter = VideoAdapter(it.itemList)
                rv_video.adapter = adpter
            })
        }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_video_recommend
    }
}