package com.abner.wanandroid.module.video.bean;

import java.util.List;

/**
 * @author zhangduntai
 * @date 2019/3/18
 */
public class ColumnCardList {

    /**
     * dataType : ItemCollection
     * header : {"id":7,"title":"开眼栏目","font":"bold","subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"rightText":null}
     * itemList : [{"type":"squareCardOfColumn","data":{"dataType":"SquareCard","id":1219,"title":"开眼周末计划","image":"http://img.kaiyanapp.com/15b82791d204eefa71246792fc1aefa2.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E5%BC%80%E7%9C%BC%E5%91%A8%E6%9C%AB%E8%AE%A1%E5%88%92&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1274%26shareable%3Dtrue","shade":true,"adTrack":null,"description":"你的周末指南"},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfColumn","data":{"dataType":"SquareCard","id":1220,"title":"开眼专题策划","image":"http://img.kaiyanapp.com/77c82a7f940b1bf7b20acab7fa9b312e.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://campaign/list","shade":true,"adTrack":null,"description":"潮骚"},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfColumn","data":{"dataType":"SquareCard","id":1221,"title":"开眼榜单","image":"http://img.kaiyanapp.com/1b5cffeeb27cfbb25fc6de8c37b5ff3b.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://ranklist","shade":true,"adTrack":null,"description":"最热的都在这"},"tag":null,"id":0,"adIndex":-1},{"type":"squareCardOfColumn","data":{"dataType":"SquareCard","id":1246,"title":"开眼社区","image":"http://img.kaiyanapp.com/81dcc3369eede1de6569b48eb0a1c78a.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://homepage/community?tabIndex=0","shade":true,"adTrack":null,"description":"交到酷朋友"},"tag":null,"id":0,"adIndex":-1}]
     * count : 4
     * adTrack : null
     * footer : null
     */

    private String dataType;
    private HeaderBean header;
    private int count;
    private Object adTrack;
    private Object footer;
    private List<ItemListBean> itemList;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getAdTrack() {
        return adTrack;
    }

    public void setAdTrack(Object adTrack) {
        this.adTrack = adTrack;
    }

    public Object getFooter() {
        return footer;
    }

    public void setFooter(Object footer) {
        this.footer = footer;
    }

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class HeaderBean {
        /**
         * id : 7
         * title : 开眼栏目
         * font : bold
         * subTitle : null
         * subTitleFont : null
         * textAlign : left
         * cover : null
         * label : null
         * actionUrl : null
         * labelList : null
         * rightText : null
         */

        private int id;
        private String title;
        private String font;
        private Object subTitle;
        private Object subTitleFont;
        private String textAlign;
        private Object cover;
        private Object label;
        private Object actionUrl;
        private Object labelList;
        private Object rightText;

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

        public String getFont() {
            return font;
        }

        public void setFont(String font) {
            this.font = font;
        }

        public Object getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(Object subTitle) {
            this.subTitle = subTitle;
        }

        public Object getSubTitleFont() {
            return subTitleFont;
        }

        public void setSubTitleFont(Object subTitleFont) {
            this.subTitleFont = subTitleFont;
        }

        public String getTextAlign() {
            return textAlign;
        }

        public void setTextAlign(String textAlign) {
            this.textAlign = textAlign;
        }

        public Object getCover() {
            return cover;
        }

        public void setCover(Object cover) {
            this.cover = cover;
        }

        public Object getLabel() {
            return label;
        }

        public void setLabel(Object label) {
            this.label = label;
        }

        public Object getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(Object actionUrl) {
            this.actionUrl = actionUrl;
        }

        public Object getLabelList() {
            return labelList;
        }

        public void setLabelList(Object labelList) {
            this.labelList = labelList;
        }

        public Object getRightText() {
            return rightText;
        }

        public void setRightText(Object rightText) {
            this.rightText = rightText;
        }
    }

    public static class ItemListBean {
        /**
         * type : squareCardOfColumn
         * data : {"dataType":"SquareCard","id":1219,"title":"开眼周末计划","image":"http://img.kaiyanapp.com/15b82791d204eefa71246792fc1aefa2.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E5%BC%80%E7%9C%BC%E5%91%A8%E6%9C%AB%E8%AE%A1%E5%88%92&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1274%26shareable%3Dtrue","shade":true,"adTrack":null,"description":"你的周末指南"}
         * tag : null
         * id : 0
         * adIndex : -1
         */

        private String type;
        private DataBean data;
        private Object tag;
        private int id;
        private int adIndex;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public Object getTag() {
            return tag;
        }

        public void setTag(Object tag) {
            this.tag = tag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAdIndex() {
            return adIndex;
        }

        public void setAdIndex(int adIndex) {
            this.adIndex = adIndex;
        }

        public static class DataBean {
            /**
             * dataType : SquareCard
             * id : 1219
             * title : 开眼周末计划
             * image : http://img.kaiyanapp.com/15b82791d204eefa71246792fc1aefa2.jpeg?imageMogr2/quality/60/format/jpg
             * actionUrl : eyepetizer://webview/?title=%E5%BC%80%E7%9C%BC%E5%91%A8%E6%9C%AB%E8%AE%A1%E5%88%92&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1274%26shareable%3Dtrue
             * shade : true
             * adTrack : null
             * description : 你的周末指南
             */

            private String dataType;
            private int id;
            private String title;
            private String image;
            private String actionUrl;
            private boolean shade;
            private Object adTrack;
            private String description;

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

            public boolean isShade() {
                return shade;
            }

            public void setShade(boolean shade) {
                this.shade = shade;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }
}
