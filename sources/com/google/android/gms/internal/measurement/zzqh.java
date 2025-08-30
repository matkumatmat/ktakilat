package com.google.android.gms.internal.measurement;

public final class zzqh implements zzqg {
    public static final zzkl zza;

    static {
        zzkf zzb = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzb.zzd("measurement.sdk.collection.enable_extend_user_property_size", true);
        zza = zzb.zzd("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzb.zzc("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }

    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
