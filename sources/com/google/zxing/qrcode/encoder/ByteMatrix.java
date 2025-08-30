package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

public final class ByteMatrix {

    /* renamed from: a  reason: collision with root package name */
    public final byte[][] f448a;
    public final int b;
    public final int c;

    public ByteMatrix(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = i;
        iArr[0] = i2;
        this.f448a = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        this.b = i;
        this.c = i2;
    }

    public final byte a(int i, int i2) {
        return this.f448a[i2][i];
    }

    public final void b(int i, int i2, int i3) {
        this.f448a[i2][i] = (byte) i3;
    }

    public final void c(int i, int i2, boolean z) {
        this.f448a[i2][i] = z ? (byte) 1 : 0;
    }

    public final String toString() {
        int i = this.b;
        int i2 = this.c;
        StringBuilder sb = new StringBuilder((i * 2 * i2) + 2);
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                byte b2 = this.f448a[i3][i4];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append(10);
        }
        return sb.toString();
    }
}
