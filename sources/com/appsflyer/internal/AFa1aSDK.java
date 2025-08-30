package com.appsflyer.internal;

import java.util.Map;
import org.jetbrains.annotations.Nullable;

public interface AFa1aSDK {
    void getCurrencyIso4217Code(boolean z);

    boolean getCurrencyIso4217Code();

    @Nullable
    Map<String, Object> getMonetizationNetwork();

    void getRevenue();
}
