package com.google.android.gms.internal.maps;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.PinConfig;

public final class zzg extends zza implements zzi {
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
    }

    public final IObjectWrapper zzd() throws RemoteException {
        return ba.h(zzJ(4, zza()));
    }

    public final IObjectWrapper zze(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        return ba.h(zzJ(5, zza));
    }

    public final IObjectWrapper zzf(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        return ba.h(zzJ(2, zza));
    }

    public final IObjectWrapper zzg(Bitmap bitmap) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bitmap);
        return ba.h(zzJ(6, zza));
    }

    public final IObjectWrapper zzh(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        return ba.h(zzJ(3, zza));
    }

    public final IObjectWrapper zzi(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        return ba.h(zzJ(7, zza));
    }

    public final IObjectWrapper zzj(PinConfig pinConfig) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, pinConfig);
        return ba.h(zzJ(8, zza));
    }

    public final IObjectWrapper zzk(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        return ba.h(zzJ(1, zza));
    }
}
