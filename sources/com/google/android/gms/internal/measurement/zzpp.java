package com.google.android.gms.internal.measurement;

public final class zzpp implements zzpo {
    public static final zzkl zza;
    public static final zzkl zzb;

    static {
        zzkf zzb2 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzb2.zzd("measurement.collection.event_safelist", true);
        zza = zzb2.zzd("measurement.service.store_null_safelist", true);
        zzb = zzb2.zzd("measurement.service.store_safelist", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zza.zzd()).booleanValue();
    }

    public final boolean zzc() {
        return ((Boolean) zzb.zzd()).booleanValue();
    }
}
