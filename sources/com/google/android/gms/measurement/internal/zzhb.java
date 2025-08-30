package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

public final class zzhb {
    final /* synthetic */ zzhg zza;
    private final String zzb;
    private final boolean zzc;
    private boolean zzd;
    private boolean zze;

    public zzhb(zzhg zzhg, String str, boolean z) {
        Objects.requireNonNull(zzhg);
        this.zza = zzhg;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = z;
    }

    @WorkerThread
    public final boolean zza() {
        if (!this.zzd) {
            this.zzd = true;
            zzhg zzhg = this.zza;
            this.zze = zzhg.zzd().getBoolean(this.zzb, this.zzc);
        }
        return this.zze;
    }

    @WorkerThread
    public final void zzb(boolean z) {
        SharedPreferences.Editor edit = this.zza.zzd().edit();
        edit.putBoolean(this.zzb, z);
        edit.apply();
        this.zze = z;
    }
}
