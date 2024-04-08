package com.wyk.taobao;

import android.app.Application;

import com.wyk.taobao.utils.SPUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SPUtils.init(this,"sp_user.pref");
        CookieJarImpl cookieJar = new CookieJarImpl(
                new PersistentCookieStore(
                        getApplicationContext()
                )
        );
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L,TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }
}
