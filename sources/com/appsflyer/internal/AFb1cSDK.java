package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class AFb1cSDK implements AFb1hSDK {
    @NotNull
    private final AFf1gSDK getCurrencyIso4217Code;
    @NotNull
    private final AFc1kSDK getMediationNetwork;
    @NotNull
    private final AFc1iSDK getMonetizationNetwork;

    public AFb1cSDK(@NotNull AFc1kSDK aFc1kSDK, @NotNull AFc1iSDK aFc1iSDK, @NotNull AFf1gSDK aFf1gSDK) {
        Intrinsics.checkNotNullParameter(aFc1kSDK, "");
        Intrinsics.checkNotNullParameter(aFc1iSDK, "");
        Intrinsics.checkNotNullParameter(aFf1gSDK, "");
        this.getMediationNetwork = aFc1kSDK;
        this.getMonetizationNetwork = aFc1iSDK;
        this.getCurrencyIso4217Code = aFf1gSDK;
    }

    /* access modifiers changed from: private */
    public static final void AFAdRevenueData(AFb1cSDK aFb1cSDK, AppSetIdInfo appSetIdInfo) {
        Intrinsics.checkNotNullParameter(aFb1cSDK, "");
        AFc1kSDK aFc1kSDK = aFb1cSDK.getMediationNetwork;
        int scope = appSetIdInfo.getScope();
        String id = appSetIdInfo.getId();
        Intrinsics.checkNotNullExpressionValue(id, "");
        aFc1kSDK.toString = new AFb1gSDK(scope, id);
    }

    public final boolean getCurrencyIso4217Code() {
        if (this.getCurrencyIso4217Code.AFAdRevenueData() || this.getMediationNetwork.AFAdRevenueData() || !AFj1iSDK.AFAdRevenueData(this.getMonetizationNetwork.getMonetizationNetwork) || !AFj1iSDK.getCurrencyIso4217Code(this.getMonetizationNetwork.getMonetizationNetwork)) {
            return false;
        }
        return true;
    }

    public final void getMediationNetwork() {
        Context context = this.getMonetizationNetwork.getMonetizationNetwork;
        if (context != null) {
            try {
                Intrinsics.checkNotNullExpressionValue(AppSet.getClient(context).getAppSetIdInfo().addOnSuccessListener(new f(this)), "");
            } catch (Throwable th) {
                AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.APP_SET_ID, "Error while trying to  fetch App set ID", th, false, false, false, false, 120, (Object) null);
                Unit unit = Unit.f696a;
            }
        }
    }
}
