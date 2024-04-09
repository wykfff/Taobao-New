package com.wyk.taobao.config;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;

public class Config {
    /**
     * 主机名应改为本机的ip地址（注意不要使用localhost）
     */
    public static final String baseUrl = "http://192.168.1.104:9090/api/";
    public static final String rsUrl = "http://192.168.1.104:9090/image/";

    @SuppressLint("SimpleDateFormat")
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
}
