package com.google.android.gms.internal.fido;

import java.util.Iterator;
import javax.annotation.CheckForNull;

final class zzay extends zzau {
    final transient Object zza;

    public zzay(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzav(this.zza);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        return ba.o("[", this.zza.toString(), "]");
    }

    public final int zza(Object[] objArr, int i) {
        objArr[0] = this.zza;
        return 1;
    }

    public final zzaz zzd() {
        return new zzav(this.zza);
    }
}
