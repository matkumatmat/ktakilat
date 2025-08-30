package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final /* synthetic */ class zzja implements Runnable {
    private final /* synthetic */ zzjc zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzr zzd;

    public /* synthetic */ zzja(zzjc zzjc, Bundle bundle, String str, zzr zzr) {
        this.zza = zzjc;
        this.zzb = bundle;
        this.zzc = str;
        this.zzd = zzr;
    }

    public final /* synthetic */ void run() {
        this.zza.zzK(this.zzb, this.zzc, this.zzd);
    }
}
