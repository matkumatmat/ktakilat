package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public final class AFa1lSDK implements AFa1gSDK {
    @NotNull
    private final AFc1qSDK getMonetizationNetwork;

    public AFa1lSDK(@NotNull AFc1qSDK aFc1qSDK) {
        Intrinsics.checkNotNullParameter(aFc1qSDK, "");
        this.getMonetizationNetwork = aFc1qSDK;
    }

    @NotNull
    public final Map<String, Object> getCurrencyIso4217Code() {
        if (this.getMonetizationNetwork.getMediationNetwork("deeplink_data")) {
            try {
                String AFAdRevenueData = this.getMonetizationNetwork.AFAdRevenueData("deeplink_data", (String) null);
                if (AFAdRevenueData == null) {
                    return MapsKt.b();
                }
                return AFj1eSDK.getCurrencyIso4217Code(new JSONObject(AFAdRevenueData));
            } catch (Throwable th) {
                AFLogger.afErrorLog("Exception while parsing stored deeplink data", th, true, false);
            }
        }
        return MapsKt.b();
    }

    public final void getMediationNetwork(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.getMonetizationNetwork.getMediationNetwork("deeplink_data", new JSONObject(map).toString());
    }

    public final void getMonetizationNetwork() {
        this.getMonetizationNetwork.getMonetizationNetwork("deeplink_data");
    }
}
