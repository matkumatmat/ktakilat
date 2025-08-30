package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzt;
import java.util.concurrent.Callable;

final /* synthetic */ class zzhp implements Callable {
    private final /* synthetic */ zzhs zza;

    public /* synthetic */ zzhp(zzhs zzhs) {
        this.zza = zzhs;
    }

    public final /* synthetic */ Object call() {
        return new zzt(this.zza.zze);
    }
}
