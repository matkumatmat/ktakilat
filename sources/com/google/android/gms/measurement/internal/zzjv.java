package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Objects;

final class zzjv implements FutureCallback {
    final /* synthetic */ zzog zza;
    final /* synthetic */ zzli zzb;

    public zzjv(zzli zzli, zzog zzog) {
        this.zza = zzog;
        Objects.requireNonNull(zzli);
        this.zzb = zzli;
    }

    private final void zza() {
        zzib zzib = this.zzb.zzu;
        SparseArray zzf = zzib.zzd().zzf();
        zzog zzog = this.zza;
        zzf.put(zzog.zzc, Long.valueOf(zzog.zzb));
        zzhg zzd = zzib.zzd();
        int[] iArr = new int[zzf.size()];
        long[] jArr = new long[zzf.size()];
        for (int i = 0; i < zzf.size(); i++) {
            iArr[i] = zzf.keyAt(i);
            jArr[i] = ((Long) zzf.valueAt(i)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        zzd.zzi.zzb(bundle);
    }

    public final void onFailure(Throwable th) {
        int i;
        zzli zzli = this.zzb;
        zzli.zzg();
        zzli.zzal(false);
        zzib zzib = zzli.zzu;
        if (zzib.zzc().zzp((String) null, zzfx.zzaT)) {
            i = zzli.zzap(th);
        } else {
            i = 2;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            zzib.zzaV().zze().zzc("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", zzgt.zzl(zzli.zzu.zzv().zzj()), zzgt.zzl(th.toString()));
            zzli.zzan(1);
            zzli.zzy().add(this.zza);
        } else if (i2 != 1) {
            zzib.zzaV().zzb().zzc("registerTriggerAsync failed. Dropping URI. App ID, Throwable", zzgt.zzl(zzli.zzu.zzv().zzj()), th);
            zza();
            zzli.zzan(1);
            zzli.zzz();
        } else {
            zzli.zzy().add(this.zza);
            if (zzli.zzam() > ((Integer) zzfx.zzaw.zzb((Object) null)).intValue()) {
                zzli.zzan(1);
                zzib.zzaV().zze().zzc("registerTriggerAsync failed. May try later. App ID, throwable", zzgt.zzl(zzli.zzu.zzv().zzj()), zzgt.zzl(th.toString()));
                return;
            }
            zzib.zzaV().zze().zzd("registerTriggerAsync failed. App ID, delay in seconds, throwable", zzgt.zzl(zzli.zzu.zzv().zzj()), zzgt.zzl(String.valueOf(zzli.zzam())), zzgt.zzl(th.toString()));
            zzli.zzah(zzli.zzam());
            int zzam = zzli.zzam();
            zzli.zzan(zzam + zzam);
        }
    }

    public final void onSuccess(Object obj) {
        zzli zzli = this.zzb;
        zzli.zzg();
        zza();
        zzli.zzal(false);
        zzli.zzan(1);
        zzli.zzu.zzaV().zzj().zzb("Successfully registered trigger URI", this.zza.zza);
        zzli.zzz();
    }
}
