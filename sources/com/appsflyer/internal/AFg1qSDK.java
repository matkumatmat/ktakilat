package com.appsflyer.internal;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AFg1qSDK {
    long AFAdRevenueData();

    void AFAdRevenueData(@NotNull AFh1rSDK aFh1rSDK);

    void AFAdRevenueData(@NotNull Map<String, Object> map);

    @Nullable
    Long getCurrencyIso4217Code();

    void getCurrencyIso4217Code(@NotNull AFh1rSDK aFh1rSDK);

    void getCurrencyIso4217Code(@NotNull Map<String, Object> map);

    void getMediationNetwork(@NotNull AFh1rSDK aFh1rSDK);

    void getMonetizationNetwork(@NotNull AFh1rSDK aFh1rSDK);

    void getRevenue(@NotNull AFh1rSDK aFh1rSDK);

    void getRevenue(@NotNull Map<String, Object> map);

    void getRevenue(@NotNull Map<String, Object> map, int i, int i2);
}
