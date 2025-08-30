package com.trustdecision.android.bugly;

import android.content.Context;
import com.trustdecision.android.BuildConfig;
import com.trustdecision.android.bugly.l1ill1li1i.l1l11i111l;
import com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1;

public class Bugly {
    private static volatile boolean liii1l1lll1;

    public static void initWithNative(Context context, int i, String str, String str2) {
        String str3;
        if (!liii1l1lll1) {
            Context applicationContext = context.getApplicationContext();
            liii1l1lll1.liii1l1lll1(applicationContext);
            if (i == 0) {
                str3 = "com.trustdecision";
            } else {
                str3 = BuildConfig.LIBRARY_PACKAGE_NAME;
            }
            liii1l1lll1.liii1l1lll1(applicationContext, str3, str, str2);
            l1l11i111l.liii1l1lll1().liii1l1lll1(applicationContext);
            com.trustdecision.android.bugly.l1l11i111l.liii1l1lll1.l1l11i111l(applicationContext);
            liii1l1lll1();
            NativeBugly.liii1l1lll1(context, str3, com.trustdecision.android.bugly.l1l11i111l.liii1l1lll1.liii1l1lll1(applicationContext));
            llli1l111ilii1i.liii1l1lll1(applicationContext, str3);
            liii1l1lll1 = true;
        }
    }

    private static void liii1l1lll1() {
        Thread.setDefaultUncaughtExceptionHandler(new l1l11i111l(Thread.getDefaultUncaughtExceptionHandler()));
    }

    public static void setCustomHost(String str) {
        llli1l111ilii1i.liii1l1lll1 = str;
    }
}
