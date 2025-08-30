package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.MainThread;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzfb;
import java.util.Objects;

public final class zzns {
    private final Context zza;

    public zzns(Context context) {
        Preconditions.checkNotNull(context);
        this.zza = context;
    }

    @MainThread
    public static final void zzi(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onRebind called with null intent");
        } else {
            "onRebind called. action: ".concat(String.valueOf(intent.getAction()));
        }
    }

    @MainThread
    public static final boolean zzj(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onUnbind called with null intent");
            return true;
        }
        "onUnbind called for intent. action: ".concat(String.valueOf(intent.getAction()));
        return true;
    }

    private final void zzk(zzpf zzpf, Runnable runnable) {
        zzpf.zzaW().zzj(new zznn(this, zzpf, runnable));
    }

    @MainThread
    public final void zza() {
        this.zza.getClass().getSimpleName().concat(" is starting up.");
    }

    @MainThread
    public final void zzb() {
        this.zza.getClass().getSimpleName().concat(" is shutting down.");
    }

    @MainThread
    public final int zzc(Intent intent, int i, int i2) {
        if (intent == null) {
            Log.w("FA", "AppMeasurementService started with null intent");
            return 2;
        }
        Context context = this.zza;
        zzib zzy = zzib.zzy(context, (zzdd) null, (Long) null);
        zzgt zzaV = zzy.zzaV();
        String action = intent.getAction();
        zzy.zzaU();
        zzaV.zzk().zzc("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzk(zzpf.zza(context), new zznr(this, i2, zzaV, intent));
        }
        return 2;
    }

    @MainThread
    public final IBinder zzd(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzjc(zzpf.zza(this.zza), (String) null);
        }
        Log.w("FA", "onBind received unknown action: ".concat(String.valueOf(action)));
        return null;
    }

    @TargetApi(24)
    @MainThread
    public final boolean zze(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString(NativeProtocol.WEB_DIALOG_ACTION);
        "onStartJob received action: ".concat(String.valueOf(string));
        if (Objects.equals(string, "com.google.android.gms.measurement.UPLOAD")) {
            zzpf zza2 = zzpf.zza(this.zza);
            zzgt zzaV = zza2.zzaV();
            zza2.zzaU();
            zzaV.zzk().zzb("Local AppMeasurementJobService called. action", (String) Preconditions.checkNotNull(string));
            zzk(zza2, new zznp(this, zzaV, jobParameters));
        }
        if (!Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            return true;
        }
        String str = (String) Preconditions.checkNotNull(string);
        zzfb.zza(this.zza, (Bundle) null).zzw(new zznq(this, jobParameters));
        return true;
    }

    public final /* synthetic */ void zzf(int i, zzgt zzgt, Intent intent) {
        Context context = this.zza;
        zzno zzno = (zzno) context;
        if (zzno.zza(i)) {
            zzgt.zzk().zzb("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzib.zzy(context, (zzdd) null, (Long) null).zzaV().zzk().zza("Completed wakeful intent.");
            zzno.zzc(intent);
        }
    }

    public final /* synthetic */ void zzg(zzgt zzgt, JobParameters jobParameters) {
        zzgt.zzk().zza("AppMeasurementJobService processed last upload request.");
        ((zzno) this.zza).zzb(jobParameters, false);
    }

    public final /* synthetic */ void zzh(JobParameters jobParameters) {
        ((zzno) this.zza).zzb(jobParameters, false);
    }
}
