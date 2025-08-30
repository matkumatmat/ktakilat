package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzey extends zzeq {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzco zzb;
    final /* synthetic */ zzfa zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzey(zzfa zzfa, Activity activity, zzco zzco) {
        super(zzfa.zza, true);
        this.zza = activity;
        this.zzb = zzco;
        Objects.requireNonNull(zzfa);
        this.zzc = zzfa;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzc.zza.zzQ())).onActivitySaveInstanceStateByScionActivityInfo(zzdf.zza(this.zza), this.zzb, this.zzi);
    }
}
