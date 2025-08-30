package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

final class zzaq implements Iterator {
    final /* synthetic */ zzas zza;
    private int zzb = 0;

    public zzaq(zzas zzas) {
        Objects.requireNonNull(zzas);
        this.zza = zzas;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza.zzb().length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        String zzb2 = this.zza.zzb();
        int i = this.zzb;
        if (i < zzb2.length()) {
            this.zzb = i + 1;
            return new zzas(String.valueOf(i));
        }
        throw new NoSuchElementException();
    }
}
