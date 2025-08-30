package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.Objects;

final class zzjv extends ContentObserver {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzjv(zzjx zzjx, Handler handler) {
        super((Handler) null);
        Objects.requireNonNull(zzjx);
    }

    public final void onChange(boolean z) {
        zzkl.zzc();
    }
}
