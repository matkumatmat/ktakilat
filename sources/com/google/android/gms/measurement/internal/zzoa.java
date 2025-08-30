package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.util.Objects;

final class zzoa {
    final /* synthetic */ zzob zza;

    public zzoa(zzob zzob) {
        Objects.requireNonNull(zzob);
        this.zza = zzob;
    }

    @WorkerThread
    public final void zza() {
        zzob zzob = this.zza;
        zzob.zzg();
        zzib zzib = zzob.zzu;
        if (zzib.zzd().zzp(zzib.zzaZ().currentTimeMillis())) {
            zzib.zzd().zzg.zzb(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                zzib.zzaV().zzk().zza("Detected application was in foreground");
                zzc(zzib.zzaZ().currentTimeMillis(), false);
            }
        }
    }

    @WorkerThread
    public final void zzb(long j, boolean z) {
        zzob zzob = this.zza;
        zzob.zzg();
        zzob.zzj();
        zzib zzib = zzob.zzu;
        if (zzib.zzd().zzp(j)) {
            zzib.zzd().zzg.zzb(true);
            zzob.zzu.zzv().zzi();
        }
        zzib.zzd().zzk.zzb(j);
        if (zzib.zzd().zzg.zza()) {
            zzc(j, z);
        }
    }

    @VisibleForTesting
    @WorkerThread
    public final void zzc(long j, boolean z) {
        zzob zzob = this.zza;
        zzob.zzg();
        if (zzob.zzu.zzB()) {
            zzib zzib = zzob.zzu;
            zzib.zzd().zzk.zzb(j);
            zzib.zzaV().zzk().zzb("Session started, time", Long.valueOf(zzib.zzaZ().elapsedRealtime()));
            long j2 = j / 1000;
            zzib zzib2 = zzob.zzu;
            zzib2.zzj().zzN("auto", "_sid", Long.valueOf(j2), j);
            zzib.zzd().zzl.zzb(j2);
            zzib.zzd().zzg.zzb(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j2);
            zzib2.zzj().zzG("auto", "_s", j, bundle);
            String zza2 = zzib.zzd().zzq.zza();
            if (!TextUtils.isEmpty(zza2)) {
                zzib2.zzj().zzG("auto", "_ssr", j, e.c("_ffr", zza2));
            }
        }
    }
}
