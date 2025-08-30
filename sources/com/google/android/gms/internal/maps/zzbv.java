package com.google.android.gms.internal.maps;

import java.util.Set;

public final class zzbv {
    public static int zza(Set set) {
        int i;
        int i2 = 0;
        for (Object next : set) {
            if (next != null) {
                i = next.hashCode();
            } else {
                i = 0;
            }
            i2 += i;
        }
        return i2;
    }
}
