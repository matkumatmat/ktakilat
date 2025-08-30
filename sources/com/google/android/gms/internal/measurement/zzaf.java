package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzaf implements zzao {
    private final boolean zza;

    public zzaf(Boolean bool) {
        boolean booleanValue;
        if (bool == null) {
            booleanValue = false;
        } else {
            booleanValue = bool.booleanValue();
        }
        this.zza = booleanValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zzaf) && this.zza == ((zzaf) obj).zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.zza).hashCode();
    }

    public final String toString() {
        return String.valueOf(this.zza);
    }

    public final String zzc() {
        return Boolean.toString(this.zza);
    }

    public final zzao zzcA(String str, zzg zzg, List list) {
        if ("toString".equals(str)) {
            return new zzas(Boolean.toString(this.zza));
        }
        String bool = Boolean.toString(this.zza);
        throw new IllegalArgumentException(bool + "." + str + " is not a function.");
    }

    public final Double zzd() {
        double d;
        if (true != this.zza) {
            d = 0.0d;
        } else {
            d = 1.0d;
        }
        return Double.valueOf(d);
    }

    public final Boolean zze() {
        return Boolean.valueOf(this.zza);
    }

    public final Iterator zzf() {
        return null;
    }

    public final zzao zzt() {
        return new zzaf(Boolean.valueOf(this.zza));
    }
}
