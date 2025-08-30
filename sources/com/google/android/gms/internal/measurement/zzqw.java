package com.google.android.gms.internal.measurement;

public final class zzqw implements zzqv {
    public static final zzkl zza;

    static {
        zzkf zzb = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzb.zzd("measurement.session_stitching_token_enabled", false);
        zzb.zzd("measurement.link_sst_to_sid", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
