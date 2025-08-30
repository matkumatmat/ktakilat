package com.trustdecision.android.shell;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o;
import com.trustdecision.android.shell.common.o0O00o00OOoOo0oooOoo00;
import com.trustdecision.android.shell.inter.FMCallback;
import com.trustdecision.android.shell.inter.FMGetBlackBoxCodeCallback;
import com.trustdecision.android.shell.inter.TDDeviceInfoCallback;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.CharEncoding;

@Deprecated
public class FMAgent {
    public static final String COLLECT_LEVEL_H = o0Oo0OO00O0O000ooOO0("4a", 68);
    public static final String COLLECT_LEVEL_L = o0Oo0OO00O0O000ooOO0("4e", 60);
    public static final String COLLECT_LEVEL_M = o0Oo0OO00O0O000ooOO0("4f", 79);
    public static final String ENV_PRODUCTION = o0Oo0OO00O0O000ooOO0("725b4452484f4e445f58", 43);
    public static final String ENV_SANDBOX = o0Oo0OO00O0O000ooOO0("71100d08040f15", 112);
    /* access modifiers changed from: private */
    public static int O00OO0oOOooooO00000Oo;
    @Deprecated
    public static final String OPTION_ALWAYS_DEMOTION = o0Oo0OO00O0O000ooOO0("637e68656b795f48727b71686e7572", 1);
    @Deprecated
    public static final String OPTION_APK_SIGNED_SHA256 = o0Oo0OO00O0O000ooOO0("63747e51497f6b6c6e645e497e6c366266", 23);
    @Deprecated
    public static final String OPTION_APPLICATION_ID_SHA256 = o0Oo0OO00O0O000ooOO0("63041509101f1700081314242318", 103);
    @Deprecated
    public static final String OPTION_APP_KEY = o0Oo0OO00O0O000ooOO0("634958776c5644", 42);
    @Deprecated
    public static final String OPTION_APP_NAME = o0Oo0OO00O0O000ooOO0("433f2e213f212226", 92);
    @Deprecated
    public static final String OPTION_BLACKBOX_MAXSIZE = o0Oo0OO00O0O000ooOO0("600407080203071d2d38061301101915", 120);
    @Deprecated
    public static final String OPTION_CHANNEL = o0Oo0OO00O0O000ooOO0("614f4d4b444f4d", 54);
    @Deprecated
    public static final String OPTION_COLLECT_LEVEL = o0Oo0OO00O0O000ooOO0("6166696a636c7d415963797963", 24);
    @Deprecated
    public static final String OPTION_COUNTRY = o0Oo0OO00O0O000ooOO0("61283e3f3e222f", 86);
    @Deprecated
    public static final String OPTION_CUSTOM_MESSAGE = o0Oo0OO00O0O000ooOO0("616272736f7646467c6274667276", 6);
    @Deprecated
    public static final String OPTION_CUSTOM_PATH = o0Oo0OO00O0O000ooOO0("61594948544d7d605e5a53", 61);
    @Deprecated
    public static final String OPTION_CUSTOM_URL = o0Oo0OO00O0O000ooOO0("612030312d34041c3128", 68);
    @Deprecated
    public static final String OPTION_CUST_PROCESS = o0Oo0OO00O0O000ooOO0("615646476b6f425d4c465640", 50);
    @Deprecated
    public static final String OPTION_DOMAIN = o0Oo0OO00O0O000ooOO0("665d545a5e51", 36);
    @Deprecated
    public static final String OPTION_FORCE_TLS_VERSION_ENABLE = o0Oo0OO00O0O000ooOO0("6405111d0a3627141320251f1b0d160a0d3d3607030f0205", 126);
    @Deprecated
    public static final String OPTION_GOOGLE_AID_ENABLE = o0Oo0OO00O0O000ooOO0("65414941424073774144727342464a4740", 59);
    @Deprecated
    public static final String OPTION_HTTP_TIME_OUT = o0Oo0OO00O0O000ooOO0("6a706c684347716864565c766d", 30);
    @Deprecated
    public static final String OPTION_INSTALLPACKAGES_ENABLE = o0Oo0OO00O0O000ooOO0("6b405a40524a477b76454f4d414551716c4844494e", 53);
    @Deprecated
    public static final String OPTION_KILL_DEBUGGER = o0Oo0OO00O0O000ooOO0("693c3b3e0d053f2e2c3e3c29", 76);
    @Deprecated
    public static final String OPTION_MASK = o0Oo0OO00O0O000ooOO0("6d0a11081314242719070d", 103);
    @Deprecated
    public static final String OPTION_OAID_ENABLE = o0Oo0OO00O0O000ooOO0("6d101613252415111d1017", 108);
    @Deprecated
    public static final String OPTION_OVERRIDE_CERTI = o0Oo0OO00O0O000ooOO0("6d2e2420372c3a360d0b3120312a", 69);
    @Deprecated
    public static final String OPTION_PARTNER_CODE = o0Oo0OO00O0O000ooOO0("726f6d786f69534272757f", 12);
    @Deprecated
    public static final String OPTION_PLATFORM = o0Oo0OO00O0O000ooOO0("7263726a6d766260", 13);
    @Deprecated
    public static final String OPTION_READ_PHONE_ENABLE = o0Oo0OO00O0O000ooOO0("702f3c3d0317203f3933020233373b3631", 74);
    @Deprecated
    public static final String OPTION_SENSOR_ENABLE = o0Oo0OO00O0O000ooOO0("51734e585958726e4a464b4c", 55);
    @Deprecated
    public static final String OPTION_SKIP_GPS = o0Oo0OO00O0O000ooOO0("713c263d0b1c3327", 86);
    @Deprecated
    public static final String OPTION_STORAGE_ID_ENABLE = o0Oo0OO00O0O000ooOO0("710d1117190c08303c0731300105090403", 120);
    @Deprecated
    public static final String OPTION_TASK_ENABLE = o0Oo0OO00O0O000ooOO0("707d617a7d7d7342516f68624e407175797473", 8);
    @Deprecated
    public static final String OPTION_USE_DEMOTION = o0Oo0OO00O0O000ooOO0("77091935340e070d1412090e", 125);
    @Deprecated
    public static final String OPTION_WAIT_TIME = o0Oo0OO00O0O000ooOO0("753f21340202342d21", 91);
    @Deprecated
    public static final String OPTION_WIFIMAC_ENABLE = o0Oo0OO00O0O000ooOO0("754150507b735d7974505c5156", 45);
    @Deprecated
    public static final String STATUS_COLLECTING = o0Oo0OO00O0O000ooOO0("611817141d120309131d", 102);
    @Deprecated
    public static final String STATUS_FAILED = o0Oo0OO00O0O000ooOO0("6428272a262e", 93);
    @Deprecated
    public static final String STATUS_LOADING = o0Oo0OO00O0O000ooOO0("6e111c171f151b", 96);
    @Deprecated
    public static final String STATUS_PROFILING = o0Oo0OO00O0O000ooOO0("725a4551575d5d5f51", 42);
    @Deprecated
    public static final String STATUS_SUCCESSFUL = o0Oo0OO00O0O000ooOO0("7155455355455346404a", 33);
    @Deprecated
    public static final String STATUS_UNINIT = o0Oo0OO00O0O000ooOO0("770c1010100a", 101);
    public static FMGetBlackBoxCodeCallback mFMGetBlackBoxCodeCallback;
    @Deprecated
    private static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("6f3c332e2524260a172d293f24383f", 76);
    @Deprecated
    private static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("6b7254517b7f68736569444f6f75", 26);
    private static o0Oo0OO00O0O000ooOO0 oO00o0OooO0OO0o0000o;
    public static boolean usbConnected = false;

    @Deprecated
    public static class Builder {
        private String O00OO0oOOooooO00000Oo;
        private String O0OoOo00O000;
        private String O0o0o0O0OOOooOo0OOoOOO;
        private int O0o0o0O0ooOooOoo;
        private String O0oOO0ooO;
        private String O0oOoooo0o0o0oOo;
        private String OO0000O0Ooo0OO000oo;
        private String OO000O0O0Oo;
        private String Oo0O0Oo0OO0OOOoOO0O0;
        private boolean Oo0o000OO;
        private String OoOOooOoooOoo;
        private FMCallback o00ooooooO00OO0O00;
        private int o0O00o00OOoOo0oooOoo00;
        private String o0Oo0O0o0ooOOo0oO0;
        private String o0Oo0OO00O0O000ooOO0;
        private int o0oOO0oO00OoO0 = Integer.MAX_VALUE;
        private String o0ooO0o000Oo0Oo0O0;
        private String o0ooOoo0Oo00oOOO;
        private String oO00o0OooO0OO0o0000o;
        private int oO0oOOOOoo;
        private String oOOO00oO00o0oOoOo;

        public Builder() {
            platform(o0Oo0OO00O0O000ooOO0("07342634", 4));
            waitTime(1000);
            httpTimeout(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o() == 0 ? 15000 : 10000);
            o0Oo0OO00O0O000ooOO0(1);
            o0Oo0OO00O0O000ooOO0(2);
            o0Oo0OO00O0O000ooOO0(8);
            o0O00o00OOoOo0oooOoo00(16);
            o0Oo0OO00O0O000ooOO0(32);
            o0Oo0OO00O0O000ooOO0(64);
            o0Oo0OO00O0O000ooOO0(256);
            o0Oo0OO00O0O000ooOO0(512);
            o0O00o00OOoOo0oooOoo00(2048);
            o0Oo0OO00O0O000ooOO0(4096);
            o0O00o00OOoOo0oooOoo00(8192);
            collectLevel(o0Oo0OO00O0O000ooOO0("38", 56));
            o0Oo0OO00O0O000ooOO0(16384);
            o0Oo0OO00O0O000ooOO0(32768);
            o0Oo0OO00O0O000ooOO0(131072);
            o0O00o00OOoOo0oooOoo00(262144);
            o0Oo0OO00O0O000ooOO0(524288);
            o0Oo0OO00O0O000ooOO0(1048576);
            this.Oo0o000OO = false;
        }

        private Builder o0O00o00OOoOo0oooOoo00(int i) {
            this.o0O00o00OOoOo0oooOoo00 = (~i) & this.o0O00o00OOoOo0oooOoo00;
            return this;
        }

        /* access modifiers changed from: private */
        public Builder o0Oo0OO00O0O000ooOO0() {
            this.Oo0o000OO = true;
            return this;
        }

        public Builder alwaysDemotion() {
            o0Oo0OO00O0O000ooOO0(16);
            return this;
        }

        public Builder apkSignedSHA256(String str) {
            this.oOOO00oO00o0oOoOo = str;
            return this;
        }

        public Builder appKey(String str) {
            this.O0oOoooo0o0o0oOo = str;
            return this;
        }

        public Builder appName(String str) {
            this.O0oOO0ooO = str;
            return this;
        }

        public Builder applicationIdSHA256(String str) {
            this.OO000O0O0Oo = str;
            return this;
        }

        public Builder blackBoxMaxSize(int i) {
            this.o0oOO0oO00OoO0 = i;
            return this;
        }

        public TDOption build() {
            TDOption tDOption = new TDOption();
            tDOption.setPlatform(this.o0Oo0OO00O0O000ooOO0);
            tDOption.setEnvironment(this.oO00o0OooO0OO0o0000o);
            tDOption.setPartnerCode(this.O00OO0oOOooooO00000Oo);
            tDOption.setAppName(this.O0oOO0ooO);
            tDOption.setFMCallback(this.o00ooooooO00OO0O00);
            tDOption.setCustomProcessName(this.OO0000O0Ooo0OO000oo);
            tDOption.setEnterpriseUrl(this.OoOOooOoooOoo);
            tDOption.setWaitTime(this.oO0oOOOOoo);
            tDOption.setDomain(this.O0o0o0O0OOOooOo0OOoOOO);
            tDOption.setCustomFilePath(this.o0ooOoo0Oo00oOOO);
            tDOption.setBlackBoxMaxSize(this.o0oOO0oO00OoO0);
            tDOption.setHttpTimeout(this.O0o0o0O0ooOooOoo);
            tDOption.setTDChannel(this.Oo0O0Oo0OO0OOOoOO0O0);
            tDOption.setApkSignedSHA256(this.oOOO00oO00o0oOoOo);
            tDOption.setApplicationIdSHA256(this.OO000O0O0Oo);
            tDOption.setCollectLevel(this.o0Oo0O0o0ooOOo0oO0);
            tDOption.o0Oo0OO00O0O000ooOO0(this.Oo0o000OO);
            tDOption.setAppKey(this.O0oOoooo0o0o0oOo);
            tDOption.setCustomMessage(this.o0ooO0o000Oo0Oo0O0);
            tDOption.setCountry(this.O0OoOo00O000);
            int o0Oo0OO00O0O000ooOO02 = FMAgent.O00OO0oOOooooO00000Oo;
            if ((o0Oo0OO00O0O000ooOO02 & 32768) == 0 || (this.o0O00o00OOoOo0oooOoo00 & 32768) == 0) {
                o0O00o00OOoOo0oooOoo00(32768);
            } else {
                o0Oo0OO00O0O000ooOO0(32768);
            }
            if ((o0Oo0OO00O0O000ooOO02 & 131072) == 0 || (this.o0O00o00OOoOo0oooOoo00 & 131072) == 0) {
                o0O00o00OOoOo0oooOoo00(131072);
            } else {
                o0Oo0OO00O0O000ooOO0(131072);
            }
            if ((o0Oo0OO00O0O000ooOO02 & 16384) == 0 || (this.o0O00o00OOoOo0oooOoo00 & 16384) == 0) {
                o0O00o00OOoOo0oooOoo00(16384);
            } else {
                o0Oo0OO00O0O000ooOO0(16384);
            }
            if ((o0Oo0OO00O0O000ooOO02 & 65536) == 0 || (this.o0O00o00OOoOo0oooOoo00 & 65536) == 0) {
                o0O00o00OOoOo0oooOoo00(65536);
            } else {
                o0Oo0OO00O0O000ooOO0(65536);
            }
            if ((o0Oo0OO00O0O000ooOO02 & 262144) == 0 || (this.o0O00o00OOoOo0oooOoo00 & 262144) == 0) {
                o0O00o00OOoOo0oooOoo00(262144);
            } else {
                o0Oo0OO00O0O000ooOO0(262144);
            }
            if ((o0Oo0OO00O0O000ooOO02 & 524288) == 0 || (this.o0O00o00OOoOo0oooOoo00 & 524288) == 0) {
                o0O00o00OOoOo0oooOoo00(524288);
            } else {
                o0Oo0OO00O0O000ooOO0(524288);
            }
            if ((o0Oo0OO00O0O000ooOO02 & 1048576) == 0 || (this.o0O00o00OOoOo0oooOoo00 & 1048576) == 0) {
                o0O00o00OOoOo0oooOoo00(1048576);
            } else {
                o0Oo0OO00O0O000ooOO0(1048576);
            }
            tDOption.setMask(this.o0O00o00OOoOo0oooOoo00);
            return tDOption;
        }

        @Deprecated
        public Builder callback(FMCallback fMCallback) {
            this.o00ooooooO00OO0O00 = fMCallback;
            throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("204f7269203e7b626f7478373b7a6120317473783d377266716475716662723b7f236f7a7761653621647070642127683c276f7e363a746962716660666e75723d37787f656b7b786966666e757233", 81));
        }

        public Builder collectLevel(String str) {
            this.o0Oo0O0o0ooOOo0oO0 = str;
            return this;
        }

        public Builder country(String str) {
            this.O0OoOo00O000 = str;
            return this;
        }

        public Builder customFilePath(String str) {
            this.o0ooOoo0Oo00oOOO = str;
            return this;
        }

        public Builder customMessage(String str) {
            this.o0ooO0o000Oo0Oo0O0 = str;
            return this;
        }

        public Builder customProcessName(String str) {
            this.OO0000O0Ooo0OO000oo = str;
            return this;
        }

        public Builder disableAndroidId() {
            o0O00o00OOoOo0oooOoo00(524288);
            return this;
        }

        public Builder disableDebugger() {
            o0O00o00OOoOo0oooOoo00(8);
            return this;
        }

        public Builder disableGPS() {
            o0O00o00OOoOo0oooOoo00(2);
            return this;
        }

        public Builder disableGoogleAid() {
            o0O00o00OOoOo0oooOoo00(16384);
            return this;
        }

        public Builder disableInstallPackageList() {
            o0O00o00OOoOo0oooOoo00(1);
            return this;
        }

        public Builder disableOaid() {
            o0O00o00OOoOo0oooOoo00(32768);
            return this;
        }

        public Builder disableReadPhone() {
            o0O00o00OOoOo0oooOoo00(64);
            return this;
        }

        public Builder disableRunningTasks() {
            o0O00o00OOoOo0oooOoo00(32);
            return this;
        }

        public Builder disableSensor() {
            o0O00o00OOoOo0oooOoo00(512);
            return this;
        }

        public Builder disableStorageId() {
            o0O00o00OOoOo0oooOoo00(65536);
            return this;
        }

        public Builder disableVerifyCertificate() {
            o0O00o00OOoOo0oooOoo00(256);
            return this;
        }

        public Builder disableWifiMac() {
            o0O00o00OOoOo0oooOoo00(4096);
            return this;
        }

        public Builder domain(String str) {
            this.O0o0o0O0OOOooOo0OOoOOO = str;
            return this;
        }

        public Builder enableAndroidId() {
            o0Oo0OO00O0O000ooOO0(524288);
            return this;
        }

        public Builder enableGoogleAid() {
            o0Oo0OO00O0O000ooOO0(16384);
            return this;
        }

        public Builder enableOaid() {
            o0Oo0OO00O0O000ooOO0(32768);
            return this;
        }

        public Builder enableStorageId() {
            o0Oo0OO00O0O000ooOO0(65536);
            return this;
        }

        public Builder enableWifiMac() {
            o0Oo0OO00O0O000ooOO0(4096);
            return this;
        }

        public Builder forceTLSVersion() {
            o0Oo0OO00O0O000ooOO0(8192);
            return this;
        }

        public Builder httpTimeout(int i) {
            this.O0o0o0O0ooOooOoo = i;
            return this;
        }

        public Builder openLog() {
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0();
            oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("3b7c56480d1758424a4052580d10544c080f404b", 97));
            return this;
        }

        public Builder partner(String str) {
            this.O00OO0oOOooooO00000Oo = str;
            return this;
        }

        public Builder platform(String str) {
            this.o0Oo0OO00O0O000ooOO0 = str;
            return this;
        }

        public Builder production(boolean z) {
            String str;
            int i;
            if (z) {
                str = "0427382e343332382324";
                i = 7;
            } else {
                str = "070a17121e150f";
                i = 58;
            }
            this.oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0(str, i);
            return this;
        }

        public Builder tdChannel(String str) {
            this.Oo0O0Oo0OO0OOOoOO0O0 = str;
            return this;
        }

        public Builder url(String str) {
            this.OoOOooOoooOoo = str;
            return this;
        }

        public Builder useDemotionData() {
            o0Oo0OO00O0O000ooOO0(2048);
            return this;
        }

        public Builder waitTime(int i) {
            this.oO0oOOOOoo = i;
            return this;
        }

        private Builder o0Oo0OO00O0O000ooOO0(int i) {
            this.o0O00o00OOoOo0oooOoo00 = i | this.o0O00o00OOoOo0oooOoo00;
            return this;
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
                byte b = (byte) (i ^ 34);
                byte b2 = (byte) (bArr[0] ^ 116);
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
    }

    @Deprecated
    public static void collectAndReportInNeeded(Context context, Builder builder) {
        if (builder == null) {
            builder = new Builder();
        }
        Builder unused = builder.o0Oo0OO00O0O000ooOO0();
        init(context, builder);
    }

    @Deprecated
    public static void getDeviceInfo(TDDeviceInfoCallback tDDeviceInfoCallback) {
        if (oO00o0OooO0OO0o0000o == null) {
            oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
        }
        oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(tDDeviceInfoCallback);
    }

    @Deprecated
    public static String getInitStatus() {
        o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0 = oO00o0OooO0OO0o0000o;
        return o0oo0oo00o0o000oooo0 == null ? o0Oo0OO00O0O000ooOO0("77716d6d6d77", 24) : o0oo0oo00o0o000oooo0.o0O00o00OOoOo0oooOoo00;
    }

    public static String getVersion() {
        return o0Oo0OO00O0O000ooOO0("37797d7d7e", 16);
    }

    public static void init(Context context, Builder builder) {
        if (builder == null) {
            builder = new Builder();
        }
        init(context, builder.build());
    }

    @Deprecated
    public static void initSEWithOptions(Context context, Map map) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00();
        Builder o0O00o00OOoOo0oooOoo002 = o0O00o00OOoOo0oooOoo00(context, (String) null, map, (FMCallback) null);
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(context);
        if (oO00o0OooO0OO0o0000o == null) {
            oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
        }
        oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(o0O00o00OOoOo0oooOoo002.build());
    }

    @Deprecated
    public static void initWithCallback(Context context, String str, FMCallback fMCallback) {
        initWithCallback(context, str, (Map) null, fMCallback);
    }

    @Deprecated
    public static void initWithDomain(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(o0Oo0OO00O0O000ooOO0("66676e60646b", 30), str);
        o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("724c53455f585953484f", 60), hashMap, (FMCallback) null);
    }

    @Deprecated
    public static void initWithOptions(Context context, String str, Map map) {
        o0Oo0OO00O0O000ooOO0(context, str, map, (FMCallback) null);
    }

    private static Builder o0O00o00OOoOo0oooOoo00(Context context, String str, Map map, FMCallback fMCallback) {
        Object obj;
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo2 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        Builder builder = new Builder();
        if (fMCallback != null) {
            builder.callback(fMCallback);
        }
        if (o0Oo0OO00O0O000ooOO0("7124393c303b21", 68).equals(str)) {
            builder.production(false);
        } else if (o0Oo0OO00O0O000ooOO0("72100f190304050f1413", 96).equals(str)) {
            builder.production(true);
        }
        if (map == null) {
            builder.partner(o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(context));
            builder.appName(o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00(context));
            return builder;
        }
        builder.partner(map.containsKey(o0Oo0OO00O0O000ooOO0("721e1c091e18223303040e", 125)) ? (String) map.get(o0Oo0OO00O0O000ooOO0("7245475245437968585f55", 38)) : o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(context));
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("75425c497f7f49505c", 38))) {
            builder.waitTime(((Integer) map.get(o0Oo0OO00O0O000ooOO0("752e30251313253c30", 74))).intValue());
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("60080b040e0f0b1121340a1f0d1c1519", 116))) {
            builder.blackBoxMaxSize(Math.max(((Integer) map.get(o0Oo0OO00O0O000ooOO0("6000030c06070319293c021705141d11", 124))).intValue(), 5120));
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("714d574c7a6d4256", 39)) && ((Boolean) map.get(o0Oo0OO00O0O000ooOO0("7143594274634c58", 41))).booleanValue()) {
            builder.disableGPS();
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("69424540737b415052404257", 50)) && ((Boolean) map.get(o0Oo0OO00O0O000ooOO0("692a2d281b1329383a282a3f", 90))).booleanValue()) {
            builder.disableDebugger();
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("6335232e2032140339303a23253e39", 74)) && ((Boolean) map.get(o0Oo0OO00O0O000ooOO0("637e68656b795f48727b71686e7572", 1))).booleanValue()) {
            builder.alwaysDemotion();
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("66272e20242b", 94))) {
            builder.domain((String) map.get(o0Oo0OO00O0O000ooOO0("6618111f1b14", 97)));
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("707f63787f7f7140536d6a604c4273777b7671", 10)) && !((Boolean) map.get(o0Oo0OO00O0O000ooOO0("70405c4740404e7f6c52555f737d4c4844494e", 53))).booleanValue()) {
            builder.disableRunningTasks();
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("611707062a2e031c0d071701", 115))) {
            builder.customProcessName((String) map.get(o0Oo0OO00O0O000ooOO0("613d2d2c00042936272d3d2b", 89)));
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("617363627e67574f627b", 23))) {
            builder.url((String) map.get(o0Oo0OO00O0O000ooOO0("613c2c2d312818002d34", 88)));
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("61243233322e23", 90))) {
            builder.country((String) map.get(o0Oo0OO00O0O000ooOO0("61091f1e1f030e", 119)));
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("726f7e66617a6e6c", 1))) {
            builder.platform((String) map.get(o0Oo0OO00O0O000ooOO0("720e1f07001b0f0d", 96)));
        }
        builder.appName(map.containsKey(o0Oo0OO00O0O000ooOO0("4337262937292a2e", 84)) ? (String) map.get(o0Oo0OO00O0O000ooOO0("434f5e514f515256", 44)) : o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00(context));
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("6d3b313522392f23181e2435243f", 80)) && ((Boolean) map.get(o0Oo0OO00O0O000ooOO0("6d313b3f2833252912142e3f2e35", 90))).booleanValue()) {
            builder.disableVerifyCertificate();
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("6b5349534159546865565c5e525642627f5b575a5d", 38)) && !((Boolean) map.get(o0Oo0OO00O0O000ooOO0("6b617b61736b665a57646e6c606470504d6965686f", 20))).booleanValue()) {
            builder.disableInstallPackageList();
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("515c617776775d4165696463", 24)) && !((Boolean) map.get(o0Oo0OO00O0O000ooOO0("510c312726270d1135393433", 72))).booleanValue()) {
            builder.disableSensor();
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("757c6d6d464e6044496d616c6b", 16))) {
            if (!((Boolean) map.get(o0Oo0OO00O0O000ooOO0("756a7b7b505876525f7b777a7d", 6))).booleanValue()) {
                builder.disableWifiMac();
            } else {
                builder.enableWifiMac();
            }
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("617a6a6b776e5e437d7970", 30))) {
            builder.customFilePath((String) map.get(o0Oo0OO00O0O000ooOO0("611101001c05352816121b", 117)));
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("6a5844406b6f59404c7e745e45", 54))) {
            builder.httpTimeout(((Integer) map.get(o0Oo0OO00O0O000ooOO0("6a6f73775c586e777b49436972", 1))).intValue());
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("70485b5a647047585e54656554505c5156", 45)) && !((Boolean) map.get(o0Oo0OO00O0O000ooOO0("707360615f4b7c63656f5e5e6f6b676a6d", 22))).booleanValue()) {
            builder.disableReadPhone();
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("61797b7d72797b", 0))) {
            builder.tdChannel((String) map.get(o0Oo0OO00O0O000ooOO0("610a080e010a08", 115)));
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("7770604c4d777e746d6b7077", 4)) && ((Boolean) map.get(o0Oo0OO00O0O000ooOO0("7772624e4f757c766f697275", 6))).booleanValue()) {
            builder.useDemotionData();
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("636d674850667275777d475067752f7b7f", 14))) {
            builder.apkSignedSHA256((String) map.get(o0Oo0OO00O0O000ooOO0("636f654a52647077757f455265772d797d", 12)));
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("631908140d020a1d150e09393e05", 122))) {
            builder.applicationIdSHA256((String) map.get(o0Oo0OO00O0O000ooOO0("6351405c454a42555d464171764d", 50)));
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("6426323e291504373003063c382e35292e1e1524202c2126", 93)) && ((Boolean) map.get(o0Oo0OO00O0O000ooOO0("64293d31261a0b383f0c093337213a2621111a2b2f232e29", 82))).booleanValue()) {
            builder.forceTLSVersion();
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("61555a59505f4e726a504a4a50", 43))) {
            builder.collectLevel((String) map.get(o0Oo0OO00O0O000ooOO0("61121d1e171809352d170d0d17", 108)));
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("6b210702282c3b20363a171c3c26", 73)) && ((Boolean) map.get(o0Oo0OO00O0O000ooOO0("6b4e686d4743544f595578735349", 38))).booleanValue()) {
            Builder unused = builder.o0Oo0OO00O0O000ooOO0();
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("636b7a554e7466", 8))) {
            builder.appKey((String) map.get(o0Oo0OO00O0O000ooOO0("634859766d5745", 43)));
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("6f424d505b5a5874695357415a4641", 50))) {
            String str2 = (String) map.get(o0Oo0OO00O0O000ooOO0("6f1f100d06070529340e0a1c071b1c", 111));
            if (!TextUtils.isEmpty(str2)) {
                O00OO0oOOooooO00000Oo2.OOoOo00oo0Ooo0o0o0o000 = str2;
            }
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("65212921222013172124121322262a2720", 91))) {
            if (!((Boolean) map.get(o0Oo0OO00O0O000ooOO0("655d555d5e5c6f6b5d586e6f5e5a565b5c", 39))).booleanValue()) {
                builder.disableGoogleAid();
            } else {
                builder.enableGoogleAid();
            }
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("6d4c4a4f7978494d414c4b", 48))) {
            if (!((Boolean) map.get(o0Oo0OO00O0O000ooOO0("6d434540767746424e4344", 63))).booleanValue()) {
                builder.disableOaid();
            } else {
                builder.enableOaid();
            }
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("613020213d2414142e3026342024", 84))) {
            builder.customMessage((String) map.get(o0Oo0OO00O0O000ooOO0("610b1b1a061f2f2f150b1d0f1b1f", 111)));
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("71332f292732360e02390f0e3f3b373a3d", 70)) && (obj = map.get(o0Oo0OO00O0O000ooOO0("71524e484653576f63586e6f5e5a565b5c", 39))) != null) {
            if (((Boolean) obj).booleanValue()) {
                builder.enableStorageId();
            } else {
                builder.disableStorageId();
            }
        }
        if (map.containsKey(o0Oo0OO00O0O000ooOO0("6d071c051e19292a140a00", 106))) {
            Object obj2 = map.get(o0Oo0OO00O0O000ooOO0("6d342f362d2a1a19273933", 89));
            if (obj2 instanceof Integer) {
                O00OO0oOOooooO00000Oo = ((Integer) obj2).intValue();
            }
        }
        return builder;
    }

    public static String onEvent(Context context) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(context);
        if (oO00o0OooO0OO0o0000o == null) {
            oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
        }
        return oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0());
    }

    @Deprecated
    public static void openLog() {
        oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0();
        oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("4d0f253b7e642b313933212b7e63273f7b7c3338", 66));
    }

    public static void setOnErrorCodeListener(FMGetBlackBoxCodeCallback fMGetBlackBoxCodeCallback) {
        if (fMGetBlackBoxCodeCallback != null) {
            mFMGetBlackBoxCodeCallback = fMGetBlackBoxCodeCallback;
        }
    }

    @Deprecated
    public static void collectAndReportInNeeded(Context context, TDOption tDOption) {
        if (tDOption == null) {
            tDOption = new TDOption();
        }
        tDOption.o0Oo0OO00O0O000ooOO0(true);
        init(context, tDOption);
    }

    @Deprecated
    public static void init(Context context, @NonNull TDOption tDOption) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(context);
        if (oO00o0OooO0OO0o0000o == null) {
            oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
        }
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
        oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(tDOption);
    }

    @Deprecated
    public static void initWithCallback(Context context, String str, Map map, FMCallback fMCallback) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(context);
        o0Oo0OO00O0O000ooOO0(context, str, map, fMCallback);
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
            byte b = (byte) (i ^ 114);
            byte b2 = (byte) (bArr[0] ^ 2);
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

    public static void onEvent(Context context, FMCallback fMCallback) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(context);
        if (oO00o0OooO0OO0o0000o == null) {
            oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
        }
        oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(), fMCallback);
    }

    @Deprecated
    public static void collectAndReportInNeeded(Context context, String str, Map map, FMCallback fMCallback) {
        if (map == null) {
            map = new HashMap();
        }
        map.put(o0Oo0OO00O0O000ooOO0("6b3315103a3e29322428050e2e34", 91), Boolean.TRUE);
        o0Oo0OO00O0O000ooOO0(context, str, map, fMCallback);
    }

    @Deprecated
    public static void init(Context context, String str) {
        o0Oo0OO00O0O000ooOO0(context, str, (Map) null, (FMCallback) null);
    }

    private static void o0Oo0OO00O0O000ooOO0(Context context, String str, Map map, FMCallback fMCallback) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
        init(context, o0O00o00OOoOo0oooOoo00(context, str, map, fMCallback));
    }
}
