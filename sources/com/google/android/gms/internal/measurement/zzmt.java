package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzmt implements Iterator {
    private final Iterator zza;

    public zzmt(Iterator it) {
        this.zza = it;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        if (entry.getValue() instanceof zzmu) {
            return new zzms(entry, (byte[]) null);
        }
        return entry;
    }

    public final void remove() {
        this.zza.remove();
    }
}
