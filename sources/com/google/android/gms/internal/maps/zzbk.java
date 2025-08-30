package com.google.android.gms.internal.maps;

import java.util.Arrays;

public final class zzbk {
    Object[] zza;
    int zzb;
    zzbj zzc;

    public zzbk() {
        this(4);
    }

    private final void zzb(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            int i3 = length + (length >> 1) + 1;
            if (i3 < i2) {
                int highestOneBit = Integer.highestOneBit(i2 - 1);
                i3 = highestOneBit + highestOneBit;
            }
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i3);
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.maps.zzbk zza(java.lang.Iterable r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof java.util.Collection
            if (r0 == 0) goto L_0x000e
            int r0 = r5.zzb
            int r1 = r6.size()
            int r1 = r1 + r0
            r5.zzb(r1)
        L_0x000e:
            java.util.Iterator r6 = r6.iterator()
        L_0x0012:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0041
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.Object r0 = r0.getValue()
            int r2 = r5.zzb
            int r2 = r2 + 1
            r5.zzb(r2)
            com.google.android.gms.internal.maps.zzbd.zza(r1, r0)
            java.lang.Object[] r2 = r5.zza
            int r3 = r5.zzb
            int r4 = r3 + r3
            r2[r4] = r1
            int r4 = r4 + 1
            r2[r4] = r0
            int r3 = r3 + 1
            r5.zzb = r3
            goto L_0x0012
        L_0x0041:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.maps.zzbk.zza(java.lang.Iterable):com.google.android.gms.internal.maps.zzbk");
    }

    public zzbk(int i) {
        this.zza = new Object[(i + i)];
        this.zzb = 0;
    }
}
