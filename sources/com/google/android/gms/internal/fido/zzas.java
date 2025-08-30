package com.google.android.gms.internal.fido;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.CheckForNull;

final class zzas extends zzat {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzat zzc;

    public zzas(zzat zzat, int i, int i2) {
        this.zzc = zzat;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzam.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @CheckForNull
    public final Object[] zze() {
        return this.zzc.zze();
    }

    /* renamed from: zzf */
    public final zzat subList(int i, int i2) {
        zzam.zze(i, i2, this.zzb);
        zzat zzat = this.zzc;
        int i3 = this.zza;
        return zzat.subList(i + i3, i2 + i3);
    }
}
