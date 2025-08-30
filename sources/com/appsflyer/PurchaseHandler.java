package com.appsflyer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.internal.AFc1dSDK;
import com.appsflyer.internal.AFc1pSDK;
import com.appsflyer.internal.AFe1lSDK;
import com.appsflyer.internal.AFj1cSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.Map;

public final class PurchaseHandler {
    @NonNull
    public final AFc1dSDK getCurrencyIso4217Code;
    @NonNull
    private final AFc1pSDK getMediationNetwork;
    @NonNull
    public final AFe1lSDK getRevenue;

    public interface PurchaseValidationCallback {
        void onFailure(@NonNull Throwable th);

        void onResponse(@NonNull ResponseNetwork<String> responseNetwork);
    }

    public PurchaseHandler(@NonNull AFc1dSDK aFc1dSDK) {
        this.getCurrencyIso4217Code = aFc1dSDK;
        this.getMediationNetwork = aFc1dSDK.getRevenue();
        this.getRevenue = aFc1dSDK.copydefault();
    }

    public final boolean AFAdRevenueData(Map<String, Object> map, @Nullable PurchaseValidationCallback purchaseValidationCallback, String... strArr) {
        boolean mediationNetwork = AFj1cSDK.getMediationNetwork(map, strArr, this.getMediationNetwork);
        if (!mediationNetwork && purchaseValidationCallback != null) {
            purchaseValidationCallback.onFailure(new IllegalArgumentException("Invalid Request Data"));
        }
        return mediationNetwork;
    }
}
