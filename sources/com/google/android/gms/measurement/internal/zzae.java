package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;

public final class zzae {
    public zzae(Context context) {
    }

    public static final boolean zza() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }
}
