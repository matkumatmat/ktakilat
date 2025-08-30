package com.google.android.gms.internal.measurement;

public final class zzqn implements zzqm {
    public static final zzkl zza;
    public static final zzkl zzb;
    public static final zzkl zzc;
    public static final zzkl zzd;
    public static final zzkl zze;
    public static final zzkl zzf;
    public static final zzkl zzg;
    public static final zzkl zzh;

    static {
        zzkf zzb2 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzb2.zzd("measurement.rb.attribution.ad_campaign_info", true);
        zzb2.zzd("measurement.rb.attribution.service.bundle_on_backgrounded", true);
        zza = zzb2.zzd("measurement.rb.attribution.client2", true);
        zzb = zzb2.zzd("measurement.rb.attribution.followup1.service", false);
        zzb2.zzd("measurement.rb.attribution.client.get_trigger_uris_async", true);
        zzc = zzb2.zzd("measurement.rb.attribution.service.trigger_uris_high_priority", true);
        zzb2.zzd("measurement.rb.attribution.index_out_of_bounds_fix", true);
        zzd = zzb2.zzd("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", true);
        zze = zzb2.zzd("measurement.rb.attribution.retry_disposition", false);
        zzf = zzb2.zzd("measurement.rb.attribution.service", true);
        zzg = zzb2.zzd("measurement.rb.attribution.enable_trigger_redaction", true);
        zzh = zzb2.zzd("measurement.rb.attribution.uuid_generation", true);
        zzb2.zzc("measurement.id.rb.attribution.retry_disposition", 0);
        zzb2.zzd("measurement.rb.attribution.improved_retry", true);
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

    public final boolean zzd() {
        return ((Boolean) zzc.zzd()).booleanValue();
    }

    public final boolean zze() {
        return ((Boolean) zzd.zzd()).booleanValue();
    }

    public final boolean zzf() {
        return ((Boolean) zze.zzd()).booleanValue();
    }

    public final boolean zzg() {
        return ((Boolean) zzf.zzd()).booleanValue();
    }

    public final boolean zzh() {
        return ((Boolean) zzg.zzd()).booleanValue();
    }

    public final boolean zzi() {
        return ((Boolean) zzh.zzd()).booleanValue();
    }
}
