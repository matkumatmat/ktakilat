package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

final class zzac implements Iterator {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ Iterator zzb;

    public zzac(zzae zzae, Iterator it, Iterator it2) {
        this.zza = it;
        this.zzb = it2;
        Objects.requireNonNull(zzae);
    }

    public final boolean hasNext() {
        if (this.zza.hasNext()) {
            return true;
        }
        return this.zzb.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Iterator it = this.zza;
        if (it.hasNext()) {
            return new zzas(((Integer) it.next()).toString());
        }
        Iterator it2 = this.zzb;
        if (it2.hasNext()) {
            return new zzas((String) it2.next());
        }
        throw new NoSuchElementException();
    }
}
