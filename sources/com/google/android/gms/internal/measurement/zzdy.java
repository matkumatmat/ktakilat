package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdy extends zzeq {
    final /* synthetic */ zzco zza;
    final /* synthetic */ zzfb zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdy(zzfb zzfb, zzco zzco) {
        super(zzfb, true);
        this.zza = zzco;
        Objects.requireNonNull(zzfb);
        this.zzb = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzb.zzQ())).generateEventId(this.zza);
    }

    public final void zzb() {
        this.zza.zzb((Bundle) null);
    }
}
