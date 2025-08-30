package com.appsflyer.internal;

import android.net.Uri;
import com.appsflyer.AFLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00019B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\nJ\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\nJ\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\nJ\u0017\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001e\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b \u0010\u0014J\r\u0010!\u001a\u00020\b¢\u0006\u0004\b!\u0010\nJ\r\u0010\"\u001a\u00020\b¢\u0006\u0004\b\"\u0010\nJ\r\u0010#\u001a\u00020\b¢\u0006\u0004\b#\u0010\nJ\r\u0010$\u001a\u00020\b¢\u0006\u0004\b$\u0010\nJ\r\u0010%\u001a\u00020\b¢\u0006\u0004\b%\u0010\nJ\r\u0010&\u001a\u00020\b¢\u0006\u0004\b&\u0010\nJ\r\u0010'\u001a\u00020\b¢\u0006\u0004\b'\u0010\nJ\u0017\u0010(\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b(\u0010\u001bJ\u000f\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b)\u0010\nJ\u000f\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\nJ\u000f\u0010+\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010\nJ\u000f\u0010,\u001a\u00020\bH\u0002¢\u0006\u0004\b,\u0010\nJ\u001d\u0010/\u001a\u00020\b*\u00020\b2\b\b\u0002\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100J\u001d\u00102\u001a\u00020\b*\u00020\b2\b\b\u0002\u00101\u001a\u00020-H\u0002¢\u0006\u0004\b2\u00100J\u0013\u00103\u001a\u00020\b*\u00020\bH\u0002¢\u0006\u0004\b3\u0010\u001bJ'\u00105\u001a\u000204*\u0002042\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b5\u00106R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u00107R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u00108¨\u0006:"}, d2 = {"Lcom/appsflyer/internal/util/EventUrlResolver;", "", "Lcom/appsflyer/internal/components/IdProvider;", "idProvider", "Lcom/appsflyer/internal/util/ServerConfigUrlFormatter;", "serverConfigUrlFormatter", "<init>", "(Lcom/appsflyer/internal/components/IdProvider;Lcom/appsflyer/internal/util/ServerConfigUrlFormatter;)V", "", "getAdRevenueUrl", "()Ljava/lang/String;", "getAppsTrackingUrl", "getArsBilling4", "getArsBilling5", "getDdlUrl", "getEventsTrackingUrl", "getFirstLaunchUrl", "Lcom/appsflyer/internal/model/event/AFEvent;", "event", "getLaunchUrl", "(Lcom/appsflyer/internal/model/event/AFEvent;)Ljava/lang/String;", "getManualValidatePurchaseUrl", "getPlayIntegrityUrl", "getReferrerTrackingUrl", "getRegisterUrl", "billingVersion", "getUrlForArs", "(Ljava/lang/String;)Ljava/lang/String;", "devKey", "timestamp", "getUrlForDdlEvent", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getUrlForEvent", "getUrlForManualPurchaseValidation", "getUrlForPlayIntegrityReporting", "getUrlForPrivacySandbox", "getUrlForRdMonitor", "getUrlForRegister", "getUrlForValidatePurchase", "getUrlForValidatePurchaseWithWebHandler", "getUrlForViap", "getValidatePurchaseUrl", "getValidatePurchaseWithWebHandlerUrl", "getViapBilling4", "getViapBilling5", "", "isAdRevenueEvent", "appendBuildNumber", "(Ljava/lang/String;Z)Ljava/lang/String;", "isRegisterEvent", "appendConfiguredChannel", "appendPackageName", "Landroid/net/Uri$Builder;", "appendSigQueryParam", "(Landroid/net/Uri$Builder;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;", "Lcom/appsflyer/internal/components/IdProvider;", "Lcom/appsflyer/internal/util/ServerConfigUrlFormatter;", "Companion", "SDK_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEventUrlResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventUrlResolver.kt\ncom/appsflyer/internal/util/EventUrlResolver\n+ 2 StringExtensions.kt\ncom/appsflyer/internal/util/StringExtensionsKt\n*L\n1#1,333:1\n39#2:334\n*S KotlinDebug\n*F\n+ 1 EventUrlResolver.kt\ncom/appsflyer/internal/util/EventUrlResolver\n*L\n184#1:334\n*E\n"})
public final class AFj1fSDK {
    @NotNull
    public static final AFa1vSDK AFAdRevenueData = new AFa1vSDK((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final String areAllFieldsValid;
    @NotNull
    @JvmField
    public static final String component1;
    @NotNull
    @JvmField
    public static final String component2;
    @NotNull
    @JvmField
    public static final String component3;
    @NotNull
    @JvmField
    public static final String component4 = "https://%smonitorsdk.%s/api/remote-debug/v2.0?app_id=";
    @NotNull
    @JvmField
    public static final String getCurrencyIso4217Code = "https://%sadrevenue.%s/api/v2/generic/v6.17.0/android?app_id=";
    @NotNull
    @JvmField
    public static final String getMediationNetwork;
    @NotNull
    @JvmField
    public static final String getRevenue;
    @NotNull
    private static final String toString;
    @NotNull
    public final AFk1xSDK getMonetizationNetwork;
    @NotNull
    private final AFc1pSDK hashCode;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006XD¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006XD¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006"}, d2 = {"Lcom/appsflyer/internal/AFj1fSDK$AFa1vSDK;", "", "<init>", "()V", "", "toString", "Ljava/lang/String;", "AFAdRevenueData", "getCurrencyIso4217Code", "getMediationNetwork", "getMonetizationNetwork", "component2", "getRevenue", "component1", "component4", "areAllFieldsValid", "component3"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1vSDK {
        private AFa1vSDK() {
        }

        public /* synthetic */ AFa1vSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String l = e.l(AFa1tSDK.getRevenue, "/androidevent?app_id=");
        toString = l;
        getRevenue = e.B("https://%sattr.%s/api/v", l);
        getMediationNetwork = e.B("https://%sconversions.%s/api/v", l);
        component1 = e.B("https://%slaunches.%s/api/v", l);
        component2 = e.B("https://%sinapps.%s/api/v", l);
        areAllFieldsValid = e.B("https://%sregister.%s/api/v", l);
        component3 = e.B("https://%svalidate.%s/api/v", l);
    }

    @JvmOverloads
    private AFj1fSDK(@NotNull AFc1pSDK aFc1pSDK, @NotNull AFk1xSDK aFk1xSDK) {
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFk1xSDK, "");
        this.hashCode = aFc1pSDK;
        this.getMonetizationNetwork = aFk1xSDK;
    }

    @NotNull
    public static String getCurrencyIso4217Code() {
        return "https://privacy-sandbox.appsflyersdk.com/api/trigger";
    }

    @NotNull
    public final String AFAdRevenueData(@Nullable String str, @Nullable String str2) {
        String packageName = this.hashCode.getRevenue.getMonetizationNetwork.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "");
        String component22 = this.hashCode.component2();
        if (component22 != null && !StringsKt.t(component22)) {
            component22 = e.B("-", StringsKt.Q(component22).toString());
        }
        if (component22 == null) {
            component22 = "";
        }
        String obj = StringsKt.Q(component22).toString();
        Uri.Builder buildUpon = Uri.parse(this.getMonetizationNetwork.AFAdRevenueData("https://%sdlsdk.%s/v1.0/android/")).buildUpon();
        Uri.Builder appendPath = buildUpon.appendPath(packageName + obj);
        Intrinsics.checkNotNullExpressionValue(appendPath, "");
        if (str == null || str2 == null) {
            String str3 = str == null ? "devKey" : "timestamp";
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, str3.concat(" is null at attempt to generate ddl event url"), new IllegalStateException(str3.concat(" is null")), true, false, false, true);
        } else {
            appendPath.appendQueryParameter("af_sig", AFj1cSDK.getRevenue(str2.concat(str), str));
        }
        String obj2 = appendPath.appendQueryParameter("sdk_version", AFa1tSDK.getRevenue).build().toString();
        Intrinsics.checkNotNullExpressionValue(obj2, "");
        return obj2;
    }

    public final String getRevenue(String str, boolean z) {
        String str2;
        if (z) {
            return str;
        }
        String component22 = this.hashCode.component2();
        if (component22 != null) {
            str2 = "&channel=".concat(component22);
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        return e.l(str, str2);
    }

    public final String getCurrencyIso4217Code(String str) {
        return e.l(str, this.hashCode.getRevenue.getMonetizationNetwork.getPackageName());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AFj1fSDK(AFc1pSDK aFc1pSDK, AFk1xSDK aFk1xSDK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFc1pSDK, (i & 2) != 0 ? new AFk1zSDK() : aFk1xSDK);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AFj1fSDK(@NotNull AFc1pSDK aFc1pSDK) {
        this(aFc1pSDK, (AFk1xSDK) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
    }

    public static String AFAdRevenueData(String str, boolean z) {
        return e.l(str, !z ? "&buildnumber=6.17.0" : "");
    }
}
