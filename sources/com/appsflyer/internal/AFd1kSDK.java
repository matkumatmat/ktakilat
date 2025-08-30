package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class AFd1kSDK implements AFd1pSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long areAllFieldsValid = 0;
    private static char copy = '\u0000';
    private static int equals = 1;
    private static final int getRevenue = 98166;
    private static int hashCode;
    private static int toString;
    @NonNull
    private final Map<String, Object> AFAdRevenueData = new HashMap();
    private final AFc1dSDK component1;
    private boolean component2 = (true ^ AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false));
    private SecureRandom component3 = new SecureRandom();
    private boolean component4 = false;
    private List<String> getCurrencyIso4217Code = new ArrayList();
    private int getMediationNetwork = 0;
    private boolean getMonetizationNetwork = true;

    static {
        component3();
        int i = equals + 117;
        toString = i % 128;
        if (i % 2 != 0) {
            int i2 = 69 / 0;
        }
    }

    public AFd1kSDK(AFc1dSDK aFc1dSDK) {
        this.component1 = aFc1dSDK;
    }

    private void AFInAppEventParameterName() {
        toString = (equals + 89) % 128;
        this.component1.component2().getMonetizationNetwork("participantInProxy");
        equals = (toString + 121) % 128;
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.String] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(int r16, char r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Object[] r21) {
        /*
            r0 = 2
            if (r20 == 0) goto L_0x0018
            int r1 = $11
            int r1 = r1 + 31
            int r2 = r1 % 128
            $10 = r2
            int r1 = r1 % r0
            if (r1 != 0) goto L_0x0013
            char[] r1 = r20.toCharArray()
            goto L_0x001a
        L_0x0013:
            r20.toCharArray()
            r0 = 0
            throw r0
        L_0x0018:
            r1 = r20
        L_0x001a:
            char[] r1 = (char[]) r1
            if (r19 == 0) goto L_0x002b
            char[] r2 = r19.toCharArray()
            int r3 = $11
            int r3 = r3 + 29
            int r3 = r3 % 128
            $10 = r3
            goto L_0x002d
        L_0x002b:
            r2 = r19
        L_0x002d:
            char[] r2 = (char[]) r2
            if (r18 == 0) goto L_0x0036
            char[] r3 = r18.toCharArray()
            goto L_0x0038
        L_0x0036:
            r3 = r18
        L_0x0038:
            char[] r3 = (char[]) r3
            com.appsflyer.internal.AFk1jSDK r4 = new com.appsflyer.internal.AFk1jSDK
            r4.<init>()
            int r5 = r3.length
            char[] r6 = new char[r5]
            int r7 = r1.length
            char[] r8 = new char[r7]
            r9 = 0
            java.lang.System.arraycopy(r3, r9, r6, r9, r5)
            java.lang.System.arraycopy(r1, r9, r8, r9, r7)
            char r1 = r6[r9]
            r1 = r1 ^ r17
            char r1 = (char) r1
            r6[r9] = r1
            char r1 = r8[r0]
            r3 = r16
            char r3 = (char) r3
            int r1 = r1 + r3
            char r1 = (char) r1
            r8[r0] = r1
            int r0 = r2.length
            char[] r1 = new char[r0]
            r4.getMediationNetwork = r9
        L_0x0061:
            int r3 = r4.getMediationNetwork
            if (r3 >= r0) goto L_0x00ad
            int r5 = r3 + 2
            int r5 = r5 % 4
            int r7 = r3 + 3
            int r7 = r7 % 4
            int r10 = r3 % 4
            char r10 = r6[r10]
            int r10 = r10 * 32718
            char r5 = r8[r5]
            int r10 = r10 + r5
            r11 = 65535(0xffff, float:9.1834E-41)
            int r10 = r10 % r11
            char r10 = (char) r10
            r4.AFAdRevenueData = r10
            char r12 = r6[r7]
            int r12 = r12 * 32718
            int r12 = r12 + r5
            int r12 = r12 / r11
            char r5 = (char) r12
            r8[r7] = r5
            r6[r7] = r10
            char r5 = r2[r3]
            r5 = r5 ^ r10
            long r10 = (long) r5
            long r12 = areAllFieldsValid
            r14 = -866183138771165766(0xf3fab306471c9dba, double:-4.778994398988759E250)
            long r12 = r12 ^ r14
            long r10 = r10 ^ r12
            int r5 = hashCode
            long r12 = (long) r5
            long r12 = r12 ^ r14
            int r5 = (int) r12
            long r12 = (long) r5
            long r10 = r10 ^ r12
            char r5 = copy
            long r12 = (long) r5
            long r12 = r12 ^ r14
            int r5 = (int) r12
            char r5 = (char) r5
            long r12 = (long) r5
            long r10 = r10 ^ r12
            int r5 = (int) r10
            char r5 = (char) r5
            r1[r3] = r5
            int r3 = r3 + 1
            r4.getMediationNetwork = r3
            goto L_0x0061
        L_0x00ad:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
            r21[r9] = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1kSDK.a(int, char, java.lang.String, java.lang.String, java.lang.String, java.lang.Object[]):void");
    }

    private synchronized void areAllFieldsValid() {
        int i = toString + 63;
        equals = i % 128;
        if (i % 2 == 0) {
            throw null;
        } else if (!this.component4) {
            this.component4 = true;
            try {
                getCurrencyIso4217Code("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
                equals = (toString + 3) % 128;
            } catch (Throwable th) {
                AFLogger.INSTANCE.e(AFg1cSDK.PROXY, "Error while starting remote debugger", th, true, true, true);
            }
        }
    }

    @VisibleForTesting
    private static String component1() {
        int i = toString;
        int i2 = i + 77;
        equals = i2 % 128;
        if (i2 % 2 != 0) {
            equals = (i + 33) % 128;
            return "6.17.0";
        }
        throw null;
    }

    @VisibleForTesting
    private float component2() {
        equals = (toString + 65) % 128;
        float nextFloat = this.component3.nextFloat();
        int i = equals + 119;
        toString = i % 128;
        if (i % 2 != 0) {
            int i2 = 16 / 0;
        }
        return nextFloat;
    }

    public static void component3() {
        areAllFieldsValid = -866183138771165766L;
        hashCode = 1193057722;
        copy = 29794;
    }

    @NonNull
    private synchronized Map<String, Object> copy() {
        Map<String, Object> map;
        equals = (toString + 47) % 128;
        this.AFAdRevenueData.put("data", this.getCurrencyIso4217Code);
        equals();
        map = this.AFAdRevenueData;
        toString = (equals + 111) % 128;
        return map;
    }

    private boolean copydefault() {
        return ((Boolean) getMediationNetwork(new Object[]{this}, -1999031441, 1999031443, System.identityHashCode(this))).booleanValue();
    }

    private synchronized void equals() {
        this.getCurrencyIso4217Code = new ArrayList();
        this.getMediationNetwork = 0;
        toString = (equals + 115) % 128;
    }

    public static /* synthetic */ Object getMediationNetwork(Object[] objArr, int i, int i2, int i3) {
        int i4 = (i2 * 85) + (i * 85);
        int i5 = ~i;
        int i6 = ~i2;
        int i7 = ~(i5 | i6);
        int i8 = ~i3;
        int i9 = (~(i5 | i8)) | i7 | (~(i6 | i8));
        int i10 = i | i2;
        int i11 = ~(i2 | i8);
        int i12 = (i | (~(i3 | i6)) | i11) * -84;
        int i13 = ((i11 | (~i10)) * 84) + i12 + ((i9 | (~(i10 | i3))) * -84) + i4;
        if (i13 == 1) {
            equals = (toString + 69) % 128;
            objArr[0].getCurrencyIso4217Code("public_api_call", objArr[1], objArr[2]);
            toString = (equals + 1) % 128;
            return null;
        } else if (i13 == 2) {
            return getCurrencyIso4217Code(objArr);
        } else {
            if (i13 == 3) {
                return getMonetizationNetwork(objArr);
            }
            AFd1kSDK aFd1kSDK = objArr[0];
            boolean AFAdRevenueData2 = aFd1kSDK.AFAdRevenueData(getCurrencyIso4217Code(aFd1kSDK.component1.component1().getMediationNetwork.getCurrencyIso4217Code), getCurrencyIso4217Code(aFd1kSDK.component1.component1().getMediationNetwork.AFAdRevenueData));
            if (!AFAdRevenueData2) {
                aFd1kSDK.getRevenue();
                aFd1kSDK.getMediationNetwork();
            } else {
                equals = (toString + 57) % 128;
                aFd1kSDK.areAllFieldsValid();
            }
            equals = (toString + 31) % 128;
            return Boolean.valueOf(AFAdRevenueData2);
        }
    }

    @VisibleForTesting
    private Map<String, Object> p_(String str, PackageManager packageManager) {
        int i = equals + 95;
        toString = i % 128;
        if (i % 2 == 0) {
            q_(str, packageManager, this.component1.registerClient(), this.component1.afInfoLog());
            Map<String, Object> copy2 = copy();
            int i2 = equals + 29;
            toString = i2 % 128;
            if (i2 % 2 == 0) {
                return copy2;
            }
            throw null;
        }
        q_(str, packageManager, this.component1.registerClient(), this.component1.afInfoLog());
        copy();
        throw null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        if (r3 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        getMediationNetwork(r5.component1.getRevenue().AFAdRevenueData(), r8.getRevenue(), r9.AFAdRevenueData);
        r8 = new java.lang.StringBuilder("6.17.0.");
        r8.append(com.appsflyer.internal.AFa1tSDK.getMonetizationNetwork);
        getCurrencyIso4217Code(r8.toString(), r5.component1.registerClient().getMediationNetwork(), r1.getString("KSAppsFlyerId"), com.appsflyer.internal.AFb1iSDK.getRevenue(r5.component1.getRevenue().getMonetizationNetwork));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r7 = r7.getPackageInfo(r6, 0).versionCode;
        getMonetizationNetwork(r6, java.lang.String.valueOf(r7), r1.getString(com.appsflyer.AppsFlyerProperties.CHANNEL), r1.getString("preInstallName"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r1.set("remote_debug_static_data", new org.json.JSONObject(r5.AFAdRevenueData).toString());
        equals = (toString + 43) % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r3 != null) goto L_0x003b;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00a5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void q_(java.lang.String r6, android.content.pm.PackageManager r7, com.appsflyer.internal.AFf1gSDK r8, com.appsflyer.internal.AFc1kSDK r9) {
        /*
            r5 = this;
            java.lang.String r0 = "remote_debug_static_data"
            monitor-enter(r5)
            int r1 = toString     // Catch:{ all -> 0x0027 }
            int r1 = r1 + 43
            int r2 = r1 % 128
            equals = r2     // Catch:{ all -> 0x0027 }
            int r1 = r1 % 2
            r2 = 0
            if (r1 != 0) goto L_0x002a
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0027 }
            java.lang.String r3 = "remote_debug_static_data"
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0027 }
            java.util.Map<java.lang.String, java.lang.Object> r4 = r5.AFAdRevenueData     // Catch:{ all -> 0x0027 }
            r4.clear()     // Catch:{ all -> 0x0027 }
            r4 = 38
            int r4 = r4 / r2
            if (r3 == 0) goto L_0x004a
            goto L_0x003b
        L_0x0025:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r6 = move-exception
            goto L_0x00d6
        L_0x002a:
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0027 }
            java.lang.String r3 = "remote_debug_static_data"
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0027 }
            java.util.Map<java.lang.String, java.lang.Object> r4 = r5.AFAdRevenueData     // Catch:{ all -> 0x0027 }
            r4.clear()     // Catch:{ all -> 0x0027 }
            if (r3 == 0) goto L_0x004a
        L_0x003b:
            java.util.Map<java.lang.String, java.lang.Object> r6 = r5.AFAdRevenueData     // Catch:{ all -> 0x00bb }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x00bb }
            r7.<init>(r3)     // Catch:{ all -> 0x00bb }
            java.util.Map r7 = com.appsflyer.internal.AFg1lSDK.getMonetizationNetwork((org.json.JSONObject) r7)     // Catch:{ all -> 0x00bb }
            r6.putAll(r7)     // Catch:{ all -> 0x00bb }
            goto L_0x00bb
        L_0x004a:
            com.appsflyer.internal.AFc1dSDK r3 = r5.component1     // Catch:{ all -> 0x0027 }
            com.appsflyer.internal.AFc1pSDK r3 = r3.getRevenue()     // Catch:{ all -> 0x0027 }
            java.lang.String r3 = r3.AFAdRevenueData()     // Catch:{ all -> 0x0027 }
            java.lang.String r8 = r8.getRevenue()     // Catch:{ all -> 0x0027 }
            java.lang.String r9 = r9.AFAdRevenueData     // Catch:{ all -> 0x0027 }
            r5.getMediationNetwork(r3, r8, r9)     // Catch:{ all -> 0x0027 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0027 }
            java.lang.String r9 = "6.17.0."
            r8.<init>(r9)     // Catch:{ all -> 0x0027 }
            java.lang.String r9 = com.appsflyer.internal.AFa1tSDK.getMonetizationNetwork     // Catch:{ all -> 0x0027 }
            r8.append(r9)     // Catch:{ all -> 0x0027 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0027 }
            com.appsflyer.internal.AFc1dSDK r9 = r5.component1     // Catch:{ all -> 0x0027 }
            com.appsflyer.internal.AFf1gSDK r9 = r9.registerClient()     // Catch:{ all -> 0x0027 }
            java.lang.String r9 = r9.getMediationNetwork()     // Catch:{ all -> 0x0027 }
            java.lang.String r3 = "KSAppsFlyerId"
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0027 }
            com.appsflyer.internal.AFc1dSDK r4 = r5.component1     // Catch:{ all -> 0x0027 }
            com.appsflyer.internal.AFc1pSDK r4 = r4.getRevenue()     // Catch:{ all -> 0x0027 }
            com.appsflyer.internal.AFc1qSDK r4 = r4.getMonetizationNetwork     // Catch:{ all -> 0x0027 }
            java.lang.String r4 = com.appsflyer.internal.AFb1iSDK.getRevenue(r4)     // Catch:{ all -> 0x0027 }
            r5.getCurrencyIso4217Code(r8, r9, r3, r4)     // Catch:{ all -> 0x0027 }
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r6, r2)     // Catch:{ all -> 0x00a5 }
            int r7 = r7.versionCode     // Catch:{ all -> 0x00a5 }
            java.lang.String r8 = "channel"
            java.lang.String r8 = r1.getString(r8)     // Catch:{ all -> 0x00a5 }
            java.lang.String r9 = "preInstallName"
            java.lang.String r9 = r1.getString(r9)     // Catch:{ all -> 0x00a5 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x00a5 }
            r5.getMonetizationNetwork(r6, r7, r8, r9)     // Catch:{ all -> 0x00a5 }
        L_0x00a5:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0027 }
            java.util.Map<java.lang.String, java.lang.Object> r7 = r5.AFAdRevenueData     // Catch:{ all -> 0x0027 }
            r6.<init>(r7)     // Catch:{ all -> 0x0027 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0027 }
            r1.set((java.lang.String) r0, (java.lang.String) r6)     // Catch:{ all -> 0x0027 }
            int r6 = toString     // Catch:{ all -> 0x0027 }
            int r6 = r6 + 43
            int r6 = r6 % 128
            equals = r6     // Catch:{ all -> 0x0027 }
        L_0x00bb:
            java.util.Map<java.lang.String, java.lang.Object> r6 = r5.AFAdRevenueData     // Catch:{ all -> 0x0027 }
            java.lang.String r7 = "launch_counter"
            com.appsflyer.internal.AFc1dSDK r8 = r5.component1     // Catch:{ all -> 0x0027 }
            com.appsflyer.internal.AFc1pSDK r8 = r8.getRevenue()     // Catch:{ all -> 0x0027 }
            com.appsflyer.internal.AFc1qSDK r8 = r8.getMonetizationNetwork     // Catch:{ all -> 0x0027 }
            java.lang.String r9 = "appsFlyerCount"
            int r8 = r8.AFAdRevenueData((java.lang.String) r9, (int) r2)     // Catch:{ all -> 0x0027 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0027 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0027 }
            monitor-exit(r5)
            return
        L_0x00d6:
            monitor-exit(r5)     // Catch:{ all -> 0x0027 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1kSDK.q_(java.lang.String, android.content.pm.PackageManager, com.appsflyer.internal.AFf1gSDK, com.appsflyer.internal.AFc1kSDK):void");
    }

    private boolean registerClient() {
        int i = toString + 9;
        equals = i % 128;
        int i2 = i % 2;
        return this.component1.component2().getMediationNetwork("participantInProxy", false);
    }

    public final synchronized void AFAdRevenueData() {
        toString = (equals + 31) % 128;
        this.AFAdRevenueData.clear();
        this.getCurrencyIso4217Code.clear();
        this.getMediationNetwork = 0;
        int i = toString + 105;
        equals = i % 128;
        if (i % 2 == 0) {
            int i2 = 83 / 0;
        }
    }

    public final boolean component4() {
        int i = equals;
        int i2 = i + 103;
        toString = i2 % 128;
        if (i2 % 2 == 0) {
            boolean z = this.component4;
            toString = (i + 119) % 128;
            return z;
        }
        throw null;
    }

    public final void getCurrencyIso4217Code(String str, String str2) {
        int i = toString + 17;
        equals = i % 128;
        if (i % 2 == 0) {
            String[] strArr = new String[0];
            strArr[0] = str2;
            getCurrencyIso4217Code("server_request", str, strArr);
        } else {
            getCurrencyIso4217Code("server_request", str, str2);
        }
        int i2 = toString + 101;
        equals = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    public final void getMonetizationNetwork(Throwable th) {
        StackTraceElement[] stackTraceElementArr;
        equals = (toString + 45) % 128;
        Throwable cause = th.getCause();
        String simpleName = th.getClass().getSimpleName();
        String message = cause == null ? th.getMessage() : cause.getMessage();
        if (cause == null) {
            int i = equals + 73;
            toString = i % 128;
            if (i % 2 == 0) {
                stackTraceElementArr = th.getStackTrace();
            } else {
                th.getStackTrace();
                throw null;
            }
        } else {
            stackTraceElementArr = cause.getStackTrace();
            equals = (toString + 3) % 128;
        }
        getCurrencyIso4217Code("exception", simpleName, getRevenue(message, stackTraceElementArr));
    }

    public final void getRevenue(String str, int i, String str2) {
        equals = (toString + 29) % 128;
        getCurrencyIso4217Code("server_response", str, String.valueOf(i), str2);
        int i2 = equals + 121;
        toString = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    public final void o_(String str, PackageManager packageManager) {
        int i = equals + 117;
        toString = i % 128;
        if (i % 2 == 0) {
            try {
                AFd1mSDK revenue = this.component1.getCurrencyIso4217Code().getRevenue(p_(str, packageManager), this.component1.registerClient().getMediationNetwork());
                if (revenue == null) {
                    AFLogger.afErrorLogForExcManagerOnly("could not send null proxy data", new NullPointerException("request was null"));
                    return;
                }
                this.component1.getMonetizationNetwork().execute(new d(revenue, 1));
                int i2 = toString + 19;
                equals = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
            } catch (Throwable th) {
                AFLogger.afErrorLogForExcManagerOnly("could not send proxy data", th);
            }
        } else {
            this.component1.getCurrencyIso4217Code().getRevenue(p_(str, packageManager), this.component1.registerClient().getMediationNetwork());
            throw null;
        }
    }

    public final void getCurrencyIso4217Code() {
        boolean z;
        int i = toString + 23;
        int i2 = i % 128;
        equals = i2;
        if (i % 2 == 0) {
            z = true;
        } else {
            z = false;
        }
        this.component2 = z;
        int i3 = i2 + 63;
        toString = i3 % 128;
        if (i3 % 2 != 0) {
            throw null;
        }
    }

    public final synchronized void getRevenue() {
        equals = (toString + 125) % 128;
        this.getMonetizationNetwork = false;
        AFAdRevenueData();
        equals();
        toString = (equals + 121) % 128;
    }

    private synchronized boolean AFAdRevenueData(@Nullable AFi1xSDK aFi1xSDK, @Nullable AFi1xSDK aFi1xSDK2) {
        boolean z = false;
        if (aFi1xSDK == null) {
            AFInAppEventParameterName();
            return false;
        } else if (!aFi1xSDK.getCurrencyIso4217Code()) {
            int i = toString + 77;
            equals = i % 128;
            if (i % 2 != 0) {
                return false;
            }
            throw null;
        } else if (this.component1.getRevenue().getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0) > aFi1xSDK.getMonetizationNetwork) {
            toString = (equals + 3) % 128;
            return false;
        } else if (!getRevenue(aFi1xSDK, aFi1xSDK2)) {
            return false;
        } else {
            if (!AFAdRevenueData(aFi1xSDK.AFAdRevenueData)) {
                int i2 = equals;
                int i3 = i2 + 113;
                toString = i3 % 128;
                if (i3 % 2 == 0) {
                    z = true;
                }
                boolean z2 = !z;
                toString = (i2 + 21) % 128;
                return z2;
            } else if (getCurrencyIso4217Code(aFi1xSDK.component2)) {
                return true;
            } else {
                int i4 = toString + 113;
                equals = i4 % 128;
                if (i4 % 2 == 0) {
                    return true;
                }
                return false;
            }
        }
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        AFd1kSDK aFd1kSDK = objArr[0];
        if (aFd1kSDK.component2) {
            int i = equals;
            toString = (i + 49) % 128;
            if (aFd1kSDK.getMonetizationNetwork || aFd1kSDK.component4) {
                int i2 = i + 57;
                toString = i2 % 128;
                if (i2 % 2 == 0) {
                    return Boolean.TRUE;
                }
                throw null;
            }
        }
        return Boolean.FALSE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        if (r4.length() > 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        if (r5.length() > 0) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0074, code lost:
        if (r6.length() > 0) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void getCurrencyIso4217Code(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r2.AFAdRevenueData     // Catch:{ all -> 0x0082 }
            java.lang.String r1 = "sdk_version"
            r0.put(r1, r3)     // Catch:{ all -> 0x0082 }
            if (r4 == 0) goto L_0x0031
            int r3 = toString     // Catch:{ all -> 0x002f }
            int r3 = r3 + 61
            int r0 = r3 % 128
            equals = r0     // Catch:{ all -> 0x002f }
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x0021
            int r3 = r4.length()     // Catch:{ all -> 0x0082 }
            r0 = 47
            int r0 = r0 / 0
            if (r3 <= 0) goto L_0x0031
            goto L_0x0027
        L_0x0021:
            int r3 = r4.length()     // Catch:{ all -> 0x0082 }
            if (r3 <= 0) goto L_0x0031
        L_0x0027:
            java.util.Map<java.lang.String, java.lang.Object> r3 = r2.AFAdRevenueData     // Catch:{ all -> 0x0082 }
            java.lang.String r0 = "devkey"
            r3.put(r0, r4)     // Catch:{ all -> 0x0082 }
            goto L_0x0031
        L_0x002f:
            r3 = move-exception
            goto L_0x007e
        L_0x0031:
            if (r5 == 0) goto L_0x0057
            int r3 = toString     // Catch:{ all -> 0x002f }
            int r3 = r3 + 19
            int r4 = r3 % 128
            equals = r4     // Catch:{ all -> 0x002f }
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x004a
            int r3 = r5.length()     // Catch:{ all -> 0x0082 }
            r4 = 74
            int r4 = r4 / 0
            if (r3 <= 0) goto L_0x0057
            goto L_0x0050
        L_0x004a:
            int r3 = r5.length()     // Catch:{ all -> 0x0082 }
            if (r3 <= 0) goto L_0x0057
        L_0x0050:
            java.util.Map<java.lang.String, java.lang.Object> r3 = r2.AFAdRevenueData     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = "originalAppsFlyerId"
            r3.put(r4, r5)     // Catch:{ all -> 0x0082 }
        L_0x0057:
            if (r6 == 0) goto L_0x0080
            int r3 = toString     // Catch:{ all -> 0x002f }
            int r3 = r3 + 61
            int r4 = r3 % 128
            equals = r4     // Catch:{ all -> 0x002f }
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x0070
            int r3 = r6.length()     // Catch:{ all -> 0x0082 }
            r4 = 79
            int r4 = r4 / 0
            if (r3 <= 0) goto L_0x0080
            goto L_0x0076
        L_0x0070:
            int r3 = r6.length()     // Catch:{ all -> 0x0082 }
            if (r3 <= 0) goto L_0x0080
        L_0x0076:
            java.util.Map<java.lang.String, java.lang.Object> r3 = r2.AFAdRevenueData     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = "uid"
            r3.put(r4, r6)     // Catch:{ all -> 0x0082 }
            goto L_0x0080
        L_0x007e:
            monitor-exit(r2)     // Catch:{ all -> 0x002f }
            throw r3
        L_0x0080:
            monitor-exit(r2)
            return
        L_0x0082:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1kSDK.getCurrencyIso4217Code(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private static String[] getRevenue(String str, StackTraceElement[] stackTraceElementArr) {
        int i = toString;
        equals = (i + 55) % 128;
        if (stackTraceElementArr == null) {
            int i2 = i + 91;
            equals = i2 % 128;
            if (i2 % 2 == 0) {
                String[] strArr = new String[0];
                strArr[1] = str;
                return strArr;
            }
            return new String[]{str};
        }
        String[] strArr2 = new String[(stackTraceElementArr.length + 1)];
        strArr2[0] = str;
        for (int i3 = 1; i3 < stackTraceElementArr.length; i3++) {
            strArr2[i3] = stackTraceElementArr[i3].toString();
        }
        return strArr2;
    }

    public final void getMonetizationNetwork(String str, String str2) {
        int i = toString + 53;
        equals = i % 128;
        if (i % 2 == 0) {
            String[] strArr = new String[1];
            strArr[1] = str2;
            getCurrencyIso4217Code((String) null, str, strArr);
        } else {
            getCurrencyIso4217Code((String) null, str, str2);
        }
        int i2 = equals + 45;
        toString = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    private synchronized void getMonetizationNetwork(String str, String str2, String str3, String str4) {
        try {
            int i = toString;
            int i2 = i + 71;
            equals = i2 % 128;
            if (i2 % 2 != 0) {
                if (str != null) {
                    equals = (i + 35) % 128;
                    if (str.length() > 0) {
                        int i3 = toString + 109;
                        equals = i3 % 128;
                        if (i3 % 2 == 0) {
                            this.AFAdRevenueData.put("app_id", str);
                            int i4 = 52 / 0;
                        } else {
                            this.AFAdRevenueData.put("app_id", str);
                        }
                    }
                }
                if (str2 != null && str2.length() > 0) {
                    this.AFAdRevenueData.put("app_version", str2);
                }
                if (str3 != null && str3.length() > 0) {
                    this.AFAdRevenueData.put(AppsFlyerProperties.CHANNEL, str3);
                    toString = (equals + 55) % 128;
                }
                if (str4 != null) {
                    if (str4.length() > 0) {
                        this.AFAdRevenueData.put("preInstall", str4);
                    }
                }
            } else {
                throw null;
            }
        } catch (Throwable unused) {
        }
    }

    private boolean getRevenue(@NonNull AFi1xSDK aFi1xSDK, @Nullable AFi1xSDK aFi1xSDK2) {
        equals = (toString + 87) % 128;
        if (aFi1xSDK.equals(aFi1xSDK2)) {
            equals = (toString + 63) % 128;
            return registerClient();
        }
        boolean monetizationNetwork = getMonetizationNetwork(aFi1xSDK.getRevenue);
        getMediationNetwork(new Object[]{this, Boolean.valueOf(monetizationNetwork)}, 124011145, -124011142, System.identityHashCode(this));
        return monetizationNetwork;
    }

    public final synchronized void getMediationNetwork() {
        int i = (toString + 35) % 128;
        equals = i;
        if (!this.component4) {
            int i2 = i + 23;
            toString = i2 % 128;
            if (i2 % 2 != 0) {
                throw null;
            } else if (!this.getMonetizationNetwork) {
                return;
            }
        }
        this.component4 = false;
        this.getMonetizationNetwork = false;
        try {
            getCurrencyIso4217Code("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.PROXY, "Error while stopping remote debugger", th, true, true, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00df, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void getCurrencyIso4217Code(java.lang.String r4, java.lang.String r5, java.lang.String... r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.copydefault()     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x00e4
            int r0 = toString     // Catch:{ all -> 0x00e0 }
            int r0 = r0 + 75
            int r0 = r0 % 128
            equals = r0     // Catch:{ all -> 0x00e0 }
            int r0 = r3.getMediationNetwork     // Catch:{ all -> 0x00e0 }
            r1 = 98304(0x18000, float:1.37753E-40)
            if (r0 < r1) goto L_0x0018
            goto L_0x00e4
        L_0x0018:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00e2 }
            java.lang.String r2 = ", "
            java.lang.String r6 = android.text.TextUtils.join(r2, r6)     // Catch:{ all -> 0x00e2 }
            if (r4 == 0) goto L_0x0059
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e2 }
            r2.<init>()     // Catch:{ all -> 0x00e2 }
            r2.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = " "
            r2.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00e2 }
            long r0 = r0.getId()     // Catch:{ all -> 0x00e2 }
            r2.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = " _/AppsFlyer_6.17.0 ["
            r2.append(r0)     // Catch:{ all -> 0x00e2 }
            r2.append(r4)     // Catch:{ all -> 0x00e2 }
            java.lang.String r4 = "] "
            r2.append(r4)     // Catch:{ all -> 0x00e2 }
            r2.append(r5)     // Catch:{ all -> 0x00e2 }
            java.lang.String r4 = " "
            r2.append(r4)     // Catch:{ all -> 0x00e2 }
            r2.append(r6)     // Catch:{ all -> 0x00e2 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x00e2 }
            goto L_0x008d
        L_0x0059:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e2 }
            r4.<init>()     // Catch:{ all -> 0x00e2 }
            r4.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = " "
            r4.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00e2 }
            long r0 = r0.getId()     // Catch:{ all -> 0x00e2 }
            r4.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = " "
            r4.append(r0)     // Catch:{ all -> 0x00e2 }
            r4.append(r5)     // Catch:{ all -> 0x00e2 }
            java.lang.String r5 = "/AppsFlyer_6.17.0 "
            r4.append(r5)     // Catch:{ all -> 0x00e2 }
            r4.append(r6)     // Catch:{ all -> 0x00e2 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00e2 }
            int r5 = equals     // Catch:{ all -> 0x00e0 }
            int r5 = r5 + 73
            int r5 = r5 % 128
            toString = r5     // Catch:{ all -> 0x00e0 }
        L_0x008d:
            int r5 = r3.getMediationNetwork     // Catch:{ all -> 0x00e2 }
            int r6 = r4.length()     // Catch:{ all -> 0x00e2 }
            r0 = 1
            int r6 = r6 << r0
            int r5 = r5 + r6
            int r6 = getRevenue     // Catch:{ all -> 0x00e2 }
            r1 = 0
            if (r5 <= r6) goto L_0x00a5
            int r5 = r3.getMediationNetwork     // Catch:{ all -> 0x00e2 }
            int r6 = r6 - r5
            int r6 = r6 / 2
            java.lang.String r4 = r4.substring(r1, r6)     // Catch:{ all -> 0x00e2 }
            r1 = 1
        L_0x00a5:
            java.util.List<java.lang.String> r5 = r3.getCurrencyIso4217Code     // Catch:{ all -> 0x00e2 }
            r5.add(r4)     // Catch:{ all -> 0x00e2 }
            int r5 = r3.getMediationNetwork     // Catch:{ all -> 0x00e2 }
            int r4 = r4.length()     // Catch:{ all -> 0x00e2 }
            int r4 = r4 << r0
            int r5 = r5 + r4
            r3.getMediationNetwork = r5     // Catch:{ all -> 0x00e2 }
            if (r1 == r0) goto L_0x00b7
            goto L_0x00de
        L_0x00b7:
            int r4 = toString     // Catch:{ all -> 0x00e0 }
            int r4 = r4 + 47
            int r5 = r4 % 128
            equals = r5     // Catch:{ all -> 0x00e0 }
            int r4 = r4 % 2
            if (r4 != 0) goto L_0x00d1
            java.util.List<java.lang.String> r4 = r3.getCurrencyIso4217Code     // Catch:{ all -> 0x00e2 }
            java.lang.String r5 = "+~+~ The limit has been exceeded, and no more data is available. +~+~"
            r4.add(r5)     // Catch:{ all -> 0x00e2 }
            int r4 = r3.getMediationNetwork     // Catch:{ all -> 0x00e2 }
            int r4 = r4 + 7164
            r3.getMediationNetwork = r4     // Catch:{ all -> 0x00e2 }
            goto L_0x00de
        L_0x00d1:
            java.util.List<java.lang.String> r4 = r3.getCurrencyIso4217Code     // Catch:{ all -> 0x00e2 }
            java.lang.String r5 = "+~+~ The limit has been exceeded, and no more data is available. +~+~"
            r4.add(r5)     // Catch:{ all -> 0x00e2 }
            int r4 = r3.getMediationNetwork     // Catch:{ all -> 0x00e2 }
            int r4 = r4 + 138
            r3.getMediationNetwork = r4     // Catch:{ all -> 0x00e2 }
        L_0x00de:
            monitor-exit(r3)
            return
        L_0x00e0:
            r4 = move-exception
            goto L_0x00e6
        L_0x00e2:
            monitor-exit(r3)
            return
        L_0x00e4:
            monitor-exit(r3)
            return
        L_0x00e6:
            monitor-exit(r3)     // Catch:{ all -> 0x00e0 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1kSDK.getCurrencyIso4217Code(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    private boolean AFAdRevenueData(String str) {
        int i = equals + 125;
        toString = i % 128;
        if (i % 2 != 0) {
            int i2 = 31 / 0;
            if (AFk1ySDK.getCurrencyIso4217Code(str)) {
                return true;
            }
        } else if (AFk1ySDK.getCurrencyIso4217Code(str)) {
            return true;
        }
        Context context = this.component1.getRevenue().getRevenue.getMonetizationNetwork;
        boolean equals2 = str.equals(AFj1iSDK.getMediationNetwork(context, context.getPackageName()));
        int i3 = toString + 93;
        equals = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 13 / 0;
        }
        return equals2;
    }

    private boolean getMonetizationNetwork(float f) {
        double d = (double) f;
        if (d >= 1.0d) {
            return true;
        }
        if (d <= 0.0d) {
            equals = (toString + 39) % 128;
            return false;
        } else if (component2() > f) {
            return false;
        } else {
            toString = (equals + 67) % 128;
            return true;
        }
    }

    private synchronized void getMediationNetwork(String str, String str2, String str3) {
        try {
            Map<String, Object> map = this.AFAdRevenueData;
            Object[] objArr = new Object[1];
            a(428417108 - TextUtils.indexOf("", '0', 0, 0), (char) (45453 - TextUtils.indexOf("", '0', 0)), "嗊褠踙", "ᒸي醼뇗ൎ", "\u0000\u0000\u0000\u0000", objArr);
            map.put(((String) objArr[0]).intern(), Build.BRAND);
            this.AFAdRevenueData.put("model", Build.MODEL);
            this.AFAdRevenueData.put("platform", "Android");
            this.AFAdRevenueData.put("platform_version", Build.VERSION.RELEASE);
            if (str != null) {
                equals = (toString + 111) % 128;
                if (str.length() > 0) {
                    this.AFAdRevenueData.put("advertiserId", str);
                }
            }
            if (str2 != null) {
                int i = toString + 27;
                equals = i % 128;
                if (i % 2 == 0) {
                    throw null;
                } else if (str2.length() > 0) {
                    this.AFAdRevenueData.put("imei", str2);
                }
            }
            if (str3 != null) {
                if (str3.length() > 0) {
                    this.AFAdRevenueData.put("android_id", str3);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static /* synthetic */ Object getMonetizationNetwork(Object[] objArr) {
        AFd1kSDK aFd1kSDK = objArr[0];
        boolean booleanValue = objArr[1].booleanValue();
        int i = toString + 41;
        equals = i % 128;
        if (i % 2 == 0) {
            aFd1kSDK.component1.component2().getCurrencyIso4217Code("participantInProxy", booleanValue);
            int i2 = 89 / 0;
        } else {
            aFd1kSDK.component1.component2().getCurrencyIso4217Code("participantInProxy", booleanValue);
        }
        toString = (equals + 31) % 128;
        return null;
    }

    private static boolean getCurrencyIso4217Code(String str) {
        toString = (equals + 65) % 128;
        if (AFk1ySDK.getCurrencyIso4217Code(str)) {
            int i = toString + 97;
            equals = i % 128;
            return i % 2 != 0;
        }
        new AFd1sSDK();
        return AFd1sSDK.getMediationNetwork(component1(), str);
    }

    private void getMonetizationNetwork(boolean z) {
        getMediationNetwork(new Object[]{this, Boolean.valueOf(z)}, 124011145, -124011142, System.identityHashCode(this));
    }

    public final boolean getMonetizationNetwork() {
        return ((Boolean) getMediationNetwork(new Object[]{this}, -1790300573, 1790300573, System.identityHashCode(this))).booleanValue();
    }

    @Nullable
    private static AFi1xSDK getCurrencyIso4217Code(@Nullable AFi1wSDK aFi1wSDK) {
        if (aFi1wSDK != null) {
            int i = equals + 49;
            int i2 = i % 128;
            toString = i2;
            if (i % 2 == 0) {
                AFh1cSDK aFh1cSDK = aFi1wSDK.getMonetizationNetwork;
                if (aFh1cSDK != null) {
                    AFi1xSDK aFi1xSDK = aFh1cSDK.AFAdRevenueData;
                    equals = (i2 + 51) % 128;
                    return aFi1xSDK;
                }
            } else {
                AFh1cSDK aFh1cSDK2 = aFi1wSDK.getMonetizationNetwork;
                throw null;
            }
        }
        return null;
    }

    public final void getMediationNetwork(String str, String... strArr) {
        getMediationNetwork(new Object[]{this, str, strArr}, 595413115, -595413114, System.identityHashCode(this));
    }
}
