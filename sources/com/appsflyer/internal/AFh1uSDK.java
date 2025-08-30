package com.appsflyer.internal;

import android.content.Intent;
import androidx.annotation.WorkerThread;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

public interface AFh1uSDK {
    void getCurrencyIso4217Code(@NotNull AFh1rSDK aFh1rSDK);

    void getMediationNetwork();

    @WorkerThread
    void getMediationNetwork(@NotNull AFh1rSDK aFh1rSDK);

    @WorkerThread
    void getMonetizationNetwork(@NotNull AFh1rSDK aFh1rSDK);

    boolean getMonetizationNetwork();

    @WorkerThread
    void getRevenue(@NotNull AFf1uSDK aFf1uSDK, @NotNull Function0<Unit> function0);

    boolean getRevenue();

    void u_(@NotNull Intent intent, @NotNull AFa1oSDK aFa1oSDK);
}
