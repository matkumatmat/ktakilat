package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

final class zzec extends zzeq {
    final /* synthetic */ String zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzfb zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzec(zzfb zzfb, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(zzfb, false);
        this.zza = str;
        this.zzb = obj;
        Objects.requireNonNull(zzfb);
        this.zzc = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzc.zzQ())).logHealthData(5, this.zza, ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(null), ObjectWrapper.wrap(null));
    }
}
