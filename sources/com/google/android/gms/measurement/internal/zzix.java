package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final /* synthetic */ class zzix implements Runnable {
    private final /* synthetic */ zzjc zza;
    private final /* synthetic */ zzr zzb;
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzgd zzd;
    private final /* synthetic */ String zze;

    public /* synthetic */ zzix(zzjc zzjc, zzr zzr, Bundle bundle, zzgd zzgd, String str) {
        this.zza = zzjc;
        this.zzb = zzr;
        this.zzc = bundle;
        this.zzd = zzgd;
        this.zze = str;
    }

    public final /* synthetic */ void run() {
        this.zza.zzH(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
