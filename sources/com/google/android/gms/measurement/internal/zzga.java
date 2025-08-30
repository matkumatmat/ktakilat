package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.List;

public interface zzga extends IInterface {
    void zzA(zzr zzr) throws RemoteException;

    void zzB(zzr zzr, zzon zzon, zzgg zzgg) throws RemoteException;

    void zzC(zzr zzr, zzaf zzaf) throws RemoteException;

    void zzD(zzr zzr, Bundle bundle, zzgd zzgd) throws RemoteException;

    void zze(zzbg zzbg, zzr zzr) throws RemoteException;

    void zzf(zzpk zzpk, zzr zzr) throws RemoteException;

    void zzg(zzr zzr) throws RemoteException;

    void zzh(zzbg zzbg, String str, @Nullable String str2) throws RemoteException;

    void zzi(zzr zzr) throws RemoteException;

    @Nullable
    List zzj(zzr zzr, boolean z) throws RemoteException;

    @Nullable
    byte[] zzk(zzbg zzbg, String str) throws RemoteException;

    void zzl(long j, @Nullable String str, @Nullable String str2, String str3) throws RemoteException;

    @Nullable
    String zzm(zzr zzr) throws RemoteException;

    void zzn(zzah zzah, zzr zzr) throws RemoteException;

    void zzo(zzah zzah) throws RemoteException;

    List zzp(@Nullable String str, @Nullable String str2, boolean z, zzr zzr) throws RemoteException;

    List zzq(String str, @Nullable String str2, @Nullable String str3, boolean z) throws RemoteException;

    List zzr(@Nullable String str, @Nullable String str2, zzr zzr) throws RemoteException;

    List zzs(String str, @Nullable String str2, @Nullable String str3) throws RemoteException;

    void zzt(zzr zzr) throws RemoteException;

    void zzu(Bundle bundle, zzr zzr) throws RemoteException;

    void zzv(zzr zzr) throws RemoteException;

    zzao zzw(zzr zzr) throws RemoteException;

    List zzx(zzr zzr, Bundle bundle) throws RemoteException;

    void zzy(zzr zzr) throws RemoteException;

    void zzz(zzr zzr) throws RemoteException;
}
