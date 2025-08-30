package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;

public abstract class OneDimensionalCodeWriter implements Writer {
    public static int b(boolean[] zArr, int i, int[] iArr, boolean z) {
        int i2 = 0;
        for (int i3 : iArr) {
            int i4 = 0;
            while (i4 < i3) {
                zArr[i] = z;
                i4++;
                i++;
            }
            i2 += i3;
            z = !z;
        }
        return i2;
    }

    public BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap) {
        if (!str.isEmpty()) {
            int d = d();
            EncodeHintType encodeHintType = EncodeHintType.MARGIN;
            if (enumMap.containsKey(encodeHintType)) {
                d = Integer.parseInt(enumMap.get(encodeHintType).toString());
            }
            boolean[] c = c(str);
            int length = c.length;
            int i = d + length;
            int max = Math.max(200, i);
            int max2 = Math.max(1, 200);
            int i2 = max / i;
            int i3 = (max - (length * i2)) / 2;
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i4 = 0;
            while (i4 < length) {
                if (c[i4]) {
                    bitMatrix.c(i3, 0, i2, max2);
                }
                i4++;
                i3 += i2;
            }
            return bitMatrix;
        }
        throw new IllegalArgumentException("Found empty contents");
    }

    public abstract boolean[] c(String str);

    public int d() {
        return 10;
    }
}
