package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public final class zzb extends zza implements ICameraUpdateFactoryDelegate {
    public zzb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
    }

    public final IObjectWrapper newCameraPosition(CameraPosition cameraPosition) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, cameraPosition);
        return ba.h(zzJ(7, zza));
    }

    public final IObjectWrapper newLatLng(LatLng latLng) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, latLng);
        return ba.h(zzJ(8, zza));
    }

    public final IObjectWrapper newLatLngBounds(LatLngBounds latLngBounds, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, latLngBounds);
        zza.writeInt(i);
        return ba.h(zzJ(10, zza));
    }

    public final IObjectWrapper newLatLngBoundsWithSize(LatLngBounds latLngBounds, int i, int i2, int i3) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, latLngBounds);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        return ba.h(zzJ(11, zza));
    }

    public final IObjectWrapper newLatLngZoom(LatLng latLng, float f) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, latLng);
        zza.writeFloat(f);
        return ba.h(zzJ(9, zza));
    }

    public final IObjectWrapper scrollBy(float f, float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zza.writeFloat(f2);
        return ba.h(zzJ(3, zza));
    }

    public final IObjectWrapper zoomBy(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        return ba.h(zzJ(5, zza));
    }

    public final IObjectWrapper zoomByWithFocus(float f, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zza.writeInt(i);
        zza.writeInt(i2);
        return ba.h(zzJ(6, zza));
    }

    public final IObjectWrapper zoomIn() throws RemoteException {
        return ba.h(zzJ(1, zza()));
    }

    public final IObjectWrapper zoomOut() throws RemoteException {
        return ba.h(zzJ(2, zza()));
    }

    public final IObjectWrapper zoomTo(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        return ba.h(zzJ(4, zza));
    }
}
