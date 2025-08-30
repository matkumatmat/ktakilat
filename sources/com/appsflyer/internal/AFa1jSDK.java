package com.appsflyer.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B+\b\u0002\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\n\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\rR\"\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lcom/appsflyer/internal/AFa1jSDK;", "", "", "", "p0", "Lcom/appsflyer/internal/AFa1gSDK;", "p1", "<init>", "(Ljava/util/Map;Lcom/appsflyer/internal/AFa1gSDK;)V", "", "getCurrencyIso4217Code", "(Ljava/lang/String;)Z", "", "(Ljava/lang/String;Ljava/lang/Object;)V", "getMediationNetwork", "Ljava/util/Map;", "getMonetizationNetwork", "Lcom/appsflyer/internal/AFa1gSDK;", "AFa1ySDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFa1jSDK {
    @NotNull
    public static final AFa1ySDK AFa1ySDK = new AFa1ySDK((DefaultConstructorMarker) null);
    @NotNull
    final Map<String, Object> getMediationNetwork;
    @Nullable
    final AFa1gSDK getMonetizationNetwork;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/appsflyer/internal/AFa1jSDK$AFa1ySDK;", "", "<init>", "()V", "Lcom/appsflyer/internal/AFh1rSDK;", "p0", "Lcom/appsflyer/internal/AFa1jSDK;", "AFAdRevenueData", "(Lcom/appsflyer/internal/AFh1rSDK;)Lcom/appsflyer/internal/AFa1jSDK;", "Lcom/appsflyer/internal/AFa1gSDK;", "getMonetizationNetwork", "(Lcom/appsflyer/internal/AFa1gSDK;)Lcom/appsflyer/internal/AFa1jSDK;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1ySDK {
        private AFa1ySDK() {
        }

        @JvmStatic
        @NotNull
        public static AFa1jSDK AFAdRevenueData(@NotNull AFh1rSDK aFh1rSDK) {
            Intrinsics.checkNotNullParameter(aFh1rSDK, "");
            Map<String, Object> map = aFh1rSDK.AFAdRevenueData;
            Intrinsics.checkNotNullExpressionValue(map, "");
            return new AFa1jSDK(map, (AFa1gSDK) null, 2, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        @NotNull
        public static AFa1jSDK getMonetizationNetwork(@NotNull AFa1gSDK aFa1gSDK) {
            Intrinsics.checkNotNullParameter(aFa1gSDK, "");
            return new AFa1jSDK(new LinkedHashMap(), aFa1gSDK, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ AFa1ySDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private AFa1jSDK(Map<String, Object> map, AFa1gSDK aFa1gSDK) {
        this.getMediationNetwork = map;
        this.getMonetizationNetwork = aFa1gSDK;
    }

    @JvmStatic
    @NotNull
    public static final AFa1jSDK AFAdRevenueData(@NotNull AFh1rSDK aFh1rSDK) {
        return AFa1ySDK.AFAdRevenueData(aFh1rSDK);
    }

    public final void getCurrencyIso4217Code(@NotNull String str, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getMediationNetwork.put(str, obj);
        AFa1gSDK aFa1gSDK = this.getMonetizationNetwork;
        if (aFa1gSDK != null) {
            aFa1gSDK.getMediationNetwork(this.getMediationNetwork);
        }
    }

    public final boolean getCurrencyIso4217Code(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return this.getMediationNetwork.containsKey(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AFa1jSDK(Map map, AFa1gSDK aFa1gSDK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i & 2) != 0 ? null : aFa1gSDK);
    }

    @JvmStatic
    @NotNull
    public static final AFa1jSDK getCurrencyIso4217Code(@NotNull AFa1gSDK aFa1gSDK) {
        return AFa1ySDK.getMonetizationNetwork(aFa1gSDK);
    }

    public /* synthetic */ AFa1jSDK(Map map, AFa1gSDK aFa1gSDK, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, aFa1gSDK);
    }
}
