package com.sise.abner.abaselib.kotlinext

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sise.abner.abaselib.Glide.GlideOptions

fun ImageView.showImageByUrl(context: Context, url: String) {
    Glide.with(context).load(url).into(this)
}

fun ImageView.showCircleImageByUrl(context: Context,url:String)
{
    Glide.with(context).load(url).apply(GlideOptions.getCircleOptions(context)).into(this)
}

fun ImageView.showCircleImageByUrl(context: Context,uri:Uri)
{
    Glide.with(context).load(uri).apply(GlideOptions.getCircleOptions(context)).into(this)
}