package com.appsflyer.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFf1bSDK implements AFf1cSDK {
    @NotNull
    private final AppsFlyerProperties AFAdRevenueData;
    @NotNull
    private final Context getMonetizationNetwork;

    public AFf1bSDK(@NotNull Context context, @NotNull AppsFlyerProperties appsFlyerProperties) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(appsFlyerProperties, "");
        this.getMonetizationNetwork = context;
        this.AFAdRevenueData = appsFlyerProperties;
    }

    @Nullable
    public final AFg1zSDK getMediationNetwork() {
        if (!Boolean.parseBoolean(this.AFAdRevenueData.getString(AppsFlyerProperties.ENABLE_TCF_DATA_COLLECTION))) {
            return null;
        }
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.getMonetizationNetwork);
            int i = defaultSharedPreferences.getInt("IABTCF_gdprApplies", -1);
            int i2 = defaultSharedPreferences.getInt("IABTCF_CmpSdkID", -1);
            int i3 = defaultSharedPreferences.getInt("IABTCF_PolicyVersion", -1);
            int i4 = defaultSharedPreferences.getInt("IABTCF_CmpSdkVersion", -1);
            String str = "";
            if (i == 1) {
                String string = defaultSharedPreferences.getString("IABTCF_TCString", str);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, str);
                    str = string;
                }
            }
            return new AFg1zSDK(i3, i, i2, i4, str);
        } catch (Exception e) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.DMA, "TCF data collection exception", e, false, false, false, false, 120, (Object) null);
            return null;
        }
    }
}
