package com.sise.abner.abaselib.util

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/14
 */
class LoggingUtil {
    companion object {
        fun init(isDebug: Boolean){
            Logger.addLogAdapter(object : AndroidLogAdapter() {
                override fun isLoggable(priority: Int, tag: String?): Boolean {
                    return isDebug
                }
            })
        }
    }
}