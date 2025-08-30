package com.google.android.gms.internal.measurement;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class zzed implements ThreadFactory {
    private final ThreadFactory zza = Executors.defaultThreadFactory();

    public zzed(zzfb zzfb) {
        Objects.requireNonNull(zzfb);
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zza.newThread(runnable);
        newThread.setName("ScionFrontendApi");
        return newThread;
    }
}
