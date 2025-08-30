package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;

public final class Code128Writer extends OneDimensionalCodeWriter {

    public enum CType {
    }

    public static CType e(int i, String str) {
        int length = str.length();
        CType cType = CType.c;
        if (i >= length) {
            return cType;
        }
        char charAt = str.charAt(i);
        if (charAt == 241) {
            return CType.f;
        }
        if (charAt >= '0' && charAt <= '9') {
            int i2 = i + 1;
            cType = CType.d;
            if (i2 >= length) {
                return cType;
            }
            char charAt2 = str.charAt(i2);
            if (charAt2 >= '0' && charAt2 <= '9') {
                return CType.e;
            }
        }
        return cType;
    }

    public final BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap) {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, enumMap);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0074, code lost:
        if (e(r6 + 3, r0) == r15) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0087, code lost:
        if (r11 == r14) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0092, code lost:
        if (r11 == r15) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x003f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean[] c(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r17
            int r1 = r17.length()
            if (r1 <= 0) goto L_0x011f
            r2 = 80
            if (r1 > r2) goto L_0x011f
            r3 = 0
        L_0x000d:
            r4 = 32
            if (r3 >= r1) goto L_0x0035
            char r5 = r0.charAt(r3)
            if (r5 < r4) goto L_0x001b
            r4 = 126(0x7e, float:1.77E-43)
            if (r5 <= r4) goto L_0x0032
        L_0x001b:
            switch(r5) {
                case 241: goto L_0x0032;
                case 242: goto L_0x0032;
                case 243: goto L_0x0032;
                case 244: goto L_0x0032;
                default: goto L_0x001e;
            }
        L_0x001e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Bad character in input: "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0032:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x0035:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r5 = 1
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 1
        L_0x003f:
            int[][] r10 = com.google.zxing.oned.Code128Reader.f425a
            if (r6 >= r1) goto L_0x00dc
            com.google.zxing.oned.Code128Writer$CType r11 = e(r6, r0)
            com.google.zxing.oned.Code128Writer$CType r12 = com.google.zxing.oned.Code128Writer.CType.c
            r13 = 100
            if (r11 == r12) goto L_0x0079
            com.google.zxing.oned.Code128Writer$CType r14 = com.google.zxing.oned.Code128Writer.CType.d
            if (r11 != r14) goto L_0x0052
            goto L_0x0079
        L_0x0052:
            r15 = 99
            if (r8 != r15) goto L_0x0058
        L_0x0056:
            r15 = r8
            goto L_0x0095
        L_0x0058:
            com.google.zxing.oned.Code128Writer$CType r2 = com.google.zxing.oned.Code128Writer.CType.f
            com.google.zxing.oned.Code128Writer$CType r15 = com.google.zxing.oned.Code128Writer.CType.e
            if (r8 != r13) goto L_0x008a
            if (r11 != r2) goto L_0x0061
            goto L_0x0056
        L_0x0061:
            int r11 = r6 + 2
            com.google.zxing.oned.Code128Writer$CType r11 = e(r11, r0)
            if (r11 == r12) goto L_0x0056
            if (r11 != r14) goto L_0x006c
            goto L_0x0056
        L_0x006c:
            if (r11 != r2) goto L_0x007c
            int r2 = r6 + 3
            com.google.zxing.oned.Code128Writer$CType r2 = e(r2, r0)
            if (r2 != r15) goto L_0x0079
        L_0x0076:
            r15 = 99
            goto L_0x0095
        L_0x0079:
            r15 = 100
            goto L_0x0095
        L_0x007c:
            int r2 = r6 + 4
        L_0x007e:
            com.google.zxing.oned.Code128Writer$CType r11 = e(r2, r0)
            if (r11 != r15) goto L_0x0087
            int r2 = r2 + 2
            goto L_0x007e
        L_0x0087:
            if (r11 != r14) goto L_0x0076
            goto L_0x0079
        L_0x008a:
            if (r11 != r2) goto L_0x0092
            int r2 = r6 + 1
            com.google.zxing.oned.Code128Writer$CType r11 = e(r2, r0)
        L_0x0092:
            if (r11 != r15) goto L_0x0079
            goto L_0x0076
        L_0x0095:
            if (r15 != r8) goto L_0x00be
            char r2 = r0.charAt(r6)
            switch(r2) {
                case 241: goto L_0x00ba;
                case 242: goto L_0x00b7;
                case 243: goto L_0x00b4;
                case 244: goto L_0x00bc;
                default: goto L_0x009e;
            }
        L_0x009e:
            if (r8 != r13) goto L_0x00a7
            char r2 = r0.charAt(r6)
            int r13 = r2 + -32
            goto L_0x00bc
        L_0x00a7:
            int r2 = r6 + 2
            java.lang.String r2 = r0.substring(r6, r2)
            int r13 = java.lang.Integer.parseInt(r2)
            int r6 = r6 + 1
            goto L_0x00bc
        L_0x00b4:
            r13 = 96
            goto L_0x00bc
        L_0x00b7:
            r13 = 97
            goto L_0x00bc
        L_0x00ba:
            r13 = 102(0x66, float:1.43E-43)
        L_0x00bc:
            int r6 = r6 + r5
            goto L_0x00ce
        L_0x00be:
            if (r8 != 0) goto L_0x00cc
            if (r15 != r13) goto L_0x00c7
            r2 = 104(0x68, float:1.46E-43)
            r13 = 104(0x68, float:1.46E-43)
            goto L_0x00cd
        L_0x00c7:
            r2 = 105(0x69, float:1.47E-43)
            r13 = 105(0x69, float:1.47E-43)
            goto L_0x00cd
        L_0x00cc:
            r13 = r15
        L_0x00cd:
            r8 = r15
        L_0x00ce:
            r2 = r10[r13]
            r3.add(r2)
            int r13 = r13 * r9
            int r7 = r7 + r13
            if (r6 == 0) goto L_0x003f
            int r9 = r9 + 1
            goto L_0x003f
        L_0x00dc:
            int r7 = r7 % 103
            r0 = r10[r7]
            r3.add(r0)
            r0 = 106(0x6a, float:1.49E-43)
            r0 = r10[r0]
            r3.add(r0)
            java.util.Iterator r0 = r3.iterator()
            r1 = 0
        L_0x00ef:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0105
            java.lang.Object r2 = r0.next()
            int[] r2 = (int[]) r2
            int r4 = r2.length
            r6 = 0
        L_0x00fd:
            if (r6 >= r4) goto L_0x00ef
            r7 = r2[r6]
            int r1 = r1 + r7
            int r6 = r6 + 1
            goto L_0x00fd
        L_0x0105:
            boolean[] r0 = new boolean[r1]
            java.util.Iterator r1 = r3.iterator()
            r2 = 0
        L_0x010c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x011e
            java.lang.Object r3 = r1.next()
            int[] r3 = (int[]) r3
            int r3 = com.google.zxing.oned.OneDimensionalCodeWriter.b(r0, r2, r3, r5)
            int r2 = r2 + r3
            goto L_0x010c
        L_0x011e:
            return r0
        L_0x011f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Contents length should be between 1 and 80 characters, but got "
            java.lang.String r1 = defpackage.ba.k(r1, r2)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.c(java.lang.String):boolean[]");
    }
}
