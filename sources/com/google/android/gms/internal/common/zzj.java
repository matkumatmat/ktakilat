package com.google.android.gms.internal.common;

import androidx.annotation.Nullable;

public class zzj {
    private final Class zza;
    @Nullable
    private final Object zzb;

    private zzj(Class cls, @Nullable Object obj) {
        this.zza = cls;
        this.zzb = obj;
    }

    public static zzj zzb(Class cls, @Nullable Object obj) {
        return new zzj(cls, obj);
    }

    public final Class zzc() {
        return this.zza;
    }

    @Nullable
    public final Object zzd() {
        return this.zzb;
    }
}
