package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbl;
import com.google.android.gms.internal.measurement.zzbn;

public final class zzge extends zzbl implements zzgg {
    public zzge(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    public final void zze(zzop zzop) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzop);
        zzd(2, zza);
    }
}
