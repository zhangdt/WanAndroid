package com.sise.abner.abaselib.base

import android.app.Activity
import java.lang.ref.WeakReference

/**
 * Created by Abner on 2017/9/20.
 */
class ActivityCollector
{
    companion object {
        val activitys:ArrayList<Activity> = ArrayList<Activity>()
        val  weakReferenceActivitys:WeakReference<ArrayList<Activity>> = WeakReference<ArrayList<Activity>>(activitys)

        fun addActivity(a:Activity)
        {
            weakReferenceActivitys.get()!!.add(a)
        }

        fun removeActivity(a:Activity)
        {
            weakReferenceActivitys.get()!!.remove(a)
            if(!a.isFinishing())
            {
                a.finish()
            }
        }
    }
}