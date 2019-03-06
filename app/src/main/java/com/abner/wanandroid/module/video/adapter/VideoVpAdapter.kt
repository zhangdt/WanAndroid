package com.abner.wanandroid.module.video.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *
 *
 * @author zhangduntai
 * @date 2019/3/6
 */
class VideoVpAdapter(data: List<Fragment>, titles: List<String>, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    var fragments = data
    var itemTitles = titles
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return itemTitles[position]
    }
}