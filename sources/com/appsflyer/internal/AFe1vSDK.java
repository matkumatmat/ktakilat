package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFe1vSDK {
    @NotNull
    final String AFAdRevenueData;
    @NotNull
    final String getMediationNetwork;

    public AFe1vSDK(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.AFAdRevenueData = str;
        this.getMediationNetwork = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFe1vSDK)) {
            return false;
        }
        AFe1vSDK aFe1vSDK = (AFe1vSDK) obj;
        if (Intrinsics.a(this.AFAdRevenueData, aFe1vSDK.AFAdRevenueData) && Intrinsics.a(this.getMediationNetwork, aFe1vSDK.getMediationNetwork)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.getMediationNetwork.hashCode() + (this.AFAdRevenueData.hashCode() * 31);
    }

    @NotNull
    public final String toString() {
        return e.o("HostConfig(prefix=", this.AFAdRevenueData, ", host=", this.getMediationNetwork, ")");
    }
}
