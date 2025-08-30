package com.appsflyer;

import com.appsflyer.internal.AFg1cSDK;
import com.appsflyer.internal.AFg1gSDK;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÇ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0012\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J8\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007HÇ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\rJ\u0010\u0010\u001e\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u001e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u00048\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b#\u0010\u000fR\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010\u0014"}, d2 = {"Lcom/appsflyer/AFAdRevenueData;", "", "", "monetizationNetwork", "Lcom/appsflyer/MediationNetwork;", "mediationNetwork", "currencyIso4217Code", "", "revenue", "<init>", "(Ljava/lang/String;Lcom/appsflyer/MediationNetwork;Ljava/lang/String;D)V", "", "areAllFieldsValid", "()Z", "component1", "()Ljava/lang/String;", "component2", "()Lcom/appsflyer/MediationNetwork;", "component3", "component4", "()D", "copy", "(Ljava/lang/String;Lcom/appsflyer/MediationNetwork;Ljava/lang/String;D)Lcom/appsflyer/AFAdRevenueData;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "AFAdRevenueData", "toString", "Ljava/lang/String;", "getCurrencyIso4217Code", "Lcom/appsflyer/MediationNetwork;", "getMediationNetwork", "getMonetizationNetwork", "D", "getRevenue"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFAdRevenueData {
    @NotNull
    private final String currencyIso4217Code;
    @NotNull
    private final MediationNetwork mediationNetwork;
    @NotNull
    private final String monetizationNetwork;
    private final double revenue;

    public AFAdRevenueData(@NotNull String str, @NotNull MediationNetwork mediationNetwork2, @NotNull String str2, double d) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(mediationNetwork2, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.monetizationNetwork = str;
        this.mediationNetwork = mediationNetwork2;
        this.currencyIso4217Code = str2;
        this.revenue = d;
    }

    private final boolean AFAdRevenueData() {
        try {
            Currency.getInstance(this.currencyIso4217Code);
            return true;
        } catch (Throwable unused) {
            AFg1gSDK.w$default(AFLogger.INSTANCE, AFg1cSDK.AD_REVENUE, "Currency is not ISO 4217 currency code", false, 4, (Object) null);
            return false;
        }
    }

    public static /* synthetic */ AFAdRevenueData copy$default(AFAdRevenueData aFAdRevenueData, String str, MediationNetwork mediationNetwork2, String str2, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aFAdRevenueData.monetizationNetwork;
        }
        if ((i & 2) != 0) {
            mediationNetwork2 = aFAdRevenueData.mediationNetwork;
        }
        MediationNetwork mediationNetwork3 = mediationNetwork2;
        if ((i & 4) != 0) {
            str2 = aFAdRevenueData.currencyIso4217Code;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            d = aFAdRevenueData.revenue;
        }
        return aFAdRevenueData.copy(str, mediationNetwork3, str3, d);
    }

    public final boolean areAllFieldsValid() {
        if (StringsKt.t(this.monetizationNetwork) || !AFAdRevenueData()) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String component1() {
        return this.monetizationNetwork;
    }

    @NotNull
    public final MediationNetwork component2() {
        return this.mediationNetwork;
    }

    @NotNull
    public final String component3() {
        return this.currencyIso4217Code;
    }

    public final double component4() {
        return this.revenue;
    }

    @NotNull
    public final AFAdRevenueData copy(@NotNull String str, @NotNull MediationNetwork mediationNetwork2, @NotNull String str2, double d) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(mediationNetwork2, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return new AFAdRevenueData(str, mediationNetwork2, str2, d);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFAdRevenueData)) {
            return false;
        }
        AFAdRevenueData aFAdRevenueData = (AFAdRevenueData) obj;
        if (Intrinsics.a(this.monetizationNetwork, aFAdRevenueData.monetizationNetwork) && this.mediationNetwork == aFAdRevenueData.mediationNetwork && Intrinsics.a(this.currencyIso4217Code, aFAdRevenueData.currencyIso4217Code) && Double.compare(this.revenue, aFAdRevenueData.revenue) == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    @JvmName(name = "getCurrencyIso4217Code")
    public final String getCurrencyIso4217Code() {
        return this.currencyIso4217Code;
    }

    @NotNull
    @JvmName(name = "getMediationNetwork")
    public final MediationNetwork getMediationNetwork() {
        return this.mediationNetwork;
    }

    @NotNull
    @JvmName(name = "getMonetizationNetwork")
    public final String getMonetizationNetwork() {
        return this.monetizationNetwork;
    }

    @JvmName(name = "getRevenue")
    public final double getRevenue() {
        return this.revenue;
    }

    public final int hashCode() {
        int hashCode = this.mediationNetwork.hashCode();
        int hashCode2 = this.currencyIso4217Code.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(this.revenue);
        return ((hashCode2 + ((hashCode + (this.monetizationNetwork.hashCode() * 31)) * 31)) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    @NotNull
    public final String toString() {
        String str = this.monetizationNetwork;
        MediationNetwork mediationNetwork2 = this.mediationNetwork;
        String str2 = this.currencyIso4217Code;
        double d = this.revenue;
        return "AFAdRevenueData(monetizationNetwork=" + str + ", mediationNetwork=" + mediationNetwork2 + ", currencyIso4217Code=" + str2 + ", revenue=" + d + ")";
    }
}
