package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

public final class zzhf {
    final /* synthetic */ zzhg zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;

    public zzhf(zzhg zzhg, String str, String str2) {
        Objects.requireNonNull(zzhg);
        this.zza = zzhg;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
    }

    @WorkerThread
    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            zzhg zzhg = this.zza;
            this.zzd = zzhg.zzd().getString(this.zzb, (String) null);
        }
        return this.zzd;
    }

    @WorkerThread
    public final void zzb(String str) {
        SharedPreferences.Editor edit = this.zza.zzd().edit();
        edit.putString(this.zzb, str);
        edit.apply();
        this.zzd = str;
    }
}
