package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbn;
import java.util.ArrayList;

public abstract class zzgc extends zzbm implements zzgd {
    public zzgc() {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        ArrayList<zzog> createTypedArrayList = parcel.createTypedArrayList(zzog.CREATOR);
        zzbn.zzf(parcel);
        zze(createTypedArrayList);
        return true;
    }
}
