package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

public final class zzhd {
    final /* synthetic */ zzhg zza;
    private final String zzb;
    private final long zzc;
    private boolean zzd;
    private long zze;

    public zzhd(zzhg zzhg, String str, long j) {
        Objects.requireNonNull(zzhg);
        this.zza = zzhg;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = j;
    }

    @WorkerThread
    public final long zza() {
        if (!this.zzd) {
            this.zzd = true;
            zzhg zzhg = this.zza;
            this.zze = zzhg.zzd().getLong(this.zzb, this.zzc);
        }
        return this.zze;
    }

    @WorkerThread
    public final void zzb(long j) {
        SharedPreferences.Editor edit = this.zza.zzd().edit();
        edit.putLong(this.zzb, j);
        edit.apply();
        this.zze = j;
    }
}
