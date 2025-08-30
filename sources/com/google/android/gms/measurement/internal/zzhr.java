package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;
import java.util.concurrent.Callable;

final /* synthetic */ class zzhr implements Callable {
    private final /* synthetic */ zzhs zza;
    private final /* synthetic */ String zzb;

    public /* synthetic */ zzhr(zzhs zzhs, String str) {
        this.zza = zzhs;
        this.zzb = str;
    }

    public final /* synthetic */ Object call() {
        return new zzn("internal.remoteConfig", new zzhn(this.zza, this.zzb));
    }
}
