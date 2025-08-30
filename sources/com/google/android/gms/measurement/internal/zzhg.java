package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.annotations.VisibleForTesting;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class zzhg extends zzje {
    static final Pair zza = new Pair("", 0L);
    public zzhe zzb;
    public final zzhd zzc = new zzhd(this, "first_open_time", 0);
    public final zzhd zzd = new zzhd(this, "app_install_time", 0);
    public final zzhf zze = new zzhf(this, "app_instance_id", (String) null);
    public final zzhd zzf = new zzhd(this, "session_timeout", 1800000);
    public final zzhb zzg = new zzhb(this, "start_new_session", true);
    public final zzhf zzh = new zzhf(this, "non_personalized_ads", (String) null);
    public final zzhc zzi = new zzhc(this, "last_received_uri_timestamps_by_source", (Bundle) null);
    public final zzhb zzj = new zzhb(this, "allow_remote_dynamite", false);
    public final zzhd zzk = new zzhd(this, "last_pause_time", 0);
    public final zzhd zzl = new zzhd(this, "session_id", 0);
    public boolean zzm;
    public final zzhb zzn = new zzhb(this, "app_backgrounded", false);
    public final zzhb zzo = new zzhb(this, "deep_link_retrieval_complete", false);
    public final zzhd zzp = new zzhd(this, "deep_link_retrieval_attempts", 0);
    public final zzhf zzq = new zzhf(this, "firebase_feature_rollouts", (String) null);
    public final zzhf zzr = new zzhf(this, "deferred_attribution_cache", (String) null);
    public final zzhd zzs = new zzhd(this, "deferred_attribution_cache_timestamp", 0);
    public final zzhc zzt = new zzhc(this, "default_event_parameters", (Bundle) null);
    private SharedPreferences zzv;
    private SharedPreferences zzw;
    private String zzx;
    private boolean zzy;
    private long zzz;

    public zzhg(zzib zzib) {
        super(zzib);
    }

    public final boolean zza() {
        return true;
    }

    @WorkerThread
    public final Pair zzb(String str) {
        zzg();
        if (!zzl().zzo(zzjj.AD_STORAGE)) {
            return new Pair("", Boolean.FALSE);
        }
        zzib zzib = this.zzu;
        long elapsedRealtime = zzib.zzaZ().elapsedRealtime();
        String str2 = this.zzx;
        if (str2 != null && elapsedRealtime < this.zzz) {
            return new Pair(str2, Boolean.valueOf(this.zzy));
        }
        this.zzz = zzib.zzc().zzl(str, zzfx.zza) + elapsedRealtime;
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzib.zzaY());
            this.zzx = "";
            String id = advertisingIdInfo.getId();
            if (id != null) {
                this.zzx = id;
            }
            this.zzy = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e) {
            this.zzu.zzaV().zzj().zzb("Unable to get advertising id", e);
            this.zzx = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.zzx, Boolean.valueOf(this.zzy));
    }

    @WorkerThread
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    public final void zzba() {
        zzib zzib = this.zzu;
        SharedPreferences sharedPreferences = zzib.zzaY().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzv = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzm = z;
        if (!z) {
            SharedPreferences.Editor edit = this.zzv.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        zzib.zzc();
        this.zzb = new zzhe(this, "health_monitor", Math.max(0, ((Long) zzfx.zzc.zzb((Object) null)).longValue()), (byte[]) null);
    }

    @WorkerThread
    @VisibleForTesting
    public final SharedPreferences zzd() {
        zzg();
        zzw();
        Preconditions.checkNotNull(this.zzv);
        return this.zzv;
    }

    @WorkerThread
    public final SharedPreferences zze() {
        zzg();
        zzw();
        if (this.zzw == null) {
            zzib zzib = this.zzu;
            String valueOf = String.valueOf(zzib.zzaY().getPackageName());
            zzgr zzk2 = zzib.zzaV().zzk();
            String concat = valueOf.concat("_preferences");
            zzk2.zzb("Default prefs file", concat);
            this.zzw = zzib.zzaY().getSharedPreferences(concat, 0);
        }
        return this.zzw;
    }

    public final SparseArray zzf() {
        Bundle zza2 = this.zzi.zza();
        int[] intArray = zza2.getIntArray("uriSources");
        long[] longArray = zza2.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            this.zzu.zzaV().zzb().zza("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < intArray.length; i++) {
            sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
        }
        return sparseArray;
    }

    @WorkerThread
    public final void zzh(Boolean bool) {
        zzg();
        SharedPreferences.Editor edit = zzd().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    @WorkerThread
    public final Boolean zzi() {
        zzg();
        if (zzd().contains("measurement_enabled")) {
            return Boolean.valueOf(zzd().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    @WorkerThread
    public final zzaz zzj() {
        zzg();
        return zzaz.zzg(zzd().getString("dma_consent_settings", (String) null));
    }

    @WorkerThread
    public final boolean zzk(int i) {
        return zzjk.zzu(i, zzd().getInt("consent_source", 100));
    }

    @WorkerThread
    public final zzjk zzl() {
        zzg();
        return zzjk.zzf(zzd().getString("consent_settings", "G1"), zzd().getInt("consent_source", 100));
    }

    @WorkerThread
    public final boolean zzm(zzoc zzoc) {
        zzg();
        String string = zzd().getString("stored_tcf_param", "");
        String zza2 = zzoc.zza();
        if (zza2.equals(string)) {
            return false;
        }
        SharedPreferences.Editor edit = zzd().edit();
        edit.putString("stored_tcf_param", zza2);
        edit.apply();
        return true;
    }

    @WorkerThread
    public final void zzn(boolean z) {
        zzg();
        this.zzu.zzaV().zzk().zzb("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzd().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    @WorkerThread
    public final boolean zzo() {
        SharedPreferences sharedPreferences = this.zzv;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    public final boolean zzp(long j) {
        if (j - this.zzf.zza() > this.zzk.zza()) {
            return true;
        }
        return false;
    }
}
