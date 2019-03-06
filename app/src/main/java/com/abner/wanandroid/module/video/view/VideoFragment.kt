package com.abner.wanandroid.module.video.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.abner.wanandroid.R
import com.abner.wanandroid.base.BaseFragment
import com.abner.wanandroid.module.video.adapter.VideoVpAdapter
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_video.*

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/14
 */
class VideoFragment: BaseFragment() {
    lateinit var mVideoFindFragment:VideoFindFragment
    lateinit var mVideoRecommendFragment:VideoRecommendFragment
    lateinit var mVideoDailyFragment:VideoDailyFragment
    override fun onVisible() {
        Logger.i("onVisible")
    }

    override fun initView(args: Bundle?) {
//        vp_video.adapter =
        setupViewPager()
        tl_video.setupWithViewPager(vp_video)

    }

    override fun initViewModel(savedInstanceState: Bundle?) {
    }

    override fun getLayout(): Int {
        return R.layout.fragment_video
    }

    private fun setupViewPager(){
        mVideoFindFragment = VideoFindFragment()
        mVideoRecommendFragment = VideoRecommendFragment()
        mVideoDailyFragment = VideoDailyFragment()

        var fragments = ArrayList<Fragment>()
        fragments.add(mVideoFindFragment)
        fragments.add(mVideoRecommendFragment)
        fragments.add(mVideoDailyFragment)

        var titles = ArrayList<String>()
        titles.add(mContext.resources.getString(R.string.video_find))
        titles.add(mContext.resources.getString(R.string.video_recommend))
        titles.add(mContext.resources.getString(R.string.video_daily))

        vp_video.adapter = VideoVpAdapter(fragments,titles, this!!.fragmentManager!!)

    }
}