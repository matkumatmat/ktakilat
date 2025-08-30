package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class AFd1cSDK {
    @NonNull
    final Map<String, String> AFAdRevenueData;
    @Nullable
    private final byte[] areAllFieldsValid;
    private boolean component1;
    private final boolean component2;
    private final boolean component3;
    public int component4;
    public boolean getCurrencyIso4217Code;
    public boolean getMediationNetwork;
    @NonNull
    public final String getMonetizationNetwork;
    @NonNull
    final String getRevenue;

    public AFd1cSDK(@NonNull String str, @Nullable byte[] bArr, @NonNull String str2, @NonNull Map<String, String> map, boolean z) {
        this(str, bArr, str2, map, z, (byte) 0);
    }

    public final boolean AFAdRevenueData() {
        return this.component2;
    }

    public final boolean component3() {
        return this.getCurrencyIso4217Code;
    }

    public final boolean getCurrencyIso4217Code() {
        return this.component3;
    }

    public final boolean getMediationNetwork() {
        return this.component1;
    }

    public final boolean getMonetizationNetwork() {
        return this.getMediationNetwork;
    }

    @Nullable
    public final byte[] getRevenue() {
        return this.areAllFieldsValid;
    }

    private AFd1cSDK(@NonNull String str, @Nullable byte[] bArr, @NonNull String str2, @NonNull Map<String, String> map, boolean z, byte b) {
        this.component1 = true;
        this.getMediationNetwork = false;
        this.getCurrencyIso4217Code = true;
        this.component4 = -1;
        this.getMonetizationNetwork = str;
        this.areAllFieldsValid = bArr;
        this.getRevenue = str2;
        this.AFAdRevenueData = map;
        this.component2 = z;
        this.component3 = true;
    }

    public AFd1cSDK(@NonNull String str, @NonNull String str2) {
        this(str, (byte[]) null, str2, new HashMap(), false);
    }
}
