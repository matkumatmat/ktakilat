package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.internal.zzno;
import com.google.android.gms.measurement.internal.zzns;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzno {
    private zzns zza;

    private final zzns zzd() {
        if (this.zza == null) {
            this.zza = new zzns(this);
        }
        return this.zza;
    }

    @MainThread
    public void onCreate() {
        super.onCreate();
        zzd().zza();
    }

    @MainThread
    public void onDestroy() {
        zzd().zzb();
        super.onDestroy();
    }

    @MainThread
    public void onRebind(@NonNull Intent intent) {
        zzd();
        zzns.zzi(intent);
    }

    public boolean onStartJob(@NonNull JobParameters jobParameters) {
        zzd().zze(jobParameters);
        return true;
    }

    public boolean onStopJob(@NonNull JobParameters jobParameters) {
        return false;
    }

    @MainThread
    public boolean onUnbind(@NonNull Intent intent) {
        zzd();
        zzns.zzj(intent);
        return true;
    }

    public final boolean zza(int i) {
        throw new UnsupportedOperationException();
    }

    @TargetApi(24)
    public final void zzb(@NonNull JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final void zzc(@NonNull Intent intent) {
    }
}
