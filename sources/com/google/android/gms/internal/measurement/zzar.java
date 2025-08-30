package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

final class zzar implements Iterator {
    final /* synthetic */ zzas zza;
    private int zzb = 0;

    public zzar(zzas zzas) {
        Objects.requireNonNull(zzas);
        this.zza = zzas;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza.zzb().length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        zzas zzas = this.zza;
        String zzb2 = zzas.zzb();
        int i = this.zzb;
        if (i < zzb2.length()) {
            this.zzb = i + 1;
            return new zzas(String.valueOf(zzas.zzb().charAt(i)));
        }
        throw new NoSuchElementException();
    }
}
