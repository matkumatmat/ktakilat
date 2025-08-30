package com.google.android.gms.internal.maps;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzbq extends zzbm {
    private final transient zzbl zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    /* access modifiers changed from: private */
    public final transient int zzc;

    public zzbq(zzbl zzbl, Object[] objArr, int i, int i2) {
        this.zza = zzbl;
        this.zzb = objArr;
        this.zzc = i2;
    }

    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i) {
        return zzg().zza(objArr, 0);
    }

    public final zzbx zzd() {
        return zzg().listIterator(0);
    }

    public final zzbi zzh() {
        return new zzbp(this);
    }
}
