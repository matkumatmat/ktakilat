package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.PurchaseHandler;
import java.util.Map;

public final class AFe1cSDK extends AFe1iSDK {
    public AFe1cSDK(@NonNull Map<String, Object> map, @Nullable PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback, @NonNull AFc1dSDK aFc1dSDK) {
        super(AFe1mSDK.PURCHASE_VALIDATE, new AFe1mSDK[]{AFe1mSDK.RC_CDN, AFe1mSDK.FETCH_ADVERTISING_ID}, aFc1dSDK, map, purchaseValidationCallback);
        this.AFAdRevenueData.add(AFe1mSDK.CONVERSION);
    }

    @Nullable
    public final AFd1nSDK<String> AFAdRevenueData(@NonNull Map<String, Object> map, @NonNull String str, @Nullable String str2) {
        return this.component4.getCurrencyIso4217Code(map, str, str2);
    }
}
