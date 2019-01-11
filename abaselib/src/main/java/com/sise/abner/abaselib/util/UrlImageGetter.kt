package com.sise.abner.abaselib.util

import android.graphics.drawable.Drawable
import android.text.Html
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.SimpleTarget
import com.sise.abner.abaselib.SDKBaseLib

/**
 * Created by Abner on 2017/10/23.
 */
class UrlImageGetter:Html.ImageGetter
{
    var  urlDrawable:Drawable? = null
    override fun getDrawable(p0: String?): Drawable {

         Glide.with(SDKBaseLib.application)
                 .load(p0)
//                 .into(SimpleTarget()

//                         urlDrawable = resource!!
//                 )

        return urlDrawable!!

    }


}