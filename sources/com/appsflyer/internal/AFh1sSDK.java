package com.appsflyer.internal;

import com.appsflyer.migration.AppsFlyerMigrationHelper;
import kotlin.jvm.JvmName;

@JvmName(name = "BranchMigrationManagerUtil")
public final class AFh1sSDK {
    public static final boolean getCurrencyIso4217Code() {
        try {
            AppsFlyerMigrationHelper appsFlyerMigrationHelper = AppsFlyerMigrationHelper.INSTANCE;
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
