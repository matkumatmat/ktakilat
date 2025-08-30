package com.appsflyer.internal;

import androidx.annotation.WorkerThread;
import com.google.firebase.perf.util.Constants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@WorkerThread
public final class AFd1ySDK implements AFd1xSDK {
    @NotNull
    private final AFc1aSDK getRevenue;

    public AFd1ySDK(@NotNull AFc1aSDK aFc1aSDK) {
        Intrinsics.checkNotNullParameter(aFc1aSDK, "");
        this.getRevenue = aFc1aSDK;
    }

    public final void getMediationNetwork(@NotNull byte[] bArr, @Nullable Map<String, String> map, int i) {
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        if (new AFd1wSDK(bArr, map, Constants.MAX_URL_LENGTH).getMonetizationNetwork()) {
            this.getRevenue.getMonetizationNetwork();
        }
    }
}
