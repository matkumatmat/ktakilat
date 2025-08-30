package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzib;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzli;
import com.google.android.gms.measurement.internal.zzpk;
import java.util.List;
import java.util.Map;

final class zza extends zzc {
    private final zzib zza;
    private final zzli zzb;

    public zza(@NonNull zzib zzib) {
        super((byte[]) null);
        Preconditions.checkNotNull(zzib);
        this.zza = zzib;
        this.zzb = zzib.zzj();
    }

    public final void zza(String str, String str2, Bundle bundle) {
        this.zzb.zzB(str, str2, bundle);
    }

    public final void zzb(String str, String str2, Bundle bundle, long j) {
        this.zzb.zzC(str, str2, bundle, true, false, j);
    }

    public final Map zzc(boolean z) {
        List<zzpk> zzO = this.zzb.zzO(z);
        ArrayMap arrayMap = new ArrayMap(zzO.size());
        for (zzpk zzpk : zzO) {
            Object zza2 = zzpk.zza();
            if (zza2 != null) {
                arrayMap.put(zzpk.zzb, zza2);
            }
        }
        return arrayMap;
    }

    public final Map zzd(String str, String str2, boolean z) {
        return this.zzb.zzP(str, str2, z);
    }

    public final void zze(zzjo zzjo) {
        this.zzb.zzV(zzjo);
    }

    public final void zzf(zzjp zzjp) {
        this.zzb.zzW(zzjp);
    }

    public final void zzg(zzjp zzjp) {
        this.zzb.zzX(zzjp);
    }

    public final String zzh() {
        return this.zzb.zzad();
    }

    public final String zzi() {
        return this.zzb.zzae();
    }

    public final String zzj() {
        return this.zzb.zzQ();
    }

    public final String zzk() {
        return this.zzb.zzQ();
    }

    public final long zzl() {
        return this.zza.zzk().zzd();
    }

    public final void zzm(String str) {
        zzib zzib = this.zza;
        zzib.zzw().zza(str, zzib.zzaZ().elapsedRealtime());
    }

    public final void zzn(String str) {
        zzib zzib = this.zza;
        zzib.zzw().zzb(str, zzib.zzaZ().elapsedRealtime());
    }

    public final void zzo(Bundle bundle) {
        this.zzb.zzZ(bundle);
    }

    public final void zzp(String str, String str2, Bundle bundle) {
        this.zza.zzj().zzab(str, str2, bundle);
    }

    public final List zzq(String str, String str2) {
        return this.zzb.zzac(str, str2);
    }

    public final int zzr(String str) {
        this.zzb.zzY(str);
        return 25;
    }

    public final Boolean zzs() {
        return this.zzb.zzi();
    }

    public final Integer zzt() {
        return this.zzb.zzl();
    }

    public final String zzu() {
        return this.zzb.zzj();
    }

    public final Long zzv() {
        return this.zzb.zzk();
    }

    public final Double zzw() {
        return this.zzb.zzm();
    }

    public final Object zzx(int i) {
        if (i == 0) {
            return this.zzb.zzj();
        }
        if (i == 1) {
            return this.zzb.zzk();
        }
        if (i == 2) {
            return this.zzb.zzm();
        }
        if (i != 3) {
            return this.zzb.zzi();
        }
        return this.zzb.zzl();
    }
}
