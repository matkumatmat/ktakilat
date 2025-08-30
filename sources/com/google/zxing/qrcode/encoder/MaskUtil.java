package com.google.zxing.qrcode.encoder;

final class MaskUtil {
    public static int a(ByteMatrix byteMatrix, boolean z) {
        int i;
        byte b;
        int i2 = byteMatrix.b;
        int i3 = byteMatrix.c;
        if (z) {
            i = i3;
        } else {
            i = i2;
        }
        if (!z) {
            i2 = i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            byte b2 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                byte[][] bArr = byteMatrix.f448a;
                if (z) {
                    b = bArr[i5][i7];
                } else {
                    b = bArr[i7][i5];
                }
                if (b == b2) {
                    i6++;
                } else {
                    if (i6 >= 5) {
                        i4 += i6 - 2;
                    }
                    b2 = b;
                    i6 = 1;
                }
            }
            if (i6 >= 5) {
                i4 = (i6 - 2) + i4;
            }
        }
        return i4;
    }
}
