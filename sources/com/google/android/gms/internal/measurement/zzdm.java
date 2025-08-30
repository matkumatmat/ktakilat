package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdm extends zzeq {
    final /* synthetic */ zzdf zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzfb zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdm(zzfb zzfb, zzdf zzdf, String str, String str2) {
        super(zzfb, true);
        this.zza = zzdf;
        this.zzb = str;
        this.zzc = str2;
        Objects.requireNonNull(zzfb);
        this.zzd = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzd.zzQ())).setCurrentScreenByScionActivityInfo(this.zza, this.zzb, this.zzc, this.zzh);
    }
}
