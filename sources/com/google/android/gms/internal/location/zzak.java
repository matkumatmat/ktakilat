package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzak extends zzb implements zzai {
    public zzak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    public final void a_() throws RemoteException {
        zzc(2, b_());
    }

    public final void zza(zzac zzac) throws RemoteException {
        Parcel b_ = b_();
        zzd.zza(b_, (Parcelable) zzac);
        zzc(1, b_);
    }
}
