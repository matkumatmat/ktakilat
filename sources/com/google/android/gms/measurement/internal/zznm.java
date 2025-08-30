package com.google.android.gms.measurement.internal;

import android.content.pm.PackageManager;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public final class zznm extends zzor {
    public final zzhd zza;
    public final zzhd zzb;
    public final zzhd zzc;
    public final zzhd zzd;
    public final zzhd zze;
    public final zzhd zzf;
    private final Map zzh = new HashMap();

    public zznm(zzpf zzpf) {
        super(zzpf);
        zzhg zzd2 = this.zzu.zzd();
        Objects.requireNonNull(zzd2);
        this.zza = new zzhd(zzd2, "last_delete_stale", 0);
        zzhg zzd3 = this.zzu.zzd();
        Objects.requireNonNull(zzd3);
        this.zzb = new zzhd(zzd3, "last_delete_stale_batch", 0);
        zzhg zzd4 = this.zzu.zzd();
        Objects.requireNonNull(zzd4);
        this.zzc = new zzhd(zzd4, "backoff", 0);
        zzhg zzd5 = this.zzu.zzd();
        Objects.requireNonNull(zzd5);
        this.zzd = new zzhd(zzd5, "last_upload", 0);
        zzhg zzd6 = this.zzu.zzd();
        Objects.requireNonNull(zzd6);
        this.zze = new zzhd(zzd6, "last_upload_attempt", 0);
        zzhg zzd7 = this.zzu.zzd();
        Objects.requireNonNull(zzd7);
        this.zzf = new zzhd(zzd7, "midnight_offset", 0);
    }

    public final boolean zzbb() {
        return false;
    }

    @WorkerThread
    public final Pair zzc(String str, zzjk zzjk) {
        if (zzjk.zzo(zzjj.AD_STORAGE)) {
            return zzd(str);
        }
        return new Pair("", Boolean.FALSE);
    }

    @WorkerThread
    @Deprecated
    public final Pair zzd(String str) {
        zznl zznl;
        AdvertisingIdClient.Info info;
        zzg();
        zzib zzib = this.zzu;
        long elapsedRealtime = zzib.zzaZ().elapsedRealtime();
        zznl zznl2 = (zznl) this.zzh.get(str);
        if (zznl2 != null && elapsedRealtime < zznl2.zzc) {
            return new Pair(zznl2.zza, Boolean.valueOf(zznl2.zzb));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long zzl = zzib.zzc().zzl(str, zzfx.zza) + elapsedRealtime;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(zzib.zzaY());
        } catch (PackageManager.NameNotFoundException unused) {
            info = null;
            if (zznl2 != null) {
                try {
                    if (elapsedRealtime < zznl2.zzc + this.zzu.zzc().zzl(str, zzfx.zzb)) {
                        return new Pair(zznl2.zza, Boolean.valueOf(zznl2.zzb));
                    }
                } catch (Exception e) {
                    this.zzu.zzaV().zzj().zzb("Unable to get advertising id", e);
                    zznl = new zznl("", false, zzl);
                }
            }
        }
        if (info == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String id = info.getId();
        if (id != null) {
            zznl = new zznl(id, info.isLimitAdTrackingEnabled(), zzl);
        } else {
            zznl = new zznl("", info.isLimitAdTrackingEnabled(), zzl);
        }
        this.zzh.put(str, zznl);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(zznl.zza, Boolean.valueOf(zznl.zzb));
    }

    @WorkerThread
    @Deprecated
    public final String zzf(String str, boolean z) {
        String str2;
        zzg();
        if (z) {
            str2 = (String) zzd(str).first;
        } else {
            str2 = "00000000-0000-0000-0000-000000000000";
        }
        MessageDigest zzO = zzpo.zzO();
        if (zzO == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzO.digest(str2.getBytes()))});
    }
}
