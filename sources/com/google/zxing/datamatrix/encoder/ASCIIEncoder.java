package com.google.zxing.datamatrix.encoder;

final class ASCIIEncoder implements Encoder {
    public final void a(EncoderContext encoderContext) {
        int i;
        int i2 = encoderContext.f;
        String str = encoderContext.f420a;
        int length = str.length();
        if (i2 < length) {
            char charAt = str.charAt(i2);
            i = 0;
            while (HighLevelEncoder.d(charAt) && i2 < length) {
                i++;
                i2++;
                if (i2 < length) {
                    charAt = str.charAt(i2);
                }
            }
        } else {
            i = 0;
        }
        if (i >= 2) {
            char charAt2 = str.charAt(encoderContext.f);
            char charAt3 = str.charAt(encoderContext.f + 1);
            if (!HighLevelEncoder.d(charAt2) || !HighLevelEncoder.d(charAt3)) {
                throw new IllegalArgumentException("not digits: " + charAt2 + charAt3);
            }
            encoderContext.d((char) ((charAt3 - '0') + ((charAt2 - '0') * 10) + 130));
            encoderContext.f += 2;
            return;
        }
        char a2 = encoderContext.a();
        int g = HighLevelEncoder.g(str, encoderContext.f, 0);
        if (g != 0) {
            if (g == 1) {
                encoderContext.d(230);
                encoderContext.g = 1;
            } else if (g == 2) {
                encoderContext.d(239);
                encoderContext.g = 2;
            } else if (g == 3) {
                encoderContext.d(238);
                encoderContext.g = 3;
            } else if (g == 4) {
                encoderContext.d(240);
                encoderContext.g = 4;
            } else if (g == 5) {
                encoderContext.d(231);
                encoderContext.g = 5;
            } else {
                throw new IllegalStateException(ba.k(g, "Illegal mode: "));
            }
        } else if (HighLevelEncoder.e(a2)) {
            encoderContext.d(235);
            encoderContext.d((char) (a2 - 127));
            encoderContext.f++;
        } else {
            encoderContext.d((char) (a2 + 1));
            encoderContext.f++;
        }
    }
}
