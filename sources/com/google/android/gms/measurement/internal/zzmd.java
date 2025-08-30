package com.google.android.gms.measurement.internal;

import androidx.annotation.BinderThread;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzmd extends zzgc {
    final /* synthetic */ AtomicReference zza;

    public zzmd(zznk zznk, AtomicReference atomicReference) {
        this.zza = atomicReference;
        Objects.requireNonNull(zznk);
    }

    @BinderThread
    public final void zze(List list) {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            atomicReference.set(list);
            atomicReference.notifyAll();
        }
    }
}
