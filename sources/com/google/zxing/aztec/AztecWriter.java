package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.util.EnumMap;
import org.apache.commons.lang3.CharEncoding;

public final class AztecWriter implements Writer {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f405a = Charset.forName(CharEncoding.ISO_8859_1);

    public final BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap) {
        Charset charset;
        int i;
        int i2;
        EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
        if (enumMap.containsKey(encodeHintType)) {
            charset = Charset.forName(enumMap.get(encodeHintType).toString());
        } else {
            charset = f405a;
        }
        EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
        if (enumMap.containsKey(encodeHintType2)) {
            i = Integer.parseInt(enumMap.get(encodeHintType2).toString());
        } else {
            i = 33;
        }
        EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
        if (enumMap.containsKey(encodeHintType3)) {
            i2 = Integer.parseInt(enumMap.get(encodeHintType3).toString());
        } else {
            i2 = 0;
        }
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            BitMatrix bitMatrix = Encoder.b(str.getBytes(charset), i, i2).f407a;
            if (bitMatrix != null) {
                int i3 = bitMatrix.c;
                int max = Math.max(200, i3);
                int i4 = bitMatrix.d;
                int max2 = Math.max(200, i4);
                int min = Math.min(max / i3, max2 / i4);
                int i5 = (max - (i3 * min)) / 2;
                int i6 = (max2 - (i4 * min)) / 2;
                BitMatrix bitMatrix2 = new BitMatrix(max, max2);
                int i7 = 0;
                while (i7 < i4) {
                    int i8 = i5;
                    int i9 = 0;
                    while (i9 < i3) {
                        if (bitMatrix.a(i9, i7)) {
                            bitMatrix2.c(i8, i6, min, min);
                        }
                        i9++;
                        i8 += min;
                    }
                    i7++;
                    i6 += min;
                }
                return bitMatrix2;
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }
}
