package com.google.zxing.pdf417.encoder;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;
import org.apache.commons.lang3.CharEncoding;

final class PDF417HighLevelEncoder {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f443a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, Ascii.CR, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    public static final byte[] b = {59, 60, 62, SignedBytes.MAX_POWER_OF_TWO, 91, 92, 93, 95, 96, 126, 33, Ascii.CR, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, Utf8.REPLACEMENT_BYTE, 123, 125, 39, 0};
    public static final byte[] c;
    public static final byte[] d = new byte[128];
    public static final Charset e = Charset.forName(CharEncoding.ISO_8859_1);

    static {
        int i = 0;
        byte[] bArr = new byte[128];
        c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f443a;
            if (i2 >= bArr2.length) {
                break;
            }
            byte b2 = bArr2[i2];
            if (b2 > 0) {
                c[b2] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(d, (byte) -1);
        while (true) {
            byte[] bArr3 = b;
            if (i < bArr3.length) {
                byte b3 = bArr3[i];
                if (b3 > 0) {
                    d[b3] = (byte) i;
                }
                i++;
            } else {
                return;
            }
        }
    }

    public static void a(byte[] bArr, int i, int i2, StringBuilder sb) {
        if (i == 1 && i2 == 0) {
            sb.append(913);
        } else if (i % 6 == 0) {
            sb.append(924);
        } else {
            sb.append(901);
        }
        int i3 = 0;
        if (i >= 6) {
            char[] cArr = new char[5];
            int i4 = 0;
            while (i - i4 >= 6) {
                long j = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + ((long) (bArr[i4 + i5] & UnsignedBytes.MAX_VALUE));
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
            i3 = i4;
        }
        while (i3 < i) {
            sb.append((char) (bArr[i3] & UnsignedBytes.MAX_VALUE));
            i3++;
        }
    }

    public static void b(StringBuilder sb, int i, int i2, String str) {
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int min = Math.min(44, i2 - i3);
            StringBuilder sb3 = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            int i4 = i + i3;
            sb3.append(str.substring(i4, i4 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i3 += min;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e4 A[EDGE_INSN: B:68:0x00e4->B:55:0x00e4 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x000e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int c(int r17, int r18, int r19, java.lang.String r20, java.lang.StringBuilder r21) {
        /*
            r0 = r18
            r1 = r20
            r2 = r21
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            r5 = r19
            r6 = 0
        L_0x000e:
            int r7 = r17 + r6
            char r8 = r1.charAt(r7)
            byte[] r9 = d
            r10 = 2
            byte[] r11 = c
            r12 = 1
            r13 = -1
            r4 = 27
            r14 = 28
            r15 = 29
            if (r5 == 0) goto L_0x00ae
            if (r5 == r12) goto L_0x0073
            if (r5 == r10) goto L_0x0036
            byte r4 = r9[r8]
            if (r4 == r13) goto L_0x0031
            char r4 = (char) r4
            r3.append(r4)
            goto L_0x00e0
        L_0x0031:
            r3.append(r15)
        L_0x0034:
            r5 = 0
            goto L_0x000e
        L_0x0036:
            byte r11 = r11[r8]
            if (r11 == r13) goto L_0x0040
            char r4 = (char) r11
            r3.append(r4)
            goto L_0x00e0
        L_0x0040:
            boolean r11 = e(r8)
            if (r11 == 0) goto L_0x004a
            r3.append(r14)
            goto L_0x0034
        L_0x004a:
            boolean r11 = d(r8)
            if (r11 == 0) goto L_0x0055
            r3.append(r4)
        L_0x0053:
            r5 = 1
            goto L_0x000e
        L_0x0055:
            int r7 = r7 + 1
            if (r7 >= r0) goto L_0x0068
            char r4 = r1.charAt(r7)
            byte r4 = r9[r4]
            if (r4 == r13) goto L_0x0068
            r4 = 25
            r3.append(r4)
            r5 = 3
            goto L_0x000e
        L_0x0068:
            r3.append(r15)
            byte r4 = r9[r8]
            char r4 = (char) r4
            r3.append(r4)
            goto L_0x00e0
        L_0x0073:
            boolean r7 = d(r8)
            if (r7 == 0) goto L_0x008a
            r7 = 32
            if (r8 != r7) goto L_0x0083
            r4 = 26
            r3.append(r4)
            goto L_0x00e0
        L_0x0083:
            int r8 = r8 + -97
            char r4 = (char) r8
            r3.append(r4)
            goto L_0x00e0
        L_0x008a:
            boolean r7 = e(r8)
            if (r7 == 0) goto L_0x009a
            r3.append(r4)
            int r8 = r8 + -65
            char r4 = (char) r8
            r3.append(r4)
            goto L_0x00e0
        L_0x009a:
            byte r4 = r11[r8]
            if (r4 == r13) goto L_0x00a4
            r3.append(r14)
        L_0x00a1:
            r5 = 2
            goto L_0x000e
        L_0x00a4:
            r3.append(r15)
            byte r4 = r9[r8]
            char r4 = (char) r4
            r3.append(r4)
            goto L_0x00e0
        L_0x00ae:
            boolean r7 = e(r8)
            if (r7 == 0) goto L_0x00c5
            r7 = 32
            if (r8 != r7) goto L_0x00be
            r4 = 26
            r3.append(r4)
            goto L_0x00e0
        L_0x00be:
            int r8 = r8 + -65
            char r4 = (char) r8
            r3.append(r4)
            goto L_0x00e0
        L_0x00c5:
            boolean r7 = d(r8)
            if (r7 == 0) goto L_0x00cf
            r3.append(r4)
            goto L_0x0053
        L_0x00cf:
            byte r4 = r11[r8]
            if (r4 == r13) goto L_0x00d7
            r3.append(r14)
            goto L_0x00a1
        L_0x00d7:
            r3.append(r15)
            byte r4 = r9[r8]
            char r4 = (char) r4
            r3.append(r4)
        L_0x00e0:
            int r6 = r6 + 1
            if (r6 < r0) goto L_0x000e
            int r0 = r3.length()
            r4 = 0
            r16 = 0
        L_0x00eb:
            if (r4 >= r0) goto L_0x0108
            int r1 = r4 % 2
            if (r1 == 0) goto L_0x0100
            int r16 = r16 * 30
            char r1 = r3.charAt(r4)
            int r1 = r1 + r16
            char r1 = (char) r1
            r2.append(r1)
        L_0x00fd:
            r16 = r1
            goto L_0x0105
        L_0x0100:
            char r1 = r3.charAt(r4)
            goto L_0x00fd
        L_0x0105:
            int r4 = r4 + 1
            goto L_0x00eb
        L_0x0108:
            int r0 = r0 % r10
            if (r0 == 0) goto L_0x0113
            int r16 = r16 * 30
            int r0 = r16 + 29
            char r0 = (char) r0
            r2.append(r0)
        L_0x0113:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.c(int, int, int, java.lang.String, java.lang.StringBuilder):int");
    }

    public static boolean d(char c2) {
        if (c2 != ' ') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    public static boolean e(char c2) {
        if (c2 != ' ') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }
}
