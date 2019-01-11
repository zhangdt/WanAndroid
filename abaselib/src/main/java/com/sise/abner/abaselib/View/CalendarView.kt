package com.sise.abner.abaselib.View

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import com.sise.abner.abaselib.bean.CalendarMonth
import com.sise.abner.abaselib.util.CalendarUtil
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Abner on 2017/12/20.
 */
class CalendarView : ViewPager {

    private lateinit var calendarAdapter: CalendarAdapter
    private lateinit var mConetxt:Context
    private lateinit var months: ArrayList<CalendarMonth>

    private lateinit var dayClickLitener:(Int,Int,Int)->Unit
    private lateinit var curSelectLitener:(Int,Int)->Unit


    constructor(context: Context?) : super(context!!)
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)
    {
        mConetxt  =  context!!
        init()
    }



    private fun initArrt(context: Context?,attrs: AttributeSet?)
    {

    }

     fun setDayClickListener(listener:(Int,Int,Int)->Unit): CalendarView {
        dayClickLitener = listener!!
        return this
    }
     fun getDayClickListener(): (Int, Int, Int) -> Unit {
        return dayClickLitener
    }

    fun setCurSelectListener(listener: (Int, Int) -> Unit):CalendarView
    {
        curSelectLitener = listener!!
        return this
    }

    fun clearSelect()
    {

    }

    private fun init()
    {
        months = CalendarUtil.createMonths(Date())
        var views:ArrayList<MonthView> = ArrayList()
        for ( month in months)
        {
            views.add(MonthView(context)
                    .setDate(month))
        }
        calendarAdapter = CalendarAdapter(mConetxt).setData(months,views)
        adapter =calendarAdapter
        setOnPageChangeListener(object:OnPageChangeListener
        {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                curSelectLitener(months[position].dataList[0].solar[0],months[position].dataList[0].solar[1])
            }

        })
    }

}