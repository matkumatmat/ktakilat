package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzcy extends zzbl implements zzda {
    public zzcy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final void zze(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbn.zzc(zza, bundle);
        zza.writeLong(j);
        zzc(1, zza);
    }

    public final int zzf() throws RemoteException {
        Parcel zzP = zzP(2, zza());
        int readInt = zzP.readInt();
        zzP.recycle();
        return readInt;
    }
}
