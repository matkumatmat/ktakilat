package com.appsflyer.internal;

import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.net.MalformedURLException;
import java.net.URL;

public final class AFf1vSDK extends AFe1dSDK<String> {
    private final AFh1mSDK component2;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AFf1vSDK(@androidx.annotation.NonNull com.appsflyer.internal.AFh1mSDK r8, @androidx.annotation.NonNull com.appsflyer.internal.AFc1dSDK r9) {
        /*
            r7 = this;
            com.appsflyer.internal.AFe1mSDK r0 = r8.toString
            if (r0 == 0) goto L_0x0006
        L_0x0004:
            r2 = r0
            goto L_0x0009
        L_0x0006:
            com.appsflyer.internal.AFe1mSDK r0 = com.appsflyer.internal.AFe1mSDK.CACHED_EVENT
            goto L_0x0004
        L_0x0009:
            r0 = 1
            com.appsflyer.internal.AFe1mSDK[] r3 = new com.appsflyer.internal.AFe1mSDK[r0]
            com.appsflyer.internal.AFe1mSDK r0 = com.appsflyer.internal.AFe1mSDK.RC_CDN
            r1 = 0
            r3[r1] = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r8.getRevenue
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            java.lang.String r1 = getRevenue((com.appsflyer.internal.AFh1mSDK) r8)
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r6 = r8.getRevenue
            r1 = r7
            r4 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            r7.component2 = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1vSDK.<init>(com.appsflyer.internal.AFh1mSDK, com.appsflyer.internal.AFc1dSDK):void");
    }

    private boolean copy() {
        AFd1aSDK<Result> aFd1aSDK;
        AFe1mSDK aFe1mSDK = this.component2.toString;
        if (aFe1mSDK == null) {
            aFe1mSDK = AFe1mSDK.CACHED_EVENT;
        }
        if (aFe1mSDK == AFe1mSDK.ARS_VALIDATE && (aFd1aSDK = this.component1) != null && aFd1aSDK.getStatusCode() == 424) {
            return true;
        }
        return false;
    }

    private boolean equals() {
        boolean z;
        boolean z2;
        AFd1aSDK<Result> aFd1aSDK = this.component1;
        if (this.getMediationNetwork == AFe1rSDK.FAILURE && aFd1aSDK != null && aFd1aSDK.getStatusCode() / 500 == 1) {
            z = true;
        } else {
            z = false;
        }
        AFe1mSDK aFe1mSDK = this.getMonetizationNetwork;
        if (aFe1mSDK == AFe1mSDK.CONVERSION || aFe1mSDK == AFe1mSDK.ATTR) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    @Nullable
    public final AppsFlyerRequestListener component3() {
        return this.component2.getCurrencyIso4217Code;
    }

    public final boolean copydefault() {
        return false;
    }

    public final boolean getMediationNetwork() {
        if (super.getMediationNetwork() || copy() || equals()) {
            return true;
        }
        return false;
    }

    public final AFd1nSDK<String> getRevenue(@NonNull String str) {
        String encodeToString = Base64.encodeToString(this.component2.AFAdRevenueData(), 2);
        AFLogger.afInfoLog("cached data: ".concat(String.valueOf(encodeToString)));
        this.areAllFieldsValid.getCurrencyIso4217Code(this.component2.component1, encodeToString);
        AFd1oSDK aFd1oSDK = this.component4;
        return (AFd1nSDK) AFd1oSDK.getCurrencyIso4217Code(new Object[]{aFd1oSDK, this.component2}, -44698683, 44698684, System.identityHashCode(aFd1oSDK));
    }

    private static String getRevenue(AFh1mSDK aFh1mSDK) {
        try {
            return new URL(aFh1mSDK.component1).getHost();
        } catch (MalformedURLException unused) {
            return "";
        }
    }
}
