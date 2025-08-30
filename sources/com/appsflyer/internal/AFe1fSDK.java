package com.appsflyer.internal;

import com.appsflyer.AFPurchaseDetails;
import com.appsflyer.AppsFlyerInAppPurchaseValidationCallback;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\u0001*BK\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u0014\u0010\u0015JC\u0010\u0017\u001a\u000e\u0012\b\u0012\u0006*\u00020\t0\t\u0018\u00010\u00162\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0006\u0010\u0005\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0017¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0017\u001a\u00020\t2\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H\u0015¢\u0006\u0004\b\u0017\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001b\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u001b\u0010\u001dR\"\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0017\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010("}, d2 = {"Lcom/appsflyer/internal/AFe1fSDK;", "Lcom/appsflyer/internal/AFe1gSDK;", "Lcom/appsflyer/internal/AFc1dSDK;", "p0", "Lcom/appsflyer/AppsFlyerProperties;", "p1", "Lcom/appsflyer/AFPurchaseDetails;", "p2", "", "", "p3", "Lcom/appsflyer/AppsFlyerInAppPurchaseValidationCallback;", "p4", "Lcom/appsflyer/internal/AFj1hSDK;", "p5", "<init>", "(Lcom/appsflyer/internal/AFc1dSDK;Lcom/appsflyer/AppsFlyerProperties;Lcom/appsflyer/AFPurchaseDetails;Ljava/util/Map;Lcom/appsflyer/AppsFlyerInAppPurchaseValidationCallback;Lcom/appsflyer/internal/AFj1hSDK;)V", "", "", "", "getMediationNetwork", "(Ljava/util/Map;Ljava/lang/String;)V", "Lcom/appsflyer/internal/AFd1nSDK;", "AFAdRevenueData", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/appsflyer/internal/AFd1nSDK;", "(Ljava/util/Map;)Ljava/lang/String;", "", "getRevenue", "(Ljava/lang/String;I)V", "()V", "toString", "Ljava/util/Map;", "getMonetizationNetwork", "copy", "Lcom/appsflyer/internal/AFj1hSDK;", "hashCode", "Lcom/appsflyer/AppsFlyerInAppPurchaseValidationCallback;", "component2", "Lcom/appsflyer/AppsFlyerProperties;", "equals", "Lcom/appsflyer/AFPurchaseDetails;", "getCurrencyIso4217Code", "AFa1tSDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nManualValidationTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ManualValidationTask.kt\ncom/appsflyer/internal/components/queue/tasks/ManualValidationTask\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,144:1\n1747#2,3:145\n*S KotlinDebug\n*F\n+ 1 ManualValidationTask.kt\ncom/appsflyer/internal/components/queue/tasks/ManualValidationTask\n*L\n98#1:145,3\n*E\n"})
public final class AFe1fSDK extends AFe1gSDK {
    @NotNull
    private final AppsFlyerProperties component2;
    @NotNull
    private final AFj1hSDK copy;
    @NotNull
    private final AFPurchaseDetails equals;
    @Nullable
    private final AppsFlyerInAppPurchaseValidationCallback hashCode;
    @Nullable
    private final Map<String, String> toString;

    public static final class AFa1tSDK extends RuntimeException {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AFe1fSDK(AFc1dSDK aFc1dSDK, AppsFlyerProperties appsFlyerProperties, AFPurchaseDetails aFPurchaseDetails, Map map, AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback, AFj1hSDK aFj1hSDK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFc1dSDK, appsFlyerProperties, aFPurchaseDetails, map, appsFlyerInAppPurchaseValidationCallback, (i & 32) != 0 ? new AFj1gSDK() : aFj1hSDK);
    }

    @NotNull
    public final String AFAdRevenueData(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return this.copy.getRevenue();
    }

    public final void getMediationNetwork(@NotNull Map<String, Object> map, @Nullable String str) {
        Map<String, Object> map2;
        Intrinsics.checkNotNullParameter(map, "");
        super.getMediationNetwork(map, str);
        Iterable<String> t = CollectionsKt.t(this.equals.getPurchaseToken(), this.equals.getProductId(), this.equals.getPrice(), this.equals.getCurrency());
        if (!(t instanceof Collection) || !((Collection) t).isEmpty()) {
            for (String length : t) {
                if (length.length() == 0) {
                    throw new AFa1tSDK();
                }
            }
        }
        map.put("purchase_token", this.equals.getPurchaseToken());
        map.put("product_id", this.equals.getProductId());
        map.put("revenue", this.equals.getPrice());
        map.put(FirebaseAnalytics.Param.CURRENCY, this.equals.getCurrency());
        map.put("purchase_type", this.equals.getPurchaseType().getValue());
        Map<String, String> map3 = this.toString;
        if (map3 != null && !map3.isEmpty()) {
            map.put("extra_event_values", this.toString);
        }
        String string = this.component2.getString(AppsFlyerProperties.ADDITIONAL_CUSTOM_DATA);
        if (string == null || string.length() == 0) {
            map2 = MapsKt.b();
        } else {
            map2 = AFj1eSDK.getCurrencyIso4217Code(new JSONObject(string));
        }
        map.put("custom_data", map2);
    }

    public final void getRevenue() {
        Object obj;
        Unit unit;
        super.getRevenue();
        Throwable component4 = component4();
        if (component4 != null && !(component4 instanceof AFe1oSDK)) {
            if (component4 instanceof AFe1nSDK) {
                getRevenue("No dev key", -1);
            } else if (component4 instanceof AFa1tSDK) {
                getRevenue("One or more of provided arguments is empty", -1);
            } else {
                getRevenue("Error while sending request to server", -1);
            }
        }
        AFd1aSDK<Result> aFd1aSDK = this.component1;
        if (aFd1aSDK == null) {
            return;
        }
        if (aFd1aSDK.getStatusCode() == 200) {
            try {
                Result.Companion companion = Result.Companion;
                AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback = this.hashCode;
                if (appsFlyerInAppPurchaseValidationCallback != null) {
                    appsFlyerInAppPurchaseValidationCallback.onInAppPurchaseValidationFinished(AFj1eSDK.getCurrencyIso4217Code(new JSONObject((String) aFd1aSDK.getBody())));
                    unit = Unit.f696a;
                } else {
                    unit = null;
                }
                obj = Result.m16constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m16constructorimpl(ResultKt.a(th));
            }
            if (Result.m19exceptionOrNullimpl(obj) != null) {
                getRevenue("Error while trying to parse JSON response", aFd1aSDK.getStatusCode());
            }
            Result.m15boximpl(obj);
            return;
        }
        AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback2 = this.hashCode;
        if (appsFlyerInAppPurchaseValidationCallback2 != null) {
            appsFlyerInAppPurchaseValidationCallback2.onInAppPurchaseValidationError(MapsKt.e(new Pair(NativeProtocol.BRIDGE_ARG_ERROR_CODE, Integer.valueOf(aFd1aSDK.getStatusCode())), new Pair(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, aFd1aSDK.getBody())));
        }
    }

    @Nullable
    public final AFd1nSDK<String> AFAdRevenueData(@NotNull Map<String, Object> map, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(str, "");
        return this.component4.getMonetizationNetwork(map, str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    private AFe1fSDK(@NotNull AFc1dSDK aFc1dSDK, @NotNull AppsFlyerProperties appsFlyerProperties, @NotNull AFPurchaseDetails aFPurchaseDetails, @Nullable Map<String, String> map, @Nullable AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback, @NotNull AFj1hSDK aFj1hSDK) {
        super(AFe1mSDK.MANUAL_PURCHASE_VALIDATION, new AFe1mSDK[]{AFe1mSDK.RC_CDN, AFe1mSDK.FETCH_ADVERTISING_ID}, aFc1dSDK, (String) null, MapsKt.b());
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        Intrinsics.checkNotNullParameter(appsFlyerProperties, "");
        Intrinsics.checkNotNullParameter(aFPurchaseDetails, "");
        Intrinsics.checkNotNullParameter(aFj1hSDK, "");
        this.component2 = appsFlyerProperties;
        this.equals = aFPurchaseDetails;
        this.toString = map;
        this.hashCode = appsFlyerInAppPurchaseValidationCallback;
        this.copy = aFj1hSDK;
        this.AFAdRevenueData.add(AFe1mSDK.CONVERSION);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AFe1fSDK(@NotNull AFc1dSDK aFc1dSDK, @NotNull AppsFlyerProperties appsFlyerProperties, @NotNull AFPurchaseDetails aFPurchaseDetails, @Nullable Map<String, String> map, @Nullable AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback) {
        this(aFc1dSDK, appsFlyerProperties, aFPurchaseDetails, map, appsFlyerInAppPurchaseValidationCallback, (AFj1hSDK) null, 32, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        Intrinsics.checkNotNullParameter(appsFlyerProperties, "");
        Intrinsics.checkNotNullParameter(aFPurchaseDetails, "");
    }

    private final void getRevenue(String str, int i) {
        AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback = this.hashCode;
        if (appsFlyerInAppPurchaseValidationCallback != null) {
            appsFlyerInAppPurchaseValidationCallback.onInAppPurchaseValidationError(MapsKt.e(new Pair(NativeProtocol.BRIDGE_ARG_ERROR_CODE, Integer.valueOf(i)), new Pair(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str)));
        }
    }
}
