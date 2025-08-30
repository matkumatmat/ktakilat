package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;

public final class EAN13Writer extends UPCEANWriter {
    public final BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap) {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, enumMap);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ac A[SYNTHETIC, Splitter:B:39:0x00ac] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean[] c(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 6
            r1 = 1
            int r2 = r10.length()
            r3 = 13
            if (r2 != r3) goto L_0x00bc
            int[] r2 = com.google.zxing.oned.UPCEANReader.f431a     // Catch:{ FormatException -> 0x00b4 }
            int r2 = r10.length()     // Catch:{ FormatException -> 0x00b4 }
            r3 = 0
            if (r2 != 0) goto L_0x0015
        L_0x0013:
            r2 = 0
            goto L_0x004c
        L_0x0015:
            int r4 = r2 + -2
            r5 = 0
        L_0x0018:
            r6 = 9
            if (r4 < 0) goto L_0x002f
            char r7 = r10.charAt(r4)     // Catch:{ FormatException -> 0x00b4 }
            int r7 = r7 + -48
            if (r7 < 0) goto L_0x002a
            if (r7 > r6) goto L_0x002a
            int r5 = r5 + r7
            int r4 = r4 + -2
            goto L_0x0018
        L_0x002a:
            com.google.zxing.FormatException r10 = com.google.zxing.FormatException.getFormatInstance()     // Catch:{ FormatException -> 0x00b4 }
            throw r10     // Catch:{ FormatException -> 0x00b4 }
        L_0x002f:
            int r5 = r5 * 3
            int r2 = r2 - r1
        L_0x0032:
            if (r2 < 0) goto L_0x0047
            char r4 = r10.charAt(r2)     // Catch:{ FormatException -> 0x00b4 }
            int r4 = r4 + -48
            if (r4 < 0) goto L_0x0042
            if (r4 > r6) goto L_0x0042
            int r5 = r5 + r4
            int r2 = r2 + -2
            goto L_0x0032
        L_0x0042:
            com.google.zxing.FormatException r10 = com.google.zxing.FormatException.getFormatInstance()     // Catch:{ FormatException -> 0x00b4 }
            throw r10     // Catch:{ FormatException -> 0x00b4 }
        L_0x0047:
            int r5 = r5 % 10
            if (r5 != 0) goto L_0x0013
            r2 = 1
        L_0x004c:
            if (r2 == 0) goto L_0x00ac
            java.lang.String r2 = r10.substring(r3, r1)
            int r2 = java.lang.Integer.parseInt(r2)
            int[] r4 = com.google.zxing.oned.EAN13Reader.f
            r2 = r4[r2]
            r4 = 95
            boolean[] r4 = new boolean[r4]
            int[] r5 = com.google.zxing.oned.UPCEANReader.f431a
            int r5 = com.google.zxing.oned.OneDimensionalCodeWriter.b(r4, r3, r5, r1)
            r6 = 1
        L_0x0065:
            if (r6 > r0) goto L_0x0085
            int r7 = r6 + 1
            java.lang.String r8 = r10.substring(r6, r7)
            int r8 = java.lang.Integer.parseInt(r8)
            int r6 = 6 - r6
            int r6 = r2 >> r6
            r6 = r6 & r1
            if (r6 != r1) goto L_0x007a
            int r8 = r8 + 10
        L_0x007a:
            int[][] r6 = com.google.zxing.oned.UPCEANReader.e
            r6 = r6[r8]
            int r6 = com.google.zxing.oned.OneDimensionalCodeWriter.b(r4, r5, r6, r3)
            int r5 = r5 + r6
            r6 = r7
            goto L_0x0065
        L_0x0085:
            int[] r0 = com.google.zxing.oned.UPCEANReader.b
            int r0 = com.google.zxing.oned.OneDimensionalCodeWriter.b(r4, r5, r0, r3)
            int r0 = r0 + r5
            r2 = 7
        L_0x008d:
            r3 = 12
            if (r2 > r3) goto L_0x00a6
            int r3 = r2 + 1
            java.lang.String r2 = r10.substring(r2, r3)
            int r2 = java.lang.Integer.parseInt(r2)
            int[][] r5 = com.google.zxing.oned.UPCEANReader.d
            r2 = r5[r2]
            int r2 = com.google.zxing.oned.OneDimensionalCodeWriter.b(r4, r0, r2, r1)
            int r0 = r0 + r2
            r2 = r3
            goto L_0x008d
        L_0x00a6:
            int[] r10 = com.google.zxing.oned.UPCEANReader.f431a
            com.google.zxing.oned.OneDimensionalCodeWriter.b(r4, r0, r10, r1)
            return r4
        L_0x00ac:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ FormatException -> 0x00b4 }
            java.lang.String r0 = "Contents do not pass checksum"
            r10.<init>(r0)     // Catch:{ FormatException -> 0x00b4 }
            throw r10     // Catch:{ FormatException -> 0x00b4 }
        L_0x00b4:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Illegal contents"
            r10.<init>(r0)
            throw r10
        L_0x00bc:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Requested contents should be 13 digits long, but got "
            r1.<init>(r2)
            int r10 = r10.length()
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.EAN13Writer.c(java.lang.String):boolean[]");
    }
}
