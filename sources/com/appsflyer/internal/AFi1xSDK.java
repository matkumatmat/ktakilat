package com.appsflyer.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001BC\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00078\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\u0014\u0010\u0016\u001a\u00020\u00078\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001eR\u0014\u0010 \u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001f"}, d2 = {"Lcom/appsflyer/internal/AFi1xSDK;", "", "", "p0", "", "p1", "", "", "p2", "", "p3", "p4", "p5", "<init>", "(JFLjava/util/List;ILjava/lang/String;Ljava/lang/String;)V", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "getCurrencyIso4217Code", "()Z", "AFAdRevenueData", "Ljava/lang/String;", "getRevenue", "getMonetizationNetwork", "I", "F", "getMediationNetwork", "component2", "Ljava/util/List;", "J", "component1"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFi1xSDK {
    @NotNull
    public final String AFAdRevenueData;
    @NotNull
    public final String component2;
    @NotNull
    public List<String> getCurrencyIso4217Code;
    public long getMediationNetwork;
    public final int getMonetizationNetwork;
    public final float getRevenue;

    @JvmOverloads
    public AFi1xSDK(long j, float f, @NotNull List<String> list, int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.getMediationNetwork = j;
        this.getRevenue = f;
        this.getCurrencyIso4217Code = list;
        this.getMonetizationNetwork = i;
        this.AFAdRevenueData = str;
        this.component2 = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!AFi1xSDK.class.equals(cls)) {
            return false;
        }
        Intrinsics.d(obj, "");
        AFi1xSDK aFi1xSDK = (AFi1xSDK) obj;
        if (this.getMediationNetwork == aFi1xSDK.getMediationNetwork && this.getRevenue == aFi1xSDK.getRevenue && Intrinsics.a(this.getCurrencyIso4217Code, aFi1xSDK.getCurrencyIso4217Code) && this.getMonetizationNetwork == aFi1xSDK.getMonetizationNetwork && Intrinsics.a(this.AFAdRevenueData, aFi1xSDK.AFAdRevenueData) && Intrinsics.a(this.component2, aFi1xSDK.component2)) {
            return true;
        }
        return false;
    }

    @JvmName(name = "getCurrencyIso4217Code")
    public final boolean getCurrencyIso4217Code() {
        if (TimeUnit.SECONDS.toMillis(this.getMediationNetwork) > ((AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).AFAdRevenueData().component3().AFAdRevenueData()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.getMediationNetwork;
        int floatToIntBits = Float.floatToIntBits(this.getRevenue);
        int hashCode = this.getCurrencyIso4217Code.hashCode();
        int hashCode2 = this.AFAdRevenueData.hashCode();
        return this.component2.hashCode() + ((hashCode2 + ((((hashCode + ((floatToIntBits + (((int) (j ^ (j >>> 32))) * 31)) * 31)) * 31) + this.getMonetizationNetwork) * 31)) * 31);
    }
}
