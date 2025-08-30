package com.appsflyer.internal;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.appsflyer.AFLogger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class AFc1gSDK extends HashMap<String, Object> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long AFAdRevenueData = 0;
    private static int areAllFieldsValid = 1;
    private static int[] getCurrencyIso4217Code;
    private static int getMonetizationNetwork;
    private final Map<String, Object> getMediationNetwork;
    private final Context getRevenue;

    @VisibleForTesting
    public static class AFa1vSDK {
        public static byte[] getMediationNetwork(@NonNull byte[] bArr) throws Exception {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (bArr[i] ^ ((i % 2) + 42));
            }
            return bArr;
        }

        @NonNull
        public static byte[] getMonetizationNetwork(@NonNull String str) throws Exception {
            return str.getBytes(Charset.defaultCharset());
        }
    }

    static {
        getMediationNetwork();
        TextUtils.indexOf("", "");
        KeyEvent.getModifierMetaStateMask();
        ViewConfiguration.getScrollDefaultDelay();
        SystemClock.currentThreadTimeMillis();
        KeyEvent.getDeadChar(0, 0);
        ViewConfiguration.getTapTimeout();
        ExpandableListView.getPackedPositionForGroup(0);
        int i = getMonetizationNetwork + 5;
        areAllFieldsValid = i % 128;
        if (i % 2 == 0) {
            throw null;
        }
    }

    @WorkerThread
    public AFc1gSDK(Map<String, Object> map, Context context) {
        this.getMediationNetwork = map;
        this.getRevenue = context;
        put(getMonetizationNetwork(), getCurrencyIso4217Code());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0077, code lost:
        throw null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r10, int r11, java.lang.Object[] r12) {
        /*
            int r0 = $10
            int r0 = r0 + 21
            int r1 = r0 % 128
            $11 = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0076
            if (r10 == 0) goto L_0x0012
            char[] r10 = r10.toCharArray()
        L_0x0012:
            char[] r10 = (char[]) r10
            com.appsflyer.internal.AFk1pSDK r0 = new com.appsflyer.internal.AFk1pSDK
            r0.<init>()
            r0.getMediationNetwork = r11
            int r11 = r10.length
            long[] r1 = new long[r11]
            r2 = 0
            r0.getRevenue = r2
        L_0x0021:
            int r3 = r0.getRevenue
            int r4 = r10.length
            if (r3 >= r4) goto L_0x0040
            char r4 = r10[r3]
            long r4 = (long) r4
            long r6 = (long) r3
            int r8 = r0.getMediationNetwork
            long r8 = (long) r8
            long r6 = r6 * r8
            long r4 = r4 ^ r6
            long r6 = AFAdRevenueData
            r8 = 199061409475100049(0x2c3354c18407d91, double:2.3496369255300187E-295)
            long r6 = r6 ^ r8
            long r4 = r4 ^ r6
            r1[r3] = r4
            int r3 = r3 + 1
            r0.getRevenue = r3
            goto L_0x0021
        L_0x0040:
            char[] r11 = new char[r11]
            r0.getRevenue = r2
        L_0x0044:
            int r3 = r0.getRevenue
            int r4 = r10.length
            if (r3 >= r4) goto L_0x006e
            int r4 = $11
            int r4 = r4 + 97
            int r5 = r4 % 128
            $10 = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x005e
            r6 = r1[r3]
            int r4 = (int) r6
            char r4 = (char) r4
            r11[r3] = r4
        L_0x005b:
            r0.getRevenue = r3
            goto L_0x0067
        L_0x005e:
            r6 = r1[r3]
            int r4 = (int) r6
            char r4 = (char) r4
            r11[r3] = r4
            int r3 = r3 + 1
            goto L_0x005b
        L_0x0067:
            int r5 = r5 + 95
            int r5 = r5 % 128
            $11 = r5
            goto L_0x0044
        L_0x006e:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r11)
            r12[r2] = r10
            return
        L_0x0076:
            r10 = 0
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1gSDK.a(java.lang.String, int, java.lang.Object[]):void");
    }

    private static void b(int[] iArr, int i, Object[] objArr) {
        int[] iArr2 = iArr;
        AFk1kSDK aFk1kSDK = new AFk1kSDK();
        char[] cArr = new char[4];
        char[] cArr2 = new char[(iArr2.length * 2)];
        int[] iArr3 = getCurrencyIso4217Code;
        if (iArr3 != null) {
            $11 = ($10 + 61) % 128;
            int length = iArr3.length;
            int[] iArr4 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr4[i2] = (int) (((long) iArr3[i2]) ^ 3670241895213185600L);
            }
            iArr3 = iArr4;
        }
        int length2 = iArr3.length;
        int[] iArr5 = new int[length2];
        int[] iArr6 = getCurrencyIso4217Code;
        if (iArr6 != null) {
            int length3 = iArr6.length;
            int[] iArr7 = new int[length3];
            int i3 = 0;
            while (i3 < length3) {
                int i4 = $11 + 57;
                $10 = i4 % 128;
                if (i4 % 2 != 0) {
                    iArr7[i3] = (int) (((long) iArr6[i3]) / 3670241895213185600L);
                    i3 >>= 1;
                } else {
                    iArr7[i3] = (int) (((long) iArr6[i3]) ^ 3670241895213185600L);
                    i3++;
                }
            }
            iArr6 = iArr7;
        }
        System.arraycopy(iArr6, 0, iArr5, 0, length2);
        aFk1kSDK.getCurrencyIso4217Code = 0;
        while (true) {
            int i5 = aFk1kSDK.getCurrencyIso4217Code;
            if (i5 < iArr2.length) {
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

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0285 A[Catch:{ Exception -> 0x016c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getCurrencyIso4217Code() {
        /*
            r16 = this;
            r1 = r16
            r2 = 1
            r3 = 22
            r4 = 8
            java.lang.String r5 = ""
            r6 = 48
            r7 = 16
            r8 = 0
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.getMediationNetwork     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r9 = "ٓ䛅蝏쟵П䒊蔱얶ˎ䍊菵쁹"
            int r10 = android.text.TextUtils.getCapsMode(r5, r8, r8)     // Catch:{ Exception -> 0x00b5 }
            int r10 = r10 + 16529
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00b5 }
            a(r9, r10, r11)     // Catch:{ Exception -> 0x00b5 }
            r9 = r11[r8]     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r9 = r9.intern()     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b5 }
            java.util.Map<java.lang.String, java.lang.Object> r9 = r1.getMediationNetwork     // Catch:{ Exception -> 0x00b5 }
            int[] r10 = new int[r4]     // Catch:{ Exception -> 0x00b5 }
            r10 = {-2010068804, 540027562, -1611408693, 1290839385, -1409557867, 1221376410, 1124754813, -1552552339} // fill-array     // Catch:{ Exception -> 0x00b5 }
            int r11 = android.graphics.drawable.Drawable.resolveOpacity(r8, r8)     // Catch:{ Exception -> 0x00b5 }
            int r11 = 15 - r11
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00b5 }
            b(r10, r11, r12)     // Catch:{ Exception -> 0x00b5 }
            r10 = r12[r8]     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r10 = r10.intern()     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r9 = r9.get(r10)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r10 = "؄䏅趱힎ᅸ嬿"
            int r11 = android.view.KeyEvent.keyCodeFromString(r5)     // Catch:{ Exception -> 0x00b5 }
            int r11 = r11 + 17881
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00b5 }
            a(r10, r11, r12)     // Catch:{ Exception -> 0x00b5 }
            r10 = r12[r8]     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r10 = r10.intern()     // Catch:{ Exception -> 0x00b5 }
            r11 = 1926287854(0x72d0d1ee, float:8.272214E30)
            r12 = -500104792(0xffffffffe23101a8, float:-8.1629826E20)
            r13 = -1719657709(0xffffffff99801b13, float:-1.3245825E-23)
            r14 = -1010008550(0xffffffffc3cc7e1a, float:-408.98517)
            int[] r11 = new int[]{r12, r13, r14, r11}     // Catch:{ Exception -> 0x00b5 }
            int r12 = android.view.View.MeasureSpec.getMode(r8)     // Catch:{ Exception -> 0x00b5 }
            int r12 = r12 + 5
            java.lang.Object[] r13 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00b5 }
            b(r11, r12, r13)     // Catch:{ Exception -> 0x00b5 }
            r11 = r13[r8]     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r11 = r11.intern()     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r10 = r10.replaceAll(r11, r5)     // Catch:{ Exception -> 0x00b5 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b5 }
            r11.<init>()     // Catch:{ Exception -> 0x00b5 }
            r11.append(r0)     // Catch:{ Exception -> 0x00b5 }
            r11.append(r9)     // Catch:{ Exception -> 0x00b5 }
            r11.append(r10)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r0 = r11.toString()     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r0 = com.appsflyer.internal.AFj1cSDK.getMonetizationNetwork(r0)     // Catch:{ Exception -> 0x00b5 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b5 }
            r9.<init>(r5)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r0 = r0.substring(r8, r7)     // Catch:{ Exception -> 0x00b5 }
            r9.append(r0)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r0 = r9.toString()     // Catch:{ Exception -> 0x00b5 }
        L_0x00b3:
            r9 = r0
            goto L_0x0125
        L_0x00b5:
            r0 = move-exception
            r9 = 20
            int[] r9 = new int[r9]
            r9 = {1412659751, -1225518006, 773104622, 1068029282, -141638432, 1353047013, 1075026864, 1832361899, -1682230360, 559510922, -697688254, 1914000959, 812386368, -220880964, 205571840, 667018555, -2049150556, -1682711385, -806296611, -80359859} // fill-array
            int r10 = android.os.Process.myTid()
            int r10 = r10 >> r3
            int r10 = r10 + 38
            java.lang.Object[] r11 = new java.lang.Object[r2]
            b(r9, r10, r11)
            r9 = r11[r8]
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r9 = r9.intern()
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r9, r0)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int[] r10 = new int[r3]
            r10 = {-1080009004, 844403482, -683446169, 2011701581, 1233271862, -317730360, 474044529, -1279916753, -2006198622, 428775418, -984596794, -978390891, 878183437, 2057824704, 1541426602, 1401202182, -1442141497, 1653693558, -345898809, 1573805036, 244475260, 1779591003} // fill-array
            int r11 = android.text.TextUtils.lastIndexOf(r5, r6)
            int r11 = r11 + 45
            java.lang.Object[] r12 = new java.lang.Object[r2]
            b(r10, r11, r12)
            r10 = r12[r8]
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r10 = r10.intern()
            r9.append(r10)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            com.appsflyer.AFLogger.afRDLog(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            r9 = 10
            int[] r9 = new int[r9]
            r9 = {1526111022, -471598143, -1921753797, -132556607, -1402220075, -512792088, 445237066, 69508151, 892799620, -65302862} // fill-array
            int r10 = android.view.View.resolveSize(r8, r8)
            int r10 = r10 + 18
            java.lang.Object[] r11 = new java.lang.Object[r2]
            b(r9, r10, r11)
            r9 = r11[r8]
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r9 = r9.intern()
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            goto L_0x00b3
        L_0x0125:
            android.content.Context r0 = r1.getRevenue     // Catch:{ Exception -> 0x016c }
            android.content.IntentFilter r10 = new android.content.IntentFilter     // Catch:{ Exception -> 0x016c }
            java.lang.String r11 = "ٓ⦩妼覟릉᧨䦯秳꧁?৐㤠椷饺줈更⤃奡襲른᥾䥰碞ꢋ?ࢷ㢧梬飇죑⣩壿蠈렂"
            float r12 = android.media.AudioTrack.getMaxVolume()     // Catch:{ Exception -> 0x016c }
            r13 = 0
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            int r12 = r12 + 12276
            java.lang.Object[] r13 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x016c }
            a(r11, r12, r13)     // Catch:{ Exception -> 0x016c }
            r11 = r13[r8]     // Catch:{ Exception -> 0x016c }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x016c }
            java.lang.String r11 = r11.intern()     // Catch:{ Exception -> 0x016c }
            r10.<init>(r11)     // Catch:{ Exception -> 0x016c }
            r11 = 0
            android.content.Intent r0 = r0.registerReceiver(r11, r10)     // Catch:{ Exception -> 0x016c }
            r10 = -2700(0xfffffffffffff574, float:NaN)
            if (r0 == 0) goto L_0x016f
            r12 = 6
            int[] r12 = new int[r12]     // Catch:{ Exception -> 0x016c }
            r12 = {-928491678, 1479704380, -891867092, 74755836, -1761205169, 1640230696} // fill-array     // Catch:{ Exception -> 0x016c }
            int r13 = android.text.TextUtils.indexOf(r5, r6)     // Catch:{ Exception -> 0x016c }
            int r13 = r13 + 12
            java.lang.Object[] r14 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x016c }
            b(r12, r13, r14)     // Catch:{ Exception -> 0x016c }
            r12 = r14[r8]     // Catch:{ Exception -> 0x016c }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x016c }
            java.lang.String r12 = r12.intern()     // Catch:{ Exception -> 0x016c }
            int r10 = r0.getIntExtra(r12, r10)     // Catch:{ Exception -> 0x016c }
            goto L_0x016f
        L_0x016c:
            r0 = move-exception
            goto L_0x02bc
        L_0x016f:
            android.content.Context r0 = r1.getRevenue     // Catch:{ Exception -> 0x016c }
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()     // Catch:{ Exception -> 0x016c }
            java.lang.String r0 = r0.nativeLibraryDir     // Catch:{ Exception -> 0x016c }
            if (r0 == 0) goto L_0x01a7
            int r12 = areAllFieldsValid
            int r12 = r12 + 49
            int r12 = r12 % 128
            getMonetizationNetwork = r12
            java.lang.String r12 = "ي氡퉒"
            int r13 = android.view.Gravity.getAbsoluteGravity(r8, r8)     // Catch:{ Exception -> 0x016c }
            int r13 = r13 + 27179
            java.lang.Object[] r14 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x016c }
            a(r12, r13, r14)     // Catch:{ Exception -> 0x016c }
            r12 = r14[r8]     // Catch:{ Exception -> 0x016c }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x016c }
            java.lang.String r12 = r12.intern()     // Catch:{ Exception -> 0x016c }
            boolean r0 = r0.contains(r12)     // Catch:{ Exception -> 0x016c }
            if (r0 == 0) goto L_0x01a7
            int r0 = getMonetizationNetwork
            int r0 = r0 + 93
            int r0 = r0 % 128
            areAllFieldsValid = r0
            r0 = 1
            goto L_0x01a8
        L_0x01a7:
            r0 = 0
        L_0x01a8:
            android.content.Context r12 = r1.getRevenue     // Catch:{ Exception -> 0x016c }
            r13 = -1177671545(0xffffffffb9ce2887, float:-3.9321577E-4)
            r14 = 39584719(0x25c03cf, float:1.616414E-37)
            r15 = 152510957(0x91721ed, float:1.8191916E-33)
            r3 = 1115452019(0x427c7273, float:63.111767)
            int[] r3 = new int[]{r14, r15, r3, r13}     // Catch:{ Exception -> 0x016c }
            int r13 = android.view.KeyEvent.keyCodeFromString(r5)     // Catch:{ Exception -> 0x016c }
            int r13 = r13 + 6
            java.lang.Object[] r14 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x016c }
            b(r3, r13, r14)     // Catch:{ Exception -> 0x016c }
            r3 = r14[r8]     // Catch:{ Exception -> 0x016c }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x016c }
            java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x016c }
            java.lang.Object r3 = r12.getSystemService(r3)     // Catch:{ Exception -> 0x016c }
            android.hardware.SensorManager r3 = (android.hardware.SensorManager) r3     // Catch:{ Exception -> 0x016c }
            r12 = -1
            java.util.List r3 = r3.getSensorList(r12)     // Catch:{ Exception -> 0x016c }
            int r3 = r3.size()     // Catch:{ Exception -> 0x016c }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016c }
            r12.<init>()     // Catch:{ Exception -> 0x016c }
            r13 = -1049246313(0xffffffffc175c597, float:-15.36074)
            r14 = -262877734(0xfffffffff054cdda, float:-2.6343873E29)
            int[] r13 = new int[]{r14, r13}     // Catch:{ Exception -> 0x016c }
            int r14 = android.text.TextUtils.lastIndexOf(r5, r6, r8)     // Catch:{ Exception -> 0x016c }
            int r14 = -r14
            java.lang.Object[] r15 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x016c }
            b(r13, r14, r15)     // Catch:{ Exception -> 0x016c }
            r13 = r15[r8]     // Catch:{ Exception -> 0x016c }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x016c }
            java.lang.String r13 = r13.intern()     // Catch:{ Exception -> 0x016c }
            r12.append(r13)     // Catch:{ Exception -> 0x016c }
            r12.append(r10)     // Catch:{ Exception -> 0x016c }
            java.lang.String r10 = "ؔ"
            int r13 = android.graphics.ImageFormat.getBitsPerPixel(r8)     // Catch:{ Exception -> 0x016c }
            r14 = 58726(0xe566, float:8.2293E-41)
            int r14 = r14 - r13
            java.lang.Object[] r13 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x016c }
            a(r10, r14, r13)     // Catch:{ Exception -> 0x016c }
            r10 = r13[r8]     // Catch:{ Exception -> 0x016c }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x016c }
            java.lang.String r10 = r10.intern()     // Catch:{ Exception -> 0x016c }
            r12.append(r10)     // Catch:{ Exception -> 0x016c }
            r12.append(r0)     // Catch:{ Exception -> 0x016c }
            java.lang.String r0 = "ؔ"
            int r5 = android.text.TextUtils.lastIndexOf(r5, r6, r8)     // Catch:{ Exception -> 0x016c }
            r6 = 63486(0xf7fe, float:8.8963E-41)
            int r6 = r6 - r5
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x016c }
            a(r0, r6, r5)     // Catch:{ Exception -> 0x016c }
            r0 = r5[r8]     // Catch:{ Exception -> 0x016c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x016c }
            java.lang.String r0 = r0.intern()     // Catch:{ Exception -> 0x016c }
            r12.append(r0)     // Catch:{ Exception -> 0x016c }
            r12.append(r3)     // Catch:{ Exception -> 0x016c }
            r0 = -1154682097(0xffffffffbb2cf30f, float:-0.0026389991)
            r3 = -400266022(0xffffffffe8246cda, float:-3.1059042E24)
            int[] r0 = new int[]{r3, r0}     // Catch:{ Exception -> 0x016c }
            int r3 = android.graphics.ImageFormat.getBitsPerPixel(r8)     // Catch:{ Exception -> 0x016c }
            int r3 = 1 - r3
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x016c }
            b(r0, r3, r5)     // Catch:{ Exception -> 0x016c }
            r0 = r5[r8]     // Catch:{ Exception -> 0x016c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x016c }
            java.lang.String r0 = r0.intern()     // Catch:{ Exception -> 0x016c }
            r12.append(r0)     // Catch:{ Exception -> 0x016c }
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.getMediationNetwork     // Catch:{ Exception -> 0x016c }
            int r0 = r0.size()     // Catch:{ Exception -> 0x016c }
            r12.append(r0)     // Catch:{ Exception -> 0x016c }
            java.lang.String r0 = r12.toString()     // Catch:{ Exception -> 0x016c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016c }
            r3.<init>()     // Catch:{ Exception -> 0x016c }
            r3.append(r9)     // Catch:{ Exception -> 0x016c }
            byte[] r0 = com.appsflyer.internal.AFc1gSDK.AFa1vSDK.getMonetizationNetwork(r0)     // Catch:{ Exception -> 0x016c }
            byte[] r0 = com.appsflyer.internal.AFc1gSDK.AFa1vSDK.getMediationNetwork(r0)     // Catch:{ Exception -> 0x016c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016c }
            r5.<init>()     // Catch:{ Exception -> 0x016c }
            int r6 = r0.length     // Catch:{ Exception -> 0x016c }
            r10 = 0
        L_0x0283:
            if (r10 >= r6) goto L_0x02b0
            byte r12 = r0[r10]     // Catch:{ Exception -> 0x016c }
            java.lang.String r12 = java.lang.Integer.toHexString(r12)     // Catch:{ Exception -> 0x016c }
            int r13 = r12.length()     // Catch:{ Exception -> 0x016c }
            if (r13 != r2) goto L_0x02ab
            int r13 = getMonetizationNetwork
            int r13 = r13 + 23
            int r14 = r13 % 128
            areAllFieldsValid = r14
            int r13 = r13 % 2
            java.lang.String r14 = "0"
            if (r13 == 0) goto L_0x02a4
            java.lang.String r12 = r14.concat(r12)     // Catch:{ Exception -> 0x016c }
            goto L_0x02ab
        L_0x02a4:
            r14.concat(r12)     // Catch:{ Exception -> 0x016c }
            throw r11     // Catch:{ all -> 0x02a8 }
        L_0x02a8:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x02ab:
            r5.append(r12)     // Catch:{ Exception -> 0x016c }
            int r10 = r10 + r2
            goto L_0x0283
        L_0x02b0:
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x016c }
            r3.append(r0)     // Catch:{ Exception -> 0x016c }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x016c }
            goto L_0x032b
        L_0x02bc:
            int[] r3 = new int[r4]
            r3 = {1412659751, -1225518006, 773104622, 1068029282, -1961924635, 1375008509, 776083721, -1573871477} // fill-array
            int r5 = android.graphics.Color.red(r8)
            int r5 = 16 - r5
            java.lang.Object[] r6 = new java.lang.Object[r2]
            b(r3, r5, r6)
            r3 = r6[r8]
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = r3.intern()
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r3, r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r5 = 22
            int[] r5 = new int[r5]
            r5 = {-1080009004, 844403482, -683446169, 2011701581, 1233271862, -317730360, 474044529, -1279916753, -2006198622, 428775418, -984596794, -978390891, 878183437, 2057824704, 1541426602, 1401202182, -1442141497, 1653693558, -345898809, 1573805036, 244475260, 1779591003} // fill-array
            int r6 = android.view.ViewConfiguration.getKeyRepeatDelay()
            int r6 = r6 >> r7
            int r6 = r6 + 44
            java.lang.Object[] r10 = new java.lang.Object[r2]
            b(r5, r6, r10)
            r5 = r10[r8]
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r5 = r5.intern()
            r3.append(r5)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.appsflyer.AFLogger.afRDLog(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r9)
            int[] r3 = new int[r4]
            r3 = {-683062148, -858043544, -2064842399, 815261139, 1867195511, 963766349, -1317296620, -449999879} // fill-array
            int r4 = android.view.ViewConfiguration.getEdgeSlop()
            int r4 = r4 >> r7
            int r4 = r4 + r7
            java.lang.Object[] r2 = new java.lang.Object[r2]
            b(r3, r4, r2)
            r2 = r2[r8]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
        L_0x032b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1gSDK.getCurrencyIso4217Code():java.lang.String");
    }

    @VisibleForTesting
    private static StringBuilder getMediationNetwork(@NonNull String... strArr) throws Exception {
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        for (int i = 0; i < 3; i++) {
            arrayList.add(Integer.valueOf(strArr[i].length()));
        }
        Collections.sort(arrayList);
        int intValue = ((Integer) arrayList.get(0)).intValue();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < intValue; i2++) {
            getMonetizationNetwork = (areAllFieldsValid + 47) % 128;
            Integer num = null;
            for (int i3 = 0; i3 < 3; i3++) {
                char charAt = strArr[i3].charAt(i2);
                if (num != null) {
                    charAt ^= num.intValue();
                }
                num = Integer.valueOf(charAt);
            }
            sb.append(Integer.toHexString(num.intValue()));
        }
        return sb;
    }

    @NonNull
    private String getMonetizationNetwork() {
        getMonetizationNetwork = (areAllFieldsValid + 3) % 128;
        try {
            String num = Integer.toString(Build.VERSION.SDK_INT);
            Map<String, Object> map = this.getMediationNetwork;
            Object[] objArr = new Object[1];
            a("ٓ䛅蝏쟵П䒊蔱얶ˎ䍊菵쁹", 16530 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr);
            String obj = map.get(((String) objArr[0]).intern()).toString();
            Map<String, Object> map2 = this.getMediationNetwork;
            Object[] objArr2 = new Object[1];
            a("ِ彗둽ങ戊", View.getDefaultSize(0, 0) + 22807, objArr2);
            String obj2 = map2.get(((String) objArr2[0]).intern()).toString();
            if (obj2 == null) {
                areAllFieldsValid = (getMonetizationNetwork + 29) % 128;
                Object[] objArr3 = new Object[1];
                a("ټ೔ጿᦋⳄ㌾㦊䳩", 2729 - View.MeasureSpec.getSize(0), objArr3);
                obj2 = ((String) objArr3[0]).intern();
            }
            StringBuilder sb = new StringBuilder(obj);
            sb.reverse();
            StringBuilder mediationNetwork = getMediationNetwork(num, obj2, sb.toString());
            int length = mediationNetwork.length();
            if (length > 4) {
                mediationNetwork.delete(4, length);
            } else {
                while (length < 4) {
                    length++;
                    mediationNetwork.append('1');
                }
            }
            Object[] objArr4 = new Object[1];
            b(new int[]{-269708407, 691550562}, Color.green(0) + 3, objArr4);
            mediationNetwork.insert(0, ((String) objArr4[0]).intern());
            return mediationNetwork.toString();
        } catch (Exception e) {
            Object[] objArr5 = new Object[1];
            b(new int[]{854565745, 306981016, 2092009709, 1211146027, -1997348285, -2069302082, -1014555636, -1115818356, 1491143540, 297822326, -891867092, 74755836, -538226225, -689317204, -1794805564, -1830683349, -1867036264, 1235626699, 1541426602, 1401202182}, 40 - Color.argb(0, 0, 0, 0), objArr5);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr5[0]).intern(), e);
            StringBuilder sb2 = new StringBuilder();
            Object[] objArr6 = new Object[1];
            b(new int[]{-1080009004, 844403482, -683446169, 2011701581, 1233271862, -317730360, 474044529, -1279916753, -2006198622, 428775418, 1632684225, -344979390, -1051640727, -1500483547, 1921909678, 1197372451, 1709650531, 1369506269, 1275252993, 1437497808, 761424572, -1240279331}, 42 - (KeyEvent.getMaxKeyCode() >> 16), objArr6);
            sb2.append(((String) objArr6[0]).intern());
            sb2.append(e);
            AFLogger.afRDLog(sb2.toString());
            Object[] objArr7 = new Object[1];
            b(new int[]{-2132896634, 840027810, -513331929, 1353535124}, (ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1)) + 8, objArr7);
            return ((String) objArr7[0]).intern();
        }
    }

    public static void getMediationNetwork() {
        AFAdRevenueData = -8351283963653293149L;
        getCurrencyIso4217Code = new int[]{442543737, -1490671600, 624544975, 963078580, -38548639, -1507093695, -433807488, 2027768116, 1333435861, -1679971940, -735591064, 871109200, 1542131051, 1882103064, 1923897460, -2041115963, 1803608463, -148454374};
    }
}
