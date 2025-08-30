package com.google.android.gms.common.util;

import android.os.Looper;

public final class zzd {
    public static boolean zza() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }
}
