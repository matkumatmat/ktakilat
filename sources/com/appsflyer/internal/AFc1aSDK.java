package com.appsflyer.internal;

import androidx.annotation.WorkerThread;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AFc1aSDK {
    @WorkerThread
    @Nullable
    String AFAdRevenueData(@NotNull Throwable th, @NotNull String str);

    @WorkerThread
    void AFAdRevenueData(int i, int i2);

    @WorkerThread
    int getCurrencyIso4217Code();

    @NotNull
    @WorkerThread
    List<AFc1cSDK> getMediationNetwork();

    @WorkerThread
    boolean getMonetizationNetwork();

    @WorkerThread
    boolean getRevenue(@NotNull String... strArr);
}
