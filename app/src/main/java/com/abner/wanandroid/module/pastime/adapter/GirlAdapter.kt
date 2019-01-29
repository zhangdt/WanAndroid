package com.abner.wanandroid.module.pastime.adapter

import android.widget.ImageView
import com.abner.wanandroid.R
import com.abner.wanandroid.module.pastime.bean.Girl
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sise.abner.abaselib.kotlinext.showImageByUrl

/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/29
 */
class GirlAdapter : BaseQuickAdapter<Girl, BaseViewHolder>(R.layout.item_girl) {
    override fun convert(helper: BaseViewHolder?, item: Girl?) {
        if (item != null) {
            helper?.getView<ImageView>(R.id.iv_girl)?.showImageByUrl(mContext, item.url)
        }
    }
}