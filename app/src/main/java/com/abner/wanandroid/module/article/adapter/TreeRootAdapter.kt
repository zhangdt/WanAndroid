package com.abner.wanandroid.module.article.adapter

import com.abner.wanandroid.R
import com.abner.wanandroid.module.article.bean.TreeNode
import com.abner.wanandroid.module.article.bean.TreeRoot
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity


/**
 *
 *
 * @author zhangduntai
 * @date 2019/1/15
 */
class TreeRootAdapter : BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder>{
    val TYPE_ROOT = 0
    val TYPE_NODE = 1
    lateinit var _nodeClickListener: (Int, String) -> Unit

    constructor(data:List<MultiItemEntity>) : super(data) {
        addItemType(TYPE_ROOT, R.layout.item_treeroot)
        addItemType(TYPE_NODE, R.layout.item_treenode)
    }
    override fun convert(helper: BaseViewHolder?, item: MultiItemEntity?) {
        when(helper?.itemViewType){
            TYPE_ROOT->{
                var  root = item as TreeRoot
                helper.setText(R.id.tv_name,root.name)
                helper.setOnClickListener(R.id.ll_root) {
                    var pos = helper.adapterPosition
                    when {
                        pos==0 -> _nodeClickListener(0,root.name)
                        root.isExpanded -> collapse(pos)
                        else -> expand(pos)
                    }
                }
            }
            TYPE_NODE->{
                var node:TreeNode = item as TreeNode
                helper.setText(R.id.tv_name,node.name)
                helper.setOnClickListener(R.id.cv_node) {
                    _nodeClickListener(node.id,node.name)
                }
            }
        }

    }

    fun setNodeClickListener(listener:(Int,String)->Unit){
        _nodeClickListener = listener
    }


}