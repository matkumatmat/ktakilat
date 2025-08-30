package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u000b8GX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\rR\u001b\u0010\u0012\u001a\u00020\u000b8GX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013"}, d2 = {"Lcom/appsflyer/internal/AFf1iSDK;", "", "Lcom/appsflyer/internal/AFc1pSDK;", "p0", "Lcom/appsflyer/internal/AFf1lSDK;", "p1", "<init>", "(Lcom/appsflyer/internal/AFc1pSDK;Lcom/appsflyer/internal/AFf1lSDK;)V", "", "AFAdRevenueData", "()J", "", "getMediationNetwork", "()Z", "Lcom/appsflyer/internal/AFc1pSDK;", "getMonetizationNetwork", "getRevenue", "Lkotlin/Lazy;", "getCurrencyIso4217Code", "Lcom/appsflyer/internal/AFf1lSDK;", "AFa1tSDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFf1iSDK {
    @NotNull
    public static final AFa1tSDK AFa1tSDK = new AFa1tSDK((DefaultConstructorMarker) null);
    private static final long getMonetizationNetwork = TimeUnit.HOURS.toSeconds(24);
    @NotNull
    private final AFf1lSDK AFAdRevenueData;
    @NotNull
    private final Lazy getCurrencyIso4217Code = LazyKt.b(new Function0<Boolean>(this) {
        private /* synthetic */ AFf1iSDK getMonetizationNetwork;

        {
            this.getMonetizationNetwork = r1;
        }

        @NotNull
        /* renamed from: getMonetizationNetwork */
        public final Boolean invoke() {
            return Boolean.valueOf(Boolean.parseBoolean(this.getMonetizationNetwork.getMediationNetwork.getCurrencyIso4217Code("com.appsflyer.rc.staging")));
        }
    });
    /* access modifiers changed from: private */
    @NotNull
    public final AFc1pSDK getMediationNetwork;
    @NotNull
    private final Lazy getRevenue = LazyKt.b(new Function0<Boolean>(this) {
        private /* synthetic */ AFf1iSDK getRevenue;

        {
            this.getRevenue = r1;
        }

        @NotNull
        /* renamed from: getCurrencyIso4217Code */
        public final Boolean invoke() {
            return Boolean.valueOf(Boolean.parseBoolean(this.getRevenue.getMediationNetwork.getCurrencyIso4217Code("com.appsflyer.rc.sandbox")));
        }
    });

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/appsflyer/internal/AFf1iSDK$AFa1tSDK;", "", "<init>", "()V", "", "getMonetizationNetwork", "J", "getMediationNetwork"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1tSDK {
        private AFa1tSDK() {
        }

        public /* synthetic */ AFa1tSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AFf1iSDK(@NotNull AFc1pSDK aFc1pSDK, @NotNull AFf1lSDK aFf1lSDK) {
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFf1lSDK, "");
        this.getMediationNetwork = aFc1pSDK;
        this.AFAdRevenueData = aFf1lSDK;
    }

    public final long AFAdRevenueData() {
        Object obj;
        String currencyIso4217Code = this.getMediationNetwork.getCurrencyIso4217Code("com.appsflyer.rc.cache.max-age-fallback");
        if (currencyIso4217Code == null) {
            return getMonetizationNetwork;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m16constructorimpl(Long.valueOf(Long.parseLong(currencyIso4217Code)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m16constructorimpl(ResultKt.a(th));
        }
        Throwable r1 = Result.m19exceptionOrNullimpl(obj);
        if (r1 != null) {
            String message = r1.getMessage();
            AFLogger.afErrorLog("Can't read maxAgeFallback from Manifest: " + message, r1);
            obj = Long.valueOf(getMonetizationNetwork);
        }
        return ((Number) obj).longValue();
    }

    public final boolean getMediationNetwork() {
        boolean z;
        AFi1xSDK aFi1xSDK;
        AFi1wSDK aFi1wSDK = this.AFAdRevenueData.getCurrencyIso4217Code;
        if (aFi1wSDK == null) {
            AFg1gSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.REMOTE_CONTROL, "active config is missing - fetching from CDN", false, 4, (Object) null);
            return true;
        }
        AFh1cSDK aFh1cSDK = aFi1wSDK.getMonetizationNetwork;
        if (aFh1cSDK == null || (aFi1xSDK = aFh1cSDK.AFAdRevenueData) == null) {
            z = false;
        } else {
            z = aFi1xSDK.getCurrencyIso4217Code();
        }
        long currentTimeMillis = System.currentTimeMillis();
        AFf1lSDK aFf1lSDK = this.AFAdRevenueData;
        long j = currentTimeMillis - aFf1lSDK.getMediationNetwork;
        long millis = TimeUnit.SECONDS.toMillis(aFf1lSDK.getRevenue);
        if (z || j > millis) {
            return true;
        }
        return false;
    }

    @JvmName(name = "getMonetizationNetwork")
    public final boolean getMonetizationNetwork() {
        return ((Boolean) this.getRevenue.getValue()).booleanValue();
    }

    @JvmName(name = "getRevenue")
    public final boolean getRevenue() {
        return ((Boolean) this.getCurrencyIso4217Code.getValue()).booleanValue();
    }
}
