package com.google.zxing.common;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public final class BitMatrix implements Cloneable {
    public final int c;
    public final int d;
    public final int e;
    public final int[] f;

    public BitMatrix(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.c = i;
        this.d = i2;
        int i3 = (i + 31) / 32;
        this.e = i3;
        this.f = new int[(i3 * i2)];
    }

    public final boolean a(int i, int i2) {
        if (((this.f[(i / 32) + (i2 * this.e)] >>> (i & 31)) & 1) != 0) {
            return true;
        }
        return false;
    }

    public final void b(int i, int i2) {
        int i3 = (i / 32) + (i2 * this.e);
        int[] iArr = this.f;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public final void c(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.d || i5 > this.c) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.e * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int i9 = (i8 / 32) + i7;
                    int[] iArr = this.f;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public final Object clone() {
        int i = this.e;
        return new BitMatrix(this.c, this.d, i, (int[]) this.f.clone());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r4 = (com.google.zxing.common.BitMatrix) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.google.zxing.common.BitMatrix
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            com.google.zxing.common.BitMatrix r4 = (com.google.zxing.common.BitMatrix) r4
            int r0 = r4.c
            int r2 = r3.c
            if (r2 != r0) goto L_0x0026
            int r0 = r3.d
            int r2 = r4.d
            if (r0 != r2) goto L_0x0026
            int r0 = r3.e
            int r2 = r4.e
            if (r0 != r2) goto L_0x0026
            int[] r0 = r3.f
            int[] r4 = r4.f
            boolean r4 = java.util.Arrays.equals(r0, r4)
            if (r4 == 0) goto L_0x0026
            r4 = 1
            return r4
        L_0x0026:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.BitMatrix.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = this.c;
        return Arrays.hashCode(this.f) + (((((((i * 31) + i) * 31) + this.d) * 31) + this.e) * 31);
    }

    public final String toString() {
        String str;
        int i = this.c;
        int i2 = this.d;
        StringBuilder sb = new StringBuilder((i + 1) * i2);
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                if (a(i4, i3)) {
                    str = "X ";
                } else {
                    str = "  ";
                }
                sb.append(str);
            }
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }

    public BitMatrix(int i, int i2, int i3, int[] iArr) {
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = iArr;
    }
}
