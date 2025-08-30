package com.trustdecision.android.bugly.liii1l1lll1;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.Arrays;

public class liii1l1lll1 {
    private static boolean i11llii11ilillll1i1 = false;
    private static String l1ill1li1i = "";
    private static String l1l11i111l = "";
    private static String liii1l1lll1 = "";
    private static String llli1l111ilii1i = "";

    public static String i1111ii1111iliii() {
        return l1l11i111l;
    }

    public static String i11llii11ilillll1i1() {
        return liii1l1lll1;
    }

    public static boolean i1l1ill11() {
        return i11llii11ilillll1i1;
    }

    public static String iillii1ili1lll1() {
        return Arrays.toString(Build.SUPPORTED_ABIS);
    }

    public static String l1ill1li1i() {
        return llli1l111ilii1i;
    }

    public static boolean l1l11i111l() {
        if (TextUtils.isEmpty(l1ill1li1i) || !l1ill1li1i.equals(liii1l1lll1)) {
            return false;
        }
        return true;
    }

    public static void liii1l1lll1(Context context, String str, String str2, String str3) {
        llli1l111ilii1i = str2;
        l1ill1li1i = str;
        liii1l1lll1 = context.getPackageName();
        l1l11i111l = str3;
        i11llii11ilillll1i1 = liii1l1lll1(context);
    }

    public static boolean llli111iiilli11ll1i1i() {
        return liii1l1lll1("su");
    }

    public static String llli1l111ilii1i() {
        return l1ill1li1i;
    }

    public static int liii1l1lll1() {
        return l1l11i111l() ? 1 : 2;
    }

    public static boolean liii1l1lll1(Context context) {
        if (context == null || context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) {
            return false;
        }
        return true;
    }

    public static boolean liii1l1lll1(String str) {
        String str2 = System.getenv().get("PATH");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String v : str2.split(":")) {
            if (new File(ba.r(ba.v(v), File.separator, str)).exists()) {
                return true;
            }
        }
        return false;
    }
}
