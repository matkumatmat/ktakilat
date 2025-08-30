package com.google.firebase.analytics;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzlj;
import java.util.List;
import java.util.Map;

final class zzd implements zzlj {
    final /* synthetic */ zzfb zza;

    public zzd(zzfb zzfb) {
        this.zza = zzfb;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zzi(str, str2, bundle);
    }

    public final void zzb(String str, String str2, Bundle bundle, long j) {
        this.zza.zzj(str, str2, bundle, j);
    }

    public final Map zzd(@Nullable String str, @Nullable String str2, boolean z) {
        return this.zza.zzC(str, str2, z);
    }

    public final void zze(zzjo zzjo) {
        this.zza.zzd(zzjo);
    }

    public final void zzf(zzjp zzjp) {
        this.zza.zzf(zzjp);
    }

    public final void zzg(zzjp zzjp) {
        this.zza.zzg(zzjp);
    }

    @Nullable
    public final String zzh() {
        return this.zza.zzA();
    }

    @Nullable
    public final String zzi() {
        return this.zza.zzB();
    }

    @Nullable
    public final String zzj() {
        return this.zza.zzy();
    }

    @Nullable
    public final String zzk() {
        return this.zza.zzx();
    }

    public final long zzl() {
        return this.zza.zzz();
    }

    public final void zzm(String str) {
        this.zza.zzu(str);
    }

    public final void zzn(String str) {
        this.zza.zzv(str);
    }

    public final void zzo(Bundle bundle) {
        this.zza.zzl(bundle);
    }

    public final void zzp(String str, @Nullable String str2, @Nullable Bundle bundle) {
        this.zza.zzm(str, str2, bundle);
    }

    public final List zzq(@Nullable String str, @Nullable String str2) {
        return this.zza.zzn(str, str2);
    }

    public final int zzr(String str) {
        return this.zza.zzF(str);
    }

    @Nullable
    public final Object zzx(int i) {
        return this.zza.zzJ(i);
    }
}
