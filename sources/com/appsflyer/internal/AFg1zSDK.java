package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFg1zSDK {
    final int AFAdRevenueData;
    final int getCurrencyIso4217Code;
    @NotNull
    final String getMediationNetwork;
    final int getMonetizationNetwork;
    final int getRevenue;

    public AFg1zSDK(int i, int i2, int i3, int i4, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getMonetizationNetwork = i;
        this.getCurrencyIso4217Code = i2;
        this.getRevenue = i3;
        this.AFAdRevenueData = i4;
        this.getMediationNetwork = str;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFg1zSDK)) {
            return false;
        }
        AFg1zSDK aFg1zSDK = (AFg1zSDK) obj;
        if (this.getMonetizationNetwork == aFg1zSDK.getMonetizationNetwork && this.getCurrencyIso4217Code == aFg1zSDK.getCurrencyIso4217Code && this.getRevenue == aFg1zSDK.getRevenue && this.AFAdRevenueData == aFg1zSDK.AFAdRevenueData && Intrinsics.a(this.getMediationNetwork, aFg1zSDK.getMediationNetwork)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.getMediationNetwork.hashCode() + (((((((this.getMonetizationNetwork * 31) + this.getCurrencyIso4217Code) * 31) + this.getRevenue) * 31) + this.AFAdRevenueData) * 31);
    }

    @NotNull
    public final String toString() {
        int i = this.getMonetizationNetwork;
        int i2 = this.getCurrencyIso4217Code;
        int i3 = this.getRevenue;
        int i4 = this.AFAdRevenueData;
        String str = this.getMediationNetwork;
        StringBuilder r = e.r(i, "CmpTcfData(policyVersion=", i2, ", gdprApplies=", ", cmpSdkId=");
        r.append(i3);
        r.append(", cmpSdkVersion=");
        r.append(i4);
        r.append(", tcString=");
        return ba.r(r, str, ")");
    }
}
