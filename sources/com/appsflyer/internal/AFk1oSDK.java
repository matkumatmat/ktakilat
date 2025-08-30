package com.appsflyer.internal;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class AFk1oSDK extends FilterInputStream {
    private static final int[] AFAdRevenueData = AFk1uSDK.getRevenue;
    private static final int[] getCurrencyIso4217Code = AFk1uSDK.getCurrencyIso4217Code;
    private static final int[] getMediationNetwork = AFk1uSDK.AFAdRevenueData;
    private static final byte[] getMonetizationNetwork = AFk1uSDK.getMonetizationNetwork;
    private static final int[] getRevenue = AFk1uSDK.getMediationNetwork;
    private int AFInAppEventType;
    private int AFLogger;
    private final byte[][] areAllFieldsValid;
    private final byte[] component1;
    private final int[] component2;
    private final int component3;
    private final int[] component4;
    private int copy;
    private final int copydefault;
    private final byte[] equals;
    private final int hashCode;
    private int toString;

    public AFk1oSDK(InputStream inputStream, int i, byte[] bArr, byte[][] bArr2) {
        this(inputStream, i, bArr, bArr2, (byte) 0);
    }

    private void AFAdRevenueData(byte[] bArr, byte[] bArr2) {
        int[] iArr = this.component4;
        char c = 1;
        byte b = (bArr[0] << Ascii.CAN) | ((bArr[1] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[2] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[3] & UnsignedBytes.MAX_VALUE);
        int[] iArr2 = this.component2;
        iArr[0] = b ^ iArr2[0];
        iArr[1] = ((((bArr[4] << Ascii.CAN) | ((bArr[5] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) | ((bArr[6] & UnsignedBytes.MAX_VALUE) << 8)) | (bArr[7] & UnsignedBytes.MAX_VALUE)) ^ iArr2[1];
        iArr[2] = ((((bArr[8] << Ascii.CAN) | ((bArr[9] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) | ((bArr[10] & UnsignedBytes.MAX_VALUE) << 8)) | (bArr[11] & UnsignedBytes.MAX_VALUE)) ^ iArr2[2];
        int i = bArr[12] << Ascii.CAN;
        iArr[3] = iArr2[3] ^ (((((bArr[13] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | i) | ((bArr[14] & UnsignedBytes.MAX_VALUE) << 8)) | (bArr[15] & UnsignedBytes.MAX_VALUE));
        int i2 = 1;
        int i3 = 4;
        while (i2 < this.component3) {
            int[] iArr3 = getRevenue;
            int[] iArr4 = this.component4;
            byte[][] bArr3 = this.areAllFieldsValid;
            byte[] bArr4 = bArr3[0];
            int i4 = iArr3[iArr4[bArr4[0]] >>> 24];
            int[] iArr5 = getMediationNetwork;
            byte[] bArr5 = bArr3[c];
            int i5 = i4 ^ iArr5[(iArr4[bArr5[0]] >>> 16) & 255];
            int[] iArr6 = getCurrencyIso4217Code;
            byte[] bArr6 = bArr3[2];
            int i6 = iArr6[(iArr4[bArr6[0]] >>> 8) & 255] ^ i5;
            int[] iArr7 = AFAdRevenueData;
            byte[] bArr7 = bArr3[3];
            int i7 = iArr7[iArr4[bArr7[0]] & 255] ^ i6;
            int[] iArr8 = this.component2;
            int i8 = i7 ^ iArr8[i3];
            int i9 = ((iArr6[(iArr4[bArr6[c]] >>> 8) & 255] ^ (iArr3[iArr4[bArr4[c]] >>> 24] ^ iArr5[(iArr4[bArr5[c]] >>> 16) & 255])) ^ iArr7[iArr4[bArr7[c]] & 255]) ^ iArr8[i3 + 1];
            int i10 = (((iArr5[(iArr4[bArr5[2]] >>> 16) & 255] ^ iArr3[iArr4[bArr4[2]] >>> 24]) ^ iArr6[(iArr4[bArr6[2]] >>> 8) & 255]) ^ iArr7[iArr4[bArr7[2]] & 255]) ^ iArr8[i3 + 2];
            iArr4[0] = i8;
            iArr4[1] = i9;
            iArr4[2] = i10;
            iArr4[3] = (((iArr3[iArr4[bArr4[3]] >>> 24] ^ iArr5[(iArr4[bArr5[3]] >>> 16) & 255]) ^ iArr6[(iArr4[bArr6[3]] >>> 8) & 255]) ^ iArr7[iArr4[bArr7[3]] & 255]) ^ iArr8[i3 + 3];
            i2++;
            i3 += 4;
            c = 1;
        }
        int[] iArr9 = this.component2;
        int i11 = iArr9[i3];
        byte[] bArr8 = getMonetizationNetwork;
        int[] iArr10 = this.component4;
        byte[][] bArr9 = this.areAllFieldsValid;
        byte[] bArr10 = bArr9[0];
        bArr2[0] = (byte) (bArr8[iArr10[bArr10[0]] >>> 24] ^ (i11 >>> 24));
        byte[] bArr11 = bArr9[1];
        bArr2[1] = (byte) (bArr8[(iArr10[bArr11[0]] >>> 16) & 255] ^ (i11 >>> 16));
        byte[] bArr12 = bArr9[2];
        bArr2[2] = (byte) (bArr8[(iArr10[bArr12[0]] >>> 8) & 255] ^ (i11 >>> 8));
        byte[] bArr13 = bArr9[3];
        bArr2[3] = (byte) (bArr8[iArr10[bArr13[0]] & 255] ^ i11);
        int i12 = iArr9[i3 + 1];
        bArr2[4] = (byte) (bArr8[iArr10[bArr10[1]] >>> 24] ^ (i12 >>> 24));
        bArr2[5] = (byte) (bArr8[(iArr10[bArr11[1]] >>> 16) & 255] ^ (i12 >>> 16));
        bArr2[6] = (byte) (bArr8[(iArr10[bArr12[1]] >>> 8) & 255] ^ (i12 >>> 8));
        bArr2[7] = (byte) (i12 ^ bArr8[iArr10[bArr13[1]] & 255]);
        int i13 = iArr9[i3 + 2];
        bArr2[8] = (byte) (bArr8[iArr10[bArr10[2]] >>> 24] ^ (i13 >>> 24));
        bArr2[9] = (byte) (bArr8[(iArr10[bArr11[2]] >>> 16) & 255] ^ (i13 >>> 16));
        bArr2[10] = (byte) (bArr8[(iArr10[bArr12[2]] >>> 8) & 255] ^ (i13 >>> 8));
        bArr2[11] = (byte) (i13 ^ bArr8[iArr10[bArr13[2]] & 255]);
        int i14 = iArr9[i3 + 3];
        bArr2[12] = (byte) (bArr8[iArr10[bArr10[3]] >>> 24] ^ (i14 >>> 24));
        bArr2[13] = (byte) (bArr8[(iArr10[bArr11[3]] >>> 16) & 255] ^ (i14 >>> 16));
        bArr2[14] = (byte) (bArr8[(iArr10[bArr12[3]] >>> 8) & 255] ^ (i14 >>> 8));
        bArr2[15] = (byte) (i14 ^ bArr8[iArr10[bArr13[3]] & 255]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getMediationNetwork() throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.toString
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r8.in
            int r0 = r0.read()
            r8.toString = r0
        L_0x000f:
            int r0 = r8.AFInAppEventType
            r1 = 16
            if (r0 != r1) goto L_0x0086
            byte[] r0 = r8.component1
            int r2 = r8.toString
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x0080
            r2 = 1
            r3 = 1
        L_0x0023:
            java.io.InputStream r5 = r8.in
            byte[] r6 = r8.component1
            int r7 = 16 - r3
            int r5 = r5.read(r6, r3, r7)
            if (r5 <= 0) goto L_0x0032
            int r3 = r3 + r5
            if (r3 < r1) goto L_0x0023
        L_0x0032:
            if (r3 < r1) goto L_0x007a
            int r0 = r8.copydefault
            int r3 = r8.hashCode
            if (r0 != r3) goto L_0x0042
            byte[] r0 = r8.component1
            byte[] r2 = r8.equals
            r8.AFAdRevenueData(r0, r2)
            goto L_0x0062
        L_0x0042:
            int r3 = r8.copy
            if (r3 > r0) goto L_0x004e
            byte[] r0 = r8.component1
            byte[] r3 = r8.equals
            r8.AFAdRevenueData(r0, r3)
            goto L_0x0056
        L_0x004e:
            byte[] r0 = r8.component1
            byte[] r3 = r8.equals
            int r5 = r0.length
            java.lang.System.arraycopy(r0, r4, r3, r4, r5)
        L_0x0056:
            int r0 = r8.copy
            int r3 = r8.hashCode
            if (r0 >= r3) goto L_0x0060
            int r0 = r0 + r2
            r8.copy = r0
            goto L_0x0062
        L_0x0060:
            r8.copy = r2
        L_0x0062:
            java.io.InputStream r0 = r8.in
            int r0 = r0.read()
            r8.toString = r0
            r8.AFInAppEventType = r4
            if (r0 >= 0) goto L_0x0077
            byte[] r0 = r8.equals
            r2 = 15
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x0077:
            r8.AFLogger = r1
            goto L_0x0086
        L_0x007a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0080:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0086:
            int r0 = r8.AFLogger
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFk1oSDK.getMediationNetwork():int");
    }

    private static byte[][] getRevenue(byte[][] bArr) {
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = new byte[bArr[i].length];
            int i2 = 0;
            while (true) {
                byte[] bArr3 = bArr[i];
                if (i2 >= bArr3.length) {
                    break;
                }
                bArr2[i][bArr3[i2]] = (byte) i2;
                i2++;
            }
        }
        return bArr2;
    }

    public final int available() throws IOException {
        getMediationNetwork();
        return this.AFLogger - this.AFInAppEventType;
    }

    public final void close() throws IOException {
        super.close();
    }

    public final synchronized void mark(int i) {
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        getMediationNetwork();
        int i = this.AFInAppEventType;
        if (i >= this.AFLogger) {
            return -1;
        }
        byte[] bArr = this.equals;
        this.AFInAppEventType = i + 1;
        return bArr[i] & UnsignedBytes.MAX_VALUE;
    }

    public final synchronized void reset() throws IOException {
    }

    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    private AFk1oSDK(InputStream inputStream, int i, byte[] bArr, byte[][] bArr2, byte b) {
        super(new BufferedInputStream(inputStream, 4096));
        this.component4 = new int[4];
        this.component1 = new byte[16];
        this.equals = new byte[16];
        this.copy = 1;
        this.toString = Integer.MAX_VALUE;
        this.AFInAppEventType = 16;
        this.AFLogger = 16;
        this.component3 = i;
        this.component2 = AFk1uSDK.getCurrencyIso4217Code(bArr, i);
        this.areAllFieldsValid = getRevenue(bArr2);
        this.copydefault = 100;
        this.hashCode = 100;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = i;
        while (i4 < i3) {
            getMediationNetwork();
            int i5 = this.AFInAppEventType;
            if (i5 < this.AFLogger) {
                byte[] bArr2 = this.equals;
                this.AFInAppEventType = i5 + 1;
                bArr[i4] = bArr2[i5];
                i4++;
            } else if (i4 == i) {
                return -1;
            } else {
                return i2 - (i3 - i4);
            }
        }
        return i2;
    }
}
