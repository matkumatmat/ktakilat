package com.google.android.gms.measurement.internal;

import java.util.Map;

final /* synthetic */ class zzll implements Runnable {
    private final /* synthetic */ zzlm zza;
    private final /* synthetic */ int zzb;
    private final /* synthetic */ Exception zzc;
    private final /* synthetic */ byte[] zzd;
    private final /* synthetic */ Map zze;

    public /* synthetic */ zzll(zzlm zzlm, int i, Exception exc, byte[] bArr, Map map) {
        this.zza = zzlm;
        this.zzb = i;
        this.zzc = exc;
        this.zzd = bArr;
        this.zze = map;
    }

    public final /* synthetic */ void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
