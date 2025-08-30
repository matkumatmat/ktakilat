package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class AFh1vSDK {
    public final Map<String, Object> AFAdRevenueData;
    public long areAllFieldsValid = 0;
    public final long[] component1 = new long[2];
    public final long[] component2 = new long[2];
    public long component3 = 0;
    public final long[] component4 = new long[2];
    public long equals = 0;
    public final AFc1qSDK getCurrencyIso4217Code;
    public long getMediationNetwork = 0;
    public final Map<String, Object> getMonetizationNetwork;
    public final Map<String, Object> getRevenue;
    public long toString;

    public AFh1vSDK(AFc1qSDK aFc1qSDK) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.AFAdRevenueData = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        this.getMonetizationNetwork = concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
        this.getRevenue = concurrentHashMap3;
        this.getCurrencyIso4217Code = aFc1qSDK;
        concurrentHashMap.putAll(getCurrencyIso4217Code("first_launch"));
        concurrentHashMap2.putAll(getCurrencyIso4217Code("ddl"));
        concurrentHashMap3.putAll(getCurrencyIso4217Code("gcd"));
        this.toString = aFc1qSDK.getCurrencyIso4217Code("prev_session_dur", 0);
    }

    public final void AFAdRevenueData() {
        this.component3 = System.currentTimeMillis();
        if (getCurrencyIso4217Code()) {
            long j = this.getMediationNetwork;
            if (j != 0) {
                this.AFAdRevenueData.put("init_to_fg", Long.valueOf(this.component3 - j));
                this.getCurrencyIso4217Code.getMediationNetwork("first_launch", new JSONObject(this.AFAdRevenueData).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: init ts is missing");
        }
    }

    public final void getCurrencyIso4217Code(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        this.areAllFieldsValid = currentTimeMillis;
        if (i == 1) {
            long j = this.component3;
            if (j != 0) {
                this.AFAdRevenueData.put("from_fg", Long.valueOf(currentTimeMillis - j));
                this.getCurrencyIso4217Code.getMediationNetwork("first_launch", new JSONObject(this.AFAdRevenueData).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: fg ts is missing");
        }
    }

    public final void getMediationNetwork(AFh1tSDK aFh1tSDK) {
        if (getCurrencyIso4217Code()) {
            this.AFAdRevenueData.put("start_with", aFh1tSDK.toString());
            this.getCurrencyIso4217Code.getMediationNetwork("first_launch", new JSONObject(this.AFAdRevenueData).toString());
        }
    }

    public final void getMediationNetwork(DeepLinkResult deepLinkResult, long j) {
        this.getMonetizationNetwork.put("status", deepLinkResult.getStatus().toString());
        this.getMonetizationNetwork.put("timeout_value", Long.valueOf(j));
        this.getCurrencyIso4217Code.getMediationNetwork("ddl", new JSONObject(this.getMonetizationNetwork).toString());
    }

    private Map<String, Object> getCurrencyIso4217Code(String str) {
        Map<String, Object> emptyMap = Collections.emptyMap();
        String AFAdRevenueData2 = this.getCurrencyIso4217Code.AFAdRevenueData(str, (String) null);
        if (AFAdRevenueData2 == null) {
            return emptyMap;
        }
        try {
            return AFg1lSDK.getMonetizationNetwork(new JSONObject(AFAdRevenueData2));
        } catch (Exception e) {
            AFLogger.afErrorLog("Error while parsing cached json data", e, true);
            return emptyMap;
        }
    }

    public final void AFAdRevenueData(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.equals;
        if (j != 0) {
            this.getRevenue.put("net", Long.valueOf(currentTimeMillis - j));
        } else {
            AFLogger.afInfoLog("Metrics: gcdStart ts is missing");
        }
        this.getRevenue.put("retries", Integer.valueOf(i));
        this.getCurrencyIso4217Code.getMediationNetwork("gcd", new JSONObject(this.getRevenue).toString());
    }

    public final boolean getCurrencyIso4217Code() {
        return this.getCurrencyIso4217Code.AFAdRevenueData("appsFlyerCount", 0) == 0;
    }
}
