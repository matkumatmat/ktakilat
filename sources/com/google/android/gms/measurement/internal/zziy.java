package com.google.android.gms.measurement.internal;

final /* synthetic */ class zziy implements Runnable {
    private final /* synthetic */ zzjc zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzon zzc;
    private final /* synthetic */ zzgg zzd;

    public /* synthetic */ zziy(zzjc zzjc, String str, zzon zzon, zzgg zzgg) {
        this.zza = zzjc;
        this.zzb = str;
        this.zzc = zzon;
        this.zzd = zzgg;
    }

    public final /* synthetic */ void run() {
        this.zza.zzI(this.zzb, this.zzc, this.zzd);
    }
}
