package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzin;

public final class zzlp extends zzg {
    private JobScheduler zza;

    public zzlp(zzib zzib) {
        super(zzib);
    }

    public final boolean zze() {
        return true;
    }

    @WorkerThread
    @TargetApi(24)
    public final void zzf() {
        this.zza = (JobScheduler) this.zzu.zzaY().getSystemService("jobscheduler");
    }

    @WorkerThread
    @TargetApi(24)
    public final void zzh(long j) {
        String str;
        zzb();
        zzg();
        JobScheduler jobScheduler = this.zza;
        if (jobScheduler == null || jobScheduler.getPendingJob(zzi()) == null) {
            zzin zzj = zzj();
            if (zzj == zzin.CLIENT_UPLOAD_ELIGIBLE) {
                zzib zzib = this.zzu;
                zzib.zzaV().zzk().zzb("[sgtm] Scheduling Scion upload, millis", Long.valueOf(j));
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "com.google.android.gms.measurement.SCION_UPLOAD");
                int schedule = ((JobScheduler) Preconditions.checkNotNull(this.zza)).schedule(new JobInfo.Builder(zzi(), new ComponentName(zzib.zzaY(), "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j).setOverrideDeadline(j + j).setExtras(persistableBundle).build());
                zzgr zzk = zzib.zzaV().zzk();
                if (schedule == 1) {
                    str = "SUCCESS";
                } else {
                    str = "FAILURE";
                }
                zzk.zzb("[sgtm] Scion upload job scheduled with result", str);
                return;
            }
            this.zzu.zzaV().zzk().zzb("[sgtm] Not eligible for Scion upload", zzj.name());
            return;
        }
        this.zzu.zzaV().zzk().zza("[sgtm] There's an existing pending job, skip this schedule.");
    }

    @VisibleForTesting
    public final int zzi() {
        return "measurement-client".concat(String.valueOf(this.zzu.zzaY().getPackageName())).hashCode();
    }

    @WorkerThread
    public final zzin zzj() {
        zzb();
        zzg();
        if (this.zza == null) {
            return zzin.MISSING_JOB_SCHEDULER;
        }
        zzib zzib = this.zzu;
        if (!zzib.zzc().zzx()) {
            return zzin.NOT_ENABLED_IN_MANIFEST;
        }
        zzib zzib2 = this.zzu;
        if (zzib2.zzv().zzn() < 119000) {
            return zzin.SDK_TOO_OLD;
        }
        if (!zzpo.zzR(zzib.zzaY(), "com.google.android.gms.measurement.AppMeasurementJobService")) {
            return zzin.MEASUREMENT_SERVICE_NOT_ENABLED;
        }
        if (Build.VERSION.SDK_INT < 24) {
            return zzin.ANDROID_TOO_OLD;
        }
        if (!zzib2.zzt().zzK()) {
            return zzin.NON_PLAY_MODE;
        }
        return zzin.CLIENT_UPLOAD_ELIGIBLE;
    }
}
