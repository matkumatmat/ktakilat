package com.appsflyer.internal;

import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.idl.face.platform.FaceEnvironment;

public final class AFf1pSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int AFAdRevenueData = 0;
    private static int getCurrencyIso4217Code = 1;
    private static int[] getMediationNetwork;

    static {
        getMediationNetwork();
        ViewConfiguration.getLongPressTimeout();
        int i = getCurrencyIso4217Code + 3;
        AFAdRevenueData = i % 128;
        if (i % 2 != 0) {
            int i2 = 75 / 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0058, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0031, code lost:
        if (r6.length() < 63) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0044, code lost:
        if (r6.length() < 12) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0047, code lost:
        r6 = r6.substring(0, 12);
        r7 = AFAdRevenueData + 47;
        getCurrencyIso4217Code = r7 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0054, code lost:
        if ((r7 % 2) == 0) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0056, code lost:
        return r6;
     */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String AFAdRevenueData(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            int r0 = AFAdRevenueData
            int r0 = r0 + 85
            int r1 = r0 % 128
            getCurrencyIso4217Code = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 12
            java.lang.String r3 = "⁣"
            java.lang.String r4 = ""
            r5 = 0
            if (r0 != 0) goto L_0x0034
            java.lang.String[] r0 = new java.lang.String[r1]
            r0[r5] = r7
            r7 = 1
            r0[r7] = r8
            r7 = 5
            r0[r7] = r9
            r0[r7] = r10
            r7 = 4
            r0[r7] = r4
            java.lang.String r7 = android.text.TextUtils.join(r3, r0)
            java.lang.String r6 = com.appsflyer.internal.AFj1cSDK.getRevenue(r7, r6)
            int r7 = r6.length()
            r8 = 63
            if (r7 >= r8) goto L_0x0047
            goto L_0x0046
        L_0x0034:
            java.lang.String[] r7 = new java.lang.String[]{r7, r8, r9, r10, r4}
            java.lang.String r7 = android.text.TextUtils.join(r3, r7)
            java.lang.String r6 = com.appsflyer.internal.AFj1cSDK.getRevenue(r7, r6)
            int r7 = r6.length()
            if (r7 >= r2) goto L_0x0047
        L_0x0046:
            return r6
        L_0x0047:
            java.lang.String r6 = r6.substring(r5, r2)
            int r7 = AFAdRevenueData
            int r7 = r7 + 47
            int r8 = r7 % 128
            getCurrencyIso4217Code = r8
            int r7 = r7 % r1
            if (r7 == 0) goto L_0x0057
            return r6
        L_0x0057:
            r6 = 0
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1pSDK.AFAdRevenueData(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private static void a(int[] iArr, int i, Object[] objArr) {
        int[] iArr2 = iArr;
        AFk1kSDK aFk1kSDK = new AFk1kSDK();
        char[] cArr = new char[4];
        char[] cArr2 = new char[(iArr2.length * 2)];
        int[] iArr3 = getMediationNetwork;
        if (iArr3 != null) {
            int length = iArr3.length;
            int[] iArr4 = new int[length];
            $10 = ($11 + 59) % 128;
            int i2 = 0;
            while (i2 < length) {
                int i3 = $10 + 39;
                $11 = i3 % 128;
                if (i3 % 2 == 0) {
                    iArr4[i2] = (int) (((long) iArr3[i2]) * 3670241895213185600L);
                    i2 %= 1;
                } else {
                    iArr4[i2] = (int) (((long) iArr3[i2]) ^ 3670241895213185600L);
                    i2++;
                }
            }
            iArr3 = iArr4;
        }
        int length2 = iArr3.length;
        int[] iArr5 = new int[length2];
        int[] iArr6 = getMediationNetwork;
        if (iArr6 != null) {
            int length3 = iArr6.length;
            int[] iArr7 = new int[length3];
            for (int i4 = 0; i4 < length3; i4++) {
                $11 = ($10 + 79) % 128;
                iArr7[i4] = (int) (((long) iArr6[i4]) ^ 3670241895213185600L);
            }
            iArr6 = iArr7;
        }
        System.arraycopy(iArr6, 0, iArr5, 0, length2);
        aFk1kSDK.getCurrencyIso4217Code = 0;
        while (true) {
            int i5 = aFk1kSDK.getCurrencyIso4217Code;
            if (i5 < iArr2.length) {
                $11 = ($10 + 51) % 128;
                int i6 = iArr2[i5];
                char c = (char) (i6 >> 16);
                cArr[0] = c;
                char c2 = (char) i6;
                cArr[1] = c2;
                char c3 = (char) (iArr2[i5 + 1] >> 16);
                cArr[2] = c3;
                char c4 = (char) iArr2[i5 + 1];
                cArr[3] = c4;
                aFk1kSDK.AFAdRevenueData = (c << 16) + c2;
                aFk1kSDK.getMonetizationNetwork = (c3 << 16) + c4;
                AFk1kSDK.getMediationNetwork(iArr5);
                for (int i7 = 0; i7 < 16; i7++) {
                    $10 = ($11 + 9) % 128;
                    int i8 = aFk1kSDK.AFAdRevenueData ^ iArr5[i7];
                    aFk1kSDK.AFAdRevenueData = i8;
                    int AFAdRevenueData2 = AFk1kSDK.AFAdRevenueData(i8) ^ aFk1kSDK.getMonetizationNetwork;
                    int i9 = aFk1kSDK.AFAdRevenueData;
                    aFk1kSDK.AFAdRevenueData = AFAdRevenueData2;
                    aFk1kSDK.getMonetizationNetwork = i9;
                }
                int i10 = aFk1kSDK.AFAdRevenueData;
                int i11 = aFk1kSDK.getMonetizationNetwork;
                aFk1kSDK.AFAdRevenueData = i11;
                aFk1kSDK.getMonetizationNetwork = i10;
                int i12 = i10 ^ iArr5[16];
                aFk1kSDK.getMonetizationNetwork = i12;
                int i13 = i11 ^ iArr5[17];
                aFk1kSDK.AFAdRevenueData = i13;
                cArr[0] = (char) (i13 >>> 16);
                cArr[1] = (char) i13;
                cArr[2] = (char) (i12 >>> 16);
                cArr[3] = (char) i12;
                AFk1kSDK.getMediationNetwork(iArr5);
                int i14 = aFk1kSDK.getCurrencyIso4217Code;
                cArr2[i14 * 2] = cArr[0];
                cArr2[(i14 * 2) + 1] = cArr[1];
                cArr2[(i14 * 2) + 2] = cArr[2];
                cArr2[(i14 * 2) + 3] = cArr[3];
                aFk1kSDK.getCurrencyIso4217Code = i14 + 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }

    @NonNull
    private static AFi1uSDK getMediationNetwork(@NonNull AFi1wSDK aFi1wSDK, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        String str4;
        boolean z = false;
        if (str == null) {
            if (aFi1wSDK.AFAdRevenueData == AFh1aSDK.DEFAULT) {
                z = true;
            }
            return new AFi1uSDK(z, AFi1ySDK.NA);
        }
        Object[] objArr = new Object[1];
        a(new int[]{-643013363, -1773125790, -901337036, 656549561, -1731661770, 1258424067, -1532942264, 934407696, -1450123275, -1059473533, 82834636, 73705576, -1221507016, 1763733418, -1711569501, 1840946075, -1493249449, -1523654642, 594617170, -836811800, 1195240337, 1166309858, 1004762227, 96245697, 395058159, 64877192, 56299164, -104828535, -4786395, 2101942765, -285338731, 1554123850}, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 64, objArr);
        String intern = ((String) objArr[0]).intern();
        if (aFi1wSDK.AFAdRevenueData == AFh1aSDK.CUSTOM) {
            str4 = new StringBuilder(str2).reverse().toString();
        } else {
            str4 = "";
            str3 = intern;
        }
        boolean equals = AFAdRevenueData(new StringBuilder(str3).reverse().toString(), aFi1wSDK.getCurrencyIso4217Code, FaceEnvironment.OS, "v1", str4).equals(str);
        return new AFi1uSDK(equals, equals ? AFi1ySDK.SUCCESS : AFi1ySDK.FAILURE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r7 != null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r7 != null) goto L_0x0017;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFi1uSDK getRevenue(@androidx.annotation.NonNull com.appsflyer.internal.AFi1wSDK r5, @androidx.annotation.Nullable java.lang.String r6, @androidx.annotation.NonNull java.lang.String r7, @androidx.annotation.NonNull java.lang.String r8) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0033
            int r1 = AFAdRevenueData
            int r2 = r1 + 29
            int r3 = r2 % 128
            getCurrencyIso4217Code = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L_0x0015
            r2 = 9
            int r2 = r2 / r0
            if (r7 == 0) goto L_0x0033
            goto L_0x0017
        L_0x0015:
            if (r7 == 0) goto L_0x0033
        L_0x0017:
            if (r8 == 0) goto L_0x0033
            int r1 = r1 + 67
            int r1 = r1 % 128
            getCurrencyIso4217Code = r1
            com.appsflyer.internal.AFi1uSDK r5 = getMediationNetwork(r5, r6, r7, r8)
            int r6 = getCurrencyIso4217Code
            int r6 = r6 + 51
            int r7 = r6 % 128
            AFAdRevenueData = r7
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x0032
            r6 = 27
            int r6 = r6 / r0
        L_0x0032:
            return r5
        L_0x0033:
            int r5 = AFAdRevenueData
            int r5 = r5 + 21
            int r5 = r5 % 128
            getCurrencyIso4217Code = r5
            com.appsflyer.internal.AFi1uSDK r5 = new com.appsflyer.internal.AFi1uSDK
            com.appsflyer.internal.AFi1ySDK r6 = com.appsflyer.internal.AFi1ySDK.INTERNAL_ERROR
            r5.<init>(r0, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1pSDK.getRevenue(com.appsflyer.internal.AFi1wSDK, java.lang.String, java.lang.String, java.lang.String):com.appsflyer.internal.AFi1uSDK");
    }

    public static void getMediationNetwork() {
        getMediationNetwork = new int[]{-1667361725, -1699441632, 432593808, 251732126, -1427520749, -699397331, 585070146, 1483439762, 1609066215, 453290560, -192666392, -1278453714, -213940739, 2102241028, -1309214613, 1294459639, 1092066826, -1216170440};
    }
}
