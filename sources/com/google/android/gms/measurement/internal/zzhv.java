package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.Objects;

final class zzhv implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzhy zza;
    private final String zzb;

    public zzhv(zzhy zzhy, String str) {
        Objects.requireNonNull(zzhy);
        this.zza = zzhy;
        Preconditions.checkNotNull(str);
        this.zzb = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zza.zzu.zzaV().zzb().zzb(this.zzb, th);
    }
}
