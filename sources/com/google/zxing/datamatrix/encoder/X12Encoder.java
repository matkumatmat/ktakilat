package com.google.zxing.datamatrix.encoder;

final class X12Encoder extends C40Encoder {
    public final void a(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.b()) {
                break;
            }
            char a2 = encoderContext.a();
            encoderContext.f++;
            b(a2, sb);
            if (sb.length() % 3 == 0) {
                C40Encoder.e(encoderContext, sb);
                int g = HighLevelEncoder.g(encoderContext.f420a, encoderContext.f, 3);
                if (g != 3) {
                    encoderContext.g = g;
                    break;
                }
            }
        }
        d(encoderContext, sb);
    }

    public final int b(char c, StringBuilder sb) {
        if (c == 13) {
            sb.append(0);
        } else if (c == '*') {
            sb.append(1);
        } else if (c == '>') {
            sb.append(2);
        } else if (c == ' ') {
            sb.append(3);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
        } else if (c < 'A' || c > 'Z') {
            HighLevelEncoder.c(c);
            throw null;
        } else {
            sb.append((char) (c - '3'));
        }
        return 1;
    }

    public final int c() {
        return 3;
    }

    public final void d(EncoderContext encoderContext, StringBuilder sb) {
        StringBuilder sb2 = encoderContext.e;
        encoderContext.c(sb2.length());
        int length = encoderContext.h.b - sb2.length();
        encoderContext.f -= sb.length();
        String str = encoderContext.f420a;
        if ((str.length() - encoderContext.i) - encoderContext.f > 1 || length > 1 || (str.length() - encoderContext.i) - encoderContext.f != length) {
            encoderContext.d(254);
        }
        if (encoderContext.g < 0) {
            encoderContext.g = 0;
        }
    }
}
