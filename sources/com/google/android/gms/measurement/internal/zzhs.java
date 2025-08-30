package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zziy;
import com.google.android.gms.internal.measurement.zzja;
import com.google.android.gms.internal.measurement.zzmq;
import com.google.android.gms.internal.measurement.zzr;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public final class zzhs extends zzor implements zzak {
    @VisibleForTesting
    final Map zza = new ArrayMap();
    @VisibleForTesting
    final Map zzb = new ArrayMap();
    @VisibleForTesting
    final Map zzc = new ArrayMap();
    @VisibleForTesting
    final LruCache zzd = new zzhl(this, 20);
    final zzr zze = new zzhm(this);
    private final Map zzf = new ArrayMap();
    private final Map zzh = new ArrayMap();
    private final Map zzi = new ArrayMap();
    private final Map zzj = new ArrayMap();
    private final Map zzk = new ArrayMap();
    private final Map zzl = new ArrayMap();

    public zzhs(zzpf zzpf) {
        super(zzpf);
    }

    @WorkerThread
    private final void zzE(String str) {
        zzay();
        zzg();
        Preconditions.checkNotEmpty(str);
        Map map = this.zzh;
        if (map.get(str) == null) {
            zzaq zzy = this.zzg.zzj().zzy(str);
            if (zzy == null) {
                this.zzf.put(str, (Object) null);
                this.zzb.put(str, (Object) null);
                this.zza.put(str, (Object) null);
                this.zzc.put(str, (Object) null);
                map.put(str, (Object) null);
                this.zzj.put(str, (Object) null);
                this.zzk.put(str, (Object) null);
                this.zzl.put(str, (Object) null);
                this.zzi.put(str, (Object) null);
                return;
            }
            zzgk zzgk = (zzgk) zzH(str, zzy.zza).zzcl();
            zzF(str, zzgk);
            this.zzf.put(str, zzI((zzgl) zzgk.zzbc()));
            map.put(str, (zzgl) zzgk.zzbc());
            zzG(str, (zzgl) zzgk.zzbc());
            this.zzj.put(str, zzgk.zzh());
            this.zzk.put(str, zzy.zzb);
            this.zzl.put(str, zzy.zzc);
        }
    }

    private final void zzF(String str, zzgk zzgk) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        for (zzgh zza2 : zzgk.zzg()) {
            hashSet.add(zza2.zza());
        }
        for (int i = 0; i < zzgk.zza(); i++) {
            zzgi zzgi = (zzgi) zzgk.zzb(i).zzcl();
            if (zzgi.zza().isEmpty()) {
                e.C(this.zzu, "EventConfig contained null event name");
            } else {
                String zza3 = zzgi.zza();
                String zzb2 = zzjl.zzb(zzgi.zza());
                if (!TextUtils.isEmpty(zzb2)) {
                    zzgi.zzb(zzb2);
                    zzgk.zzc(i, zzgi);
                }
                if (zzgi.zzc() && zzgi.zzd()) {
                    arrayMap.put(zza3, Boolean.TRUE);
                }
                if (zzgi.zze() && zzgi.zzf()) {
                    arrayMap2.put(zzgi.zza(), Boolean.TRUE);
                }
                if (zzgi.zzg()) {
                    if (zzgi.zzh() < 2 || zzgi.zzh() > 65535) {
                        this.zzu.zzaV().zze().zzc("Invalid sampling rate. Event name, sample rate", zzgi.zza(), Integer.valueOf(zzgi.zzh()));
                    } else {
                        arrayMap3.put(zzgi.zza(), Integer.valueOf(zzgi.zzh()));
                    }
                }
            }
        }
        this.zza.put(str, hashSet);
        this.zzb.put(str, arrayMap);
        this.zzc.put(str, arrayMap2);
        this.zzi.put(str, arrayMap3);
    }

    @WorkerThread
    private final void zzG(String str, zzgl zzgl) {
        if (zzgl.zzj() != 0) {
            zzib zzib = this.zzu;
            zzib.zzaV().zzk().zzb("EES programs found", Integer.valueOf(zzgl.zzj()));
            zzja zzja = (zzja) zzgl.zzi().get(0);
            try {
                zzc zzc2 = new zzc();
                zzc2.zza("internal.remoteConfig", new zzhr(this, str));
                zzc2.zza("internal.appMetadata", new zzho(this, str));
                zzc2.zza("internal.logger", new zzhp(this));
                zzc2.zzf(zzja);
                this.zzd.put(str, zzc2);
                zzib.zzaV().zzk().zzc("EES program loaded for appId, activities", str, Integer.valueOf(zzja.zzb().zzb()));
                for (zziy zza2 : zzja.zzb().zza()) {
                    zzib.zzaV().zzk().zzb("EES program activity", zza2.zza());
                }
            } catch (zzd unused) {
                this.zzu.zzaV().zzb().zzb("Failed to load EES program. appId", str);
            }
        } else {
            this.zzd.remove(str);
        }
    }

    @WorkerThread
    private final zzgl zzH(String str, byte[] bArr) {
        Long l;
        if (bArr == null) {
            return zzgl.zzs();
        }
        try {
            zzgl zzgl = (zzgl) ((zzgk) zzpj.zzw(zzgl.zzr(), bArr)).zzbc();
            zzgr zzk2 = this.zzu.zzaV().zzk();
            String str2 = null;
            if (zzgl.zza()) {
                l = Long.valueOf(zzgl.zzb());
            } else {
                l = null;
            }
            if (zzgl.zzc()) {
                str2 = zzgl.zzd();
            }
            zzk2.zzc("Parsed config. version, gmp_app_id", l, str2);
            return zzgl;
        } catch (zzmq e) {
            this.zzu.zzaV().zze().zzc("Unable to merge remote config. appId", zzgt.zzl(str), e);
            return zzgl.zzs();
        } catch (RuntimeException e2) {
            this.zzu.zzaV().zze().zzc("Unable to merge remote config. appId", zzgt.zzl(str), e2);
            return zzgl.zzs();
        }
    }

    private static final Map zzI(zzgl zzgl) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzgl != null) {
            for (zzgt zzgt : zzgl.zze()) {
                arrayMap.put(zzgt.zza(), zzgt.zzb());
            }
        }
        return arrayMap;
    }

    private static final zzjj zzJ(int i) {
        int i2 = i - 1;
        if (i2 == 1) {
            return zzjj.AD_STORAGE;
        }
        if (i2 == 2) {
            return zzjj.ANALYTICS_STORAGE;
        }
        if (i2 == 3) {
            return zzjj.AD_USER_DATA;
        }
        if (i2 != 4) {
            return null;
        }
        return zzjj.AD_PERSONALIZATION;
    }

    @WorkerThread
    public final zzjh zzA(String str, zzjj zzjj) {
        zzg();
        zzE(str);
        zzgf zzx = zzx(str);
        if (zzx == null) {
            return zzjh.UNINITIALIZED;
        }
        for (zzfu zzfu : zzx.zzf()) {
            if (zzJ(zzfu.zzb()) == zzjj) {
                int zzc2 = zzfu.zzc() - 1;
                if (zzc2 == 1) {
                    return zzjh.GRANTED;
                }
                if (zzc2 != 2) {
                    return zzjh.UNINITIALIZED;
                }
                return zzjh.DENIED;
            }
        }
        return zzjh.UNINITIALIZED;
    }

    @WorkerThread
    public final boolean zzB(String str) {
        zzg();
        zzE(str);
        zzgf zzx = zzx(str);
        if (zzx == null) {
            return false;
        }
        for (zzfu zzfu : zzx.zza()) {
            if (zzfu.zzb() == 3 && zzfu.zzd() == 3) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ zzc zzC(String str) {
        zzay();
        Preconditions.checkNotEmpty(str);
        zzaq zzy = this.zzg.zzj().zzy(str);
        if (zzy == null) {
            return null;
        }
        this.zzu.zzaV().zzk().zzb("Populate EES config from database on cache miss. appId", str);
        zzG(str, zzH(str, zzy.zza));
        return (zzc) this.zzd.snapshot().get(str);
    }

    public final /* synthetic */ Map zzD() {
        return this.zzf;
    }

    @WorkerThread
    public final String zza(String str, String str2) {
        zzg();
        zzE(str);
        Map map = (Map) this.zzf.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    @WorkerThread
    public final zzgl zzb(String str) {
        zzay();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzE(str);
        return (zzgl) this.zzh.get(str);
    }

    public final boolean zzbb() {
        return false;
    }

    @WorkerThread
    public final String zzc(String str) {
        zzg();
        zzE(str);
        return (String) this.zzj.get(str);
    }

    @WorkerThread
    public final String zzd(String str) {
        zzg();
        return (String) this.zzk.get(str);
    }

    @WorkerThread
    public final String zze(String str) {
        zzg();
        return (String) this.zzl.get(str);
    }

    @WorkerThread
    public final void zzf(String str) {
        zzg();
        this.zzk.put(str, (Object) null);
    }

    @WorkerThread
    public final void zzh(String str) {
        zzg();
        this.zzh.remove(str);
    }

    @WorkerThread
    public final boolean zzi(String str, byte[] bArr, String str2, String str3) {
        zzay();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzgk zzgk = (zzgk) zzH(str, bArr).zzcl();
        zzF(str, zzgk);
        zzG(str, (zzgl) zzgk.zzbc());
        this.zzh.put(str, (zzgl) zzgk.zzbc());
        this.zzj.put(str, zzgk.zzh());
        this.zzk.put(str, str2);
        this.zzl.put(str, str3);
        this.zzf.put(str, zzI((zzgl) zzgk.zzbc()));
        this.zzg.zzj().zzag(str, new ArrayList(zzgk.zzd()));
        try {
            zzgk.zze();
            bArr = ((zzgl) zzgk.zzbc()).zzcc();
        } catch (RuntimeException e) {
            this.zzu.zzaV().zze().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzgt.zzl(str), e);
        }
        zzav zzj2 = this.zzg.zzj();
        Preconditions.checkNotEmpty(str);
        zzj2.zzg();
        zzj2.zzay();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (((long) zzj2.zze().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzj2.zzu.zzaV().zzb().zzb("Failed to update remote config (got 0). appId", zzgt.zzl(str));
            }
        } catch (SQLiteException e2) {
            zzj2.zzu.zzaV().zzb().zzc("Error storing remote config. appId", zzgt.zzl(str), e2);
        }
        zzgk.zzf();
        this.zzh.put(str, (zzgl) zzgk.zzbc());
        return true;
    }

    @WorkerThread
    public final boolean zzj(String str, String str2) {
        Boolean bool;
        zzg();
        zzE(str);
        if (zzn(str) && zzpo.zzZ(str2)) {
            return true;
        }
        if (zzo(str) && zzpo.zzh(str2)) {
            return true;
        }
        Map map = (Map) this.zzb.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    public final boolean zzk(String str, String str2) {
        Boolean bool;
        zzg();
        zzE(str);
        if ("ecommerce_purchase".equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map map = (Map) this.zzc.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    public final Set zzl(String str) {
        zzg();
        zzE(str);
        return (Set) this.zza.get(str);
    }

    @WorkerThread
    public final int zzm(String str, String str2) {
        Integer num;
        zzg();
        zzE(str);
        Map map = (Map) this.zzi.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final boolean zzn(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    public final boolean zzo(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_public"));
    }

    @WorkerThread
    public final boolean zzp(String str) {
        zzg();
        zzE(str);
        Map map = this.zza;
        if (map.get(str) == null) {
            return false;
        }
        if (((Set) map.get(str)).contains("device_model") || ((Set) map.get(str)).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM)) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final boolean zzq(String str) {
        zzg();
        zzE(str);
        Map map = this.zza;
        if (map.get(str) == null) {
            return false;
        }
        if (((Set) map.get(str)).contains("os_version") || ((Set) map.get(str)).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM)) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final boolean zzr(String str) {
        zzg();
        zzE(str);
        Map map = this.zza;
        if (map.get(str) == null || !((Set) map.get(str)).contains(AccessToken.USER_ID_KEY)) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final boolean zzs(String str) {
        zzg();
        zzE(str);
        Map map = this.zza;
        if (map.get(str) == null || !((Set) map.get(str)).contains("google_signals")) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final boolean zzt(String str) {
        zzg();
        zzE(str);
        Map map = this.zza;
        if (map.get(str) == null || !((Set) map.get(str)).contains("app_instance_id")) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final boolean zzu(String str) {
        zzg();
        zzE(str);
        Map map = this.zza;
        if (map.get(str) == null || !((Set) map.get(str)).contains("enhanced_user_id")) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final boolean zzv(String str, zzjj zzjj) {
        zzg();
        zzE(str);
        zzgf zzx = zzx(str);
        if (zzx == null) {
            return false;
        }
        Iterator it = zzx.zza().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzfu zzfu = (zzfu) it.next();
            if (zzjj == zzJ(zzfu.zzb())) {
                if (zzfu.zzc() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    @WorkerThread
    public final zzjj zzw(String str, zzjj zzjj) {
        zzg();
        zzE(str);
        zzgf zzx = zzx(str);
        if (zzx == null) {
            return null;
        }
        for (zzfw zzfw : zzx.zzb()) {
            if (zzjj == zzJ(zzfw.zzb())) {
                return zzJ(zzfw.zzc());
            }
        }
        return null;
    }

    @WorkerThread
    public final zzgf zzx(String str) {
        zzg();
        zzE(str);
        zzgl zzb2 = zzb(str);
        if (zzb2 == null || !zzb2.zzn()) {
            return null;
        }
        return zzb2.zzo();
    }

    @WorkerThread
    public final boolean zzy(String str) {
        zzg();
        zzE(str);
        zzgf zzx = zzx(str);
        if (zzx != null && zzx.zzd() && !zzx.zze()) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final SortedSet zzz(String str) {
        zzg();
        zzE(str);
        TreeSet treeSet = new TreeSet();
        zzgf zzx = zzx(str);
        if (zzx != null) {
            for (zzgc zza2 : zzx.zzc()) {
                treeSet.add(zza2.zza());
            }
        }
        return treeSet;
    }
}
