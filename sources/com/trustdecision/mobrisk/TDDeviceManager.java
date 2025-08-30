package com.trustdecision.mobrisk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.google.common.base.Ascii;
import com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo;
import com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00.O0oOO0ooO;
import com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;
import com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;
import org.apache.commons.lang3.CharEncoding;

public class TDDeviceManager {
    public static final String COLLECT_LEVEL_H = o0Oo0OO00O0O000ooOO0("47", 52);
    public static final String COLLECT_LEVEL_L = o0Oo0OO00O0O000ooOO0("43", 110);
    public static final String COLLECT_LEVEL_M = o0Oo0OO00O0O000ooOO0("42", 71);
    public static final String COUNTRY_CN = o0Oo0OO00O0O000ooOO0("4c79", 61);
    public static final String COUNTRY_FRA = o0Oo0OO00O0O000ooOO0("492d2a", 112);
    public static final String COUNTRY_IDNA = o0Oo0OO00O0O000ooOO0("467a7d78", 62);
    public static final String COUNTRY_SG = o0Oo0OO00O0O000ooOO0("5c39", 100);
    public static final String COUNTRY_US = o0Oo0OO00O0O000ooOO0("5a73", 60);
    public static final int OPTION_AID = 16384;
    public static final int OPTION_ANDROID_ID = 524288;
    public static final int OPTION_BOOT_ID = 131072;
    public static final int OPTION_DRM_ID = 1048576;
    public static final int OPTION_OAID = 32768;
    public static final int OPTION_STORAGE_ID = 65536;
    private static TDRiskOption o0Oo0OO00O0O000ooOO0;

    public static class Builder {
        private TDRiskOption o0Oo0OO00O0O000ooOO0;

        public Builder() {
            TDRiskOption tDRiskOption = new TDRiskOption();
            this.o0Oo0OO00O0O000ooOO0 = tDRiskOption;
            tDRiskOption.setPlatform(o0Oo0OO00O0O000ooOO0("512b392b", 77));
            this.o0Oo0OO00O0O000ooOO0.setProductType(1);
        }

        private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
            try {
                int length = str.length() / 2;
                char[] charArray = str.toCharArray();
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 2;
                    bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
                }
                byte b = (byte) (i ^ 116);
                byte b2 = (byte) (bArr[0] ^ 34);
                bArr[0] = b2;
                for (int i4 = 1; i4 < length; i4++) {
                    b2 = (byte) ((b2 ^ bArr[i4]) ^ b);
                    bArr[i4] = b2;
                }
                return new String(bArr, CharEncoding.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        public Builder appKey(String str) {
            this.o0Oo0OO00O0O000ooOO0.setAppKey(str);
            return this;
        }

        public Builder appName(String str) {
            this.o0Oo0OO00O0O000ooOO0.setAppName(str);
            return this;
        }

        public TDRiskOption build() {
            return this.o0Oo0OO00O0O000ooOO0;
        }

        public Builder channel(String str) {
            this.o0Oo0OO00O0O000ooOO0.channel(str);
            return this;
        }

        public Builder collectLevel(String str) {
            this.o0Oo0OO00O0O000ooOO0.setCollectLevel(str);
            return this;
        }

        public Builder country(String str) {
            this.o0Oo0OO00O0O000ooOO0.setCountry(str);
            return this;
        }

        public Builder customMessage(String str) {
            this.o0Oo0OO00O0O000ooOO0.customMessage(str);
            return this;
        }

        public Builder disableDebugger() {
            this.o0Oo0OO00O0O000ooOO0.disableDebugger();
            return this;
        }

        public Builder disableGPS() {
            this.o0Oo0OO00O0O000ooOO0.disableGPS();
            return this;
        }

        public Builder disableGoogleAid() {
            this.o0Oo0OO00O0O000ooOO0.disableGoogleAid();
            return this;
        }

        public Builder disableInstallPackageList() {
            this.o0Oo0OO00O0O000ooOO0.disableInstallPackageList();
            return this;
        }

        public Builder disableOaid() {
            this.o0Oo0OO00O0O000ooOO0.disableOaid();
            return this;
        }

        public Builder disableOptions(int i) {
            this.o0Oo0OO00O0O000ooOO0.disableOptions(i);
            return this;
        }

        public Builder disableReadPhone() {
            this.o0Oo0OO00O0O000ooOO0.disableReadPhone();
            return this;
        }

        public Builder disableRunningTasks() {
            this.o0Oo0OO00O0O000ooOO0.disableRunningTasks();
            return this;
        }

        public Builder disableSensor() {
            this.o0Oo0OO00O0O000ooOO0.disableSensor();
            return this;
        }

        public Builder disableStorageId() {
            this.o0Oo0OO00O0O000ooOO0.disableStorageId();
            return this;
        }

        public Builder disableWifiMac() {
            this.o0Oo0OO00O0O000ooOO0.disableWifiMac();
            return this;
        }

        public Builder enableGoogleAid() {
            this.o0Oo0OO00O0O000ooOO0.enableGoogleAid();
            return this;
        }

        public Builder enableOaid() {
            this.o0Oo0OO00O0O000ooOO0.enableOaid();
            return this;
        }

        public Builder enableOptions(int i) {
            this.o0Oo0OO00O0O000ooOO0.enableOptions(i);
            return this;
        }

        public Builder enableStorageId() {
            this.o0Oo0OO00O0O000ooOO0.enableStorageId();
            return this;
        }

        public Builder enableWifiMac() {
            this.o0Oo0OO00O0O000ooOO0.enableWifiMac();
            return this;
        }

        public Builder forceTLSVersion(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.forceTLSVersion(z);
            return this;
        }

        public Builder httpTimeOut(int i) {
            this.o0Oo0OO00O0O000ooOO0.setHttpTimeOut(i);
            return this;
        }

        public Builder partner(String str) {
            return partnerCode(str);
        }

        public Builder partnerCode(String str) {
            this.o0Oo0OO00O0O000ooOO0.setPartnerCode(str);
            return this;
        }

        public Builder url(String str) {
            this.o0Oo0OO00O0O000ooOO0.setEnterpriseUrl(str);
            return this;
        }

        public Builder waitTime(int i) {
            this.o0Oo0OO00O0O000ooOO0.setWaitTime(i);
            return this;
        }
    }

    private TDDeviceManager() {
    }

    public static void getDeviceInfo(TDDeviceInfoCallback tDDeviceInfoCallback) {
        O0oOO0ooO.o0Oo0OO00O0O000ooOO0(tDDeviceInfoCallback);
    }

    public static String getSDKVersion() {
        return o0Oo0OO00O0O000ooOO0("3a5a5e5e5d", 8);
    }

    public static void initWithOptions(Context context, Builder builder) {
        Application application;
        if (builder != null) {
            if (context instanceof Activity) {
                application = ((Activity) context).getApplication();
            } else if (context instanceof Application) {
                application = (Application) context;
            } else {
                throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("6c060b101b17065e431059440b115e6b281d1715151707534517586b3b0a160f00081f170c0b", 67));
            }
            o0Oo0OO00O0O000ooOO0(application, builder.build());
            return;
        }
        throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("6d4c475e535a4c091241081540425b", 18));
    }

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 73);
            byte b2 = (byte) (bArr[0] ^ Ascii.SI);
            bArr[0] = b2;
            for (int i4 = 1; i4 < length; i4++) {
                b2 = (byte) ((b2 ^ bArr[i4]) ^ b);
                bArr[i4] = b2;
            }
            return new String(bArr, CharEncoding.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static void o0Oo0OO00O0O000ooOO0(Application application, TDRiskOption tDRiskOption) {
        if (application == null) {
            throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("6e0819051c131b0c041f185750034a57020019", 80));
        } else if (tDRiskOption != null) {
            o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(application);
            o0Oo0OO00O0O000ooOO0 = tDRiskOption;
            o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(tDRiskOption.getCountry());
            O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(tDRiskOption);
            com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o(o0Oo0OO00O0O000ooOO0("7c746c282a64647e37256c646479786e6227347d7e7f2b76787c7c7f", 42));
        } else {
            throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("7d2120221e053e273c3b747320697421233a", 115));
        }
    }
}
