package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFi1wSDK {
    @NonNull
    public final AFh1aSDK AFAdRevenueData;
    @NonNull
    public final String getCurrencyIso4217Code;
    private final boolean getMediationNetwork;
    @Nullable
    public final AFh1cSDK getMonetizationNetwork;
    @NonNull
    public final String getRevenue;

    public AFi1wSDK(@NonNull String str) throws JSONException {
        AFh1aSDK aFh1aSDK;
        AFh1cSDK aFh1cSDK;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("ver");
                this.getRevenue = string;
                this.getMediationNetwork = jSONObject.optBoolean("test_mode");
                this.getCurrencyIso4217Code = str;
                if (string.startsWith("default")) {
                    aFh1aSDK = AFh1aSDK.DEFAULT;
                } else {
                    aFh1aSDK = AFh1aSDK.CUSTOM;
                }
                this.AFAdRevenueData = aFh1aSDK;
                JSONObject optJSONObject = jSONObject.optJSONObject("features");
                if (optJSONObject != null) {
                    aFh1cSDK = new AFh1cSDK(optJSONObject);
                } else {
                    aFh1cSDK = null;
                }
                this.getMonetizationNetwork = aFh1cSDK;
            } catch (JSONException e) {
                AFLogger.afErrorLogForExcManagerOnly("Error in RC config parsing", e);
                throw new JSONException("Failed to parse remote configuration JSON");
            }
        } else {
            throw new JSONException("Failed to parse remote configuration JSON: originalJson is null");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AFi1wSDK.class != obj.getClass()) {
            return false;
        }
        AFi1wSDK aFi1wSDK = (AFi1wSDK) obj;
        if (this.getMediationNetwork == aFi1wSDK.getMediationNetwork && this.getRevenue.equals(aFi1wSDK.getRevenue)) {
            return this.getCurrencyIso4217Code.equals(aFi1wSDK.getCurrencyIso4217Code);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.getRevenue.hashCode();
        int hashCode2 = this.getCurrencyIso4217Code.hashCode() + ((hashCode + ((this.getMediationNetwork ? 1 : 0) * true)) * 31);
        AFh1cSDK aFh1cSDK = this.getMonetizationNetwork;
        if (aFh1cSDK != null) {
            return (hashCode2 * 31) + aFh1cSDK.hashCode();
        }
        return hashCode2;
    }
}
