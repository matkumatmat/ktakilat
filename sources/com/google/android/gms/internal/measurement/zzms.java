package com.google.android.gms.internal.measurement;

import java.util.Map;

final class zzms implements Map.Entry {
    private final Map.Entry zza;

    public /* synthetic */ zzms(Map.Entry entry, byte[] bArr) {
        this.zza = entry;
    }

    public final Object getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (((zzmu) this.zza.getValue()) == null) {
            return null;
        }
        throw null;
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zznl) {
            return ((zzmu) this.zza.getValue()).zza((zznl) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzmu zza() {
        return (zzmu) this.zza.getValue();
    }
}
