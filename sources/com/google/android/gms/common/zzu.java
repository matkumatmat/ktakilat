package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class zzu extends zzw {
    private final Callable zze;

    public /* synthetic */ zzu(Callable callable, zzv zzv) {
        super(false, 1, 5, (String) null, (Throwable) null, (zzv) null);
        this.zze = callable;
    }

    public final String zza() {
        try {
            return (String) this.zze.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
