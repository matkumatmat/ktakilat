package com.google.android.gms.internal.common;

import org.jspecify.annotations.NullMarked;

@NullMarked
public final class zzal {
    public static Object[] zza(Object[] objArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            if (objArr[i2] != null) {
                i2++;
            } else {
                throw new NullPointerException(ba.k(i2, "at index "));
            }
        }
        return objArr;
    }
}
