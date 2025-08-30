package com.google.android.gms.internal.measurement;

import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.idl.face.platform.FaceEnvironment;
import org.apache.commons.lang3.time.DateUtils;

public final class zzpa implements zzoz {
    public static final zzkl zzA;
    public static final zzkl zzB;
    public static final zzkl zzC;
    public static final zzkl zzD;
    public static final zzkl zzE;
    public static final zzkl zzF;
    public static final zzkl zzG;
    public static final zzkl zzH;
    public static final zzkl zzI;
    public static final zzkl zzJ;
    public static final zzkl zzK;
    public static final zzkl zzL;
    public static final zzkl zzM;
    public static final zzkl zzN;
    public static final zzkl zzO;
    public static final zzkl zzP;
    public static final zzkl zzQ;
    public static final zzkl zzR;
    public static final zzkl zzS;
    public static final zzkl zzT;
    public static final zzkl zzU;
    public static final zzkl zzV;
    public static final zzkl zzW;
    public static final zzkl zzX;
    public static final zzkl zzY;
    public static final zzkl zzZ;
    public static final zzkl zza;
    public static final zzkl zzaa;
    public static final zzkl zzab;
    public static final zzkl zzac;
    public static final zzkl zzad;
    public static final zzkl zzae;
    public static final zzkl zzaf;
    public static final zzkl zzag;
    public static final zzkl zzah;
    public static final zzkl zzai;
    public static final zzkl zzaj;
    public static final zzkl zzak;
    public static final zzkl zzal;
    public static final zzkl zzam;
    public static final zzkl zzan;
    public static final zzkl zzao;
    public static final zzkl zzap;
    public static final zzkl zzaq;
    public static final zzkl zzar;
    public static final zzkl zzas;
    public static final zzkl zzat;
    public static final zzkl zzau;
    public static final zzkl zzav;
    public static final zzkl zzaw;
    public static final zzkl zzb;
    public static final zzkl zzc;
    public static final zzkl zzd;
    public static final zzkl zze;
    public static final zzkl zzf;
    public static final zzkl zzg;
    public static final zzkl zzh;
    public static final zzkl zzi;
    public static final zzkl zzj;
    public static final zzkl zzk;
    public static final zzkl zzl;
    public static final zzkl zzm;
    public static final zzkl zzn;
    public static final zzkl zzo;
    public static final zzkl zzp;
    public static final zzkl zzq;
    public static final zzkl zzr;
    public static final zzkl zzs;
    public static final zzkl zzt;
    public static final zzkl zzu;
    public static final zzkl zzv;
    public static final zzkl zzw;
    public static final zzkl zzx;
    public static final zzkl zzy;
    public static final zzkl zzz;

    static {
        zzkf zzb2 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzb2.zzc("measurement.ad_id_cache_time", 10000);
        zzb = zzb2.zzc("measurement.app_uninstalled_additional_ad_id_cache_time", DateUtils.MILLIS_PER_HOUR);
        zzc = zzb2.zzd("measurement.config.bundle_for_all_apps_on_backgrounded", true);
        zzd = zzb2.zzc("measurement.max_bundles_per_iteration", 100);
        zze = zzb2.zzf("measurement.gbraid_campaign.campaign_params_triggering_info_update", "gclid,gbraid,gad_campaignid");
        zzf = zzb2.zzc("measurement.config.cache_time", DateUtils.MILLIS_PER_DAY);
        zzb2.zzf("measurement.log_tag", "FA");
        zzg = zzb2.zzf("measurement.config.url_authority", "app-measurement.com");
        zzh = zzb2.zzf("measurement.config.url_scheme", "https");
        zzi = zzb2.zzc("measurement.upload.debug_upload_interval", 1000);
        zzb2.zzd("measurement.config.default_flag_values", true);
        zzj = zzb2.zzc("measurement.session.engagement_interval", DateUtils.MILLIS_PER_HOUR);
        zzk = zzb2.zzf("measurement.rb.attribution.event_params", "value|currency");
        zzl = zzb2.zzf("measurement.edpb.events_cached_in_no_data_mode", "_f,_v,_cmp");
        zzm = zzb2.zzc("measurement.upload.google_signal_max_queue_time", 605000);
        zzn = zzb2.zzf("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d");
        zzo = zzb2.zzc("measurement.lifetimevalue.max_currency_tracked", 4);
        zzp = zzb2.zzc("measurement.dma_consent.max_daily_dcu_realtime_events", 1);
        zzq = zzb2.zzc("measurement.upload.max_event_parameter_value_length", 500);
        zzr = zzb2.zzc("measurement.store.max_stored_events_per_app", 100000);
        zzs = zzb2.zzc("measurement.experiment.max_ids", 50);
        zzt = zzb2.zzc("measurement.audience.filter_result_max_count", 200);
        zzu = zzb2.zzc("measurement.upload.max_item_scoped_custom_parameters", 27);
        zzv = zzb2.zzc("measurement.rb.max_trigger_registrations_per_day", 1000);
        zzw = zzb2.zzc("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0);
        zzx = zzb2.zzc("measurement.rb.attribution.client.min_ad_services_version", 7);
        zzy = zzb2.zzc("measurement.alarm_manager.minimum_interval", DateUtils.MILLIS_PER_MINUTE);
        zzz = zzb2.zzc("measurement.upload.minimum_delay", 500);
        zzA = zzb2.zzc("measurement.monitoring.sample_period_millis", DateUtils.MILLIS_PER_DAY);
        zzB = zzb2.zzc("measurement.rb.attribution.notify_app_delay_millis", 3000);
        zzC = zzb2.zzd("measurement.config.notify_trigger_uris_on_backgrounded", true);
        zzb2.zzc("measurement.id.rb.attribution.app_allowlist", 0);
        zzD = zzb2.zzf("measurement.rb.attribution.app_allowlist", "com.labpixies.flood");
        zzE = zzb2.zzc("measurement.upload.realtime_upload_interval", 10000);
        zzF = zzb2.zzc("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        zzb2.zzc("measurement.config.cache_time.service", DateUtils.MILLIS_PER_HOUR);
        zzG = zzb2.zzc("measurement.service_client.idle_disconnect_millis", 5000);
        zzb2.zzf("measurement.log_tag.service", "FA-SVC");
        zzH = zzb2.zzc("measurement.service_client.reconnect_millis", 1000);
        zzb2.zzf("measurement.sgtm.app_allowlist", "*");
        zzI = zzb2.zzc("measurement.sgtm.batch.long_queuing_threshold", 240000);
        zzJ = zzb2.zzc("measurement.sgtm.batch.retry_interval", 1800000);
        zzK = zzb2.zzc("measurement.sgtm.batch.retry_max_count", 10);
        zzL = zzb2.zzc("measurement.sgtm.batch.retry_max_wait", 21600000);
        zzM = zzb2.zzf("measurement.sgtm.service_upload_apps_list", "");
        zzN = zzb2.zzf("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504");
        zzO = zzb2.zzc("measurement.sgtm.upload.batches_retrieval_limit", 5);
        zzP = zzb2.zzc("measurement.sgtm.upload.max_queued_batches", 5000);
        zzQ = zzb2.zzc("measurement.sgtm.upload.min_delay_after_background", 600000);
        zzR = zzb2.zzc("measurement.sgtm.upload.min_delay_after_broadcast", 1000);
        zzS = zzb2.zzc("measurement.sgtm.upload.min_delay_after_startup", 5000);
        zzT = zzb2.zzc("measurement.sgtm.upload.retry_interval", 600000);
        zzU = zzb2.zzc("measurement.sgtm.upload.retry_max_wait", 21600000);
        zzV = zzb2.zzc("measurement.upload.stale_data_deletion_interval", DateUtils.MILLIS_PER_DAY);
        zzW = zzb2.zzc("measurement.rb.attribution.max_retry_delay_seconds", 16);
        zzX = zzb2.zzc("measurement.rb.attribution.client.min_time_after_boot_seconds", 90);
        zzY = zzb2.zzf("measurement.rb.attribution.uri_authority", "google-analytics.com");
        zzZ = zzb2.zzc("measurement.rb.attribution.max_queue_time", 864000000);
        zzaa = zzb2.zzf("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion");
        zzab = zzb2.zzf("measurement.rb.attribution.query_parameters_to_remove", "");
        zzac = zzb2.zzf("measurement.rb.attribution.uri_scheme", "https");
        zzad = zzb2.zzc("measurement.sdk.attribution.cache.ttl", 604800000);
        zzae = zzb2.zzc("measurement.redaction.app_instance_id.ttl", 7200000);
        zzaf = zzb2.zzc("measurement.upload.backoff_period", 43200000);
        zzag = zzb2.zzc("measurement.upload.initial_upload_delay_time", FaceEnvironment.TIME_DETECT_MODULE);
        zzah = zzb2.zzc("measurement.upload.interval", DateUtils.MILLIS_PER_HOUR);
        zzai = zzb2.zzc("measurement.upload.max_bundle_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzaj = zzb2.zzc("measurement.upload.max_bundles", 100);
        zzak = zzb2.zzc("measurement.upload.max_conversions_per_day", 500);
        zzal = zzb2.zzc("measurement.upload.max_error_events_per_day", 1000);
        zzam = zzb2.zzc("measurement.upload.max_events_per_bundle", 1000);
        zzan = zzb2.zzc("measurement.upload.max_events_per_day", 100000);
        zzao = zzb2.zzc("measurement.upload.max_public_events_per_day", 50000);
        zzap = zzb2.zzc("measurement.upload.max_queue_time", 518400000);
        zzaq = zzb2.zzc("measurement.upload.max_realtime_events_per_day", 10);
        zzar = zzb2.zzc("measurement.upload.max_batch_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzas = zzb2.zzc("measurement.upload.retry_count", 6);
        zzat = zzb2.zzc("measurement.upload.retry_time", 1800000);
        zzau = zzb2.zzf("measurement.upload.url", "https://app-measurement.com/a");
        zzav = zzb2.zzc("measurement.upload.window_interval", DateUtils.MILLIS_PER_HOUR);
        zzaw = zzb2.zzf("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot");
    }

    public final long zzA() {
        return ((Long) zzA.zzd()).longValue();
    }

    public final long zzB() {
        return ((Long) zzB.zzd()).longValue();
    }

    public final boolean zzC() {
        return ((Boolean) zzC.zzd()).booleanValue();
    }

    public final String zzD() {
        return (String) zzD.zzd();
    }

    public final long zzE() {
        return ((Long) zzE.zzd()).longValue();
    }

    public final long zzF() {
        return ((Long) zzF.zzd()).longValue();
    }

    public final long zzG() {
        return ((Long) zzG.zzd()).longValue();
    }

    public final long zzH() {
        return ((Long) zzH.zzd()).longValue();
    }

    public final long zzI() {
        return ((Long) zzI.zzd()).longValue();
    }

    public final long zzJ() {
        return ((Long) zzJ.zzd()).longValue();
    }

    public final long zzK() {
        return ((Long) zzK.zzd()).longValue();
    }

    public final long zzL() {
        return ((Long) zzL.zzd()).longValue();
    }

    public final String zzM() {
        return (String) zzM.zzd();
    }

    public final String zzN() {
        return (String) zzN.zzd();
    }

    public final long zzO() {
        return ((Long) zzO.zzd()).longValue();
    }

    public final long zzP() {
        return ((Long) zzP.zzd()).longValue();
    }

    public final long zzQ() {
        return ((Long) zzQ.zzd()).longValue();
    }

    public final long zzR() {
        return ((Long) zzR.zzd()).longValue();
    }

    public final long zzS() {
        return ((Long) zzS.zzd()).longValue();
    }

    public final long zzT() {
        return ((Long) zzT.zzd()).longValue();
    }

    public final long zzU() {
        return ((Long) zzU.zzd()).longValue();
    }

    public final long zzV() {
        return ((Long) zzV.zzd()).longValue();
    }

    public final long zzW() {
        return ((Long) zzW.zzd()).longValue();
    }

    public final long zzX() {
        return ((Long) zzX.zzd()).longValue();
    }

    public final String zzY() {
        return (String) zzY.zzd();
    }

    public final long zzZ() {
        return ((Long) zzZ.zzd()).longValue();
    }

    public final long zza() {
        return ((Long) zza.zzd()).longValue();
    }

    public final String zzaa() {
        return (String) zzaa.zzd();
    }

    public final String zzab() {
        return (String) zzab.zzd();
    }

    public final String zzac() {
        return (String) zzac.zzd();
    }

    public final long zzad() {
        return ((Long) zzad.zzd()).longValue();
    }

    public final long zzae() {
        return ((Long) zzae.zzd()).longValue();
    }

    public final long zzaf() {
        return ((Long) zzaf.zzd()).longValue();
    }

    public final long zzag() {
        return ((Long) zzag.zzd()).longValue();
    }

    public final long zzah() {
        return ((Long) zzah.zzd()).longValue();
    }

    public final long zzai() {
        return ((Long) zzai.zzd()).longValue();
    }

    public final long zzaj() {
        return ((Long) zzaj.zzd()).longValue();
    }

    public final long zzak() {
        return ((Long) zzak.zzd()).longValue();
    }

    public final long zzal() {
        return ((Long) zzal.zzd()).longValue();
    }

    public final long zzam() {
        return ((Long) zzam.zzd()).longValue();
    }

    public final long zzan() {
        return ((Long) zzan.zzd()).longValue();
    }

    public final long zzao() {
        return ((Long) zzao.zzd()).longValue();
    }

    public final long zzap() {
        return ((Long) zzap.zzd()).longValue();
    }

    public final long zzaq() {
        return ((Long) zzaq.zzd()).longValue();
    }

    public final long zzar() {
        return ((Long) zzar.zzd()).longValue();
    }

    public final long zzas() {
        return ((Long) zzas.zzd()).longValue();
    }

    public final long zzat() {
        return ((Long) zzat.zzd()).longValue();
    }

    public final String zzau() {
        return (String) zzau.zzd();
    }

    public final long zzav() {
        return ((Long) zzav.zzd()).longValue();
    }

    public final String zzaw() {
        return (String) zzaw.zzd();
    }

    public final long zzb() {
        return ((Long) zzb.zzd()).longValue();
    }

    public final boolean zzc() {
        return ((Boolean) zzc.zzd()).booleanValue();
    }

    public final long zzd() {
        return ((Long) zzd.zzd()).longValue();
    }

    public final String zze() {
        return (String) zze.zzd();
    }

    public final long zzf() {
        return ((Long) zzf.zzd()).longValue();
    }

    public final String zzg() {
        return (String) zzg.zzd();
    }

    public final String zzh() {
        return (String) zzh.zzd();
    }

    public final long zzi() {
        return ((Long) zzi.zzd()).longValue();
    }

    public final long zzj() {
        return ((Long) zzj.zzd()).longValue();
    }

    public final String zzk() {
        return (String) zzk.zzd();
    }

    public final String zzl() {
        return (String) zzl.zzd();
    }

    public final long zzm() {
        return ((Long) zzm.zzd()).longValue();
    }

    public final String zzn() {
        return (String) zzn.zzd();
    }

    public final long zzo() {
        return ((Long) zzo.zzd()).longValue();
    }

    public final long zzp() {
        return ((Long) zzp.zzd()).longValue();
    }

    public final long zzq() {
        return ((Long) zzq.zzd()).longValue();
    }

    public final long zzr() {
        return ((Long) zzr.zzd()).longValue();
    }

    public final long zzs() {
        return ((Long) zzs.zzd()).longValue();
    }

    public final long zzt() {
        return ((Long) zzt.zzd()).longValue();
    }

    public final long zzu() {
        return ((Long) zzu.zzd()).longValue();
    }

    public final long zzv() {
        return ((Long) zzv.zzd()).longValue();
    }

    public final long zzw() {
        return ((Long) zzw.zzd()).longValue();
    }

    public final long zzx() {
        return ((Long) zzx.zzd()).longValue();
    }

    public final long zzy() {
        return ((Long) zzy.zzd()).longValue();
    }

    public final long zzz() {
        return ((Long) zzz.zzd()).longValue();
    }
}
