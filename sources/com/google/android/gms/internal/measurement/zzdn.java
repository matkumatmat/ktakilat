package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdn extends zzeq {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzfb zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdn(zzfb zzfb, Boolean bool) {
        super(zzfb, true);
        this.zza = bool;
        Objects.requireNonNull(zzfb);
        this.zzb = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzb.zzQ())).setMeasurementEnabled(this.zza.booleanValue(), this.zzh);
    }
}
