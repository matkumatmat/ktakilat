package com.appsflyer.internal;

import androidx.annotation.Nullable;

public final class AFk1ySDK {
    public static boolean getCurrencyIso4217Code(@Nullable String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean getMediationNetwork(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }
}
