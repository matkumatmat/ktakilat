package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzhl extends LruCache {
    final /* synthetic */ zzhs zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzhl(zzhs zzhs, int i) {
        super(20);
        Objects.requireNonNull(zzhs);
        this.zza = zzhs;
    }

    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return this.zza.zzC(str);
    }
}
