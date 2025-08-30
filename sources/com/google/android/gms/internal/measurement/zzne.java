package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzne {
    private final zznd zza;

    private zzne(zzos zzos, Object obj, zzos zzos2, Object obj2) {
        this.zza = new zznd(zzos, "", zzos2, "");
    }

    public static zzne zza(zzos zzos, Object obj, zzos zzos2, Object obj2) {
        return new zzne(zzos, "", zzos2, "");
    }

    public static void zzb(zzll zzll, zznd zznd, Object obj, Object obj2) throws IOException {
        zzlv.zzf(zzll, zznd.zza, 1, obj);
        zzlv.zzf(zzll, zznd.zzc, 2, obj2);
    }

    public static int zzc(zznd zznd, Object obj, Object obj2) {
        return zzlv.zzh(zznd.zza, 1, obj) + zzlv.zzh(zznd.zzc, 2, obj2);
    }

    public final int zzd(int i, Object obj, Object obj2) {
        zznd zznd = this.zza;
        int zzz = zzll.zzz(i << 3);
        int zzc = zzc(zznd, obj, obj2);
        return ba.c(zzc, zzc, zzz);
    }

    public final zznd zze() {
        return this.zza;
    }
}
