package com.appsflyer.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class AFc1pSDK {
    private static String AFAdRevenueData = "348";
    private Bundle component1 = null;
    private final Executor component3;
    public final AFc1kSDK getCurrencyIso4217Code;
    public String getMediationNetwork = "";
    public final AFc1qSDK getMonetizationNetwork;
    public final AFc1iSDK getRevenue;

    public AFc1pSDK(AFc1iSDK aFc1iSDK, AFc1qSDK aFc1qSDK, AFc1kSDK aFc1kSDK, Executor executor) {
        this.getRevenue = aFc1iSDK;
        this.getMonetizationNetwork = aFc1qSDK;
        this.getCurrencyIso4217Code = aFc1kSDK;
        this.component3 = executor;
    }

    public static boolean AFAdRevenueData(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.INSTANCE.e(AFg1cSDK.PUBLIC_API, "Could not check if app is pre installed", e);
        }
    }

    public static String component1() {
        StringBuilder sb = new StringBuilder("version: 6.17.0 (build ");
        sb.append(AFAdRevenueData);
        sb.append(")");
        return sb.toString();
    }

    public static String getCurrencyIso4217Code() {
        return AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
    }

    public static String getMediationNetwork() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @NonNull
    public static String getMonetizationNetwork() {
        return "6.17.0";
    }

    @NonNull
    public static String getRevenue() {
        return UUID.randomUUID().toString();
    }

    @Nullable
    public final String component2() {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.CHANNEL);
        if (string == null) {
            string = getCurrencyIso4217Code("CHANNEL");
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }

    public final boolean component4() {
        if (!this.getCurrencyIso4217Code.getMonetizationNetwork()) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getCurrencyIso4217Code(String str) {
        Object obj;
        try {
            if (this.component1 == null) {
                this.component1 = this.getRevenue.getMonetizationNetwork.getPackageManager().getApplicationInfo(this.getRevenue.getMonetizationNetwork.getPackageName(), 128).metaData;
            }
            Bundle bundle = this.component1;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Could not load manifest metadata!");
            sb.append(th.getMessage());
            AFLogger.afErrorLog(sb.toString(), th);
            return null;
        }
    }

    public final boolean getMonetizationNetwork(String str, boolean z) {
        String currencyIso4217Code = getCurrencyIso4217Code(str);
        return currencyIso4217Code != null ? Boolean.parseBoolean(currencyIso4217Code) : z;
    }

    @SuppressLint({"DiscouragedApi"})
    @Nullable
    public final String getRevenue(String str) {
        try {
            int identifier = this.getRevenue.getMonetizationNetwork.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, this.getRevenue.getMonetizationNetwork.getPackageName());
            if (identifier != 0) {
                return this.getRevenue.getMonetizationNetwork.getString(identifier);
            }
            return null;
        } catch (Resources.NotFoundException e) {
            StringBuilder sb = new StringBuilder("Could not load string resource!");
            sb.append(e.getMessage());
            AFLogger.afErrorLog(sb.toString(), e);
            return null;
        }
    }

    @Nullable
    public final String AFAdRevenueData() {
        AFh1oSDK aFh1oSDK = this.getCurrencyIso4217Code.component3;
        AFb1mSDK aFb1mSDK = aFh1oSDK != null ? new AFb1mSDK(aFh1oSDK.AFAdRevenueData, aFh1oSDK.getRevenue) : null;
        if (aFb1mSDK != null) {
            return aFb1mSDK.getMonetizationNetwork;
        }
        return null;
    }

    public final String getCurrencyIso4217Code(Context context) {
        try {
            return new AFb1kSDK(context, this.component3).getRevenue();
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.PUBLIC_API, "Exception while collecting facebook's attribution ID. ", th, true, false, false);
            return null;
        }
    }
}
