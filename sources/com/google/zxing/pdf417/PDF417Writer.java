package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.Dimensions;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.EnumMap;

public final class PDF417Writer implements Writer {
    public static BitMatrix b(byte[][] bArr, int i) {
        int i2 = i * 2;
        int length = bArr.length + i2;
        BitMatrix bitMatrix = new BitMatrix(bArr[0].length + i2, length);
        int[] iArr = bitMatrix.f;
        int length2 = iArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            iArr[i3] = 0;
        }
        int i4 = (length - i) - 1;
        int i5 = 0;
        while (i5 < bArr.length) {
            for (int i6 = 0; i6 < bArr[0].length; i6++) {
                if (bArr[i5][i6] == 1) {
                    bitMatrix.b(i6 + i, i4);
                }
            }
            i5++;
            i4--;
        }
        return bitMatrix;
    }

    public static byte[][] c(byte[][] bArr) {
        int length = bArr[0].length;
        int[] iArr = new int[2];
        iArr[1] = bArr.length;
        iArr[0] = length;
        byte[][] bArr2 = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        for (int i = 0; i < bArr.length; i++) {
            int length2 = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length2] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    /* JADX WARNING: type inference failed for: r7v2, types: [java.lang.Object, com.google.zxing.pdf417.encoder.PDF417] */
    public final BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap) {
        boolean z;
        boolean z2;
        if (barcodeFormat == BarcodeFormat.PDF_417) {
            ? obj = new Object();
            obj.b = false;
            obj.c = Compaction.AUTO;
            obj.d = null;
            int i = 2;
            obj.e = 2;
            int i2 = 30;
            obj.f = 30;
            obj.g = 30;
            obj.h = 2;
            EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
            if (enumMap.containsKey(encodeHintType)) {
                obj.b = Boolean.valueOf(enumMap.get(encodeHintType).toString()).booleanValue();
            }
            EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
            if (enumMap.containsKey(encodeHintType2)) {
                obj.c = Compaction.valueOf(enumMap.get(encodeHintType2).toString());
            }
            EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
            if (enumMap.containsKey(encodeHintType3)) {
                ((Dimensions) enumMap.get(encodeHintType3)).getClass();
                obj.f = 0;
                obj.e = 0;
                obj.g = 0;
                obj.h = 0;
            }
            EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
            if (enumMap.containsKey(encodeHintType4)) {
                i2 = Integer.parseInt(enumMap.get(encodeHintType4).toString());
            }
            EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
            if (enumMap.containsKey(encodeHintType5)) {
                i = Integer.parseInt(enumMap.get(encodeHintType5).toString());
            }
            EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
            if (enumMap.containsKey(encodeHintType6)) {
                obj.d = Charset.forName(enumMap.get(encodeHintType6).toString());
            }
            obj.b(i, str);
            byte[][] b = obj.f441a.b(1, 4);
            if (b[0].length < b.length) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                b = c(b);
                z2 = true;
            } else {
                z2 = false;
            }
            int length = 200 / b[0].length;
            int length2 = 200 / b.length;
            if (length >= length2) {
                length = length2;
            }
            if (length <= 1) {
                return b(b, i2);
            }
            byte[][] b2 = obj.f441a.b(length, length << 2);
            if (z2) {
                b2 = c(b2);
            }
            return b(b2, i2);
        }
        throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
    }
}
