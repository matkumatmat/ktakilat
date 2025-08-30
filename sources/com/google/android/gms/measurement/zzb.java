package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzlj;
import java.util.List;
import java.util.Map;

final class zzb extends zzc {
    private final zzlj zza;

    public zzb(zzlj zzlj) {
        super((byte[]) null);
        Preconditions.checkNotNull(zzlj);
        this.zza = zzlj;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    public final void zzb(String str, String str2, Bundle bundle, long j) {
        this.zza.zzb(str, str2, bundle, j);
    }

    public final Map zzc(boolean z) {
        return this.zza.zzd((String) null, (String) null, z);
    }

    public final Map zzd(String str, String str2, boolean z) {
        return this.zza.zzd(str, str2, z);
    }

    public final void zze(zzjo zzjo) {
        this.zza.zze(zzjo);
    }

    public final void zzf(zzjp zzjp) {
        this.zza.zzf(zzjp);
    }

    public final void zzg(zzjp zzjp) {
        this.zza.zzg(zzjp);
    }

    public final String zzh() {
        return this.zza.zzh();
    }

    public final String zzi() {
        return this.zza.zzi();
    }

    public final String zzj() {
        return this.zza.zzj();
    }

    public final String zzk() {
        return this.zza.zzk();
    }

    public final long zzl() {
        return this.zza.zzl();
    }

    public final void zzm(String str) {
        this.zza.zzm(str);
    }

    public final void zzn(String str) {
        this.zza.zzn(str);
    }

    public final void zzo(Bundle bundle) {
        this.zza.zzo(bundle);
    }

    public final void zzp(String str, String str2, Bundle bundle) {
        this.zza.zzp(str, str2, bundle);
    }

    public final List zzq(String str, String str2) {
        return this.zza.zzq(str, str2);
    }

    public final int zzr(String str) {
        return this.zza.zzr(str);
    }

    public final Boolean zzs() {
        return (Boolean) this.zza.zzx(4);
    }

    public final Integer zzt() {
        return (Integer) this.zza.zzx(3);
    }

    public final String zzu() {
        return (String) this.zza.zzx(0);
    }

    public final Long zzv() {
        return (Long) this.zza.zzx(1);
    }

    public final Double zzw() {
        return (Double) this.zza.zzx(2);
    }

    public final Object zzx(int i) {
        return this.zza.zzx(i);
    }
}
