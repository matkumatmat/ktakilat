package com.google.zxing.common;

import java.util.Arrays;
import org.apache.commons.lang3.ClassUtils;

public final class BitArray implements Cloneable {
    public int[] c = new int[1];
    public int d = 0;

    public final void a(boolean z) {
        c(this.d + 1);
        if (z) {
            int[] iArr = this.c;
            int i = this.d;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.d++;
    }

    public final void b(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        c(this.d + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            a(z);
            i2--;
        }
    }

    public final void c(int i) {
        int[] iArr = this.c;
        if (i > (iArr.length << 5)) {
            int[] iArr2 = new int[((i + 31) / 32)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.c = iArr2;
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, com.google.zxing.common.BitArray] */
    public final Object clone() {
        int i = this.d;
        ? obj = new Object();
        obj.c = (int[]) this.c.clone();
        obj.d = i;
        return obj;
    }

    public final boolean d(int i) {
        if (((1 << (i & 31)) & this.c[i / 32]) != 0) {
            return true;
        }
        return false;
    }

    public final int e() {
        return (this.d + 7) / 8;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        if (this.d != bitArray.d || !Arrays.equals(this.c, bitArray.c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.c) + (this.d * 31);
    }

    public final String toString() {
        char c2;
        StringBuilder sb = new StringBuilder(this.d);
        for (int i = 0; i < this.d; i++) {
            if ((i & 7) == 0) {
                sb.append(' ');
            }
            if (d(i)) {
                c2 = 'X';
            } else {
                c2 = ClassUtils.PACKAGE_SEPARATOR_CHAR;
            }
            sb.append(c2);
        }
        return sb.toString();
    }
}
