package com.abner.wanandroid.module.video.adapter

import android.widget.ImageView
import com.abner.wanandroid.R
import com.abner.wanandroid.module.video.bean.ColumnCardList
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sise.abner.abaselib.kotlinext.showImageByUrl

/**
 * @author zhangduntai
 * @date 2019/3/18
 */
class ColumnCardAdapter: BaseQuickAdapter<ColumnCardList.ItemListBean, BaseViewHolder>(R.layout.item_column_card) {
    override fun convert(helper: BaseViewHolder?, item: ColumnCardList.ItemListBean?) {
        if (item != null) {
            helper!!.getView<ImageView>(R.id.iv_column_card).showImageByUrl(mContext,item.data.image)
        }
    }
}