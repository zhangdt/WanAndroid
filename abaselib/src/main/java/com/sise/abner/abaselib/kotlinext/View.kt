package com.example.abner.myapplication10.ext

import android.util.Log
import android.view.OrientationEventListener
import android.view.View

fun View.hide():View {
    visibility = View.GONE
    return this
}

fun View.show():View {
    visibility = View.VISIBLE
    return this
}

fun View.isShowing(): Boolean {
    return visibility == View.VISIBLE
}

fun View.setOnCustomClickListener(listener: (view:View) -> Unit):View{
        var lastclick:Long =0
        var timems = 1000
    setOnClickListener{
        Log.e("abner","time:"+(System.currentTimeMillis() - lastclick))
        if (System.currentTimeMillis() - lastclick >= timems) {
            lastclick = System.currentTimeMillis()
            listener(it)
        }
    }
    return this
}

