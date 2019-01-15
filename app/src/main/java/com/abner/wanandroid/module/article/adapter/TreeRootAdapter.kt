package com.abner.wanandroid.module.article.adapter

import com.abner.wanandroid.R
import com.abner.wanandroid.module.article.bean.TreeRoot
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity


/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/15
 */
class TreeRootAdapter : BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder>{


    constructor(data:List<MultiItemEntity>) : super(data) {
        addItemType(0, R.layout.item_tree)
        addItemType(1, R.layout.item_tree)
    }
    override fun convert(helper: BaseViewHolder?, item: MultiItemEntity?) {
        when(helper?.itemViewType){
            0->{
            }
            1->{
            }
        }

    }


}