package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcn;

abstract class zzay {
    private static volatile Handler zzb;
    private final zzjf zza;
    private final Runnable zzc;
    private volatile long zzd;

    public zzay(zzjf zzjf) {
        Preconditions.checkNotNull(zzjf);
        this.zza = zzjf;
        this.zzc = new zzax(this, zzjf);
    }

    private final Handler zzf() {
        Handler handler;
        if (zzb != null) {
            return zzb;
        }
        synchronized (zzay.class) {
            try {
                if (zzb == null) {
                    zzb = new zzcn(this.zza.zzaY().getMainLooper());
                }
                handler = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public abstract void zza();

    public final void zzb(long j) {
        zzd();
        if (j >= 0) {
            zzjf zzjf = this.zza;
            this.zzd = zzjf.zzaZ().currentTimeMillis();
            if (!zzf().postDelayed(this.zzc, j)) {
                zzjf.zzaV().zzb().zzb("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final boolean zzc() {
        return this.zzd != 0;
    }

    public final void zzd() {
        this.zzd = 0;
        zzf().removeCallbacks(this.zzc);
    }

    public final /* synthetic */ void zze(long j) {
        this.zzd = 0;
    }
}
