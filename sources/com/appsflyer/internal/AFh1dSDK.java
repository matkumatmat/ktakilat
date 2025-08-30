package com.appsflyer.internal;

import org.json.JSONException;
import org.json.JSONObject;

public final class AFh1dSDK {
    public final int AFAdRevenueData;
    public final int getCurrencyIso4217Code;
    public final long getMediationNetwork;
    public final String getRevenue;

    public AFh1dSDK(String str, int i, int i2, long j) {
        this.getRevenue = str;
        this.getCurrencyIso4217Code = i;
        this.AFAdRevenueData = i2;
        this.getMediationNetwork = j;
    }

    public final boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (obj != null && AFh1dSDK.class == obj.getClass()) {
            AFh1dSDK aFh1dSDK = (AFh1dSDK) obj;
            if (this.getCurrencyIso4217Code == aFh1dSDK.getCurrencyIso4217Code && this.AFAdRevenueData == aFh1dSDK.AFAdRevenueData && this.getMediationNetwork == aFh1dSDK.getMediationNetwork && (str = this.getRevenue) != null && str.equals(aFh1dSDK.getRevenue)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final String getMonetizationNetwork() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_ver", this.getRevenue);
            jSONObject.put("min", this.getCurrencyIso4217Code);
            jSONObject.put("expire", this.AFAdRevenueData);
            jSONObject.put("ttl", this.getMediationNetwork);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final int hashCode() {
        int i;
        String str = this.getRevenue;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return (((((i * 31) + this.getCurrencyIso4217Code) * 31) + this.AFAdRevenueData) * 31) + ((int) this.getMediationNetwork);
    }
}
