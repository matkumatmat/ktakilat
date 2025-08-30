package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.appsflyer.AFLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFg1xSDK {
    @NotNull
    private final String getCurrencyIso4217Code;
    @Nullable
    private final PackageManager getMediationNetwork;
    @NotNull
    private final Map<String, Object> getRevenue = new LinkedHashMap();

    public AFg1xSDK(@NotNull AFc1iSDK aFc1iSDK, @NotNull AFc1pSDK aFc1pSDK) {
        PackageManager packageManager;
        Intrinsics.checkNotNullParameter(aFc1iSDK, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Context context = aFc1iSDK.getMonetizationNetwork;
        if (context != null) {
            packageManager = context.getPackageManager();
        } else {
            packageManager = null;
        }
        this.getMediationNetwork = packageManager;
        String packageName = aFc1pSDK.getRevenue.getMonetizationNetwork.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "");
        this.getCurrencyIso4217Code = packageName;
    }

    @NotNull
    public final Map<String, Object> getCurrencyIso4217Code() {
        InstallSourceInfo a2;
        String installerPackageName;
        if (this.getRevenue.isEmpty()) {
            try {
                PackageManager packageManager = this.getMediationNetwork;
                if (!(packageManager == null || (installerPackageName = packageManager.getInstallerPackageName(this.getCurrencyIso4217Code)) == null)) {
                    this.getRevenue.put("installer_package", installerPackageName);
                }
            } catch (Exception e) {
                AFLogger.afErrorLog("Exception while getting the app's installer package. ", e);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                Map<String, Object> map = this.getRevenue;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str = this.getCurrencyIso4217Code;
                PackageManager packageManager2 = this.getMediationNetwork;
                if (!(packageManager2 == null || (a2 = packageManager2.getInstallSourceInfo(str)) == null)) {
                    Intrinsics.checkNotNullExpressionValue(a2, "");
                    linkedHashMap = new LinkedHashMap();
                    String b = a2.getInitiatingPackageName();
                    if (b != null) {
                        linkedHashMap.put("initiating_package", b);
                    }
                    String d = a2.getInstallingPackageName();
                    if (d != null) {
                        linkedHashMap.put("installing_package", d);
                    }
                    String e2 = a2.getOriginatingPackageName();
                    if (e2 != null) {
                        linkedHashMap.put("originating_package", e2);
                    }
                }
                map.put("install_source_info", linkedHashMap);
            }
        }
        return this.getRevenue;
    }
}
