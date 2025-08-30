package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFAdRevenueData;
import java.util.Map;

public final class AFh1lSDK extends AFh1rSDK {
    @Nullable
    public final Map<String, Object> copy;
    @NonNull
    public final AFAdRevenueData equals;

    public AFh1lSDK(@NonNull AFAdRevenueData aFAdRevenueData, @Nullable Map<String, Object> map) {
        super("adrevenue_generic", (String) null, Boolean.TRUE);
        this.equals = aFAdRevenueData;
        this.copy = map;
    }

    public final AFe1mSDK getCurrencyIso4217Code() {
        return AFe1mSDK.ADREVENUE;
    }
}
