package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

final class zzad implements Iterator {
    final /* synthetic */ zzae zza;
    private int zzb = 0;

    public zzad(zzae zzae) {
        Objects.requireNonNull(zzae);
        this.zza = zzae;
    }

    public final boolean hasNext() {
        if (this.zzb < this.zza.zzh()) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        zzae zzae = this.zza;
        if (this.zzb < zzae.zzh()) {
            int i = this.zzb;
            this.zzb = i + 1;
            return zzae.zzl(i);
        }
        int i2 = this.zzb;
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i2);
        throw new NoSuchElementException(sb.toString());
    }
}
