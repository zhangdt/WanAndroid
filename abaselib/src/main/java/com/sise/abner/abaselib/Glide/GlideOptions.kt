package com.sise.abner.abaselib.Glide

import android.content.Context
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.sise.abner.abaselib.R

/**
 * Created by Abner on 2017/12/18.
 */
class GlideOptions {
    companion object {
        fun getCircleOptions(context: Context):RequestOptions
        {
            return RequestOptions()
                    .centerCrop()
//                    .placeholder(R.)
//                    .error(R.mipmap.lodefailed)
                    .priority(Priority.HIGH)
                    .transform(GlideCircleTransform(context))
        }

        fun  getGSOptions(context: Context):RequestOptions
        {
            return RequestOptions()
                    .centerCrop()
                    .priority(Priority.HIGH)
                    .transform(GlideGsTransform(context))
        }
    }
}