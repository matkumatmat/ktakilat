package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFi1hSDK {
    public final long AFAdRevenueData;
    @Nullable
    public final String getCurrencyIso4217Code;
    @Nullable
    public final String getMonetizationNetwork;
    public final long getRevenue;

    public AFi1hSDK(long j, long j2, @Nullable String str, @Nullable String str2) {
        this.AFAdRevenueData = j;
        this.getRevenue = j2;
        this.getCurrencyIso4217Code = str;
        this.getMonetizationNetwork = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFi1hSDK)) {
            return false;
        }
        AFi1hSDK aFi1hSDK = (AFi1hSDK) obj;
        if (this.AFAdRevenueData == aFi1hSDK.AFAdRevenueData && this.getRevenue == aFi1hSDK.getRevenue && Intrinsics.a(this.getCurrencyIso4217Code, aFi1hSDK.getCurrencyIso4217Code) && Intrinsics.a(this.getMonetizationNetwork, aFi1hSDK.getMonetizationNetwork)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        long j = this.AFAdRevenueData;
        long j2 = this.getRevenue;
        int i2 = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.getCurrencyIso4217Code;
        int i3 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i4 = (i2 + i) * 31;
        String str2 = this.getMonetizationNetwork;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i4 + i3;
    }

    @NotNull
    public final String toString() {
        long j = this.AFAdRevenueData;
        long j2 = this.getRevenue;
        String str = this.getCurrencyIso4217Code;
        String str2 = this.getMonetizationNetwork;
        StringBuilder sb = new StringBuilder("PlayIntegrityApiData(piaTimestamp=");
        sb.append(j);
        sb.append(", ttrMillis=");
        sb.append(j2);
        sb.append(", piaToken=");
        sb.append(str);
        return e.q(sb, ", errorCode=", str2, ")");
    }
}
