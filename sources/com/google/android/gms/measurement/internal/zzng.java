package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

final /* synthetic */ class zzng implements Runnable {
    private final /* synthetic */ zznk zza;
    private final /* synthetic */ AtomicReference zzb;
    private final /* synthetic */ zzr zzc;
    private final /* synthetic */ Bundle zzd;

    public /* synthetic */ zzng(zznk zznk, AtomicReference atomicReference, zzr zzr, Bundle bundle) {
        this.zza = zznk;
        this.zzb = atomicReference;
        this.zzc = zzr;
        this.zzd = bundle;
    }

    public final /* synthetic */ void run() {
        this.zza.zzS(this.zzb, this.zzc, this.zzd);
    }
}
