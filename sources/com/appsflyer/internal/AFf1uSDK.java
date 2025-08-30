package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AFf1uSDK extends AFf1rSDK {
    @NonNull
    private final AFa1gSDK AFInAppEventParameterName;
    @NonNull
    private final AFh1vSDK AFInAppEventType;
    @Nullable
    private final AFh1uSDK AFKeystoreWrapper;
    @NonNull
    private final AppsFlyerProperties AFLogger = AppsFlyerProperties.getInstance();
    public Map<String, Object> copydefault;
    @NonNull
    private final AFj1sSDK equals;
    @NonNull
    private final AFc1qSDK hashCode;
    @NonNull
    private final AFf1oSDK registerClient;

    /* renamed from: com.appsflyer.internal.AFf1uSDK$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] AFAdRevenueData;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.appsflyer.internal.AFj1qSDK$AFa1ySDK[] r0 = com.appsflyer.internal.AFj1qSDK.AFa1ySDK.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                AFAdRevenueData = r0
                com.appsflyer.internal.AFj1qSDK$AFa1ySDK r1 = com.appsflyer.internal.AFj1qSDK.AFa1ySDK.FINISHED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = AFAdRevenueData     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.internal.AFj1qSDK$AFa1ySDK r1 = com.appsflyer.internal.AFj1qSDK.AFa1ySDK.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1uSDK.AnonymousClass1.<clinit>():void");
        }
    }

    public AFf1uSDK(@NonNull AFh1rSDK aFh1rSDK, @NonNull AFc1dSDK aFc1dSDK) {
        super(aFh1rSDK, aFc1dSDK);
        this.equals = aFc1dSDK.AFLogger();
        this.hashCode = aFc1dSDK.component2();
        this.AFInAppEventType = aFc1dSDK.areAllFieldsValid();
        this.registerClient = aFc1dSDK.component1();
        this.AFInAppEventParameterName = aFc1dSDK.afVerboseLog();
        this.AFKeystoreWrapper = aFc1dSDK.afErrorLogForExcManagerOnly();
        this.AFAdRevenueData.add(AFe1mSDK.RESOLVE_ESP);
        this.AFAdRevenueData.add(AFe1mSDK.DLSDK);
    }

    @VisibleForTesting
    private boolean equals() {
        boolean z;
        boolean z2;
        AFd1aSDK<Result> aFd1aSDK = this.component1;
        if (this.getMediationNetwork == AFe1rSDK.FAILURE && aFd1aSDK != null && aFd1aSDK.getStatusCode() / 500 == 1) {
            z = true;
        } else {
            z = false;
        }
        AFe1mSDK aFe1mSDK = this.getMonetizationNetwork;
        if (aFe1mSDK == AFe1mSDK.CONVERSION || aFe1mSDK == AFe1mSDK.ATTR) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public void AFAdRevenueData(AFh1rSDK aFh1rSDK) {
        AFh1uSDK aFh1uSDK;
        AFh1uSDK aFh1uSDK2;
        super.AFAdRevenueData(aFh1rSDK);
        int i = aFh1rSDK.component2;
        AFAdRevenueData(i);
        Map map = (Map) aFh1rSDK.AFAdRevenueData.get("meta");
        if (map == null) {
            map = new HashMap();
            aFh1rSDK.AFAdRevenueData.put("meta", map);
        }
        if (!aFh1rSDK.AFAdRevenueData.containsKey("af_deeplink")) {
            aFh1rSDK.getMediationNetwork(this.AFInAppEventParameterName.getCurrencyIso4217Code());
        }
        AFi1vSDK AFAdRevenueData = this.registerClient.AFAdRevenueData();
        if (AFAdRevenueData != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("cdn_token", AFAdRevenueData.AFAdRevenueData);
            String str = AFAdRevenueData.getCurrencyIso4217Code;
            if (str != null) {
                hashMap.put("c_ver", str);
            }
            long j = AFAdRevenueData.getRevenue;
            if (j > 0) {
                hashMap.put("latency", Long.valueOf(j));
            }
            long j2 = AFAdRevenueData.getMediationNetwork;
            if (j2 > 0) {
                hashMap.put("delay", Long.valueOf(j2));
            }
            int i2 = AFAdRevenueData.getMonetizationNetwork;
            if (i2 > 0) {
                hashMap.put("res_code", Integer.valueOf(i2));
            }
            if (AFAdRevenueData.component1 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(AFAdRevenueData.component1.getClass().getSimpleName());
                sb.append(": ");
                sb.append(AFAdRevenueData.component1.getMessage());
                hashMap.put("error", sb.toString());
            }
            AFi1ySDK aFi1ySDK = AFAdRevenueData.component4;
            if (aFi1ySDK != null) {
                hashMap.put("sig", aFi1ySDK.toString());
            }
            String str2 = AFAdRevenueData.component3;
            if (str2 != null) {
                hashMap.put("cdn_cache_status", str2);
            }
            map.put("rc", hashMap);
        }
        this.toString.getCurrencyIso4217Code(aFh1rSDK.AFAdRevenueData);
        if (i == 1) {
            if (this.AFLogger.getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                aFh1rSDK.AFAdRevenueData.put("wait_cid", Boolean.toString(true));
            }
            HashMap hashMap2 = new HashMap(this.AFInAppEventType.getMonetizationNetwork);
            this.AFInAppEventType.getCurrencyIso4217Code.getMonetizationNetwork("ddl");
            if (!hashMap2.isEmpty()) {
                map.put("ddl", hashMap2);
            }
            HashMap hashMap3 = new HashMap(this.AFInAppEventType.AFAdRevenueData);
            if (!hashMap3.isEmpty()) {
                map.put("first_launch", hashMap3);
            }
            AFh1uSDK aFh1uSDK3 = this.AFKeystoreWrapper;
            if (aFh1uSDK3 != null) {
                aFh1uSDK3.getCurrencyIso4217Code(aFh1rSDK);
            }
        } else if (i == 2) {
            HashMap hashMap4 = new HashMap(this.AFInAppEventType.AFAdRevenueData);
            if (!hashMap4.isEmpty()) {
                map.put("first_launch", hashMap4);
            }
            this.AFInAppEventType.getCurrencyIso4217Code.getMonetizationNetwork("first_launch");
            if ((aFh1rSDK instanceof AFh1kSDK) && (aFh1uSDK2 = this.AFKeystoreWrapper) != null && !aFh1uSDK2.getMonetizationNetwork()) {
                this.AFKeystoreWrapper.getMediationNetwork(aFh1rSDK);
            }
        }
        if (map.isEmpty()) {
            aFh1rSDK.AFAdRevenueData.remove("meta");
        }
        if (i <= 2) {
            ArrayList arrayList = new ArrayList();
            for (AFj1qSDK aFj1qSDK : this.equals.getRevenue()) {
                boolean z = aFj1qSDK instanceof AFi1aSDK;
                int i3 = AnonymousClass1.AFAdRevenueData[aFj1qSDK.component4.ordinal()];
                if (i3 == 1) {
                    if (z) {
                        aFh1rSDK.getMediationNetwork("rfr", ((AFi1aSDK) aFj1qSDK).getCurrencyIso4217Code);
                        this.hashCode.getCurrencyIso4217Code(AppsFlyerProperties.NEW_REFERRER_SENT, true);
                    }
                    arrayList.add(aFj1qSDK.AFAdRevenueData);
                } else if (i3 == 2 && i == 2 && !z) {
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("source", aFj1qSDK.component2);
                    hashMap5.put("response", "TIMEOUT");
                    hashMap5.put("type", aFj1qSDK.areAllFieldsValid);
                    arrayList.add(hashMap5);
                }
            }
            if (!arrayList.isEmpty()) {
                aFh1rSDK.getMediationNetwork("referrers", arrayList);
            }
            Map<String, Object> map2 = this.copydefault;
            if (map2 != null) {
                aFh1rSDK.getMediationNetwork("fb_ddl", map2);
            }
        }
        if (aFh1rSDK.getCurrencyIso4217Code() == AFe1mSDK.LAUNCH && (aFh1uSDK = this.AFKeystoreWrapper) != null && aFh1uSDK.getRevenue()) {
            this.AFKeystoreWrapper.getMonetizationNetwork(aFh1rSDK);
        }
        this.toString.getCurrencyIso4217Code(aFh1rSDK);
    }

    public boolean getMediationNetwork() {
        if (super.getMediationNetwork() || equals()) {
            return true;
        }
        return false;
    }

    public final void getRevenue() {
        super.getRevenue();
        AFh1vSDK aFh1vSDK = this.AFInAppEventType;
        int i = this.component2.component2;
        long currentTimeMillis = System.currentTimeMillis();
        if (i == 1) {
            long j = aFh1vSDK.areAllFieldsValid;
            if (j != 0) {
                aFh1vSDK.AFAdRevenueData.put("net", Long.valueOf(currentTimeMillis - j));
                aFh1vSDK.getCurrencyIso4217Code.getMediationNetwork("first_launch", new JSONObject(aFh1vSDK.AFAdRevenueData).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: launch start ts is missing");
        }
    }

    public void AFAdRevenueData(int i) {
        this.AFInAppEventType.getCurrencyIso4217Code(i);
    }
}
