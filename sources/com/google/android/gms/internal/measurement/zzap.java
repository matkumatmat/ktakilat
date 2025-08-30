package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzap implements zzao {
    private final String zza;
    private final ArrayList zzb;

    public zzap(String str, List list) {
        this.zza = str;
        ArrayList arrayList = new ArrayList();
        this.zzb = arrayList;
        arrayList.addAll(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzap)) {
            return false;
        }
        zzap zzap = (zzap) obj;
        String str = this.zza;
        if (str == null ? zzap.zza == null : str.equals(zzap.zza)) {
            return this.zzb.equals(zzap.zzb);
        }
        return false;
    }

    public final int hashCode() {
        int i;
        String str = this.zza;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return this.zzb.hashCode() + (i * 31);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    public final zzao zzcA(String str, zzg zzg, List list) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    public final Double zzd() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    public final Boolean zze() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    public final Iterator zzf() {
        return null;
    }

    public final ArrayList zzg() {
        return this.zzb;
    }

    public final zzao zzt() {
        return this;
    }
}
