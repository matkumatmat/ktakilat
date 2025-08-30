package com.google.android.gms.internal.common;

final class zzo extends zzn {
    private final char zza;

    public zzo(char c) {
        this.zza = c;
    }

    public final String toString() {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        int i = this.zza;
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(i & 15);
            i >>= 4;
        }
        return ba.o("CharMatcher.is('", String.copyValueOf(cArr), "')");
    }

    public final boolean zza(char c) {
        return c == this.zza;
    }
}
