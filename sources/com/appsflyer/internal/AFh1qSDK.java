package com.appsflyer.internal;

import android.app.Activity;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFh1qSDK {
    @NotNull
    public final String getCurrencyIso4217Code;
    @Nullable
    public final String getMediationNetwork;
    @Nullable
    public final Intent getRevenue;

    public AFh1qSDK(@NotNull Activity activity, @NotNull AFi1kSDK aFi1kSDK) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(aFi1kSDK, "");
        this.getRevenue = activity.getIntent();
        this.getCurrencyIso4217Code = aFi1kSDK.getMonetizationNetwork(activity);
        this.getMediationNetwork = aFi1kSDK.getCurrencyIso4217Code(activity);
    }
}
