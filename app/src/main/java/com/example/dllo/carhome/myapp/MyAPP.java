package com.example.dllo.carhome.myapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/10/31.
 * 啊,注册是不能忘记的,喵
 */
public class MyAPP extends Application{
    // 与界面无关的全局Context
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
    public static Context getContext() {
        return sContext;
    }
}
