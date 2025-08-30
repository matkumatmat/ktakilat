package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzd;

public final class zzas extends zzb implements zzaq {
    public zzas(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationListener");
    }

    public final void zza(Location location) throws RemoteException {
        Parcel b_ = b_();
        zzd.zza(b_, (Parcelable) location);
        zzc(1, b_);
    }
}
