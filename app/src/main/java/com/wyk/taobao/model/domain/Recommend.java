package com.wyk.taobao.model.domain;

import java.util.List;


public class Recommend {
    /**
     * 猜你喜欢，特惠
     * 示例：[api.sunofbeach.net/shop/r/1](https://api.sunofbeach.net/shop/r/1)
     */

    private Boolean success;

    private int code;

    private String msg;

    private DataDTO data;

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }


    public static class DataDTO {

        private int total;

        private int pageSize;

        private int currentPage;

        private Boolean hasNext;

        private Boolean hasPre;

        private int totalPage;

        private List<ListDTO> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public Boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(Boolean hasNext) {
            this.hasNext = hasNext;
        }

        public Boolean isHasPre() {
            return hasPre;
        }

        public void setHasPre(Boolean hasPre) {
            this.hasPre = hasPre;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public List<ListDTO> getList() {
            return list;
        }

        public void setList(List<ListDTO> list) {
            this.list = list;
        }


        public static class ListDTO {

            private String cover;

            private String source;

            private String title;

            private Double couponAmount;

            private String zkFinalPrice;

            private String couponShareUrl;

            private int couponTotalCount;

            private int couponRemainCount;

            private int sellCount;

            private String justPrice;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Double getCouponAmount() {
                return couponAmount;
            }

            public void setCouponAmount(Double couponAmount) {
                this.couponAmount = couponAmount;
            }

            public String getZkFinalPrice() {
                return zkFinalPrice;
            }

            public void setZkFinalPrice(String zkFinalPrice) {
                this.zkFinalPrice = zkFinalPrice;
            }

            public String getCouponShareUrl() {
                return couponShareUrl;
            }

            public void setCouponShareUrl(String couponShareUrl) {
                this.couponShareUrl = couponShareUrl;
            }

            public int getCouponTotalCount() {
                return couponTotalCount;
            }

            public void setCouponTotalCount(int couponTotalCount) {
                this.couponTotalCount = couponTotalCount;
            }

            public int getCouponRemainCount() {
                return couponRemainCount;
            }

            public void setCouponRemainCount(int couponRemainCount) {
                this.couponRemainCount = couponRemainCount;
            }

            public int getSellCount() {
                return sellCount;
            }

            public void setSellCount(int sellCount) {
                this.sellCount = sellCount;
            }

            public String getJustPrice() {
                return justPrice;
            }

            public void setJustPrice(String justPrice) {
                this.justPrice = justPrice;
            }
        }
    }
}
