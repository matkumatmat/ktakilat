package com.google.android.gms.internal.auth;

import com.google.common.primitives.UnsignedBytes;
import java.util.Comparator;

final class zzdx implements Comparator {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzef zzef = (zzef) obj;
        zzef zzef2 = (zzef) obj2;
        zzdw zzdw = new zzdw(zzef);
        zzdw zzdw2 = new zzdw(zzef2);
        while (zzdw.hasNext() && zzdw2.hasNext()) {
            int compareTo = Integer.valueOf(zzdw.zza() & UnsignedBytes.MAX_VALUE).compareTo(Integer.valueOf(zzdw2.zza() & UnsignedBytes.MAX_VALUE));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzef.zzd()).compareTo(Integer.valueOf(zzef2.zzd()));
    }
}
