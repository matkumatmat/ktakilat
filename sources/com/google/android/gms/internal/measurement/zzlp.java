package com.google.android.gms.internal.measurement;

final class zzlp {
    private final Object zza;
    private final int zzb;

    public zzlp(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzlp)) {
            return false;
        }
        zzlp zzlp = (zzlp) obj;
        if (this.zza == zzlp.zza && this.zzb == zzlp.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
