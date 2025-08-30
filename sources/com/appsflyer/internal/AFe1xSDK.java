package com.appsflyer.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015"}, d2 = {"Lcom/appsflyer/internal/AFe1xSDK;", "", "", "p0", "p1", "Lcom/appsflyer/internal/AFe1wSDK;", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/appsflyer/internal/AFe1wSDK;)V", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "AFAdRevenueData", "Lcom/appsflyer/internal/AFe1wSDK;", "getRevenue", "getMediationNetwork", "Ljava/lang/String;", "getCurrencyIso4217Code", "getMonetizationNetwork"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFe1xSDK {
    @NotNull
    public final AFe1wSDK AFAdRevenueData;
    @NotNull
    public final String getMediationNetwork;
    @Nullable
    public final String getRevenue;

    public AFe1xSDK(@NotNull String str, @Nullable String str2, @NotNull AFe1wSDK aFe1wSDK) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(aFe1wSDK, "");
        this.getMediationNetwork = str;
        this.getRevenue = str2;
        this.AFAdRevenueData = aFe1wSDK;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFe1xSDK)) {
            return false;
        }
        AFe1xSDK aFe1xSDK = (AFe1xSDK) obj;
        if (Intrinsics.a(this.getMediationNetwork, aFe1xSDK.getMediationNetwork) && Intrinsics.a(this.getRevenue, aFe1xSDK.getRevenue) && this.AFAdRevenueData == aFe1xSDK.AFAdRevenueData) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.getMediationNetwork.hashCode() * 31;
        String str = this.getRevenue;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        return this.AFAdRevenueData.hashCode() + ((hashCode + i) * 31);
    }

    @NotNull
    public final String toString() {
        String str = this.getMediationNetwork;
        String str2 = this.getRevenue;
        AFe1wSDK aFe1wSDK = this.AFAdRevenueData;
        StringBuilder u = e.u("HostMeta(name=", str, ", prefix=", str2, ", method=");
        u.append(aFe1wSDK);
        u.append(")");
        return u.toString();
    }
}
