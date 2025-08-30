package com.trustdecision.android.location.uvvvvvvvuuuv;

import android.content.Context;
import android.os.Process;

public class uvuuuuvuuvvuvvvvvuuvuv {
    public static boolean uvuuuuvuuvvuvvvvvuuvuv(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public static boolean uvuuuuvuuvvuvvvvvuuvuv(Context context, String... strArr) {
        if (r0 == 0) {
            return false;
        }
        boolean z = false;
        for (String checkPermission : strArr) {
            if (context.checkPermission(checkPermission, Process.myPid(), Process.myUid()) == 0) {
                z = true;
            }
        }
        return z;
    }
}
