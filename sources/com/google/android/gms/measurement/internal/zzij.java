package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Callable;

final class zzij implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzjc zzd;

    public zzij(zzjc zzjc, String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        Objects.requireNonNull(zzjc);
        this.zzd = zzjc;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzjc zzjc = this.zzd;
        zzjc.zzL().zzY();
        return zzjc.zzL().zzj().zzo(this.zza, this.zzb, this.zzc);
    }
}
