package com.abner.wanandroid.module.video.bean;

import java.util.List;

/**
 * @author zhangduntai
 * @date 2019/3/7
 */
public class EyepetizerIndexTab {

    /**
     * tabInfo : {"tabList":[{"id":-1,"name":"发现","apiUrl":"http://baobab.kaiyanapp.com/api/v7/index/tab/discovery","tabType":0,"nameType":0,"adTrack":null},{"id":-2,"name":"推荐","apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=0","tabType":0,"nameType":0,"adTrack":null},{"id":-3,"name":"日报","apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/feed","tabType":0,"nameType":0,"adTrack":null}],"defaultIdx":-2}
     */

    private TabInfoBean tabInfo;

    public TabInfoBean getTabInfo() {
        return tabInfo;
    }

    public void setTabInfo(TabInfoBean tabInfo) {
        this.tabInfo = tabInfo;
    }

    public static class TabInfoBean {
        /**
         * tabList : [{"id":-1,"name":"发现","apiUrl":"http://baobab.kaiyanapp.com/api/v7/index/tab/discovery","tabType":0,"nameType":0,"adTrack":null},{"id":-2,"name":"推荐","apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=0","tabType":0,"nameType":0,"adTrack":null},{"id":-3,"name":"日报","apiUrl":"http://baobab.kaiyanapp.com/api/v5/index/tab/feed","tabType":0,"nameType":0,"adTrack":null}]
         * defaultIdx : -2
         */

        private int defaultIdx;
        private List<TabListBean> tabList;

        public int getDefaultIdx() {
            return defaultIdx;
        }

        public void setDefaultIdx(int defaultIdx) {
            this.defaultIdx = defaultIdx;
        }

        public List<TabListBean> getTabList() {
            return tabList;
        }

        public void setTabList(List<TabListBean> tabList) {
            this.tabList = tabList;
        }

        public static class TabListBean {
            /**
             * id : -1
             * name : 发现
             * apiUrl : http://baobab.kaiyanapp.com/api/v7/index/tab/discovery
             * tabType : 0
             * nameType : 0
             * adTrack : null
             */

            private int id;
            private String name;
            private String apiUrl;
            private int tabType;
            private int nameType;
            private Object adTrack;

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

            public String getApiUrl() {
                return apiUrl;
            }

            public void setApiUrl(String apiUrl) {
                this.apiUrl = apiUrl;
            }

            public int getTabType() {
                return tabType;
            }

            public void setTabType(int tabType) {
                this.tabType = tabType;
            }

            public int getNameType() {
                return nameType;
            }

            public void setNameType(int nameType) {
                this.nameType = nameType;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }
        }
    }
}
