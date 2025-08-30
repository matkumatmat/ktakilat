package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;
import java.util.Objects;

final class zzov implements zzgv {
    final /* synthetic */ String zza;
    final /* synthetic */ List zzb;
    final /* synthetic */ zzpf zzc;

    public zzov(zzpf zzpf, String str, List list) {
        this.zza = str;
        this.zzb = list;
        Objects.requireNonNull(zzpf);
        this.zzc = zzpf;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.zzc.zzU(true, i, th, bArr, this.zza, this.zzb);
    }
}
