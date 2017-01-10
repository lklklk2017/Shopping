package com.qf.nwt.application.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/5.
 */

public class DiscountInfo {


    /**
     * psj : 0
     * topics : [{"topicId":"2516","title":"珠宝 最潮最in精选4折 \u2014\u2014 都市时尚黑白 逆天优惠！","desc":"01/05 2017 ","img":"http://cdn.palshock.cn/img/itm/147/485716_1_GzNIlPrL_s.jpg"},{"topicId":"2515","title":"鞋 精选商品6折够不够？ \u2014\u2014 都市时尚黑白 绝对值得买！","desc":"01/05 2017 ","img":"http://cdn.palshock.cn/img/itm/133/441067_1_1r1rt9B9_s.jpg"},{"topicId":"2514","title":" 秒杀网红必备单品！ \u2014\u2014 ONLY上衣 不得不抢的1折好货！","desc":"01/05 2017 ","img":"http://cdn.palshock.cn/img/itm/145/481348_1_PNvcT42A_s.jpg"},{"topicId":"2513","title":" 1折起！ \u2014\u2014 上衣 扫货攻略！","desc":"01/05 2017 ","img":"http://cdn.palshock.cn/img/itm/101/334237_1_5YdqIEfW_s.jpg"},{"topicId":"2512","title":" 玩转搭配！ \u2014\u2014 BRIGITTE沙滩装 5折精选！","desc":"01/05 2017 ","img":"http://cdn.palshock.cn/img/itm/147/485638_1_LdqPaZ8Q_s.jpg"},{"topicId":"2511","title":"上衣 精选商品3折够不够？ \u2014\u2014 浪漫的青靛 独家省钱快报！","desc":"01/05 2017 ","img":"http://cdn.palshock.cn/img/itm/140/463081_1_jn81l8C0_s.jpg"},{"topicId":"2510","title":" 不得不抢的1折好货！ \u2014\u2014 连衣裙 会搭配的姑娘最会省！","desc":"01/04 2017 ","img":"http://cdn.palshock.cn/img/itm/121/400808_1_X76119iY_s.jpg"},{"topicId":"2509","title":" 买得到的好货！ \u2014\u2014 ONLY上衣 1折精选！","desc":"01/04 2017 ","img":"http://cdn.palshock.cn/img/itm/91/303104_1_rYrMU4UO_s.jpg"},{"topicId":"2508","title":" 不得不抢的1折好货！ \u2014\u2014 上衣 忙碌一周是否该送自己个礼物？","desc":"01/04 2017 ","img":"http://cdn.palshock.cn/img/itm/133/439434_1_CTYRj7Ni_s.jpg"},{"topicId":"2507","title":" 最新优惠！ \u2014\u2014 H&M裤子 只要5折！","desc":"01/04 2017 ","img":"http://cdn.palshock.cn/img/itm/129/426816_1_tFtsplHK_s.jpg"},{"topicId":"2506","title":" 逆天优惠！ \u2014\u2014 GIUSEPPE ZANOTTI鞋 1折好货！","desc":"01/04 2017 ","img":"http://cdn.palshock.cn/img/itm/140/463966_1_NiOcIjoy_s.jpg"},{"topicId":"2505","title":"外套 仅需1折！ \u2014\u2014 极具女人味的黑白 不买也要来看看！","desc":"01/04 2017 ","img":"http://cdn.palshock.cn/img/itm/134/445098_1_I4syjAGB_s.jpg"}]
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
         * topicId : 2516
         * title : 珠宝 最潮最in精选4折 —— 都市时尚黑白 逆天优惠！
         * desc : 01/05 2017
         * img : http://cdn.palshock.cn/img/itm/147/485716_1_GzNIlPrL_s.jpg
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
