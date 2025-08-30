package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.appsflyer.PurchaseHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public interface AFc1dSDK {
    @NonNull
    ScheduledExecutorService AFAdRevenueData();

    @NonNull
    AFc1vSDK AFInAppEventParameterName();

    @NonNull
    AFc1iSDK AFInAppEventType();

    @NonNull
    AFe1zSDK AFKeystoreWrapper();

    @NonNull
    AFj1sSDK AFLogger();

    @NonNull
    AFb1bSDK afDebugLog();

    @NonNull
    AFf1dSDK afErrorLog();

    @Nullable
    AFh1uSDK afErrorLogForExcManagerOnly();

    @NonNull
    AFc1kSDK afInfoLog();

    @NonNull
    AFd1vSDK afRDLog();

    @NonNull
    AFa1gSDK afVerboseLog();

    @NonNull
    AFb1hSDK afWarnLog();

    @NonNull
    AFh1vSDK areAllFieldsValid();

    @NonNull
    AFf1oSDK component1();

    @NonNull
    AFc1qSDK component2();

    @NonNull
    AFg1qSDK component3();

    @NonNull
    PurchaseHandler component4();

    @NonNull
    AFd1pSDK copy();

    @NonNull
    AFe1lSDK copydefault();

    @NonNull
    AFa1oSDK d();

    @NonNull
    AFa1aSDK e();

    @NonNull
    AFj1lSDK equals();

    @WorkerThread
    @Nullable
    AFi1fSDK force();

    @NonNull
    AFd1oSDK getCurrencyIso4217Code();

    @NonNull
    AFe1uSDK getMediationNetwork();

    @NonNull
    ExecutorService getMonetizationNetwork();

    @NonNull
    AFc1pSDK getRevenue();

    @NonNull
    AFi1tSDK i();

    @NonNull
    AFf1gSDK registerClient();

    @NonNull
    AFi1lSDK unregisterClient();

    @NonNull
    AFg1bSDK v();

    @NonNull
    AFi1kSDK w();
}
