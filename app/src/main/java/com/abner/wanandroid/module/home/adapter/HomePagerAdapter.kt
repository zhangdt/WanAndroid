package com.abner.wanandroid.module.home.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.View

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/14
 */
class HomePagerAdapter(data:List<Fragment>,fragmentManager:FragmentManager): FragmentPagerAdapter(fragmentManager) {
    var fragments = data;
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }


}