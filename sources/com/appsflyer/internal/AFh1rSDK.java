package com.appsflyer.internal;

import androidx.annotation.Nullable;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

public abstract class AFh1rSDK {
    public Map<String, Object> AFAdRevenueData;
    public String areAllFieldsValid;
    public String component1;
    public int component2;
    public String component3;
    @Nullable
    public String component4;
    private byte[] copy;
    @Nullable
    public AppsFlyerRequestListener getCurrencyIso4217Code;
    @Nullable
    public String getMediationNetwork;
    @Nullable
    public Map<String, Object> getMonetizationNetwork;
    public String getRevenue;
    private final boolean toString;

    public AFh1rSDK() {
        this((String) null, (String) null, (Boolean) null);
    }

    public final AFh1rSDK AFAdRevenueData(int i) {
        this.component2 = i;
        synchronized (this.AFAdRevenueData) {
            try {
                if (this.AFAdRevenueData.containsKey("counter")) {
                    this.AFAdRevenueData.put("counter", Integer.toString(i));
                }
                if (this.AFAdRevenueData.containsKey("launch_counter")) {
                    this.AFAdRevenueData.put("launch_counter", Integer.toString(i));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    public boolean areAllFieldsValid() {
        return false;
    }

    public boolean component2() {
        return true;
    }

    public boolean component4() {
        return true;
    }

    public abstract AFe1mSDK getCurrencyIso4217Code();

    public final AFh1rSDK getCurrencyIso4217Code(byte[] bArr) {
        this.copy = bArr;
        return this;
    }

    public final boolean getMediationNetwork() {
        return this.areAllFieldsValid == null && this.getRevenue == null;
    }

    public final boolean getMonetizationNetwork() {
        return this.toString;
    }

    public boolean getRevenue() {
        return true;
    }

    public AFh1rSDK(@Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
        this.AFAdRevenueData = new HashMap();
        this.areAllFieldsValid = str;
        this.component1 = str2;
        this.toString = bool != null ? bool.booleanValue() : true;
    }

    public static boolean getCurrencyIso4217Code(double d) {
        if (d < 0.0d || d >= 1.0d) {
            return false;
        }
        if (d == 0.0d) {
            return true;
        }
        int i = (int) (1.0d / d);
        if (i + 1 > 0) {
            return ((int) ((Math.random() * ((double) i)) + 1.0d)) != i;
        }
        throw new IllegalArgumentException("Unsupported max value");
    }

    public final AFh1rSDK getMediationNetwork(Map<String, ?> map) {
        synchronized (map) {
            this.AFAdRevenueData.putAll(map);
        }
        return this;
    }

    public final AFh1rSDK getMediationNetwork(String str, Object obj) {
        synchronized (this.AFAdRevenueData) {
            this.AFAdRevenueData.put(str, obj);
        }
        return this;
    }

    public final byte[] AFAdRevenueData() {
        return this.copy;
    }
}
