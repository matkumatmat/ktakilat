package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzkn implements zzju {
    @GuardedBy("SharedPreferencesLoader.class")
    private static final Map zza = new ArrayMap();
    private final SharedPreferences zzb;
    private SharedPreferences.OnSharedPreferenceChangeListener zzc;
    private final Object zzd = new Object();
    private volatile Map zze;
    @GuardedBy("this")
    private final List zzf = new ArrayList();

    private zzkn(SharedPreferences sharedPreferences, Runnable runnable) {
        this.zzb = sharedPreferences;
    }

    public static zzkn zza(Context context, String str, Runnable runnable) {
        zzkn zzkn;
        SharedPreferences zza2;
        if (zzjm.zza() && !str.startsWith("direct_boot:") && !zzjm.zzc(context)) {
            return null;
        }
        synchronized (zzkn.class) {
            Map map = zza;
            zzkn = (zzkn) map.get(str);
            if (zzkn == null) {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    if (str.startsWith("direct_boot:")) {
                        if (zzjm.zza()) {
                            context = context.createDeviceProtectedStorageContext();
                        }
                        zza2 = zzcf.zza(context, str.substring(12), 0, zzcb.zza);
                    } else {
                        zza2 = zzcf.zza(context, str, 0, zzcb.zza);
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    zzkn = new zzkn(zza2, runnable);
                    zzkm zzkm = new zzkm(zzkn);
                    zzkn.zzc = zzkm;
                    zzkn.zzb.registerOnSharedPreferenceChangeListener(zzkm);
                    map.put(str, zzkn);
                } catch (Throwable th) {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    throw th;
                }
            }
        }
        return zzkn;
    }

    public static synchronized void zzb() {
        synchronized (zzkn.class) {
            try {
                Map map = zza;
                for (zzkn zzkn : map.values()) {
                    zzkn.zzb.unregisterOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) Preconditions.checkNotNull(zzkn.zzc));
                }
                map.clear();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final /* synthetic */ void zzc(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzd) {
            this.zze = null;
            zzkl.zzc();
        }
        synchronized (this) {
            try {
                for (zzjr zza2 : this.zzf) {
                    zza2.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object zze(String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads;
        Map<String, ?> map = this.zze;
        if (map == null) {
            synchronized (this.zzd) {
                try {
                    map = this.zze;
                    if (map == null) {
                        allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        Map<String, ?> all = this.zzb.getAll();
                        this.zze = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
