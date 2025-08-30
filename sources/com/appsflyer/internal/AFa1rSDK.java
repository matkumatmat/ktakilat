package com.appsflyer.internal;

import com.appsflyer.deeplink.DeepLink;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

public final class AFa1rSDK implements AFe1ySDK<AFa1mSDK> {
    public final /* synthetic */ Object getMonetizationNetwork(String str) {
        JSONObject optJSONObject;
        DeepLink deepLink = null;
        if (str == null || str.length() == 0) {
            return new AFa1mSDK(false, (DeepLink) null, 3, (DefaultConstructorMarker) null);
        }
        JSONObject jSONObject = new JSONObject(str);
        boolean optBoolean = jSONObject.optBoolean("found", false);
        boolean optBoolean2 = jSONObject.optBoolean("is_second_ping", true);
        if (optBoolean && (optJSONObject = jSONObject.optJSONObject("click_event")) != null) {
            deepLink = DeepLink.getRevenue(optJSONObject);
            deepLink.getCurrencyIso4217Code.put("is_deferred", true);
        }
        return new AFa1mSDK(optBoolean2, deepLink);
    }
}
