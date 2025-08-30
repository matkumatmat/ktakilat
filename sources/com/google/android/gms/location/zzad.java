package com.google.android.gms.location;

import com.google.android.gms.tasks.TaskCompletionSource;

final class zzad extends LocationCallback {
    private final /* synthetic */ TaskCompletionSource zza;
    private final /* synthetic */ FusedLocationProviderClient zzb;

    public zzad(FusedLocationProviderClient fusedLocationProviderClient, TaskCompletionSource taskCompletionSource) {
        this.zzb = fusedLocationProviderClient;
        this.zza = taskCompletionSource;
    }

    public final void onLocationAvailability(LocationAvailability locationAvailability) {
    }

    public final void onLocationResult(LocationResult locationResult) {
        this.zza.trySetResult(locationResult.getLastLocation());
        this.zzb.removeLocationUpdates((LocationCallback) this);
    }
}
