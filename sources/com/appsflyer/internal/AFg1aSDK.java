package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFg1aSDK implements AFg1bSDK {
    @Nullable
    private AFh1zSDK AFAdRevenueData;
    @Nullable
    private AFh1wSDK getCurrencyIso4217Code;
    @Nullable
    private AFg1fSDK getMediationNetwork;
    @NotNull
    private final AFc1dSDK getRevenue;

    public AFg1aSDK(@NotNull AFc1dSDK aFc1dSDK) {
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        this.getRevenue = aFc1dSDK;
    }

    public final void AFAdRevenueData() {
        AFLogger aFLogger = AFLogger.INSTANCE;
        if (this.getCurrencyIso4217Code == null) {
            this.getCurrencyIso4217Code = new AFh1wSDK(this.getRevenue);
        }
        AFh1wSDK aFh1wSDK = this.getCurrencyIso4217Code;
        Intrinsics.c(aFh1wSDK);
        aFLogger.registerClient(aFh1wSDK);
    }

    public final void component4() {
        AFLogger aFLogger = AFLogger.INSTANCE;
        if (this.getMediationNetwork == null) {
            this.getMediationNetwork = new AFg1fSDK();
        }
        AFg1fSDK aFg1fSDK = this.getMediationNetwork;
        Intrinsics.c(aFg1fSDK);
        aFLogger.registerClient(aFg1fSDK);
    }

    public final void getCurrencyIso4217Code() {
        AFh1zSDK aFh1zSDK = this.AFAdRevenueData;
        if (aFh1zSDK != null) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1gSDK.v$default(aFLogger, AFg1cSDK.EXCEPTION_MANAGER, "Releasing Exception Manager Client", false, 4, (Object) null);
            aFLogger.unregisterClient(aFh1zSDK);
            this.AFAdRevenueData = null;
        }
    }

    public final void getMediationNetwork() {
        AFh1wSDK aFh1wSDK = this.getCurrencyIso4217Code;
        if (aFh1wSDK != null) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1gSDK.v$default(aFLogger, AFg1cSDK.RD, "Releasing Proxy Manager Client", false, 4, (Object) null);
            aFLogger.unregisterClient(aFh1wSDK);
            this.getCurrencyIso4217Code = null;
        }
    }

    public final void getMonetizationNetwork() {
        AFg1fSDK aFg1fSDK = this.getMediationNetwork;
        if (aFg1fSDK != null) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1gSDK.v$default(aFLogger, AFg1cSDK.RD, "Releasing Proxy Manager Client", false, 4, (Object) null);
            aFLogger.unregisterClient(aFg1fSDK);
            this.getMediationNetwork = null;
        }
    }

    public final void getRevenue() {
        AFLogger aFLogger = AFLogger.INSTANCE;
        if (this.AFAdRevenueData == null) {
            this.AFAdRevenueData = new AFh1zSDK(this.getRevenue);
        }
        AFh1zSDK aFh1zSDK = this.AFAdRevenueData;
        Intrinsics.c(aFh1zSDK);
        aFLogger.registerClient(aFh1zSDK);
    }
}
