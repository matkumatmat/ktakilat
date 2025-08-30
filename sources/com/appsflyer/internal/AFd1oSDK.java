package com.appsflyer.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.ConnectionResult;
import com.google.common.base.Ascii;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

public final class AFd1oSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    public static String AFAdRevenueData = "https://%sgcdsdk.%s/install_data/v5.0/";
    private static int areAllFieldsValid = 0;
    private static int component1 = 0;
    private static int component3 = 0;
    private static int copy = 0;
    private static byte[] copydefault = null;
    @VisibleForTesting
    private static String getRevenue = "https://%sonelink.%s/shortlink-sdk/v2";
    private static int hashCode = 1;
    private static short[] toString;
    private final AFj1fSDK component2;
    private final AFe1zSDK component4;
    private final AFc1pSDK getCurrencyIso4217Code;
    private final AppsFlyerProperties getMediationNetwork;
    private final AFd1lSDK getMonetizationNetwork;

    static {
        getMonetizationNetwork();
        int i = hashCode + 37;
        copy = i % 128;
        if (i % 2 != 0) {
            throw null;
        }
    }

    public AFd1oSDK(AFd1lSDK aFd1lSDK, AFc1pSDK aFc1pSDK, AppsFlyerProperties appsFlyerProperties, AFe1zSDK aFe1zSDK, AFj1fSDK aFj1fSDK) {
        this.getMonetizationNetwork = aFd1lSDK;
        this.getCurrencyIso4217Code = aFc1pSDK;
        this.getMediationNetwork = appsFlyerProperties;
        this.component4 = aFe1zSDK;
        this.component2 = aFj1fSDK;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0095, code lost:
        if (r3 != false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a2, code lost:
        if (r3 != false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a6, code lost:
        r3 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(byte r13, short r14, int r15, int r16, int r17, java.lang.Object[] r18) {
        /*
            com.appsflyer.internal.AFk1lSDK r0 = new com.appsflyer.internal.AFk1lSDK
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = areAllFieldsValid
            long r2 = (long) r2
            r4 = -612162971269904352(0xf781290560cf4820, double:-4.426591823439666E267)
            long r2 = r2 ^ r4
            int r3 = (int) r2
            int r2 = r15 + r3
            r3 = -1
            r6 = 0
            r7 = 1
            if (r2 != r3) goto L_0x001d
            r3 = 1
            goto L_0x001e
        L_0x001d:
            r3 = 0
        L_0x001e:
            if (r3 == r7) goto L_0x0021
            goto L_0x007d
        L_0x0021:
            int r2 = $11
            int r2 = r2 + 17
            int r2 = r2 % 128
            $10 = r2
            byte[] r8 = copydefault
            if (r8 == 0) goto L_0x004e
            int r2 = r2 + 95
            int r9 = r2 % 128
            $11 = r9
            int r2 = r2 % 2
            if (r2 != 0) goto L_0x003c
            int r2 = r8.length
            byte[] r9 = new byte[r2]
            r10 = 1
            goto L_0x0040
        L_0x003c:
            int r2 = r8.length
            byte[] r9 = new byte[r2]
            r10 = 0
        L_0x0040:
            if (r10 >= r2) goto L_0x004d
            byte r11 = r8[r10]
            long r11 = (long) r11
            long r11 = r11 ^ r4
            int r12 = (int) r11
            byte r11 = (byte) r12
            r9[r10] = r11
            int r10 = r10 + 1
            goto L_0x0040
        L_0x004d:
            r8 = r9
        L_0x004e:
            if (r8 == 0) goto L_0x0067
            byte[] r2 = copydefault
            int r8 = component1
            long r8 = (long) r8
            long r8 = r8 ^ r4
            int r9 = (int) r8
            int r8 = r16 + r9
            byte r2 = r2[r8]
            long r8 = (long) r2
            long r8 = r8 ^ r4
            int r2 = (int) r8
            byte r2 = (byte) r2
            int r8 = areAllFieldsValid
            long r8 = (long) r8
            long r8 = r8 ^ r4
            int r9 = (int) r8
            int r2 = r2 + r9
            byte r2 = (byte) r2
            goto L_0x007d
        L_0x0067:
            short[] r2 = toString
            int r8 = component1
            long r8 = (long) r8
            long r8 = r8 ^ r4
            int r9 = (int) r8
            int r8 = r16 + r9
            short r2 = r2[r8]
            long r8 = (long) r2
            long r8 = r8 ^ r4
            int r2 = (int) r8
            short r2 = (short) r2
            int r8 = areAllFieldsValid
            long r8 = (long) r8
            long r8 = r8 ^ r4
            int r9 = (int) r8
            int r2 = r2 + r9
            short r2 = (short) r2
        L_0x007d:
            if (r2 <= 0) goto L_0x013b
            int r8 = $11
            int r8 = r8 + 55
            int r9 = r8 % 128
            $10 = r9
            int r8 = r8 % 2
            if (r8 == 0) goto L_0x0098
            int r8 = r16 - r2
            int r8 = r8 >> 5
            int r9 = component1
            long r9 = (long) r9
            long r9 = r9 & r4
            int r10 = (int) r9
            int r8 = r8 << r10
            if (r3 == 0) goto L_0x00a6
            goto L_0x00a4
        L_0x0098:
            int r8 = r16 + r2
            int r8 = r8 + -2
            int r9 = component1
            long r9 = (long) r9
            long r9 = r9 ^ r4
            int r10 = (int) r9
            int r8 = r8 + r10
            if (r3 == 0) goto L_0x00a6
        L_0x00a4:
            r3 = 1
            goto L_0x00a7
        L_0x00a6:
            r3 = 0
        L_0x00a7:
            int r8 = r8 + r3
            r0.getCurrencyIso4217Code = r8
            int r3 = component3
            long r8 = (long) r3
            long r8 = r8 ^ r4
            int r3 = (int) r8
            int r3 = r17 + r3
            char r3 = (char) r3
            r0.getMediationNetwork = r3
            r1.append(r3)
            char r3 = r0.getMediationNetwork
            r0.AFAdRevenueData = r3
            byte[] r3 = copydefault
            if (r3 == 0) goto L_0x00d1
            int r8 = r3.length
            byte[] r9 = new byte[r8]
            r10 = 0
        L_0x00c3:
            if (r10 >= r8) goto L_0x00d0
            byte r11 = r3[r10]
            long r11 = (long) r11
            long r11 = r11 ^ r4
            int r12 = (int) r11
            byte r11 = (byte) r12
            r9[r10] = r11
            int r10 = r10 + 1
            goto L_0x00c3
        L_0x00d0:
            r3 = r9
        L_0x00d1:
            if (r3 == 0) goto L_0x00d5
            r3 = 1
            goto L_0x00d6
        L_0x00d5:
            r3 = 0
        L_0x00d6:
            r0.getRevenue = r7
        L_0x00d8:
            int r8 = r0.getRevenue
            if (r8 >= r2) goto L_0x013b
            if (r3 == 0) goto L_0x0115
            int r8 = $11
            int r8 = r8 + 125
            int r9 = r8 % 128
            $10 = r9
            int r8 = r8 % 2
            if (r8 == 0) goto L_0x0100
            byte[] r8 = copydefault
            int r9 = r0.getCurrencyIso4217Code
            r0.getCurrencyIso4217Code = r9
            byte r8 = r8[r9]
            long r8 = (long) r8
            long r8 = r8 - r4
            int r9 = (int) r8
            byte r8 = (byte) r9
            char r9 = r0.AFAdRevenueData
            int r8 = r8 % r14
            byte r8 = (byte) r8
            r8 = r8 ^ r13
            int r9 = r9 % r8
        L_0x00fc:
            char r8 = (char) r9
            r0.getMediationNetwork = r8
            goto L_0x012c
        L_0x0100:
            byte[] r8 = copydefault
            int r9 = r0.getCurrencyIso4217Code
            int r10 = r9 + -1
            r0.getCurrencyIso4217Code = r10
            byte r8 = r8[r9]
            long r8 = (long) r8
            long r8 = r8 ^ r4
            int r9 = (int) r8
            byte r8 = (byte) r9
            char r9 = r0.AFAdRevenueData
            int r8 = r8 + r14
            byte r8 = (byte) r8
            r8 = r8 ^ r13
            int r9 = r9 + r8
            goto L_0x00fc
        L_0x0115:
            short[] r8 = toString
            int r9 = r0.getCurrencyIso4217Code
            int r10 = r9 + -1
            r0.getCurrencyIso4217Code = r10
            short r8 = r8[r9]
            long r8 = (long) r8
            long r8 = r8 ^ r4
            int r9 = (int) r8
            short r8 = (short) r9
            char r9 = r0.AFAdRevenueData
            int r8 = r8 + r14
            short r8 = (short) r8
            r8 = r8 ^ r13
            int r9 = r9 + r8
            char r8 = (char) r9
            r0.getMediationNetwork = r8
        L_0x012c:
            char r8 = r0.getMediationNetwork
            r1.append(r8)
            char r8 = r0.getMediationNetwork
            r0.AFAdRevenueData = r8
            int r8 = r0.getRevenue
            int r8 = r8 + r7
            r0.getRevenue = r8
            goto L_0x00d8
        L_0x013b:
            java.lang.String r0 = r1.toString()
            r18[r6] = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1oSDK.a(byte, short, int, int, int, java.lang.Object[]):void");
    }

    public static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr, int i, int i2, int i3) {
        String str;
        String str2;
        String str3;
        int i4 = ~i;
        int i5 = ((~(i4 | i2 | i3)) * 521) + (i2 * 522) + (i * -520);
        int i6 = ~(i | (~i2));
        int i7 = ((i6 | (~(i2 | (~i3) | i4))) * 521) + (i6 * -1042) + i5;
        if (i7 == 1) {
            AFh1mSDK aFh1mSDK = objArr[1];
            AFd1nSDK revenue = objArr[0].getRevenue(new AFd1cSDK(aFh1mSDK.component1, aFh1mSDK.AFAdRevenueData(), FirebasePerformance.HttpMethod.POST, Collections.emptyMap(), true), new AFd1eSDK());
            hashCode = (copy + 67) % 128;
            return revenue;
        } else if (i7 != 2) {
            AFd1oSDK aFd1oSDK = objArr[0];
            HashMap hashMap = new HashMap();
            hashMap.put("build_number", "6.17.0");
            hashMap.put("counter", Integer.valueOf(aFd1oSDK.getCurrencyIso4217Code.getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0)));
            hashMap.put("model", Build.MODEL);
            Object[] objArr2 = new Object[1];
            a((byte) (83 - MotionEvent.axisFromString("")), (short) (Gravity.getAbsoluteGravity(0, 0) + 43), -88 - ((Process.getThreadPriority(0) + 20) >> 6), MotionEvent.axisFromString("") + 2017627781, KeyEvent.keyCodeFromString("") + 1432018452, objArr2);
            hashMap.put(((String) objArr2[0]).intern(), Build.BRAND);
            hashMap.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Integer.toString(Build.VERSION.SDK_INT));
            Context context = aFd1oSDK.getCurrencyIso4217Code.getRevenue.getMonetizationNetwork;
            hashMap.put("app_version_name", AFj1iSDK.getMediationNetwork(context, context.getPackageName()));
            hashMap.put("app_id", aFd1oSDK.getCurrencyIso4217Code.getRevenue.getMonetizationNetwork.getPackageName());
            hashMap.put("platformextension", new AFa1vSDK().getMonetizationNetwork());
            hashCode = (copy + 93) % 128;
            return hashMap;
        } else {
            AFd1oSDK aFd1oSDK2 = objArr[0];
            boolean booleanValue = objArr[1].booleanValue();
            boolean booleanValue2 = objArr[2].booleanValue();
            String str4 = objArr[3];
            objArr[4].intValue();
            AFe1zSDK aFe1zSDK = aFd1oSDK2.component4;
            Intrinsics.checkNotNullParameter(str4, "");
            if (booleanValue) {
                str = AFe1zSDK.getRevenue;
            } else {
                str = AFe1zSDK.getMediationNetwork;
                copy = (hashCode + 47) % 128;
            }
            if (booleanValue2) {
                hashCode = (copy + 115) % 128;
                str2 = "stg";
            } else {
                str2 = "";
            }
            if (AFe1zSDK.AFAdRevenueData()) {
                str3 = (String) aFe1zSDK.AFAdRevenueData.getValue();
            } else {
                copy = (hashCode + 33) % 128;
                str3 = "";
            }
            String format = String.format(str, Arrays.copyOf(new Object[]{str3, str2, aFe1zSDK.getMediationNetwork(), str4}, 4));
            Intrinsics.checkNotNullExpressionValue(format, "");
            AFd1cSDK aFd1cSDK = new AFd1cSDK(format, FirebasePerformance.HttpMethod.GET);
            aFd1cSDK.component4 = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
            return aFd1oSDK2.getRevenue(aFd1cSDK, new AFd1bSDK());
        }
    }

    @VisibleForTesting
    private Map<String, Object> getMediationNetwork() {
        return (Map) getCurrencyIso4217Code(new Object[]{this}, -1717475171, 1717475171, System.identityHashCode(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0077, code lost:
        if (r15.length() == 0) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007e, code lost:
        if (r15.length() == 0) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a1, code lost:
        if (new kotlin.text.Regex("3.?(\\d+)?.?(\\d+)").matches(r15) == false) goto L_0x00a4;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFd1nSDK<java.lang.String> AFAdRevenueData(java.util.Map<java.lang.String, java.lang.Object> r13, java.lang.String r14, @androidx.annotation.Nullable java.lang.String r15) {
        /*
            r12 = this;
            r0 = 0
            r1 = 1
            r2 = 2
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x00e2 }
            r4[r1] = r14     // Catch:{ all -> 0x00e2 }
            r4[r0] = r13     // Catch:{ all -> 0x00e2 }
            java.util.Map r13 = com.appsflyer.internal.AFa1kSDK.i     // Catch:{ all -> 0x00e2 }
            r14 = 317123644(0x12e6ec3c, float:1.4573277E-27)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x00e2 }
            java.lang.Object r5 = r13.get(r5)     // Catch:{ all -> 0x00e2 }
            if (r5 == 0) goto L_0x001a
            goto L_0x0052
        L_0x001a:
            int r5 = android.view.ViewConfiguration.getLongPressTimeout()     // Catch:{ all -> 0x00e2 }
            int r5 = r5 >> 16
            int r5 = r5 + 196
            double r6 = android.telephony.cdma.CdmaCellLocation.convertQuartSecToDecDegrees(r0)     // Catch:{ all -> 0x00e2 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            char r6 = (char) r10     // Catch:{ all -> 0x00e2 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00e2 }
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            int r7 = 38 - r11
            java.lang.Object r5 = com.appsflyer.internal.AFa1kSDK.getCurrencyIso4217Code(r5, r6, r7)     // Catch:{ all -> 0x00e2 }
            java.lang.Class r5 = (java.lang.Class) r5     // Catch:{ all -> 0x00e2 }
            java.lang.String r6 = "getMediationNetwork"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ all -> 0x00e2 }
            java.lang.Class<java.util.Map> r8 = java.util.Map.class
            r7[r0] = r8     // Catch:{ all -> 0x00e2 }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r1] = r8     // Catch:{ all -> 0x00e2 }
            java.lang.reflect.Method r5 = r5.getMethod(r6, r7)     // Catch:{ all -> 0x00e2 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x00e2 }
            r13.put(r14, r5)     // Catch:{ all -> 0x00e2 }
        L_0x0052:
            java.lang.reflect.Method r5 = (java.lang.reflect.Method) r5     // Catch:{ all -> 0x00e2 }
            java.lang.Object r13 = r5.invoke(r3, r4)     // Catch:{ all -> 0x00e2 }
            r6 = r13
            byte[] r6 = (byte[]) r6     // Catch:{ all -> 0x00e2 }
            int r13 = hashCode
            int r14 = r13 + 95
            int r14 = r14 % 128
            copy = r14
            com.appsflyer.internal.AFj1fSDK r14 = r12.component2
            if (r15 == 0) goto L_0x00a3
            int r13 = r13 + 119
            int r4 = r13 % 128
            copy = r4
            int r13 = r13 % r2
            if (r13 == 0) goto L_0x007a
            int r13 = r15.length()
            r4 = 83
            int r4 = r4 / r0
            if (r13 != 0) goto L_0x0081
            goto L_0x00a3
        L_0x007a:
            int r13 = r15.length()
            if (r13 != 0) goto L_0x0081
            goto L_0x00a3
        L_0x0081:
            int r13 = copy
            int r13 = r13 + 75
            int r13 = r13 % 128
            hashCode = r13
            kotlin.text.Regex r13 = new kotlin.text.Regex
            java.lang.String r4 = "4.?(\\d+)?.?(\\d+)"
            r13.<init>((java.lang.String) r4)
            boolean r13 = r13.matches(r15)
            if (r13 != 0) goto L_0x00a3
            kotlin.text.Regex r13 = new kotlin.text.Regex
            java.lang.String r4 = "3.?(\\d+)?.?(\\d+)"
            r13.<init>((java.lang.String) r4)
            boolean r13 = r13.matches(r15)
            if (r13 == 0) goto L_0x00a4
        L_0x00a3:
            r0 = 1
        L_0x00a4:
            if (r0 != 0) goto L_0x00af
            com.appsflyer.internal.AFk1xSDK r13 = r14.getMonetizationNetwork
            java.lang.String r15 = "https://%sars.%s/api/v2/android/validate_subscription_v2?app_id="
            java.lang.String r13 = r13.AFAdRevenueData(r15)
            goto L_0x00b7
        L_0x00af:
            com.appsflyer.internal.AFk1xSDK r13 = r14.getMonetizationNetwork
            java.lang.String r15 = "https://%sars.%s/api/v2/android/validate_subscription?app_id="
            java.lang.String r13 = r13.AFAdRevenueData(r15)
        L_0x00b7:
            java.lang.String r13 = r14.getCurrencyIso4217Code(r13)
            java.lang.String r5 = r14.getRevenue(r13, false)
            com.appsflyer.internal.AFd1cSDK r13 = new com.appsflyer.internal.AFd1cSDK
            java.util.Map r8 = java.util.Collections.emptyMap()
            r9 = 1
            java.lang.String r7 = "POST"
            r4 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            com.appsflyer.internal.AFd1eSDK r14 = new com.appsflyer.internal.AFd1eSDK
            r14.<init>()
            com.appsflyer.internal.AFd1nSDK r13 = r12.getRevenue((com.appsflyer.internal.AFd1cSDK) r13, r14)
            int r14 = hashCode
            int r14 = r14 + 33
            int r15 = r14 % 128
            copy = r15
            int r14 = r14 % r2
            if (r14 != 0) goto L_0x00e1
            return r13
        L_0x00e1:
            throw r3
        L_0x00e2:
            r13 = move-exception
            java.lang.Throwable r14 = r13.getCause()     // Catch:{ all -> 0x00ea }
            if (r14 == 0) goto L_0x00ed
            throw r14     // Catch:{ all -> 0x00ea }
        L_0x00ea:
            r13 = move-exception
            r7 = r13
            goto L_0x00ee
        L_0x00ed:
            throw r13     // Catch:{ all -> 0x00ea }
        L_0x00ee:
            com.appsflyer.AFLogger r4 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r5 = com.appsflyer.internal.AFg1cSDK.PURCHASE_VALIDATION
            r8 = 0
            r9 = 0
            java.lang.String r6 = "AFFinalizer: reflection init failed."
            r4.e(r5, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1oSDK.AFAdRevenueData(java.util.Map, java.lang.String, java.lang.String):com.appsflyer.internal.AFd1nSDK");
    }

    @Nullable
    public final AFd1nSDK<String> getMonetizationNetwork(Map<String, Object> map, String str) {
        hashCode = (copy + 117) % 128;
        try {
            Object[] objArr = new Object[2];
            objArr[1] = str;
            objArr[0] = map;
            Map map2 = AFa1kSDK.i;
            Object obj = map2.get(317123644);
            if (obj == null) {
                obj = ((Class) AFa1kSDK.getCurrencyIso4217Code(Gravity.getAbsoluteGravity(0, 0) + 196, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1))), 37 - TextUtils.getOffsetAfter("", 0))).getMethod("getMediationNetwork", new Class[]{Map.class, String.class});
                map2.put(317123644, obj);
            }
            byte[] bArr = (byte[]) ((Method) obj).invoke((Object) null, objArr);
            hashCode = (copy + 69) % 128;
            AFj1fSDK aFj1fSDK = this.component2;
            return getRevenue(new AFd1cSDK(aFj1fSDK.getCurrencyIso4217Code(aFj1fSDK.getMonetizationNetwork.AFAdRevenueData("https://%svalidate-and-log.%s/api/v1.0/android/validateAndLog?app_id=")), bArr, FirebasePerformance.HttpMethod.POST, Collections.emptyMap(), true), new AFd1eSDK());
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.PURCHASE_VALIDATION, "AFFinalizer: reflection init failed.", th, false, false);
            return null;
        }
    }

    public final AFd1nSDK<Map<String, Object>> getRevenue(String str, String str2) {
        AFd1nSDK<Map<String, Object>> revenue = getRevenue((AFd1cSDK) AFd1fSDK.getMonetizationNetwork(this.getCurrencyIso4217Code.getRevenue.getMonetizationNetwork.getPackageName(), AFb1iSDK.getRevenue(this.getCurrencyIso4217Code.getMonetizationNetwork), str, str2), new AFd1iSDK());
        copy = (hashCode + 79) % 128;
        return revenue;
    }

    public final AFd1nSDK<String> getMediationNetwork(AFh1mSDK aFh1mSDK) {
        return (AFd1nSDK) getCurrencyIso4217Code(new Object[]{this, aFh1mSDK}, -44698683, 44698684, System.identityHashCode(this));
    }

    public final AFd1nSDK<Map<String, String>> getRevenue(@NonNull String str, @NonNull String str2, @NonNull UUID uuid, @NonNull String str3) {
        String str4 = str;
        String str5 = str2;
        String obj = uuid.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(getRevenue, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ((AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).getHostName()}));
        sb.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb.append(str4);
        sb.append("?id=");
        sb.append(str5);
        String obj2 = sb.toString();
        Map map = (Map) getCurrencyIso4217Code(new Object[]{this}, -1717475171, 1717475171, System.identityHashCode(this));
        String valueOf = String.valueOf(map.get("build_number"));
        HashMap hashMap = new HashMap();
        hashMap.put("Af-UUID", uuid.toString());
        hashMap.put("Af-Meta-Sdk-Ver", valueOf);
        hashMap.put("Af-Meta-Counter", String.valueOf(map.get("counter")));
        hashMap.put("Af-Meta-Model", String.valueOf(map.get("model")));
        hashMap.put("Af-Meta-Platform", String.valueOf(map.get("platformextension")));
        hashMap.put("Af-Meta-System-Version", String.valueOf(map.get(ServerProtocol.DIALOG_PARAM_SDK_VERSION)));
        Object[] objArr = new Object[1];
        a((byte) (88 - Color.green(0)), (short) (22 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), -88 - Gravity.getAbsoluteGravity(0, 0), Drawable.resolveOpacity(0, 0) + 2017627768, 1432018418 - ImageFormat.getBitsPerPixel(0), objArr);
        hashMap.put(((String) objArr[0]).intern(), getMonetizationNetwork(str3, obj, FirebasePerformance.HttpMethod.GET, obj, str4, str5, valueOf));
        AFd1nSDK<Map<String, String>> revenue = getRevenue(new AFd1cSDK(obj2, (byte[]) null, FirebasePerformance.HttpMethod.GET, hashMap, false), new AFd1dSDK());
        hashCode = (copy + 5) % 128;
        return revenue;
    }

    public final AFd1nSDK<String> getMonetizationNetwork(@NonNull String str, @NonNull Map<String, String> map, @Nullable String str2, @NonNull UUID uuid, @NonNull String str3) {
        String str4 = str2;
        String obj = uuid.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("ttl", "-1");
        hashMap.put("uuid", obj);
        hashMap.put("data", map);
        hashMap.put("meta", (Map) getCurrencyIso4217Code(new Object[]{this}, -1717475171, 1717475171, System.identityHashCode(this)));
        if (str4 != null) {
            int i = hashCode + 81;
            copy = i % 128;
            if (i % 2 != 0) {
                hashMap.put("brand_domain", str4);
                int i2 = 19 / 0;
            } else {
                hashMap.put("brand_domain", str4);
            }
            hashCode = (copy + 1) % 128;
        }
        String jSONObject = AFg1lSDK.getCurrencyIso4217Code(hashMap).toString();
        HashMap hashMap2 = new HashMap();
        Object[] objArr = new Object[1];
        a((byte) (88 - TextUtils.indexOf("", "", 0)), (short) (((Process.getThreadPriority(0) + 20) >> 6) + 22), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) - 88, Color.rgb(0, 0, 0) + 2034404984, 1432018419 - (ViewConfiguration.getScrollBarSize() >> 8), objArr);
        hashMap2.put(((String) objArr[0]).intern(), getMonetizationNetwork(str3, obj, FirebasePerformance.HttpMethod.POST, jSONObject));
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(getRevenue, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFa1tSDK.getCurrencyIso4217Code().getHostName()}));
        sb.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb.append(str);
        AFd1nSDK<String> revenue = getRevenue(new AFd1cSDK(sb.toString(), jSONObject.getBytes(Charset.defaultCharset()), FirebasePerformance.HttpMethod.POST, hashMap2, false), new AFd1eSDK(), true);
        int i3 = hashCode + 67;
        copy = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 99 / 0;
        }
        return revenue;
    }

    @NonNull
    public final AFd1nSDK<AFa1mSDK> AFAdRevenueData(AFa1pSDK aFa1pSDK) {
        AFd1nSDK<AFa1mSDK> revenue = getRevenue(new AFd1cSDK(aFa1pSDK.component1, AFg1lSDK.getCurrencyIso4217Code(aFa1pSDK.AFAdRevenueData).toString().getBytes(Charset.defaultCharset()), FirebasePerformance.HttpMethod.POST, Collections.emptyMap(), aFa1pSDK.getMonetizationNetwork()), new AFa1rSDK());
        int i = hashCode + 91;
        copy = i % 128;
        if (i % 2 != 0) {
            int i2 = 24 / 0;
        }
        return revenue;
    }

    public final AFd1nSDK<String> getRevenue(@NonNull String str) {
        AFd1cSDK aFd1cSDK = new AFd1cSDK(str, (byte[]) null, FirebasePerformance.HttpMethod.GET, Collections.emptyMap(), false);
        aFd1cSDK.component4 = 10000;
        aFd1cSDK.getCurrencyIso4217Code = false;
        AFd1nSDK<String> revenue = getRevenue(aFd1cSDK, new AFd1eSDK());
        int i = hashCode + 19;
        copy = i % 128;
        if (i % 2 == 0) {
            return revenue;
        }
        throw null;
    }

    @Nullable
    public final AFd1mSDK getRevenue(Map<String, Object> map, String str) {
        copy = (hashCode + 65) % 128;
        try {
            Object[] objArr = new Object[2];
            objArr[1] = str;
            objArr[0] = map;
            Map map2 = AFa1kSDK.i;
            Object obj = map2.get(317123644);
            if (obj == null) {
                obj = ((Class) AFa1kSDK.getCurrencyIso4217Code(197 - (SystemClock.uptimeMillis() > 0 ? 1 : (SystemClock.uptimeMillis() == 0 ? 0 : -1)), (char) (-1 - TextUtils.indexOf("", '0', 0)), TextUtils.lastIndexOf("", '0', 0, 0) + 38)).getMethod("getMediationNetwork", new Class[]{Map.class, String.class});
                map2.put(317123644, obj);
            }
            byte[] bArr = (byte[]) ((Method) obj).invoke((Object) null, objArr);
            if (bArr == null) {
                AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "AFFinalizer: failed to create bytes.", new IllegalArgumentException("Failed to create bytes from proxyData, bytes are null"), false, false);
                return null;
            }
            copy = (hashCode + 19) % 128;
            return new AFd1mSDK(this.getCurrencyIso4217Code, bArr);
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "AFFinalizer: reflection init failed.", th, false, false);
            return null;
        }
    }

    private static String getMonetizationNetwork(String str, String str2, String... strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add(1, "v2");
        String join = TextUtils.join("⁣", (String[]) arrayList.toArray(new String[0]));
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append("v2");
        String revenue = AFj1cSDK.getRevenue(join, sb.toString());
        int i = hashCode + 41;
        copy = i % 128;
        if (i % 2 == 0) {
            return revenue;
        }
        throw null;
    }

    private <T> AFd1nSDK<T> getRevenue(AFd1cSDK aFd1cSDK, AFe1ySDK<T> aFe1ySDK) {
        AFd1nSDK<T> aFd1nSDK;
        int i = hashCode + 69;
        copy = i % 128;
        if (i % 2 != 0) {
            aFd1nSDK = getRevenue(aFd1cSDK, aFe1ySDK, getRevenue());
            int i2 = 32 / 0;
        } else {
            aFd1nSDK = getRevenue(aFd1cSDK, aFe1ySDK, getRevenue());
        }
        int i3 = hashCode + 71;
        copy = i3 % 128;
        if (i3 % 2 == 0) {
            return aFd1nSDK;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00cb  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFd1nSDK<java.lang.String> getCurrencyIso4217Code(java.util.Map<java.lang.String, java.lang.Object> r13, java.lang.String r14, @androidx.annotation.Nullable java.lang.String r15) {
        /*
            r12 = this;
            r0 = 0
            r1 = 1
            r2 = 2
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x00cf }
            r4[r1] = r14     // Catch:{ all -> 0x00cf }
            r4[r0] = r13     // Catch:{ all -> 0x00cf }
            java.util.Map r13 = com.appsflyer.internal.AFa1kSDK.i     // Catch:{ all -> 0x00cf }
            r14 = 317123644(0x12e6ec3c, float:1.4573277E-27)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x00cf }
            java.lang.Object r5 = r13.get(r5)     // Catch:{ all -> 0x00cf }
            if (r5 == 0) goto L_0x001a
            goto L_0x004c
        L_0x001a:
            int r5 = android.view.View.combineMeasuredStates(r0, r0)     // Catch:{ all -> 0x00cf }
            int r5 = 196 - r5
            int r6 = android.view.View.resolveSize(r0, r0)     // Catch:{ all -> 0x00cf }
            char r6 = (char) r6     // Catch:{ all -> 0x00cf }
            long r7 = android.widget.ExpandableListView.getPackedPositionForChild(r0, r0)     // Catch:{ all -> 0x00cf }
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            int r7 = 36 - r11
            java.lang.Object r5 = com.appsflyer.internal.AFa1kSDK.getCurrencyIso4217Code(r5, r6, r7)     // Catch:{ all -> 0x00cf }
            java.lang.Class r5 = (java.lang.Class) r5     // Catch:{ all -> 0x00cf }
            java.lang.String r6 = "getMediationNetwork"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ all -> 0x00cf }
            java.lang.Class<java.util.Map> r8 = java.util.Map.class
            r7[r0] = r8     // Catch:{ all -> 0x00cf }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r1] = r8     // Catch:{ all -> 0x00cf }
            java.lang.reflect.Method r5 = r5.getMethod(r6, r7)     // Catch:{ all -> 0x00cf }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x00cf }
            r13.put(r14, r5)     // Catch:{ all -> 0x00cf }
        L_0x004c:
            java.lang.reflect.Method r5 = (java.lang.reflect.Method) r5     // Catch:{ all -> 0x00cf }
            java.lang.Object r13 = r5.invoke(r3, r4)     // Catch:{ all -> 0x00cf }
            r6 = r13
            byte[] r6 = (byte[]) r6     // Catch:{ all -> 0x00cf }
            int r13 = hashCode
            int r14 = r13 + 103
            int r14 = r14 % 128
            copy = r14
            com.appsflyer.internal.AFj1fSDK r14 = r12.component2
            if (r15 == 0) goto L_0x0092
            int r13 = r13 + 3
            int r13 = r13 % 128
            copy = r13
            int r13 = r15.length()
            if (r13 != 0) goto L_0x006e
            goto L_0x0092
        L_0x006e:
            kotlin.text.Regex r13 = new kotlin.text.Regex
            java.lang.String r1 = "4.?(\\d+)?.?(\\d+)"
            r13.<init>((java.lang.String) r1)
            boolean r13 = r13.matches(r15)
            if (r13 != 0) goto L_0x0092
            kotlin.text.Regex r13 = new kotlin.text.Regex
            java.lang.String r1 = "3.?(\\d+)?.?(\\d+)"
            r13.<init>((java.lang.String) r1)
            boolean r13 = r13.matches(r15)
            if (r13 == 0) goto L_0x0089
            goto L_0x0092
        L_0x0089:
            com.appsflyer.internal.AFk1xSDK r13 = r14.getMonetizationNetwork
            java.lang.String r15 = "https://%sviap.%s/api/v1/android/validate_purchase_v2?app_id="
            java.lang.String r13 = r13.AFAdRevenueData(r15)
            goto L_0x00a2
        L_0x0092:
            int r13 = hashCode
            int r13 = r13 + 75
            int r13 = r13 % 128
            copy = r13
            com.appsflyer.internal.AFk1xSDK r13 = r14.getMonetizationNetwork
            java.lang.String r15 = "https://%sviap.%s/api/v1/android/validate_purchase?app_id="
            java.lang.String r13 = r13.AFAdRevenueData(r15)
        L_0x00a2:
            java.lang.String r13 = r14.getCurrencyIso4217Code(r13)
            java.lang.String r5 = r14.getRevenue(r13, false)
            com.appsflyer.internal.AFd1cSDK r13 = new com.appsflyer.internal.AFd1cSDK
            java.util.Map r8 = java.util.Collections.emptyMap()
            r9 = 1
            java.lang.String r7 = "POST"
            r4 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            com.appsflyer.internal.AFd1eSDK r14 = new com.appsflyer.internal.AFd1eSDK
            r14.<init>()
            com.appsflyer.internal.AFd1nSDK r13 = r12.getRevenue((com.appsflyer.internal.AFd1cSDK) r13, r14)
            int r14 = hashCode
            int r14 = r14 + 67
            int r15 = r14 % 128
            copy = r15
            int r14 = r14 % r2
            if (r14 == 0) goto L_0x00ce
            r14 = 46
            int r14 = r14 / r0
        L_0x00ce:
            return r13
        L_0x00cf:
            r13 = move-exception
            java.lang.Throwable r14 = r13.getCause()     // Catch:{ all -> 0x00d7 }
            if (r14 == 0) goto L_0x00da
            throw r14     // Catch:{ all -> 0x00d7 }
        L_0x00d7:
            r13 = move-exception
            r7 = r13
            goto L_0x00db
        L_0x00da:
            throw r13     // Catch:{ all -> 0x00d7 }
        L_0x00db:
            com.appsflyer.AFLogger r4 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r5 = com.appsflyer.internal.AFg1cSDK.ENGAGEMENT
            r8 = 0
            r9 = 0
            java.lang.String r6 = "AFFinalizer: reflection init failed."
            r4.e(r5, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1oSDK.getCurrencyIso4217Code(java.util.Map, java.lang.String, java.lang.String):com.appsflyer.internal.AFd1nSDK");
    }

    public static void getMonetizationNetwork() {
        component1 = -411944536;
        areAllFieldsValid = 1624197239;
        component3 = -898995602;
        copydefault = new byte[]{-107, -75, -81, 99, Ascii.NAK, -75, 105, -80, Ascii.CAN, 72, -87, 71, -114, 87, Ascii.SO, -80, 57};
    }

    private boolean getRevenue() {
        boolean z = false;
        if (this.getMediationNetwork.getBoolean(AppsFlyerProperties.HTTP_CACHE, true)) {
            return false;
        }
        int i = copy;
        int i2 = i + 107;
        hashCode = i2 % 128;
        if (i2 % 2 == 0) {
            z = true;
        }
        boolean z2 = !z;
        hashCode = (i + 79) % 128;
        return z2;
    }

    private <T> AFd1nSDK<T> getRevenue(AFd1cSDK aFd1cSDK, AFe1ySDK<T> aFe1ySDK, boolean z) {
        aFd1cSDK.getMediationNetwork = z;
        AFd1lSDK aFd1lSDK = this.getMonetizationNetwork;
        AFd1nSDK<T> aFd1nSDK = new AFd1nSDK<>(aFd1cSDK, aFd1lSDK.getRevenue, aFd1lSDK.getMonetizationNetwork, aFe1ySDK);
        copy = (hashCode + 109) % 128;
        return aFd1nSDK;
    }

    @NonNull
    public final AFd1nSDK<AFi1wSDK> getRevenue(boolean z, boolean z2, @NonNull String str, int i) {
        return (AFd1nSDK) getCurrencyIso4217Code(new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), str, Integer.valueOf(i)}, 662152322, -662152320, i);
    }

    @Nullable
    public final AFd1nSDK<String> getCurrencyIso4217Code(AFh1rSDK aFh1rSDK, String str, AFc1iSDK aFc1iSDK) {
        String str2;
        String revenue;
        AFh1rSDK aFh1rSDK2 = aFh1rSDK;
        try {
            Object[] objArr = new Object[3];
            objArr[2] = aFc1iSDK;
            objArr[1] = str;
            objArr[0] = aFh1rSDK2;
            Map map = AFa1kSDK.i;
            Object obj = map.get(-1609157430);
            if (obj == null) {
                obj = ((Class) AFa1kSDK.getCurrencyIso4217Code(TextUtils.indexOf("", "", 0, 0) + 196, (char) KeyEvent.normalizeMetaState(0), 37 - TextUtils.indexOf("", "", 0, 0))).getMethod("getMonetizationNetwork", new Class[]{AFh1rSDK.class, String.class, AFc1iSDK.class});
                map.put(-1609157430, obj);
            }
            byte[] bArr = (byte[]) ((Method) obj).invoke((Object) null, objArr);
            hashCode = (copy + 13) % 128;
            AFj1fSDK aFj1fSDK = this.component2;
            Intrinsics.checkNotNullParameter(aFh1rSDK2, "");
            boolean mediationNetwork = aFh1rSDK.getMediationNetwork();
            boolean z = aFh1rSDK2 instanceof AFh1lSDK;
            boolean z2 = aFh1rSDK2 instanceof AFh1jSDK;
            boolean z3 = aFh1rSDK2 instanceof AFh1kSDK;
            boolean z4 = aFh1rSDK2 instanceof AFi1zSDK;
            boolean z5 = aFh1rSDK2 instanceof AFh1gSDK;
            boolean z6 = aFh1rSDK2 instanceof AFg1wSDK;
            if (aFh1rSDK2 instanceof AFh1eSDK) {
                str2 = aFj1fSDK.getMonetizationNetwork.AFAdRevenueData("https://%spia.%s/api/v1.0/pia-android-event?app_id=");
                copy = (hashCode + 21) % 128;
                revenue = aFj1fSDK.getRevenue(AFj1fSDK.AFAdRevenueData(aFj1fSDK.getCurrencyIso4217Code(str2), z), z6);
            } else {
                if (!z3) {
                    int i = hashCode + 19;
                    int i2 = i % 128;
                    copy = i2;
                    if (i % 2 != 0) {
                        throw null;
                    } else if (!z2) {
                        if (z) {
                            int i3 = i2 + 13;
                            hashCode = i3 % 128;
                            if (i3 % 2 != 0) {
                                str2 = aFj1fSDK.getMonetizationNetwork.AFAdRevenueData(AFj1fSDK.getCurrencyIso4217Code);
                            } else {
                                aFj1fSDK.getMonetizationNetwork.AFAdRevenueData(AFj1fSDK.getCurrencyIso4217Code);
                                throw null;
                            }
                        } else if (z4) {
                            int i4 = i2 + 7;
                            hashCode = i4 % 128;
                            if (i4 % 2 != 0) {
                                str2 = aFj1fSDK.getMonetizationNetwork.AFAdRevenueData(AFj1fSDK.component3);
                            } else {
                                aFj1fSDK.getMonetizationNetwork.AFAdRevenueData(AFj1fSDK.component3);
                                throw null;
                            }
                        } else if (z5) {
                            revenue = aFj1fSDK.getMonetizationNetwork.AFAdRevenueData("https://%ssdk-services.%s/validate-android-signature");
                        } else if (z6) {
                            str2 = aFj1fSDK.getMonetizationNetwork.AFAdRevenueData(AFj1fSDK.areAllFieldsValid);
                        } else if (!mediationNetwork) {
                            str2 = aFj1fSDK.getMonetizationNetwork.AFAdRevenueData(AFj1fSDK.component2);
                        } else if (aFh1rSDK2.component2 < 2) {
                            str2 = aFj1fSDK.getMonetizationNetwork.AFAdRevenueData(AFj1fSDK.getMediationNetwork);
                        } else {
                            str2 = aFj1fSDK.getMonetizationNetwork.AFAdRevenueData(AFj1fSDK.component1);
                        }
                        revenue = aFj1fSDK.getRevenue(AFj1fSDK.AFAdRevenueData(aFj1fSDK.getCurrencyIso4217Code(str2), z), z6);
                    }
                }
                str2 = aFj1fSDK.getMonetizationNetwork.AFAdRevenueData(AFj1fSDK.getRevenue);
                revenue = aFj1fSDK.getRevenue(AFj1fSDK.AFAdRevenueData(aFj1fSDK.getCurrencyIso4217Code(str2), z), z6);
            }
            return getRevenue(new AFd1cSDK(revenue, bArr, FirebasePerformance.HttpMethod.POST, Collections.emptyMap(), aFh1rSDK.getMonetizationNetwork()), new AFd1eSDK());
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "AFFinalizer: reflection init failed.", th, false, false);
            return null;
        }
    }
}
