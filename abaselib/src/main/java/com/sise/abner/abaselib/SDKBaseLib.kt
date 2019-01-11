package com.sise.abner.abaselib

import android.app.Application
import com.sise.abner.abaselib.base.BaseApp

/**
 * Created by Abner on 2017/9/20.
 */
object SDKBaseLib {

    public lateinit var application: BaseApp

    public fun SDKInit(application: BaseApp) {
        this.application = application
    }


}