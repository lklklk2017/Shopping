package com.qf.nwt.application.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/12/29 0029.
 */

public class GoodsPropertiesEntity implements Serializable{

    /**
     * psj : 0
     * props : {"colors":{"name":"颜色","options":[{"id":"CL_638549_0001","text":"银色"}]},"sizes":{"name":"尺码","options":[{"id":"SI_638549_0002","text":"K"}]},"styles":{}}
     * skus : [{"id":"SKU_638549_0002","propPath":"CL_638549_0001:SI_638549_0002:*","price":{"currency":"CNY","sprice":1000}}]
     * sizeCountry :
     * sizeTable : {"type":"IMG","url":"http://cdn.palshock.cn/img/size_table/theroom/theroom_ring.zh.png","wd":750,"ht":2567}
     */

    private int psj;
    private PropsBean props;
    private String sizeCountry;
    private SizeTableBean sizeTable;
    private List<SkusBean> skus;

    public int getPsj() {
        return psj;
    }

    public void setPsj(int psj) {
        this.psj = psj;
    }

    public PropsBean getProps() {
        return props;
    }

    public void setProps(PropsBean props) {
        this.props = props;
    }

    public String getSizeCountry() {
        return sizeCountry;
    }

    public void setSizeCountry(String sizeCountry) {
        this.sizeCountry = sizeCountry;
    }

    public SizeTableBean getSizeTable() {
        return sizeTable;
    }

    public void setSizeTable(SizeTableBean sizeTable) {
        this.sizeTable = sizeTable;
    }

    public List<SkusBean> getSkus() {
        return skus;
    }

    public void setSkus(List<SkusBean> skus) {
        this.skus = skus;
    }

    public static class PropsBean {
        /**
         * colors : {"name":"颜色","options":[{"id":"CL_638549_0001","text":"银色"}]}
         * sizes : {"name":"尺码","options":[{"id":"SI_638549_0002","text":"K"}]}
         * styles : {}
         */

        private ColorsBean colors;
        private SizesBean sizes;
        private StylesBean styles;

        public ColorsBean getColors() {
            return colors;
        }

        public void setColors(ColorsBean colors) {
            this.colors = colors;
        }

        public SizesBean getSizes() {
            return sizes;
        }

        public void setSizes(SizesBean sizes) {
            this.sizes = sizes;
        }

        public StylesBean getStyles() {
            return styles;
        }

        public void setStyles(StylesBean styles) {
            this.styles = styles;
        }

        public static class ColorsBean {
            /**
             * name : 颜色
             * options : [{"id":"CL_638549_0001","text":"银色"}]
             */

            private String name;
            private List<OptionsBean> options;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<OptionsBean> getOptions() {
                return options;
            }

            public void setOptions(List<OptionsBean> options) {
                this.options = options;
            }

            public static class OptionsBean {
                /**
                 * id : CL_638549_0001
                 * text : 银色
                 */

                private String id;
                private String text;

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
        }

        public static class SizesBean {
            /**
             * sizes : {"name":"尺码","options":[{"id":"SI_638549_0002","text":"K"}]}
             */
            private String name;
            private List<OptionsBeanX> options;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<OptionsBeanX> getOptions() {
                return options;
            }

            public void setOptions(List<OptionsBeanX> options) {
                this.options = options;
            }

            public static class OptionsBeanX {
                /**
                 * {"id":"SI_638549_0002","text":"K"}
                 */
                private String id;
                private String text;

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
        }

        public static class StylesBean {
        }
    }

    public static class SizeTableBean {
        /**
         * type : IMG
         * url : http://cdn.palshock.cn/img/size_table/theroom/theroom_ring.zh.png
         * wd : 750
         * ht : 2567
         */

        private String type;
        private String url;
        private int wd;
        private int ht;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

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

    public static class SkusBean {
        /**
         * id : SKU_638549_0002
         * propPath : CL_638549_0001:SI_638549_0002:*
         * price : {"currency":"CNY","sprice":1000}
         */

        private String id;
        private String propPath;
        private PriceBean price;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPropPath() {
            return propPath;
        }

        public void setPropPath(String propPath) {
            this.propPath = propPath;
        }

        public PriceBean getPrice() {
            return price;
        }

        public void setPrice(PriceBean price) {
            this.price = price;
        }

        public static class PriceBean {
            /**
             * currency : CNY
             * sprice : 1000
             */

            private String currency;
            private int sprice;

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public int getSprice() {
                return sprice;
            }

            public void setSprice(int sprice) {
                this.sprice = sprice;
            }
        }
    }
}
