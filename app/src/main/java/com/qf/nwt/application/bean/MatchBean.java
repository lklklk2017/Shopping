package com.qf.nwt.application.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fyl on 2016/12/27.
 */

public class MatchBean implements Serializable{
    /**
     * hasLevelUp : 0
     * hasNews : 0
     * psj : 0
     * newsFlags : {"interact":0,"comment":0,"order":0,"system":0}
     * colls : [{"desc":"长袖配短裤的造型总是能带给人活力感觉，卡其色更让你显得帅气不羁，搭配白色运动鞋让显眼度倍增避免一身土色！","ruleId":"1320","items":[{"prc":80,"unit":"CNY","pCName":"下身","url":"http://cdn.palshock.cn/img/itm/154/508457_1_NGTSDtZK_s.jpg","pCID":3,"itemId":"508457"},{"prc":899,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/180/595885_1_vorIgRDw_s.jpg","pCID":2,"itemId":"595885"},{"prc":1420,"unit":"CNY","pCName":"头部","url":"http://cdn.palshock.cn/img/itm/120/399026_1_qMH6iEk8_s.jpg","pCID":1,"itemId":"399026"},{"prc":1763,"unit":"CNY","pCName":"包包","url":"http://cdn.palshock.cn/img/itm/182/603490_1_1YSQ7WQy_s.jpg","pCID":4,"itemId":"603490"},{"prc":882,"unit":"CNY","pCName":"鞋子","url":"http://cdn.palshock.cn/img/itm/152/503969_1_dDlvZJA7_s.jpg","pCID":5,"itemId":"503969"},{"prc":55,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/153/507607_1_wWkNeb1d_s.jpg","pCID":2,"itemId":"507607"}]},{"desc":"俏丽的桃红色大衣在冬天里明亮异常，灰色毛衣和牛仔裤带来经典的都市休闲风格，在亲友聚会派对上让人眼前一亮！","ruleId":"899","items":[{"prc":239,"unit":"CNY","pCName":"下身","url":"http://cdn.palshock.cn/img/itm/153/507456_1_6edtO62F_s.jpg","pCID":3,"itemId":"507456"},{"prc":200,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/154/508921_1_2cGlNnqG_s.jpg","pCID":2,"itemId":"508921"},{"prc":759,"unit":"CNY","pCName":"头部","url":"http://cdn.palshock.cn/img/itm/130/430067_1_Me2SwltS_s.jpg","pCID":1,"itemId":"430067"},{"prc":2579,"unit":"CNY","pCName":"包包","url":"http://cdn.palshock.cn/img/itm/192/634351_1_mqTIOOEX_s.jpg","pCID":4,"itemId":"634351"},{"prc":2763,"unit":"CNY","pCName":"鞋子","url":"http://cdn.palshock.cn/img/itm/151/498451_1_JS9cfQig_s.jpg","pCID":5,"itemId":"498451"},{"prc":132,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/121/401539_1_owbNYVzV_s.jpg","pCID":2,"itemId":"401539"}]},{"desc":"宽松的裤装行动方便，舒适自如，在盛夏时节既舒爽也不用担心太阳直射，白色配饰的清新自感让整个人气质闲淡自然！","ruleId":"929","items":[{"prc":300,"unit":"CNY","pCName":"头部","url":"http://cdn.palshock.cn/img/itm/133/440402_1_mF3DqSzZ_s.jpg","pCID":1,"itemId":"440402"},{"prc":503,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/145/480931_1_xoeLrEUJ_s.jpg","pCID":2,"itemId":"480931"},{"prc":399,"unit":"CNY","pCName":"下身","url":"http://cdn.palshock.cn/img/itm/153/507385_1_0UrCraOj_s.jpg","pCID":3,"itemId":"507385"},{"prc":296,"unit":"CNY","pCName":"包包","url":"http://cdn.palshock.cn/img/itm/155/512404_1_kIKlXwF1_s.jpg","pCID":4,"itemId":"512404"},{"prc":397,"unit":"CNY","pCName":"鞋子","url":"http://cdn.palshock.cn/img/itm/121/401036_1_3vU71LS8_s.jpg","pCID":5,"itemId":"401036"},{"prc":60,"unit":"CNY","pCName":"附件","url":"http://cdn.palshock.cn/img/itm/146/482314_1_IGZnUVa0_s.jpg","pCID":6,"itemId":"482314"}]},{"desc":"饱和度极高的红色毛衣轻快明亮且休闲，搭配同样休闲风的牛仔裤和短靴，让人感觉活力十足，也可以内搭长背心或是衬衫，露出不同色彩的领子和下摆，更富有层次感。","ruleId":"762","items":[{"prc":899,"unit":"CNY","pCName":"头部","url":"http://cdn.palshock.cn/img/itm/193/638132_1_phgJvHjp_s.jpg","pCID":1,"itemId":"638132"},{"prc":88,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/91/303118_1_O8I6D0LD_s.jpg","pCID":2,"itemId":"303118"},{"prc":106,"unit":"CNY","pCName":"下身","url":"http://cdn.palshock.cn/img/itm/101/333769_1_UTk7781o_s.jpg","pCID":3,"itemId":"333769"},{"prc":3484,"unit":"CNY","pCName":"包包","url":"http://cdn.palshock.cn/img/itm/145/480070_1_ZmIxRNAo_s.jpg","pCID":4,"itemId":"480070"},{"prc":653,"unit":"CNY","pCName":"鞋子","url":"http://cdn.palshock.cn/img/itm/152/504431_1_1yajEahR_s.jpg","pCID":5,"itemId":"504431"},{"prc":680,"unit":"CNY","pCName":"附件","url":"http://cdn.palshock.cn/img/itm/120/397005_1_cJlSmQkA_s.jpg","pCID":6,"itemId":"397005"}]},{"desc":"清爽色彩的搭配，令人倍感舒爽！","ruleId":"1428","items":[{"prc":644,"unit":"CNY","pCName":"附件","url":"http://cdn.palshock.cn/ext/itm/0/996_1_a210b280_s.jpg","pCID":6,"itemId":"505203"},{"prc":1854,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/152/501796_1_5AitylAp_s.jpg","pCID":2,"itemId":"501796"},{"prc":79,"unit":"CNY","pCName":"头部","url":"http://cdn.palshock.cn/img/itm/145/478893_1_BA6frZsv_s.jpg","pCID":1,"itemId":"478893"},{"prc":2018,"unit":"CNY","pCName":"包包","url":"http://cdn.palshock.cn/img/itm/182/603778_1_6l1fdzPh_s.jpg","pCID":4,"itemId":"603778"},{"prc":88,"unit":"CNY","pCName":"鞋子","url":"http://cdn.palshock.cn/img/itm/91/303262_1_vddS1nc1_s.jpg","pCID":5,"itemId":"303262"},{"prc":10687,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/151/501245_1_NDacP9B2_s.jpg","pCID":2,"itemId":"501245"}]},{"desc":"安静的一身黑色带来宁静氛围，搭配并不明亮但饱和度却很高的橙色大衣，打破沉闷，却依旧沉稳知性，并且舒适不拘束。","ruleId":"810","items":[{"prc":199,"unit":"CNY","pCName":"下身","url":"http://cdn.palshock.cn/img/itm/153/507433_1_GOvEGkXR_s.jpg","pCID":3,"itemId":"507433"},{"prc":999,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/180/595892_1_Vv09kEsr_s.jpg","pCID":2,"itemId":"595892"},{"prc":1103,"unit":"CNY","pCName":"头部","url":"http://cdn.palshock.cn/img/itm/130/430382_1_NHU3WgkJ_s.jpg","pCID":1,"itemId":"430382"},{"prc":2731,"unit":"CNY","pCName":"包包","url":"http://cdn.palshock.cn/img/itm/151/501487_1_BR0tWSmY_s.jpg","pCID":4,"itemId":"501487"},{"prc":299,"unit":"CNY","pCName":"鞋子","url":"http://cdn.palshock.cn/img/itm/190/629822_1_4KxaTid2_s.jpg","pCID":5,"itemId":"629822"},{"prc":123,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/91/303039_1_bTyAFIVE_s.jpg","pCID":2,"itemId":"303039"}]},{"desc":"黑白配色帅气又带点叛逆，衬衫带来的整齐和禁锢感搭配俏皮短裙和帅气的短靴，利落洒脱的样子适合高挑女生！","ruleId":"931","items":[{"prc":759,"unit":"CNY","pCName":"头部","url":"http://cdn.palshock.cn/img/itm/130/430066_1_kxaVtdj3_s.jpg","pCID":1,"itemId":"430066"},{"prc":99,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/122/402605_1_gLM4E5Vp_s.jpg","pCID":2,"itemId":"402605"},{"prc":794,"unit":"CNY","pCName":"下身","url":"http://cdn.palshock.cn/img/itm/145/480611_1_bW7QmrIl_s.jpg","pCID":3,"itemId":"480611"},{"prc":4637,"unit":"CNY","pCName":"包包","url":"http://cdn.palshock.cn/img/itm/150/496694_1_TwT8mLrN_s.jpg","pCID":4,"itemId":"496694"},{"prc":864,"unit":"CNY","pCName":"鞋子","url":"http://cdn.palshock.cn/img/itm/152/504341_1_JQeXwlX0_s.jpg","pCID":5,"itemId":"504341"},{"prc":149,"unit":"CNY","pCName":"附件","url":"http://cdn.palshock.cn/img/itm/120/398559_1_4dMAfnkW_s.jpg","pCID":6,"itemId":"398559"}]},{"desc":"浓郁的深红色上衣既不会泯然冬季黑色的人潮也不会太过于跳脱，同时搭配今年十分流行又十分有气质的酒红色短靴，整个形象的时尚度都提升了一个层次。","ruleId":"626","items":[{"prc":1329,"unit":"CNY","pCName":"头部","url":"http://cdn.palshock.cn/img/itm/141/467328_1_C6JH28bD_s.jpg","pCID":1,"itemId":"467328"},{"prc":299,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/122/402800_1_7zg2BP2u_s.jpg","pCID":2,"itemId":"402800"},{"prc":259,"unit":"CNY","pCName":"下身","url":"http://cdn.palshock.cn/img/itm/190/629282_1_iMnzIgNJ_s.jpg","pCID":3,"itemId":"629282"},{"prc":3300,"unit":"CNY","pCName":"包包","url":"http://cdn.palshock.cn/img/itm/141/466162_1_npIVSEbC_s.jpg","pCID":4,"itemId":"466162"},{"prc":799,"unit":"CNY","pCName":"鞋子","url":"http://cdn.palshock.cn/img/itm/153/507645_1_zOgmy9GR_s.jpg","pCID":5,"itemId":"507645"},{"prc":680,"unit":"CNY","pCName":"附件","url":"http://cdn.palshock.cn/img/itm/120/396988_1_xLWrW5IQ_s.jpg","pCID":6,"itemId":"396988"}]},{"desc":"浅色背心和短裤给人干净的感觉，搭配黑色水桶包和凉鞋让增添分量感和造型感，避免家居服的感觉！","ruleId":"1157","items":[{"prc":598,"unit":"CNY","pCName":"头部","url":"http://cdn.palshock.cn/ext/itm/0/473_1_b21c0c36_s.jpg","pCID":1,"itemId":"441711"},{"prc":239,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/180/596033_1_TkwiF5iJ_s.jpg","pCID":2,"itemId":"596033"},{"prc":99,"unit":"CNY","pCName":"下身","url":"http://cdn.palshock.cn/img/itm/122/403670_1_A2R6t62C_s.jpg","pCID":3,"itemId":"403670"},{"prc":299,"unit":"CNY","pCName":"包包","url":"http://cdn.palshock.cn/img/itm/120/398495_1_aUT51zmG_s.jpg","pCID":4,"itemId":"398495"},{"prc":1480,"unit":"CNY","pCName":"鞋子","url":"http://cdn.palshock.cn/img/itm/150/495195_1_XsLDqzGB_s.jpg","pCID":5,"itemId":"495195"},{"prc":80,"unit":"CNY","pCName":"附件","url":"http://cdn.palshock.cn/img/itm/129/427182_1_VZWANWlP_s.jpg","pCID":6,"itemId":"427182"}]},{"desc":"天气渐凉，参加聚会既要舒服漂亮，也要兼备一定保暖性，针织衫可是个必不可少的单品呢！配上牛仔裤舒舒服服的出门吧！","ruleId":"480","items":[{"prc":1390,"unit":"CNY","pCName":"头部","url":"http://cdn.palshock.cn/img/itm/189/624531_1_EBF4oClV_s.jpg","pCID":1,"itemId":"624531"},{"prc":212,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/101/334061_1_dyT3kvSC_s.jpg","pCID":2,"itemId":"334061"},{"prc":299,"unit":"CNY","pCName":"下身","url":"http://cdn.palshock.cn/img/itm/162/536615_1_xbWnkyya_s.jpg","pCID":3,"itemId":"536615"},{"prc":2114,"unit":"CNY","pCName":"包包","url":"http://cdn.palshock.cn/img/itm/63/210895_1_qUlVIyiw_s.jpg","pCID":4,"itemId":"210895"},{"prc":772,"unit":"CNY","pCName":"鞋子","url":"http://cdn.palshock.cn/img/itm/155/512435_1_GR3G6gGk_s.jpg","pCID":5,"itemId":"512435"},{"prc":20,"unit":"CNY","pCName":"附件","url":"http://cdn.palshock.cn/img/itm/129/427287_1_06oLcdY0_s.jpg","pCID":6,"itemId":"427287"}]},{"desc":"牛仔外套才是真的可以穿10年都有范儿的经典ITEM!利用靛蓝色毛衫和橙色半身裙的鲜艳撞色，让牛仔造型也更有活力！","ruleId":"1327","items":[{"prc":209,"unit":"CNY","pCName":"下身","url":"http://cdn.palshock.cn/img/itm/190/629649_1_VFCMHvKv_s.jpg","pCID":3,"itemId":"629649"},{"prc":1926,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/119/395672_1_YQMNmZzS_s.jpg","pCID":2,"itemId":"395672"},{"prc":70,"unit":"CNY","pCName":"头部","url":"http://cdn.palshock.cn/img/itm/154/508646_1_TO6M1APg_s.jpg","pCID":1,"itemId":"508646"},{"prc":2264,"unit":"CNY","pCName":"包包","url":"http://cdn.palshock.cn/img/itm/118/390297_1_m83mnuPv_s.jpg","pCID":4,"itemId":"390297"},{"prc":3480,"unit":"CNY","pCName":"鞋子","url":"http://cdn.palshock.cn/img/itm/192/635554_1_7mbcAJyn_s.jpg","pCID":5,"itemId":"635554"},{"prc":97,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/91/303175_1_PLb1KN06_s.jpg","pCID":2,"itemId":"303175"}]},{"desc":"用运动风卫衣搭配知性感觉的深色大衣，很有街头感的混搭风格，搭配简单的黑色单鞋，既满足舒适感也不会让你看起来太出位。","ruleId":"1394","items":[{"prc":139,"unit":"CNY","pCName":"下身","url":"http://cdn.palshock.cn/img/itm/122/402849_1_Y2cOGNLN_s.jpg","pCID":3,"itemId":"402849"},{"prc":953,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/121/401344_1_EEC2IzyU_s.jpg","pCID":2,"itemId":"401344"},{"prc":485,"unit":"CNY","pCName":"头部","url":"http://cdn.palshock.cn/img/itm/121/400287_1_0UiNQN9H_s.jpg","pCID":1,"itemId":"400287"},{"prc":259,"unit":"CNY","pCName":"包包","url":"http://cdn.palshock.cn/img/itm/190/630040_1_XEmVnttl_s.jpg","pCID":4,"itemId":"630040"},{"prc":1076,"unit":"CNY","pCName":"鞋子","url":"http://cdn.palshock.cn/img/itm/152/502023_1_lrMC2qke_s.jpg","pCID":5,"itemId":"502023"},{"prc":732,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/121/399738_1_NlIqTnwD_s.jpg","pCID":2,"itemId":"399738"}]}]
     */

    private int hasLevelUp;
    private int hasNews;
    private int psj;


    private NewsFlagsBean newsFlags;
    private List<CollsBean> colls;


    public int getHasLevelUp() {
        return hasLevelUp;
    }

    public void setHasLevelUp(int hasLevelUp) {
        this.hasLevelUp = hasLevelUp;
    }

    public int getHasNews() {
        return hasNews;
    }

    public void setHasNews(int hasNews) {
        this.hasNews = hasNews;
    }

    public int getPsj() {
        return psj;
    }

    public void setPsj(int psj) {
        this.psj = psj;
    }

    public NewsFlagsBean getNewsFlags() {
        return newsFlags;
    }

    public void setNewsFlags(NewsFlagsBean newsFlags) {
        this.newsFlags = newsFlags;
    }

    public List<CollsBean> getColls() {
        return colls;
    }

    public void setColls(List<CollsBean> colls) {
        this.colls = colls;
    }

    public static class NewsFlagsBean implements Serializable{
        /**
         * interact : 0
         * comment : 0
         * order : 0
         * system : 0
         */

        private int interact;
        private int comment;
        private int order;
        private int system;

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

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getSystem() {
            return system;
        }

        public void setSystem(int system) {
            this.system = system;
        }
    }

    public static class CollsBean implements Serializable{
        /**
         * desc : 长袖配短裤的造型总是能带给人活力感觉，卡其色更让你显得帅气不羁，搭配白色运动鞋让显眼度倍增避免一身土色！
         * ruleId : 1320
         * items : [{"prc":80,"unit":"CNY","pCName":"下身","url":"http://cdn.palshock.cn/img/itm/154/508457_1_NGTSDtZK_s.jpg","pCID":3,"itemId":"508457"},{"prc":899,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/180/595885_1_vorIgRDw_s.jpg","pCID":2,"itemId":"595885"},{"prc":1420,"unit":"CNY","pCName":"头部","url":"http://cdn.palshock.cn/img/itm/120/399026_1_qMH6iEk8_s.jpg","pCID":1,"itemId":"399026"},{"prc":1763,"unit":"CNY","pCName":"包包","url":"http://cdn.palshock.cn/img/itm/182/603490_1_1YSQ7WQy_s.jpg","pCID":4,"itemId":"603490"},{"prc":882,"unit":"CNY","pCName":"鞋子","url":"http://cdn.palshock.cn/img/itm/152/503969_1_dDlvZJA7_s.jpg","pCID":5,"itemId":"503969"},{"prc":55,"unit":"CNY","pCName":"上身","url":"http://cdn.palshock.cn/img/itm/153/507607_1_wWkNeb1d_s.jpg","pCID":2,"itemId":"507607"}]
         */

        private String desc;
        private String ruleId;
        private List<ItemsBean> items;

        private int type;//自己添加来区分布局的

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getRuleId() {
            return ruleId;
        }

        public void setRuleId(String ruleId) {
            this.ruleId = ruleId;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean implements Serializable{
            /**
             * prc : 80
             * unit : CNY
             * pCName : 下身
             * url : http://cdn.palshock.cn/img/itm/154/508457_1_NGTSDtZK_s.jpg
             * pCID : 3
             * itemId : 508457
             */

            private int prc;
            private String unit;
            private String pCName;
            private String url;
            private int pCID;
            private String itemId;

            public int getPrc() {
                return prc;
            }

            public void setPrc(int prc) {
                this.prc = prc;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getPCName() {
                return pCName;
            }

            public void setPCName(String pCName) {
                this.pCName = pCName;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getPCID() {
                return pCID;
            }

            public void setPCID(int pCID) {
                this.pCID = pCID;
            }

            public String getItemId() {
                return itemId;
            }

            public void setItemId(String itemId) {
                this.itemId = itemId;
            }
        }
    }
}
