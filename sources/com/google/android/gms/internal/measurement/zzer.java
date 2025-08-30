package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzjo;

final class zzer extends zzcz {
    private final zzjo zza;

    public zzer(zzjo zzjo) {
        this.zza = zzjo;
    }

    public final void zze(String str, String str2, Bundle bundle, long j) {
        this.zza.interceptEvent(str, str2, bundle, j);
    }

    public final int zzf() {
        return System.identityHashCode(this.zza);
    }
}
