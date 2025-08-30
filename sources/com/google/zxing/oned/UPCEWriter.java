package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;

public final class UPCEWriter extends UPCEANWriter {
    public final BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap) {
        if (barcodeFormat == BarcodeFormat.UPC_E) {
            return super.a(str, barcodeFormat, enumMap);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got " + barcodeFormat);
    }

    public final boolean[] c(String str) {
        if (str.length() == 8) {
            int i = UPCEReader.f[Integer.parseInt(str.substring(7, 8))];
            boolean[] zArr = new boolean[51];
            int b = OneDimensionalCodeWriter.b(zArr, 0, UPCEANReader.f431a, true);
            int i2 = 1;
            while (i2 <= 6) {
                int i3 = i2 + 1;
                int parseInt = Integer.parseInt(str.substring(i2, i3));
                if (((i >> (6 - i2)) & 1) == 1) {
                    parseInt += 10;
                }
                b += OneDimensionalCodeWriter.b(zArr, b, UPCEANReader.e[parseInt], false);
                i2 = i3;
            }
            OneDimensionalCodeWriter.b(zArr, b, UPCEANReader.c, false);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
    }
}
