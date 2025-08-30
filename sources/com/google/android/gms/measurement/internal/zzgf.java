package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbn;

public abstract class zzgf extends zzbm implements zzgg {
    public zzgf() {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        zzbn.zzf(parcel);
        zze((zzop) zzbn.zzb(parcel, zzop.CREATOR));
        return true;
    }
}
