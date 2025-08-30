package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;

public final class ITFWriter extends OneDimensionalCodeWriter {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f429a = {1, 1, 1, 1};
    public static final int[] b = {3, 1, 1};

    public final BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap) {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.a(str, barcodeFormat, enumMap);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + barcodeFormat);
    }

    public final boolean[] c(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        } else if (length <= 80) {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int b2 = OneDimensionalCodeWriter.b(zArr, 0, f429a, true);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[18];
                for (int i2 = 0; i2 < 5; i2++) {
                    int i3 = i2 * 2;
                    int[][] iArr2 = ITFReader.f428a;
                    iArr[i3] = iArr2[digit][i2];
                    iArr[i3 + 1] = iArr2[digit2][i2];
                }
                b2 += OneDimensionalCodeWriter.b(zArr, b2, iArr, true);
            }
            OneDimensionalCodeWriter.b(zArr, b2, b, true);
            return zArr;
        } else {
            throw new IllegalArgumentException(ba.k(length, "Requested contents should be less than 80 digits long, but got "));
        }
    }
}
