package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFb1gSDK {
    public final int AFAdRevenueData;
    @NotNull
    public final String getMonetizationNetwork;

    public AFb1gSDK(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.AFAdRevenueData = i;
        this.getMonetizationNetwork = str;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFb1gSDK)) {
            return false;
        }
        AFb1gSDK aFb1gSDK = (AFb1gSDK) obj;
        if (this.AFAdRevenueData == aFb1gSDK.AFAdRevenueData && Intrinsics.a(this.getMonetizationNetwork, aFb1gSDK.getMonetizationNetwork)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.getMonetizationNetwork.hashCode() + (this.AFAdRevenueData * 31);
    }

    @NotNull
    public final String toString() {
        int i = this.AFAdRevenueData;
        String str = this.getMonetizationNetwork;
        return "AppSetIdModel(scope=" + i + ", id=" + str + ")";
    }
}
