package com.google.android.gms.location;

import com.google.android.gms.tasks.OnTokenCanceledListener;

final /* synthetic */ class zzt implements OnTokenCanceledListener {
    private final FusedLocationProviderClient zza;
    private final LocationCallback zzb;

    public zzt(FusedLocationProviderClient fusedLocationProviderClient, LocationCallback locationCallback) {
        this.zza = fusedLocationProviderClient;
        this.zzb = locationCallback;
    }

    public final void onCanceled() {
        this.zza.removeLocationUpdates(this.zzb);
    }
}
