package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzep extends zzeq {
    final /* synthetic */ Long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;
    final /* synthetic */ zzfb zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzep(zzfb zzfb, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzfb, true);
        this.zza = l;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bundle;
        this.zze = z;
        this.zzf = z2;
        Objects.requireNonNull(zzfb);
        this.zzg = zzfb;
    }

    public final void zza() throws RemoteException {
        long longValue;
        Long l = this.zza;
        if (l == null) {
            longValue = this.zzh;
        } else {
            longValue = l.longValue();
        }
        ((zzcr) Preconditions.checkNotNull(this.zzg.zzQ())).logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, longValue);
    }
}
