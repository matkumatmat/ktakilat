package com.google.android.gms.internal.measurement;

final class zzbd implements zzbe {
    private final zzg zza;
    private final String zzb;

    public zzbd(zzg zzg, String str) {
        this.zza = zzg;
        this.zzb = str;
    }

    public final zzg zza(zzao zzao) {
        zzg zzc = this.zza.zzc();
        zzc.zzf(this.zzb, zzao);
        return zzc;
    }
}
