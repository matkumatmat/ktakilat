package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzmx implements Runnable {
    final /* synthetic */ zzga zza;
    final /* synthetic */ zzne zzb;

    public zzmx(zzne zzne, zzga zzga) {
        this.zza = zzga;
        Objects.requireNonNull(zzne);
        this.zzb = zzne;
    }

    public final void run() {
        zzne zzne = this.zzb;
        synchronized (zzne) {
            try {
                zzne.zzd(false);
                zznk zznk = zzne.zza;
                if (!zznk.zzh()) {
                    zznk.zzu.zzaV().zzk().zza("Connected to service");
                    zznk.zzL(this.zza);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
