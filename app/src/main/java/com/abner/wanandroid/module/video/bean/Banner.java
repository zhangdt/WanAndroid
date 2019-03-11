package com.abner.wanandroid.module.video.bean;

/**
 * @author zhangduntai
 * @date 2019/3/11
 */
public class Banner {

    /**
     * dataType : Banner
     * id : 424
     * title : 寻猫启示
     * description : null
     * image : http://img.kaiyanapp.com/2d06ae121c01ce15e1d390057bbb00e6.jpeg?imageMogr2/quality/60/format/jpg
     * actionUrl : eyepetizer://webview/?title=%E5%AF%BB%E7%8C%AB%E5%90%AF%E7%A4%BA&url=http%3A%2F%2Fwww.eyepetizer.net%2Fvideos_article.html%3Fnid%3D424%26shareable%3Dtrue
     * adTrack : null
     * shade : false
     * label : null
     * labelList : null
     * header : null
     * autoPlay : false
     */

    private String dataType;
    private int id;
    private String title;
    private Object description;
    private String image;
    private String actionUrl;
    private Object adTrack;
    private boolean shade;
    private Object label;
    private Object labelList;
    private Object header;
    private boolean autoPlay;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public Object getAdTrack() {
        return adTrack;
    }

    public void setAdTrack(Object adTrack) {
        this.adTrack = adTrack;
    }

    public boolean isShade() {
        return shade;
    }

    public void setShade(boolean shade) {
        this.shade = shade;
    }

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public Object getLabelList() {
        return labelList;
    }

    public void setLabelList(Object labelList) {
        this.labelList = labelList;
    }

    public Object getHeader() {
        return header;
    }

    public void setHeader(Object header) {
        this.header = header;
    }

    public boolean isAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }
}
