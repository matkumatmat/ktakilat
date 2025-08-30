package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

public final class HighLevelEncoder {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: com.google.zxing.datamatrix.encoder.Encoder[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: com.google.zxing.datamatrix.encoder.X12Encoder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r11, com.google.zxing.datamatrix.encoder.SymbolShapeHint r12, com.google.zxing.Dimension r13, com.google.zxing.Dimension r14) {
        /*
            r0 = 5
            r1 = 2
            r2 = 1
            r3 = 0
            com.google.zxing.datamatrix.encoder.ASCIIEncoder r4 = new com.google.zxing.datamatrix.encoder.ASCIIEncoder
            r4.<init>()
            com.google.zxing.datamatrix.encoder.C40Encoder r5 = new com.google.zxing.datamatrix.encoder.C40Encoder
            r5.<init>()
            com.google.zxing.datamatrix.encoder.TextEncoder r6 = new com.google.zxing.datamatrix.encoder.TextEncoder
            r6.<init>()
            com.google.zxing.datamatrix.encoder.X12Encoder r7 = new com.google.zxing.datamatrix.encoder.X12Encoder
            r7.<init>()
            com.google.zxing.datamatrix.encoder.EdifactEncoder r8 = new com.google.zxing.datamatrix.encoder.EdifactEncoder
            r8.<init>()
            com.google.zxing.datamatrix.encoder.Base256Encoder r9 = new com.google.zxing.datamatrix.encoder.Base256Encoder
            r9.<init>()
            r10 = 6
            com.google.zxing.datamatrix.encoder.Encoder[] r10 = new com.google.zxing.datamatrix.encoder.Encoder[r10]
            r10[r3] = r4
            r10[r2] = r5
            r10[r1] = r6
            r4 = 3
            r10[r4] = r7
            r4 = 4
            r10[r4] = r8
            r10[r0] = r9
            com.google.zxing.datamatrix.encoder.EncoderContext r4 = new com.google.zxing.datamatrix.encoder.EncoderContext
            r4.<init>(r11)
            r4.b = r12
            r4.c = r13
            r4.d = r14
            java.lang.String r12 = "[)>\u001e05\u001d"
            boolean r12 = r11.startsWith(r12)
            java.lang.String r13 = "\u001e\u0004"
            if (r12 == 0) goto L_0x005c
            boolean r12 = r11.endsWith(r13)
            if (r12 == 0) goto L_0x005c
            r11 = 236(0xec, float:3.31E-43)
            r4.d(r11)
            r4.i = r1
            int r11 = r4.f
            int r11 = r11 + 7
            r4.f = r11
            goto L_0x0077
        L_0x005c:
            java.lang.String r12 = "[)>\u001e06\u001d"
            boolean r12 = r11.startsWith(r12)
            if (r12 == 0) goto L_0x0077
            boolean r11 = r11.endsWith(r13)
            if (r11 == 0) goto L_0x0077
            r11 = 237(0xed, float:3.32E-43)
            r4.d(r11)
            r4.i = r1
            int r11 = r4.f
            int r11 = r11 + 7
            r4.f = r11
        L_0x0077:
            boolean r11 = r4.b()
            if (r11 == 0) goto L_0x008b
            r11 = r10[r3]
            r11.a(r4)
            int r11 = r4.g
            if (r11 < 0) goto L_0x0077
            r12 = -1
            r4.g = r12
            r3 = r11
            goto L_0x0077
        L_0x008b:
            java.lang.StringBuilder r11 = r4.e
            int r12 = r11.length()
            int r13 = r11.length()
            r4.c(r13)
            com.google.zxing.datamatrix.encoder.SymbolInfo r13 = r4.h
            int r13 = r13.b
            r14 = 254(0xfe, float:3.56E-43)
            if (r12 >= r13) goto L_0x00a7
            if (r3 == 0) goto L_0x00a7
            if (r3 == r0) goto L_0x00a7
            r4.d(r14)
        L_0x00a7:
            int r12 = r11.length()
            if (r12 >= r13) goto L_0x00b2
            r12 = 129(0x81, float:1.81E-43)
            r11.append(r12)
        L_0x00b2:
            int r12 = r11.length()
            if (r12 >= r13) goto L_0x00cd
            int r12 = r11.length()
            int r12 = r12 + r2
            int r12 = r12 * 149
            int r12 = r12 % 253
            int r0 = r12 + 130
            if (r0 > r14) goto L_0x00c6
            goto L_0x00c8
        L_0x00c6:
            int r0 = r12 + -124
        L_0x00c8:
            char r12 = (char) r0
            r11.append(r12)
            goto L_0x00b2
        L_0x00cd:
            java.lang.String r11 = r11.toString()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.HighLevelEncoder.a(java.lang.String, com.google.zxing.datamatrix.encoder.SymbolShapeHint, com.google.zxing.Dimension, com.google.zxing.Dimension):java.lang.String");
    }

    public static int b(float[] fArr, int[] iArr, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < 6; i2++) {
            int ceil = (int) Math.ceil((double) fArr[i2]);
            iArr[i2] = ceil;
            if (i > ceil) {
                Arrays.fill(bArr, (byte) 0);
                i = ceil;
            }
            if (i == ceil) {
                bArr[i2] = (byte) (bArr[i2] + 1);
            }
        }
        return i;
    }

    public static void c(char c) {
        String hexString = Integer.toHexString(c);
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    public static boolean d(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean e(char c) {
        return c >= 128 && c <= 255;
    }

    public static boolean f(char c) {
        if (c == 13 || c == '*' || c == '>' || c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    public static int g(CharSequence charSequence, int i, int i2) {
        float[] fArr;
        CharSequence charSequence2 = charSequence;
        int i3 = i;
        if (i3 >= charSequence.length()) {
            return i2;
        }
        int i4 = 0;
        int i5 = 6;
        float f = 2.0f;
        float f2 = 1.0f;
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i2] = 0.0f;
        }
        int i6 = 0;
        while (true) {
            int i7 = i3 + i6;
            if (i7 == charSequence.length()) {
                byte[] bArr = new byte[i5];
                int[] iArr = new int[i5];
                int b = b(fArr, iArr, bArr);
                int i8 = 0;
                for (int i9 = 0; i9 < i5; i9++) {
                    i8 += bArr[i9];
                }
                if (iArr[i4] == b) {
                    return i4;
                }
                if (i8 == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (i8 == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (i8 == 1 && bArr[2] > 0) {
                    return 2;
                }
                if (i8 != 1 || bArr[3] <= 0) {
                    return 1;
                }
                return 3;
            }
            char charAt = charSequence2.charAt(i7);
            i6++;
            if (d(charAt)) {
                fArr[i4] = fArr[i4] + 0.5f;
            } else if (e(charAt)) {
                float ceil = (float) Math.ceil((double) fArr[i4]);
                fArr[i4] = ceil;
                fArr[i4] = ceil + f;
            } else {
                float ceil2 = (float) Math.ceil((double) fArr[i4]);
                fArr[i4] = ceil2;
                fArr[i4] = ceil2 + f2;
            }
            if (charAt == ' ' || ((charAt >= '0' && charAt <= '9') || (charAt >= 'A' && charAt <= 'Z'))) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (e(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (charAt == ' ' || ((charAt >= '0' && charAt <= '9') || (charAt >= 'a' && charAt <= 'z'))) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (e(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (f(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (e(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (charAt >= ' ' && charAt <= '^') {
                fArr[4] = fArr[4] + 0.75f;
            } else if (e(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            fArr[5] = fArr[5] + 1.0f;
            if (i6 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                b(fArr, iArr2, bArr2);
                int i10 = 0;
                for (int i11 = 0; i11 < 6; i11++) {
                    i10 += bArr2[i11];
                }
                int i12 = iArr2[0];
                int i13 = iArr2[5];
                if (i12 >= i13 || i12 >= iArr2[1] || i12 >= iArr2[2] || i12 >= iArr2[3] || i12 >= iArr2[4]) {
                    if (i13 < i12) {
                        break;
                    }
                    byte b2 = bArr2[1];
                    byte b3 = bArr2[2];
                    byte b4 = bArr2[3];
                    byte b5 = bArr2[4];
                    if (b2 + b3 + b4 + b5 == 0) {
                        break;
                    } else if (i10 == 1 && b5 > 0) {
                        return 4;
                    } else {
                        if (i10 == 1 && b3 > 0) {
                            return 2;
                        }
                        if (i10 == 1 && b4 > 0) {
                            return 3;
                        }
                        int i14 = iArr2[1];
                        int i15 = i14 + 1;
                        if (i15 < i12 && i15 < i13 && i15 < iArr2[4] && i15 < iArr2[2]) {
                            int i16 = iArr2[3];
                            if (i14 < i16) {
                                return 1;
                            }
                            if (i14 == i16) {
                                int i17 = i3 + i6 + 1;
                                while (i17 < charSequence.length()) {
                                    char charAt2 = charSequence2.charAt(i17);
                                    if (charAt2 != 13 && charAt2 != '*' && charAt2 != '>') {
                                        if (!f(charAt2)) {
                                            break;
                                        }
                                        i17++;
                                    } else {
                                        return 3;
                                    }
                                }
                                return 1;
                            }
                        }
                    }
                } else {
                    return 0;
                }
            }
            i4 = 0;
            i5 = 6;
            f = 2.0f;
            f2 = 1.0f;
        }
        return 5;
    }
}
