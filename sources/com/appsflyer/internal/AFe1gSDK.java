package com.appsflyer.internal;

import android.content.Context;
import android.os.Build;
import androidx.annotation.CallSuper;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public abstract class AFe1gSDK extends AFe1dSDK<String> {
    @NotNull
    private final AFe1mSDK component2;
    @NotNull
    private final AFc1pSDK copy;
    @NotNull
    private final AFc1qSDK copydefault;
    @NotNull
    private final Map<String, Object> equals;
    @NotNull
    private final AFg1qSDK hashCode;
    @NotNull
    private final AFf1dSDK toString;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFe1gSDK(@NotNull AFe1mSDK aFe1mSDK, @NotNull AFe1mSDK[] aFe1mSDKArr, @NotNull AFc1dSDK aFc1dSDK, @Nullable String str, @NotNull Map<String, ? extends Object> map) {
        super(aFe1mSDK, aFe1mSDKArr, aFc1dSDK, (String) null);
        Intrinsics.checkNotNullParameter(aFe1mSDK, "");
        Intrinsics.checkNotNullParameter(aFe1mSDKArr, "");
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.component2 = aFe1mSDK;
        this.equals = map;
        AFc1pSDK revenue = aFc1dSDK.getRevenue();
        Intrinsics.checkNotNullExpressionValue(revenue, "");
        this.copy = revenue;
        AFc1qSDK component22 = aFc1dSDK.component2();
        Intrinsics.checkNotNullExpressionValue(component22, "");
        this.copydefault = component22;
        AFg1qSDK component3 = aFc1dSDK.component3();
        Intrinsics.checkNotNullExpressionValue(component3, "");
        this.hashCode = component3;
        AFf1dSDK afErrorLog = aFc1dSDK.afErrorLog();
        Intrinsics.checkNotNullExpressionValue(afErrorLog, "");
        this.toString = afErrorLog;
    }

    @Nullable
    public abstract AFd1nSDK<String> AFAdRevenueData(@NotNull Map<String, Object> map, @NotNull String str, @Nullable String str2);

    @Nullable
    public String AFAdRevenueData(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return null;
    }

    public boolean component1() {
        return false;
    }

    @Nullable
    public final AppsFlyerRequestListener component3() {
        return null;
    }

    public final boolean copydefault() {
        return true;
    }

    @CallSuper
    public void getMediationNetwork(@NotNull Map<String, Object> map, @Nullable String str) {
        Intrinsics.checkNotNullParameter(map, "");
        map.put("app_id", this.copy.getRevenue.getMonetizationNetwork.getPackageName());
        String currencyIso4217Code = AFc1pSDK.getCurrencyIso4217Code();
        if (currencyIso4217Code != null) {
            map.put("cuid", currencyIso4217Code);
        }
        Context context = this.copy.getRevenue.getMonetizationNetwork;
        map.put("app_version_name", AFj1iSDK.getMediationNetwork(context, context.getPackageName()));
        if (component1()) {
            map.put("event_timestamp", Long.valueOf(this.hashCode.AFAdRevenueData()));
        }
        if (str != null) {
            map.put("billing_lib_version", str);
        }
    }

    @Nullable
    public String getMonetizationNetwork(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return null;
    }

    @Nullable
    public final AFd1nSDK<String> getRevenue(@NotNull String str) {
        String str2;
        String str3;
        AFd1cSDK aFd1cSDK;
        Intrinsics.checkNotNullParameter(str, "");
        LinkedHashMap i = MapsKt.i(this.equals);
        String AFAdRevenueData = AFAdRevenueData(i);
        String monetizationNetwork = getMonetizationNetwork(i);
        LinkedHashMap i2 = MapsKt.i(i);
        getMediationNetwork(i2, AFAdRevenueData);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String AFAdRevenueData2 = this.copy.AFAdRevenueData();
        if (AFAdRevenueData2 != null && !StringsKt.t(AFAdRevenueData2)) {
            linkedHashMap.put("advertising_id", AFAdRevenueData2);
        }
        AFb1mSDK mediationNetwork = AFb1jSDK.getMediationNetwork(this.copy.getRevenue.getMonetizationNetwork);
        String str4 = null;
        if (mediationNetwork != null) {
            str2 = mediationNetwork.getMonetizationNetwork;
        } else {
            str2 = null;
        }
        if (str2 != null && !StringsKt.t(str2)) {
            linkedHashMap.put("oaid", str2);
        }
        AFb1mSDK k_ = AFb1jSDK.k_(this.copy.getRevenue.getMonetizationNetwork.getContentResolver());
        if (k_ != null) {
            str3 = k_.getMonetizationNetwork;
        } else {
            str3 = null;
        }
        if (str3 != null && !StringsKt.t(str3)) {
            linkedHashMap.put("amazon_aid", str3);
        }
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            AFf1gSDK aFf1gSDK = this.component3;
            String str5 = (String) AFf1gSDK.getCurrencyIso4217Code(new Object[]{aFf1gSDK, this.copydefault}, -1198101809, 1198101809, System.identityHashCode(aFf1gSDK));
            if (str5 != null && !StringsKt.t(str5)) {
                linkedHashMap.put("imei", str5);
            }
        } else {
            i2.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
        }
        String revenue = AFb1iSDK.getRevenue(this.copy.getMonetizationNetwork);
        if (revenue == null) {
            revenue = "";
        }
        linkedHashMap.put("appsflyer_id", revenue);
        linkedHashMap.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
        linkedHashMap.put("sdk_version", "6.17.0");
        if (monetizationNetwork != null && !StringsKt.t(monetizationNetwork)) {
            linkedHashMap.put("sdk_connector_version", monetizationNetwork);
        }
        i2.put("device_data", linkedHashMap);
        this.toString.AFAdRevenueData(i2, this.component2);
        AFd1nSDK<String> AFAdRevenueData3 = AFAdRevenueData(i2, str, AFAdRevenueData);
        if (!(AFAdRevenueData3 == null || (aFd1cSDK = AFAdRevenueData3.getRevenue) == null)) {
            str4 = aFd1cSDK.getMonetizationNetwork;
        }
        if (str4 != null) {
            JSONObject jSONObject = new JSONObject(i2);
            AFh1ySDK.getCurrencyIso4217Code(toString() + ": preparing data: ", jSONObject);
            AFd1pSDK aFd1pSDK = this.areAllFieldsValid;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "");
            aFd1pSDK.getCurrencyIso4217Code(str4, jSONObject2);
        }
        return AFAdRevenueData3;
    }
}
