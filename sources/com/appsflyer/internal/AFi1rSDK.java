package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFi1rSDK {
    @Nullable
    public final String AFAdRevenueData;
    @NotNull
    public final String getCurrencyIso4217Code;
    private final boolean getMonetizationNetwork;
    @Nullable
    public final String getRevenue;

    public AFi1rSDK(@NotNull String str, @Nullable String str2, @Nullable String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getCurrencyIso4217Code = str;
        this.getRevenue = str2;
        this.AFAdRevenueData = str3;
        this.getMonetizationNetwork = z;
    }

    public final boolean getMediationNetwork() {
        return this.getMonetizationNetwork;
    }
}
