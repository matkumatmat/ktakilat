package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

public final class BarcodeMatrix {

    /* renamed from: a  reason: collision with root package name */
    public final BarcodeRow[] f439a;
    public int b;
    public final int c;
    public final int d;

    public BarcodeMatrix(int i, int i2) {
        this.f439a = new BarcodeRow[i];
        for (int i3 = 0; i3 < i; i3++) {
            this.f439a[i3] = new BarcodeRow(((i2 + 4) * 17) + 1);
        }
        this.d = i2 * 17;
        this.c = i;
        this.b = -1;
    }

    public final BarcodeRow a() {
        return this.f439a[this.b];
    }

    public final byte[][] b(int i, int i2) {
        int i3 = this.c;
        int[] iArr = new int[2];
        iArr[1] = this.d * i;
        iArr[0] = i3 * i2;
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        int i4 = i3 * i2;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i4 - i5) - 1;
            byte[] bArr2 = this.f439a[i5 / i2].f440a;
            int length = bArr2.length * i;
            byte[] bArr3 = new byte[length];
            for (int i7 = 0; i7 < length; i7++) {
                bArr3[i7] = bArr2[i7 / i];
            }
            bArr[i6] = bArr3;
        }
        return bArr;
    }
}
