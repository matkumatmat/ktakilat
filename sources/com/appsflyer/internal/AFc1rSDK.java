package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.util.Arrays;
import java.util.Scanner;

public final class AFc1rSDK {
    String AFAdRevenueData;
    private byte[] getCurrencyIso4217Code;
    public String getMediationNetwork;
    public AFe1mSDK getMonetizationNetwork;
    public String getRevenue;

    public AFc1rSDK(String str, byte[] bArr, String str2, AFe1mSDK aFe1mSDK) {
        this.getRevenue = str;
        this.getCurrencyIso4217Code = bArr;
        this.AFAdRevenueData = str2;
        this.getMonetizationNetwork = aFe1mSDK;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AFc1rSDK.class == obj.getClass()) {
            AFc1rSDK aFc1rSDK = (AFc1rSDK) obj;
            String str = this.AFAdRevenueData;
            if (str == null ? aFc1rSDK.AFAdRevenueData != null : !str.equals(aFc1rSDK.AFAdRevenueData)) {
                return false;
            }
            if (!Arrays.equals(this.getCurrencyIso4217Code, aFc1rSDK.getCurrencyIso4217Code)) {
                return false;
            }
            String str2 = this.getRevenue;
            if (str2 == null ? aFc1rSDK.getRevenue != null : !str2.equals(aFc1rSDK.getRevenue)) {
                return false;
            }
            String str3 = this.getMediationNetwork;
            if (str3 == null ? aFc1rSDK.getMediationNetwork != null : !str3.equals(aFc1rSDK.getMediationNetwork)) {
                return false;
            }
            if (this.getMonetizationNetwork == aFc1rSDK.getMonetizationNetwork) {
                return true;
            }
        }
        return false;
    }

    public final byte[] getMediationNetwork() {
        return this.getCurrencyIso4217Code;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3;
        String str = this.AFAdRevenueData;
        int i4 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int hashCode = (Arrays.hashCode(this.getCurrencyIso4217Code) + (i * 31)) * 31;
        String str2 = this.getRevenue;
        if (str2 != null) {
            i2 = str2.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (hashCode + i2) * 31;
        String str3 = this.getMediationNetwork;
        if (str3 != null) {
            i3 = str3.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (i5 + i3) * 31;
        AFe1mSDK aFe1mSDK = this.getMonetizationNetwork;
        if (aFe1mSDK != null) {
            i4 = aFe1mSDK.hashCode();
        }
        return i6 + i4;
    }

    public AFc1rSDK(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.getRevenue = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.AFAdRevenueData = nextLine.substring(8).trim();
            } else if (nextLine.startsWith("data=")) {
                this.getCurrencyIso4217Code = Base64.decode(nextLine.substring(5).trim(), 2);
            } else if (nextLine.startsWith("type=")) {
                String trim = nextLine.substring(5).trim();
                try {
                    this.getMonetizationNetwork = AFe1mSDK.valueOf(trim);
                } catch (Exception e) {
                    AFLogger.afErrorLog("CACHE: Unknown task type: ".concat(String.valueOf(trim)), e);
                }
            }
        }
        scanner.close();
    }
}
