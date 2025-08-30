package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzeo extends zzeq {
    final /* synthetic */ zzes zza;
    final /* synthetic */ zzfb zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzeo(zzfb zzfb, zzes zzes) {
        super(zzfb, true);
        this.zza = zzes;
        Objects.requireNonNull(zzfb);
        this.zzb = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzb.zzQ())).unregisterOnMeasurementEventListener(this.zza);
    }
}
