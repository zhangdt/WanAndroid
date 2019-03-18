package com.abner.wanandroid.module.video.adapter

import android.widget.ImageView
import com.abner.wanandroid.R
import com.abner.wanandroid.module.video.bean.Banner
import com.abner.wanandroid.module.video.bean.HorizontalScrollCard
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sise.abner.abaselib.kotlinext.showImageByUrl

/**
 * @author zhangduntai
 * @date 2019/3/18
 */
class HorizontalScrollAdapter : BaseQuickAdapter<HorizontalScrollCard.ItemListBean, BaseViewHolder>(R.layout.item_banner) {
    override fun convert(helper: BaseViewHolder?, item: HorizontalScrollCard.ItemListBean?) {
        if (item != null) {
            helper?.getView<ImageView>(R.id.iv_pic)!!.showImageByUrl(mContext,item.data.image)
        }
    }
}