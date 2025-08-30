package com.ktakilat.cbase.datacollect;

import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.ktakilat.cbase.datacollect.PCollectorManager;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.ui.LogActivity;
import java.util.ArrayList;

public class DataCollectManager {

    /* renamed from: com.ktakilat.cbase.datacollect.DataCollectManager$1  reason: invalid class name */
    class AnonymousClass1 implements OnCompleteListener<String> {
        public final void onComplete(Task task) {
            if (task.isSuccessful()) {
                String str = (String) task.getResult();
            }
        }
    }

    public static void a(BaseApplication baseApplication, AppsFlyerConversionListener appsFlyerConversionListener) {
        FirebaseManager.f468a = baseApplication;
        FirebaseApp.initializeApp(baseApplication);
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);
        AppsFlyerManager.f467a = baseApplication;
        AppsFlyerLib.getInstance().init("tYtpANGRvddo7DVHmGgZyQ", appsFlyerConversionListener, baseApplication);
        AppsFlyerLib.getInstance().start(baseApplication);
        AppsFlyerLib.getInstance().setDebugLog(true);
        AppsFlyerLib.getInstance().setCurrencyCode("IDR");
    }

    public static void b(String str, Bundle bundle) {
        String str2 = PCollectorManager.f469a;
        PCollectorManager.Companion.b(bundle, str, (String) null);
    }

    public static void c(Throwable th) {
        if (FirebaseManager.f468a != null) {
            FirebaseManager.a().recordException(th);
        }
    }

    public static void d(String str) {
        String str2;
        if (FirebaseManager.f468a != null) {
            if (TextUtils.isEmpty(FirebaseManager.d)) {
                try {
                    str2 = Settings.Secure.getString(FirebaseManager.f468a.getContentResolver(), "android_id");
                    AppsFlyerLib.getInstance().setAndroidIdData(str2);
                } catch (Exception e) {
                    e.toString();
                    ArrayList arrayList = LogActivity.k;
                    str2 = "";
                }
                FirebaseManager.d = str2;
            }
            FirebaseManager.a().setUserId(e.q(new StringBuilder(), FirebaseManager.d, "-", str));
            if (FirebaseManager.b == null) {
                synchronized (FirebaseAnalytics.class) {
                    try {
                        if (FirebaseManager.b == null) {
                            FirebaseManager.b = FirebaseAnalytics.getInstance(FirebaseManager.f468a);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            FirebaseManager.b.setUserId(str);
        }
        if (AppsFlyerManager.f467a != null) {
            AppsFlyerLib.getInstance().setCustomerUserId(str);
        }
        PCollectorManager.f469a = str;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, com.google.android.gms.tasks.OnCompleteListener] */
    public static void e(BaseApplication baseApplication) {
        FirebaseAnalytics.getInstance(baseApplication).getAppInstanceId().addOnCompleteListener(new Object());
    }
}
