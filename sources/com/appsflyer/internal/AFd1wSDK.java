package com.appsflyer.internal;

import com.appsflyer.AppsFlyerLib;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u0005*\u00020\u0005H\u0017¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\u00020\r8\u0017X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00058WX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0013"}, d2 = {"Lcom/appsflyer/internal/AFd1wSDK;", "Lcom/appsflyer/internal/AFd1zSDK;", "", "p0", "", "", "p1", "", "p2", "<init>", "([BLjava/util/Map;I)V", "getCurrencyIso4217Code", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/appsflyer/internal/AFd1gSDK;", "getMediationNetwork", "Lcom/appsflyer/internal/AFd1gSDK;", "getRevenue", "()Lcom/appsflyer/internal/AFd1gSDK;", "getMonetizationNetwork", "()Ljava/lang/String;", "AFAdRevenueData", "AFa1tSDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFd1wSDK extends AFd1zSDK {
    @NotNull
    public static final AFa1tSDK AFa1tSDK = new AFa1tSDK((DefaultConstructorMarker) null);
    @NotNull
    public static String getRevenue = "https://%smonitorsdk.%s/remote-debug/exception-manager";
    @NotNull
    private final AFd1gSDK getMediationNetwork = AFd1gSDK.JSON;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\f¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/appsflyer/internal/AFd1wSDK$AFa1tSDK;", "", "<init>", "()V", "", "getRevenue", "Ljava/lang/String;", "getCurrencyIso4217Code"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1tSDK {
        private AFa1tSDK() {
        }

        public /* synthetic */ AFa1tSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFd1wSDK(@NotNull byte[] bArr, @Nullable Map<String, String> map, int i) {
        super(bArr, map, i);
        Intrinsics.checkNotNullParameter(bArr, "");
    }

    @NotNull
    @JvmName(name = "getCurrencyIso4217Code")
    public final String getCurrencyIso4217Code() {
        String format = String.format(getRevenue, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ((AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).getHostName()});
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    @NotNull
    @JvmName(name = "getRevenue")
    public final AFd1gSDK getRevenue() {
        return this.getMediationNetwork;
    }

    @NotNull
    public final String getCurrencyIso4217Code(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return AFd1rSDK.AFAdRevenueData(str);
    }
}
