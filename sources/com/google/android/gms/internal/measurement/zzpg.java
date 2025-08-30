package com.google.android.gms.internal.measurement;

public final class zzpg implements zzpf {
    public static final zzkl zza;
    public static final zzkl zzb;

    static {
        zzkf zzb2 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzb2.zzd("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        zzb2.zzd("measurement.set_default_event_parameters_with_backfill.service", true);
        zzb2.zzc("measurement.id.set_default_event_parameters.fix_service_request_ordering", 0);
        zza = zzb2.zzd("measurement.set_default_event_parameters.fix_app_update_logging", true);
        zzb = zzb2.zzd("measurement.set_default_event_parameters.fix_service_request_ordering", false);
        zzb2.zzd("measurement.set_default_event_parameters.fix_subsequent_launches", true);
    }

    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }

    public final boolean zzb() {
        return ((Boolean) zzb.zzd()).booleanValue();
    }
}
