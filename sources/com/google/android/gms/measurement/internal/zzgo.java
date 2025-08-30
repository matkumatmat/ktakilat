package com.google.android.gms.measurement.internal;

import com.google.android.gms.tasks.OnFailureListener;

final /* synthetic */ class zzgo implements OnFailureListener {
    private final /* synthetic */ zzgp zza;
    private final /* synthetic */ long zzb;

    public /* synthetic */ zzgo(zzgp zzgp, long j) {
        this.zza = zzgp;
        this.zzb = j;
    }

    public final /* synthetic */ void onFailure(Exception exc) {
        this.zza.zzc(this.zzb, exc);
    }
}
