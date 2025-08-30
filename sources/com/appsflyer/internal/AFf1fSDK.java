package com.appsflyer.internal;

import com.appsflyer.AppsFlyerConsent;
import com.appsflyer.AppsFlyerProperties;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class AFf1fSDK implements AFf1dSDK {
    @NotNull
    private final AFc1kSDK getCurrencyIso4217Code;
    @NotNull
    private final AFf1cSDK getMediationNetwork;
    @NotNull
    private final AppsFlyerProperties getRevenue;

    public AFf1fSDK(@NotNull AFf1cSDK aFf1cSDK, @NotNull AFc1kSDK aFc1kSDK, @NotNull AppsFlyerProperties appsFlyerProperties) {
        Intrinsics.checkNotNullParameter(aFf1cSDK, "");
        Intrinsics.checkNotNullParameter(aFc1kSDK, "");
        Intrinsics.checkNotNullParameter(appsFlyerProperties, "");
        this.getMediationNetwork = aFf1cSDK;
        this.getCurrencyIso4217Code = aFc1kSDK;
        this.getRevenue = appsFlyerProperties;
    }

    public final void AFAdRevenueData(@NotNull Map<String, Object> map, @NotNull AFe1mSDK aFe1mSDK) {
        boolean z;
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(aFe1mSDK, "");
        AFg1zSDK mediationNetwork = this.getMediationNetwork.getMediationNetwork();
        AppsFlyerConsent appsFlyerConsent = this.getCurrencyIso4217Code.component2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (appsFlyerConsent != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Boolean isUserSubjectToGDPR = appsFlyerConsent.isUserSubjectToGDPR();
            if (isUserSubjectToGDPR != null) {
                linkedHashMap2.put("gdpr_applies", isUserSubjectToGDPR);
            }
            Boolean hasConsentForDataUsage = appsFlyerConsent.getHasConsentForDataUsage();
            if (hasConsentForDataUsage != null) {
                linkedHashMap2.put("ad_user_data_enabled", hasConsentForDataUsage);
            }
            Boolean hasConsentForAdsPersonalization = appsFlyerConsent.getHasConsentForAdsPersonalization();
            if (hasConsentForAdsPersonalization != null) {
                linkedHashMap2.put("ad_personalization_enabled", hasConsentForAdsPersonalization);
            }
            Boolean hasConsentForAdStorage = appsFlyerConsent.getHasConsentForAdStorage();
            if (hasConsentForAdStorage != null) {
                linkedHashMap2.put("ad_storage_enabled", hasConsentForAdStorage);
            }
            linkedHashMap.put("manual", linkedHashMap2);
        }
        if (mediationNetwork != null) {
            if (appsFlyerConsent != null) {
                z = true;
            } else {
                z = false;
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap3.put("policy_version", Integer.valueOf(mediationNetwork.getMonetizationNetwork));
            linkedHashMap3.put("cmp_sdk_id", Integer.valueOf(mediationNetwork.getRevenue));
            linkedHashMap3.put("cmp_sdk_version", Integer.valueOf(mediationNetwork.AFAdRevenueData));
            if (z) {
                linkedHashMap3.put("gdpr_applies", -1);
                linkedHashMap3.put("tcstring", "");
            } else {
                linkedHashMap3.put("gdpr_applies", Integer.valueOf(mediationNetwork.getCurrencyIso4217Code));
                linkedHashMap3.put("tcstring", mediationNetwork.getMediationNetwork);
            }
            linkedHashMap.put("tcf", linkedHashMap3);
        }
        if (!linkedHashMap.isEmpty()) {
            map.put("consent_data", linkedHashMap);
        }
        if (aFe1mSDK == AFe1mSDK.CONVERSION && this.getRevenue.getString(AppsFlyerProperties.ENABLE_TCF_DATA_COLLECTION) != null) {
            Map<String, Object> revenue = AFa1tSDK.getRevenue(map);
            Intrinsics.checkNotNullExpressionValue(revenue, "");
            revenue.put("api", MapsKt.d(new Pair(AppsFlyerProperties.ENABLE_TCF_DATA_COLLECTION, this.getRevenue.getString(AppsFlyerProperties.ENABLE_TCF_DATA_COLLECTION))));
        }
    }
}
