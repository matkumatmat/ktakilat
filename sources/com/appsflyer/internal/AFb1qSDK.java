package com.appsflyer.internal;

import java.util.HashMap;
import java.util.Map;

public final class AFb1qSDK {
    public Map<String, Object> AFAdRevenueData = new HashMap();
    public final Map<String, Object> getCurrencyIso4217Code = new HashMap();

    public final void getRevenue(Map<String, Object> map) {
        if (!this.getCurrencyIso4217Code.isEmpty()) {
            map.put("partner_data", this.getCurrencyIso4217Code);
        }
        if (!this.AFAdRevenueData.isEmpty()) {
            AFa1tSDK.getRevenue(map).put("partner_data", this.AFAdRevenueData);
            this.AFAdRevenueData = new HashMap();
        }
    }
}
