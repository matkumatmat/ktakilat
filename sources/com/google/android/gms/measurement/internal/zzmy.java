package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import java.util.Objects;

final class zzmy implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzne zzb;

    public zzmy(zzne zzne, ComponentName componentName) {
        this.zza = componentName;
        Objects.requireNonNull(zzne);
        this.zzb = zzne;
    }

    public final void run() {
        this.zzb.zza.zzW(this.zza);
    }
}
