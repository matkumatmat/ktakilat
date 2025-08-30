package com.trustdecision.liveness.cw.api;

import android.util.Base64;

public class TDLivenessOption {
    private String i11iliil1li1;
    private int i1i1l1lii = 10000;
    private String i1l1i1llllil1i1lii;
    private boolean i1lill1ii = true;
    private boolean ii1lilli = false;
    private String iill11l11 = illill1ll1("AT03PycB");
    private String iill11lliiil1l1i11l11;
    private String il111liilil;
    private String il11iii11l11i1;
    private String ilii1liii11i1iii1l1;
    private String illill1ll1;
    private boolean l1li11i1ll = false;
    private int li1li1ii1ii11ii = 8;
    private boolean ll11li11l11il1lillll;
    private int ll1i11ii1liilll1ii = 1000;
    private int ll1lllii11l1iii1l1 = 0;

    private static String illill1ll1(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 99);
            byte b2 = (byte) (bArr[0] ^ 97);
            bArr[0] = b2;
            int i4 = 1;
            while (i4 < length) {
                byte b3 = bArr[i4];
                bArr[i4] = (byte) ((b2 ^ b3) ^ b);
                i4++;
                b2 = b3;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getActionStageTimeout() {
        return this.li1li1ii1ii11ii;
    }

    public String getAppKey() {
        return this.i1l1i1llllil1i1lii;
    }

    public String getCountry() {
        return this.i11iliil1li1;
    }

    public String getDetectionThreshold() {
        return this.iill11l11;
    }

    public String getEnv() {
        return this.il11iii11l11i1;
    }

    public int getFaceMissingInterval() {
        return this.ll1i11ii1liilll1ii;
    }

    public int getHttpTimeout() {
        return this.i1i1l1lii;
    }

    public String getLanguage() {
        return this.iill11lliiil1l1i11l11;
    }

    public String getPartnerCode() {
        return this.illill1ll1;
    }

    public String getPartnerKey() {
        return this.il111liilil;
    }

    public int getPrepareStageTimeout() {
        return this.ll1lllii11l1iii1l1;
    }

    public String getWebViewUrl() {
        return this.ilii1liii11i1iii1l1;
    }

    public boolean isPlayAudio() {
        return this.ll11li11l11il1lillll;
    }

    public boolean isShowFailResultPage() {
        return this.ii1lilli;
    }

    public boolean isShowReadyPage() {
        return this.i1lill1ii;
    }

    public boolean isShowSuccessResultPage() {
        return this.l1li11i1ll;
    }

    public void setActionStageTimeout(int i) {
        this.li1li1ii1ii11ii = i;
    }

    public void setAppKey(String str) {
        this.i1l1i1llllil1i1lii = str;
    }

    public void setCountry(String str) {
        this.i11iliil1li1 = str;
    }

    public void setDetectionThreshold(String str) {
        this.iill11l11 = str;
    }

    public void setEnv(String str) {
        this.il11iii11l11i1 = str;
    }

    public void setFaceMissingInterval(int i) {
        this.ll1i11ii1liilll1ii = i;
    }

    public void setHttpTimeout(int i) {
        this.i1i1l1lii = i;
    }

    public void setLanguage(String str) {
        this.iill11lliiil1l1i11l11 = str;
    }

    public void setPartnerCode(String str) {
        this.illill1ll1 = str;
    }

    public void setPartnerKey(String str) {
        this.il111liilil = str;
    }

    public void setPlayAudio(boolean z) {
        this.ll11li11l11il1lillll = z;
    }

    public void setPrepareStageTimeout(int i) {
        this.ll1lllii11l1iii1l1 = i;
    }

    public void setShowFailResultPage(boolean z) {
        this.ii1lilli = z;
    }

    public void setShowReadyPage(boolean z) {
        this.i1lill1ii = z;
    }

    public void setShowSuccessResultPage(boolean z) {
        this.l1li11i1ll = z;
    }

    public void setWebViewUrl(String str) {
        this.ilii1liii11i1iii1l1 = str;
    }

    public String toString() {
        return illill1ll1("35285c0d431e48155e15622a6637603675", 91) + illill1ll1("HDkhIjwJKhA5NglldA==") + this.illill1ll1 + '\'' + illill1ll1("QHgjNyAYNjYkGQkhbnE=") + this.il111liilil + '\'' + illill1ll1("4d076f0b75106f1664527e", 104) + this.i11iliil1li1 + '\'' + illill1ll1("QHg/NzwLLTIxN1F/") + this.iill11lliiil1l1i11l11 + '\'' + illill1ll1("QHg2OCRRfw==") + this.il11iii11l11i1 + '\'' + illill1ll1("QHgyJiInPSprdQ==") + this.i1l1i1llllil1i1lii + '\'' + illill1ll1("4d40684179507f476241637b5f614877537050780962", 47) + this.iill11l11 + '\'' + illill1ll1("QHg7IiYcDDo7NwMtJ2s=") + this.i1i1l1lii + illill1ll1("QHgjOjMVGSYyOwNl") + this.ll11li11l11il1lillll + illill1ll1("QHggPj0bCjY3NhUIMjE3UQ==") + this.i1lill1ii + illill1ll1("4d197f02781a5c3c4a3c4c2a4c0b7b1d7d0465205426567e", 118) + this.l1li11i1ll + illill1ll1("QHggPj0bHjI/Pj49ICM+GAgyMTdR") + this.ii1lilli + illill1ll1("QHg1NzEJFTolIQU2NB88GD0hIDMAZQ==") + this.ll1i11ii1liilll1ii + illill1ll1("4d167c146b017a126d244a314c337d0e7906731c7255", 121) + this.ll1lllii11l1iii1l1 + illill1ll1("QHgyNSYFNz0FJg0/NgI7AT08IyZR") + this.li1li1ii1ii11ii + '}';
    }

    private static String illill1ll1(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            int length = decode.length;
            byte[] bytes = "lXSVR".getBytes();
            int length2 = bytes.length;
            for (int i = 0; i < length; i++) {
                decode[i] = (byte) (decode[i] ^ bytes[i % length2]);
            }
            return new String(decode, "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }
}
