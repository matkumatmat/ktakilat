package com.google.android.gms.measurement.internal;

import android.content.Intent;

final /* synthetic */ class zznr implements Runnable {
    private final /* synthetic */ zzns zza;
    private final /* synthetic */ int zzb;
    private final /* synthetic */ zzgt zzc;
    private final /* synthetic */ Intent zzd;

    public /* synthetic */ zznr(zzns zzns, int i, zzgt zzgt, Intent intent) {
        this.zza = zzns;
        this.zzb = i;
        this.zzc = zzgt;
        this.zzd = intent;
    }

    public final /* synthetic */ void run() {
        this.zza.zzf(this.zzb, this.zzc, this.zzd);
    }
}
