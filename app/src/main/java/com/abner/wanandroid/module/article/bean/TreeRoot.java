package com.abner.wanandroid.module.article.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author zhangduntai
 * @date 2019/1/15
 */
public class TreeRoot extends AbstractExpandableItem<TreeNode> implements MultiItemEntity {


    /**
     * courseId : 13
     * id : 150
     * name : 开发环境
     * order : 1
     * parentChapterId : 0
     * userControlSetTop : false
     * visible : 1
     */

    private int courseId;
    private int id;
    private String name;
    private int order;
    private int parentChapterId;
    private boolean userControlSetTop;
    private int visible;
    private List<TreeNode> children;


    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public boolean isUserControlSetTop() {
        return userControlSetTop;
    }

    public void setUserControlSetTop(boolean userControlSetTop) {
        this.userControlSetTop = userControlSetTop;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
