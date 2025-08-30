package com.google.android.gms.measurement.internal;

public enum zzlr {
    GOOGLE_ANALYTICS(0),
    GOOGLE_SIGNAL(1),
    SGTM(2),
    SGTM_CLIENT(3),
    GOOGLE_SIGNAL_PENDING(4),
    UNKNOWN(99);
    
    private final int zzg;

    private zzlr(int i) {
        this.zzg = i;
    }

    public static zzlr zzb(int i) {
        for (zzlr zzlr : values()) {
            if (zzlr.zzg == i) {
                return zzlr;
            }
        }
        return UNKNOWN;
    }

    public final int zza() {
        return this.zzg;
    }
}
