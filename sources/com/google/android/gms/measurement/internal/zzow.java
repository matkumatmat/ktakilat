package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Objects;

final class zzow implements zzgv {
    final /* synthetic */ String zza;
    final /* synthetic */ zzpi zzb;
    final /* synthetic */ zzpf zzc;

    public zzow(zzpf zzpf, String str, zzpi zzpi) {
        this.zza = str;
        this.zzb = zzpi;
        Objects.requireNonNull(zzpf);
        this.zzc = zzpf;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.zzc.zzQ(this.zza, i, th, bArr, this.zzb);
    }
}
