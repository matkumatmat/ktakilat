package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.internal.measurement.zzcg;
import com.google.android.gms.internal.measurement.zzch;

public final class zzoj extends zzor {
    private final AlarmManager zza = ((AlarmManager) this.zzu.zzaY().getSystemService(NotificationCompat.CATEGORY_ALARM));
    private zzay zzb;
    private Integer zzc;

    public zzoj(zzpf zzpf) {
        super(zzpf);
    }

    private final zzay zzf() {
        if (this.zzb == null) {
            this.zzb = new zzoi(this, this.zzg.zzaf());
        }
        return this.zzb;
    }

    @TargetApi(24)
    private final void zzh() {
        JobScheduler jobScheduler = (JobScheduler) this.zzu.zzaY().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(zzi());
        }
    }

    private final int zzi() {
        if (this.zzc == null) {
            this.zzc = Integer.valueOf("measurement".concat(String.valueOf(this.zzu.zzaY().getPackageName())).hashCode());
        }
        return this.zzc.intValue();
    }

    private final PendingIntent zzj() {
        Context zzaY = this.zzu.zzaY();
        return PendingIntent.getBroadcast(zzaY, 0, new Intent().setClassName(zzaY, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), zzcg.zza);
    }

    public final boolean zzbb() {
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzj());
        }
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        zzh();
        return false;
    }

    public final void zzc(long j) {
        zzay();
        zzib zzib = this.zzu;
        zzib.zzaU();
        Context zzaY = zzib.zzaY();
        if (!zzpo.zzau(zzaY)) {
            zzib.zzaV().zzj().zza("Receiver not registered/enabled");
        }
        if (!zzpo.zzQ(zzaY, false)) {
            zzib.zzaV().zzj().zza("Service not registered/enabled");
        }
        zzd();
        zzib.zzaV().zzk().zzb("Scheduling upload, millis", Long.valueOf(j));
        long elapsedRealtime = zzib.zzaZ().elapsedRealtime() + j;
        zzib.zzc();
        if (j < Math.max(0, ((Long) zzfx.zzL.zzb((Object) null)).longValue()) && !zzf().zzc()) {
            zzf().zzb(j);
        }
        zzib.zzaU();
        if (Build.VERSION.SDK_INT >= 24) {
            Context zzaY2 = zzib.zzaY();
            ComponentName componentName = new ComponentName(zzaY2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int zzi = zzi();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "com.google.android.gms.measurement.UPLOAD");
            zzch.zza(zzaY2, new JobInfo.Builder(zzi, componentName).setMinimumLatency(j).setOverrideDeadline(j + j).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            zzib.zzc();
            alarmManager.setInexactRepeating(2, elapsedRealtime, Math.max(((Long) zzfx.zzG.zzb((Object) null)).longValue(), j), zzj());
        }
    }

    public final void zzd() {
        zzay();
        this.zzu.zzaV().zzk().zza("Unscheduling upload");
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzj());
        }
        zzf().zzd();
        if (Build.VERSION.SDK_INT >= 24) {
            zzh();
        }
    }
}
