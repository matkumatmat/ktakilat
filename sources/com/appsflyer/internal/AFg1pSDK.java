package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class AFg1pSDK extends AFe1dSDK<Map<String, Object>> {
    private static final List<String> component2 = Arrays.asList(new String[]{"googleplay", "playstore", "googleplaystore"});
    @Nullable
    private String AFInAppEventParameterName;
    @Nullable
    private Map<String, Object> copy;
    private final AFh1vSDK copydefault;
    private final AFc1pSDK equals;
    private final AFd1oSDK hashCode;
    private final AFc1qSDK toString;

    public AFg1pSDK(@NonNull AFc1dSDK aFc1dSDK) {
        super(AFe1mSDK.GCDSDK, new AFe1mSDK[]{AFe1mSDK.RC_CDN}, aFc1dSDK, "GCD-FETCH");
        this.hashCode = aFc1dSDK.getCurrencyIso4217Code();
        this.toString = aFc1dSDK.component2();
        this.copydefault = aFc1dSDK.areAllFieldsValid();
        this.equals = aFc1dSDK.getRevenue();
        this.AFAdRevenueData.add(AFe1mSDK.CONVERSION);
        this.AFAdRevenueData.add(AFe1mSDK.LAUNCH);
    }

    @Nullable
    public final AppsFlyerRequestListener component3() {
        return null;
    }

    public final boolean copydefault() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e A[Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073, all -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008d A[Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073, all -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00be A[Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073, all -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010a A[Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073, all -> 0x0070 }] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFe1rSDK getCurrencyIso4217Code() throws java.lang.Exception {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            java.lang.String r2 = "is_first_launch"
            java.lang.String r3 = "af_channel"
            java.lang.String r4 = "af_siteid"
            java.lang.String r5 = "[GCD-A03] Server retrieving attempt finished"
            com.appsflyer.internal.AFf1gSDK r6 = r14.component3
            boolean r6 = r6.AFAdRevenueData()
            if (r6 != 0) goto L_0x0155
            com.appsflyer.internal.AFe1rSDK r6 = com.appsflyer.internal.AFe1rSDK.FAILURE
            r7 = 0
        L_0x0015:
            r8 = 2
            if (r7 > r8) goto L_0x0154
            if (r7 < r8) goto L_0x001c
            r6 = 1
            goto L_0x001d
        L_0x001c:
            r6 = 0
        L_0x001d:
            com.appsflyer.internal.AFh1vSDK r8 = r14.copydefault
            long r9 = java.lang.System.currentTimeMillis()
            r8.equals = r9
            com.appsflyer.internal.AFe1rSDK r8 = super.getCurrencyIso4217Code()     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.internal.AFd1aSDK<Result> r9 = r14.component1     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            if (r9 != 0) goto L_0x0036
        L_0x002d:
            com.appsflyer.internal.AFh1vSDK r6 = r14.copydefault
            r6.AFAdRevenueData(r7)
            com.appsflyer.AFLogger.afDebugLog(r5)
            goto L_0x0056
        L_0x0036:
            int r10 = r9.getStatusCode()     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            r11 = 403(0x193, float:5.65E-43)
            if (r10 == r11) goto L_0x0045
            r11 = 500(0x1f4, float:7.0E-43)
            if (r10 < r11) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r11 = 0
            goto L_0x0046
        L_0x0045:
            r11 = 1
        L_0x0046:
            boolean r12 = r9.isSuccessful()     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            r13 = 404(0x194, float:5.66E-43)
            if (r12 != 0) goto L_0x0079
            if (r10 != r13) goto L_0x0051
            goto L_0x0079
        L_0x0051:
            if (r6 != 0) goto L_0x0059
            if (r11 != 0) goto L_0x002d
            goto L_0x0059
        L_0x0056:
            r6 = r8
            goto L_0x0137
        L_0x0059:
            java.lang.String r8 = "Error connection to server: "
            java.lang.String r9 = java.lang.String.valueOf(r10)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r8 = r8.concat(r9)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            r14.AFInAppEventParameterName = r8     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.internal.AFe1rSDK r0 = com.appsflyer.internal.AFe1rSDK.FAILURE     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
        L_0x0067:
            com.appsflyer.internal.AFh1vSDK r1 = r14.copydefault
            r1.AFAdRevenueData(r7)
            com.appsflyer.AFLogger.afDebugLog(r5)
            return r0
        L_0x0070:
            r0 = move-exception
            goto L_0x014b
        L_0x0073:
            r8 = move-exception
            goto L_0x0115
        L_0x0076:
            r0 = move-exception
            goto L_0x0141
        L_0x0079:
            java.lang.Object r8 = r9.getBody()     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            int r9 = r9.getStatusCode()     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r10 = "iscache"
            java.lang.Object r10 = r8.get(r10)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            if (r9 != r13) goto L_0x00a5
            java.lang.String r9 = "error_reason"
            r8.remove(r9)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r9 = "status_code"
            r8.remove(r9)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r9 = "af_status"
            java.lang.String r11 = "Organic"
            r8.put(r9, r11)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r9 = "af_message"
            java.lang.String r11 = "organic install"
            r8.put(r9, r11)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
        L_0x00a5:
            if (r10 == 0) goto L_0x00b8
            boolean r9 = r10.booleanValue()     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            if (r9 != 0) goto L_0x00b8
            com.appsflyer.internal.AFc1qSDK r9 = r14.toString     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r10 = "appsflyerConversionDataCacheExpiration"
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            r9.getMonetizationNetwork(r10, r11)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
        L_0x00b8:
            boolean r9 = r8.containsKey(r4)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            if (r9 == 0) goto L_0x00eb
            boolean r9 = r8.containsKey(r3)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            if (r9 == 0) goto L_0x00da
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r10 = "[Invite] Detected App-Invite via channel: "
            r9.<init>(r10)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.Object r10 = r8.get(r3)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            r9.append(r10)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r9 = r9.toString()     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.AFLogger.afDebugLog(r9)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            goto L_0x00eb
        L_0x00da:
            java.lang.String r9 = "[CrossPromotion] App was installed via %s's Cross Promotion"
            java.lang.Object r10 = r8.get(r4)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.Object[] r11 = new java.lang.Object[r1]     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            r11[r0] = r10     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r9 = java.lang.String.format(r9, r11)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.AFLogger.afDebugLog(r9)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
        L_0x00eb:
            java.lang.Boolean r9 = java.lang.Boolean.FALSE     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            r8.put(r2, r9)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            r9.<init>(r8)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r9 = r9.toString()     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.internal.AFc1qSDK r10 = r14.toString     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r11 = "attributionId"
            r10.getMediationNetwork((java.lang.String) r11, (java.lang.String) r9)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.internal.AFc1qSDK r9 = r14.toString     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r10 = "sixtyDayConversionData"
            boolean r9 = r9.getMediationNetwork((java.lang.String) r10, (boolean) r0)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            if (r9 != 0) goto L_0x010f
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            r8.put(r2, r9)     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
        L_0x010f:
            r14.copy = r8     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.internal.AFe1rSDK r0 = com.appsflyer.internal.AFe1rSDK.SUCCESS     // Catch:{ AFe1nSDK -> 0x0076, Exception -> 0x0073 }
            goto L_0x0067
        L_0x0115:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            java.lang.String r10 = "[GCD] Error: "
            r9.<init>(r10)     // Catch:{ all -> 0x0070 }
            java.lang.String r10 = r8.getMessage()     // Catch:{ all -> 0x0070 }
            r9.append(r10)     // Catch:{ all -> 0x0070 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0070 }
            com.appsflyer.AFLogger.afErrorLog(r9, r8, r0, r0)     // Catch:{ all -> 0x0070 }
            com.appsflyer.internal.AFe1rSDK r9 = com.appsflyer.internal.AFe1rSDK.FAILURE     // Catch:{ all -> 0x0070 }
            if (r6 != 0) goto L_0x013a
            com.appsflyer.internal.AFh1vSDK r6 = r14.copydefault
            r6.AFAdRevenueData(r7)
            com.appsflyer.AFLogger.afDebugLog(r5)
            r6 = r9
        L_0x0137:
            int r7 = r7 + r1
            goto L_0x0015
        L_0x013a:
            java.lang.String r0 = r8.getMessage()     // Catch:{ all -> 0x0070 }
            r14.AFInAppEventParameterName = r0     // Catch:{ all -> 0x0070 }
            throw r8     // Catch:{ all -> 0x0070 }
        L_0x0141:
            java.lang.String r1 = "[GCD-E05] AppsFlyer dev key is missing"
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0070 }
            java.lang.String r1 = "AppsFlyer dev key is missing"
            r14.AFInAppEventParameterName = r1     // Catch:{ all -> 0x0070 }
            throw r0     // Catch:{ all -> 0x0070 }
        L_0x014b:
            com.appsflyer.internal.AFh1vSDK r1 = r14.copydefault
            r1.AFAdRevenueData(r7)
            com.appsflyer.AFLogger.afDebugLog(r5)
            throw r0
        L_0x0154:
            return r6
        L_0x0155:
            java.lang.String r0 = "[GCD-E03] 'isStopTracking' enabled"
            com.appsflyer.AFLogger.afDebugLog(r0)
            java.lang.String r0 = "'isStopTracking' enabled"
            r14.AFInAppEventParameterName = r0
            com.appsflyer.internal.AFe1oSDK r0 = new com.appsflyer.internal.AFe1oSDK
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1pSDK.getCurrencyIso4217Code():com.appsflyer.internal.AFe1rSDK");
    }

    public final boolean getMediationNetwork() {
        return false;
    }

    public final void getRevenue() {
        super.getRevenue();
        Map<String, Object> map = this.copy;
        String str = this.AFInAppEventParameterName;
        if (map != null) {
            AFg1nSDK.getMonetizationNetwork(map);
        } else if (str == null || str.isEmpty()) {
            AFg1nSDK.getMediationNetwork("Unknown error");
        } else {
            AFg1nSDK.getMediationNetwork(str);
        }
    }

    public final AFd1nSDK<Map<String, Object>> getRevenue(@NonNull String str) {
        String str2;
        String monetizationNetwork = AFa1tSDK.getMonetizationNetwork(this.toString, this.equals.component2());
        if (monetizationNetwork != null && !monetizationNetwork.trim().isEmpty()) {
            if (!component2.contains(monetizationNetwork.toLowerCase(Locale.getDefault()))) {
                str2 = "-".concat(monetizationNetwork);
                AFd1nSDK<Map<String, Object>> revenue = this.hashCode.getRevenue(str2, str);
                StringBuilder sb = new StringBuilder("[GCD-B01] URL: ");
                sb.append(revenue.getRevenue.getMonetizationNetwork);
                AFLogger.afInfoLog(sb.toString());
                return revenue;
            }
            AFLogger.afWarnLog("[GCD] AF detected using redundant Google-Play channel for attribution - " + monetizationNetwork + ". Using without channel postfix.");
        }
        str2 = "";
        AFd1nSDK<Map<String, Object>> revenue2 = this.hashCode.getRevenue(str2, str);
        StringBuilder sb2 = new StringBuilder("[GCD-B01] URL: ");
        sb2.append(revenue2.getRevenue.getMonetizationNetwork);
        AFLogger.afInfoLog(sb2.toString());
        return revenue2;
    }
}
