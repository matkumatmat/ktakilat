package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import java.util.EnumMap;

public final class QRCodeWriter implements Writer {
    public final BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap) {
        int i;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat == BarcodeFormat.QR_CODE) {
            ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
            EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
            if (enumMap.containsKey(encodeHintType)) {
                errorCorrectionLevel = ErrorCorrectionLevel.valueOf(enumMap.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
            if (enumMap.containsKey(encodeHintType2)) {
                i = Integer.parseInt(enumMap.get(encodeHintType2).toString());
            } else {
                i = 4;
            }
            ByteMatrix byteMatrix = Encoder.a(str, errorCorrectionLevel, enumMap).e;
            if (byteMatrix != null) {
                int i2 = i << 1;
                int i3 = byteMatrix.b;
                int i4 = i3 + i2;
                int i5 = byteMatrix.c;
                int i6 = i2 + i5;
                int max = Math.max(200, i4);
                int max2 = Math.max(200, i6);
                int min = Math.min(max / i4, max2 / i6);
                int i7 = (max - (i3 * min)) / 2;
                int i8 = (max2 - (i5 * min)) / 2;
                BitMatrix bitMatrix = new BitMatrix(max, max2);
                int i9 = 0;
                while (i9 < i5) {
                    int i10 = i7;
                    int i11 = 0;
                    while (i11 < i3) {
                        if (byteMatrix.a(i11, i9) == 1) {
                            bitMatrix.c(i10, i8, min, min);
                        }
                        i11++;
                        i10 += min;
                    }
                    i9++;
                    i8 += min;
                }
                return bitMatrix;
            }
            throw new IllegalStateException();
        } else {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
    }
}
