package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdt extends zzeq {
    final /* synthetic */ String zza;
    final /* synthetic */ zzfb zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdt(zzfb zzfb, String str) {
        super(zzfb, true);
        this.zza = str;
        Objects.requireNonNull(zzfb);
        this.zzb = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzb.zzQ())).endAdUnitExposure(this.zza, this.zzi);
    }
}
