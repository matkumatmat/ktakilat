package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class AFi1vSDK {
    @NonNull
    public final String AFAdRevenueData;
    @Nullable
    public final Throwable component1;
    @Nullable
    public final String component3;
    @Nullable
    public final AFi1ySDK component4;
    @Nullable
    public final String getCurrencyIso4217Code;
    public final long getMediationNetwork;
    public final int getMonetizationNetwork;
    public final long getRevenue;

    public AFi1vSDK(@Nullable String str, @NonNull String str2, long j, long j2, int i, @Nullable AFi1ySDK aFi1ySDK, @Nullable String str3, Throwable th) {
        this.getCurrencyIso4217Code = str;
        this.AFAdRevenueData = str2;
        this.getRevenue = j;
        this.getMediationNetwork = j2;
        this.getMonetizationNetwork = i;
        this.component4 = aFi1ySDK;
        this.component3 = str3;
        this.component1 = th;
    }
}
