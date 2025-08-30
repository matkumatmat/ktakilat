package com.google.android.gms.maps.internal;

import androidx.annotation.Nullable;

public final class zza {
    public static byte zza(@Nullable Boolean bool) {
        if (bool == null) {
            return -1;
        }
        if (!bool.booleanValue()) {
            return 0;
        }
        return 1;
    }

    @Nullable
    public static Boolean zzb(byte b) {
        if (b == 0) {
            return Boolean.FALSE;
        }
        if (b != 1) {
            return null;
        }
        return Boolean.TRUE;
    }
}
