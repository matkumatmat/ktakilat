package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;

final class zzmz implements Runnable {
    final /* synthetic */ zzga zza;
    final /* synthetic */ zzne zzb;

    public zzmz(zzne zzne, zzga zzga) {
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
                    zznk.zzu.zzaV().zzj().zza("Connected to remote service");
                    zznk.zzL(this.zza);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        zznk zznk2 = this.zzb.zza;
        if (zznk2.zzab() != null) {
            zznk2.zzab().shutdownNow();
            zznk2.zzac((ScheduledExecutorService) null);
        }
    }
}
