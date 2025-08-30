package com.google.android.gms.internal.measurement;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

public final class zzji {
    @GuardedBy("GservicesDelegateSupplier.class")
    @Nullable
    private static zzjh zza;

    public static synchronized void zza(zzjh zzjh) {
        synchronized (zzji.class) {
            if (zza == null) {
                zza = zzjh;
            } else {
                throw new IllegalStateException("init() already called");
            }
        }
    }

    public static synchronized zzjh zzb() {
        zzjh zzjh;
        synchronized (zzji.class) {
            try {
                if (zza == null) {
                    zza(new zzjl());
                }
                zzjh = zza;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return zzjh;
    }
}
