package com.ktakilat.cbase.datacollect;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.ktakilat.cbase.ui.BaseApplication;

class FirebaseManager {

    /* renamed from: a  reason: collision with root package name */
    public static BaseApplication f468a;
    public static volatile FirebaseAnalytics b;
    public static volatile FirebaseCrashlytics c;
    public static String d;

    public static FirebaseCrashlytics a() {
        if (c == null) {
            synchronized (FirebaseCrashlytics.class) {
                try {
                    if (c == null) {
                        c = FirebaseCrashlytics.getInstance();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }
}
