package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzej extends zzeq {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzfb zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzej(zzfb zzfb, boolean z) {
        super(zzfb, true);
        this.zza = z;
        Objects.requireNonNull(zzfb);
        this.zzb = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzb.zzQ())).setDataCollectionEnabled(this.zza);
    }
}
