package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final /* synthetic */ class zzle implements Runnable {
    private final /* synthetic */ zzli zza;
    private final /* synthetic */ Bundle zzb;

    public /* synthetic */ zzle(zzli zzli, Bundle bundle) {
        this.zza = zzli;
        this.zzb = bundle;
    }

    public final /* synthetic */ void run() {
        this.zza.zzag(this.zzb);
    }
}
