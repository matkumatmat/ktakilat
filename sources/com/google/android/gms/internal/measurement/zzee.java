package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzee extends zzeq {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzco zzb;
    final /* synthetic */ zzfb zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzee(zzfb zzfb, Bundle bundle, zzco zzco) {
        super(zzfb, true);
        this.zza = bundle;
        this.zzb = zzco;
        Objects.requireNonNull(zzfb);
        this.zzc = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzc.zzQ())).performAction(this.zza, this.zzb, this.zzh);
    }

    public final void zzb() {
        this.zzb.zzb((Bundle) null);
    }
}
