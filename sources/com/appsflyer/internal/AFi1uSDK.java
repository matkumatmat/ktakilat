package com.appsflyer.internal;

import androidx.annotation.NonNull;

public final class AFi1uSDK {
    @NonNull
    public final AFi1ySDK AFAdRevenueData;
    private boolean getMonetizationNetwork;

    public AFi1uSDK(boolean z, @NonNull AFi1ySDK aFi1ySDK) {
        this.getMonetizationNetwork = z;
        this.AFAdRevenueData = aFi1ySDK;
    }

    public final boolean getRevenue() {
        return this.getMonetizationNetwork;
    }
}
