package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;

public class Code93Writer extends OneDimensionalCodeWriter {
    public static void e(boolean[] zArr, int i, int[] iArr) {
        boolean z;
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            if (iArr[i2] != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i] = z;
            i2++;
            i = i3;
        }
    }

    public static int f(int i, String str) {
        int i2 = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            i3++;
            if (i3 > i) {
                i3 = 1;
            }
        }
        return i2 % 47;
    }

    public static void g(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    public final BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap) {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.a(str, barcodeFormat, enumMap);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got " + barcodeFormat);
    }

    public final boolean[] c(String str) {
        int length = str.length();
        if (length <= 80) {
            int i = 9;
            int[] iArr = new int[9];
            boolean[] zArr = new boolean[(((str.length() + 4) * 9) + 1)];
            g(Code93Reader.f427a[47], iArr);
            e(zArr, 0, iArr);
            for (int i2 = 0; i2 < length; i2++) {
                g(Code93Reader.f427a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i2))], iArr);
                e(zArr, i, iArr);
                i += 9;
            }
            int f = f(20, str);
            int[] iArr2 = Code93Reader.f427a;
            g(iArr2[f], iArr);
            e(zArr, i, iArr);
            StringBuilder v = ba.v(str);
            v.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(f));
            g(iArr2[f(15, v.toString())], iArr);
            e(zArr, i + 9, iArr);
            g(iArr2[47], iArr);
            e(zArr, i + 18, iArr);
            zArr[i + 27] = true;
            return zArr;
        }
        throw new IllegalArgumentException(ba.k(length, "Requested contents should be less than 80 digits long, but got "));
    }
}
