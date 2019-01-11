package com.sise.abner.abaselib.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Abner on 2018/2/24.
 */
class TimeUtil {
    companion object {

        fun timestamp2YYMMDD(timestamp:Long):String
        {
            val format = SimpleDateFormat("yyyy-MM-dd")
//            val time = Long(timestamp)
            val d = format.format(timestamp)
            val date = format.parse(d)
            println("Format To String(Date):" + d)
            println("Format To Date:" + date)
            return d
        }

        fun timestamp2m(timestamp: Long):Int{
            var data = Date(timestamp)
            return data.month+1
        }

        fun timestamp2D(timestamp: Long):Int{
            var data = Date(timestamp)
            return data.date
        }

    }
}