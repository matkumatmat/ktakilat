package com.google.android.gms.measurement.internal;

enum zzam {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');
    
    private final char zzk;

    private zzam(char c) {
        this.zzk = c;
    }

    public static zzam zza(char c) {
        for (zzam zzam : values()) {
            if (zzam.zzk == c) {
                return zzam;
            }
        }
        return UNSET;
    }
}
