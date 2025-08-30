package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzpc {
    final String zza;
    long zzb;

    public /* synthetic */ zzpc(zzpf zzpf, String str, byte[] bArr) {
        this(zzpf, str);
    }

    private zzpc(zzpf zzpf, String str) {
        Objects.requireNonNull(zzpf);
        this.zza = str;
        this.zzb = zzpf.zzaZ().elapsedRealtime();
    }

    public /* synthetic */ zzpc(zzpf zzpf, byte[] bArr) {
        this(zzpf, zzpf.zzt().zzaw());
    }
}
