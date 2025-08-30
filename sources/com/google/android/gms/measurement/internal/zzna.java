package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import java.util.Objects;

final class zzna implements Runnable {
    final /* synthetic */ zzne zza;

    public zzna(zzne zzne) {
        Objects.requireNonNull(zzne);
        this.zza = zzne;
    }

    public final void run() {
        zznk zznk = this.zza.zza;
        zzib zzib = zznk.zzu;
        Context zzaY = zzib.zzaY();
        zzib.zzaU();
        zznk.zzW(new ComponentName(zzaY, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
