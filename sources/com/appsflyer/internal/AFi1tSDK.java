package com.appsflyer.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFi1tSDK {
    @NotNull
    public final Context getCurrencyIso4217Code;
    @Nullable
    public AFi1pSDK getMediationNetwork;

    public AFi1tSDK(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.getCurrencyIso4217Code = context;
    }
}
