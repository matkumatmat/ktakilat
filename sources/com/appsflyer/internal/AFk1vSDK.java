package com.appsflyer.internal;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class AFk1vSDK extends FilterInputStream {
    private final int AFAdRevenueData;
    private int areAllFieldsValid;
    private byte[] component1;
    private int[] component2;
    private byte[] component3;
    private byte[] component4;
    private int copydefault;
    private final int getCurrencyIso4217Code;
    private final int getMediationNetwork;
    private AFk1sSDK getMonetizationNetwork;
    private int getRevenue;
    private int hashCode;
    private int toString;

    public AFk1vSDK(InputStream inputStream, int[] iArr, byte[] bArr, int i, boolean z, int i2) throws IOException {
        this(inputStream, iArr, bArr, i, false, i2, (byte) 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int AFAdRevenueData() throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.hashCode
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r8.in
            int r0 = r0.read()
            r8.hashCode = r0
        L_0x000f:
            int r0 = r8.areAllFieldsValid
            r1 = 8
            if (r0 != r1) goto L_0x0074
            byte[] r0 = r8.component4
            int r2 = r8.hashCode
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x006e
            r2 = 1
            r3 = 1
        L_0x0023:
            java.io.InputStream r5 = r8.in
            byte[] r6 = r8.component4
            int r7 = 8 - r3
            int r5 = r5.read(r6, r3, r7)
            if (r5 <= 0) goto L_0x0032
            int r3 = r3 + r5
            if (r3 < r1) goto L_0x0023
        L_0x0032:
            if (r3 < r1) goto L_0x0068
            int r0 = r8.getMediationNetwork
            int r3 = r8.AFAdRevenueData
            if (r0 != r3) goto L_0x003e
            r8.getCurrencyIso4217Code()
            goto L_0x0051
        L_0x003e:
            int r3 = r8.getRevenue
            if (r3 > r0) goto L_0x0045
            r8.getCurrencyIso4217Code()
        L_0x0045:
            int r0 = r8.getRevenue
            int r3 = r8.AFAdRevenueData
            if (r0 >= r3) goto L_0x004f
            int r0 = r0 + r2
            r8.getRevenue = r0
            goto L_0x0051
        L_0x004f:
            r8.getRevenue = r2
        L_0x0051:
            java.io.InputStream r0 = r8.in
            int r0 = r0.read()
            r8.hashCode = r0
            r8.areAllFieldsValid = r4
            if (r0 >= 0) goto L_0x0065
            byte[] r0 = r8.component4
            r2 = 7
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x0065:
            r8.toString = r1
            goto L_0x0074
        L_0x0068:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x006e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0074:
            int r0 = r8.toString
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFk1vSDK.AFAdRevenueData():int");
    }

    private void getCurrencyIso4217Code() {
        if (this.copydefault == 2) {
            byte[] bArr = this.component4;
            System.arraycopy(bArr, 0, this.component3, 0, bArr.length);
        }
        byte[] bArr2 = this.component4;
        int i = ((bArr2[0] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) + ((bArr2[1] << Ascii.DLE) & 16711680) + ((bArr2[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & UnsignedBytes.MAX_VALUE);
        int i2 = (-16777216 & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << Ascii.DLE)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & UnsignedBytes.MAX_VALUE);
        int i3 = this.getCurrencyIso4217Code;
        AFk1sSDK aFk1sSDK = this.getMonetizationNetwork;
        int[] iArr = aFk1sSDK.getCurrencyIso4217Code;
        AFk1tSDK.AFAdRevenueData(i, i2, false, i3, iArr, aFk1sSDK.getRevenue, this.component2);
        int[] iArr2 = this.component2;
        int i4 = iArr2[0];
        int i5 = iArr2[1];
        byte[] bArr3 = this.component4;
        bArr3[0] = (byte) (i4 >> 24);
        bArr3[1] = (byte) (i4 >> 16);
        bArr3[2] = (byte) (i4 >> 8);
        bArr3[3] = (byte) i4;
        bArr3[4] = (byte) (i5 >> 24);
        bArr3[5] = (byte) (i5 >> 16);
        bArr3[6] = (byte) (i5 >> 8);
        bArr3[7] = (byte) i5;
        if (this.copydefault == 2) {
            for (int i6 = 0; i6 < 8; i6++) {
                byte[] bArr4 = this.component4;
                bArr4[i6] = (byte) (bArr4[i6] ^ this.component1[i6]);
            }
            byte[] bArr5 = this.component3;
            System.arraycopy(bArr5, 0, this.component1, 0, bArr5.length);
        }
    }

    public final int available() throws IOException {
        AFAdRevenueData();
        return this.toString - this.areAllFieldsValid;
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        AFAdRevenueData();
        int i = this.areAllFieldsValid;
        if (i >= this.toString) {
            return -1;
        }
        byte[] bArr = this.component4;
        this.areAllFieldsValid = i + 1;
        return bArr[i] & UnsignedBytes.MAX_VALUE;
    }

    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    private AFk1vSDK(InputStream inputStream, int[] iArr, byte[] bArr, int i, boolean z, int i2, byte b) throws IOException {
        super(new BufferedInputStream(inputStream, 4096));
        this.getRevenue = 1;
        this.hashCode = Integer.MAX_VALUE;
        int min = Math.min(Math.max(i, 3), 16);
        this.getCurrencyIso4217Code = min;
        this.component4 = new byte[8];
        byte[] bArr2 = new byte[8];
        this.component1 = bArr2;
        this.component3 = new byte[8];
        this.component2 = new int[2];
        this.areAllFieldsValid = 8;
        this.toString = 8;
        this.copydefault = i2;
        if (i2 == 2) {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        }
        this.getMonetizationNetwork = new AFk1sSDK(iArr, min, true, false);
        this.getMediationNetwork = 100;
        this.AFAdRevenueData = 100;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = i;
        while (i4 < i3) {
            AFAdRevenueData();
            int i5 = this.areAllFieldsValid;
            if (i5 < this.toString) {
                byte[] bArr2 = this.component4;
                this.areAllFieldsValid = i5 + 1;
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
