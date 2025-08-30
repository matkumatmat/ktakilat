package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u000b\u001a\u00020\b8BX\u0002¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0015\u0010\r\u001a\u00020\b8BX\u0002¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0011\u0010\u000e\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0010\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\f\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000f"}, d2 = {"Lcom/appsflyer/internal/AFe1zSDK;", "", "Lcom/appsflyer/internal/AFc1pSDK;", "p0", "Lcom/appsflyer/internal/AFc1qSDK;", "p1", "<init>", "(Lcom/appsflyer/internal/AFc1pSDK;Lcom/appsflyer/internal/AFc1qSDK;)V", "", "areAllFieldsValid", "Lkotlin/Lazy;", "getRevenue", "AFAdRevenueData", "getMonetizationNetwork", "getMediationNetwork", "()Ljava/lang/String;", "getCurrencyIso4217Code", "Lcom/appsflyer/internal/AFc1pSDK;", "", "()Z", "Lcom/appsflyer/internal/AFc1qSDK;", "component4", "component3", "AFa1ySDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFe1zSDK {
    @NotNull
    public static final AFa1ySDK AFa1ySDK = new AFa1ySDK((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final List<String> component1 = CollectionsKt.t("googleplay", "playstore", "googleplaystore");
    /* access modifiers changed from: private */
    @Nullable
    public static AFe1vSDK component3;
    @NotNull
    public static String getMediationNetwork = "https://%scdn-%ssettings.%s/android/v1/%s/settings";
    @NotNull
    public static String getRevenue = "https://%scdn-%stestsettings.%s/android/v1/%s/settings";
    @NotNull
    public final Lazy AFAdRevenueData = LazyKt.b(new Function0<String>(this) {
        private /* synthetic */ AFe1zSDK getRevenue;

        {
            this.getRevenue = r1;
        }

        @NotNull
        /* renamed from: getMediationNetwork */
        public final String invoke() {
            String packageName = this.getRevenue.getCurrencyIso4217Code.getRevenue.getMonetizationNetwork.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "");
            return AFe1zSDK.getMonetizationNetwork(packageName, AFe1zSDK.getCurrencyIso4217Code(this.getRevenue));
        }
    });
    @NotNull
    private final Lazy areAllFieldsValid = LazyKt.b(new Function0<String>(this) {
        private /* synthetic */ AFe1zSDK getMediationNetwork;

        {
            this.getMediationNetwork = r1;
        }

        @NotNull
        /* renamed from: AFAdRevenueData */
        public final String invoke() {
            String monetizationNetwork = AFa1tSDK.getMonetizationNetwork(this.getMediationNetwork.getMonetizationNetwork, this.getMediationNetwork.getCurrencyIso4217Code.component2());
            String str = "";
            if (monetizationNetwork != null && !StringsKt.t(monetizationNetwork)) {
                String obj = StringsKt.Q(monetizationNetwork).toString();
                List<String> revenue = AFa1ySDK.getRevenue();
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, str);
                String lowerCase = obj.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, str);
                if (!revenue.contains(lowerCase)) {
                    monetizationNetwork = "-".concat(obj);
                } else {
                    String format = String.format("AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", Arrays.copyOf(new Object[]{obj}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, str);
                    AFLogger.afWarnLog(format);
                    monetizationNetwork = str;
                }
            }
            if (monetizationNetwork != null) {
                str = monetizationNetwork;
            }
            return StringsKt.Q(str).toString();
        }
    });
    /* access modifiers changed from: private */
    @NotNull
    public final AFc1pSDK getCurrencyIso4217Code;
    /* access modifiers changed from: private */
    @NotNull
    public final AFc1qSDK getMonetizationNetwork;

    public /* synthetic */ class AFa1uSDK {
        public static final /* synthetic */ int[] getCurrencyIso4217Code;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.appsflyer.internal.AFe1wSDK[] r0 = com.appsflyer.internal.AFe1wSDK.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.appsflyer.internal.AFe1wSDK r1 = com.appsflyer.internal.AFe1wSDK.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.appsflyer.internal.AFe1wSDK r1 = com.appsflyer.internal.AFe1wSDK.API     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.appsflyer.internal.AFe1wSDK r1 = com.appsflyer.internal.AFe1wSDK.RC     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                getCurrencyIso4217Code = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1zSDK.AFa1uSDK.<clinit>():void");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u00058\u0006@\u0006X\f¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\f¢\u0006\u0006\n\u0004\b\b\u0010\fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\"\u0004\b\u000b\u0010\u0011"}, d2 = {"Lcom/appsflyer/internal/AFe1zSDK$AFa1ySDK;", "", "<init>", "()V", "", "", "component1", "Ljava/util/List;", "getRevenue", "()Ljava/util/List;", "AFAdRevenueData", "getMediationNetwork", "Ljava/lang/String;", "getCurrencyIso4217Code", "Lcom/appsflyer/internal/AFe1vSDK;", "component3", "Lcom/appsflyer/internal/AFe1vSDK;", "(Lcom/appsflyer/internal/AFe1vSDK;)V", "getMonetizationNetwork"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1ySDK {
        private AFa1ySDK() {
        }

        @JvmName(name = "getMediationNetwork")
        public static void getMediationNetwork(@Nullable AFe1vSDK aFe1vSDK) {
            AFe1zSDK.component3 = aFe1vSDK;
        }

        @NotNull
        @JvmName(name = "getRevenue")
        public static List<String> getRevenue() {
            return AFe1zSDK.component1;
        }

        public /* synthetic */ AFa1ySDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AFe1zSDK(@NotNull AFc1pSDK aFc1pSDK, @NotNull AFc1qSDK aFc1qSDK) {
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFc1qSDK, "");
        this.getCurrencyIso4217Code = aFc1pSDK;
        this.getMonetizationNetwork = aFc1qSDK;
    }

    @JvmName(name = "AFAdRevenueData")
    public static boolean AFAdRevenueData() {
        if (component3 == null) {
            return true;
        }
        return false;
    }

    public static final /* synthetic */ String getMonetizationNetwork(String str, String str2) {
        String str3 = str + str2;
        Intrinsics.checkNotNullParameter(str3, "");
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str3.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        byte[] digest = instance.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "");
        String encodeToString = Base64.encodeToString(digest, 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "");
        String lowerCase = encodeToString.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        String substring = new Regex("[^\\w]+").replace((CharSequence) lowerCase, "").substring(0, 6);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        return substring + ".";
    }

    @NotNull
    @JvmName(name = "getCurrencyIso4217Code")
    public final String getCurrencyIso4217Code() {
        AFe1wSDK aFe1wSDK;
        if (AFAdRevenueData()) {
            aFe1wSDK = AFe1wSDK.DEFAULT;
        } else {
            aFe1wSDK = AFe1wSDK.API;
        }
        int i = AFa1uSDK.getCurrencyIso4217Code[aFe1wSDK.ordinal()];
        if (i == 1) {
            return (String) this.AFAdRevenueData.getValue();
        }
        if (i == 2) {
            AFe1vSDK aFe1vSDK = component3;
            String str = aFe1vSDK != null ? aFe1vSDK.AFAdRevenueData : null;
            if (str == null) {
                return "";
            }
            return str;
        } else if (i == 3) {
            return "";
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    @JvmName(name = "getMediationNetwork")
    public final String getMediationNetwork() {
        AFe1wSDK aFe1wSDK;
        if (AFAdRevenueData()) {
            aFe1wSDK = AFe1wSDK.DEFAULT;
        } else {
            aFe1wSDK = AFe1wSDK.API;
        }
        int i = AFa1uSDK.getCurrencyIso4217Code[aFe1wSDK.ordinal()];
        if (i == 1) {
            return "appsflyersdk.com";
        }
        if (i == 2) {
            AFe1vSDK aFe1vSDK = component3;
            String str = aFe1vSDK != null ? aFe1vSDK.getMediationNetwork : null;
            if (str == null) {
                return "";
            }
            return str;
        } else if (i == 3) {
            return "";
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final /* synthetic */ String getCurrencyIso4217Code(AFe1zSDK aFe1zSDK) {
        return (String) aFe1zSDK.areAllFieldsValid.getValue();
    }

    public static final void getMediationNetwork(@Nullable AFe1vSDK aFe1vSDK) {
        AFa1ySDK.getMediationNetwork(aFe1vSDK);
    }
}
