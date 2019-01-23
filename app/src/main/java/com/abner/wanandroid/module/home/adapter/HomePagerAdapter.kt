package com.abner.wanandroid.module.home.adapter


import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/14
 */
class HomePagerAdapter(data:List<Fragment>, fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    var fragments = data;
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }


}