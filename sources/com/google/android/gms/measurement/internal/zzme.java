package com.google.android.gms.measurement.internal;

import androidx.annotation.BinderThread;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzme extends zzgf {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zznk zzb;

    public zzme(zznk zznk, AtomicReference atomicReference) {
        this.zza = atomicReference;
        Objects.requireNonNull(zznk);
        this.zzb = zznk;
    }

    @BinderThread
    public final void zze(zzop zzop) {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            this.zzb.zzu.zzaV().zzk().zzb("[sgtm] Got upload batches from service. count", Integer.valueOf(zzop.zza.size()));
            atomicReference.set(zzop);
            atomicReference.notifyAll();
        }
    }
}
