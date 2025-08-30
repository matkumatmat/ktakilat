package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzab;

public final class IndoorLevel {
    private final zzab zza;

    public IndoorLevel(zzab zzab) {
        this.zza = (zzab) Preconditions.checkNotNull(zzab);
    }

    public void activate() {
        try {
            this.zza.zzg();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.zza.zzh(((IndoorLevel) obj).zza);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @NonNull
    public String getName() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @NonNull
    public String getShortName() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
