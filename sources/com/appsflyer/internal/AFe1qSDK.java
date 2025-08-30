package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

public interface AFe1qSDK {
    @WorkerThread
    void getCurrencyIso4217Code(@NonNull AFe1sSDK<?> aFe1sSDK, @NonNull AFe1rSDK aFe1rSDK);

    @WorkerThread
    void getMediationNetwork(@NonNull AFe1sSDK<?> aFe1sSDK);

    @WorkerThread
    void getMonetizationNetwork(@NonNull AFe1sSDK<?> aFe1sSDK);
}
