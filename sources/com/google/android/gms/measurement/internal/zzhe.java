package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.annotations.VisibleForTesting;
import java.util.Objects;

public final class zzhe {
    @VisibleForTesting
    final String zza;
    final /* synthetic */ zzhg zzb;
    private final String zzc;
    private final String zzd;
    private final long zze;

    public /* synthetic */ zzhe(zzhg zzhg, String str, long j, byte[] bArr) {
        boolean z;
        Objects.requireNonNull(zzhg);
        this.zzb = zzhg;
        Preconditions.checkNotEmpty("health_monitor");
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = j;
    }

    @WorkerThread
    private final void zzc() {
        zzhg zzhg = this.zzb;
        zzhg.zzg();
        long currentTimeMillis = zzhg.zzu.zzaZ().currentTimeMillis();
        SharedPreferences.Editor edit = zzhg.zzd().edit();
        edit.remove(this.zzc);
        edit.remove(this.zzd);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    private final long zzd() {
        return this.zzb.zzd().getLong(this.zza, 0);
    }

    @WorkerThread
    public final void zza(String str, long j) {
        zzhg zzhg = this.zzb;
        zzhg.zzg();
        if (zzd() == 0) {
            zzc();
        }
        if (str == null) {
            str = "";
        }
        SharedPreferences zzd2 = zzhg.zzd();
        String str2 = this.zzc;
        long j2 = zzd2.getLong(str2, 0);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = zzhg.zzd().edit();
            edit.putString(this.zzd, str);
            edit.putLong(str2, 1);
            edit.apply();
            return;
        }
        long nextLong = zzhg.zzu.zzk().zzf().nextLong() & LocationRequestCompat.PASSIVE_INTERVAL;
        long j3 = j2 + 1;
        long j4 = LocationRequestCompat.PASSIVE_INTERVAL / j3;
        SharedPreferences.Editor edit2 = zzhg.zzd().edit();
        if (nextLong < j4) {
            edit2.putString(this.zzd, str);
        }
        edit2.putLong(str2, j3);
        edit2.apply();
    }

    @WorkerThread
    public final Pair zzb() {
        long j;
        zzhg zzhg = this.zzb;
        zzhg.zzg();
        zzhg.zzg();
        long zzd2 = zzd();
        if (zzd2 == 0) {
            zzc();
            j = 0;
        } else {
            j = Math.abs(zzd2 - zzhg.zzu.zzaZ().currentTimeMillis());
        }
        long j2 = this.zze;
        if (j < j2) {
            return null;
        }
        if (j > j2 + j2) {
            zzc();
            return null;
        }
        String string = zzhg.zzd().getString(this.zzd, (String) null);
        long j3 = zzhg.zzd().getLong(this.zzc, 0);
        zzc();
        if (string == null || j3 <= 0) {
            return zzhg.zza;
        }
        return new Pair(string, Long.valueOf(j3));
    }
}
