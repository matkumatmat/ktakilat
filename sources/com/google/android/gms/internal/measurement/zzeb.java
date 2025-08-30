package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzeb extends zzeq {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzco zzd;
    final /* synthetic */ zzfb zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzeb(zzfb zzfb, String str, String str2, boolean z, zzco zzco) {
        super(zzfb, true);
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzco;
        Objects.requireNonNull(zzfb);
        this.zze = zzfb;
    }

    public final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zze.zzQ())).getUserProperties(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public final void zzb() {
        this.zzd.zzb((Bundle) null);
    }
}
