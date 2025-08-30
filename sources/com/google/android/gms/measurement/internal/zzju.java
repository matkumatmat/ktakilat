package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Executor;

final class zzju implements Executor {
    final /* synthetic */ zzli zza;

    public zzju(zzli zzli) {
        Objects.requireNonNull(zzli);
        this.zza = zzli;
    }

    public final void execute(Runnable runnable) {
        this.zza.zzu.zzaW().zzj(runnable);
    }
}
