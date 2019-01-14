package com.sise.abner.abaselib.base

import android.app.Application
import com.facebook.stetho.Stetho

//import com.sise.abner.abaselib.SDKBaseLib.application

open class BaseApp : Application() {
     companion object {
         /**
          * Context对象
          */
         private var mInstance: BaseApp? = null

         /**
          * 全局Context
          * @return Application的Context
          */
         fun getInstance(): BaseApp? {
             return mInstance
         }
     }



    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }



}