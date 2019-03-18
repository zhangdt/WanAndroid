package com.abner.wanandroid.module.video.view

import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.abner.wanandroid.R
import com.abner.wanandroid.base.BaseFragment
import com.abner.wanandroid.module.video.adapter.VideoVpAdapter
import com.abner.wanandroid.module.video.bean.EyepetizerIndexTab
import com.abner.wanandroid.module.video.vm.EyeVm
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_video.*

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/14
 */
class VideoFragment : BaseFragment() {


    lateinit var mVideoFindFragment: VideoFindFragment
    lateinit var mVideoRecommendFragment: VideoRecommendFragment
    lateinit var mVideoDailyFragment: VideoDailyFragment
    private lateinit var eyeVm: EyeVm
    override fun onVisible() {
        Logger.i("onVisible")
    }

    override fun onLoadData() {
        eyeVm.getIndexTabInfo()
    }

    override fun initView(args: Bundle?) {
//        vp_video.adapter =

    }

    override fun initViewModel(savedInstanceState: Bundle?) {
        eyeVm = ViewModelProviders.of(this@VideoFragment).get(EyeVm::class.java).apply {
            eyeTabInfo.observe(this@VideoFragment, Observer {
                setupViewPager(it)
                tl_video.setupWithViewPager(vp_video)
            })
        }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_video
    }

    private fun setupViewPager(eyeTabInfo: EyepetizerIndexTab) {
        mVideoFindFragment = VideoFindFragment()
        mVideoFindFragment.setTabInfo(eyeTabInfo.tabInfo.tabList[0])
        mVideoRecommendFragment = VideoRecommendFragment()
        mVideoRecommendFragment.setTabInfo(eyeTabInfo.tabInfo.tabList[1])
        mVideoDailyFragment = VideoDailyFragment()
        mVideoDailyFragment.setTabInfo(eyeTabInfo.tabInfo.tabList[2])

        var fragments = ArrayList<Fragment>()
        fragments.add(mVideoFindFragment)
        fragments.add(mVideoRecommendFragment)
        fragments.add(mVideoDailyFragment)

        var titles = ArrayList<String>()
        titles.add(eyeTabInfo.tabInfo.tabList[0].name)
        titles.add(eyeTabInfo.tabInfo.tabList[1].name)
        titles.add(eyeTabInfo.tabInfo.tabList[2].name)

        vp_video.adapter = VideoVpAdapter(fragments, titles, this.fragmentManager!!)
        vp_video.offscreenPageLimit = 3

    }
}