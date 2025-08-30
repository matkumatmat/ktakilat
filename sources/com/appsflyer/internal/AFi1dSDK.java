package com.appsflyer.internal;

import com.appsflyer.AFLogger;

public abstract class AFi1dSDK extends AFj1qSDK {
    private AFc1pSDK getMediationNetwork;

    public AFi1dSDK(String str, String str2, AFc1pSDK aFc1pSDK, Runnable runnable) {
        super(str, str2, runnable);
        this.getMediationNetwork = aFc1pSDK;
    }

    public final boolean getRevenue() {
        if (this.getMediationNetwork.getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0) <= 0) {
            return true;
        }
        AFLogger.afRDLog("Install referrer will not load, the counter > 1, ");
        return false;
    }
}
