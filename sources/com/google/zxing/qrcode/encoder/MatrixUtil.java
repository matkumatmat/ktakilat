package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;

final class MatrixUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final int[][] f451a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    public static final int[][] b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    public static final int[][] c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    public static final int[][] d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0224, code lost:
        r16 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0226, code lost:
        if (r16 == false) goto L_0x022d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0228, code lost:
        r13 = !r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01e7, code lost:
        r16 = r16 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x021f, code lost:
        if (r16 != 0) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0221, code lost:
        r16 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.google.zxing.common.BitArray r23, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r24, com.google.zxing.qrcode.decoder.Version r25, int r26, com.google.zxing.qrcode.encoder.ByteMatrix r27) {
        /*
            r0 = r23
            r1 = r26
            r2 = r27
            r3 = 0
            r4 = 0
        L_0x0008:
            r5 = -1
            int r6 = r2.c
            int r7 = r2.b
            if (r4 >= r6) goto L_0x001e
            r6 = 0
        L_0x0010:
            if (r6 >= r7) goto L_0x001b
            byte[][] r8 = r2.f448a
            r8 = r8[r4]
            r8[r6] = r5
            int r6 = r6 + 1
            goto L_0x0010
        L_0x001b:
            int r4 = r4 + 1
            goto L_0x0008
        L_0x001e:
            int[][] r4 = f451a
            r4 = r4[r3]
            int r4 = r4.length
            d(r3, r3, r2)
            int r4 = r7 - r4
            d(r4, r3, r2)
            d(r3, r4, r2)
            r4 = 7
            c(r3, r4, r2)
            int r8 = r7 + -8
            c(r8, r4, r2)
            c(r3, r8, r2)
            e(r4, r3, r2)
            int r9 = r6 + -8
            e(r9, r3, r2)
            int r10 = r6 + -7
            e(r4, r10, r2)
            r11 = 8
            byte r12 = r2.a(r11, r9)
            if (r12 == 0) goto L_0x02a3
            r12 = 1
            r2.b(r11, r9, r12)
            r9 = 2
            r13 = r25
            int r13 = r13.f444a
            r14 = 5
            if (r13 >= r9) goto L_0x005d
            goto L_0x00c2
        L_0x005d:
            int r15 = r13 + -1
            int[][] r16 = c
            r15 = r16[r15]
            int r9 = r15.length
            r4 = 0
        L_0x0065:
            if (r4 >= r9) goto L_0x00c2
            r12 = 0
        L_0x0068:
            if (r12 >= r9) goto L_0x00b7
            r3 = r15[r4]
            r11 = r15[r12]
            if (r11 == r5) goto L_0x00ab
            if (r3 == r5) goto L_0x00ab
            byte r19 = r2.a(r11, r3)
            boolean r19 = f(r19)
            if (r19 == 0) goto L_0x00ab
            int r11 = r11 + -2
            int r3 = r3 + -2
            r5 = 0
        L_0x0081:
            if (r5 >= r14) goto L_0x00ab
            r25 = r9
            r9 = 0
        L_0x0086:
            if (r9 >= r14) goto L_0x00a1
            int r14 = r11 + r9
            r20 = r11
            int r11 = r3 + r5
            int[][] r21 = b
            r21 = r21[r5]
            r22 = r3
            r3 = r21[r9]
            r2.b(r14, r11, r3)
            int r9 = r9 + 1
            r11 = r20
            r3 = r22
            r14 = 5
            goto L_0x0086
        L_0x00a1:
            r22 = r3
            r20 = r11
            int r5 = r5 + 1
            r9 = r25
            r14 = 5
            goto L_0x0081
        L_0x00ab:
            r25 = r9
            int r12 = r12 + 1
            r9 = r25
            r3 = 0
            r5 = -1
            r11 = 8
            r14 = 5
            goto L_0x0068
        L_0x00b7:
            r25 = r9
            int r4 = r4 + 1
            r3 = 0
            r5 = -1
            r11 = 8
            r12 = 1
            r14 = 5
            goto L_0x0065
        L_0x00c2:
            r3 = 8
        L_0x00c4:
            r4 = 6
            if (r3 >= r8) goto L_0x00e7
            int r5 = r3 + 1
            int r9 = r5 % 2
            byte r11 = r2.a(r3, r4)
            boolean r11 = f(r11)
            if (r11 == 0) goto L_0x00d8
            r2.b(r3, r4, r9)
        L_0x00d8:
            byte r11 = r2.a(r4, r3)
            boolean r11 = f(r11)
            if (r11 == 0) goto L_0x00e5
            r2.b(r4, r3, r9)
        L_0x00e5:
            r3 = r5
            goto L_0x00c4
        L_0x00e7:
            com.google.zxing.common.BitArray r3 = new com.google.zxing.common.BitArray
            r3.<init>()
            if (r1 < 0) goto L_0x029b
            r5 = 8
            if (r1 >= r5) goto L_0x029b
            int r5 = r24.getBits()
            r8 = 3
            int r5 = r5 << r8
            r5 = r5 | r1
            r9 = 5
            r3.b(r5, r9)
            r9 = 1335(0x537, float:1.871E-42)
            int r5 = b(r5, r9)
            r9 = 10
            r3.b(r5, r9)
            com.google.zxing.common.BitArray r5 = new com.google.zxing.common.BitArray
            r5.<init>()
            r9 = 21522(0x5412, float:3.0159E-41)
            r11 = 15
            r5.b(r9, r11)
            int r9 = r3.d
            int r12 = r5.d
            if (r9 != r12) goto L_0x0293
            r9 = 0
        L_0x011b:
            int[] r12 = r3.c
            int r14 = r12.length
            if (r9 >= r14) goto L_0x012c
            r14 = r12[r9]
            int[] r15 = r5.c
            r15 = r15[r9]
            r14 = r14 ^ r15
            r12[r9] = r14
            int r9 = r9 + 1
            goto L_0x011b
        L_0x012c:
            int r5 = r3.d
            java.lang.String r9 = "should not happen but we got: "
            if (r5 != r11) goto L_0x027f
            r5 = 0
        L_0x0133:
            int r11 = r3.d
            if (r5 >= r11) goto L_0x0161
            int r11 = r11 + -1
            int r11 = r11 - r5
            boolean r11 = r3.d(r11)
            int[][] r12 = d
            r12 = r12[r5]
            r14 = 0
            r15 = r12[r14]
            r18 = 1
            r12 = r12[r18]
            r2.c(r15, r12, r11)
            r12 = 8
            if (r5 >= r12) goto L_0x0158
            int r15 = r7 - r5
            int r15 = r15 + -1
            r2.c(r15, r12, r11)
            goto L_0x015e
        L_0x0158:
            int r15 = r5 + -8
            int r15 = r15 + r10
            r2.c(r12, r15, r11)
        L_0x015e:
            int r5 = r5 + 1
            goto L_0x0133
        L_0x0161:
            r5 = 7
            r14 = 0
            if (r13 >= r5) goto L_0x0167
        L_0x0165:
            r3 = 1
            goto L_0x019d
        L_0x0167:
            com.google.zxing.common.BitArray r3 = new com.google.zxing.common.BitArray
            r3.<init>()
            r3.b(r13, r4)
            r5 = 7973(0x1f25, float:1.1173E-41)
            int r5 = b(r13, r5)
            r10 = 12
            r3.b(r5, r10)
            int r5 = r3.d
            r10 = 18
            if (r5 != r10) goto L_0x026b
            r5 = 17
            r9 = 0
        L_0x0183:
            if (r9 >= r4) goto L_0x0165
            r10 = 0
        L_0x0186:
            if (r10 >= r8) goto L_0x019a
            boolean r11 = r3.d(r5)
            int r5 = r5 + -1
            int r12 = r6 + -11
            int r12 = r12 + r10
            r2.c(r9, r12, r11)
            r2.c(r12, r9, r11)
            int r10 = r10 + 1
            goto L_0x0186
        L_0x019a:
            int r9 = r9 + 1
            goto L_0x0183
        L_0x019d:
            int r7 = r7 - r3
            int r3 = r6 + -1
            r5 = 0
            r9 = -1
        L_0x01a2:
            if (r7 <= 0) goto L_0x0248
            if (r7 != r4) goto L_0x01a8
            int r7 = r7 + -1
        L_0x01a8:
            if (r3 < 0) goto L_0x023e
            if (r3 >= r6) goto L_0x023e
            r10 = 2
            r11 = 0
        L_0x01ae:
            if (r11 >= r10) goto L_0x0238
            int r12 = r7 - r11
            byte r13 = r2.a(r12, r3)
            boolean r13 = f(r13)
            if (r13 == 0) goto L_0x0231
            int r13 = r0.d
            if (r5 >= r13) goto L_0x01c8
            boolean r13 = r0.d(r5)
            int r5 = r5 + 1
        L_0x01c6:
            r15 = -1
            goto L_0x01ca
        L_0x01c8:
            r13 = 0
            goto L_0x01c6
        L_0x01ca:
            if (r1 == r15) goto L_0x022b
            switch(r1) {
                case 0: goto L_0x021a;
                case 1: goto L_0x0217;
                case 2: goto L_0x0214;
                case 3: goto L_0x020f;
                case 4: goto L_0x0202;
                case 5: goto L_0x01f9;
                case 6: goto L_0x01ea;
                case 7: goto L_0x01db;
                default: goto L_0x01cf;
            }
        L_0x01cf:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Invalid mask pattern: "
            java.lang.String r1 = defpackage.ba.k(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x01db:
            int r16 = r3 * r12
            int r16 = r16 % 3
            int r17 = r3 + r12
            r18 = 1
            r17 = r17 & 1
            int r16 = r16 + r17
        L_0x01e7:
            r16 = r16 & 1
            goto L_0x021f
        L_0x01ea:
            r18 = 1
            int r16 = r3 * r12
            r17 = r16 & 1
            int r16 = r16 % 3
            int r16 = r16 + r17
            r16 = r16 & 1
        L_0x01f6:
            r18 = 1
            goto L_0x021f
        L_0x01f9:
            int r16 = r3 * r12
            r17 = r16 & 1
            int r16 = r16 % 3
            int r16 = r16 + r17
            goto L_0x01f6
        L_0x0202:
            int r16 = r3 / 2
            int r17 = r12 / 3
            int r17 = r17 + r16
            r16 = 1
            r17 = r17 & 1
            r16 = r17
            goto L_0x01f6
        L_0x020f:
            int r16 = r3 + r12
            int r16 = r16 % 3
            goto L_0x01f6
        L_0x0214:
            int r16 = r12 % 3
            goto L_0x01f6
        L_0x0217:
            r16 = r3 & 1
            goto L_0x01f6
        L_0x021a:
            int r16 = r3 + r12
            r18 = 1
            goto L_0x01e7
        L_0x021f:
            if (r16 != 0) goto L_0x0224
            r16 = 1
            goto L_0x0226
        L_0x0224:
            r16 = 0
        L_0x0226:
            if (r16 == 0) goto L_0x022d
            r13 = r13 ^ 1
            goto L_0x022d
        L_0x022b:
            r18 = 1
        L_0x022d:
            r2.c(r12, r3, r13)
            goto L_0x0234
        L_0x0231:
            r15 = -1
            r18 = 1
        L_0x0234:
            int r11 = r11 + 1
            goto L_0x01ae
        L_0x0238:
            r15 = -1
            r18 = 1
            int r3 = r3 + r9
            goto L_0x01a8
        L_0x023e:
            r10 = 2
            r15 = -1
            r18 = 1
            int r9 = -r9
            int r3 = r3 + r9
            int r7 = r7 + -2
            goto L_0x01a2
        L_0x0248:
            int r1 = r0.d
            if (r5 != r1) goto L_0x024d
            return
        L_0x024d:
            com.google.zxing.WriterException r1 = new com.google.zxing.WriterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Not all bits consumed: "
            r2.<init>(r3)
            r2.append(r5)
            r3 = 47
            r2.append(r3)
            int r0 = r0.d
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x026b:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r9)
            int r2 = r3.d
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x027f:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r9)
            int r2 = r3.d
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0293:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Sizes don't match"
            r0.<init>(r1)
            throw r0
        L_0x029b:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Invalid mask pattern"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x02a3:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.MatrixUtil.a(com.google.zxing.common.BitArray, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, com.google.zxing.qrcode.decoder.Version, int, com.google.zxing.qrcode.encoder.ByteMatrix):void");
    }

    public static int b(int i, int i2) {
        if (i2 != 0) {
            int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i2);
            int i3 = 32 - numberOfLeadingZeros;
            int i4 = i << (31 - numberOfLeadingZeros);
            while (32 - Integer.numberOfLeadingZeros(i4) >= i3) {
                i4 ^= i2 << ((32 - Integer.numberOfLeadingZeros(i4)) - i3);
            }
            return i4;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    public static void c(int i, int i2, ByteMatrix byteMatrix) {
        int i3 = 0;
        while (i3 < 8) {
            int i4 = i + i3;
            if (f(byteMatrix.a(i4, i2))) {
                byteMatrix.b(i4, i2, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    public static void d(int i, int i2, ByteMatrix byteMatrix) {
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                byteMatrix.b(i + i4, i2 + i3, f451a[i3][i4]);
            }
        }
    }

    public static void e(int i, int i2, ByteMatrix byteMatrix) {
        int i3 = 0;
        while (i3 < 7) {
            int i4 = i2 + i3;
            if (f(byteMatrix.a(i, i4))) {
                byteMatrix.b(i, i4, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    public static boolean f(int i) {
        return i == -1;
    }
}
