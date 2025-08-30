package com.trustdecision.android.bugly;

import android.content.Context;
import android.text.TextUtils;

public class NativeBugly {
    private static boolean liii1l1lll1 = true;

    static {
        try {
            System.loadLibrary("tdcoreplugin");
        } catch (Throwable unused) {
        }
    }

    public static boolean liii1l1lll1(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException(" dump file is empty.");
        } else if (!liii1l1lll1 || nativeInit(context, str, str2) <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private static native int nativeInit(Context context, String str, String str2);
}
