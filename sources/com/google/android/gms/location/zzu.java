package com.google.android.gms.location;

import com.google.android.gms.location.FusedLocationProviderClient;

final /* synthetic */ class zzu implements FusedLocationProviderClient.zza {
    private final FusedLocationProviderClient zza;
    private final FusedLocationProviderClient.zzc zzb;
    private final LocationCallback zzc;
    private final FusedLocationProviderClient.zza zzd;

    public zzu(FusedLocationProviderClient fusedLocationProviderClient, FusedLocationProviderClient.zzc zzc2, LocationCallback locationCallback, FusedLocationProviderClient.zza zza2) {
        this.zza = fusedLocationProviderClient;
        this.zzb = zzc2;
        this.zzc = locationCallback;
        this.zzd = zza2;
    }

    public final void zza() {
        FusedLocationProviderClient fusedLocationProviderClient = this.zza;
        FusedLocationProviderClient.zzc zzc2 = this.zzb;
        LocationCallback locationCallback = this.zzc;
        FusedLocationProviderClient.zza zza2 = this.zzd;
        zzc2.zza(false);
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        if (zza2 != null) {
            zza2.zza();
        }
    }
}
