package com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00;

import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import com.trustdecision.mobrisk.TDRiskCaptchaCallback;
import com.trustdecision.mobrisk.TDRiskOption;
import com.trustdecision.mobrisk.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo;
import java.lang.reflect.Proxy;
import org.apache.commons.lang3.CharEncoding;

public class oO00o0OooO0OO0o0000o {
    private static long o0O00o00OOoOo0oooOoo00;
    public static boolean o0Oo0OO00O0O000ooOO0;

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 82);
            byte b2 = (byte) (bArr[0] ^ 125);
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

    public static void o0Oo0OO00O0O000ooOO0(Activity activity, TDRiskOption tDRiskOption, TDRiskCaptchaCallback tDRiskCaptchaCallback) {
        int parseInt;
        if (!o0Oo0OO00O0O000ooOO0 || SystemClock.elapsedRealtime() - o0O00o00OOoOo0oooOoo00 > 1000) {
            o0O00o00OOoOo0oooOoo00 = SystemClock.elapsedRealtime();
            try {
                Class<?> cls = Class.forName(o0Oo0OO00O0O000ooOO0("1e3937766f333233322534333f2f2f33347578372431223e3c38303e7958172431223e3c1719343d3a3b76530229303d3422", 103));
                Object newInstance = cls.newInstance();
                com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("0d3e3c293524381e03242e", 125), tDRiskOption.getPartnerCode());
                com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("1c160739280b0f", 85), tDRiskOption.getAppName());
                String language = tDRiskOption.getLanguage();
                if (!TextUtils.isEmpty(language) && TextUtils.isDigitsOnly(language) && (parseInt = Integer.parseInt(language)) > 0) {
                    com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("0e4a4d647153554e485a5e", 14), Integer.valueOf(parseInt));
                }
                com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("1209031d34351e", 68), Boolean.valueOf(tDRiskOption.getOpenLog()));
                com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("13567e5c5e7644485d51", 5), Boolean.valueOf(tDRiskOption.getNoFMDevice()));
                com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("134e45447273517d68", 23), Boolean.valueOf(tDRiskOption.getNeedSeqid()));
                com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("09393d081700032f303a", 126), Boolean.valueOf(tDRiskOption.getTapToClose()));
                com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("156c606c444e636841507c", 63), Boolean.valueOf(tDRiskOption.getHideLoadHud()));
                com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("15565a566565507678544b41706056574c56", 5), Boolean.valueOf(tDRiskOption.getHideWebCloseButton()));
                com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("0e140e153f2705010c0507050e", 94), Boolean.valueOf(tDRiskOption.getSkipCaptcha()));
                com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("1069654a4f", 48), tDRiskOption.getMfaId());
                Class<?> cls2 = Class.forName(o0Oo0OO00O0O000ooOO0("1e7c72332a767776776071767a6a6a7671303d726174677b797d757b3c0a60765b777a57526174677b79", 34));
                Class<?> cls3 = Class.forName(o0Oo0OO00O0O000ooOO0("1e6967263f636263627564636f7f7f63642528677461726e6c68606e290d6e6b477461726e6c474768654b46676d", 55));
                Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls3}, new O00OO0oOOooooO00000Oo(tDRiskCaptchaCallback));
                Object o0Oo0OO00O0O000ooOO02 = com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("1f555e474a", 16), new Object[0]);
                Object o0Oo0OO00O0O000ooOO03 = com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls2, (Object) null, o0Oo0OO00O0O000ooOO0("14080812", 93), activity, o0Oo0OO00O0O000ooOO02, newProxyInstance);
                o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO03, tDRiskOption.getCountry());
                com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls2, o0Oo0OO00O0O000ooOO03, o0Oo0OO00O0O000ooOO0("0b2e2a263222", 111), new Object[0]);
                o0Oo0OO00O0O000ooOO0 = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void o0Oo0OO00O0O000ooOO0(Object obj, String str) {
        String o0Oo0OO00O0O000ooOO02;
        String str2;
        int i;
        if (str.equals(o0Oo0OO00O0O000ooOO0("2e4f", 9))) {
            o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("0e49495e455c5a4b0b07465c545e4c461d1d564c", 15);
            str2 = "0e1d0f0f07105740011b13190b015a5a110b41460e5256180b1e0d1113";
            i = 72;
        } else if (str.equals(o0Oo0OO00O0O000ooOO0("2808", 92))) {
            o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("0b4a4f5e455c5a4b0b07465c545e4c461d1d564c", 15);
            str2 = "0e293b3b33246374352f272d3f356e6e253f75742872622c3f2a392527";
            i = 124;
        } else if (str.equals(o0Oo0OO00O0O000ooOO0("3b2423", 98))) {
            o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("1b6a6d7e6c7d667f79682824657f777d6f653e3e756f", 44);
            str2 = "0e6f7d7d756225327369616b79732828637933217c7b26246a796c7f6361";
            i = 58;
        } else {
            o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("0e756e777160202c6d777f75676d36367d67", 36);
            str2 = "0e6d7f7f77602730716b63697b712a2a617b3126687b6e7d6163";
            i = 56;
        }
        String o0Oo0OO00O0O000ooOO03 = o0Oo0OO00O0O000ooOO0(str2, i);
        com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("1e444a0b124e4f4e4f58494e4252524e4908054a594c5f4341454d430432584e634f426f6a594c5f4341", 26), obj, o0Oo0OO00O0O000ooOO0("0e3334140e3d", 119), o0Oo0OO00O0O000ooOO03, o0Oo0OO00O0O000ooOO02, 1);
    }
}
