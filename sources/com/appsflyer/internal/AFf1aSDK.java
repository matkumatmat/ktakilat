package com.appsflyer.internal;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFf1aSDK {
    @JvmField
    public final long AFAdRevenueData;
    @JvmField
    public final boolean getMediationNetwork;
    @NotNull
    @JvmField
    public final String getRevenue;

    public AFf1aSDK(@NotNull String str, long j, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getRevenue = str;
        this.AFAdRevenueData = j;
        this.getMediationNetwork = z;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFf1aSDK)) {
            return false;
        }
        AFf1aSDK aFf1aSDK = (AFf1aSDK) obj;
        if (Intrinsics.a(this.getRevenue, aFf1aSDK.getRevenue) && this.AFAdRevenueData == aFf1aSDK.AFAdRevenueData && this.getMediationNetwork == aFf1aSDK.getMediationNetwork) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.AFAdRevenueData;
        int hashCode = ((this.getRevenue.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        boolean z = this.getMediationNetwork;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    @NotNull
    public final String toString() {
        String str = this.getRevenue;
        long j = this.AFAdRevenueData;
        boolean z = this.getMediationNetwork;
        return "AFUninstallToken(token=" + str + ", receivedTime=" + j + ", isQueued=" + z + ")";
    }
}
