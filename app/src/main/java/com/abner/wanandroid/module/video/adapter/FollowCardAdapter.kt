package com.abner.wanandroid.module.video.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.abner.wanandroid.R
import com.abner.wanandroid.module.video.bean.FollowCard
import com.abner.wanandroid.module.video.bean.VideoListTemp
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sise.abner.abaselib.Glide.GlideOptions
import com.squareup.moshi.Moshi

/**
 * @author zhangduntai
 * @date 2019/3/11
 */
class FollowCardAdapter() : BaseQuickAdapter<VideoListTemp.ItemListBean, BaseViewHolder>(R.layout.item_follow_card) {
    internal var moshi = Moshi.Builder().build()
    internal var followCardJsonAdapter = moshi.adapter(FollowCard::class.java)
    override fun convert(helper: BaseViewHolder?, item: VideoListTemp.ItemListBean) {
        var followCard = followCardJsonAdapter.fromJsonValue(item.data)

        if (followCard != null) {
            Glide.with(mContext).load(followCard.content.data.cover.feed).into(helper?.getView(R.id.iv_follow_homepage)!!)
            Glide.with(mContext).load(followCard.header.icon).apply(GlideOptions.getCircleOptions(mContext)).into(helper?.getView(R.id.iv_icon)!!)
            helper?.setText(R.id.tv_title, followCard.content.data.title)
                    ?.setText(R.id.tv_type, followCard.header.title + " / #" + followCard.content.data.category)
        };
    }

}