package com.google.android.gms.measurement.internal;

import java.util.Iterator;
import java.util.Objects;

final class zzbd implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzbe zzb;

    public zzbd(zzbe zzbe) {
        Objects.requireNonNull(zzbe);
        this.zzb = zzbe;
        this.zza = zzbe.zzg().keySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    /* renamed from: zza */
    public final String next() {
        return (String) this.zza.next();
    }
}
