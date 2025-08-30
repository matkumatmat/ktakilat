package com.appsflyer.internal;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

public final class AFb1jSDK {
    public static String getMonetizationNetwork;
    @Nullable
    public static Boolean getRevenue;

    private static boolean getCurrencyIso4217Code() {
        Boolean bool = getRevenue;
        if (bool == null || bool.booleanValue()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c A[RETURN] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.AFb1mSDK getMediationNetwork(android.content.Context r5) {
        /*
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = getMonetizationNetwork
            r2 = 1
            if (r1 == 0) goto L_0x000b
            r3 = 1
            goto L_0x000c
        L_0x000b:
            r3 = 0
        L_0x000c:
            r4 = 0
            if (r3 == 0) goto L_0x0011
        L_0x000f:
            r5 = r4
            goto L_0x004e
        L_0x0011:
            java.lang.Boolean r1 = getRevenue
            if (r1 == 0) goto L_0x001b
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0027
        L_0x001b:
            java.lang.Boolean r1 = getRevenue
            if (r1 != 0) goto L_0x004c
            java.lang.String r1 = "collectOAID"
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 == 0) goto L_0x004c
        L_0x0027:
            com.appsflyer.oaid.OaidClient r1 = new com.appsflyer.oaid.OaidClient     // Catch:{ all -> 0x0045 }
            r1.<init>(r5)     // Catch:{ all -> 0x0045 }
            boolean r5 = r0.isEnableLog()     // Catch:{ all -> 0x0045 }
            r1.setLogging(r5)     // Catch:{ all -> 0x0045 }
            com.appsflyer.oaid.OaidClient$Info r5 = r1.fetch()     // Catch:{ all -> 0x0045 }
            if (r5 == 0) goto L_0x004c
            java.lang.String r0 = r5.getId()     // Catch:{ all -> 0x0045 }
            java.lang.Boolean r5 = r5.getLat()     // Catch:{ all -> 0x0043 }
            r1 = r0
            goto L_0x004e
        L_0x0043:
            r1 = r0
            goto L_0x0046
        L_0x0045:
            r1 = r4
        L_0x0046:
            java.lang.String r5 = "No OAID library"
            com.appsflyer.AFLogger.afDebugLog(r5)
            goto L_0x000f
        L_0x004c:
            r5 = r4
            r1 = r5
        L_0x004e:
            if (r1 == 0) goto L_0x005c
            com.appsflyer.internal.AFb1mSDK r0 = new com.appsflyer.internal.AFb1mSDK
            r0.<init>(r1, r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            r0.AFAdRevenueData = r5
            return r0
        L_0x005c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1jSDK.getMediationNetwork(android.content.Context):com.appsflyer.internal.AFb1mSDK");
    }

    @Nullable
    public static AFb1mSDK k_(ContentResolver contentResolver) {
        String str;
        if (!getCurrencyIso4217Code() || contentResolver == null || AppsFlyerProperties.getInstance().getString("amazon_aid") != null || !"Amazon".equals(Build.MANUFACTURER)) {
            return null;
        }
        int i = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
        if (i == 0) {
            return new AFb1mSDK(Settings.Secure.getString(contentResolver, "advertising_id"), Boolean.FALSE);
        }
        if (i == 2) {
            return null;
        }
        try {
            str = Settings.Secure.getString(contentResolver, "advertising_id");
        } catch (Throwable th) {
            AFLogger.afErrorLog("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
            str = "";
        }
        return new AFb1mSDK(str, Boolean.TRUE);
    }
}
