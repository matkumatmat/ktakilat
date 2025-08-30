package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzah extends zza implements zzai {
    public zzah() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza((zzac) zzd.zza(parcel, zzac.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            a_();
        }
        return true;
    }
}
