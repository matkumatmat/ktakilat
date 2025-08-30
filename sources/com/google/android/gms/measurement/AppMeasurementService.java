package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzno;
import com.google.android.gms.measurement.internal.zzns;

public final class AppMeasurementService extends Service implements zzno {
    private zzns zza;

    private final zzns zzd() {
        if (this.zza == null) {
            this.zza = new zzns(this);
        }
        return this.zza;
    }

    @MainThread
    @Nullable
    public IBinder onBind(@NonNull Intent intent) {
        return zzd().zzd(intent);
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

    @MainThread
    public int onStartCommand(@NonNull Intent intent, int i, int i2) {
        zzd().zzc(intent, i, i2);
        return 2;
    }

    @MainThread
    public boolean onUnbind(@NonNull Intent intent) {
        zzd();
        zzns.zzj(intent);
        return true;
    }

    public final boolean zza(int i) {
        return stopSelfResult(i);
    }

    public final void zzb(@NonNull JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zzc(@NonNull Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
