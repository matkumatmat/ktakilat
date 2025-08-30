package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

final /* synthetic */ class zznp implements Runnable {
    private final /* synthetic */ zzns zza;
    private final /* synthetic */ zzgt zzb;
    private final /* synthetic */ JobParameters zzc;

    public /* synthetic */ zznp(zzns zzns, zzgt zzgt, JobParameters jobParameters) {
        this.zza = zzns;
        this.zzb = zzgt;
        this.zzc = jobParameters;
    }

    public final /* synthetic */ void run() {
        this.zza.zzg(this.zzb, this.zzc);
    }
}
