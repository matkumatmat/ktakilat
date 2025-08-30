package com.appsflyer.internal;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

public final class AFk1uSDK {
    static final int[] AFAdRevenueData = new int[256];
    private static int[] areAllFieldsValid = new int[10];
    private static byte[] component1 = new byte[256];
    static final int[] getCurrencyIso4217Code = new int[256];
    static final int[] getMediationNetwork = new int[256];
    static final byte[] getMonetizationNetwork = new byte[256];
    static final int[] getRevenue = new int[256];

    static {
        byte b;
        byte b2;
        byte[] bArr;
        byte b3;
        byte b4 = 1;
        byte b5 = 1;
        do {
            byte b6 = (b4 << 1) ^ b4;
            if ((b4 & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                b = Ascii.ESC;
            } else {
                b = 0;
            }
            b4 = (byte) (b ^ b6);
            byte b7 = (byte) (b5 ^ (b5 << 1));
            byte b8 = (byte) (b7 ^ (b7 << 2));
            byte b9 = (byte) (b8 ^ (b8 << 4));
            if ((b9 & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                b2 = 9;
            } else {
                b2 = 0;
            }
            b5 = (byte) (b9 ^ b2);
            bArr = component1;
            b3 = b4 & UnsignedBytes.MAX_VALUE;
            byte b10 = b5 & UnsignedBytes.MAX_VALUE;
            bArr[b3] = (byte) (((((b5 ^ 99) ^ ((b10 << 1) | (b10 >> 7))) ^ ((b10 << 2) | (b10 >> 6))) ^ ((b10 << 3) | (b10 >> 5))) ^ ((b10 >> 4) | (b10 << 4)));
        } while (b3 != 1);
        bArr[0] = 99;
        for (int i = 0; i < 256; i++) {
            byte b11 = component1[i] & UnsignedBytes.MAX_VALUE;
            getMonetizationNetwork[b11] = (byte) i;
            int i2 = i << 1;
            if (i2 >= 256) {
                i2 ^= 283;
            }
            int i3 = i2 << 1;
            if (i3 >= 256) {
                i3 ^= 283;
            }
            int i4 = i3 << 1;
            if (i4 >= 256) {
                i4 ^= 283;
            }
            int i5 = i4 ^ i;
            int i6 = ((i2 ^ (i3 ^ i4)) << 24) | (i5 << 16) | ((i5 ^ i3) << 8) | (i5 ^ i2);
            getMediationNetwork[b11] = i6;
            AFAdRevenueData[b11] = (i6 >>> 8) | (i6 << 24);
            getCurrencyIso4217Code[b11] = (i6 >>> 16) | (i6 << 16);
            getRevenue[b11] = (i6 << 8) | (i6 >>> 24);
        }
        areAllFieldsValid[0] = 16777216;
        int i7 = 1;
        for (int i8 = 1; i8 < 10; i8++) {
            i7 <<= 1;
            if (i7 >= 256) {
                i7 ^= 283;
            }
            areAllFieldsValid[i8] = i7 << 24;
        }
    }

    public static int[] getCurrencyIso4217Code(byte[] bArr, int i) throws IllegalArgumentException {
        byte[] bArr2 = bArr;
        int i2 = i;
        if (bArr2.length == 16) {
            int i3 = 4;
            int i4 = (i2 + 1) * 4;
            int[] iArr = new int[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < 4; i6++) {
                byte b = ((bArr2[i5 + 1] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | (bArr2[i5] << Ascii.CAN);
                int i7 = i5 + 3;
                i5 += 4;
                iArr[i6] = b | ((bArr2[i5 + 2] & UnsignedBytes.MAX_VALUE) << 8) | (bArr2[i7] & UnsignedBytes.MAX_VALUE);
            }
            int i8 = 4;
            int i9 = 0;
            int i10 = 0;
            while (i8 < i4) {
                int i11 = iArr[i8 - 1];
                if (i9 == 0) {
                    byte[] bArr3 = component1;
                    i11 = ((bArr3[i11 >>> 24] & UnsignedBytes.MAX_VALUE) | (((bArr3[(i11 >>> 16) & 255] << Ascii.CAN) | ((bArr3[(i11 >>> 8) & 255] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) | ((bArr3[i11 & 255] & UnsignedBytes.MAX_VALUE) << 8))) ^ areAllFieldsValid[i10];
                    i10++;
                    i9 = 4;
                }
                iArr[i8] = i11 ^ iArr[i8 - 4];
                i8++;
                i9--;
            }
            if (bArr2.length == 16) {
                int[] iArr2 = new int[i4];
                int i12 = i2 * 4;
                iArr2[0] = iArr[i12];
                int i13 = 1;
                iArr2[1] = iArr[i12 + 1];
                iArr2[2] = iArr[i12 + 2];
                iArr2[3] = iArr[i12 + 3];
                int i14 = i12 - 4;
                while (i13 < i2) {
                    int i15 = iArr[i14];
                    int[] iArr3 = getMediationNetwork;
                    byte[] bArr4 = component1;
                    int i16 = iArr3[bArr4[i15 >>> 24] & UnsignedBytes.MAX_VALUE];
                    int[] iArr4 = AFAdRevenueData;
                    int i17 = i16 ^ iArr4[bArr4[(i15 >>> 16) & 255] & UnsignedBytes.MAX_VALUE];
                    int[] iArr5 = getCurrencyIso4217Code;
                    int i18 = i17 ^ iArr5[bArr4[(i15 >>> 8) & 255] & UnsignedBytes.MAX_VALUE];
                    int[] iArr6 = getRevenue;
                    iArr2[i3] = iArr6[bArr4[i15 & 255] & UnsignedBytes.MAX_VALUE] ^ i18;
                    int i19 = iArr[i14 + 1];
                    iArr2[i3 + 1] = ((iArr4[bArr4[(i19 >>> 16) & 255] & UnsignedBytes.MAX_VALUE] ^ iArr3[bArr4[i19 >>> 24] & UnsignedBytes.MAX_VALUE]) ^ iArr5[bArr4[(i19 >>> 8) & 255] & UnsignedBytes.MAX_VALUE]) ^ iArr6[bArr4[i19 & 255] & UnsignedBytes.MAX_VALUE];
                    int i20 = iArr[i14 + 2];
                    int i21 = i3 + 3;
                    iArr2[i3 + 2] = iArr6[bArr4[i20 & 255] & UnsignedBytes.MAX_VALUE] ^ ((iArr3[bArr4[i20 >>> 24] & UnsignedBytes.MAX_VALUE] ^ iArr4[bArr4[(i20 >>> 16) & 255] & UnsignedBytes.MAX_VALUE]) ^ iArr5[bArr4[(i20 >>> 8) & 255] & UnsignedBytes.MAX_VALUE]);
                    int i22 = iArr[i14 + 3];
                    i3 += 4;
                    iArr2[i21] = iArr6[bArr4[i22 & 255] & UnsignedBytes.MAX_VALUE] ^ ((iArr3[bArr4[i22 >>> 24] & UnsignedBytes.MAX_VALUE] ^ iArr4[bArr4[(i22 >>> 16) & 255] & UnsignedBytes.MAX_VALUE]) ^ iArr5[bArr4[(i22 >>> 8) & 255] & UnsignedBytes.MAX_VALUE]);
                    i14 -= 4;
                    i13++;
                    i2 = i;
                }
                iArr2[i3] = iArr[i14];
                iArr2[i3 + 1] = iArr[i14 + 1];
                iArr2[i3 + 2] = iArr[i14 + 2];
                iArr2[i3 + 3] = iArr[i14 + 3];
                return iArr2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static byte[][] getMediationNetwork(int i) {
        byte[][] bArr = new byte[4][];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i >>> (i2 << 3);
            bArr[i2] = new byte[]{(byte) (i3 & 3), (byte) ((i3 >> 2) & 3), (byte) ((i3 >> 4) & 3), (byte) ((i3 >> 6) & 3)};
        }
        return bArr;
    }
}
