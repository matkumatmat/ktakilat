package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.PurchaseHandler;
import java.util.Map;

public final class AFe1hSDK extends AFe1iSDK {
    public AFe1hSDK(@NonNull Map<String, Object> map, @Nullable PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback, @NonNull AFc1dSDK aFc1dSDK) {
        super(AFe1mSDK.ARS_VALIDATE, new AFe1mSDK[]{AFe1mSDK.RC_CDN, AFe1mSDK.FETCH_ADVERTISING_ID}, aFc1dSDK, map, purchaseValidationCallback);
        this.AFAdRevenueData.add(AFe1mSDK.CONVERSION);
    }

    @Nullable
    public final AFd1nSDK<String> AFAdRevenueData(@NonNull Map<String, Object> map, @NonNull String str, @Nullable String str2) {
        return this.component4.AFAdRevenueData(map, str, str2);
    }

    public final boolean getMediationNetwork() {
        AFd1aSDK<Result> aFd1aSDK = this.component1;
        if (aFd1aSDK == null || aFd1aSDK.getStatusCode() != 424) {
            return super.getMediationNetwork();
        }
        return true;
    }
}
