package com.appsflyer.internal;

import android.app.Activity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AFi1kSDK {
    @Nullable
    String getCurrencyIso4217Code(@Nullable Activity activity);

    void getMediationNetwork(@NotNull Activity activity);

    @NotNull
    String getMonetizationNetwork(@Nullable Activity activity);
}
