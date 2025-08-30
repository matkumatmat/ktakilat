package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzem extends zzeq {
    final /* synthetic */ Intent zza;
    final /* synthetic */ zzfb zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzem(zzfb zzfb, Intent intent) {
        super(zzfb, true);
        this.zza = intent;
        Objects.requireNonNull(zzfb);
        this.zzb = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzb.zzQ())).setSgtmDebugInfo(this.zza);
    }
}
