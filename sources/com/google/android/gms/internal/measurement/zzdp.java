package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdp extends zzeq {
    final /* synthetic */ zzfb zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdp(zzfb zzfb) {
        super(zzfb, true);
        Objects.requireNonNull(zzfb);
        this.zza = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zza.zzQ())).resetAnalyticsData(this.zzh);
    }
}
