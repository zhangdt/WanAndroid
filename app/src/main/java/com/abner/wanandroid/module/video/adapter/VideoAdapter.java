package com.abner.wanandroid.module.video.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.abner.wanandroid.R;
import com.abner.wanandroid.module.video.bean.Banner;
import com.abner.wanandroid.module.video.bean.FollowCard;
import com.abner.wanandroid.module.video.bean.SquareCardCollection;
import com.abner.wanandroid.module.video.bean.TextCard;
import com.abner.wanandroid.module.video.bean.VideoListTemp;
import com.abner.wanandroid.module.video.bean.VideoSmallCard;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.sise.abner.abaselib.Glide.GlideOptions;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;


/**
 * @author zhangduntai
 * @date 2019/3/7
 */
public class VideoAdapter extends BaseMultiItemQuickAdapter<VideoListTemp.ItemListBean, BaseViewHolder> {
    final int TEXT_CARD = 0;//大标题
    final int FOLLOW_CARD = 1;//封面加作者
    final int SQUARE_CARD_COLLECTION =2;//大标题加可滑动的followCard
    final int VIDEO_SMALL_CARD = 3;//
    final int BANNER = 4;
    final int HORIZONTAL__SCROLL_CARD =5;
    final int BRIEF_CARD= 6;
    final int COLUM_CARDLIST=7;


    public VideoAdapter(List<VideoListTemp.ItemListBean> data) {
        super(data);
        addItemType(TEXT_CARD, R.layout.item_text_card);
        addItemType(FOLLOW_CARD, R.layout.item_follow_card);
        addItemType(SQUARE_CARD_COLLECTION, R.layout.item_square_card_collection);
        addItemType(VIDEO_SMALL_CARD, R.layout.item_small_card);
        addItemType(BANNER,R.layout.item_banner);

    }

    @Override
    protected void convert(BaseViewHolder helper, VideoListTemp.ItemListBean item) {
        Gson gson = new Gson();
        switch (item.getItemType()) {
            case TEXT_CARD:
                TextCard textCard = gson.fromJson(item.getData(), TextCard.class);
                helper.setText(R.id.tv_text_card, textCard.getText());
                break;
            case FOLLOW_CARD:
                FollowCard followCard = gson.fromJson(item.getData(), FollowCard.class);
                ImageView imageView = helper.getView(R.id.iv_follow_homepage);
                ImageView ivIcon = helper.getView(R.id.iv_icon);
                Glide.with(mContext).load(followCard.getContent().getData().getCover().getFeed()).apply(GlideOptions.Companion.getCircleOptions(mContext, 10)).into(imageView);
                Glide.with(mContext).load(followCard.getHeader().getIcon()).apply(GlideOptions.Companion.getCircleOptions(mContext)).into(ivIcon);
//                Logger.e(followCard.getContent().getData().getTitle());
                helper.setText(R.id.tv_title, followCard.getContent().getData().getTitle());
                helper.setText(R.id.tv_type, followCard.getHeader().getTitle() + " / #" + followCard.getContent().getData().getCategory());
                break;
            case SQUARE_CARD_COLLECTION:
                SquareCardCollection squareCardCollection = gson.fromJson(item.getData(),SquareCardCollection.class);
                helper.setText(R.id.tv_title,squareCardCollection.getHeader().getTitle())
                        .setText(R.id.tv_date,squareCardCollection.getHeader().getSubTitle());
                ViewPager viewPager = helper.getView(R.id.vp_follow_card);
                List<View> followCards = new ArrayList<>();

                for (VideoListTemp.ItemListBean itemListBean :squareCardCollection.getItemList()){
                    FollowCard followCard1 = gson.fromJson(itemListBean.getData(),FollowCard.class); //太耗时
                    View view = View.inflate(mContext,R.layout.item_follow_card,null);

                    Glide.with(mContext).load(followCard1.getContent().getData().getCover().getFeed()).into((ImageView)view.findViewById(R.id.iv_follow_homepage));
                    Glide.with(mContext).load(followCard1.getHeader().getIcon()).apply(GlideOptions.Companion.getCircleOptions(mContext)).into((ImageView) view.findViewById(R.id.iv_icon));
                    ((TextView)view.findViewById(R.id.tv_title)).setText(followCard1.getContent().getData().getTitle());
                    ((TextView)view.findViewById(R.id.tv_type)).setText(followCard1.getHeader().getTitle() + " / #" + followCard1.getContent().getData().getCategory());

                    followCards.add(view);
                }
                viewPager.setAdapter(new FollowCardAdapter(followCards));
                break;

            case VIDEO_SMALL_CARD:
                VideoSmallCard videoSmallCard = gson.fromJson(item.getData(),VideoSmallCard.class);
                Glide.with(mContext).load(videoSmallCard.getCover().getFeed()).into((ImageView) helper.getView(R.id.iv_pic));
                helper.setText(R.id.tv_title,videoSmallCard.getTitle())
                .setText(R.id.tv_tag,videoSmallCard.getCategory());
                break;

            case BANNER:
                Banner banner = gson.fromJson(item.getData(),Banner.class);
                Glide.with(mContext).load(banner.getImage()).into((ImageView) helper.getView(R.id.iv_pic));
                break;

        }
    }


}
