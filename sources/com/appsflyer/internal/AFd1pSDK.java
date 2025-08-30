package com.appsflyer.internal;

import android.content.pm.PackageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AFd1pSDK {
    void AFAdRevenueData();

    boolean component4();

    void getCurrencyIso4217Code();

    void getCurrencyIso4217Code(@Nullable String str, @NotNull String str2);

    void getMediationNetwork();

    void getMediationNetwork(@NotNull String str, @NotNull String... strArr);

    void getMonetizationNetwork(@NotNull String str, @NotNull String str2);

    void getMonetizationNetwork(@NotNull Throwable th);

    boolean getMonetizationNetwork();

    void getRevenue();

    void getRevenue(@NotNull String str, int i, @NotNull String str2);

    void o_(@Nullable String str, @Nullable PackageManager packageManager);
}
