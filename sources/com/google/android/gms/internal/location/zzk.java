package com.google.android.gms.internal.location;

import android.os.DeadObjectException;
import android.os.IInterface;

final class zzk implements zzbi<zzal> {
    private final /* synthetic */ zzh zza;

    public zzk(zzh zzh) {
        this.zza = zzh;
    }

    public final void zza() {
        this.zza.checkConnected();
    }

    public final /* synthetic */ IInterface zzb() throws DeadObjectException {
        return (zzal) this.zza.getService();
    }
}
