package com.appsflyer.internal;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFf1eSDK;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class AFf1gSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] component1 = {63633, 62277, 61193, 56317, 55253, 50050, 48743, 43590, 42524, 37626, 36515, 31377};
    private static long component3 = -7623911999770266845L;
    private static int copydefault = 0;
    private static int hashCode = 1;
    private long AFAdRevenueData;
    private volatile boolean areAllFieldsValid = false;
    @Nullable
    private volatile String component2;
    private volatile String component4;
    @NonNull
    private final AFf1eSDK getCurrencyIso4217Code;
    Map<String, Object> getMediationNetwork;
    private boolean getMonetizationNetwork = false;
    @NonNull
    private final AFc1iSDK getRevenue;

    public AFf1gSDK(@NonNull AFc1iSDK aFc1iSDK, @NonNull AFf1eSDK aFf1eSDK) {
        this.getRevenue = aFc1iSDK;
        this.getCurrencyIso4217Code = aFf1eSDK;
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        int i3;
        AFk1hSDK aFk1hSDK = new AFk1hSDK();
        long[] jArr = new long[i];
        aFk1hSDK.getMediationNetwork = 0;
        $10 = ($11 + 67) % 128;
        while (true) {
            int i4 = aFk1hSDK.getMediationNetwork;
            if (i4 >= i) {
                break;
            }
            $11 = ($10 + 103) % 128;
            jArr[i4] = (((long) ((char) ((int) (((long) component1[i2 + i4]) ^ -750476924154939152L)))) ^ (((long) i4) * (-750476924154939152L ^ component3))) ^ ((long) c);
            aFk1hSDK.getMediationNetwork = i4 + 1;
        }
        char[] cArr = new char[i];
        while (true) {
            aFk1hSDK.getMediationNetwork = 0;
            while (true) {
                i3 = aFk1hSDK.getMediationNetwork;
                if (i3 < i) {
                    int i5 = $10 + 83;
                    $11 = i5 % 128;
                    if (i5 % 2 == 0) {
                        break;
                    }
                    cArr[i3] = (char) ((int) jArr[i3]);
                    aFk1hSDK.getMediationNetwork = i3 + 1;
                } else {
                    objArr[0] = new String(cArr);
                    return;
                }
            }
            cArr[i3] = (char) ((int) jArr[i3]);
        }
    }

    private boolean component1() {
        copydefault = (hashCode + 71) % 128;
        Map<String, Object> map = this.getMediationNetwork;
        if (map != null && !map.isEmpty()) {
            return true;
        }
        int i = hashCode + 117;
        copydefault = i % 128;
        if (i % 2 == 0) {
            return false;
        }
        throw null;
    }

    @VisibleForTesting
    private long component2() {
        int i = (copydefault + 59) % 128;
        hashCode = i;
        long j = this.AFAdRevenueData;
        int i2 = i + 9;
        copydefault = i2 % 128;
        if (i2 % 2 == 0) {
            return j;
        }
        throw null;
    }

    public static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr, int i, int i2, int i3) {
        int i4 = ~i2;
        int i5 = ~i3;
        int i6 = (((~(i | i5)) | (~(i3 | (~i))) | i4) * 45) + (((~(i2 | i)) | (~(i4 | i3))) * -45) + (((~(i4 | i5)) | i) * -90) + (i2 * 46) + (i * 46);
        if (i6 != 1) {
            return i6 != 2 ? getCurrencyIso4217Code(objArr) : getRevenue(objArr);
        }
        return getMediationNetwork(objArr);
    }

    public final void AFAdRevenueData(String str) {
        copydefault = (hashCode + 105) % 128;
        this.component4 = str;
        copydefault = (hashCode + 85) % 128;
    }

    public final void areAllFieldsValid() {
        getCurrencyIso4217Code(new Object[]{this}, 2120438481, -2120438480, System.identityHashCode(this));
    }

    public final void getMediationNetwork(@NonNull String str) {
        int i = hashCode + 109;
        copydefault = i % 128;
        if (i % 2 != 0) {
            this.component2 = str;
            int i2 = 29 / 0;
            return;
        }
        this.component2 = str;
    }

    public final Map<String, Object> getMonetizationNetwork(Map<String, Object> map) {
        try {
            Object[] objArr = new Object[2];
            objArr[1] = this.getRevenue.getMonetizationNetwork;
            objArr[0] = map;
            Map map2 = AFa1kSDK.i;
            Object obj = map2.get(611220697);
            if (obj == null) {
                obj = ((Class) AFa1kSDK.getCurrencyIso4217Code((ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1)) + 122, (char) (ViewConfiguration.getFadingEdgeLength() >> 16), 36 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1)))).getDeclaredConstructor(new Class[]{Map.class, Context.class});
                map2.put(611220697, obj);
            }
            Map<String, Object> map3 = (Map) ((Constructor) obj).newInstance(objArr);
            int i = copydefault + 45;
            hashCode = i % 128;
            if (i % 2 != 0) {
                return map3;
            }
            throw null;
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("AFCksmV3: reflection init failed", th);
            return new HashMap();
        }
    }

    @Nullable
    public final String getRevenue() {
        int i = hashCode + 43;
        copydefault = i % 128;
        if (i % 2 == 0) {
            String str = this.component2;
            copydefault = (hashCode + 69) % 128;
            return str;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ java.lang.Object getCurrencyIso4217Code(java.lang.Object[] r9) {
        /*
            r0 = 0
            r1 = r9[r0]
            com.appsflyer.internal.AFf1gSDK r1 = (com.appsflyer.internal.AFf1gSDK) r1
            r2 = 1
            r9 = r9[r2]
            com.appsflyer.internal.AFc1qSDK r9 = (com.appsflyer.internal.AFc1qSDK) r9
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r4 = "collectIMEI"
            boolean r0 = r3.getBoolean(r4, r0)
            java.lang.String r3 = "imeiCached"
            r4 = 0
            java.lang.String r5 = r9.AFAdRevenueData((java.lang.String) r3, (java.lang.String) r4)
            if (r0 == 0) goto L_0x00d6
            java.lang.String r0 = r1.component2
            boolean r0 = com.appsflyer.internal.AFk1ySDK.getMediationNetwork(r0)
            if (r0 == 0) goto L_0x00d6
            com.appsflyer.internal.AFc1iSDK r0 = r1.getRevenue
            android.content.Context r0 = r0.getMonetizationNetwork
            if (r0 == 0) goto L_0x00dd
            boolean r1 = getMonetizationNetwork((android.content.Context) r0)
            if (r1 == 0) goto L_0x00dd
            int r1 = copydefault
            int r1 = r1 + 93
            int r6 = r1 % 128
            hashCode = r6
            int r1 = r1 % 2
            java.lang.String r6 = "getDeviceId"
            java.lang.String r7 = "phone"
            java.lang.String r8 = "use cached IMEI: "
            if (r1 != 0) goto L_0x0063
            java.lang.Object r0 = r0.getSystemService(r7)     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            java.lang.Class r1 = r0.getClass()     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            java.lang.reflect.Method r1 = r1.getMethod(r6, r7)     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            java.lang.Object r0 = r1.invoke(r0, r2)     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            if (r0 == 0) goto L_0x007b
            goto L_0x00de
        L_0x005f:
            r0 = move-exception
            goto L_0x0094
        L_0x0061:
            r0 = move-exception
            goto L_0x00b5
        L_0x0063:
            java.lang.Object r0 = r0.getSystemService(r7)     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            java.lang.Class r1 = r0.getClass()     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            java.lang.reflect.Method r1 = r1.getMethod(r6, r4)     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            java.lang.Object r0 = r1.invoke(r0, r4)     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            if (r0 == 0) goto L_0x007b
            goto L_0x00de
        L_0x007b:
            if (r5 == 0) goto L_0x0091
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            java.lang.String r0 = r8.concat(r0)     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ InvocationTargetException -> 0x0061, Exception -> 0x005f }
            int r0 = hashCode
            int r0 = r0 + 21
            int r0 = r0 % 128
            copydefault = r0
            goto L_0x0092
        L_0x0091:
            r5 = r4
        L_0x0092:
            r0 = r5
            goto L_0x00de
        L_0x0094:
            if (r5 == 0) goto L_0x009e
            java.lang.String r1 = r8.concat(r5)
            com.appsflyer.AFLogger.afDebugLog(r1)
            goto L_0x009f
        L_0x009e:
            r5 = r4
        L_0x009f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "WARNING: Can't collect IMEI: other reason: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.afErrorLog(r1, r0)
            goto L_0x0092
        L_0x00b5:
            if (r5 == 0) goto L_0x00bf
            java.lang.String r1 = r8.concat(r5)
            com.appsflyer.AFLogger.afDebugLog(r1)
            goto L_0x00c0
        L_0x00bf:
            r5 = r4
        L_0x00c0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "WARNING: Can't collect IMEI because of missing permissions: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.afErrorLog(r1, r0)
            goto L_0x0092
        L_0x00d6:
            java.lang.String r0 = r1.component2
            if (r0 == 0) goto L_0x00dd
            java.lang.String r0 = r1.component2
            goto L_0x00de
        L_0x00dd:
            r0 = r4
        L_0x00de:
            boolean r1 = com.appsflyer.internal.AFk1ySDK.getMediationNetwork(r0)
            if (r1 != 0) goto L_0x00f0
            int r1 = copydefault
            int r1 = r1 + 7
            int r1 = r1 % 128
            hashCode = r1
            r9.getMediationNetwork((java.lang.String) r3, (java.lang.String) r0)
            return r0
        L_0x00f0:
            java.lang.String r9 = "IMEI was not collected."
            com.appsflyer.AFLogger.afInfoLog(r9)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1gSDK.getCurrencyIso4217Code(java.lang.Object[]):java.lang.Object");
    }

    private static /* synthetic */ Object getRevenue(Object[] objArr) {
        try {
            new AFb1sSDK(objArr[0]).afInfoLog();
            copydefault = (hashCode + 3) % 128;
            return null;
        } catch (Exception e) {
            AFLogger.afErrorLogForExcManagerOnly("native: reflection init failed", e);
            return null;
        }
    }

    public final boolean AFAdRevenueData() {
        int i = copydefault + 59;
        hashCode = i % 128;
        if (i % 2 != 0) {
            return this.areAllFieldsValid;
        }
        throw null;
    }

    @VisibleForTesting
    public static void getRevenue(Map<String, Object> map, AFc1pSDK aFc1pSDK) {
        int i = hashCode + 15;
        copydefault = i % 128;
        if (i % 2 == 0) {
            int i2 = 0;
            if (AFk1ySDK.getMediationNetwork(aFc1pSDK.getMediationNetwork)) {
                String currencyIso4217Code = aFc1pSDK.getCurrencyIso4217Code("com.appsflyer.security.uuid");
                if (AFk1ySDK.getMediationNetwork(currencyIso4217Code)) {
                    int i3 = copydefault + 121;
                    hashCode = i3 % 128;
                    if (i3 % 2 != 0) {
                        currencyIso4217Code = AFc1pSDK.getRevenue();
                    } else {
                        AFc1pSDK.getRevenue();
                        throw null;
                    }
                }
                aFc1pSDK.getMediationNetwork = currencyIso4217Code.substring(0, 8);
            }
            String str = aFc1pSDK.getMediationNetwork;
            try {
                Object[] objArr = new Object[1];
                a(12 - Color.argb(0, 0, 0, 0), TextUtils.indexOf("", '0', 0, 0) + 1, (char) TextUtils.indexOf("", "", 0), objArr);
                long parseLong = Long.parseLong(String.valueOf(map.get(((String) objArr[0]).intern())));
                char[] charArray = str.toCharArray();
                int i4 = ((int) (parseLong % 94)) + 33;
                while (i2 < charArray.length) {
                    int i5 = copydefault + 61;
                    hashCode = i5 % 128;
                    if (i5 % 2 == 0) {
                        charArray[i2] = (char) (charArray[i2] ^ i4);
                        i2 += 117;
                    } else {
                        charArray[i2] = (char) (charArray[i2] ^ i4);
                        i2++;
                    }
                }
                map.put("sbid", new String(charArray));
                int i6 = copydefault + 9;
                hashCode = i6 % 128;
                if (i6 % 2 == 0) {
                    throw null;
                }
            } catch (Exception e) {
                AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Exception occurred while generating sbid ", e);
            }
        } else {
            AFk1ySDK.getMediationNetwork(aFc1pSDK.getMediationNetwork);
            throw null;
        }
    }

    public final Map<String, Object> AFAdRevenueData(Map<String, Object> map) {
        AFc1gSDK aFc1gSDK = new AFc1gSDK(map, this.getRevenue.getMonetizationNetwork);
        int i = copydefault + 19;
        hashCode = i % 128;
        if (i % 2 != 0) {
            return aFc1gSDK;
        }
        throw null;
    }

    @Nullable
    public final String getMediationNetwork() {
        int i = copydefault + 39;
        hashCode = i % 128;
        if (i % 2 != 0) {
            return this.component4;
        }
        throw null;
    }

    public final void getMediationNetwork(boolean z) {
        hashCode = (copydefault + 51) % 128;
        this.areAllFieldsValid = z;
        int i = hashCode + 59;
        copydefault = i % 128;
        if (i % 2 != 0) {
            int i2 = 58 / 0;
        }
    }

    public final void AFAdRevenueData(AFc1pSDK aFc1pSDK) {
        this.AFAdRevenueData = System.currentTimeMillis();
        this.getMonetizationNetwork = this.getCurrencyIso4217Code.getMediationNetwork(getMediationNetwork(aFc1pSDK), this.getRevenue.getMonetizationNetwork, new AFf1eSDK.AFa1vSDK() {
            public final void AFAdRevenueData(@NonNull String str, @NonNull String str2) {
                AFf1gSDK.this.getMediationNetwork = new ConcurrentHashMap();
                AFf1gSDK.this.getMediationNetwork.put("signedData", str);
                AFf1gSDK.this.getMediationNetwork.put("signature", str2);
                AFf1gSDK aFf1gSDK = AFf1gSDK.this;
                AFf1gSDK.getCurrencyIso4217Code(new Object[]{aFf1gSDK}, 2120438481, -2120438480, System.identityHashCode(aFf1gSDK));
                AFLogger.afInfoLog("Successfully retrieved Google LVL data.");
            }

            public final void AFAdRevenueData(String str, Exception exc) {
                AFf1gSDK.this.getMediationNetwork = new ConcurrentHashMap();
                String message = exc.getMessage();
                if (message == null) {
                    message = "unknown";
                }
                AFf1gSDK aFf1gSDK = AFf1gSDK.this;
                AFf1gSDK.getCurrencyIso4217Code(new Object[]{aFf1gSDK}, 2120438481, -2120438480, System.identityHashCode(aFf1gSDK));
                AFf1gSDK.this.getMediationNetwork.put("error", message);
                AFLogger.afErrorLog(str, exc, true, true, false);
            }
        });
        hashCode = (copydefault + 33) % 128;
    }

    public final boolean getMonetizationNetwork() {
        int i = copydefault;
        hashCode = (i + 49) % 128;
        if (this.getMonetizationNetwork) {
            int i2 = i + 81;
            hashCode = i2 % 128;
            if (i2 % 2 == 0) {
                int i3 = 94 / 0;
                if (!component1()) {
                    return true;
                }
            } else if (!component1()) {
                return true;
            }
        }
        int i4 = hashCode + 113;
        copydefault = i4 % 128;
        if (i4 % 2 == 0) {
            return false;
        }
        throw null;
    }

    @VisibleForTesting
    private long getMediationNetwork(AFc1pSDK aFc1pSDK) {
        StringBuilder sb = new StringBuilder();
        sb.append(AFb1iSDK.getRevenue(aFc1pSDK.getMonetizationNetwork));
        sb.append(component2());
        long mediationNetwork = AFj1cSDK.getMediationNetwork(AFj1cSDK.getCurrencyIso4217Code(sb.toString()));
        hashCode = (copydefault + 105) % 128;
        return mediationNetwork;
    }

    private static boolean getMonetizationNetwork(Context context) {
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false)) {
            int i = hashCode + 79;
            copydefault = i % 128;
            if (i % 2 == 0 ? (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) : !AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, true)) {
                AFa1tSDK aFa1tSDK = (AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis());
                if (!(!AFa1tSDK.getCurrencyIso4217Code(context))) {
                    return false;
                }
            }
        }
        hashCode = (copydefault + 53) % 128;
        return true;
    }

    public static void AFAdRevenueData(AFh1rSDK aFh1rSDK) {
        getCurrencyIso4217Code(new Object[]{aFh1rSDK}, -211782083, 211782085, (int) System.currentTimeMillis());
    }

    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        AFf1gSDK aFf1gSDK = objArr[0];
        copydefault = (hashCode + 89) % 128;
        aFf1gSDK.getMediationNetwork.put("ttr", Long.valueOf(System.currentTimeMillis() - aFf1gSDK.AFAdRevenueData));
        aFf1gSDK.getMediationNetwork.put("lvl_timestamp", Long.valueOf(aFf1gSDK.component2()));
        int i = hashCode + 15;
        copydefault = i % 128;
        if (i % 2 == 0) {
            return null;
        }
        throw null;
    }

    @Nullable
    public final String getMediationNetwork(AFc1qSDK aFc1qSDK) {
        return (String) getCurrencyIso4217Code(new Object[]{this, aFc1qSDK}, -1198101809, 1198101809, System.identityHashCode(this));
    }

    @NonNull
    public final Map<String, Object> getCurrencyIso4217Code() {
        HashMap hashMap = new HashMap();
        if (component1()) {
            int i = copydefault + 13;
            hashCode = i % 128;
            if (i % 2 != 0) {
                hashMap.put("lvl", this.getMediationNetwork);
            } else {
                hashMap.put("lvl", this.getMediationNetwork);
                throw null;
            }
        } else if (this.getMonetizationNetwork) {
            this.getMediationNetwork = new HashMap();
            getCurrencyIso4217Code(new Object[]{this}, 2120438481, -2120438480, System.identityHashCode(this));
            this.getMediationNetwork.put("error", "pending LVL response");
            hashMap.put("lvl", this.getMediationNetwork);
            copydefault = (hashCode + 35) % 128;
        }
        return hashMap;
    }
}
