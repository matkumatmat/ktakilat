package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzei extends zzeq {
    final /* synthetic */ zzco zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzfb zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzei(zzfb zzfb, zzco zzco, int i) {
        super(zzfb, true);
        this.zza = zzco;
        this.zzb = i;
        Objects.requireNonNull(zzfb);
        this.zzc = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzc.zzQ())).getTestFlag(this.zza, this.zzb);
    }

    public final void zzb() {
        this.zza.zzb((Bundle) null);
    }
}
