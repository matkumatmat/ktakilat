package com.trustdecision.mobrisk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo;
import com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00.OO0000O0Ooo0OO000oo;
import com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00.o00ooooooO00OO0O00;
import com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;
import com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o;
import com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;
import org.apache.commons.lang3.CharEncoding;

public class TDRisk {
    public static final String COLLECT_LEVEL_H = o0Oo0OO00O0O000ooOO0("34", 79);
    public static final String COLLECT_LEVEL_L = o0Oo0OO00O0O000ooOO0("30", 26);
    public static final String COLLECT_LEVEL_M = o0Oo0OO00O0O000ooOO0("31", 87);
    public static final String COUNTRY_CN = o0Oo0OO00O0O000ooOO0("3f70", 84);
    public static final String COUNTRY_FRA = o0Oo0OO00O0O000ooOO0("3a4d4a", 112);
    public static final String COUNTRY_IDNA = o0Oo0OO00O0O000ooOO0("35444346", 96);
    public static final String COUNTRY_SG = o0Oo0OO00O0O000ooOO0("2f7d", 64);
    public static final String COUNTRY_US = o0Oo0OO00O0O000ooOO0("2972", 93);
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
            tDRiskOption.setPlatform(o0Oo0OO00O0O000ooOO0("723b293b", 52));
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
                byte b = (byte) (i ^ 29);
                byte b2 = (byte) (bArr[0] ^ 1);
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

        public Builder actionStageTimeout(int i) {
            this.o0Oo0OO00O0O000ooOO0.setActionStageTimeout(i);
            return this;
        }

        public Builder alwaysDemotion(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.alwaysDemotion(z);
            return this;
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

        public Builder clientKey(String str) {
            this.o0Oo0OO00O0O000ooOO0.setClientKey(str);
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

        public Builder faceMissingInterval(int i) {
            this.o0Oo0OO00O0O000ooOO0.setFaceMissingInterval(i);
            return this;
        }

        public Builder forceTLSVersion(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.forceTLSVersion(z);
            return this;
        }

        public Builder hideLoadHud(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.hideLoadHud(z);
            return this;
        }

        public Builder hideWebCloseButton(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.hideWebCloseButton(z);
            return this;
        }

        public Builder httpTimeOut(int i) {
            this.o0Oo0OO00O0O000ooOO0.setHttpTimeOut(i);
            return this;
        }

        @Deprecated
        public Builder language(int i) {
            this.o0Oo0OO00O0O000ooOO0.language(i);
            return this;
        }

        public Builder livenessDetectionThreshold(String str) {
            this.o0Oo0OO00O0O000ooOO0.setLivenessDetectionThreshold(str);
            return this;
        }

        public Builder livenessHttpTimeOut(int i) {
            this.o0Oo0OO00O0O000ooOO0.setLivenessHttpTimeOut(i);
            return this;
        }

        public Builder mfaId(String str) {
            this.o0Oo0OO00O0O000ooOO0.mfaId(str);
            return this;
        }

        public Builder needSeqId(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.needSeqId(z);
            return this;
        }

        public Builder noFMDevice(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.noFMDevice(z);
            return this;
        }

        public Builder openLog(Boolean bool) {
            this.o0Oo0OO00O0O000ooOO0.openLog(bool.booleanValue());
            return this;
        }

        public Builder partner(String str) {
            return partnerCode(str);
        }

        public Builder partnerCode(String str) {
            this.o0Oo0OO00O0O000ooOO0.setPartnerCode(str);
            return this;
        }

        public Builder partnerKey(String str) {
            this.o0Oo0OO00O0O000ooOO0.setPartnerKey(str);
            return this;
        }

        public Builder playAudio(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.setPlayAudio(z);
            return this;
        }

        public Builder prepareStageTimeout(int i) {
            this.o0Oo0OO00O0O000ooOO0.setPrepareStageTimeout(i);
            return this;
        }

        public Builder showFailResultPage(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.setShowFailResultPage(z);
            return this;
        }

        public Builder showReadyPage(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.setShowReadyPage(z);
            return this;
        }

        public Builder showSuccessResultPage(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.setShowSuccessResultPage(z);
            return this;
        }

        public Builder skipCaptcha(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.skipCaptcha(z);
            return this;
        }

        public Builder supportForCredit(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.supportForCredit(z);
            return this;
        }

        public Builder tapToClose(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.tapToClose(z);
            return this;
        }

        public Builder url(String str) {
            this.o0Oo0OO00O0O000ooOO0.setEnterpriseUrl(str);
            return this;
        }

        public Builder useDemotionData(boolean z) {
            this.o0Oo0OO00O0O000ooOO0.useDemotionData(z);
            return this;
        }

        public Builder waitTime(int i) {
            this.o0Oo0OO00O0O000ooOO0.setWaitTime(i);
            return this;
        }

        public Builder language(String str) {
            this.o0Oo0OO00O0O000ooOO0.language(str);
            return this;
        }
    }

    private TDRisk() {
    }

    public static String getBlackBox() {
        return O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0();
    }

    public static void getBlackBoxAsync(TDRiskCallback tDRiskCallback) {
        getBlackBox(tDRiskCallback);
    }

    public static String getSDKVersion() {
        return o0Oo0OO00O0O000ooOO0("497e7a7a79", 76);
    }

    @Deprecated
    public static void initWithOptions(Application application, TDRiskOption tDRiskOption) {
        if (application == null) {
            throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("1d5d4c5049464e59514a4d0205561f0257554c", 101));
        } else if (tDRiskOption != null) {
            o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(application);
            o0Oo0OO00O0O000ooOO0 = tDRiskOption;
            o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(tDRiskOption.getCountry());
            O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(tDRiskOption);
            OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0(tDRiskOption);
            com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o(o0Oo0OO00O0O000ooOO0("0f4e5612105e5e440d1f565e5e434254581d0e474445114c42464645", 112));
        } else {
            throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("0e1c1d1f2338031a0106494e1d54491c1e07", 46));
        }
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
            byte b = (byte) (i ^ 41);
            byte b2 = (byte) (bArr[0] ^ 124);
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

    public static void setOnErrorCodeListener(TDErrorCodeCallback tDErrorCodeCallback) {
        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(tDErrorCodeCallback);
    }

    public static void showCaptcha(Activity activity, TDRiskCaptchaCallback tDRiskCaptchaCallback) {
        oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(activity, o0Oo0OO00O0O000ooOO0, tDRiskCaptchaCallback);
    }

    public static void showLiveness(Activity activity, String str, TDRiskLivenessCallback tDRiskLivenessCallback) {
        o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0, activity, str, tDRiskLivenessCallback);
    }

    public static TDAPISignResult sign(Context context, String str) {
        return com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(context, str);
    }

    public static void upload() {
        OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0();
    }

    public static void getBlackBox(TDRiskCallback tDRiskCallback) {
        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(tDRiskCallback);
    }

    public static void initWithOptions(Context context, Builder builder) {
        Application application;
        if (builder != null) {
            if (context instanceof Activity) {
                application = ((Activity) context).getApplication();
            } else if (context instanceof Application) {
                application = (Application) context;
            } else {
                throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("1f79746f646879213c6f263b746e21145762686a6a68782c3a682714447569707f7760687374", 92));
            }
            initWithOptions(application, builder.build());
            return;
        }
        throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("1e717a636e6771342f7c35287d7f66", 79));
    }

    public static void showLiveness(TDRiskLivenessCallback tDRiskLivenessCallback) {
        o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0, "", tDRiskLivenessCallback);
    }

    public static void showLiveness(String str, TDRiskLivenessCallback tDRiskLivenessCallback) {
        o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0, str, tDRiskLivenessCallback);
    }
}
