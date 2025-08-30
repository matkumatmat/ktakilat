package com.google.android.gms.location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzw implements FusedLocationProviderClient.zza {
    private final TaskCompletionSource zza;

    public zzw(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zza() {
        this.zza.trySetResult(null);
    }
}
