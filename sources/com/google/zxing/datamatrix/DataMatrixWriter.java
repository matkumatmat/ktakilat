package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.EnumMap;

public final class DataMatrixWriter implements Writer {
    public final BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap) {
        int i;
        int i2;
        int i3;
        byte[] bArr;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        BarcodeFormat barcodeFormat2 = barcodeFormat;
        EnumMap enumMap2 = enumMap;
        int i4 = 3;
        int i5 = 2;
        int i6 = 1;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat2 == BarcodeFormat.DATA_MATRIX) {
            SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
            SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) enumMap2.get(EncodeHintType.DATA_MATRIX_SHAPE);
            if (symbolShapeHint2 != null) {
                symbolShapeHint = symbolShapeHint2;
            }
            Dimension dimension = (Dimension) enumMap2.get(EncodeHintType.MIN_SIZE);
            Dimension dimension2 = null;
            if (dimension == null) {
                dimension = null;
            }
            Dimension dimension3 = (Dimension) enumMap2.get(EncodeHintType.MAX_SIZE);
            if (dimension3 != null) {
                dimension2 = dimension3;
            }
            String a2 = HighLevelEncoder.a(str, symbolShapeHint, dimension, dimension2);
            SymbolInfo f = SymbolInfo.f(a2.length(), symbolShapeHint, dimension, dimension2);
            int[] iArr = ErrorCorrection.f421a;
            int length = a2.length();
            int i7 = f.b;
            if (length == i7) {
                int i8 = f.c;
                StringBuilder sb = new StringBuilder(i7 + i8);
                sb.append(a2);
                int c = f.c();
                int i9 = 0;
                if (c == 1) {
                    sb.append(ErrorCorrection.a(i8, a2));
                } else {
                    sb.setLength(sb.capacity());
                    int[] iArr2 = new int[c];
                    int[] iArr3 = new int[c];
                    int[] iArr4 = new int[c];
                    int i10 = 0;
                    while (i10 < c) {
                        int i11 = i10 + 1;
                        iArr2[i10] = f.a(i11);
                        iArr3[i10] = f.h;
                        iArr4[i10] = 0;
                        if (i10 > 0) {
                            iArr4[i10] = iArr4[i10 - 1] + iArr2[i10];
                        }
                        i10 = i11;
                    }
                    for (int i12 = 0; i12 < c; i12++) {
                        StringBuilder sb2 = new StringBuilder(iArr2[i12]);
                        for (int i13 = i12; i13 < i7; i13 += c) {
                            sb2.append(a2.charAt(i13));
                        }
                        String a3 = ErrorCorrection.a(iArr3[i12], sb2.toString());
                        int i14 = i12;
                        int i15 = 0;
                        while (i14 < iArr3[i12] * c) {
                            sb.setCharAt(i7 + i14, a3.charAt(i15));
                            i14 += c;
                            i15++;
                        }
                    }
                }
                String sb3 = sb.toString();
                int b = f.b();
                int i16 = f.d;
                int e = f.e();
                int i17 = f.e;
                DefaultPlacement defaultPlacement = new DefaultPlacement(sb3, b * i16, e * i17);
                int i18 = 4;
                int i19 = 0;
                int i20 = 0;
                while (true) {
                    i = defaultPlacement.c;
                    i2 = defaultPlacement.b;
                    if (i18 == i2 && i19 == 0) {
                        int i21 = i2 - 1;
                        defaultPlacement.a(i21, i9, i20, i6);
                        defaultPlacement.a(i21, i6, i20, i5);
                        defaultPlacement.a(i21, i5, i20, i4);
                        defaultPlacement.a(i9, i - 2, i20, 4);
                        int i22 = i - 1;
                        defaultPlacement.a(i9, i22, i20, 5);
                        defaultPlacement.a(i6, i22, i20, 6);
                        defaultPlacement.a(i5, i22, i20, 7);
                        defaultPlacement.a(3, i22, i20, 8);
                        i20++;
                    }
                    i3 = i2 - 2;
                    if (i18 == i3 && i19 == 0 && i % 4 != 0) {
                        defaultPlacement.a(i2 - 3, i9, i20, i6);
                        defaultPlacement.a(i3, i9, i20, i5);
                        defaultPlacement.a(i2 - 1, i9, i20, 3);
                        defaultPlacement.a(i9, i - 4, i20, 4);
                        defaultPlacement.a(i9, i - 3, i20, 5);
                        defaultPlacement.a(i9, i - 2, i20, 6);
                        i6 = 1;
                        int i23 = i - 1;
                        defaultPlacement.a(i9, i23, i20, 7);
                        defaultPlacement.a(1, i23, i20, 8);
                        i20++;
                    }
                    if (i18 == i3 && i19 == 0) {
                        if (i % 8 == 4) {
                            defaultPlacement.a(i2 - 3, i9, i20, i6);
                            defaultPlacement.a(i3, i9, i20, i5);
                            defaultPlacement.a(i2 - 1, i9, i20, 3);
                            defaultPlacement.a(i9, i - 2, i20, 4);
                            int i24 = i - 1;
                            defaultPlacement.a(i9, i24, i20, 5);
                            defaultPlacement.a(i6, i24, i20, 6);
                            defaultPlacement.a(i5, i24, i20, 7);
                            defaultPlacement.a(3, i24, i20, 8);
                            i20++;
                        }
                    }
                    if (i18 == i2 + 4 && i19 == i5 && i % 8 == 0) {
                        int i25 = i2 - 1;
                        defaultPlacement.a(i25, i9, i20, 1);
                        int i26 = i - 1;
                        defaultPlacement.a(i25, i26, i20, i5);
                        int i27 = i - 3;
                        defaultPlacement.a(i9, i27, i20, 3);
                        int i28 = i - 2;
                        defaultPlacement.a(i9, i28, i20, 4);
                        defaultPlacement.a(i9, i26, i20, 5);
                        defaultPlacement.a(1, i27, i20, 6);
                        defaultPlacement.a(1, i28, i20, 7);
                        defaultPlacement.a(1, i26, i20, 8);
                        i20++;
                    }
                    while (true) {
                        bArr = defaultPlacement.d;
                        if (i18 < i2 && i19 >= 0 && bArr[(i18 * i) + i19] < 0) {
                            defaultPlacement.b(i18, i19, i20);
                            i20++;
                        }
                        int i29 = i18 - 2;
                        int i30 = i19 + 2;
                        if (i29 < 0 || i30 >= i) {
                            int i31 = i18 - 1;
                            int i32 = i19 + 5;
                        } else {
                            i18 = i29;
                            i19 = i30;
                        }
                    }
                    int i312 = i18 - 1;
                    int i322 = i19 + 5;
                    while (true) {
                        if (i312 >= 0 && i322 < i && bArr[(i312 * i) + i322] < 0) {
                            defaultPlacement.b(i312, i322, i20);
                            i20++;
                        }
                        int i33 = i312 + 2;
                        int i34 = i322 - 2;
                        if (i33 < i2 && i34 >= 0) {
                            i322 = i34;
                            i312 = i33;
                        }
                    }
                    i18 = i312 + 5;
                    i19 = i322 - 1;
                    if (i18 >= i2 && i19 >= i) {
                        break;
                    }
                    i4 = 3;
                    i5 = 2;
                    i6 = 1;
                    i9 = 0;
                }
                int i35 = i - 1;
                int i36 = i2 - 1;
                if (bArr[(i36 * i) + i35] < 0) {
                    int i37 = (i36 * i) + i35;
                    byte b2 = (byte) 1;
                    bArr[i37] = b2;
                    bArr[(i3 * i) + (i - 2)] = b2;
                }
                int b3 = f.b() * i16;
                int e2 = f.e() * i17;
                ByteMatrix byteMatrix = new ByteMatrix(f.d(), (f.e() * i17) + (f.e() << 1));
                int i38 = 0;
                int i39 = 0;
                while (i38 < e2) {
                    int i40 = i38 % i17;
                    if (i40 == 0) {
                        int i41 = 0;
                        for (int i42 = 0; i42 < f.d(); i42++) {
                            if (i42 % 2 == 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            byteMatrix.c(i41, i39, z4);
                            i41++;
                        }
                        z = true;
                        i39++;
                    } else {
                        z = true;
                    }
                    int i43 = 0;
                    int i44 = 0;
                    while (i43 < b3) {
                        int i45 = i43 % i16;
                        if (i45 == 0) {
                            byteMatrix.c(i44, i39, z);
                            i44 += z;
                        }
                        if (bArr[(i38 * i) + i43] == z) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        byteMatrix.c(i44, i39, z2);
                        int i46 = i44 + 1;
                        int i47 = b3;
                        if (i45 == i16 - 1) {
                            if (i38 % 2 == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            byteMatrix.c(i46, i39, z3);
                            i44 += 2;
                        } else {
                            i44 = i46;
                        }
                        i43 += z;
                        b3 = i47;
                    }
                    int i48 = b3;
                    int i49 = i39 + 1;
                    if (i40 == i17 - 1) {
                        int i50 = 0;
                        for (int i51 = 0; i51 < f.d(); i51 += z) {
                            byteMatrix.c(i50, i49, z);
                            i50 += z;
                        }
                        i39 += 2;
                    } else {
                        i39 = i49;
                    }
                    i38 += z ? 1 : 0;
                    b3 = i48;
                }
                int i52 = byteMatrix.b;
                int i53 = byteMatrix.c;
                BitMatrix bitMatrix = new BitMatrix(i52, i53);
                int[] iArr5 = bitMatrix.f;
                int length2 = iArr5.length;
                for (int i54 = 0; i54 < length2; i54++) {
                    iArr5[i54] = 0;
                }
                for (int i55 = 0; i55 < i52; i55++) {
                    for (int i56 = 0; i56 < i53; i56++) {
                        if (byteMatrix.a(i55, i56) == 1) {
                            bitMatrix.b(i55, i56);
                        }
                    }
                }
                return bitMatrix;
            }
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        } else {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat2);
        }
    }
}
