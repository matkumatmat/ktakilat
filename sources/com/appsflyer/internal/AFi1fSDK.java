package com.appsflyer.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AFi1fSDK {
    void AFAdRevenueData(@NotNull AFi1cSDK aFi1cSDK);

    boolean AFAdRevenueData();

    @Nullable
    AFi1hSDK getCurrencyIso4217Code();

    boolean getMediationNetwork();
}
