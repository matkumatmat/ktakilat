package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;

final class PDF417CodewordDecoder {

    /* renamed from: a  reason: collision with root package name */
    public static final float[][] f436a;

    static {
        int i;
        int[] iArr = new int[2];
        iArr[1] = 8;
        iArr[0] = 2787;
        f436a = (float[][]) Array.newInstance(Float.TYPE, iArr);
        for (int i2 = 0; i2 < 2787; i2++) {
            int i3 = PDF417Common.f433a[i2];
            int i4 = i3 & 1;
            int i5 = 0;
            while (i5 < 8) {
                float f = 0.0f;
                while (true) {
                    i = i3 & 1;
                    if (i != i4) {
                        break;
                    }
                    f += 1.0f;
                    i3 >>= 1;
                }
                f436a[i2][7 - i5] = f / 17.0f;
                i5++;
                i4 = i;
            }
        }
    }
}
