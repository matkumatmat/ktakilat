package com.trustdecision.liveness.cw.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.trustdecision.liveness.cw.api.il111liilil.il111liilil;

public class illill1ll1 {
    /* access modifiers changed from: private */
    public static String i11iliil1li1 = "";
    private static final il111liilil i1l1i1llllil1i1lii = new i11iliil1li1();
    /* access modifiers changed from: private */
    public static String iill11lliiil1l1i11l11 = "";
    private static final String il111liilil = il111liilil("22105c3543266b0a6405620775", 99);
    private static TDShowLivenessCallback il11iii11l11i1;
    private static String ilii1liii11i1iii1l1 = "";
    public static boolean illill1ll1 = false;

    /* access modifiers changed from: private */
    public static String il11iii11l11i1(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            int length = decode.length;
            byte[] bytes = "xhwsnfF".getBytes();
            int length2 = bytes.length;
            for (int i = 0; i < length; i++) {
                decode[i] = (byte) (decode[i] ^ bytes[i % length2]);
            }
            return new String(decode, "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }

    private static String ilii1liii11i1iii1l1(String str) {
        if (TextUtils.isEmpty(str)) {
            return il11iii11l11i1("HQY=");
        }
        if (TDLiveness.LANG_CN.equals(str) || il111liilil("0c673f22362d2b", 22).equalsIgnoreCase(str)) {
            return il11iii11l11i1("AgBaOw8INQ==");
        }
        if (il111liilil("0c5f4d724b71", 46).equalsIgnoreCase(str) || il111liilil("0c193f5c36532c", 104).equalsIgnoreCase(str)) {
            return il11iii11l11i1("AgBaOw8IMg==");
        }
        if (il11iii11l11i1("DAQ=").equalsIgnoreCase(str)) {
            return il111liilil("102263", 78);
        }
        if (str.matches(il11iii11l11i1("VkIsLxtSI0hYWi8bXyAZXSpdRA=="))) {
            return il11iii11l11i1("HQY=");
        }
        return str.toLowerCase();
    }

    public static void il111liilil(String str, String str2) {
        illill1ll1(String.valueOf(str), str2, "");
    }

    /* access modifiers changed from: private */
    public static String il111liilil(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 99);
            byte b2 = (byte) (bArr[0] ^ 118);
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

    public static void illill1ll1(Context context, String str, TDShowLivenessCallback tDShowLivenessCallback) {
        TDLivenessOption option = TDLiveness.getOption();
        if (!illill1ll1) {
            if (tDShowLivenessCallback != null) {
                il11iii11l11i1 = tDShowLivenessCallback;
            }
            ilii1liii11i1iii1l1 = str;
            illill1ll1(option);
            if (!TextUtils.isEmpty(ilii1liii11i1iii1l1)) {
                illill1ll1(context, String.format(com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1.ilii1liii11i1iii1l1 + com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1.il11iii11l11i1, new Object[]{ilii1liii11i1iii1l1}));
            } else if (tDShowLivenessCallback != null) {
                il11iii11l11i1.onError(il111liilil("403d363d37", 88), il111liilil("1b4e48444e4f535916100c4342585b58", 12), "");
            }
        }
    }

    private static void illill1ll1(Context context, String str) {
        illill1ll1 = true;
        TDLivenessOption option = TDLiveness.getOption();
        com.trustdecision.liveness.cw.api.il111liilil.illill1ll1.illill1ll1(str, option.getHttpTimeout(), ilii1liii11i1iii1l1(option.getLanguage()), option.isPlayAudio(), option.isShowReadyPage(), new il111liilil(context));
    }

    public static void illill1ll1(String str, String str2) {
        com.trustdecision.liveness.cw.api.il111liilil.illill1ll1.illill1ll1(str, str2, "", i11iliil1li1, ilii1liii11i1iii1l1, TDLiveness.getOption().getHttpTimeout(), i1l1i1llllil1i1lii);
    }

    public static void illill1ll1(il111liilil il111liilil2) {
        com.trustdecision.liveness.cw.api.il111liilil.illill1ll1.illill1ll1(String.format(com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1.ilii1liii11i1iii1l1 + com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1.i1l1i1llllil1i1lii, new Object[]{ilii1liii11i1iii1l1}), i11iliil1li1, TDLiveness.getOption().getHttpTimeout(), il111liilil2);
    }

    private static void illill1ll1(TDLivenessOption tDLivenessOption) {
        String country = tDLivenessOption.getCountry();
        if (!TextUtils.isEmpty(country)) {
            String str = com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1.il111liilil;
            if (!TDLiveness.COUNTRY_US.equals(country) && !TDLiveness.COUNTRY_FRA.equals(country)) {
                if (TDLiveness.COUNTRY_TEST.equals(country)) {
                    str = com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1.i11iliil1li1;
                } else if (!TDLiveness.COUNTRY_CN.equals(country)) {
                    if (TDLiveness.COUNTRY_IDNA.equals(country)) {
                        str = com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1.illill1ll1;
                    } else {
                        boolean equals = TDLiveness.COUNTRY_SG.equals(country);
                    }
                }
            }
            if (!TextUtils.isEmpty(tDLivenessOption.getEnv())) {
                str = str.replaceAll(il111liilil("5b3e3c293d2420", 19), tDLivenessOption.getEnv());
            }
            com.trustdecision.liveness.cw.api.il111liilil.illill1ll1.illill1ll1(str);
        }
    }

    public static void illill1ll1(String str) {
        illill1ll1 = false;
        TDShowLivenessCallback tDShowLivenessCallback = il11iii11l11i1;
        if (tDShowLivenessCallback != null) {
            tDShowLivenessCallback.onSuccess(str);
        }
    }

    public static void illill1ll1(String str, String str2, String str3) {
        illill1ll1 = false;
        if (il11iii11l11i1 == null) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            il11iii11l11i1.onError(str, "", str3);
        } else {
            il11iii11l11i1.onError(str, str2, str3);
        }
    }
}
