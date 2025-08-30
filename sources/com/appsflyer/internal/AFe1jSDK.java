package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.google.common.net.HttpHeaders;

public final class AFe1jSDK extends AFe1dSDK<String> {
    @NonNull
    private final String component2;
    private final AFc1pSDK copy;
    @Nullable
    private final AFk1rSDK toString;

    public AFe1jSDK(@NonNull AFc1dSDK aFc1dSDK, @NonNull String str, @Nullable AFk1rSDK aFk1rSDK) {
        super(AFe1mSDK.IMPRESSIONS, new AFe1mSDK[]{AFe1mSDK.RC_CDN, AFe1mSDK.FETCH_ADVERTISING_ID}, aFc1dSDK, str);
        this.component2 = str;
        this.toString = aFk1rSDK;
        this.copy = aFc1dSDK.getRevenue();
    }

    @Nullable
    public final AppsFlyerRequestListener component3() {
        return null;
    }

    public final boolean copydefault() {
        return false;
    }

    public final boolean getMediationNetwork() {
        return false;
    }

    public final AFd1nSDK<String> getRevenue(@NonNull String str) {
        String str2;
        AFd1oSDK aFd1oSDK = this.component4;
        String AFAdRevenueData = this.copy.AFAdRevenueData();
        if (AFk1ySDK.getMediationNetwork(AFAdRevenueData)) {
            str2 = this.component2;
        } else {
            str2 = Uri.parse(this.component2).buildUpon().appendQueryParameter("advertising_id", AFAdRevenueData).build().toString();
        }
        return aFd1oSDK.getRevenue(str2);
    }

    public final void getRevenue() {
        super.getRevenue();
        AFd1aSDK<Result> aFd1aSDK = this.component1;
        if (aFd1aSDK != null) {
            int statusCode = aFd1aSDK.getStatusCode();
            if (statusCode == 200) {
                StringBuilder sb = new StringBuilder("Cross promotion impressions success: ");
                sb.append(this.component2);
                AFLogger.afInfoLog(sb.toString(), false);
            } else if (statusCode == 301 || statusCode == 302) {
                StringBuilder sb2 = new StringBuilder("Cross promotion redirection success: ");
                sb2.append(this.component2);
                AFLogger.afInfoLog(sb2.toString(), false);
                String currencyIso4217Code = aFd1aSDK.getCurrencyIso4217Code(HttpHeaders.LOCATION);
                AFk1rSDK aFk1rSDK = this.toString;
                if (aFk1rSDK != null && currencyIso4217Code != null) {
                    aFk1rSDK.getMonetizationNetwork = currencyIso4217Code;
                    Context context = aFk1rSDK.AFAdRevenueData.get();
                    if (context != null) {
                        try {
                            if (aFk1rSDK.getMonetizationNetwork != null) {
                                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(aFk1rSDK.getMonetizationNetwork)).setFlags(268435456));
                            }
                        } catch (Exception e) {
                            AFLogger.afErrorLog("Failed to open cross promotion url, does OS have browser installed?".concat(String.valueOf(e)), e);
                        }
                    }
                }
            } else {
                StringBuilder sb3 = new StringBuilder("call to ");
                sb3.append(this.component2);
                sb3.append(" failed: ");
                sb3.append(statusCode);
                AFLogger.afInfoLog(sb3.toString());
            }
        }
    }
}
