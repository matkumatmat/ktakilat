package com.google.android.gms.internal.maps;

final class zzbd {
    public static void zza(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        } else if (obj2 == null) {
            throw new NullPointerException(ba.o("null value in entry: ", obj.toString(), "=null"));
        }
    }
}
