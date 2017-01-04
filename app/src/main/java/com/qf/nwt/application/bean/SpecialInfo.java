package com.qf.nwt.application.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class SpecialInfo {

    /**
     * psj : 0
     * topics : [{"topicId":"1892","title":"冬日必备单品","desc":"有它们保驾护航，你只有美的份儿了！","img":"http://cdn.palshock.cn/dyimg/topic/import/1/1892_0_e10420a4f579.jpg"},{"topicId":"1863","title":"《校对女孩》石原里美","desc":"157的她为何是\u201c最想成为的女孩\u201d？","img":"http://cdn.palshock.cn/dyimg/topic/import/1/1863_0_4abdddce90dd.jpg"},{"topicId":"1884","title":"冬日里不可少的一抹pink","desc":"就是要美美的\u201c粉\u201d上一回~","img":"http://cdn.palshock.cn/dyimg/topic/import/1/1884_0_8c629c3ac825.jpg"},{"topicId":"1883","title":"川普王座的\u201c幕后推手\u201d","desc":"凭什么希拉里也对她赞赏有加？","img":"http://cdn.palshock.cn/dyimg/topic/import/1/1883_0_33f47dcbe968.jpg"},{"topicId":"1877","title":"All Black是一种态度","desc":"要酷，就酷到没朋友","img":"http://cdn.palshock.cn/dyimg/topic/import/1/1877_0_51473abac1dd.jpg"},{"topicId":"1878","title":"下半身大救赎！","desc":"小粗腿say goodbye","img":"http://cdn.palshock.cn/dyimg/topic/import/1/1878_0_5da22dd6683c.jpg"},{"topicId":"1875","title":"冷不怕又时髦的最佳CP：\n阔腿裤+长外套","desc":"妈妈再也不用担心我冻坏腿了","img":"http://cdn.palshock.cn/dyimg/topic/import/1/1875_0_d7d373a7b4f7.jpg"},{"topicId":"1876","title":"冬季格纹跟夏季不一样的味道","desc":"秋冬最佳点缀","img":"http://cdn.palshock.cn/dyimg/topic/import/1/1876_0_ce3d724b083c.jpg"},{"topicId":"1873","title":"秋冬鞋履宣言，时髦精人手一双！","desc":"当下最in的thigh boots，你得知道怎么穿~","img":"http://cdn.palshock.cn/dyimg/topic/import/1/1873_0_4ebc57cd006d.jpg"},{"topicId":"1874","title":"帅出新高度\u2014\u2014不能没有的派克大衣","desc":"从户外混进时尚圈的心机单品","img":"http://cdn.palshock.cn/dyimg/topic/import/1/1874_0_2d929c0839f3.jpg"},{"topicId":"1872","title":"醉了枫叶\u2014\u2014秋冬里的一抹酒红","desc":"女人味十足的酒红色你会穿吗","img":"http://cdn.palshock.cn/dyimg/topic/import/1/1872_0_2852a9f2ad7b.jpg"},{"topicId":"1869","title":"一衣多穿之秋冬喇叭裤","desc":"天气冷了喇叭裤该怎么搭？","img":"http://cdn.palshock.cn/dyimg/topic/import/1/1869_0_0265f47f144b.jpg"}]
     * topicCount : 12
     * page : 1
     * newsFlags : {"interact":0,"comment":0,"system":0,"order":0}
     * hasNews : 0
     * hasLevelUp : 0
     */

    private int psj;
    private int topicCount;
    private int page;
    private NewsFlagsBean newsFlags;
    private int hasNews;
    private int hasLevelUp;
    private List<TopicsBean> topics;

    public int getPsj() {
        return psj;
    }

    public void setPsj(int psj) {
        this.psj = psj;
    }

    public int getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(int topicCount) {
        this.topicCount = topicCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public NewsFlagsBean getNewsFlags() {
        return newsFlags;
    }

    public void setNewsFlags(NewsFlagsBean newsFlags) {
        this.newsFlags = newsFlags;
    }

    public int getHasNews() {
        return hasNews;
    }

    public void setHasNews(int hasNews) {
        this.hasNews = hasNews;
    }

    public int getHasLevelUp() {
        return hasLevelUp;
    }

    public void setHasLevelUp(int hasLevelUp) {
        this.hasLevelUp = hasLevelUp;
    }

    public List<TopicsBean> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicsBean> topics) {
        this.topics = topics;
    }

    public static class NewsFlagsBean {
        /**
         * interact : 0
         * comment : 0
         * system : 0
         * order : 0
         */

        private int interact;
        private int comment;
        private int system;
        private int order;

        public int getInteract() {
            return interact;
        }

        public void setInteract(int interact) {
            this.interact = interact;
        }

        public int getComment() {
            return comment;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public int getSystem() {
            return system;
        }

        public void setSystem(int system) {
            this.system = system;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }
    }

    public static class TopicsBean {
        /**
         * topicId : 1892
         * title : 冬日必备单品
         * desc : 有它们保驾护航，你只有美的份儿了！
         * img : http://cdn.palshock.cn/dyimg/topic/import/1/1892_0_e10420a4f579.jpg
         */

        private String topicId;
        private String title;
        private String desc;
        private String img;

        public String getTopicId() {
            return topicId;
        }

        public void setTopicId(String topicId) {
            this.topicId = topicId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
