package com.trustdecision.android.bugly.l1ill1li1i;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import okio.Utf8;
import org.apache.commons.lang3.StringUtils;

public class liii1l1lll1 {
    private static byte[] l1l11i111l = new byte[64];
    private static byte[] liii1l1lll1 = new byte[256];

    static {
        int i = 0;
        for (int i2 = 0; i2 < 255; i2++) {
            liii1l1lll1[i2] = -1;
        }
        for (int i3 = 122; i3 >= 97; i3--) {
            liii1l1lll1[i3] = (byte) (i3 - 97);
        }
        byte[] bArr = liii1l1lll1;
        bArr[112] = Ascii.DLE;
        bArr[113] = Ascii.SI;
        for (int i4 = 90; i4 >= 65; i4--) {
            liii1l1lll1[i4] = (byte) (i4 - 39);
        }
        byte[] bArr2 = liii1l1lll1;
        bArr2[73] = 35;
        bArr2[74] = 34;
        for (int i5 = 57; i5 >= 48; i5--) {
            liii1l1lll1[i5] = (byte) (i5 + 4);
        }
        byte[] bArr3 = liii1l1lll1;
        bArr3[43] = 62;
        bArr3[47] = Utf8.REPLACEMENT_BYTE;
        for (int i6 = 0; i6 <= 25; i6++) {
            l1l11i111l[i6] = (byte) (i6 + 97);
        }
        byte[] bArr4 = l1l11i111l;
        bArr4[15] = 113;
        bArr4[16] = 112;
        int i7 = 0;
        for (int i8 = 26; i8 <= 51; i8++) {
            l1l11i111l[i8] = (byte) (i7 + 65);
            i7++;
        }
        byte[] bArr5 = l1l11i111l;
        bArr5[34] = 74;
        bArr5[35] = 73;
        for (int i9 = 52; i9 <= 61; i9++) {
            l1l11i111l[i9] = (byte) (i + 48);
            i++;
        }
        byte[] bArr6 = l1l11i111l;
        bArr6[62] = 43;
        bArr6[63] = 47;
    }

    public static byte[] liii1l1lll1(byte[] bArr) {
        return liii1l1lll1(bArr, false);
    }

    public static byte[] liii1l1lll1(byte[] bArr, boolean z) {
        int i;
        byte[] bArr2 = bArr;
        int length = bArr2.length * 8;
        int i2 = length % 24;
        int i3 = length / 24;
        int i4 = i2 != 0 ? (i3 + 1) * 4 : i3 * 4;
        if (z) {
            i = liii1l1lll1().length == 0 ? 0 : (int) Math.ceil((double) (((float) i4) / 76.0f));
            i4 += liii1l1lll1().length * i;
        } else {
            i = 0;
        }
        byte[] bArr3 = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 76;
        while (i5 < i3) {
            int i9 = i5 * 3;
            byte b = bArr2[i9];
            byte b2 = bArr2[i9 + 1];
            byte b3 = bArr2[i9 + 2];
            byte b4 = (byte) (b2 & Ascii.SI);
            byte b5 = (byte) (b & 3);
            byte b6 = b & UnsignedBytes.MAX_POWER_OF_TWO;
            int i10 = b >> 2;
            if (b6 != 0) {
                i10 ^= 192;
            }
            byte b7 = (byte) i10;
            byte b8 = b2 & UnsignedBytes.MAX_POWER_OF_TWO;
            int i11 = b2 >> 4;
            if (b8 != 0) {
                i11 ^= 240;
            }
            byte b9 = (byte) i11;
            int i12 = b3 >> 6;
            if ((b3 & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                i12 ^= 252;
            }
            byte b10 = (byte) i12;
            byte[] bArr4 = l1l11i111l;
            bArr3[i6] = bArr4[b7];
            bArr3[i6 + 1] = bArr4[(b5 << 4) | b9];
            bArr3[i6 + 2] = bArr4[(b4 << 2) | b10];
            bArr3[i6 + 3] = bArr4[b3 & Utf8.REPLACEMENT_BYTE];
            i6 += 4;
            if (z && i6 == i8) {
                System.arraycopy(liii1l1lll1(), 0, bArr3, i6, liii1l1lll1().length);
                int i13 = i7 + 1;
                i8 = (liii1l1lll1().length * i13) + ((i7 + 2) * 76);
                i6 += liii1l1lll1().length;
                i7 = i13;
            }
            i5++;
        }
        int i14 = i5 * 3;
        if (i2 == 8) {
            byte b11 = bArr2[i14];
            byte b12 = (byte) (b11 & 3);
            byte b13 = b11 & UnsignedBytes.MAX_POWER_OF_TWO;
            int i15 = b11 >> 2;
            if (b13 != 0) {
                i15 ^= 192;
            }
            byte b14 = (byte) i15;
            byte[] bArr5 = l1l11i111l;
            bArr3[i6] = bArr5[b14];
            bArr3[i6 + 1] = bArr5[b12 << 4];
            bArr3[i6 + 2] = 61;
            bArr3[i6 + 3] = 61;
        } else if (i2 == 16) {
            byte b15 = bArr2[i14];
            byte b16 = bArr2[i14 + 1];
            byte b17 = (byte) (b16 & Ascii.SI);
            byte b18 = (byte) (b15 & 3);
            byte b19 = b15 & UnsignedBytes.MAX_POWER_OF_TWO;
            int i16 = b15 >> 2;
            if (b19 != 0) {
                i16 ^= 192;
            }
            byte b20 = (byte) i16;
            byte b21 = b16 & UnsignedBytes.MAX_POWER_OF_TWO;
            int i17 = b16 >> 4;
            if (b21 != 0) {
                i17 ^= 240;
            }
            byte b22 = (byte) i17;
            byte[] bArr6 = l1l11i111l;
            bArr3[i6] = bArr6[b20];
            bArr3[i6 + 1] = bArr6[b22 | (b18 << 4)];
            bArr3[i6 + 2] = bArr6[b17 << 2];
            bArr3[i6 + 3] = 61;
        }
        if (z && i7 < i) {
            System.arraycopy(liii1l1lll1(), 0, bArr3, i4 - liii1l1lll1().length, liii1l1lll1().length);
        }
        return bArr3;
    }

    private static byte[] liii1l1lll1() {
        try {
            return StringUtils.LF.getBytes("utf-8");
        } catch (Throwable unused) {
            return null;
        }
    }
}
