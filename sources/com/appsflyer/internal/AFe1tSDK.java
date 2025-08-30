package com.appsflyer.internal;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000 \t2\u00020\u0001:\u0004\t\n\u000b\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00028\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/appsflyer/internal/AFe1tSDK;", "", "", "p0", "<init>", "(Ljava/lang/String;)V", "getMediationNetwork", "Ljava/lang/String;", "AFAdRevenueData", "AFa1zSDK", "AFa1tSDK", "AFa1vSDK", "AFa1uSDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AFe1tSDK {
    @NotNull
    public static final AFa1zSDK AFa1zSDK = new AFa1zSDK((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final List<String> getRevenue = CollectionsKt.t(AFInAppEventType.ACHIEVEMENT_UNLOCKED, AFInAppEventType.AD_CLICK, AFInAppEventType.AD_VIEW, AFInAppEventType.ADD_PAYMENT_INFO, AFInAppEventType.ADD_TO_CART, AFInAppEventType.ADD_TO_WISH_LIST, AFInAppEventType.COMPLETE_REGISTRATION, AFInAppEventType.CONTENT_VIEW, AFInAppEventType.INITIATED_CHECKOUT, AFInAppEventType.INVITE, AFInAppEventType.LEVEL_ACHIEVED, AFInAppEventType.LIST_VIEW, AFInAppEventType.LOGIN, AFInAppEventType.OPENED_FROM_PUSH_NOTIFICATION, AFInAppEventType.PURCHASE, AFInAppEventType.RATE, AFInAppEventType.RE_ENGAGE, AFInAppEventType.SEARCH, AFInAppEventType.SHARE, AFInAppEventType.SPENT_CREDIT, AFInAppEventType.START_TRIAL, AFInAppEventType.SUBSCRIBE, AFInAppEventType.TRAVEL_BOOKING, AFInAppEventType.TUTORIAL_COMPLETION, AFInAppEventType.UPDATE);
    @NotNull
    public final String getMediationNetwork;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/appsflyer/internal/AFe1tSDK$AFa1tSDK;", "Lcom/appsflyer/internal/AFe1tSDK;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1tSDK extends AFe1tSDK {
        @NotNull
        public static final AFa1tSDK INSTANCE = new AFa1tSDK();

        private AFa1tSDK() {
            super("install");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/appsflyer/internal/AFe1tSDK$AFa1uSDK;", "Lcom/appsflyer/internal/AFe1tSDK;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1uSDK extends AFe1tSDK {
        @NotNull
        public static final AFa1uSDK INSTANCE = new AFa1uSDK();

        private AFa1uSDK() {
            super("af_sandbox_revenue");
        }
    }

    public static final class AFa1vSDK extends AFe1tSDK {
        @Nullable
        public final Integer getCurrencyIso4217Code;
        @NotNull
        private final String getMonetizationNetwork;
        @Nullable
        public final Float getRevenue;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AFa1vSDK(@NotNull String str, @Nullable Float f, @Nullable Integer num) {
            super(str);
            Intrinsics.checkNotNullParameter(str, "");
            this.getMonetizationNetwork = str;
            this.getRevenue = f;
            this.getCurrencyIso4217Code = num;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AFa1vSDK)) {
                return false;
            }
            AFa1vSDK aFa1vSDK = (AFa1vSDK) obj;
            if (Intrinsics.a(this.getMonetizationNetwork, aFa1vSDK.getMonetizationNetwork) && Intrinsics.a(this.getRevenue, aFa1vSDK.getRevenue) && Intrinsics.a(this.getCurrencyIso4217Code, aFa1vSDK.getCurrencyIso4217Code)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i;
            int hashCode = this.getMonetizationNetwork.hashCode() * 31;
            Float f = this.getRevenue;
            int i2 = 0;
            if (f == null) {
                i = 0;
            } else {
                i = f.hashCode();
            }
            int i3 = (hashCode + i) * 31;
            Integer num = this.getCurrencyIso4217Code;
            if (num != null) {
                i2 = num.hashCode();
            }
            return i3 + i2;
        }

        @NotNull
        public final String toString() {
            String str = this.getMonetizationNetwork;
            Float f = this.getRevenue;
            Integer num = this.getCurrencyIso4217Code;
            return "PredefinedInAppEvent(name=" + str + ", eventRevenue=" + f + ", eventCounter=" + num + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b"}, d2 = {"Lcom/appsflyer/internal/AFe1tSDK$AFa1zSDK;", "", "<init>", "()V", "Lcom/appsflyer/internal/AFh1rSDK;", "p0", "Lcom/appsflyer/internal/AFe1tSDK;", "getRevenue", "(Lcom/appsflyer/internal/AFh1rSDK;)Lcom/appsflyer/internal/AFe1tSDK;", "", "", "Ljava/util/List;", "getCurrencyIso4217Code"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1zSDK {
        private AFa1zSDK() {
        }

        @Nullable
        public static AFe1tSDK getRevenue(@NotNull AFh1rSDK aFh1rSDK) {
            Float f;
            String obj;
            Object obj2;
            String obj3;
            Intrinsics.checkNotNullParameter(aFh1rSDK, "");
            if (aFh1rSDK.getCurrencyIso4217Code() == AFe1mSDK.CONVERSION) {
                return AFa1tSDK.INSTANCE;
            }
            Integer num = null;
            if (aFh1rSDK.getCurrencyIso4217Code() != AFe1mSDK.INAPP || !AFe1tSDK.getRevenue.contains(aFh1rSDK.areAllFieldsValid)) {
                return null;
            }
            Map<String, Object> map = aFh1rSDK.getMonetizationNetwork;
            if (map == null || (obj2 = map.get(AFInAppEventParameterName.REVENUE)) == null || (obj3 = obj2.toString()) == null) {
                f = null;
            } else {
                f = StringsKt.O(obj3);
            }
            Object obj4 = aFh1rSDK.AFAdRevenueData.get("iaecounter");
            if (!(obj4 == null || (obj = obj4.toString()) == null)) {
                num = StringsKt.toIntOrNull(obj);
            }
            String str = aFh1rSDK.areAllFieldsValid;
            Intrinsics.checkNotNullExpressionValue(str, "");
            return new AFa1vSDK(str, f, num);
        }

        public /* synthetic */ AFa1zSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AFe1tSDK(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getMediationNetwork = str;
    }
}
