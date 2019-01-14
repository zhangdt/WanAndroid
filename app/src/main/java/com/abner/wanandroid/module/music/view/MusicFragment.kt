package com.abner.wanandroid.module.music.view

import android.os.Bundle
import com.abner.wanandroid.R
import com.abner.wanandroid.base.BaseFragment
import com.orhanobut.logger.Logger

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/14
 */
class MusicFragment: BaseFragment() {
    override fun onVisible() {
        Logger.i("onVisible")
    }

    override fun initView(args: Bundle?) {
    }

    override fun initViewModel(savedInstanceState: Bundle?) {
    }

    override fun getLayout(): Int {
        return R.layout.fragment_music
    }
}