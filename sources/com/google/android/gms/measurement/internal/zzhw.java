package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class zzhw extends FutureTask implements Comparable {
    final boolean zza;
    final /* synthetic */ zzhy zzb;
    private final long zzc;
    private final String zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzhw(zzhy zzhy, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        Objects.requireNonNull(zzhy);
        this.zzb = zzhy;
        Preconditions.checkNotNull(str);
        long andIncrement = zzhy.zzj.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z;
        if (andIncrement == LocationRequestCompat.PASSIVE_INTERVAL) {
            e.w(zzhy.zzu, "Tasks index overflow");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(@NonNull Object obj) {
        zzhw zzhw = (zzhw) obj;
        boolean z = zzhw.zza;
        boolean z2 = this.zza;
        if (z2 == z) {
            long j = this.zzc;
            int i = (j > zzhw.zzc ? 1 : (j == zzhw.zzc ? 0 : -1));
            if (i < 0) {
                return -1;
            }
            if (i <= 0) {
                this.zzb.zzu.zzaV().zzc().zzb("Two tasks share the same index. index", Long.valueOf(j));
                return 0;
            }
        } else if (!z2) {
            return 1;
        } else {
            return -1;
        }
        return 1;
    }

    public final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzb.zzu.zzaV().zzb().zzb(this.zzd, th);
        if ((th instanceof zzhu) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzhw(zzhy zzhy, Callable callable, boolean z, String str) {
        super(callable);
        Objects.requireNonNull(zzhy);
        this.zzb = zzhy;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzhy.zzj.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z;
        if (andIncrement == LocationRequestCompat.PASSIVE_INTERVAL) {
            e.w(zzhy.zzu, "Tasks index overflow");
        }
    }
}
