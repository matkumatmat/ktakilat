package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;

public final class EAN8Writer extends UPCEANWriter {
    public final BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap) {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, enumMap);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + barcodeFormat);
    }

    public final boolean[] c(String str) {
        if (str.length() == 8) {
            boolean[] zArr = new boolean[67];
            int b = OneDimensionalCodeWriter.b(zArr, 0, UPCEANReader.f431a, true);
            int i = 0;
            while (i <= 3) {
                int i2 = i + 1;
                b += OneDimensionalCodeWriter.b(zArr, b, UPCEANReader.d[Integer.parseInt(str.substring(i, i2))], false);
                i = i2;
            }
            int b2 = OneDimensionalCodeWriter.b(zArr, b, UPCEANReader.b, false) + b;
            int i3 = 4;
            while (i3 <= 7) {
                int i4 = i3 + 1;
                b2 += OneDimensionalCodeWriter.b(zArr, b2, UPCEANReader.d[Integer.parseInt(str.substring(i3, i4))], true);
                i3 = i4;
            }
            OneDimensionalCodeWriter.b(zArr, b2, UPCEANReader.f431a, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
    }
}
