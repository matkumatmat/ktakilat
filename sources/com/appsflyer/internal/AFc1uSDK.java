package com.appsflyer.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFc1uSDK {
    final int AFAdRevenueData;
    @NotNull
    final String getCurrencyIso4217Code;
    @NotNull
    final List<AFe1mSDK> getRevenue;

    public AFc1uSDK(@NotNull String str, @NotNull List<? extends AFe1mSDK> list, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.getCurrencyIso4217Code = str;
        this.getRevenue = list;
        this.AFAdRevenueData = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFc1uSDK)) {
            return false;
        }
        AFc1uSDK aFc1uSDK = (AFc1uSDK) obj;
        if (Intrinsics.a(this.getCurrencyIso4217Code, aFc1uSDK.getCurrencyIso4217Code) && Intrinsics.a(this.getRevenue, aFc1uSDK.getRevenue) && this.AFAdRevenueData == aFc1uSDK.AFAdRevenueData) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.getRevenue.hashCode() + (this.getCurrencyIso4217Code.hashCode() * 31)) * 31) + this.AFAdRevenueData;
    }

    @NotNull
    public final String toString() {
        String str = this.getCurrencyIso4217Code;
        List<AFe1mSDK> list = this.getRevenue;
        int i = this.AFAdRevenueData;
        StringBuilder sb = new StringBuilder("StorageConfigTypeEntry(cacheDirName=");
        sb.append(str);
        sb.append(", eventTypes=");
        sb.append(list);
        sb.append(", maxCapacity=");
        return ba.q(sb, ")", i);
    }
}
