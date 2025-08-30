package com.google.android.gms.internal.measurement;

public final class zzox implements zzow {
    public static final zzkl zza;

    static {
        zzkf zzb = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzb.zzd("measurement.service.ad_impression.convert_value_to_double", true);
        zzb.zzd("measurement.service.separate_public_internal_event_blacklisting", true);
        zzb.zzd("measurement.service.ad_impression", true);
    }

    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
