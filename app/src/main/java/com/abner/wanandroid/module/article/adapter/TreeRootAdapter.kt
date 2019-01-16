package com.abner.wanandroid.module.article.adapter

import com.abner.wanandroid.R
import com.abner.wanandroid.module.article.bean.TreeRoot
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.facebook.stetho.inspector.elements.NodeType
import com.squareup.haha.perflib.RootType


/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/15
 */
class TreeRootAdapter : BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder>{
    val TYPE_ROOT = 0
    val TYPE_NODE = 1

    constructor(data:List<MultiItemEntity>) : super(data) {
        addItemType(TYPE_ROOT, R.layout.item_tree)
        addItemType(TYPE_NODE, R.layout.item_tree)
    }
    override fun convert(helper: BaseViewHolder?, item: MultiItemEntity?) {
        when(helper?.itemViewType){
            TYPE_ROOT->{

            }
            TYPE_NODE->{

            }
        }

    }


}