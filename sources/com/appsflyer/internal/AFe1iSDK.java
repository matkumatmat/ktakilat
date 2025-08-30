package com.appsflyer.internal;

import com.appsflyer.PurchaseHandler;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AFe1iSDK extends AFe1gSDK {
    @Nullable
    private final PurchaseHandler.PurchaseValidationCallback component2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFe1iSDK(@NotNull AFe1mSDK aFe1mSDK, @NotNull AFe1mSDK[] aFe1mSDKArr, @NotNull AFc1dSDK aFc1dSDK, @NotNull Map<String, ? extends Object> map, @Nullable PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        super(aFe1mSDK, aFe1mSDKArr, aFc1dSDK, (String) null, map);
        Intrinsics.checkNotNullParameter(aFe1mSDK, "");
        Intrinsics.checkNotNullParameter(aFe1mSDKArr, "");
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.component2 = purchaseValidationCallback;
    }

    @Nullable
    public final String AFAdRevenueData(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        if (map.containsKey("billing_library_version")) {
            Object remove = map.remove("billing_library_version");
            if (remove instanceof String) {
                return (String) remove;
            }
        }
        return null;
    }

    public final boolean component1() {
        return true;
    }

    public boolean getMediationNetwork() {
        AFd1aSDK<Result> aFd1aSDK = this.component1;
        if (aFd1aSDK != null) {
            Intrinsics.c(aFd1aSDK);
            if (aFd1aSDK.getStatusCode() == 503) {
                return true;
            }
        }
        return super.getMediationNetwork();
    }

    @Nullable
    public final String getMonetizationNetwork(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        if (map.containsKey("connector_version")) {
            Object remove = map.remove("connector_version");
            if (remove instanceof String) {
                return (String) remove;
            }
        }
        return null;
    }

    public final void getRevenue() {
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback;
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback2;
        super.getRevenue();
        Throwable component4 = component4();
        if (!(component4 == null || (purchaseValidationCallback2 = this.component2) == null)) {
            purchaseValidationCallback2.onFailure(component4);
        }
        AFd1aSDK<Result> aFd1aSDK = this.component1;
        if (aFd1aSDK != null && (purchaseValidationCallback = this.component2) != null) {
            purchaseValidationCallback.onResponse(aFd1aSDK);
        }
    }
}
