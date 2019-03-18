package com.abner.wanandroid.module.video.bean;

import java.util.List;

/**
 * @author zhangduntai
 * @date 2019/3/18
 */
public class HorizontalScrollCard {

    /**
     * dataType : HorizontalScrollCard
     * itemList : [{"type":"banner2","data":{"dataType":"Banner","id":1281,"title":"","description":"","image":"http://img.kaiyanapp.com/59f66656031e54854230fcbf39daaf3c.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E5%BC%80%E7%9C%BC%E5%91%A8%E6%9C%AB%E8%AE%A1%E5%88%92&url=https%3A%2F%2Fwww.kaiyanapp.com%2Ftopic_article.html%3Fnid%3D86%26cookie%3D%26shareable%3Dtrue%26type%3DarticleTopic","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"rightText":null,"icon":null,"description":null},"autoPlay":false},"tag":null,"id":0,"adIndex":-1},{"type":"banner2","data":{"dataType":"Banner","id":1277,"title":"","description":"","image":"http://img.kaiyanapp.com/860721f008cf3ed6a6716b6bd1bac8e0.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=MINDPARK%202019&url=https%3A%2F%2Fwww.kaiyanapp.com%2Ftopic_article.html%3Fnid%3D85%26cookie%3D%26shareable%3Dtrue%26type%3DarticleTopic","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"rightText":null,"icon":null,"description":null},"autoPlay":false},"tag":null,"id":0,"adIndex":-1},{"type":"banner2","data":{"dataType":"Banner","id":1272,"title":"","description":"","image":"http://img.kaiyanapp.com/5fe6afc957d5bb87d2234055ecaf78fc.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=&url=https%3A%2F%2Fwww.kaiyanapp.com%2Ftopic_article.html%3Fnid%3D84%26cookie%3D%26shareable%3Dtrue","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"rightText":null,"icon":null,"description":null},"autoPlay":false},"tag":null,"id":0,"adIndex":-1},{"type":"banner2","data":{"dataType":"Banner","id":1269,"title":"","description":"","image":"http://img.kaiyanapp.com/8accfe3b083061609326f2c9fa6e6016.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=&url=https%3A%2F%2Fwww.kaiyanapp.com%2Ftopic_article.html%3Fnid%3D83%26cookie%3D%26shareable%3Dtrue","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"rightText":null,"icon":null,"description":null},"autoPlay":false},"tag":null,"id":0,"adIndex":-1},{"type":"banner2","data":{"dataType":"Banner","id":1263,"title":"","description":"","image":"http://img.kaiyanapp.com/feaf6237dbb62bba787e01d1cc1af131.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=&url=https%3A%2F%2Fwww.kaiyanapp.com%2Ftopic_article.html%3Fnid%3D78%26cookie%3D%26shareable%3Dtrue","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"rightText":null,"icon":null,"description":null},"autoPlay":false},"tag":null,"id":0,"adIndex":-1},{"type":"banner2","data":{"dataType":"Banner","id":1261,"title":"","description":"","image":"http://img.kaiyanapp.com/15bb02675ae5518f755d9d2827e8a4cb.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=&url=https%3A%2F%2Fwww.kaiyanapp.com%2Ftopic_article.html%3Fnid%3D77%26cookie%3D%26shareable%3Dtrue","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"rightText":null,"icon":null,"description":null},"autoPlay":false},"tag":null,"id":0,"adIndex":-1},{"type":"banner2","data":{"dataType":"Banner","id":1227,"title":"","description":"","image":"http://img.kaiyanapp.com/8389c40a39fce1c337700e8a9832e9ae.png?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=&url=http%3A%2F%2Fwww.kaiyanapp.com%2Fcampaign%2Fphotography_match%2Fphotography_match.html%3Fshareable%3Dtrue","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"rightText":null,"icon":null,"description":null},"autoPlay":false},"tag":null,"id":0,"adIndex":-1}]
     * count : 7
     */

    private String dataType;
    private int count;
    private List<ItemListBean> itemList;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBean {
        /**
         * type : banner2
         * data : {"dataType":"Banner","id":1281,"title":"","description":"","image":"http://img.kaiyanapp.com/59f66656031e54854230fcbf39daaf3c.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E5%BC%80%E7%9C%BC%E5%91%A8%E6%9C%AB%E8%AE%A1%E5%88%92&url=https%3A%2F%2Fwww.kaiyanapp.com%2Ftopic_article.html%3Fnid%3D86%26cookie%3D%26shareable%3Dtrue%26type%3DarticleTopic","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"rightText":null,"icon":null,"description":null},"autoPlay":false}
         * tag : null
         * id : 0
         * adIndex : -1
         */

        private String type;
        private Banner data;
        private Object tag;
        private int id;
        private int adIndex;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Banner getData() {
            return data;
        }

        public void setData(Banner data) {
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
    }
}
