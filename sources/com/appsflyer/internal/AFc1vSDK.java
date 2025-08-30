package com.appsflyer.internal;

import androidx.annotation.WorkerThread;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AFc1vSDK {
    @WorkerThread
    @Nullable
    String AFAdRevenueData(@NotNull AFc1rSDK aFc1rSDK);

    void AFAdRevenueData();

    @WorkerThread
    boolean AFAdRevenueData(@Nullable String str);

    @WorkerThread
    void getMediationNetwork();

    @NotNull
    @WorkerThread
    List<AFc1rSDK> getRevenue();
}
