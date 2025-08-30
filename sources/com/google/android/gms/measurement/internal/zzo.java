package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcx;

final /* synthetic */ class zzo implements Runnable {
    private final /* synthetic */ AppMeasurementDynamiteService zza;
    private final /* synthetic */ zzcx zzb;

    public /* synthetic */ zzo(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcx zzcx) {
        this.zza = appMeasurementDynamiteService;
        this.zzb = zzcx;
    }

    public final /* synthetic */ void run() {
        try {
            this.zzb.zze();
        } catch (RemoteException e) {
            ((zzib) Preconditions.checkNotNull(this.zza.zza)).zzaV().zze().zzb("Failed to call IDynamiteUploadBatchesCallback", e);
        }
    }
}
