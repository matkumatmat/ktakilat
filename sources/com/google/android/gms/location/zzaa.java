package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.internal.location.zzbc;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzaa implements RemoteCall {
    private final FusedLocationProviderClient zza;
    private final FusedLocationProviderClient.zzc zzb;
    private final LocationCallback zzc;
    private final FusedLocationProviderClient.zza zzd;
    private final zzbc zze;
    private final ListenerHolder zzf;

    public zzaa(FusedLocationProviderClient fusedLocationProviderClient, FusedLocationProviderClient.zzc zzc2, LocationCallback locationCallback, FusedLocationProviderClient.zza zza2, zzbc zzbc, ListenerHolder listenerHolder) {
        this.zza = fusedLocationProviderClient;
        this.zzb = zzc2;
        this.zzc = locationCallback;
        this.zzd = zza2;
        this.zze = zzbc;
        this.zzf = listenerHolder;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, (zzay) obj, (TaskCompletionSource) obj2);
    }
}
