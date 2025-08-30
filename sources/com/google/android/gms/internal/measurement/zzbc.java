package com.google.android.gms.internal.measurement;

final class zzbc implements zzbe {
    private final zzg zza;
    private final String zzb;

    public zzbc(zzg zzg, String str) {
        this.zza = zzg;
        this.zzb = str;
    }

    public final zzg zza(zzao zzao) {
        zzg zzc = this.zza.zzc();
        zzc.zzg(this.zzb, zzao);
        return zzc;
    }
}
