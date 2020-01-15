package com.dev.onlinestore1;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Notification extends Application {
    public static final String HUY_DON_1 ="huydon1";
    public static final String XAC_NHAN_DON_1 ="xacnhandon1";


    @Override
    public void onCreate() {
        super.onCreate();
        createNotification();
    }
    private  void createNotification(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel huydon1 =new NotificationChannel(HUY_DON_1,"Huydon 1", NotificationManager.IMPORTANCE_HIGH);
       huydon1.setDescription("this is huydon");

            NotificationChannel xacnhan1 =new NotificationChannel(XAC_NHAN_DON_1,"Xacnhan 1", NotificationManager.IMPORTANCE_LOW);
            huydon1.setDescription("this is xac nhan");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(huydon1);
            manager.createNotificationChannel(xacnhan1);
        }
    }
}
