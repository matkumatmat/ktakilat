package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

public final class Encoder {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f408a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static void a(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 > i6) {
                    break;
                }
                bitMatrix.b(i5, i4);
                bitMatrix.b(i5, i6);
                bitMatrix.b(i4, i5);
                bitMatrix.b(i6, i5);
                i5++;
            }
        }
        int i7 = i - i2;
        bitMatrix.b(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.b(i8, i7);
        bitMatrix.b(i7, i8);
        int i9 = i + i2;
        bitMatrix.b(i9, i7);
        bitMatrix.b(i9, i8);
        bitMatrix.b(i9, i9 - 1);
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Object, java.util.Comparator] */
    /* JADX WARNING: type inference failed for: r0v4, types: [com.google.zxing.aztec.encoder.AztecCode, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r15 != 32) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.aztec.encoder.AztecCode b(byte[] r20, int r21, int r22) {
        /*
            r0 = r22
            com.google.zxing.aztec.encoder.HighLevelEncoder r1 = new com.google.zxing.aztec.encoder.HighLevelEncoder
            r2 = r20
            r1.<init>(r2)
            com.google.zxing.aztec.encoder.State r2 = com.google.zxing.aztec.encoder.State.e
            java.util.List r2 = java.util.Collections.singletonList(r2)
            r4 = 0
        L_0x0010:
            byte[] r5 = r1.f409a
            int r6 = r5.length
            r7 = 10
            r8 = 3
            r9 = 4
            r10 = 2
            r11 = 5
            r12 = 1
            r14 = 32
            if (r4 >= r6) goto L_0x0115
            int r6 = r4 + 1
            int r15 = r5.length
            if (r6 >= r15) goto L_0x0026
            byte r15 = r5[r6]
            goto L_0x0027
        L_0x0026:
            r15 = 0
        L_0x0027:
            byte r3 = r5[r4]
            r13 = 13
            if (r3 == r13) goto L_0x0046
            r7 = 44
            if (r3 == r7) goto L_0x0042
            r7 = 46
            if (r3 == r7) goto L_0x003e
            r7 = 58
            if (r3 == r7) goto L_0x003b
        L_0x0039:
            r11 = 0
            goto L_0x0049
        L_0x003b:
            if (r15 != r14) goto L_0x0039
            goto L_0x0049
        L_0x003e:
            if (r15 != r14) goto L_0x0039
            r11 = 3
            goto L_0x0049
        L_0x0042:
            if (r15 != r14) goto L_0x0039
            r11 = 4
            goto L_0x0049
        L_0x0046:
            if (r15 != r7) goto L_0x0039
            r11 = 2
        L_0x0049:
            if (r11 <= 0) goto L_0x009e
            java.util.LinkedList r3 = new java.util.LinkedList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0054:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0097
            java.lang.Object r5 = r2.next()
            com.google.zxing.aztec.encoder.State r5 = (com.google.zxing.aztec.encoder.State) r5
            com.google.zxing.aztec.encoder.State r7 = r5.b(r4)
            com.google.zxing.aztec.encoder.State r13 = r7.d(r9, r11)
            r3.add(r13)
            int r13 = r5.f410a
            if (r13 == r9) goto L_0x0076
            com.google.zxing.aztec.encoder.State r13 = r7.e(r9, r11)
            r3.add(r13)
        L_0x0076:
            if (r11 == r8) goto L_0x007a
            if (r11 != r9) goto L_0x0087
        L_0x007a:
            int r13 = 16 - r11
            com.google.zxing.aztec.encoder.State r7 = r7.d(r10, r13)
            com.google.zxing.aztec.encoder.State r7 = r7.d(r10, r12)
            r3.add(r7)
        L_0x0087:
            int r7 = r5.c
            if (r7 <= 0) goto L_0x0054
            com.google.zxing.aztec.encoder.State r5 = r5.a(r4)
            com.google.zxing.aztec.encoder.State r5 = r5.a(r6)
            r3.add(r5)
            goto L_0x0054
        L_0x0097:
            java.util.LinkedList r2 = com.google.zxing.aztec.encoder.HighLevelEncoder.a(r3)
            r4 = r6
            goto L_0x0112
        L_0x009e:
            java.util.LinkedList r3 = new java.util.LinkedList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x00a7:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x010e
            java.lang.Object r6 = r2.next()
            com.google.zxing.aztec.encoder.State r6 = (com.google.zxing.aztec.encoder.State) r6
            byte r7 = r5[r4]
            r7 = r7 & 255(0xff, float:3.57E-43)
            char r7 = (char) r7
            int r8 = r6.f410a
            int[][] r11 = com.google.zxing.aztec.encoder.HighLevelEncoder.d
            r8 = r11[r8]
            r8 = r8[r7]
            if (r8 <= 0) goto L_0x00c4
            r8 = 1
            goto L_0x00c5
        L_0x00c4:
            r8 = 0
        L_0x00c5:
            r13 = 0
            r14 = 0
        L_0x00c7:
            int r15 = r6.f410a
            if (r13 > r9) goto L_0x00fa
            r17 = r11[r13]
            r9 = r17[r7]
            if (r9 <= 0) goto L_0x00f5
            if (r14 != 0) goto L_0x00d7
            com.google.zxing.aztec.encoder.State r14 = r6.b(r4)
        L_0x00d7:
            if (r8 == 0) goto L_0x00dd
            if (r13 == r15) goto L_0x00dd
            if (r13 != r10) goto L_0x00e4
        L_0x00dd:
            com.google.zxing.aztec.encoder.State r10 = r14.d(r13, r9)
            r3.add(r10)
        L_0x00e4:
            if (r8 != 0) goto L_0x00f5
            int[][] r10 = com.google.zxing.aztec.encoder.HighLevelEncoder.e
            r10 = r10[r15]
            r10 = r10[r13]
            if (r10 < 0) goto L_0x00f5
            com.google.zxing.aztec.encoder.State r9 = r14.e(r13, r9)
            r3.add(r9)
        L_0x00f5:
            int r13 = r13 + 1
            r9 = 4
            r10 = 2
            goto L_0x00c7
        L_0x00fa:
            int r8 = r6.c
            if (r8 > 0) goto L_0x0104
            r8 = r11[r15]
            r7 = r8[r7]
            if (r7 != 0) goto L_0x010b
        L_0x0104:
            com.google.zxing.aztec.encoder.State r6 = r6.a(r4)
            r3.add(r6)
        L_0x010b:
            r9 = 4
            r10 = 2
            goto L_0x00a7
        L_0x010e:
            java.util.LinkedList r2 = com.google.zxing.aztec.encoder.HighLevelEncoder.a(r3)
        L_0x0112:
            int r4 = r4 + r12
            goto L_0x0010
        L_0x0115:
            com.google.zxing.aztec.encoder.HighLevelEncoder$1 r1 = new com.google.zxing.aztec.encoder.HighLevelEncoder$1
            r1.<init>()
            java.lang.Object r1 = java.util.Collections.min(r2, r1)
            com.google.zxing.aztec.encoder.State r1 = (com.google.zxing.aztec.encoder.State) r1
            r1.getClass()
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            int r3 = r5.length
            com.google.zxing.aztec.encoder.State r1 = r1.b(r3)
            com.google.zxing.aztec.encoder.Token r1 = r1.b
        L_0x012f:
            if (r1 == 0) goto L_0x0137
            r2.addFirst(r1)
            com.google.zxing.aztec.encoder.Token r1 = r1.f411a
            goto L_0x012f
        L_0x0137:
            com.google.zxing.common.BitArray r1 = new com.google.zxing.common.BitArray
            r1.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0140:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0150
            java.lang.Object r3 = r2.next()
            com.google.zxing.aztec.encoder.Token r3 = (com.google.zxing.aztec.encoder.Token) r3
            r3.a(r1, r5)
            goto L_0x0140
        L_0x0150:
            int r2 = r1.d
            r3 = 100
            r4 = 11
            r5 = r21
            int r3 = defpackage.e.b(r2, r5, r3, r4)
            int r2 = r2 + r3
            int[] r5 = f408a
            if (r0 == 0) goto L_0x01ae
            if (r0 >= 0) goto L_0x0165
            r2 = 1
            goto L_0x0166
        L_0x0165:
            r2 = 0
        L_0x0166:
            int r8 = java.lang.Math.abs(r22)
            if (r2 == 0) goto L_0x016d
            r14 = 4
        L_0x016d:
            if (r8 > r14) goto L_0x01a0
            if (r2 == 0) goto L_0x0174
            r6 = 88
            goto L_0x0176
        L_0x0174:
            r6 = 112(0x70, float:1.57E-43)
        L_0x0176:
            int r0 = r8 << 4
            int r6 = r6 + r0
            int r6 = r6 * r8
            r0 = r5[r8]
            int r5 = r6 % r0
            int r5 = r6 - r5
            com.google.zxing.common.BitArray r1 = d(r1, r0)
            int r9 = r1.d
            int r3 = r3 + r9
            java.lang.String r10 = "Data to large for user specified layer"
            if (r3 > r5) goto L_0x019a
            if (r2 == 0) goto L_0x01f5
            int r3 = r0 << 6
            if (r9 > r3) goto L_0x0194
            goto L_0x01f5
        L_0x0194:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r10)
            throw r0
        L_0x019a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r10)
            throw r0
        L_0x01a0:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Illegal value "
            java.lang.String r3 = " for layers"
            java.lang.String r0 = defpackage.ba.l(r0, r2, r3)
            r1.<init>(r0)
            throw r1
        L_0x01ae:
            r0 = 0
            r10 = 0
            r13 = 0
        L_0x01b1:
            if (r0 > r14) goto L_0x03b9
            if (r0 > r8) goto L_0x01b7
            r15 = 1
            goto L_0x01b8
        L_0x01b7:
            r15 = 0
        L_0x01b8:
            if (r15 == 0) goto L_0x01bd
            int r16 = r0 + 1
            goto L_0x01bf
        L_0x01bd:
            r16 = r0
        L_0x01bf:
            if (r15 == 0) goto L_0x01c4
            r18 = 88
            goto L_0x01c6
        L_0x01c4:
            r18 = 112(0x70, float:1.57E-43)
        L_0x01c6:
            int r19 = r16 << 4
            int r18 = r18 + r19
            int r6 = r18 * r16
            if (r2 > r6) goto L_0x01eb
            r8 = r5[r16]
            if (r10 == r8) goto L_0x01d8
            com.google.zxing.common.BitArray r10 = d(r1, r8)
            r13 = r10
            goto L_0x01d9
        L_0x01d8:
            r8 = r10
        L_0x01d9:
            int r10 = r6 % r8
            int r10 = r6 - r10
            if (r15 == 0) goto L_0x01e5
            int r9 = r13.d
            int r14 = r8 << 6
            if (r9 > r14) goto L_0x01ea
        L_0x01e5:
            int r9 = r13.d
            int r9 = r9 + r3
            if (r9 <= r10) goto L_0x01f0
        L_0x01ea:
            r10 = r8
        L_0x01eb:
            r6 = 4
            r8 = 5
            r11 = 2
            goto L_0x03b1
        L_0x01f0:
            r0 = r8
            r1 = r13
            r2 = r15
            r8 = r16
        L_0x01f5:
            com.google.zxing.common.BitArray r3 = c(r1, r6, r0)
            int r1 = r1.d
            int r1 = r1 / r0
            com.google.zxing.common.BitArray r0 = new com.google.zxing.common.BitArray
            r0.<init>()
            if (r2 == 0) goto L_0x0216
            int r5 = r8 + -1
            r6 = 2
            r0.b(r5, r6)
            int r1 = r1 - r12
            r5 = 6
            r0.b(r1, r5)
            r1 = 28
            r6 = 4
            com.google.zxing.common.BitArray r0 = c(r0, r1, r6)
            goto L_0x0226
        L_0x0216:
            r6 = 4
            int r5 = r8 + -1
            r0.b(r5, r11)
            int r1 = r1 - r12
            r0.b(r1, r4)
            r1 = 40
            com.google.zxing.common.BitArray r0 = c(r0, r1, r6)
        L_0x0226:
            if (r2 == 0) goto L_0x0229
            goto L_0x022b
        L_0x0229:
            r4 = 14
        L_0x022b:
            int r1 = r8 << 2
            int r4 = r4 + r1
            int[] r1 = new int[r4]
            if (r2 == 0) goto L_0x023c
            r5 = 0
        L_0x0233:
            if (r5 >= r4) goto L_0x023a
            r1[r5] = r5
            int r5 = r5 + 1
            goto L_0x0233
        L_0x023a:
            r9 = r4
            goto L_0x0261
        L_0x023c:
            int r5 = r4 + 1
            int r6 = r4 / 2
            int r9 = r6 + -1
            int r9 = r9 / 15
            r10 = 2
            int r9 = r9 * 2
            int r9 = r9 + r5
            int r5 = r9 / 2
            r10 = 0
        L_0x024b:
            if (r10 >= r6) goto L_0x0261
            int r13 = r10 / 15
            int r13 = r13 + r10
            int r14 = r6 - r10
            int r14 = r14 - r12
            int r15 = r5 - r13
            int r15 = r15 - r12
            r1[r14] = r15
            int r14 = r6 + r10
            int r13 = r13 + r5
            int r13 = r13 + r12
            r1[r14] = r13
            int r10 = r10 + 1
            goto L_0x024b
        L_0x0261:
            com.google.zxing.common.BitMatrix r5 = new com.google.zxing.common.BitMatrix
            r5.<init>(r9, r9)
            r6 = 0
            r10 = 0
        L_0x0268:
            if (r6 >= r8) goto L_0x02fa
            int r13 = r8 - r6
            r14 = 2
            int r13 = r13 << r14
            if (r2 == 0) goto L_0x0273
            r14 = 9
            goto L_0x0275
        L_0x0273:
            r14 = 12
        L_0x0275:
            int r13 = r13 + r14
            r14 = 0
        L_0x0277:
            if (r14 >= r13) goto L_0x02ef
            int r15 = r14 << 1
            r11 = 0
        L_0x027c:
            r12 = 2
            if (r11 >= r12) goto L_0x02e8
            int r12 = r10 + r15
            int r12 = r12 + r11
            boolean r12 = r3.d(r12)
            if (r12 == 0) goto L_0x0294
            int r12 = r6 << 1
            int r18 = r12 + r11
            r7 = r1[r18]
            int r12 = r12 + r14
            r12 = r1[r12]
            r5.b(r7, r12)
        L_0x0294:
            int r7 = r13 << 1
            int r7 = r7 + r10
            int r7 = r7 + r15
            int r7 = r7 + r11
            boolean r7 = r3.d(r7)
            if (r7 == 0) goto L_0x02b0
            int r7 = r6 << 1
            int r12 = r7 + r14
            r12 = r1[r12]
            int r18 = r4 + -1
            int r18 = r18 - r7
            int r18 = r18 - r11
            r7 = r1[r18]
            r5.b(r12, r7)
        L_0x02b0:
            int r7 = r13 << 2
            int r7 = r7 + r10
            int r7 = r7 + r15
            int r7 = r7 + r11
            boolean r7 = r3.d(r7)
            if (r7 == 0) goto L_0x02ca
            int r7 = r4 + -1
            int r12 = r6 << 1
            int r7 = r7 - r12
            int r12 = r7 - r11
            r12 = r1[r12]
            int r7 = r7 - r14
            r7 = r1[r7]
            r5.b(r12, r7)
        L_0x02ca:
            int r7 = r13 * 6
            int r7 = r7 + r10
            int r7 = r7 + r15
            int r7 = r7 + r11
            boolean r7 = r3.d(r7)
            if (r7 == 0) goto L_0x02e3
            int r7 = r4 + -1
            int r12 = r6 << 1
            int r7 = r7 - r12
            int r7 = r7 - r14
            r7 = r1[r7]
            int r12 = r12 + r11
            r12 = r1[r12]
            r5.b(r7, r12)
        L_0x02e3:
            int r11 = r11 + 1
            r7 = 10
            goto L_0x027c
        L_0x02e8:
            int r14 = r14 + 1
            r7 = 10
            r11 = 5
            r12 = 1
            goto L_0x0277
        L_0x02ef:
            int r7 = r13 << 3
            int r10 = r10 + r7
            int r6 = r6 + 1
            r7 = 10
            r11 = 5
            r12 = 1
            goto L_0x0268
        L_0x02fa:
            int r1 = r9 / 2
            r3 = 7
            if (r2 == 0) goto L_0x033a
            r6 = 0
        L_0x0300:
            if (r6 >= r3) goto L_0x037a
            int r7 = r1 + -3
            int r7 = r7 + r6
            boolean r8 = r0.d(r6)
            if (r8 == 0) goto L_0x0310
            int r8 = r1 + -5
            r5.b(r7, r8)
        L_0x0310:
            int r8 = r6 + 7
            boolean r8 = r0.d(r8)
            if (r8 == 0) goto L_0x031d
            int r8 = r1 + 5
            r5.b(r8, r7)
        L_0x031d:
            int r8 = 20 - r6
            boolean r8 = r0.d(r8)
            if (r8 == 0) goto L_0x032a
            int r8 = r1 + 5
            r5.b(r7, r8)
        L_0x032a:
            int r8 = 27 - r6
            boolean r8 = r0.d(r8)
            if (r8 == 0) goto L_0x0337
            int r8 = r1 + -5
            r5.b(r8, r7)
        L_0x0337:
            int r6 = r6 + 1
            goto L_0x0300
        L_0x033a:
            r6 = 0
            r7 = 10
        L_0x033d:
            if (r6 >= r7) goto L_0x037a
            int r8 = r1 + -5
            int r8 = r8 + r6
            int r10 = r6 / 5
            int r10 = r10 + r8
            boolean r8 = r0.d(r6)
            if (r8 == 0) goto L_0x0350
            int r8 = r1 + -7
            r5.b(r10, r8)
        L_0x0350:
            int r8 = r6 + 10
            boolean r8 = r0.d(r8)
            if (r8 == 0) goto L_0x035d
            int r8 = r1 + 7
            r5.b(r8, r10)
        L_0x035d:
            int r8 = 29 - r6
            boolean r8 = r0.d(r8)
            if (r8 == 0) goto L_0x036a
            int r8 = r1 + 7
            r5.b(r10, r8)
        L_0x036a:
            int r8 = 39 - r6
            boolean r8 = r0.d(r8)
            if (r8 == 0) goto L_0x0377
            int r8 = r1 + -7
            r5.b(r8, r10)
        L_0x0377:
            int r6 = r6 + 1
            goto L_0x033d
        L_0x037a:
            if (r2 == 0) goto L_0x0381
            r8 = 5
            a(r5, r1, r8)
            goto L_0x03a9
        L_0x0381:
            a(r5, r1, r3)
            r0 = 0
            r3 = 0
            r11 = 2
        L_0x0387:
            int r2 = r4 / 2
            r12 = 1
            int r2 = r2 - r12
            if (r3 >= r2) goto L_0x03a9
            r2 = r1 & 1
        L_0x038f:
            if (r2 >= r9) goto L_0x03a4
            int r6 = r1 - r0
            r5.b(r6, r2)
            int r7 = r1 + r0
            r5.b(r7, r2)
            r5.b(r2, r6)
            r5.b(r2, r7)
            int r2 = r2 + 2
            goto L_0x038f
        L_0x03a4:
            int r3 = r3 + 15
            int r0 = r0 + 16
            goto L_0x0387
        L_0x03a9:
            com.google.zxing.aztec.encoder.AztecCode r0 = new com.google.zxing.aztec.encoder.AztecCode
            r0.<init>()
            r0.f407a = r5
            return r0
        L_0x03b1:
            int r0 = r0 + 1
            r8 = 3
            r11 = 5
            r14 = 32
            goto L_0x01b1
        L_0x03b9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Data too large for an Aztec code"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.encoder.Encoder.b(byte[], int, int):com.google.zxing.aztec.encoder.AztecCode");
    }

    public static BitArray c(BitArray bitArray, int i, int i2) {
        GenericGF genericGF;
        int i3;
        int i4 = bitArray.d / i2;
        if (i2 == 4) {
            genericGF = GenericGF.j;
        } else if (i2 == 6) {
            genericGF = GenericGF.i;
        } else if (i2 == 8) {
            genericGF = GenericGF.l;
        } else if (i2 == 10) {
            genericGF = GenericGF.h;
        } else if (i2 == 12) {
            genericGF = GenericGF.g;
        } else {
            throw new IllegalArgumentException(ba.k(i2, "Unsupported word size "));
        }
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(genericGF);
        int i5 = i / i2;
        int[] iArr = new int[i5];
        int i6 = bitArray.d / i2;
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                if (bitArray.d((i7 * i2) + i9)) {
                    i3 = 1 << ((i2 - i9) - 1);
                } else {
                    i3 = 0;
                }
                i8 |= i3;
            }
            iArr[i7] = i8;
        }
        reedSolomonEncoder.a(i5 - i4, iArr);
        BitArray bitArray2 = new BitArray();
        bitArray2.b(0, i % i2);
        for (int i10 = 0; i10 < i5; i10++) {
            bitArray2.b(iArr[i10], i2);
        }
        return bitArray2;
    }

    public static BitArray d(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int i2 = bitArray.d;
        int i3 = (1 << i) - 2;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                int i7 = i4 + i6;
                if (i7 >= i2 || bitArray.d(i7)) {
                    i5 |= 1 << ((i - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 == i3) {
                bitArray2.b(i8, i);
            } else if (i8 == 0) {
                bitArray2.b(i5 | 1, i);
            } else {
                bitArray2.b(i5, i);
                i4 += i;
            }
            i4--;
            i4 += i;
        }
        return bitArray2;
    }
}
