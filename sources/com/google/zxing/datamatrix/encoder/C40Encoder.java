package com.google.zxing.datamatrix.encoder;

class C40Encoder implements Encoder {
    public static void e(EncoderContext encoderContext, StringBuilder sb) {
        char charAt = sb.charAt(0);
        int charAt2 = (sb.charAt(1) * '(') + (charAt * 1600) + sb.charAt(2) + 1;
        encoderContext.e.append(new String(new char[]{(char) (charAt2 / 256), (char) (charAt2 % 256)}));
        sb.delete(0, 3);
    }

    public void a(EncoderContext encoderContext) {
        int g;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.b()) {
                break;
            }
            char a2 = encoderContext.a();
            encoderContext.f++;
            int b = b(a2, sb);
            int length = encoderContext.e.length() + ((sb.length() / 3) << 1);
            encoderContext.c(length);
            int i = encoderContext.h.b - length;
            if (encoderContext.b()) {
                if (sb.length() % 3 == 0 && (g = HighLevelEncoder.g(encoderContext.f420a, encoderContext.f, c())) != c()) {
                    encoderContext.g = g;
                    break;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (i < 2 || i > 2)) {
                    int length2 = sb.length();
                    sb.delete(length2 - b, length2);
                    encoderContext.f--;
                    b = b(encoderContext.a(), sb2);
                    encoderContext.h = null;
                }
                while (sb.length() % 3 == 1 && ((b <= 3 && i != 1) || b > 3)) {
                    int length3 = sb.length();
                    sb.delete(length3 - b, length3);
                    encoderContext.f--;
                    b = b(encoderContext.a(), sb2);
                    encoderContext.h = null;
                }
            }
        }
        d(encoderContext, sb);
    }

    public int b(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append(3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) (c - '3'));
            return 1;
        } else if (c >= 0 && c <= 31) {
            sb.append(0);
            sb.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            sb.append(1);
            sb.append((char) (c - '!'));
            return 2;
        } else if (c >= ':' && c <= '@') {
            sb.append(1);
            sb.append((char) (c - '+'));
            return 2;
        } else if (c >= '[' && c <= '_') {
            sb.append(1);
            sb.append((char) (c - 'E'));
            return 2;
        } else if (c >= '`' && c <= 127) {
            sb.append(2);
            sb.append((char) (c - '`'));
            return 2;
        } else if (c >= 128) {
            sb.append("\u0001\u001e");
            return b((char) (c - 128), sb) + 2;
        } else {
            throw new IllegalArgumentException("Illegal character: " + c);
        }
    }

    public int c() {
        return 1;
    }

    public void d(EncoderContext encoderContext, StringBuilder sb) {
        int length = sb.length() % 3;
        int length2 = encoderContext.e.length() + ((sb.length() / 3) << 1);
        encoderContext.c(length2);
        int i = encoderContext.h.b - length2;
        if (length == 2) {
            sb.append(0);
            while (sb.length() >= 3) {
                e(encoderContext, sb);
            }
            if (encoderContext.b()) {
                encoderContext.d(254);
            }
        } else if (i == 1 && length == 1) {
            while (sb.length() >= 3) {
                e(encoderContext, sb);
            }
            if (encoderContext.b()) {
                encoderContext.d(254);
            }
            encoderContext.f--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                e(encoderContext, sb);
            }
            if (i > 0 || encoderContext.b()) {
                encoderContext.d(254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        encoderContext.g = 0;
    }
}
