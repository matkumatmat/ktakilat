package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.internal.location.zzbc;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzz implements RemoteCall {
    private final FusedLocationProviderClient zza;
    private final zzbc zzb;
    private final PendingIntent zzc;

    public zzz(FusedLocationProviderClient fusedLocationProviderClient, zzbc zzbc, PendingIntent pendingIntent) {
        this.zza = fusedLocationProviderClient;
        this.zzb = zzbc;
        this.zzc = pendingIntent;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zza(this.zzb, this.zzc, (zzay) obj, (TaskCompletionSource) obj2);
    }
}
