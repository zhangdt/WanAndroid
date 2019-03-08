package com.abner.wanandroid.module.video.bean;

/**
 * @author zhangduntai
 * @date 2019/3/7
 */
public class TextCard {

    /**
     * dataType : TextCard
     * id : 0
     * type : header5
     * text : 今日开眼精选
     * subTitle : null
     * actionUrl : null
     * adTrack : null
     * follow : null
     */

    private String dataType;
    private int id;
    private String type;
    private String text;
    private Object subTitle;
    private Object actionUrl;
    private Object adTrack;
    private Object follow;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(Object subTitle) {
        this.subTitle = subTitle;
    }

    public Object getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(Object actionUrl) {
        this.actionUrl = actionUrl;
    }

    public Object getAdTrack() {
        return adTrack;
    }

    public void setAdTrack(Object adTrack) {
        this.adTrack = adTrack;
    }

    public Object getFollow() {
        return follow;
    }

    public void setFollow(Object follow) {
        this.follow = follow;
    }
}
