package com.google.android.gms.internal.measurement;

public final class zzqz implements zzqy {
    public static final zzkl zza;

    static {
        zzkf zzb = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzb.zzd("measurement.client.sessions.enable_fix_background_engagement", false);
        zzb.zzd("measurement.client.sessions.enable_pause_engagement_in_background", true);
        zzb.zzc("measurement.id.client.sessions.enable_fix_background_engagement", 0);
    }

    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
