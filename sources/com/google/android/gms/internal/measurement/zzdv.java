package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdv extends zzeq {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzfb zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdv(zzfb zzfb, Runnable runnable) {
        super(zzfb, true);
        this.zza = runnable;
        Objects.requireNonNull(zzfb);
        this.zzb = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzb.zzQ())).retrieveAndUploadBatches(new zzdu(this, this.zza));
    }
}
