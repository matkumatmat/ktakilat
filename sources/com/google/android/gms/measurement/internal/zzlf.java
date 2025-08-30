package com.google.android.gms.measurement.internal;

final /* synthetic */ class zzlf implements Runnable {
    private final /* synthetic */ zzli zza;
    private final /* synthetic */ String zzb;

    public /* synthetic */ zzlf(zzli zzli, String str) {
        this.zza = zzli;
        this.zzb = str;
    }

    public final /* synthetic */ void run() {
        zzib zzib = this.zza.zzu;
        if (zzib.zzv().zzq(this.zzb)) {
            zzib.zzv().zzi();
        }
    }
}
