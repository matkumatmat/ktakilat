package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.internal.location.zzbc;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzs implements RemoteCall {
    private final FusedLocationProviderClient zza;
    private final CancellationToken zzb;
    private final zzbc zzc;

    public zzs(FusedLocationProviderClient fusedLocationProviderClient, CancellationToken cancellationToken, zzbc zzbc) {
        this.zza = fusedLocationProviderClient;
        this.zzb = cancellationToken;
        this.zzc = zzbc;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zza(this.zzb, this.zzc, (zzay) obj, (TaskCompletionSource) obj2);
    }
}
