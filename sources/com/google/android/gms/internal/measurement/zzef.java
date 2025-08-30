package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzef extends zzeq {
    final /* synthetic */ String zza;
    final /* synthetic */ zzco zzb;
    final /* synthetic */ zzfb zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzef(zzfb zzfb, String str, zzco zzco) {
        super(zzfb, true);
        this.zza = str;
        this.zzb = zzco;
        Objects.requireNonNull(zzfb);
        this.zzc = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzc.zzQ())).getMaxUserProperties(this.zza, this.zzb);
    }

    public final void zzb() {
        this.zzb.zzb((Bundle) null);
    }
}
