package com.google.zxing.oned;

import org.apache.commons.lang3.ClassUtils;

public final class CodaBarWriter extends OneDimensionalCodeWriter {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f424a;
    public static final char[] b = {'T', 'N', '*', 'E'};
    public static final char[] c = {'/', ':', '+', ClassUtils.PACKAGE_SEPARATOR_CHAR};
    public static final char d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f424a = cArr;
        d = cArr[0];
    }

    public final boolean[] c(String str) {
        int i;
        int length = str.length();
        char c2 = d;
        if (length < 2) {
            str = c2 + str + c2;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f424a;
            boolean a2 = CodaBarReader.a(cArr, upperCase);
            boolean a3 = CodaBarReader.a(cArr, upperCase2);
            char[] cArr2 = b;
            boolean a4 = CodaBarReader.a(cArr2, upperCase);
            boolean a5 = CodaBarReader.a(cArr2, upperCase2);
            if (a2) {
                if (!a3) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (a4) {
                if (!a5) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (a3 || a5) {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
            } else {
                str = c2 + str + c2;
            }
        }
        int i2 = 20;
        for (int i3 = 1; i3 < str.length() - 1; i3++) {
            if (Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                i2 += 9;
            } else if (CodaBarReader.a(c, str.charAt(i3))) {
                i2 += 10;
            } else {
                throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i3) + '\'');
            }
        }
        boolean[] zArr = new boolean[((str.length() - 1) + i2)];
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i5));
            if (i5 == 0 || i5 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i6 = 0;
            while (true) {
                char[] cArr3 = CodaBarReader.f423a;
                if (i6 >= cArr3.length) {
                    i = 0;
                    break;
                } else if (upperCase3 == cArr3[i6]) {
                    i = CodaBarReader.b[i6];
                    break;
                } else {
                    i6++;
                }
            }
            int i7 = 0;
            boolean z = true;
            while (true) {
                int i8 = 0;
                while (i7 < 7) {
                    zArr[i4] = z;
                    i4++;
                    if (((i >> (6 - i7)) & 1) == 0 || i8 == 1) {
                        z = !z;
                        i7++;
                    } else {
                        i8++;
                    }
                }
                break;
            }
            if (i5 < str.length() - 1) {
                zArr[i4] = false;
                i4++;
            }
        }
        return zArr;
    }
}
