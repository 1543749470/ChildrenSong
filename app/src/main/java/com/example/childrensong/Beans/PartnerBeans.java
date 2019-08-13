package com.example.childrensong.Beans;

import java.util.List;

public class PartnerBeans {

    /**
     * success : true
     * data : {"id":562,"name":"超级飞侠","image_url":"http://img5g22.ergedd.com/album/562_1545043168054.jpg","description":"跟着乐迪环游世界","status":1,"video_count":26,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/562_1537873619600.png","index_recommend":1,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"http://img5g22.ergedd.com/album/562_1544176901596.png","publisher_name":"奥飞文化-奥飞","brand_styles":[{"type":"1","banner_image_url":"http://img5g22.ergedd.com/admin/app_config/59879427212_1540360430465.png","banner_image_width":"1080","banner_image_height":"640","banner_bg_image_url":"http://img5g22.ergedd.com/admin/app_config/49739090938_1540358704470.png","banner_bg_image_width":"405","banner_bg_image_height":"960","brand_image_url":"http://img5g22.ergedd.com/admin/app_config/7415578884_1540372053080.png","brand_image_width":"194","brand_image_height":"194","bg_color":"#dbf3ff","album_border_color":"#6ed4ff","album_title_color":"#ffffff","intro_color":"#13a8e7","intro_text":["超级飞侠，带你一起环游世界。飞机机器人乐迪和\u201c超级飞侠\u201d的小伙伴环游世界，为小朋友递送包裹，并帮助他们解决困难的故事。"],"albums":[{"id":645,"title":"超级飞侠第五季","name":"超级飞侠 第五季","image_url":"http://img5g22.ergedd.com/album/645_1550054122266.jpg","description":"新成员 新团队 集结完毕！","status":1,"video_count":20,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":562,"title":"超级飞侠","name":"超级飞侠","image_url":"http://img5g22.ergedd.com/album/562_1545043168054.jpg","description":"跟着乐迪环游世界","status":1,"video_count":26,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/562_1537873619600.png","index_recommend":1,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"http://img5g22.ergedd.com/album/562_1544176901596.png","publisher_name":"奥飞文化-奥飞"},{"id":569,"title":"超级飞侠欢乐玩粘土","name":"超级飞侠欢乐玩粘土","image_url":"http://img5g22.ergedd.com/album/569_1542769164613.jpg","description":"用粘土制作超级飞侠","status":1,"video_count":14,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":566,"title":"超级飞侠游学堂","name":"超级飞侠游学堂","image_url":"http://img5g22.ergedd.com/album/566_1545202068384.jpg","description":"做个文明有礼好宝宝","status":1,"video_count":6,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":570,"title":"超级飞侠简笔画","name":"超级飞侠简笔画","image_url":"http://img5g22.ergedd.com/album/7534549814_1538030096128.jpg","description":"如何画出超级飞侠","status":1,"video_count":15,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":568,"title":"超级飞侠大百科","name":"超级飞侠大百科","image_url":"http://img5g22.ergedd.com/album/568_1550138424451.jpg","description":"乐迪秒解十万个为什么","status":1,"video_count":71,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"}]}]}
     * message : Get album successfully
     */

    private boolean success;
    private DataBean data;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * id : 562
         * name : 超级飞侠
         * image_url : http://img5g22.ergedd.com/album/562_1545043168054.jpg
         * description : 跟着乐迪环游世界
         * status : 1
         * video_count : 26
         * play_count : 0
         * icon_url : http://img5g22.ergedd.com/album/562_1537873619600.png
         * index_recommend : 1
         * copyright_sensitive : 0
         * is_vip : 2
         * type : 1
         * sensitive : 0
         * erge_img_url : http://img5g22.ergedd.com/album/562_1544176901596.png
         * publisher_name : 奥飞文化-奥飞
         * brand_styles : [{"type":"1","banner_image_url":"http://img5g22.ergedd.com/admin/app_config/59879427212_1540360430465.png","banner_image_width":"1080","banner_image_height":"640","banner_bg_image_url":"http://img5g22.ergedd.com/admin/app_config/49739090938_1540358704470.png","banner_bg_image_width":"405","banner_bg_image_height":"960","brand_image_url":"http://img5g22.ergedd.com/admin/app_config/7415578884_1540372053080.png","brand_image_width":"194","brand_image_height":"194","bg_color":"#dbf3ff","album_border_color":"#6ed4ff","album_title_color":"#ffffff","intro_color":"#13a8e7","intro_text":["超级飞侠，带你一起环游世界。飞机机器人乐迪和\u201c超级飞侠\u201d的小伙伴环游世界，为小朋友递送包裹，并帮助他们解决困难的故事。"],"albums":[{"id":645,"title":"超级飞侠第五季","name":"超级飞侠 第五季","image_url":"http://img5g22.ergedd.com/album/645_1550054122266.jpg","description":"新成员 新团队 集结完毕！","status":1,"video_count":20,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":562,"title":"超级飞侠","name":"超级飞侠","image_url":"http://img5g22.ergedd.com/album/562_1545043168054.jpg","description":"跟着乐迪环游世界","status":1,"video_count":26,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/562_1537873619600.png","index_recommend":1,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"http://img5g22.ergedd.com/album/562_1544176901596.png","publisher_name":"奥飞文化-奥飞"},{"id":569,"title":"超级飞侠欢乐玩粘土","name":"超级飞侠欢乐玩粘土","image_url":"http://img5g22.ergedd.com/album/569_1542769164613.jpg","description":"用粘土制作超级飞侠","status":1,"video_count":14,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":566,"title":"超级飞侠游学堂","name":"超级飞侠游学堂","image_url":"http://img5g22.ergedd.com/album/566_1545202068384.jpg","description":"做个文明有礼好宝宝","status":1,"video_count":6,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":570,"title":"超级飞侠简笔画","name":"超级飞侠简笔画","image_url":"http://img5g22.ergedd.com/album/7534549814_1538030096128.jpg","description":"如何画出超级飞侠","status":1,"video_count":15,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":568,"title":"超级飞侠大百科","name":"超级飞侠大百科","image_url":"http://img5g22.ergedd.com/album/568_1550138424451.jpg","description":"乐迪秒解十万个为什么","status":1,"video_count":71,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"}]}]
         */

        private int id;
        private String name;
        private String image_url;
        private String description;
        private int status;
        private int video_count;
        private int play_count;
        private String icon_url;
        private int index_recommend;
        private int copyright_sensitive;
        private int is_vip;
        private int type;
        private int sensitive;
        private String erge_img_url;
        private String publisher_name;
        private List<BrandStylesBean> brand_styles;

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

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getVideo_count() {
            return video_count;
        }

        public void setVideo_count(int video_count) {
            this.video_count = video_count;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public int getIndex_recommend() {
            return index_recommend;
        }

        public void setIndex_recommend(int index_recommend) {
            this.index_recommend = index_recommend;
        }

        public int getCopyright_sensitive() {
            return copyright_sensitive;
        }

        public void setCopyright_sensitive(int copyright_sensitive) {
            this.copyright_sensitive = copyright_sensitive;
        }

        public int getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(int is_vip) {
            this.is_vip = is_vip;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getSensitive() {
            return sensitive;
        }

        public void setSensitive(int sensitive) {
            this.sensitive = sensitive;
        }

        public String getErge_img_url() {
            return erge_img_url;
        }

        public void setErge_img_url(String erge_img_url) {
            this.erge_img_url = erge_img_url;
        }

        public String getPublisher_name() {
            return publisher_name;
        }

        public void setPublisher_name(String publisher_name) {
            this.publisher_name = publisher_name;
        }

        public List<BrandStylesBean> getBrand_styles() {
            return brand_styles;
        }

        public void setBrand_styles(List<BrandStylesBean> brand_styles) {
            this.brand_styles = brand_styles;
        }

        public static class BrandStylesBean {
            /**
             * type : 1
             * banner_image_url : http://img5g22.ergedd.com/admin/app_config/59879427212_1540360430465.png
             * banner_image_width : 1080
             * banner_image_height : 640
             * banner_bg_image_url : http://img5g22.ergedd.com/admin/app_config/49739090938_1540358704470.png
             * banner_bg_image_width : 405
             * banner_bg_image_height : 960
             * brand_image_url : http://img5g22.ergedd.com/admin/app_config/7415578884_1540372053080.png
             * brand_image_width : 194
             * brand_image_height : 194
             * bg_color : #dbf3ff
             * album_border_color : #6ed4ff
             * album_title_color : #ffffff
             * intro_color : #13a8e7
             * intro_text : ["超级飞侠，带你一起环游世界。飞机机器人乐迪和\u201c超级飞侠\u201d的小伙伴环游世界，为小朋友递送包裹，并帮助他们解决困难的故事。"]
             * albums : [{"id":645,"title":"超级飞侠第五季","name":"超级飞侠 第五季","image_url":"http://img5g22.ergedd.com/album/645_1550054122266.jpg","description":"新成员 新团队 集结完毕！","status":1,"video_count":20,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":562,"title":"超级飞侠","name":"超级飞侠","image_url":"http://img5g22.ergedd.com/album/562_1545043168054.jpg","description":"跟着乐迪环游世界","status":1,"video_count":26,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/562_1537873619600.png","index_recommend":1,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"http://img5g22.ergedd.com/album/562_1544176901596.png","publisher_name":"奥飞文化-奥飞"},{"id":569,"title":"超级飞侠欢乐玩粘土","name":"超级飞侠欢乐玩粘土","image_url":"http://img5g22.ergedd.com/album/569_1542769164613.jpg","description":"用粘土制作超级飞侠","status":1,"video_count":14,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":566,"title":"超级飞侠游学堂","name":"超级飞侠游学堂","image_url":"http://img5g22.ergedd.com/album/566_1545202068384.jpg","description":"做个文明有礼好宝宝","status":1,"video_count":6,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":570,"title":"超级飞侠简笔画","name":"超级飞侠简笔画","image_url":"http://img5g22.ergedd.com/album/7534549814_1538030096128.jpg","description":"如何画出超级飞侠","status":1,"video_count":15,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":568,"title":"超级飞侠大百科","name":"超级飞侠大百科","image_url":"http://img5g22.ergedd.com/album/568_1550138424451.jpg","description":"乐迪秒解十万个为什么","status":1,"video_count":71,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"}]
             */

            private String type;
            private String banner_image_url;
            private String banner_image_width;
            private String banner_image_height;
            private String banner_bg_image_url;
            private String banner_bg_image_width;
            private String banner_bg_image_height;
            private String brand_image_url;
            private String brand_image_width;
            private String brand_image_height;
            private String bg_color;
            private String album_border_color;
            private String album_title_color;
            private String intro_color;
            private List<String> intro_text;
            private List<AlbumsBean> albums;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getBanner_image_url() {
                return banner_image_url;
            }

            public void setBanner_image_url(String banner_image_url) {
                this.banner_image_url = banner_image_url;
            }

            public String getBanner_image_width() {
                return banner_image_width;
            }

            public void setBanner_image_width(String banner_image_width) {
                this.banner_image_width = banner_image_width;
            }

            public String getBanner_image_height() {
                return banner_image_height;
            }

            public void setBanner_image_height(String banner_image_height) {
                this.banner_image_height = banner_image_height;
            }

            public String getBanner_bg_image_url() {
                return banner_bg_image_url;
            }

            public void setBanner_bg_image_url(String banner_bg_image_url) {
                this.banner_bg_image_url = banner_bg_image_url;
            }

            public String getBanner_bg_image_width() {
                return banner_bg_image_width;
            }

            public void setBanner_bg_image_width(String banner_bg_image_width) {
                this.banner_bg_image_width = banner_bg_image_width;
            }

            public String getBanner_bg_image_height() {
                return banner_bg_image_height;
            }

            public void setBanner_bg_image_height(String banner_bg_image_height) {
                this.banner_bg_image_height = banner_bg_image_height;
            }

            public String getBrand_image_url() {
                return brand_image_url;
            }

            public void setBrand_image_url(String brand_image_url) {
                this.brand_image_url = brand_image_url;
            }

            public String getBrand_image_width() {
                return brand_image_width;
            }

            public void setBrand_image_width(String brand_image_width) {
                this.brand_image_width = brand_image_width;
            }

            public String getBrand_image_height() {
                return brand_image_height;
            }

            public void setBrand_image_height(String brand_image_height) {
                this.brand_image_height = brand_image_height;
            }

            public String getBg_color() {
                return bg_color;
            }

            public void setBg_color(String bg_color) {
                this.bg_color = bg_color;
            }

            public String getAlbum_border_color() {
                return album_border_color;
            }

            public void setAlbum_border_color(String album_border_color) {
                this.album_border_color = album_border_color;
            }

            public String getAlbum_title_color() {
                return album_title_color;
            }

            public void setAlbum_title_color(String album_title_color) {
                this.album_title_color = album_title_color;
            }

            public String getIntro_color() {
                return intro_color;
            }

            public void setIntro_color(String intro_color) {
                this.intro_color = intro_color;
            }

            public List<String> getIntro_text() {
                return intro_text;
            }

            public void setIntro_text(List<String> intro_text) {
                this.intro_text = intro_text;
            }

            public List<AlbumsBean> getAlbums() {
                return albums;
            }

            public void setAlbums(List<AlbumsBean> albums) {
                this.albums = albums;
            }

            public static class AlbumsBean {
                /**
                 * id : 645
                 * title : 超级飞侠第五季
                 * name : 超级飞侠 第五季
                 * image_url : http://img5g22.ergedd.com/album/645_1550054122266.jpg
                 * description : 新成员 新团队 集结完毕！
                 * status : 1
                 * video_count : 20
                 * play_count : 0
                 * icon_url : http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg
                 * index_recommend : null
                 * copyright_sensitive : 0
                 * is_vip : 2
                 * type : 1
                 * sensitive : 0
                 * erge_img_url :
                 * publisher_name : 奥飞文化-奥飞
                 */

                private int id;
                private String title;
                private String name;
                private String image_url;
                private String description;
                private int status;
                private int video_count;
                private int play_count;
                private String icon_url;
                private Object index_recommend;
                private int copyright_sensitive;
                private int is_vip;
                private int type;
                private int sensitive;
                private String erge_img_url;
                private String publisher_name;

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

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getImage_url() {
                    return image_url;
                }

                public void setImage_url(String image_url) {
                    this.image_url = image_url;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getVideo_count() {
                    return video_count;
                }

                public void setVideo_count(int video_count) {
                    this.video_count = video_count;
                }

                public int getPlay_count() {
                    return play_count;
                }

                public void setPlay_count(int play_count) {
                    this.play_count = play_count;
                }

                public String getIcon_url() {
                    return icon_url;
                }

                public void setIcon_url(String icon_url) {
                    this.icon_url = icon_url;
                }

                public Object getIndex_recommend() {
                    return index_recommend;
                }

                public void setIndex_recommend(Object index_recommend) {
                    this.index_recommend = index_recommend;
                }

                public int getCopyright_sensitive() {
                    return copyright_sensitive;
                }

                public void setCopyright_sensitive(int copyright_sensitive) {
                    this.copyright_sensitive = copyright_sensitive;
                }

                public int getIs_vip() {
                    return is_vip;
                }

                public void setIs_vip(int is_vip) {
                    this.is_vip = is_vip;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getSensitive() {
                    return sensitive;
                }

                public void setSensitive(int sensitive) {
                    this.sensitive = sensitive;
                }

                public String getErge_img_url() {
                    return erge_img_url;
                }

                public void setErge_img_url(String erge_img_url) {
                    this.erge_img_url = erge_img_url;
                }

                public String getPublisher_name() {
                    return publisher_name;
                }

                public void setPublisher_name(String publisher_name) {
                    this.publisher_name = publisher_name;
                }
            }
        }
    }
}
