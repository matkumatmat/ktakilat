package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

final class zze {
    private final zzjh zza;

    public zze(zzjh zzjh) {
        this.zza = zzjh;
    }

    public static zze zzc(String str) {
        zzjh zzjh;
        if (TextUtils.isEmpty(str) || str.length() > 1) {
            zzjh = zzjh.UNINITIALIZED;
        } else {
            zzjh = zzjk.zzj(str.charAt(0));
        }
        return new zze(zzjh);
    }

    public final zzjh zza() {
        return this.zza;
    }

    public final String zzb() {
        return String.valueOf(zzjk.zzm(this.zza));
    }
}
