package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzq implements RemoteCall {
    private final FusedLocationProviderClient zza;

    public zzq(FusedLocationProviderClient fusedLocationProviderClient) {
        this.zza = fusedLocationProviderClient;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zza((zzay) obj, (TaskCompletionSource) obj2);
    }
}
