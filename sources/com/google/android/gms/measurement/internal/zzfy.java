package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbl;
import com.google.android.gms.internal.measurement.zzbn;
import java.util.ArrayList;
import java.util.List;

public final class zzfy extends zzbl implements zzga {
    public zzfy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void zzA(zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzr);
        zzc(27, zza);
    }

    public final void zzB(zzr zzr, zzon zzon, zzgg zzgg) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzr);
        zzbn.zzc(zza, zzon);
        zzbn.zzd(zza, zzgg);
        zzc(29, zza);
    }

    public final void zzC(zzr zzr, zzaf zzaf) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzr);
        zzbn.zzc(zza, zzaf);
        zzc(30, zza);
    }

    public final void zzD(zzr zzr, Bundle bundle, zzgd zzgd) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzr);
        zzbn.zzc(zza, bundle);
        zzbn.zzd(zza, zzgd);
        zzc(31, zza);
    }

    public final void zze(zzbg zzbg, zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzbg);
        zzbn.zzc(zza, zzr);
        zzc(1, zza);
    }

    public final void zzf(zzpk zzpk, zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzpk);
        zzbn.zzc(zza, zzr);
        zzc(2, zza);
    }

    public final void zzg(zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzr);
        zzc(4, zza);
    }

    public final void zzh(zzbg zzbg, String str, String str2) throws RemoteException {
        throw null;
    }

    public final void zzi(zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzr);
        zzc(6, zza);
    }

    public final List zzj(zzr zzr, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzr);
        zza.writeInt(z ? 1 : 0);
        Parcel zzP = zzP(7, zza);
        ArrayList<zzpk> createTypedArrayList = zzP.createTypedArrayList(zzpk.CREATOR);
        zzP.recycle();
        return createTypedArrayList;
    }

    public final byte[] zzk(zzbg zzbg, String str) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzbg);
        zza.writeString(str);
        Parcel zzP = zzP(9, zza);
        byte[] createByteArray = zzP.createByteArray();
        zzP.recycle();
        return createByteArray;
    }

    public final void zzl(long j, String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc(10, zza);
    }

    public final String zzm(zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzr);
        Parcel zzP = zzP(11, zza);
        String readString = zzP.readString();
        zzP.recycle();
        return readString;
    }

    public final void zzn(zzah zzah, zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzah);
        zzbn.zzc(zza, zzr);
        zzc(12, zza);
    }

    public final void zzo(zzah zzah) throws RemoteException {
        throw null;
    }

    public final List zzp(String str, String str2, boolean z, zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        int i = zzbn.zza;
        zza.writeInt(z ? 1 : 0);
        zzbn.zzc(zza, zzr);
        Parcel zzP = zzP(14, zza);
        ArrayList<zzpk> createTypedArrayList = zzP.createTypedArrayList(zzpk.CREATOR);
        zzP.recycle();
        return createTypedArrayList;
    }

    public final List zzq(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zza.writeString(str2);
        zza.writeString(str3);
        int i = zzbn.zza;
        zza.writeInt(z ? 1 : 0);
        Parcel zzP = zzP(15, zza);
        ArrayList<zzpk> createTypedArrayList = zzP.createTypedArrayList(zzpk.CREATOR);
        zzP.recycle();
        return createTypedArrayList;
    }

    public final List zzr(String str, String str2, zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbn.zzc(zza, zzr);
        Parcel zzP = zzP(16, zza);
        ArrayList<zzah> createTypedArrayList = zzP.createTypedArrayList(zzah.CREATOR);
        zzP.recycle();
        return createTypedArrayList;
    }

    public final List zzs(String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzP = zzP(17, zza);
        ArrayList<zzah> createTypedArrayList = zzP.createTypedArrayList(zzah.CREATOR);
        zzP.recycle();
        return createTypedArrayList;
    }

    public final void zzt(zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzr);
        zzc(18, zza);
    }

    public final void zzu(Bundle bundle, zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, bundle);
        zzbn.zzc(zza, zzr);
        zzc(19, zza);
    }

    public final void zzv(zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzr);
        zzc(20, zza);
    }

    public final zzao zzw(zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzr);
        Parcel zzP = zzP(21, zza);
        zzao zzao = (zzao) zzbn.zzb(zzP, zzao.CREATOR);
        zzP.recycle();
        return zzao;
    }

    public final List zzx(zzr zzr, Bundle bundle) throws RemoteException {
        throw null;
    }

    public final void zzy(zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzr);
        zzc(25, zza);
    }

    public final void zzz(zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzr);
        zzc(26, zza);
    }
}
