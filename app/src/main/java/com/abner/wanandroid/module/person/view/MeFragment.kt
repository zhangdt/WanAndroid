package com.abner.wanandroid.module.person.view

import android.os.Bundle
import com.abner.wanandroid.R
import com.abner.wanandroid.base.BaseFragment
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_me.*
import android.content.Context


/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/14
 */
class MeFragment: BaseFragment() {
    override fun onVisible() {
        Logger.i("onVisible")
    }

    override fun initView(args: Bundle?) {
        tv_person.setOnClickListener {
            val preferences = mContext.getSharedPreferences("language", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString("language", "zh")
            editor.apply()
        }
    }

    override fun initViewModel(savedInstanceState: Bundle?) {
    }

    override fun getLayout(): Int {
        return R.layout.fragment_me
    }
}