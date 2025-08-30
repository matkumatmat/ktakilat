package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;

public final class Code39Writer extends OneDimensionalCodeWriter {
    public static void e(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }

    public final BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap) {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.a(str, barcodeFormat, enumMap);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + barcodeFormat);
    }

    public final boolean[] c(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int i = length + 25;
            int i2 = 0;
            while (i2 < length) {
                int indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i2));
                if (indexOf >= 0) {
                    e(Code39Reader.f426a[indexOf], iArr);
                    for (int i3 = 0; i3 < 9; i3++) {
                        i += iArr[i3];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("Bad contents: ".concat(str));
                }
            }
            boolean[] zArr = new boolean[i];
            e(Code39Reader.b, iArr);
            int b = OneDimensionalCodeWriter.b(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int b2 = OneDimensionalCodeWriter.b(zArr, b, iArr2, false) + b;
            for (int i4 = 0; i4 < length; i4++) {
                e(Code39Reader.f426a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i4))], iArr);
                int b3 = OneDimensionalCodeWriter.b(zArr, b2, iArr, true) + b2;
                b2 = OneDimensionalCodeWriter.b(zArr, b3, iArr2, false) + b3;
            }
            e(Code39Reader.b, iArr);
            OneDimensionalCodeWriter.b(zArr, b2, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException(ba.k(length, "Requested contents should be less than 80 digits long, but got "));
    }
}
