package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzu;
import java.util.concurrent.Callable;

final /* synthetic */ class zzho implements Callable {
    private final /* synthetic */ zzhs zza;
    private final /* synthetic */ String zzb;

    public /* synthetic */ zzho(zzhs zzhs, String str) {
        this.zza = zzhs;
        this.zzb = str;
    }

    public final /* synthetic */ Object call() {
        return new zzu("internal.appMetadata", new zzhq(this.zza, this.zzb));
    }
}
