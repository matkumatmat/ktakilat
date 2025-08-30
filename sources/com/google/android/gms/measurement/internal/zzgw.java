package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

@WorkerThread
final class zzgw implements Runnable {
    private final zzgv zza;
    private final int zzb;
    private final Throwable zzc;
    private final byte[] zzd;
    private final String zze;
    private final Map zzf;

    public /* synthetic */ zzgw(String str, zzgv zzgv, int i, Throwable th, byte[] bArr, Map map, byte[] bArr2) {
        Preconditions.checkNotNull(zzgv);
        this.zza = zzgv;
        this.zzb = i;
        this.zzc = th;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = map;
    }

    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
