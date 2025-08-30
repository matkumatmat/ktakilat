package com.google.android.gms.measurement.internal;

import androidx.annotation.Nullable;

public final class zzlt {
    @Nullable
    public final String zza;
    @Nullable
    public final String zzb;
    public final long zzc;
    boolean zzd;
    public final boolean zze;
    public final long zzf;

    public zzlt(@Nullable String str, @Nullable String str2, long j, boolean z, long j2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = false;
        this.zze = z;
        this.zzf = j2;
    }

    public zzlt(@Nullable String str, @Nullable String str2, long j) {
        this(str, str2, j, false, 0);
    }
}
