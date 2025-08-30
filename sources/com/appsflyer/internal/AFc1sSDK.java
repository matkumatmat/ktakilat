package com.appsflyer.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFc1sSDK {
    @NotNull
    final List<AFc1uSDK> AFAdRevenueData;

    public AFc1sSDK(@NotNull List<AFc1uSDK> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.AFAdRevenueData = list;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AFc1sSDK) && Intrinsics.a(this.AFAdRevenueData, ((AFc1sSDK) obj).AFAdRevenueData)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.AFAdRevenueData.hashCode();
    }

    @NotNull
    public final String toString() {
        List<AFc1uSDK> list = this.AFAdRevenueData;
        return "StorageConfig(typeEntries=" + list + ")";
    }
}
