package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzez extends zzeq {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzfa zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzez(zzfa zzfa, Activity activity) {
        super(zzfa.zza, true);
        this.zza = activity;
        Objects.requireNonNull(zzfa);
        this.zzb = zzfa;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzb.zza.zzQ())).onActivityDestroyedByScionActivityInfo(zzdf.zza(this.zza), this.zzi);
    }
}
