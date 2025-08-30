package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdk extends zzeq {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzco zzc;
    final /* synthetic */ zzfb zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdk(zzfb zzfb, String str, String str2, zzco zzco) {
        super(zzfb, true);
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzco;
        Objects.requireNonNull(zzfb);
        this.zzd = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzd.zzQ())).getConditionalUserProperties(this.zza, this.zzb, this.zzc);
    }

    public final void zzb() {
        this.zzc.zzb((Bundle) null);
    }
}
