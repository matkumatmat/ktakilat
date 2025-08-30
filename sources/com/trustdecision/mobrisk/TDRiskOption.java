package com.trustdecision.mobrisk;

import org.apache.commons.lang3.CharEncoding;

public class TDRiskOption {
    public static final String PLATFORM_PAAS = o0Oo0OO00O0O000ooOO0("57302133", 22);
    public static final String PLATFORM_SAAS = o0Oo0OO00O0O000ooOO0("54796b79", 92);
    public static final int PRODUCT_TYPE_NORMAL = 0;
    public static final int PRODUCT_TYPE_SE = 1;
    private boolean O00O00oo0ooO0;
    private String O00OO0oOOooooO00000Oo;
    private int O00oOO0OO0ooOOo;
    private boolean O0OOO0O0OO0oO0oOoO000;
    private int O0OOo000OO0o0000O00oO0;
    private int O0OoOo00O000;
    private boolean O0o00o0;
    private int O0o0o0O0OOOooOo0OOoOOO;
    private String O0o0o0O0ooOooOoo;
    private int O0oOO0O0o0OO0o00 = -1;
    private String O0oOO0ooO;
    private boolean O0oOoO0OOOoO0ooO00;
    private String O0oOoo0oOo;
    private boolean O0oOoooo0o0o0oOo;
    private boolean O0oo0OOOOoO;
    private String O0oo0o00oooo;
    private TDRiskCallback OO0000O0Ooo0OO000oo;
    private boolean OO000O0O0Oo;
    private int OO000Ooo0O0ooO0o0 = -1;
    private boolean OO0oo0ooOO00OOO = true;
    private boolean OOOOO0o0ooo00oOo0;
    private String OOo0o00oOO00o00o;
    private boolean OOoOo00oo0Ooo0o0o0o000;
    private boolean Oo0O00OooOO00;
    private String Oo0O0Oo0OO0OOOoOO0O0;
    private boolean Oo0OO00oooO0Ooo000ooOo = true;
    private boolean Oo0o000OO;
    private String Oo0oOO0ooO0o0;
    private boolean Oo0oOo00ooOo0OOO0oO0 = false;
    private int OoOOooOoooOoo;
    private int Oooo00O0o0Oo0 = -1;
    private String o00ooooooO00OO0O00;
    private String o0O00o00OOoOo0oooOoo00;
    private boolean o0Oo0O0o0ooOOo0oO0;
    private String o0Oo0OO00O0O000ooOO0;
    private String o0OoooOooOooo0Oo;
    private boolean o0oOO00OOOO;
    private String o0oOO0oO00OoO0;
    private boolean o0ooO0o000Oo0Oo0O0;
    private String o0ooOoo0Oo00oOOO;
    private String oO00o0OooO0OO0o0000o;
    private boolean oO0OOO00;
    private String oO0OOoOo0oo0OoO0O000Oo;
    private boolean oO0o0oOoOO0OO = false;
    private int oO0oOOOOoo;
    private boolean oO0oo00OooOooOOo;
    private String oO0ooo00oooo0oOO0oO = o0Oo0OO00O0O000ooOO0("54485a48", 109);
    private boolean oOO0Oo000oOO00oo0o0 = false;
    private boolean oOO0OooO0;
    private boolean oOOO00oO00o0oOoOo;
    private String oOOO0oO0O0Oo0;
    private int oOOo0O0OooOO;
    private boolean ooOo0oO0O000o0O0O00oo;
    private String ooOoOO00;
    private boolean ooOoOooO = true;
    private int ooooO0O00OOoOO00oooO = -1;
    private boolean ooooOO0OO0O0OOoo;

    public TDRiskOption() {
        enableOptions(1818624);
        setPlatform(o0Oo0OO00O0O000ooOO0("54475547", 98));
        setProductType(0);
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
            byte b = (byte) (i ^ 55);
            byte b2 = (byte) (bArr[0] ^ 39);
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

    public void alwaysDemotion(boolean z) {
        this.OO000O0O0Oo = z;
    }

    public void channel(String str) {
        this.o0ooOoo0Oo00oOOO = str;
    }

    public void customMessage(String str) {
        this.Oo0O0Oo0OO0OOOoOO0O0 = str;
    }

    public void disableDebugger() {
        this.o0Oo0O0o0ooOOo0oO0 = true;
    }

    public void disableGPS() {
        this.o0ooO0o000Oo0Oo0O0 = true;
    }

    public void disableGoogleAid() {
        this.oOO0Oo000oOO00oo0o0 = true;
    }

    public void disableInstallPackageList() {
        this.O0oOoooo0o0o0oOo = true;
    }

    public void disableOaid() {
        this.oO0o0oOoOO0OO = true;
    }

    public void disableOptions(int i) {
        this.O0OOo000OO0o0000O00oO0 = (~i) & this.O0OOo000OO0o0000O00oO0;
    }

    public void disableReadPhone() {
        this.oOO0OooO0 = true;
    }

    public void disableRunningTasks() {
        this.Oo0o000OO = true;
    }

    public void disableSensor() {
        this.oO0oo00OooOooOOo = true;
    }

    public void disableStorageId() {
        this.Oo0oOo00ooOo0OOO0oO0 = true;
    }

    public void disableWifiMac() {
        this.Oo0OO00oooO0Ooo000ooOo = true;
    }

    public void enableGoogleAid() {
        this.oOO0Oo000oOO00oo0o0 = false;
    }

    public void enableOaid() {
        this.oO0o0oOoOO0OO = false;
    }

    public void enableOptions(int i) {
        this.O0OOo000OO0o0000O00oO0 = i | this.O0OOo000OO0o0000O00oO0;
    }

    public void enableStorageId() {
        this.Oo0oOo00ooOo0OOO0oO0 = false;
    }

    public void enableWifiMac() {
        this.Oo0OO00oooO0Ooo000ooOo = false;
    }

    public void env(String str) {
        this.o00ooooooO00OO0O00 = str;
    }

    public void forceTLSVersion(boolean z) {
        this.oOOO00oO00o0oOoOo = z;
    }

    public int getActionStageTimeout() {
        return this.O0oOO0O0o0OO0o00;
    }

    public boolean getAlwaysDemotion() {
        return this.OO000O0O0Oo;
    }

    public String getAppKey() {
        return this.O0oOO0ooO;
    }

    public String getAppName() {
        return this.o0O00o00OOoOo0oooOoo00;
    }

    public int getBlackBoxMaxSize() {
        return this.oO0oOOOOoo;
    }

    public TDRiskCallback getCallback() {
        return this.OO0000O0Ooo0OO000oo;
    }

    public String getCapDomain() {
        return this.Oo0oOO0ooO0o0;
    }

    public int getCapHttpTimeOut() {
        return this.O0o0o0O0OOOooOo0OOoOOO;
    }

    public int getCapTotalCount() {
        return this.oOOo0O0OooOO;
    }

    public String getChannel() {
        return this.o0ooOoo0Oo00oOOO;
    }

    public String getClientKey() {
        return this.O00OO0oOOooooO00000Oo;
    }

    public String getCollectLevel() {
        return this.o0oOO0oO00OoO0;
    }

    public String getCountry() {
        return this.oO00o0OooO0OO0o0000o;
    }

    public String getCustomMessage() {
        return this.Oo0O0Oo0OO0OOOoOO0O0;
    }

    @Deprecated
    public String getCustomProcessName() {
        return this.O0o0o0O0ooOooOoo;
    }

    public boolean getDebugger() {
        return this.o0Oo0O0o0ooOOo0oO0;
    }

    public String getDomain() {
        return this.ooOoOO00;
    }

    public String getEnterpriseUrl() {
        return this.OOo0o00oOO00o00o;
    }

    public String getEnv() {
        return this.o00ooooooO00OO0O00;
    }

    public int getFaceMissingInterval() {
        return this.ooooO0O00OOoOO00oooO;
    }

    public boolean getForceTLSVersion() {
        return this.oOOO00oO00o0oOoOo;
    }

    public boolean getGPS() {
        return this.o0ooO0o000Oo0Oo0O0;
    }

    public boolean getHideCompInfo() {
        return this.Oo0O00OooOO00;
    }

    public boolean getHideLoadHud() {
        return this.OOoOo00oo0Ooo0o0o0o000;
    }

    public boolean getHideWebCloseButton() {
        return this.O0OOO0O0OO0oO0oOoO000;
    }

    public int getHttpTimeOut() {
        return this.O0OoOo00O000;
    }

    public boolean getInstallPackageList() {
        return this.O0oOoooo0o0o0oOo;
    }

    public String getLanguage() {
        return this.O0oo0o00oooo;
    }

    public int getLivenessHttpTimeOut() {
        return this.OO000Ooo0O0ooO0o0;
    }

    public String getMfaId() {
        return this.O0oOoo0oOo;
    }

    public boolean getNeedSeqid() {
        return this.ooOoOooO;
    }

    public boolean getNoFMDevice() {
        return this.OOOOO0o0ooo00oOo0;
    }

    public boolean getOpenLog() {
        return this.ooOo0oO0O000o0O0O00oo;
    }

    public int getOptionsMask() {
        return this.O0OOo000OO0o0000O00oO0;
    }

    public String getPartnerCode() {
        return this.o0Oo0OO00O0O000ooOO0;
    }

    public String getPartnerKey() {
        return this.oO0OOoOo0oo0OoO0O000Oo;
    }

    public String getPlatform() {
        return this.oO0ooo00oooo0oOO0oO;
    }

    public int getPrepareStageTimeout() {
        return this.Oooo00O0o0Oo0;
    }

    public String getProbeDomain() {
        return this.oOOO0oO0O0Oo0;
    }

    public int getProductType() {
        return this.O00oOO0OO0ooOOo;
    }

    public boolean getReadPhone() {
        return this.oOO0OooO0;
    }

    public boolean getRunningTasks() {
        return this.Oo0o000OO;
    }

    public boolean getSensor() {
        return this.oO0oo00OooOooOOo;
    }

    public boolean getSkipCaptcha() {
        return this.oO0OOO00;
    }

    public boolean getSupportForCredit() {
        return this.o0oOO00OOOO;
    }

    public boolean getTapToClose() {
        return this.ooooOO0OO0O0OOoo;
    }

    public boolean getUseDemotionData() {
        return this.O0oo0OOOOoO;
    }

    public int getWaitTime() {
        return this.OoOOooOoooOoo;
    }

    public String getlivenessDetectionThreshold() {
        return this.o0OoooOooOooo0Oo;
    }

    public void hideCompInfo(boolean z) {
        this.Oo0O00OooOO00 = z;
    }

    public void hideLoadHud(boolean z) {
        this.OOoOo00oo0Ooo0o0o0o000 = z;
    }

    public void hideWebCloseButton(boolean z) {
        this.O0OOO0O0OO0oO0oOoO000 = z;
    }

    public boolean isGoogleAidDisable() {
        return this.oOO0Oo000oOO00oo0o0;
    }

    public boolean isOaidDisable() {
        return this.oO0o0oOoOO0OO;
    }

    public boolean isPlayAudio() {
        return this.O0o00o0;
    }

    public boolean isShowFailResultPage() {
        return this.O0oOoO0OOOoO0ooO00;
    }

    public boolean isShowReadyPage() {
        return this.OO0oo0ooOO00OOO;
    }

    public boolean isShowSuccessResultPage() {
        return this.O00O00oo0ooO0;
    }

    public boolean isStorageIdDisable() {
        return this.Oo0oOo00ooOo0OOO0oO0;
    }

    public boolean isWifiMacDisable() {
        return this.Oo0OO00oooO0Ooo000ooOo;
    }

    @Deprecated
    public void language(int i) {
        this.O0oo0o00oooo = String.valueOf(i);
    }

    public void mfaId(String str) {
        this.O0oOoo0oOo = str;
    }

    public void needSeqId(boolean z) {
        this.ooOoOooO = z;
    }

    public void noFMDevice(boolean z) {
        this.OOOOO0o0ooo00oOo0 = z;
    }

    public void openLog(boolean z) {
        this.ooOo0oO0O000o0O0O00oo = z;
    }

    public void setActionStageTimeout(int i) {
        this.O0oOO0O0o0OO0o00 = i;
    }

    public void setAppKey(String str) {
        this.O0oOO0ooO = str;
    }

    public void setAppName(String str) {
        this.o0O00o00OOoOo0oooOoo00 = str;
    }

    public void setBlackBoxMaxSize(int i) {
        this.oO0oOOOOoo = i;
    }

    public void setCallback(TDRiskCallback tDRiskCallback) {
        this.OO0000O0Ooo0OO000oo = tDRiskCallback;
    }

    public void setCapDomain(String str) {
        this.Oo0oOO0ooO0o0 = str;
    }

    public void setCapHttpTimeOut(int i) {
        this.O0o0o0O0OOOooOo0OOoOOO = i;
    }

    public void setCapTotalCount(int i) {
        this.oOOo0O0OooOO = i;
    }

    public void setClientKey(String str) {
        this.O00OO0oOOooooO00000Oo = str;
    }

    public void setCollectLevel(String str) {
        this.o0oOO0oO00OoO0 = str;
    }

    public void setCountry(String str) {
        this.oO00o0OooO0OO0o0000o = str;
    }

    @Deprecated
    public void setCustomProcessName(String str) {
        this.O0o0o0O0ooOooOoo = str;
    }

    public void setDomain(String str) {
        this.ooOoOO00 = str;
    }

    public void setEnterpriseUrl(String str) {
        this.OOo0o00oOO00o00o = str;
    }

    public void setFaceMissingInterval(int i) {
        this.ooooO0O00OOoOO00oooO = i;
    }

    public void setHttpTimeOut(int i) {
        this.O0OoOo00O000 = i;
    }

    public void setLivenessDetectionThreshold(String str) {
        this.o0OoooOooOooo0Oo = str;
    }

    public void setLivenessHttpTimeOut(int i) {
        this.OO000Ooo0O0ooO0o0 = i;
    }

    public void setPartnerCode(String str) {
        this.o0Oo0OO00O0O000ooOO0 = str;
    }

    public void setPartnerKey(String str) {
        this.oO0OOoOo0oo0OoO0O000Oo = str;
    }

    public void setPlatform(String str) {
        this.oO0ooo00oooo0oOO0oO = str;
    }

    public void setPlayAudio(boolean z) {
        this.O0o00o0 = z;
    }

    public void setPrepareStageTimeout(int i) {
        this.Oooo00O0o0Oo0 = i;
    }

    public void setProbeDomain(String str) {
        this.oOOO0oO0O0Oo0 = str;
    }

    public void setProductType(int i) {
        this.O00oOO0OO0ooOOo = i;
    }

    public void setShowFailResultPage(boolean z) {
        this.O0oOoO0OOOoO0ooO00 = z;
    }

    public void setShowReadyPage(boolean z) {
        this.OO0oo0ooOO00OOO = z;
    }

    public void setShowSuccessResultPage(boolean z) {
        this.O00O00oo0ooO0 = z;
    }

    public void setWaitTime(int i) {
        this.OoOOooOoooOoo = i;
    }

    public void skipCaptcha(boolean z) {
        this.oO0OOO00 = z;
    }

    public void supportForCredit(boolean z) {
        this.o0oOO00OOOO = z;
    }

    public void tapToClose(boolean z) {
        this.ooooOO0OO0O0OOoo = z;
    }

    public void useDemotionData(boolean z) {
        this.O0oo0OOOOoO = z;
    }

    public void language(String str) {
        this.O0oo0o00oooo = str;
    }
}
