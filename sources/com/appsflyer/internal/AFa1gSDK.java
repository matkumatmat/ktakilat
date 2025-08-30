package com.appsflyer.internal;

import java.util.Map;
import org.jetbrains.annotations.NotNull;

public interface AFa1gSDK {
    @NotNull
    Map<String, Object> getCurrencyIso4217Code();

    void getMediationNetwork(@NotNull Map<String, ? extends Object> map);

    void getMonetizationNetwork();
}
