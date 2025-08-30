package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.appsflyer.internal.AFb1bSDK;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFb1aSDK implements AFb1bSDK {
    @Nullable
    private AFb1lSDK AFAdRevenueData;
    @NotNull
    private final ScheduledExecutorService getCurrencyIso4217Code;
    @NotNull
    private final AFa1oSDK getMediationNetwork;
    @NotNull
    private final AFi1kSDK getMonetizationNetwork;
    @NotNull
    private final Executor getRevenue;

    public AFb1aSDK(@NotNull Executor executor, @NotNull ScheduledExecutorService scheduledExecutorService, @NotNull AFa1oSDK aFa1oSDK, @NotNull AFi1kSDK aFi1kSDK) {
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "");
        Intrinsics.checkNotNullParameter(aFa1oSDK, "");
        Intrinsics.checkNotNullParameter(aFi1kSDK, "");
        this.getRevenue = executor;
        this.getCurrencyIso4217Code = scheduledExecutorService;
        this.getMediationNetwork = aFa1oSDK;
        this.getMonetizationNetwork = aFi1kSDK;
    }

    public final void AFAdRevenueData(@NotNull Context context, @NotNull AFb1bSDK.AFa1zSDK aFa1zSDK) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(aFa1zSDK, "");
        Intrinsics.checkNotNullParameter(context, "");
        if (this.AFAdRevenueData != null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.d(applicationContext, "");
            ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this.AFAdRevenueData);
        }
        this.AFAdRevenueData = null;
        AFb1lSDK aFb1lSDK = new AFb1lSDK(this.getRevenue, this.getCurrencyIso4217Code, this.getMediationNetwork, this.getMonetizationNetwork, aFa1zSDK);
        this.AFAdRevenueData = aFb1lSDK;
        if (context instanceof Activity) {
            aFb1lSDK.onActivityResumed((Activity) context);
        }
        Application O_ = AFj1iSDK.O_(context);
        if (O_ != null) {
            O_.registerActivityLifecycleCallbacks(this.AFAdRevenueData);
        }
    }

    public final boolean getCurrencyIso4217Code() {
        if (this.AFAdRevenueData != null) {
            return true;
        }
        return false;
    }

    public final void AFAdRevenueData() {
        AFb1bSDK.AFa1zSDK aFa1zSDK;
        AFb1lSDK aFb1lSDK = this.AFAdRevenueData;
        if (aFb1lSDK != null && (aFa1zSDK = aFb1lSDK.getCurrencyIso4217Code) != null) {
            aFa1zSDK.getCurrencyIso4217Code();
        }
    }
}
