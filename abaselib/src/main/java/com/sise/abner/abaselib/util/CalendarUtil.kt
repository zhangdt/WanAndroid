package com.sise.abner.abaselib.util

import com.sise.abner.abaselib.bean.CalendarDay
import com.sise.abner.abaselib.bean.CalendarMonth
import java.util.*
import kotlin.collections.ArrayList



/**
 * Created by Abner on 2017/12/25.
 */
class CalendarUtil {

    companion object {
        //构造从当前月开始的Month数组  6个月
        fun createMonths(date: Date): ArrayList<CalendarMonth> {
            var months: ArrayList<CalendarMonth> = ArrayList()
            var count:Int = 1
            val calendar = Calendar.getInstance()
            calendar.time = date
            while (count<=6) {

                months.add(createMonth(calendar))
                calendar.add(Calendar.MONTH, 1)//把月份往后增加一个月.整数往后推,负数往前移动
                ++count
            }
            return months
        }

        fun createMonth(calendar:Calendar):CalendarMonth
        {
            var nowDate = Date()
            var y = calendar.get(Calendar.YEAR)
            var m = calendar.get(Calendar.MONTH)+1

            var days:ArrayList<CalendarDay> = ArrayList()
            var i:Int =1
            while (i<=calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
            {
                if ((y>nowDate.year+1900)||(m>=nowDate.month+1&&i>=nowDate.date)) {
                    var day: CalendarDay = CalendarDay(356, false, intArrayOf(y, m, i),false)
                    days.add(day)
                }else
                {
                    var day: CalendarDay = CalendarDay(356, true, intArrayOf(y, m, i),false)
                    days.add(day)
                }
                i++
            }
            calendar.set(Calendar.DATE,1)
            var month:CalendarMonth = CalendarMonth(days,calendar.get(Calendar.DAY_OF_WEEK))
            return month
        }

    }

}