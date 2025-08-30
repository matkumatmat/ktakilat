package io.reactivex.internal.util;

import java.util.ArrayList;

public class LinkedArrayList {
    public final int c;
    public Object[] d;
    public Object[] e;
    public volatile int f;
    public int g;

    public LinkedArrayList(int i) {
        this.c = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r4.f
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0016
            int r0 = r4.c
            int r0 = r0 + r2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r4.d = r0
            r4.e = r0
            r0[r1] = r5
            r4.g = r2
            r4.f = r2
            goto L_0x003c
        L_0x0016:
            int r0 = r4.g
            int r3 = r4.c
            if (r0 != r3) goto L_0x0030
            int r0 = r3 + 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r5
            java.lang.Object[] r5 = r4.e
            r5[r3] = r0
            r4.e = r0
            r4.g = r2
            int r5 = r4.f
            int r5 = r5 + r2
            r4.f = r5
            goto L_0x003c
        L_0x0030:
            java.lang.Object[] r1 = r4.e
            r1[r0] = r5
            int r0 = r0 + r2
            r4.g = r0
            int r5 = r4.f
            int r5 = r5 + r2
            r4.f = r5
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.LinkedArrayList.a(java.lang.Object):void");
    }

    public final String toString() {
        int i = this.c;
        int i2 = this.f;
        ArrayList arrayList = new ArrayList(i2 + 1);
        Object[] objArr = this.d;
        int i3 = 0;
        while (true) {
            int i4 = 0;
            while (i3 < i2) {
                arrayList.add(objArr[i4]);
                i3++;
                i4++;
                if (i4 == i) {
                    objArr = objArr[i];
                }
            }
            return arrayList.toString();
        }
    }
}
