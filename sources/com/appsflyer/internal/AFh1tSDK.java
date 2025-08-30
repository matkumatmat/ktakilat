package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

public enum AFh1tSDK {
    application,
    activity,
    other;

    public static AFh1tSDK getRevenue(Context context) {
        if (context instanceof Activity) {
            return activity;
        }
        if (context instanceof Application) {
            return application;
        }
        return other;
    }
}
