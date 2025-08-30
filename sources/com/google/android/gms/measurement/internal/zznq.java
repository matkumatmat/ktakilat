package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

final /* synthetic */ class zznq implements Runnable {
    private final /* synthetic */ zzns zza;
    private final /* synthetic */ JobParameters zzb;

    public /* synthetic */ zznq(zzns zzns, JobParameters jobParameters) {
        this.zza = zzns;
        this.zzb = jobParameters;
    }

    public final /* synthetic */ void run() {
        this.zza.zzh(this.zzb);
    }
}
