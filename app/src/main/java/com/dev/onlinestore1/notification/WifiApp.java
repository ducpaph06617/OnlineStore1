package com.dev.onlinestore1.notification;

import android.app.Application;

public class WifiApp extends Application {
    static WifiApp wifiInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        wifiInstance = this;
    }
    public static synchronized WifiApp getInstance() {
        return wifiInstance;
    }
}
