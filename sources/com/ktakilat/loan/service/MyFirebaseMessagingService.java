package com.ktakilat.loan.service;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.ktakilat.cbase.datacollect.AppsFlyerManager;
import com.ktakilat.cbase.datacollect.DataCollectManager;
import com.ktakilat.loan.R;
import com.ktakilat.loan.main.HomeActivity;
import com.ktakilat.loan.weiget.PushTokenUtil;

@SuppressLint({"MissingFirebaseInstanceTokenRefresh"})
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public final void c(String str, String str2) {
        NotificationCompat.Builder builder;
        if (str == null || "null".equals(str.toLowerCase())) {
            str = "";
        }
        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        intent.putExtra("finishAll", false);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        DataCollectManager.b(AFInAppEventType.OPENED_FROM_PUSH_NOTIFICATION, (Bundle) null);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        int i = Build.VERSION.SDK_INT;
        if (i < 33 || notificationManager.areNotificationsEnabled()) {
            if (i >= 26) {
                builder = new NotificationCompat.Builder((Context) this, "channelId").setAutoCancel(true).setSmallIcon((int) R.mipmap.ic_logo).setContentTitle(str2).setContentText(str).setContentIntent(activity);
                NotificationChannel c = qb.c();
                c.enableLights(true);
                c.setShowBadge(true);
                c.enableVibration(false);
                c.setSound(defaultUri, (AudioAttributes) null);
                notificationManager.createNotificationChannel(c);
            } else {
                builder = new NotificationCompat.Builder(this).setSmallIcon((int) R.mipmap.ic_logo).setContentTitle(str2).setContentText(str).setAutoCancel(true).setSound(defaultUri).setContentIntent(activity);
            }
            notificationManager.notify(0, builder.build());
        }
    }

    public final void onMessageReceived(RemoteMessage remoteMessage) {
        if (!remoteMessage.getData().containsKey("af-uinstall-tracking")) {
            if (remoteMessage.getData().size() > 0) {
                c(remoteMessage.getData() + "", "");
            }
            if (remoteMessage.getNotification() != null && remoteMessage.getNotification().getTag() != null) {
                c(remoteMessage.getNotification().getBody() + "", remoteMessage.getNotification().getTitle() + "");
            }
        }
    }

    public final void onNewToken(String str) {
        super.onNewToken(str);
        PushTokenUtil.a(str);
        if (AppsFlyerManager.f467a != null) {
            AppsFlyerLib.getInstance().updateServerUninstallToken(AppsFlyerManager.f467a, str);
        }
    }
}
