package com.facebook.appevents.internal;

import android.os.Looper;

public class AppEventUtility {
    public static void assertIsMainThread() {
    }

    public static void assertIsNotMainThread() {
    }

    private static boolean isMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }
}
