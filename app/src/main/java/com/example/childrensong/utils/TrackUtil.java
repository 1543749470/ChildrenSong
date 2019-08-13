package com.example.childrensong.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;


import com.example.childrensong.BuildConfig;
import com.example.childrensong.http.MyApp;

import java.util.HashMap;

public class TrackUtil {
    // TalkingData数据分析
    static private String currentPage;
    static private String versionName;
    private static Activity BabySongApplicationProxy;

    /**
     * 进入页面
     */
    public static void onPageStart(Context ctx, String pageName) {
       TCAgent.onPageStart(ctx, pageName);
        trackPageView(pageName);
    }

    /**
     * 离开页面
     */
    public static void onPageEnd(Context ctx, String pageName) {
        TCAgent.onPageEnd(ctx, pageName);
    }

    static public void trackPageView(String pageView) {
        setCurrentPage(pageView);
    }

    static public void trackPageView() {
        if (getCurrentPage() == null) {
            return;
        }
    }

    static public void trackEvent(String pageView, String event) {
        setCurrentPage(pageView);
        Log.i(TrackUtil.class.getSimpleName(), getAppVersion() + " : " + pageView + " : " + event);
        // talkingData
        TCAgent.onEvent(MyApp.getInstance(), pageView + "#" + event);
    }

    static public void trackEvent(String pageView, String event, String label, long value) {
        setCurrentPage(pageView);
        Log.i(TrackUtil.class.getSimpleName(), getAppVersion() + " : " + getCurrentPage() + " : " + event + ":" + label + ":" + value);

        HashMap<String, Long> map = new HashMap<>();
        map.put(String.valueOf(value), 1l);
        TCAgent.onEvent(MyApp.getInstance(), pageView + "#" + event, label, map);
    }

    static public void trackEvent(String pageView, String event, String label, String value) {
        setCurrentPage(pageView);
        Log.i(TrackUtil.class.getSimpleName(), getAppVersion() + " : " + getCurrentPage() + " : " + event + ":" + label + ":" + value);

        HashMap<String, Long> map = new HashMap<>();
        map.put(value, 1l);
        TCAgent.onEvent(MyApp.getInstance(), pageView + "#" + event, label, map);

    }

    static private String getAppVersion() {
        versionName = BuildConfig.VERSION_NAME;
        versionName = versionName.replace(".debug", "");
        versionName = versionName.replace(".release", "");
        return versionName;
    }

    public static String getCurrentPage() {
        return currentPage;
    }

    public static void setCurrentPage(String currentPage) {
        TrackUtil.currentPage = currentPage;
    }
}
