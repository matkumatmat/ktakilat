package com.appsflyer.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFi1oSDK implements AFi1kSDK {
    @Nullable
    private String getRevenue;

    private static String AFAdRevenueData(Activity activity) {
        Intent intent;
        String str;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        Uri j_ = AFb1rSDK.j_(intent);
        if (j_ != null) {
            str = j_.toString();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (getRevenue(str)) {
            return null;
        }
        return str;
    }

    private static boolean getRevenue(String str) {
        return StringsKt.I(str, "android-app://", false);
    }

    @Nullable
    public final String getCurrencyIso4217Code(@Nullable Activity activity) {
        String str = this.getRevenue;
        this.getRevenue = null;
        if (str == null || str.length() == 0) {
            return AFAdRevenueData(activity);
        }
        return str;
    }

    public final void getMediationNetwork(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        String str = this.getRevenue;
        if (str == null || str.length() == 0) {
            this.getRevenue = AFAdRevenueData(activity);
        }
    }

    @NotNull
    public final String getMonetizationNetwork(@Nullable Activity activity) {
        Uri uri;
        String str = null;
        if (activity == null || activity.getIntent() == null) {
            uri = null;
        } else if (Build.VERSION.SDK_INT >= 22) {
            uri = activity.getReferrer();
        } else {
            uri = AFb1rSDK.j_(activity.getIntent());
        }
        if (uri != null) {
            str = uri.toString();
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
