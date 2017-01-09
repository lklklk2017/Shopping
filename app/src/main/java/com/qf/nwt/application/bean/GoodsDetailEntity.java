package com.qf.nwt.application.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

public class GoodsDetailEntity implements Serializable {

    /**
     * psj : 0
     * images : [{"url":"http://cdn.palshock.cn/ext/itm/0/1215_1_efd50c3b_g.jpg","wd":800,"ht":800},{"url":"http://cdn.palshock.cn/ext/itm_detail/0/1215_2_2b707fd4.jpg","wd":960,"ht":960},{"url":"http://cdn.palshock.cn/ext/itm_detail/0/1215_3_61b3c255.jpg","wd":960,"ht":960},{"url":"http://cdn.palshock.cn/ext/itm_detail/0/1215_4_5d3a6210.jpg","wd":960,"ht":960},{"url":"http://cdn.palshock.cn/ext/itm_detail/0/1215_5_df666d2e.jpg","wd":960,"ht":960},{"url":"http://cdn.palshock.cn/ext/itm_detail/0/1215_6_c7db21fe.jpg","wd":960,"ht":960}]
     * footers : [{"url":"http://cdn.palshock.cn/img/size_table/theroom/theroom_ring.zh.png","wd":750,"ht":2567}]
     * prices : [{"prc":1000,"amt":1000,"unit":"CNY"}]
     * like : 6
     * comment : 0
     * bUrl :
     * title : Robyn薰衣草紫戒指
     * desc : Cabochon synthetic white opal x 1, baguette lavender CZ x 2, white CZ x
     白色合成蛋白石，白色、薰衣草紫5A锆石
     K相当于港码11#,内周长52mm
     装饰15*9mm
     * from : THE ROOM
     * vendor : {"vendorId":"31","logo":"http://cdn.palshock.cn/img/vdimg/theroom.jpg","name":"THE ROOM","deliverPolicy":"免邮","deliverTime":"2-7个工作日到手","deliverWay":"官网直邮","sendFrom":"中国","returnPolicy":"质量问题可于7日内退换"}
     * onSale : 1
     * skuOk : 1
     * brand : {"id":"2266","brE":"V JEWELLERY","brC":"V JEWELLERY","available":1,"desc":"来自英国的设计师Laura和她的父亲Timothy Vann在2013年八月成立了V Jewellery。V Jewellery的设计师偏爱从大自然中汲取灵感创意，本季便选用了树叶和羽毛等元素，结合高档钻石材质打造出一件件优雅的艺术品","logo":"http://cdn.palshock.cn/img/brands/V_JEWELLERY.jpg"}
     * hasRule : 0
     * part : 0
     * extension :
     * hasLiked : 0
     * hasNews : 0
     * users : [{"userId":"98728","name":"VVVVVVera_徐","icon":{"url":"http://cdn.palshock.cn/dyimg/usr/32/98728_ba16ddfa.jpg","wd":180,"ht":180},"fanCount":1,"setCount":23,"hasFol":0},{"userId":"98271","name":"🌙钟于二硕 ૢྉྉྉ","icon":{"url":"http://cdn.palshock.cn/dyimg/usr/32/98271_eb251468.jpg","wd":0,"ht":0},"fanCount":107,"setCount":97,"hasFol":0},{"userId":"100383","name":"venusUcker","icon":{"url":"http://cdn.palshock.cn/dyimg/usr/33/100383_f734bc3e.jpg","wd":0,"ht":0},"fanCount":1,"setCount":18,"hasFol":0},{"userId":"97163","name":"Cover girl ","icon":{"url":"http://cdn.palshock.cn/dyimg/usr/32/97163_3cb5a9d4.jpg","wd":80,"ht":80},"fanCount":0,"setCount":8,"hasFol":0},{"userId":"90834","name":"Ynope","icon":{"url":"http://cdn.palshock.cn/dyimg/usr/30/90834_18d1d004.jpg","wd":180,"ht":180},"fanCount":1,"setCount":0,"hasFol":0},{"userId":"12626","name":"YNANCYN","icon":{"url":"http://cdn.palshock.cn/dyimg/usr/4/12626_9df49672.jpg","wd":180,"ht":180},"fanCount":333,"setCount":279,"hasFol":0}]
     * userCount : 0
     * userTotal : 0
     * userHasMore : 0
     * comments : []
     * commCount : 0
     * commTotal : 0
     * commHasMore : 0
     * belongs : []
     * belCount : 0
     * belTotal : 0
     * belHasMore : 0
     * similars : []
     * simCount : 0
     * simTotal : 0
     * simHasMore : 0
     * newsFlags : {"interact":0,"comment":0,"system":0,"order":0}
     */

    private int psj;
    private int like;
    private int comment;
    private String bUrl;
    private String title;
    private String desc;
    private String from;
    private VendorBean vendor;
    private int onSale;
    private int skuOk;
    private BrandBean brand;
    private int hasRule;
    private int part;
    private String extension;
    private int hasLiked;
    private int hasNews;
    private int userCount;
    private int userTotal;
    private int userHasMore;
    private int commCount;
    private int commTotal;
    private int commHasMore;
    private int belCount;
    private int belTotal;
    private int belHasMore;
    private int simCount;
    private int simTotal;
    private int simHasMore;
    private NewsFlagsBean newsFlags;
    private List<ImagesBean> images;
    private List<FootersBean> footers;
    private List<PricesBean> prices;
    private List<UsersBean> users;
    private List<?> comments;
    private List<?> belongs;
    private List<?> similars;

    public int getPsj() {
        return psj;
    }

    public void setPsj(int psj) {
        this.psj = psj;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public String getBUrl() {
        return bUrl;
    }

    public void setBUrl(String bUrl) {
        this.bUrl = bUrl;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public VendorBean getVendor() {
        return vendor;
    }

    public void setVendor(VendorBean vendor) {
        this.vendor = vendor;
    }

    public int getOnSale() {
        return onSale;
    }

    public void setOnSale(int onSale) {
        this.onSale = onSale;
    }

    public int getSkuOk() {
        return skuOk;
    }

    public void setSkuOk(int skuOk) {
        this.skuOk = skuOk;
    }

    public BrandBean getBrand() {
        return brand;
    }

    public void setBrand(BrandBean brand) {
        this.brand = brand;
    }

    public int getHasRule() {
        return hasRule;
    }

    public void setHasRule(int hasRule) {
        this.hasRule = hasRule;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getHasLiked() {
        return hasLiked;
    }

    public void setHasLiked(int hasLiked) {
        this.hasLiked = hasLiked;
    }

    public int getHasNews() {
        return hasNews;
    }

    public void setHasNews(int hasNews) {
        this.hasNews = hasNews;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getUserTotal() {
        return userTotal;
    }

    public void setUserTotal(int userTotal) {
        this.userTotal = userTotal;
    }

    public int getUserHasMore() {
        return userHasMore;
    }

    public void setUserHasMore(int userHasMore) {
        this.userHasMore = userHasMore;
    }

    public int getCommCount() {
        return commCount;
    }

    public void setCommCount(int commCount) {
        this.commCount = commCount;
    }

    public int getCommTotal() {
        return commTotal;
    }

    public void setCommTotal(int commTotal) {
        this.commTotal = commTotal;
    }

    public int getCommHasMore() {
        return commHasMore;
    }

    public void setCommHasMore(int commHasMore) {
        this.commHasMore = commHasMore;
    }

    public int getBelCount() {
        return belCount;
    }

    public void setBelCount(int belCount) {
        this.belCount = belCount;
    }

    public int getBelTotal() {
        return belTotal;
    }

    public void setBelTotal(int belTotal) {
        this.belTotal = belTotal;
    }

    public int getBelHasMore() {
        return belHasMore;
    }

    public void setBelHasMore(int belHasMore) {
        this.belHasMore = belHasMore;
    }

    public int getSimCount() {
        return simCount;
    }

    public void setSimCount(int simCount) {
        this.simCount = simCount;
    }

    public int getSimTotal() {
        return simTotal;
    }

    public void setSimTotal(int simTotal) {
        this.simTotal = simTotal;
    }

    public int getSimHasMore() {
        return simHasMore;
    }

    public void setSimHasMore(int simHasMore) {
        this.simHasMore = simHasMore;
    }

    public NewsFlagsBean getNewsFlags() {
        return newsFlags;
    }

    public void setNewsFlags(NewsFlagsBean newsFlags) {
        this.newsFlags = newsFlags;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public List<FootersBean> getFooters() {
        return footers;
    }

    public void setFooters(List<FootersBean> footers) {
        this.footers = footers;
    }

    public List<PricesBean> getPrices() {
        return prices;
    }

    public void setPrices(List<PricesBean> prices) {
        this.prices = prices;
    }

    public List<UsersBean> getUsers() {
        return users;
    }

    public void setUsers(List<UsersBean> users) {
        this.users = users;
    }

    public List<?> getComments() {
        return comments;
    }

    public void setComments(List<?> comments) {
        this.comments = comments;
    }

    public List<?> getBelongs() {
        return belongs;
    }

    public void setBelongs(List<?> belongs) {
        this.belongs = belongs;
    }

    public List<?> getSimilars() {
        return similars;
    }

    public void setSimilars(List<?> similars) {
        this.similars = similars;
    }

    public static class VendorBean {
        /**
         * vendorId : 31
         * logo : http://cdn.palshock.cn/img/vdimg/theroom.jpg
         * name : THE ROOM
         * deliverPolicy : 免邮
         * deliverTime : 2-7个工作日到手
         * deliverWay : 官网直邮
         * sendFrom : 中国
         * returnPolicy : 质量问题可于7日内退换
         */

        private String vendorId;
        private String logo;
        private String name;
        private String deliverPolicy;
        private String deliverTime;
        private String deliverWay;
        private String sendFrom;
        private String returnPolicy;

        public String getVendorId() {
            return vendorId;
        }

        public void setVendorId(String vendorId) {
            this.vendorId = vendorId;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDeliverPolicy() {
            return deliverPolicy;
        }

        public void setDeliverPolicy(String deliverPolicy) {
            this.deliverPolicy = deliverPolicy;
        }

        public String getDeliverTime() {
            return deliverTime;
        }

        public void setDeliverTime(String deliverTime) {
            this.deliverTime = deliverTime;
        }

        public String getDeliverWay() {
            return deliverWay;
        }

        public void setDeliverWay(String deliverWay) {
            this.deliverWay = deliverWay;
        }

        public String getSendFrom() {
            return sendFrom;
        }

        public void setSendFrom(String sendFrom) {
            this.sendFrom = sendFrom;
        }

        public String getReturnPolicy() {
            return returnPolicy;
        }

        public void setReturnPolicy(String returnPolicy) {
            this.returnPolicy = returnPolicy;
        }
    }

    public static class BrandBean {
        /**
         * id : 2266
         * brE : V JEWELLERY
         * brC : V JEWELLERY
         * available : 1
         * desc : 来自英国的设计师Laura和她的父亲Timothy Vann在2013年八月成立了V Jewellery。V Jewellery的设计师偏爱从大自然中汲取灵感创意，本季便选用了树叶和羽毛等元素，结合高档钻石材质打造出一件件优雅的艺术品
         * logo : http://cdn.palshock.cn/img/brands/V_JEWELLERY.jpg
         */

        private String id;
        private String brE;
        private String brC;
        private int available;
        private String desc;
        private String logo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBrE() {
            return brE;
        }

        public void setBrE(String brE) {
            this.brE = brE;
        }

        public String getBrC() {
            return brC;
        }

        public void setBrC(String brC) {
            this.brC = brC;
        }

        public int getAvailable() {
            return available;
        }

        public void setAvailable(int available) {
            this.available = available;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }
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

    public static class ImagesBean {
        /**
         * url : http://cdn.palshock.cn/ext/itm/0/1215_1_efd50c3b_g.jpg
         * wd : 800
         * ht : 800
         */

        private String url;
        private int wd;
        private int ht;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWd() {
            return wd;
        }

        public void setWd(int wd) {
            this.wd = wd;
        }

        public int getHt() {
            return ht;
        }

        public void setHt(int ht) {
            this.ht = ht;
        }
    }

    public static class FootersBean {
        /**
         * url : http://cdn.palshock.cn/img/size_table/theroom/theroom_ring.zh.png
         * wd : 750
         * ht : 2567
         */

        private String url;
        private int wd;
        private int ht;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWd() {
            return wd;
        }

        public void setWd(int wd) {
            this.wd = wd;
        }

        public int getHt() {
            return ht;
        }

        public void setHt(int ht) {
            this.ht = ht;
        }
    }

    public static class PricesBean {
        /**
         * prc : 1000
         * amt : 1000
         * unit : CNY
         */

        private int prc;
        private int amt;
        private String unit;

        public int getPrc() {
            return prc;
        }

        public void setPrc(int prc) {
            this.prc = prc;
        }

        public int getAmt() {
            return amt;
        }

        public void setAmt(int amt) {
            this.amt = amt;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }

    public static class UsersBean {
        /**
         * userId : 98728
         * name : VVVVVVera_徐
         * icon : {"url":"http://cdn.palshock.cn/dyimg/usr/32/98728_ba16ddfa.jpg","wd":180,"ht":180}
         * fanCount : 1
         * setCount : 23
         * hasFol : 0
         */

        private String userId;
        private String name;
        private IconBean icon;
        private int fanCount;
        private int setCount;
        private int hasFol;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public IconBean getIcon() {
            return icon;
        }

        public void setIcon(IconBean icon) {
            this.icon = icon;
        }

        public int getFanCount() {
            return fanCount;
        }

        public void setFanCount(int fanCount) {
            this.fanCount = fanCount;
        }

        public int getSetCount() {
            return setCount;
        }

        public void setSetCount(int setCount) {
            this.setCount = setCount;
        }

        public int getHasFol() {
            return hasFol;
        }

        public void setHasFol(int hasFol) {
            this.hasFol = hasFol;
        }

        public static class IconBean {
            /**
             * url : http://cdn.palshock.cn/dyimg/usr/32/98728_ba16ddfa.jpg
             * wd : 180
             * ht : 180
             */

            private String url;
            private int wd;
            private int ht;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWd() {
                return wd;
            }

            public void setWd(int wd) {
                this.wd = wd;
            }

            public int getHt() {
                return ht;
            }

            public void setHt(int ht) {
                this.ht = ht;
            }
        }
    }
}
