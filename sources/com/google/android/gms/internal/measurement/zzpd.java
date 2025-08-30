package com.google.android.gms.internal.measurement;

public final class zzpd implements zzpc {
    public static final zzkl zza;

    static {
        zzkf zzb = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzb.zzd("measurement.client.3p_consent_state_v1", true);
        zza = zzb.zzc("measurement.service.storage_consent_support_version", 203600);
    }

    public final long zza() {
        return ((Long) zza.zzd()).longValue();
    }
}
