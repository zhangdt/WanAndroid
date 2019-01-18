package com.abner.wanandroid.module.home.view

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import com.abner.wanandroid.R
import com.abner.wanandroid.base.BaseActivity
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_home.*
import com.abner.wanandroid.base.BaseFragment
import com.abner.wanandroid.module.article.view.ArticleFragment
import com.abner.wanandroid.module.home.adapter.HomePagerAdapter
import com.abner.wanandroid.module.music.view.MusicFragment
import com.abner.wanandroid.module.pastime.view.PastimeFragment
import com.abner.wanandroid.module.person.view.MeFragment
import com.abner.wanandroid.module.video.view.VideoFragment
import com.sise.abner.abaselib.util.BottomNavigationViewHelper


/**
 * @author zhangduntai
 * @date 2019/1/13
 */
class HomeActivity : BaseActivity() {
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun initView(savedInstanceState: Bundle?) {

        BottomNavigationViewHelper.disableShiftMode(home_bnv)
        home_bnv.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_article -> home_vp.currentItem = 0
                R.id.item_video -> home_vp.currentItem = 1
                R.id.item_music -> home_vp.currentItem = 2
                R.id.item_pastime -> home_vp.currentItem = 3
                R.id.item_person -> home_vp.currentItem = 4
            }
            return@setOnNavigationItemSelectedListener true
        }
        setupViewPager(home_vp)
        home_vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                Logger.i("viewPager:%S",position)
                home_bnv.menu.getItem(position).isChecked = true

            }
        })
    }

    override fun initViewModel() {
    }

    override fun getLayout(): Int {
        return R.layout.activity_home
    }

    override fun initFragment() {
    }

    private fun setupViewPager(viewPager: ViewPager) {
        var fragments = ArrayList<Fragment>()
        fragments.add(ArticleFragment().setOnDrawerListener {
            Logger.i("setOnDrawerListener:%s",it)
            home_vp.setDraw(it)
        })
        fragments.add(VideoFragment())
        fragments.add(MusicFragment())
        fragments.add(PastimeFragment())
        fragments.add(MeFragment())
        val adapter = HomePagerAdapter(fragments,supportFragmentManager)
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 5
    }

}