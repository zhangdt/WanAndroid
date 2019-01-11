package com.sise.abner.abaselib.View

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.sise.abner.abaselib.bean.CalendarMonth

/**
 * Created by Abner on 2017/12/21.
 */
class CalendarAdapter: PagerAdapter {


    var pageCount:Int = 6
    var views:ArrayList<MonthView> = ArrayList()
    var months:ArrayList<CalendarMonth> = ArrayList()

    constructor(context:Context)

    fun setData(months:ArrayList<CalendarMonth>,views: ArrayList<MonthView>): CalendarAdapter {
        this.months = months
        this.views = views
        return this
    }



    override fun getCount(): Int {
        return pageCount
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container?.removeView(views[position])
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        return super.instantiateItem(container, position)
        container.addView(views.get(position))
        return views.get(position)
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view == `object`
    }
}