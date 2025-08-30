package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class zzaj implements Iterator {
    final /* synthetic */ Iterator zza;

    public zzaj(Iterator it) {
        this.zza = it;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return new zzas((String) this.zza.next());
    }
}
