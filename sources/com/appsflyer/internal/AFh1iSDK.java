package com.appsflyer.internal;

public final class AFh1iSDK extends AFh1rSDK {
    public final boolean areAllFieldsValid() {
        return true;
    }

    public final AFe1mSDK getCurrencyIso4217Code() {
        if (this.component2 == 1) {
            return AFe1mSDK.CONVERSION;
        }
        return AFe1mSDK.LAUNCH;
    }
}
