package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzko implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzli zzb;

    public zzko(zzli zzli, AtomicReference atomicReference) {
        this.zza = atomicReference;
        Objects.requireNonNull(zzli);
        this.zzb = zzli;
    }

    public final void run() {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            try {
                zzli zzli = this.zzb;
                atomicReference.set(Long.valueOf(zzli.zzu.zzc().zzl(zzli.zzu.zzv().zzj(), zzfx.zzac)));
                this.zza.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
