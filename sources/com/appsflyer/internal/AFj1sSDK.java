package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFj1qSDK;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class AFj1sSDK {
    public final List<AFj1qSDK> getCurrencyIso4217Code = new ArrayList();
    public final AFc1dSDK getMediationNetwork;

    public AFj1sSDK(AFc1dSDK aFc1dSDK) {
        this.getMediationNetwork = aFc1dSDK;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void component2(Runnable runnable) {
        AFj1zSDK aFj1zSDK = new AFj1zSDK(this.getMediationNetwork.getRevenue(), this.getMediationNetwork.getMonetizationNetwork(), AFj1ySDK.INSTAGRAM, runnable, new o(this, runnable, 3));
        getMediationNetwork((AFj1qSDK) aFj1zSDK);
        aFj1zSDK.getRevenue(this.getMediationNetwork.AFInAppEventType().getMonetizationNetwork);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void getCurrencyIso4217Code() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void getMonetizationNetwork(AFi1aSDK aFi1aSDK, Runnable runnable) {
        AFc1qSDK component2 = this.getMediationNetwork.component2();
        boolean z = false;
        int AFAdRevenueData = this.getMediationNetwork.getRevenue().getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0);
        boolean mediationNetwork = component2.getMediationNetwork(AppsFlyerProperties.NEW_REFERRER_SENT, false);
        if (aFi1aSDK.component4 == AFj1qSDK.AFa1ySDK.NOT_STARTED) {
            z = true;
        }
        if (AFAdRevenueData != 1) {
            return;
        }
        if (z || mediationNetwork) {
            runnable.run();
        }
    }

    public final AFi1aSDK AFAdRevenueData(Runnable runnable) {
        return new AFi1aSDK(new o(this, runnable, 0), this.getMediationNetwork.getMonetizationNetwork(), this.getMediationNetwork.getRevenue());
    }

    public final synchronized void getMediationNetwork(AFj1qSDK aFj1qSDK) {
        this.getCurrencyIso4217Code.add(aFj1qSDK);
    }

    @NonNull
    public final synchronized AFj1qSDK[] getRevenue() {
        return (AFj1qSDK[]) this.getCurrencyIso4217Code.toArray(new AFj1qSDK[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void getCurrencyIso4217Code(Runnable runnable) {
        AFj1dSDK.getMediationNetwork(this.getMediationNetwork.AFAdRevenueData(), new o(this, runnable, 1), 0, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void getRevenue(Runnable runnable) {
        try {
            if (getCurrencyIso4217Code((AFh1rSDK) new AFh1kSDK())) {
                runnable.run();
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
        }
    }

    @VisibleForTesting
    public final void getMediationNetwork(Runnable runnable) {
        getMediationNetwork((AFj1qSDK) new AFj1zSDK(this.getMediationNetwork.getRevenue(), this.getMediationNetwork.getMonetizationNetwork(), AFj1ySDK.FACEBOOK, runnable, new o(this, runnable, 2)));
    }

    public final Runnable AFAdRevenueData(AFi1aSDK aFi1aSDK, Runnable runnable) {
        return new m0(this, 20, aFi1aSDK, runnable);
    }

    public final boolean getCurrencyIso4217Code(AFh1rSDK aFh1rSDK) {
        int AFAdRevenueData = this.getMediationNetwork.getRevenue().getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0);
        return (!this.getMediationNetwork.component2().getMediationNetwork(AppsFlyerProperties.NEW_REFERRER_SENT, false) && AFAdRevenueData == 1) || (AFAdRevenueData == 1 && !(aFh1rSDK instanceof AFh1kSDK));
    }

    public final boolean AFAdRevenueData() {
        for (AFj1qSDK aFj1qSDK : this.getCurrencyIso4217Code) {
            if (aFj1qSDK.component4 == AFj1qSDK.AFa1ySDK.STARTED) {
                return false;
            }
        }
        return true;
    }

    @VisibleForTesting
    public final boolean getMonetizationNetwork() {
        return this.getMediationNetwork.getRevenue().getMonetizationNetwork("AF_PREINSTALL_DISABLED", false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void getMonetizationNetwork(Runnable runnable) {
        AFj1zSDK aFj1zSDK = new AFj1zSDK(this.getMediationNetwork.getRevenue(), this.getMediationNetwork.getMonetizationNetwork(), AFj1ySDK.FACEBOOK_LITE, runnable, new v(7));
        getMediationNetwork((AFj1qSDK) aFj1zSDK);
        aFj1zSDK.getRevenue(this.getMediationNetwork.AFInAppEventType().getMonetizationNetwork);
    }
}
