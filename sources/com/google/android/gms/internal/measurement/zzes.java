package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzjp;

final class zzes extends zzcz {
    private final zzjp zza;

    public zzes(zzjp zzjp) {
        this.zza = zzjp;
    }

    public final void zze(String str, String str2, Bundle bundle, long j) {
        this.zza.onEvent(str, str2, bundle, j);
    }

    public final int zzf() {
        return System.identityHashCode(this.zza);
    }
}
