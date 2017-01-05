package com.qf.nwt.application.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/12/29 0029.
 */

public class ShopCarDetailEntity implements Serializable {

    /**
     * psj : 0
     * carts : [{"vendorId":31,"vendorName":"THE ROOM","logo":"http://cdn.palshock.cn/img/vdimg/theroom.jpg","skus":[{"cartId":24964,"itemId":638539,"title":"Cecile戒指","brandId":2266,"url":"http://cdn.palshock.cn/ext/itm/0/1205_1_c4839275_s.jpg","sprice":950,"currency":"CNY","quantity":9,"totalPrice":8550,"soldoutQuantity":0,"status":1,"color":{"name":"颜色","id":"CL_638539_0001","text":"银色"},"size":{"name":"尺码","id":"SI_638539_0001","text":"N"},"style":{}},{"cartId":24978,"itemId":638540,"title":"Elka耳夹","brandId":2266,"url":"http://cdn.palshock.cn/ext/itm/0/1206_1_12dfc0c7_s.jpg","sprice":800,"currency":"CNY","quantity":1,"totalPrice":800,"soldoutQuantity":0,"status":1,"color":{"name":"颜色","id":"CL_638540_0001","text":"银色"},"size":{"name":"尺码","id":"SI_638540_0001","text":"均码"},"style":{}},{"cartId":24953,"itemId":638542,"title":"Lochrie项链","brandId":2266,"url":"http://cdn.palshock.cn/ext/itm/0/1208_1_9592efd2_s.jpg","sprice":850,"currency":"CNY","quantity":1,"totalPrice":850,"soldoutQuantity":0,"status":1,"color":{"name":"颜色","id":"CL_638542_0001","text":"银色"},"size":{"name":"尺码","id":"SI_638542_0001","text":"均码"},"style":{}}]}]
     */

    private int psj;
    private List<CartsBean> carts;

    public int getPsj() {
        return psj;
    }

    public void setPsj(int psj) {
        this.psj = psj;
    }

    public List<CartsBean> getCarts() {
        return carts;
    }

    public void setCarts(List<CartsBean> carts) {
        this.carts = carts;
    }

    public static class CartsBean {
        /**
         * vendorId : 31
         * vendorName : THE ROOM
         * logo : http://cdn.palshock.cn/img/vdimg/theroom.jpg
         * skus : [{"cartId":24964,"itemId":638539,"title":"Cecile戒指","brandId":2266,"url":"http://cdn.palshock.cn/ext/itm/0/1205_1_c4839275_s.jpg","sprice":950,"currency":"CNY","quantity":9,"totalPrice":8550,"soldoutQuantity":0,"status":1,"color":{"name":"颜色","id":"CL_638539_0001","text":"银色"},"size":{"name":"尺码","id":"SI_638539_0001","text":"N"},"style":{}},{"cartId":24978,"itemId":638540,"title":"Elka耳夹","brandId":2266,"url":"http://cdn.palshock.cn/ext/itm/0/1206_1_12dfc0c7_s.jpg","sprice":800,"currency":"CNY","quantity":1,"totalPrice":800,"soldoutQuantity":0,"status":1,"color":{"name":"颜色","id":"CL_638540_0001","text":"银色"},"size":{"name":"尺码","id":"SI_638540_0001","text":"均码"},"style":{}},{"cartId":24953,"itemId":638542,"title":"Lochrie项链","brandId":2266,"url":"http://cdn.palshock.cn/ext/itm/0/1208_1_9592efd2_s.jpg","sprice":850,"currency":"CNY","quantity":1,"totalPrice":850,"soldoutQuantity":0,"status":1,"color":{"name":"颜色","id":"CL_638542_0001","text":"银色"},"size":{"name":"尺码","id":"SI_638542_0001","text":"均码"},"style":{}}]
         */

        private int vendorId;
        private String vendorName;
        private String logo;
        private List<SkusBean> skus;

        public int getVendorId() {
            return vendorId;
        }

        public void setVendorId(int vendorId) {
            this.vendorId = vendorId;
        }

        public String getVendorName() {
            return vendorName;
        }

        public void setVendorName(String vendorName) {
            this.vendorName = vendorName;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public List<SkusBean> getSkus() {
            return skus;
        }

        public void setSkus(List<SkusBean> skus) {
            this.skus = skus;
        }

        public static class SkusBean {
            /**
             * cartId : 24964
             * itemId : 638539
             * title : Cecile戒指
             * brandId : 2266
             * url : http://cdn.palshock.cn/ext/itm/0/1205_1_c4839275_s.jpg
             * sprice : 950
             * currency : CNY
             * quantity : 9
             * totalPrice : 8550
             * soldoutQuantity : 0
             * status : 1
             * color : {"name":"颜色","id":"CL_638539_0001","text":"银色"}
             * size : {"name":"尺码","id":"SI_638539_0001","text":"N"}
             * style : {}
             */

            private int cartId;
            private int itemId;
            private String title;
            private int brandId;
            private String url;
            private int sprice;
            private String currency;
            private int quantity;
            private int totalPrice;
            private int soldoutQuantity;
            private int status;
            private ColorBean color;
            private SizeBean size;
            private StyleBean style;

            public int getCartId() {
                return cartId;
            }

            public void setCartId(int cartId) {
                this.cartId = cartId;
            }

            public int getItemId() {
                return itemId;
            }

            public void setItemId(int itemId) {
                this.itemId = itemId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getBrandId() {
                return brandId;
            }

            public void setBrandId(int brandId) {
                this.brandId = brandId;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getSprice() {
                return sprice;
            }

            public void setSprice(int sprice) {
                this.sprice = sprice;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getTotalPrice() {
                return totalPrice;
            }

            public void setTotalPrice(int totalPrice) {
                this.totalPrice = totalPrice;
            }

            public int getSoldoutQuantity() {
                return soldoutQuantity;
            }

            public void setSoldoutQuantity(int soldoutQuantity) {
                this.soldoutQuantity = soldoutQuantity;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public ColorBean getColor() {
                return color;
            }

            public void setColor(ColorBean color) {
                this.color = color;
            }

            public SizeBean getSize() {
                return size;
            }

            public void setSize(SizeBean size) {
                this.size = size;
            }

            public StyleBean getStyle() {
                return style;
            }

            public void setStyle(StyleBean style) {
                this.style = style;
            }

            public static class ColorBean {
                /**
                 * name : 颜色
                 * id : CL_638539_0001
                 * text : 银色
                 */

                private String name;
                private String id;
                private String text;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class SizeBean {
                /**
                 * name : 尺码
                 * id : SI_638539_0001
                 * text : N
                 */

                private String name;
                private String id;
                private String text;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class StyleBean {
            }
        }
    }
}
