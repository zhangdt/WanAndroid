package com.abner.wanandroid.module.video.adapter;


import android.widget.ImageView;

import com.abner.wanandroid.R;

import com.abner.wanandroid.module.video.bean.Banner;
import com.abner.wanandroid.module.video.bean.ColumnCardList;
import com.abner.wanandroid.module.video.bean.FollowCard;
import com.abner.wanandroid.module.video.bean.HorizontalScrollCard;
import com.abner.wanandroid.module.video.bean.SquareCardCollection;
import com.abner.wanandroid.module.video.bean.TagBriefCard;
import com.abner.wanandroid.module.video.bean.TextCard;
import com.abner.wanandroid.module.video.bean.VideoListTemp;

import com.abner.wanandroid.module.video.bean.VideoSmallCard;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import com.sise.abner.abaselib.Glide.GlideOptions;
import com.squareup.moshi.*;


import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


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
    final int BRIEF_CARD= 5;
    final int HORIZONTAL__SCROLL_CARD =6;
    final int COLUM_CARDLIST=7;
    Moshi moshi = new Moshi.Builder().build();
    private JsonAdapter<FollowCard> followCardJsonAdapter = moshi.adapter(FollowCard.class);
    private JsonAdapter<TextCard> textCardJsonAdapter = moshi.adapter(TextCard.class);
    private JsonAdapter<SquareCardCollection> squareCardCollectionJsonAdapter = moshi.adapter(SquareCardCollection.class);
    private JsonAdapter<VideoSmallCard> videoSmallCardJsonAdapter = moshi.adapter(VideoSmallCard.class);
    private JsonAdapter<Banner> bannerJsonAdapter = moshi.adapter(Banner.class);
    private JsonAdapter<TagBriefCard> tagBriefCardJsonAdapter = moshi.adapter(TagBriefCard.class);
    private JsonAdapter<HorizontalScrollCard> horizontalScrollCardJsonAdapter = moshi.adapter(HorizontalScrollCard.class);
    private JsonAdapter<ColumnCardList> columnCardListJsonAdapter = moshi.adapter(ColumnCardList.class);
    FollowCardAdapter adapter = new FollowCardAdapter();

    public VideoAdapter(List<VideoListTemp.ItemListBean> data) {
        super(data);
        addItemType(TEXT_CARD, R.layout.item_text_card);
        addItemType(FOLLOW_CARD, R.layout.item_follow_card);
        addItemType(SQUARE_CARD_COLLECTION, R.layout.item_square_card_collection);
        addItemType(VIDEO_SMALL_CARD, R.layout.item_small_card);
        addItemType(BANNER,R.layout.item_banner);
        addItemType(BRIEF_CARD,R.layout.item_brief);
        addItemType(HORIZONTAL__SCROLL_CARD,R.layout.item_scroll_crad);
        addItemType(COLUM_CARDLIST,R.layout.item_column_card_list);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoListTemp.ItemListBean item) {
        switch (item.getItemType()) {

            case TEXT_CARD:
                TextCard textCard= textCardJsonAdapter.fromJsonValue(item.getData());
                helper.setText(R.id.tv_text_card,textCard.getText());
                break;
            case FOLLOW_CARD:
                FollowCard followCard = followCardJsonAdapter.fromJsonValue(item.getData());
                ImageView imageView = helper.getView(R.id.iv_follow_homepage);
                ImageView ivIcon = helper.getView(R.id.iv_icon);
                Glide.with(mContext).load(followCard.getContent().getData().getCover().getFeed()).apply(GlideOptions.Companion.getCircleOptions(mContext, 10)).into(imageView);
                Glide.with(mContext).load(followCard.getHeader().getIcon()).apply(GlideOptions.Companion.getCircleOptions(mContext)).into(ivIcon);
//                Logger.e(followCard.getContent().getData().getTitle());
                helper.setText(R.id.tv_title, followCard.getContent().getData().getTitle());
                helper.setText(R.id.tv_type, followCard.getHeader().getTitle() + " / #" + followCard.getContent().getData().getCategory());
                break;
            case SQUARE_CARD_COLLECTION:
                SquareCardCollection squareCardCollection = squareCardCollectionJsonAdapter.fromJsonValue(item.getData());
                helper.setText(R.id.tv_title,squareCardCollection.getHeader().getTitle())
                        .setText(R.id.tv_date,squareCardCollection.getHeader().getSubTitle());
                RecyclerView recyclerView = helper.getView(R.id.rv_follow_card);
                recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
                recyclerView.setAdapter(adapter);
                adapter.setNewData(squareCardCollection.getItemList());
//                ViewPager viewPager = helper.getView(R.id.vp_follow_card);
//                List<View> followCards = new ArrayList<>();
//
//                for (VideoListTemp.ItemListBean itemListBean :squareCardCollection.getItemList()){
//
//                    FollowCard followCard1 = followCardJsonAdapter.fromJsonValue(itemListBean.getData());
////                    FollowCard followCard1 = gson.fromJson(itemListBean.getData(),FollowCard.class); //太耗时
//                    View view = View.inflate(mContext,R.layout.item_follow_card,null);
//
//                    Glide.with(mContext).load(followCard1.getContent().getData().getCover().getFeed()).into((ImageView)view.findViewById(R.id.iv_follow_homepage));
//                    Glide.with(mContext).load(followCard1.getHeader().getIcon()).apply(GlideOptions.Companion.getCircleOptions(mContext)).into((ImageView) view.findViewById(R.id.iv_icon));
//                    ((TextView)view.findViewById(R.id.tv_title)).setText(followCard1.getContent().getData().getTitle());
//                    ((TextView)view.findViewById(R.id.tv_type)).setText(followCard1.getHeader().getTitle() + " / #" + followCard1.getContent().getData().getCategory());
//
//                    followCards.add(view);
//                }
//                viewPager.setAdapter(new FollowCardAdapter(followCards));
                break;

            case VIDEO_SMALL_CARD:
                VideoSmallCard videoSmallCard = videoSmallCardJsonAdapter.fromJsonValue(item.getData());
                Glide.with(mContext).load(videoSmallCard.getCover().getFeed()).into((ImageView) helper.getView(R.id.iv_pic));
                helper.setText(R.id.tv_title,videoSmallCard.getTitle())
                .setText(R.id.tv_tag,videoSmallCard.getCategory());
                break;
            case BANNER:
                Banner banner = bannerJsonAdapter.fromJsonValue(item.getData());
                Glide.with(mContext).load(banner.getImage()).into((ImageView) helper.getView(R.id.iv_pic));
                break;
            case BRIEF_CARD:
                TagBriefCard tagBriefCard  = tagBriefCardJsonAdapter.fromJsonValue(item.getData());
                Glide.with(mContext).load(tagBriefCard.getIcon()).into((ImageView) helper.getView(R.id.iv_icon));
                helper.setText(R.id.tv_tag,tagBriefCard.getTitle())
                        .setText(R.id.tv_description,tagBriefCard.getDescription());
                break;
            case HORIZONTAL__SCROLL_CARD:
                HorizontalScrollCard horizontalScrollCard = horizontalScrollCardJsonAdapter.fromJsonValue(item.getData());
                RecyclerView rvBanner = helper.getView(R.id.rv_banner);
                rvBanner.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
                HorizontalScrollAdapter horizontalScrollAdapter = new HorizontalScrollAdapter();
                rvBanner.setAdapter(horizontalScrollAdapter);
                horizontalScrollAdapter.setNewData(horizontalScrollCard.getItemList());
                break;
            case COLUM_CARDLIST:
                ColumnCardList columnCardList = columnCardListJsonAdapter.fromJsonValue(item.getData());
                RecyclerView rvColumn = helper.getView(R.id.rv_column_card);
                rvColumn.setLayoutManager(new GridLayoutManager(mContext,2));
                ColumnCardAdapter columnCardAdapter = new ColumnCardAdapter();
                rvColumn.setAdapter(columnCardAdapter);
                columnCardAdapter.setNewData(columnCardList.getItemList());
                break;

        }
    }


}
