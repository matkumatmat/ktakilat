package com.google.android.gms.internal.measurement;

public final class zzqb implements zzqa {
    public static final zzkl zza;

    static {
        zzkf zzb = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzb.zzd("measurement.gbraid_campaign.gbraid.client", true);
        zza = zzb.zzd("measurement.gbraid_campaign.stop_lgclid", false);
    }

    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
