package com.abner.wanandroid.module.video.adapter;

import android.widget.ImageView;

import com.abner.wanandroid.R;
import com.abner.wanandroid.module.video.bean.FollowCard;
import com.abner.wanandroid.module.video.bean.TextCard;
import com.abner.wanandroid.module.video.bean.VideoListTemp;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.sise.abner.abaselib.Glide.GlideOptions;

import java.util.List;


/**
 * @author zhangduntai
 * @date 2019/3/7
 */
public class VideoAdapter  extends BaseMultiItemQuickAdapter<VideoListTemp.ItemListBean, BaseViewHolder> {
     final  int  TEXT_CARD = 0;
    final  int FOLLOW_CARD = 1;
    public VideoAdapter(List<VideoListTemp.ItemListBean> data) {
        super(data);
        addItemType(TEXT_CARD, R.layout.item_text_card);
        addItemType(FOLLOW_CARD, R.layout.item_follow_card);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoListTemp.ItemListBean item) {
        Gson gson = new Gson();
        switch (item.getItemType())
        {
            case TEXT_CARD:
                TextCard textCard = gson.fromJson(item.getData(),TextCard.class);
                helper.setText(R.id.tv_text_card,textCard.getText());
                break;
            case FOLLOW_CARD:
                FollowCard followCard = gson.fromJson(item.getData(),FollowCard.class);
                ImageView imageView = helper.getView(R.id.iv_follow_homepage);
                ImageView ivIcon = helper.getView(R.id.iv_icon);
                Glide.with(mContext).load(followCard.getContent().getData().getCover().getFeed()).apply(GlideOptions.Companion.getCircleOptions(mContext,50)).into(imageView);
                Glide.with(mContext).load(followCard.getHeader().getIcon()).apply(GlideOptions.Companion.getCircleOptions(mContext)).into(ivIcon);

        }
    }


}
