package com.appsflyer.internal;

import androidx.annotation.Nullable;

public final class AFh1mSDK extends AFh1rSDK {
    @Nullable
    public final AFe1mSDK toString;

    @Deprecated
    public AFh1mSDK() {
        this.toString = null;
    }

    public final AFe1mSDK getCurrencyIso4217Code() {
        AFe1mSDK aFe1mSDK = this.toString;
        if (aFe1mSDK != null) {
            return aFe1mSDK;
        }
        return AFe1mSDK.CACHED_EVENT;
    }

    public AFh1mSDK(String str, byte[] bArr, String str2, @Nullable AFe1mSDK aFe1mSDK) {
        super((String) null, str, Boolean.FALSE);
        this.getRevenue = str2;
        getCurrencyIso4217Code(bArr);
        this.toString = aFe1mSDK;
    }
}
