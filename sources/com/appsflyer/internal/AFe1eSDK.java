package com.appsflyer.internal;

import android.content.Context;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailability;
import com.samsung.android.game.cloudgame.dev.sdk.CloudDevCallback;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFetchAdvertisingIdTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FetchAdvertisingIdTask.kt\ncom/appsflyer/internal/components/queue/tasks/FetchAdvertisingIdTask\n+ 2 StringExtensions.kt\ncom/appsflyer/internal/util/StringExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,396:1\n39#2:397\n1#3:398\n*S KotlinDebug\n*F\n+ 1 FetchAdvertisingIdTask.kt\ncom/appsflyer/internal/components/queue/tasks/FetchAdvertisingIdTask\n*L\n202#1:397\n*E\n"})
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\nH\u0003¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u000b\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\r\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\r\u0010\u0015J\u000f\u0010\u0013\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u0013\u0010\u0017J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0018J\u000f\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000e\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u001a*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u000b\u0010\u001bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000e\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u000b\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\u0013\u001a\u00020\u00078CX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\tR\u001b\u0010%\u001a\u00020\u00078CX\u0002¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b\u001c\u0010\tR\u0014\u0010\u001c\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0015\u0010\"\u001a\u00020\u00148BX\u0002¢\u0006\u0006\n\u0004\b)\u0010$"}, d2 = {"Lcom/appsflyer/internal/AFe1eSDK;", "Lcom/appsflyer/internal/AFe1sSDK;", "Lcom/appsflyer/internal/AFh1oSDK;", "Lcom/appsflyer/internal/AFc1dSDK;", "p0", "<init>", "(Lcom/appsflyer/internal/AFc1dSDK;)V", "", "equals", "()Z", "", "AFAdRevenueData", "(I)Z", "getMonetizationNetwork", "getMediationNetwork", "Landroid/content/Context;", "Lcom/appsflyer/internal/AFe1eSDK$AFa1ySDK;", "p1", "(Landroid/content/Context;Lcom/appsflyer/internal/AFe1eSDK$AFa1ySDK;)Z", "getCurrencyIso4217Code", "", "()J", "Lcom/appsflyer/internal/AFe1rSDK;", "()Lcom/appsflyer/internal/AFe1rSDK;", "(Landroid/content/Context;)I", "", "", "(Lcom/appsflyer/internal/AFh1oSDK;Ljava/lang/String;)V", "component1", "Lcom/appsflyer/internal/AFh1oSDK;", "Lcom/appsflyer/internal/AFc1iSDK;", "areAllFieldsValid", "Lcom/appsflyer/internal/AFc1iSDK;", "Lcom/appsflyer/internal/AFc1pSDK;", "component3", "Lcom/appsflyer/internal/AFc1pSDK;", "Lkotlin/Lazy;", "getRevenue", "Lcom/appsflyer/internal/AFc1kSDK;", "component2", "Lcom/appsflyer/internal/AFc1kSDK;", "component4", "AFa1tSDK", "AFa1ySDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFe1eSDK extends AFe1sSDK<AFh1oSDK> {
    @NotNull
    public static final AFa1tSDK AFa1tSDK = new AFa1tSDK((DefaultConstructorMarker) null);
    @NotNull
    private final AFc1iSDK areAllFieldsValid;
    @NotNull
    private final AFh1oSDK component1 = new AFh1oSDK((String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (Boolean) null, (Map) null, 255, (DefaultConstructorMarker) null);
    @NotNull
    private final AFc1kSDK component2;
    /* access modifiers changed from: private */
    @NotNull
    public final AFc1pSDK component3;
    @NotNull
    private final Lazy component4 = LazyKt.b(new Function0<Long>(this) {
        final /* synthetic */ AFe1eSDK this$0;

        {
            this.this$0 = r1;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
            r0 = kotlin.text.StringsKt.P(r0);
         */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Long invoke() {
            /*
                r2 = this;
                com.appsflyer.internal.AFe1eSDK r0 = r2.this$0
                com.appsflyer.internal.AFc1pSDK r0 = r0.component3
                java.lang.String r1 = "com.appsflyer.fetch_ids.timeout"
                java.lang.String r0 = r0.getCurrencyIso4217Code((java.lang.String) r1)
                if (r0 == 0) goto L_0x0019
                java.lang.Long r0 = kotlin.text.StringsKt.P(r0)
                if (r0 == 0) goto L_0x0019
                long r0 = r0.longValue()
                goto L_0x001b
            L_0x0019:
                r0 = 1000(0x3e8, double:4.94E-321)
            L_0x001b:
                java.lang.Long r0 = java.lang.Long.valueOf(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1eSDK.AnonymousClass4.invoke():java.lang.Long");
        }
    });
    @NotNull
    private final Lazy equals = LazyKt.b(new Function0<Boolean>(this) {
        final /* synthetic */ AFe1eSDK this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(Boolean.parseBoolean(this.this$0.component3.getCurrencyIso4217Code("com.appsflyer.enable_instant_plays")));
        }
    });

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/appsflyer/internal/AFe1eSDK$AFa1tSDK;", "", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1tSDK {
        private AFa1tSDK() {
        }

        public /* synthetic */ AFa1tSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\f\b\u0002\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÇ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÇ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0012\u001a\u00060\u0007j\u0002`\bHÇ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J@\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\f\b\u0002\u0010\t\u001a\u00060\u0007j\u0002`\bHÇ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u001c\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010 R\"\u0010\u0006\u001a\u00020\u00048\u0007@\u0007X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010$R\u001e\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010\u0013R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0007@\u0007X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010'\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b(\u0010)"}, d2 = {"Lcom/appsflyer/internal/AFe1eSDK$AFa1ySDK;", "", "", "advertisingId", "", "isLimitAdTrackingEnabled", "advertisingIdWithGps", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "gaidError", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/StringBuilder;)V", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Boolean;", "component3", "()Z", "component4", "()Ljava/lang/StringBuilder;", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/StringBuilder;)Lcom/appsflyer/internal/AFe1eSDK$AFa1ySDK;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAdvertisingId", "setAdvertisingId", "(Ljava/lang/String;)V", "Z", "getAdvertisingIdWithGps", "setAdvertisingIdWithGps", "(Z)V", "Ljava/lang/StringBuilder;", "getGaidError", "Ljava/lang/Boolean;", "setLimitAdTrackingEnabled", "(Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1ySDK {
        @Nullable
        private String advertisingId;
        private boolean advertisingIdWithGps;
        @NotNull
        private final StringBuilder gaidError;
        @Nullable
        private Boolean isLimitAdTrackingEnabled;

        public AFa1ySDK() {
            this((String) null, (Boolean) null, false, (StringBuilder) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ AFa1ySDK copy$default(AFa1ySDK aFa1ySDK, String str, Boolean bool, boolean z, StringBuilder sb, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aFa1ySDK.advertisingId;
            }
            if ((i & 2) != 0) {
                bool = aFa1ySDK.isLimitAdTrackingEnabled;
            }
            if ((i & 4) != 0) {
                z = aFa1ySDK.advertisingIdWithGps;
            }
            if ((i & 8) != 0) {
                sb = aFa1ySDK.gaidError;
            }
            return aFa1ySDK.copy(str, bool, z, sb);
        }

        @Nullable
        public final String component1() {
            return this.advertisingId;
        }

        @Nullable
        public final Boolean component2() {
            return this.isLimitAdTrackingEnabled;
        }

        public final boolean component3() {
            return this.advertisingIdWithGps;
        }

        @NotNull
        public final StringBuilder component4() {
            return this.gaidError;
        }

        @NotNull
        public final AFa1ySDK copy(@Nullable String str, @Nullable Boolean bool, boolean z, @NotNull StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "gaidError");
            return new AFa1ySDK(str, bool, z, sb);
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AFa1ySDK)) {
                return false;
            }
            AFa1ySDK aFa1ySDK = (AFa1ySDK) obj;
            return Intrinsics.a(this.advertisingId, aFa1ySDK.advertisingId) && Intrinsics.a(this.isLimitAdTrackingEnabled, aFa1ySDK.isLimitAdTrackingEnabled) && this.advertisingIdWithGps == aFa1ySDK.advertisingIdWithGps && Intrinsics.a(this.gaidError, aFa1ySDK.gaidError);
        }

        @Nullable
        @JvmName(name = "getAdvertisingId")
        public final String getAdvertisingId() {
            return this.advertisingId;
        }

        @JvmName(name = "getAdvertisingIdWithGps")
        public final boolean getAdvertisingIdWithGps() {
            return this.advertisingIdWithGps;
        }

        @NotNull
        @JvmName(name = "getGaidError")
        public final StringBuilder getGaidError() {
            return this.gaidError;
        }

        public final int hashCode() {
            String str = this.advertisingId;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.isLimitAdTrackingEnabled;
            if (bool != null) {
                i = bool.hashCode();
            }
            int i2 = (hashCode + i) * 31;
            boolean z = this.advertisingIdWithGps;
            if (z) {
                z = true;
            }
            return this.gaidError.hashCode() + ((i2 + (z ? 1 : 0)) * 31);
        }

        @Nullable
        @JvmName(name = "isLimitAdTrackingEnabled")
        public final Boolean isLimitAdTrackingEnabled() {
            return this.isLimitAdTrackingEnabled;
        }

        @JvmName(name = "setAdvertisingId")
        public final void setAdvertisingId(@Nullable String str) {
            this.advertisingId = str;
        }

        @JvmName(name = "setAdvertisingIdWithGps")
        public final void setAdvertisingIdWithGps(boolean z) {
            this.advertisingIdWithGps = z;
        }

        @JvmName(name = "setLimitAdTrackingEnabled")
        public final void setLimitAdTrackingEnabled(@Nullable Boolean bool) {
            this.isLimitAdTrackingEnabled = bool;
        }

        @NotNull
        public final String toString() {
            String str = this.advertisingId;
            Boolean bool = this.isLimitAdTrackingEnabled;
            boolean z = this.advertisingIdWithGps;
            StringBuilder sb = this.gaidError;
            return "FetchGaidData(advertisingId=" + str + ", isLimitAdTrackingEnabled=" + bool + ", advertisingIdWithGps=" + z + ", gaidError=" + sb + ")";
        }

        public AFa1ySDK(@Nullable String str, @Nullable Boolean bool, boolean z, @NotNull StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "gaidError");
            this.advertisingId = str;
            this.isLimitAdTrackingEnabled = bool;
            this.advertisingIdWithGps = z;
            this.gaidError = sb;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AFa1ySDK(String str, Boolean bool, boolean z, StringBuilder sb, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? false : z, (i & 8) != 0 ? new StringBuilder() : sb);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH\u0016¨\u0006\t"}, d2 = {"com/appsflyer/internal/components/queue/tasks/FetchAdvertisingIdTask$fetchGaidUsingSamsungSdk$1", "Lcom/samsung/android/game/cloudgame/dev/sdk/CloudDevCallback;", "onError", "", "reason", "", "onSuccess", "kinds", "", "SDK_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1zSDK implements CloudDevCallback {
        final /* synthetic */ AFa1ySDK $fetchGaidData;
        final /* synthetic */ CountDownLatch $latch;

        public AFa1zSDK(AFa1ySDK aFa1ySDK, CountDownLatch countDownLatch) {
            this.$fetchGaidData = aFa1ySDK;
            this.$latch = countDownLatch;
        }

        public final void onError(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "reason");
            AFg1gSDK.w$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, e.B("Could not fetch GAID using CloudDevSdk: ", str), false, 4, (Object) null);
            StringBuilder gaidError = this.$fetchGaidData.getGaidError();
            gaidError.append(str);
            gaidError.append(" |");
            this.$latch.countDown();
        }

        public final void onSuccess(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "kinds");
            AFg1gSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "CloudDevCallback received onSuccess", false, 4, (Object) null);
            this.$fetchGaidData.setAdvertisingId(map.get("gaid"));
            this.$latch.countDown();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFe1eSDK(@NotNull AFc1dSDK aFc1dSDK) {
        super(AFe1mSDK.FETCH_ADVERTISING_ID, new AFe1mSDK[0], "FetchAdvertisingIdTask");
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        AFc1iSDK AFInAppEventType = aFc1dSDK.AFInAppEventType();
        Intrinsics.checkNotNullExpressionValue(AFInAppEventType, "");
        this.areAllFieldsValid = AFInAppEventType;
        AFc1pSDK revenue = aFc1dSDK.getRevenue();
        Intrinsics.checkNotNullExpressionValue(revenue, "");
        this.component3 = revenue;
        AFc1kSDK afInfoLog = aFc1dSDK.afInfoLog();
        Intrinsics.checkNotNullExpressionValue(afInfoLog, "");
        this.component2 = afInfoLog;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0082 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean AFAdRevenueData(int r14) {
        /*
            r13 = this;
            com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.ADVERTISING_ID
            java.lang.String r2 = "Trying to fetch GAID..."
            r3 = 0
            r4 = 4
            r5 = 0
            com.appsflyer.internal.AFg1gSDK.i$default(r0, r1, r2, r3, r4, r5)
            com.appsflyer.internal.AFe1eSDK$AFa1ySDK r0 = new com.appsflyer.internal.AFe1eSDK$AFa1ySDK
            r9 = 0
            r10 = 0
            r7 = 0
            r8 = 0
            r11 = 15
            r12 = 0
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            com.appsflyer.internal.AFc1iSDK r1 = r13.areAllFieldsValid
            android.content.Context r1 = r1.getMonetizationNetwork
            kotlin.jvm.internal.Intrinsics.c(r1)
            int r1 = getCurrencyIso4217Code(r1)
            com.appsflyer.internal.AFc1iSDK r2 = r13.areAllFieldsValid
            android.content.Context r2 = r2.getMonetizationNetwork
            kotlin.jvm.internal.Intrinsics.c(r2)
            boolean r2 = r13.getCurrencyIso4217Code(r2, r0)
            r4 = 1
            if (r2 != 0) goto L_0x0083
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r5 = "enableGpsFallback"
            boolean r2 = r2.getBoolean(r5, r4)
            if (r2 == 0) goto L_0x004d
            com.appsflyer.internal.AFc1iSDK r2 = r13.areAllFieldsValid
            android.content.Context r2 = r2.getMonetizationNetwork
            kotlin.jvm.internal.Intrinsics.c(r2)
            boolean r2 = r13.AFAdRevenueData((android.content.Context) r2, (com.appsflyer.internal.AFe1eSDK.AFa1ySDK) r0)
            if (r2 == 0) goto L_0x004d
            r2 = 1
            goto L_0x004e
        L_0x004d:
            r2 = 0
        L_0x004e:
            java.lang.StringBuilder r5 = r0.getGaidError()
            java.lang.String r5 = r5.toString()
            if (r5 == 0) goto L_0x007b
            boolean r6 = kotlin.text.StringsKt.t(r5)
            if (r6 == 0) goto L_0x005f
            goto L_0x007b
        L_0x005f:
            java.lang.CharSequence r5 = kotlin.text.StringsKt.Q(r5)
            java.lang.String r5 = r5.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r1)
            java.lang.String r1 = ": "
            r6.append(r1)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
        L_0x007b:
            com.appsflyer.internal.AFh1oSDK r1 = r13.component1
            AFAdRevenueData((com.appsflyer.internal.AFh1oSDK) r1, (java.lang.String) r5)
            if (r2 != 0) goto L_0x0083
            return r3
        L_0x0083:
            com.appsflyer.internal.AFh1oSDK r1 = r13.component1
            java.lang.String r2 = r0.getAdvertisingId()
            r1.AFAdRevenueData = r2
            java.lang.Boolean r2 = r0.isLimitAdTrackingEnabled()
            r1.getRevenue = r2
            java.lang.Boolean r2 = r0.isLimitAdTrackingEnabled()
            if (r2 == 0) goto L_0x00a1
            boolean r2 = r2.booleanValue()
            r2 = r2 ^ r4
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x00a2
        L_0x00a1:
            r2 = 0
        L_0x00a2:
            r1.getMonetizationNetwork = r2
            boolean r0 = r0.getAdvertisingIdWithGps()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1.getMediationNetwork = r0
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r1.getCurrencyIso4217Code = r0
            r0 = 2
            if (r14 == r0) goto L_0x00b6
            r3 = 1
        L_0x00b6:
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r3)
            r1.component2 = r14
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1eSDK.AFAdRevenueData(int):boolean");
    }

    @JvmName(name = "component1")
    private final boolean component1() {
        return ((Boolean) this.equals.getValue()).booleanValue();
    }

    @JvmName(name = "component3")
    private static boolean component3() {
        String B;
        try {
            Class.forName("com.samsung.android.game.cloudgame.dev.sdk.CloudDevSdk");
            return true;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof ClassNotFoundException) {
                B = "CloudDevSdk not found";
            } else {
                B = e.B("Unexpected exception while checking if running in cloud environment: ", th2.getMessage());
            }
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, B, th2, true, false, false, false, 112, (Object) null);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045 A[LOOP:0: B:1:0x0005->B:13:0x0045, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048 A[EDGE_INSN: B:16:0x0048->B:14:0x0048 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean equals() {
        /*
            r17 = this;
            r0 = r17
            r1 = 2
            r2 = 0
            r3 = 0
        L_0x0005:
            if (r1 <= 0) goto L_0x0048
            boolean r3 = r17.component1()
            r4 = 1
            if (r3 == 0) goto L_0x0022
            boolean r3 = r0.getMediationNetwork(r1)
            if (r3 == 0) goto L_0x0022
            com.appsflyer.AFLogger r5 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r6 = com.appsflyer.internal.AFg1cSDK.ADVERTISING_ID
            r9 = 4
            r10 = 0
            java.lang.String r7 = "GAID fetched using Samsung Cloud dev SDK"
            r8 = 0
            com.appsflyer.internal.AFg1gSDK.v$default(r5, r6, r7, r8, r9, r10)
        L_0x0020:
            r3 = 1
            goto L_0x0043
        L_0x0022:
            boolean r3 = r0.AFAdRevenueData(r1)
            if (r3 == 0) goto L_0x0035
            com.appsflyer.AFLogger r5 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r6 = com.appsflyer.internal.AFg1cSDK.ADVERTISING_ID
            r9 = 4
            r10 = 0
            java.lang.String r7 = "GAID fetched using GMS"
            r8 = 0
            com.appsflyer.internal.AFg1gSDK.v$default(r5, r6, r7, r8, r9, r10)
            goto L_0x0020
        L_0x0035:
            com.appsflyer.AFLogger r11 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r12 = com.appsflyer.internal.AFg1cSDK.ADVERTISING_ID
            r15 = 4
            r16 = 0
            java.lang.String r13 = "Failed to fetch GAID"
            r14 = 0
            com.appsflyer.internal.AFg1gSDK.v$default(r11, r12, r13, r14, r15, r16)
            r3 = 0
        L_0x0043:
            if (r3 != 0) goto L_0x0048
            int r1 = r1 + -1
            goto L_0x0005
        L_0x0048:
            com.appsflyer.internal.AFc1kSDK r1 = r0.component2
            com.appsflyer.internal.AFh1oSDK r2 = r0.component1
            r1.component3 = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1eSDK.equals():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d3, code lost:
        if (r11.getGaidError().length() <= 0) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d6, code lost:
        r0 = r11.getAdvertisingId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00da, code lost:
        if (r0 == null) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e0, code lost:
        if (r0.length() != 0) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e3, code lost:
        r0 = r1.component1;
        r0.AFAdRevenueData = r11.getAdvertisingId();
        r2 = java.lang.Boolean.FALSE;
        r0.getRevenue = r2;
        r3 = java.lang.Boolean.TRUE;
        r0.getMonetizationNetwork = r3;
        r0.getMediationNetwork = r2;
        r0.getCurrencyIso4217Code = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00fa, code lost:
        if (r22 == 2) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fc, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fd, code lost:
        r0.component2 = java.lang.Boolean.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0103, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0104, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0070, code lost:
        if (r11.getGaidError().length() > 0) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0072, code lost:
        AFAdRevenueData(r1.component1, r11.getGaidError().toString());
     */
    @androidx.annotation.RequiresApi(23)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean getMonetizationNetwork(int r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r2 = "Unexpected exception while fetching GAID using Samsung Cloud Dev "
            com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r9 = com.appsflyer.internal.AFg1cSDK.ADVERTISING_ID
            r7 = 4
            r8 = 0
            java.lang.String r5 = "Trying to fetch GAID using Samsung Cloud Dev..."
            r6 = 0
            r3 = r0
            r4 = r9
            com.appsflyer.internal.AFg1gSDK.i$default(r3, r4, r5, r6, r7, r8)
            boolean r3 = component3()
            r10 = 0
            if (r3 == 0) goto L_0x011d
            com.samsung.android.game.cloudgame.dev.sdk.CloudDevSdk r3 = com.samsung.android.game.cloudgame.dev.sdk.CloudDevSdk.INSTANCE
            com.appsflyer.internal.AFc1iSDK r4 = r1.areAllFieldsValid
            android.content.Context r4 = r4.getMonetizationNetwork
            kotlin.jvm.internal.Intrinsics.c(r4)
            boolean r3 = r3.isCloudEnvironment(r4)
            if (r3 != 0) goto L_0x002a
            goto L_0x011d
        L_0x002a:
            com.appsflyer.internal.AFe1eSDK$AFa1ySDK r3 = new com.appsflyer.internal.AFe1eSDK$AFa1ySDK
            r16 = 15
            r17 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r11 = r3
            r11.<init>(r12, r13, r14, r15, r16, r17)
            java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch
            r4 = 1
            r0.<init>(r4)
            com.samsung.android.game.cloudgame.dev.sdk.CloudDevSdk r5 = com.samsung.android.game.cloudgame.dev.sdk.CloudDevSdk.INSTANCE     // Catch:{ all -> 0x0080 }
            com.appsflyer.internal.AFc1iSDK r6 = r1.areAllFieldsValid     // Catch:{ all -> 0x0080 }
            android.content.Context r6 = r6.getMonetizationNetwork     // Catch:{ all -> 0x0080 }
            kotlin.jvm.internal.Intrinsics.c(r6)     // Catch:{ all -> 0x0080 }
            java.lang.String r7 = "gaid"
            java.util.List r7 = kotlin.collections.CollectionsKt.s(r7)     // Catch:{ all -> 0x0080 }
            com.appsflyer.internal.AFe1eSDK$AFa1zSDK r8 = new com.appsflyer.internal.AFe1eSDK$AFa1zSDK     // Catch:{ all -> 0x0080 }
            r8.<init>(r3, r0)     // Catch:{ all -> 0x0080 }
            com.samsung.android.game.cloudgame.dev.sdk.CloudDevCallback r8 = (com.samsung.android.game.cloudgame.dev.sdk.CloudDevCallback) r8     // Catch:{ all -> 0x0080 }
            r5.request(r6, r7, r8)     // Catch:{ all -> 0x0080 }
            kotlin.Lazy r5 = r1.component4     // Catch:{ all -> 0x0080 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x0080 }
            java.lang.Number r5 = (java.lang.Number) r5     // Catch:{ all -> 0x0080 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0080 }
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0080 }
            r0.await(r5, r7)     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r0 = r3.getGaidError()
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x00d6
        L_0x0072:
            com.appsflyer.internal.AFh1oSDK r0 = r1.component1
            java.lang.StringBuilder r2 = r3.getGaidError()
            java.lang.String r2 = r2.toString()
            AFAdRevenueData((com.appsflyer.internal.AFh1oSDK) r0, (java.lang.String) r2)
            goto L_0x00d6
        L_0x0080:
            r0 = move-exception
            boolean r5 = r0 instanceof java.lang.InterruptedException     // Catch:{ all -> 0x0089 }
            if (r5 == 0) goto L_0x008c
            java.lang.String r2 = "Fetch GAID using Samsung Cloud Dev interrupted or reached to timeout"
        L_0x0087:
            r13 = r2
            goto L_0x00a4
        L_0x0089:
            r0 = move-exception
            goto L_0x0105
        L_0x008c:
            boolean r5 = r0 instanceof java.lang.ClassNotFoundException     // Catch:{ all -> 0x0089 }
            if (r5 == 0) goto L_0x0093
            java.lang.String r2 = "CloudDevSdk not found"
            goto L_0x0087
        L_0x0093:
            java.lang.String r5 = r0.getMessage()     // Catch:{ all -> 0x0089 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            r6.<init>(r2)     // Catch:{ all -> 0x0089 }
            r6.append(r5)     // Catch:{ all -> 0x0089 }
            java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x0089 }
            goto L_0x0087
        L_0x00a4:
            com.appsflyer.AFLogger r11 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x0089 }
            com.appsflyer.internal.AFg1cSDK r12 = com.appsflyer.internal.AFg1cSDK.ADVERTISING_ID     // Catch:{ all -> 0x0089 }
            r19 = 112(0x70, float:1.57E-43)
            r20 = 0
            r15 = 1
            r16 = 0
            r17 = 0
            r18 = 0
            r14 = r0
            com.appsflyer.internal.AFg1gSDK.e$default(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0089 }
            java.lang.StringBuilder r2 = r3.getGaidError()     // Catch:{ all -> 0x0089 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x0089 }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ all -> 0x0089 }
            r2.append(r0)     // Catch:{ all -> 0x0089 }
            java.lang.String r0 = " |"
            r2.append(r0)     // Catch:{ all -> 0x0089 }
            java.lang.StringBuilder r0 = r3.getGaidError()
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x00d6
            goto L_0x0072
        L_0x00d6:
            java.lang.String r0 = r3.getAdvertisingId()
            if (r0 == 0) goto L_0x0104
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00e3
            goto L_0x0104
        L_0x00e3:
            com.appsflyer.internal.AFh1oSDK r0 = r1.component1
            java.lang.String r2 = r3.getAdvertisingId()
            r0.AFAdRevenueData = r2
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.getRevenue = r2
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r0.getMonetizationNetwork = r3
            r0.getMediationNetwork = r2
            r0.getCurrencyIso4217Code = r3
            r2 = 2
            r3 = r22
            if (r3 == r2) goto L_0x00fd
            r10 = 1
        L_0x00fd:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r10)
            r0.component2 = r2
            return r4
        L_0x0104:
            return r10
        L_0x0105:
            java.lang.StringBuilder r2 = r3.getGaidError()
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x011c
            com.appsflyer.internal.AFh1oSDK r2 = r1.component1
            java.lang.StringBuilder r3 = r3.getGaidError()
            java.lang.String r3 = r3.toString()
            AFAdRevenueData((com.appsflyer.internal.AFh1oSDK) r2, (java.lang.String) r3)
        L_0x011c:
            throw r0
        L_0x011d:
            r7 = 4
            r8 = 0
            java.lang.String r5 = "Not running in Samsung Cloud Environment. Try using GMS..."
            r6 = 0
            r3 = r0
            r4 = r9
            com.appsflyer.internal.AFg1gSDK.i$default(r3, r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1eSDK.getMonetizationNetwork(int):boolean");
    }

    @NotNull
    @VisibleForTesting(otherwise = 4)
    public final AFe1rSDK getCurrencyIso4217Code() {
        AFe1rSDK aFe1rSDK;
        if (this.component2.getMonetizationNetwork()) {
            AFg1gSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "QUEUE: Advertising ID collection is disabled. Skipping fetching... ", false, 4, (Object) null);
            return AFe1rSDK.FAILURE;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Boolean bool = Boolean.FALSE;
        if (CollectionsKt.t(Boolean.valueOf(equals()), bool, bool).contains(Boolean.TRUE)) {
            aFe1rSDK = AFe1rSDK.SUCCESS;
        } else {
            aFe1rSDK = AFe1rSDK.FAILURE;
        }
        AFc1kSDK aFc1kSDK = this.component2;
        AFd1hSDK aFd1hSDK = new AFd1hSDK(System.currentTimeMillis() - currentTimeMillis);
        AFLogger aFLogger = AFLogger.INSTANCE;
        AFg1cSDK aFg1cSDK = AFg1cSDK.ADVERTISING_ID;
        long j = aFd1hSDK.getRevenue;
        AFg1gSDK.v$default(aFLogger, aFg1cSDK, "QUEUE: FetchAdvertisingIdTask: took " + j + "ms", false, 4, (Object) null);
        aFc1kSDK.getRevenue(aFd1hSDK);
        return aFe1rSDK;
    }

    public final boolean getMediationNetwork() {
        return false;
    }

    private final boolean getMediationNetwork(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return getMonetizationNetwork(i);
        }
        return false;
    }

    private static int getCurrencyIso4217Code(Context context) {
        try {
            return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        } catch (Throwable th) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.ADVERTISING_ID, "isGooglePlayServicesAvailable error", th, false, false, false, false, 96, (Object) null);
            return -1;
        }
    }

    private final boolean getCurrencyIso4217Code(Context context, AFa1ySDK aFa1ySDK) throws IllegalStateException {
        Unit unit;
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo != null) {
                aFa1ySDK.setAdvertisingId(advertisingIdInfo.getId());
                aFa1ySDK.setLimitAdTrackingEnabled(Boolean.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled()));
                aFa1ySDK.setAdvertisingIdWithGps(true);
                String advertisingId = aFa1ySDK.getAdvertisingId();
                if (advertisingId != null) {
                    if (advertisingId.length() == 0) {
                    }
                    unit = Unit.f696a;
                }
                aFa1ySDK.getGaidError().append("emptyOrNull |");
                unit = Unit.f696a;
            } else {
                unit = null;
            }
            if (unit != null) {
                return true;
            }
            aFa1ySDK.getGaidError().append("gpsAdInfo-null |");
            throw new IllegalStateException("GpsAdIndo is null");
        } catch (Throwable th) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1cSDK aFg1cSDK = AFg1cSDK.ADVERTISING_ID;
            AFLogger aFLogger2 = aFLogger;
            AFg1cSDK aFg1cSDK2 = aFg1cSDK;
            AFg1gSDK.e$default(aFLogger2, aFg1cSDK2, e.B("Google Play Services is missing ", th.getMessage()), th, false, false, false, false, 88, (Object) null);
            StringBuilder gaidError = aFa1ySDK.getGaidError();
            gaidError.append(th.getClass().getSimpleName());
            gaidError.append(" |");
            AFg1gSDK.i$default(aFLogger2, aFg1cSDK2, "WARNING: Google Play Services is missing.", false, 4, (Object) null);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030 A[Catch:{ all -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032 A[Catch:{ all -> 0x0021 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean AFAdRevenueData(android.content.Context r13, com.appsflyer.internal.AFe1eSDK.AFa1ySDK r14) throws java.lang.IllegalStateException {
        /*
            r12 = this;
            com.appsflyer.internal.AFb1vSDK$AFa1vSDK r13 = com.appsflyer.internal.AFb1vSDK.AFAdRevenueData(r13)     // Catch:{ all -> 0x0021 }
            java.lang.String r0 = r13.AFAdRevenueData     // Catch:{ all -> 0x0021 }
            r14.setAdvertisingId(r0)     // Catch:{ all -> 0x0021 }
            boolean r13 = r13.getCurrencyIso4217Code()     // Catch:{ all -> 0x0021 }
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch:{ all -> 0x0021 }
            r14.setLimitAdTrackingEnabled(r13)     // Catch:{ all -> 0x0021 }
            java.lang.String r13 = r14.getAdvertisingId()     // Catch:{ all -> 0x0021 }
            if (r13 == 0) goto L_0x0023
            int r13 = r13.length()     // Catch:{ all -> 0x0021 }
            if (r13 != 0) goto L_0x002c
            goto L_0x0023
        L_0x0021:
            r13 = move-exception
            goto L_0x0043
        L_0x0023:
            java.lang.StringBuilder r13 = r14.getGaidError()     // Catch:{ all -> 0x0021 }
            java.lang.String r0 = "emptyOrNull (bypass) |"
            r13.append(r0)     // Catch:{ all -> 0x0021 }
        L_0x002c:
            kotlin.Unit r13 = kotlin.Unit.f696a     // Catch:{ all -> 0x0021 }
            if (r13 == 0) goto L_0x0032
            r13 = 1
            goto L_0x0088
        L_0x0032:
            java.lang.StringBuilder r13 = r14.getGaidError()     // Catch:{ all -> 0x0021 }
            java.lang.String r0 = "gpsAdInfo-null (bypass) |"
            r13.append(r0)     // Catch:{ all -> 0x0021 }
            java.lang.String r13 = "GpsAdInfo is null (bypass)"
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0021 }
            r0.<init>(r13)     // Catch:{ all -> 0x0021 }
            throw r0     // Catch:{ all -> 0x0021 }
        L_0x0043:
            com.appsflyer.AFLogger r10 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r11 = com.appsflyer.internal.AFg1cSDK.ADVERTISING_ID
            java.lang.String r0 = r13.getMessage()
            java.lang.String r1 = "Failed to fetch GAID: "
            java.lang.String r2 = defpackage.e.B(r1, r0)
            r8 = 64
            r9 = 0
            r4 = 1
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r10
            r1 = r11
            r3 = r13
            com.appsflyer.internal.AFg1gSDK.e$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            java.lang.StringBuilder r14 = r14.getGaidError()
            java.lang.Class r0 = r13.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r14.append(r0)
            java.lang.String r0 = " |"
            r14.append(r0)
            java.lang.String r14 = r13.getLocalizedMessage()
            if (r14 != 0) goto L_0x007e
            java.lang.String r13 = r13.toString()
            r2 = r13
            goto L_0x007f
        L_0x007e:
            r2 = r14
        L_0x007f:
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r10
            r1 = r11
            com.appsflyer.internal.AFg1gSDK.i$default(r0, r1, r2, r3, r4, r5)
            r13 = 0
        L_0x0088:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1eSDK.AFAdRevenueData(android.content.Context, com.appsflyer.internal.AFe1eSDK$AFa1ySDK):boolean");
    }

    @VisibleForTesting(otherwise = 4)
    public final long getMonetizationNetwork() {
        return ((Number) this.component4.getValue()).longValue();
    }

    private static void AFAdRevenueData(AFh1oSDK aFh1oSDK, String str) {
        String m;
        if (str != null) {
            String str2 = aFh1oSDK.areAllFieldsValid;
            if (!(str2 == null || (m = e.m(str2, " | ", str)) == null)) {
                str = m;
            }
            aFh1oSDK.areAllFieldsValid = str;
        }
    }
}
