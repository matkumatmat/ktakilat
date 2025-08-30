package com.google.android.gms.internal.measurement;

public enum zzos {
    DOUBLE(zzot.DOUBLE, 1),
    FLOAT(zzot.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzot.BOOLEAN, 0),
    STRING(zzot.STRING, 2),
    GROUP(r6, 3),
    MESSAGE(r6, 2),
    BYTES(zzot.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzot.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzot zzs;
    private final int zzt;

    private zzos(zzot zzot, int i) {
        this.zzs = zzot;
        this.zzt = i;
    }

    public final zzot zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
