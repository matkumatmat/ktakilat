package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzif implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzjc zze;

    public zzif(zzjc zzjc, String str, String str2, String str3, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
        Objects.requireNonNull(zzjc);
        this.zze = zzjc;
    }

    public final void run() {
        String str = this.zza;
        if (str == null) {
            zzjc zzjc = this.zze;
            zzjc.zzL().zzas(this.zzb, (zzlt) null);
            return;
        }
        zzlt zzlt = new zzlt(this.zzc, str, this.zzd);
        zzjc zzjc2 = this.zze;
        zzjc2.zzL().zzas(this.zzb, zzlt);
    }
}
