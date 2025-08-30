package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final /* synthetic */ class zzlh implements Runnable {
    private final /* synthetic */ zzli zza;
    private final /* synthetic */ AtomicReference zzb;

    public /* synthetic */ zzlh(zzli zzli, AtomicReference atomicReference) {
        this.zza = zzli;
        this.zzb = atomicReference;
    }

    public final /* synthetic */ void run() {
        this.zza.zzu.zzt().zzx(this.zzb, zzon.zza(zzlr.SGTM_CLIENT));
    }
}
