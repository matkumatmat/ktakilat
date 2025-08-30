package com.appsflyer;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1qSDK;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppsFlyerProperties {
    public static final String ADDITIONAL_CUSTOM_DATA = "additionalCustomData";
    public static final String AF_STORE_FROM_API = "api_store_value";
    public static final String AF_WAITFOR_CUSTOMERID = "waitForCustomerId";
    public static final String APP_ID = "appid";
    public static final String APP_USER_ID = "AppUserId";
    public static final String CHANNEL = "channel";
    public static final String COLLECT_ANDROID_ID = "collectAndroidId";
    public static final String COLLECT_ANDROID_ID_FORCE_BY_USER = "collectAndroidIdForceByUser";
    public static final String COLLECT_FACEBOOK_ATTR_ID = "collectFacebookAttrId";
    public static final String COLLECT_IMEI = "collectIMEI";
    public static final String COLLECT_IMEI_FORCE_BY_USER = "collectIMEIForceByUser";
    public static final String COLLECT_OAID = "collectOAID";
    public static final String CURRENCY_CODE = "currencyCode";
    public static final String DEVICE_TRACKING_DISABLED = "deviceTrackingDisabled";
    public static final String DISABLE_KEYSTORE = "keyPropDisableAFKeystore";
    public static final String DISABLE_LOGS_COMPLETELY = "disableLogs";
    public static final String DISABLE_NETWORK_DATA = "disableCollectNetworkData";
    public static final String DISABLE_OTHER_SDK = "disableOtherSdk";
    public static final String DPM = "disableProxy";
    public static final String EMAIL_CRYPT_TYPE = "userEmailsCryptType";
    public static final String ENABLE_GPS_FALLBACK = "enableGpsFallback";
    public static final String ENABLE_TCF_DATA_COLLECTION = "enableTCFDataCollection";
    public static final String EXTENSION = "sdkExtension";
    public static final String HTTP_CACHE = "http_cache";
    public static final String IS_UPDATE = "IS_UPDATE";
    public static final String LAUNCH_PROTECT_ENABLED = "launchProtectEnabled";
    public static final String NEW_REFERRER_SENT = "newGPReferrerSent";
    public static final String ONELINK_DOMAIN = "onelinkDomain";
    public static final String ONELINK_ID = "oneLinkSlug";
    public static final String ONELINK_SCHEME = "onelinkScheme";
    public static final String ONELINK_VERSION = "onelinkVersion";
    public static final String USER_EMAILS = "userEmails";
    @VisibleForTesting
    public static AppsFlyerProperties instance;
    private boolean AFAdRevenueData = false;
    public boolean getCurrencyIso4217Code;
    public String getMediationNetwork;
    private final Map<String, Object> getRevenue = new HashMap();

    public enum EmailsCryptType {
        NONE(0),
        SHA256(3);
        
        private final int getRevenue;

        private EmailsCryptType(int i) {
            this.getRevenue = i;
        }

        public final int getValue() {
            return this.getRevenue;
        }
    }

    private boolean getCurrencyIso4217Code() {
        return this.AFAdRevenueData;
    }

    public static AppsFlyerProperties getInstance() {
        if (instance == null) {
            instance = new AppsFlyerProperties();
        }
        return instance;
    }

    public final boolean AFAdRevenueData() {
        return this.getCurrencyIso4217Code;
    }

    public boolean getBoolean(String str, boolean z) {
        String string = getString(str);
        if (string == null) {
            return z;
        }
        return Boolean.parseBoolean(string);
    }

    public int getInt(String str, int i) {
        String string = getString(str);
        if (string == null) {
            return i;
        }
        return Integer.parseInt(string);
    }

    public int getLogLevel() {
        return getInt("logLevel", AFLogger.LogLevel.NONE.getLevel());
    }

    public long getLong(String str, long j) {
        String string = getString(str);
        if (string == null) {
            return j;
        }
        return Long.parseLong(string);
    }

    public String getReferrer(AFc1qSDK aFc1qSDK) {
        String str = this.getMediationNetwork;
        if (str != null) {
            return str;
        }
        if (getString("AF_REFERRER") != null) {
            return getString("AF_REFERRER");
        }
        return aFc1qSDK.AFAdRevenueData("referrer", (String) null);
    }

    @Nullable
    public synchronized String getString(String str) {
        return (String) this.getRevenue.get(str);
    }

    public boolean isEnableLog() {
        if (getLogLevel() > AFLogger.LogLevel.NONE.getLevel()) {
            return true;
        }
        return false;
    }

    public boolean isLogsDisabledCompletely() {
        return getBoolean(DISABLE_LOGS_COMPLETELY, false);
    }

    public boolean isOtherSdkStringDisabled() {
        return getBoolean(DISABLE_OTHER_SDK, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void loadProperties(com.appsflyer.internal.AFc1qSDK r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.getCurrencyIso4217Code()     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r5)
            return
        L_0x0009:
            java.lang.String r0 = "savedProperties"
            r1 = 0
            java.lang.String r0 = r6.AFAdRevenueData((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x007d
            java.lang.String r1 = "Loading properties.."
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x003e }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0040 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0040 }
            java.util.Iterator r0 = r1.keys()     // Catch:{ JSONException -> 0x0040 }
        L_0x0020:
            boolean r2 = r0.hasNext()     // Catch:{ JSONException -> 0x0040 }
            if (r2 == 0) goto L_0x0042
            java.lang.Object r2 = r0.next()     // Catch:{ JSONException -> 0x0040 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x0040 }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.getRevenue     // Catch:{ JSONException -> 0x0040 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ JSONException -> 0x0040 }
            if (r3 != 0) goto L_0x0020
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.getRevenue     // Catch:{ JSONException -> 0x0040 }
            java.lang.String r4 = r1.getString(r2)     // Catch:{ JSONException -> 0x0040 }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x0040 }
            goto L_0x0020
        L_0x003e:
            r6 = move-exception
            goto L_0x007f
        L_0x0040:
            r6 = move-exception
            goto L_0x0065
        L_0x0042:
            java.lang.String r0 = "AppsFlyerKey"
            java.lang.String r1 = "custom_host"
            java.lang.String r2 = "custom_host_prefix"
            java.lang.String r3 = "advertiserIdEnabled"
            java.lang.String r4 = "advertiserId"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r2, r3, r4}     // Catch:{ JSONException -> 0x0040 }
            r1 = 0
        L_0x0051:
            r2 = 5
            if (r1 >= r2) goto L_0x005e
            r2 = r0[r1]     // Catch:{ JSONException -> 0x0040 }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.getRevenue     // Catch:{ JSONException -> 0x0040 }
            r3.remove(r2)     // Catch:{ JSONException -> 0x0040 }
            int r1 = r1 + 1
            goto L_0x0051
        L_0x005e:
            r5.saveProperties(r6)     // Catch:{ JSONException -> 0x0040 }
            r6 = 1
            r5.AFAdRevenueData = r6     // Catch:{ JSONException -> 0x0040 }
            goto L_0x006a
        L_0x0065:
            java.lang.String r0 = "Failed loading properties"
            com.appsflyer.AFLogger.afErrorLog(r0, r6)     // Catch:{ all -> 0x003e }
        L_0x006a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            java.lang.String r0 = "Done loading properties: "
            r6.<init>(r0)     // Catch:{ all -> 0x003e }
            boolean r0 = r5.AFAdRevenueData     // Catch:{ all -> 0x003e }
            r6.append(r0)     // Catch:{ all -> 0x003e }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x003e }
            com.appsflyer.AFLogger.afDebugLog(r6)     // Catch:{ all -> 0x003e }
        L_0x007d:
            monitor-exit(r5)
            return
        L_0x007f:
            monitor-exit(r5)     // Catch:{ all -> 0x003e }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerProperties.loadProperties(com.appsflyer.internal.AFc1qSDK):void");
    }

    public synchronized void remove(String str) {
        this.getRevenue.remove(str);
    }

    public synchronized void saveProperties(AFc1qSDK aFc1qSDK) {
        this.getRevenue.remove("AppsFlyerKey");
        aFc1qSDK.getMediationNetwork("savedProperties", new JSONObject(this.getRevenue).toString());
    }

    public synchronized void set(String str, String str2) {
        this.getRevenue.put(str, str2);
    }

    public synchronized void setCustomData(String str) {
        this.getRevenue.put(ADDITIONAL_CUSTOM_DATA, str);
    }

    public synchronized void setUserEmails(String str) {
        this.getRevenue.put(USER_EMAILS, str);
    }

    public synchronized void set(String str, String[] strArr) {
        this.getRevenue.put(str, strArr);
    }

    public synchronized void set(String str, int i) {
        this.getRevenue.put(str, Integer.toString(i));
    }

    public synchronized void set(String str, long j) {
        this.getRevenue.put(str, Long.toString(j));
    }

    public synchronized void set(String str, boolean z) {
        this.getRevenue.put(str, Boolean.toString(z));
    }
}
