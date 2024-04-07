package com.wyk.taobao.model.domain;

import java.util.List;


public class SearchHotRecommend {
    /**
     * 搜索热门推荐
     * [api.sunofbeach.net/shop/search-word](https://api.sunofbeach.net/shop/search-word)
     */


    private Boolean success;

    private int code;

    private String msg;

    private List<DataDTO> data;

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

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }


    public static class DataDTO {

        private String id;

        private String word;

        private String enable;

        private int clickCount;

        private int ord;

        private String color;

        private String createTime;

        private String updateTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getEnable() {
            return enable;
        }

        public void setEnable(String enable) {
            this.enable = enable;
        }

        public int getClickCount() {
            return clickCount;
        }

        public void setClickCount(int clickCount) {
            this.clickCount = clickCount;
        }

        public int getOrd() {
            return ord;
        }

        public void setOrd(int ord) {
            this.ord = ord;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}
