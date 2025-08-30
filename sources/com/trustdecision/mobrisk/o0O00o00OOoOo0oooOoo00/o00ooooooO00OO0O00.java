package com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00;

import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import com.trustdecision.mobrisk.TDRiskLivenessCallback;
import com.trustdecision.mobrisk.TDRiskOption;
import com.trustdecision.mobrisk.o0Oo0OO00O0O000ooOO0.O0oOO0ooO;
import com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o;
import java.lang.reflect.Proxy;
import org.apache.commons.lang3.CharEncoding;

public class o00ooooooO00OO0O00 {
    private static long o0Oo0OO00O0O000ooOO0;

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 31);
            byte b2 = (byte) (bArr[0] ^ 88);
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

    public static void o0Oo0OO00O0O000ooOO0(TDRiskOption tDRiskOption, Activity activity, String str, TDRiskLivenessCallback tDRiskLivenessCallback) {
        Class[] clsArr;
        Object[] objArr;
        if (SystemClock.elapsedRealtime() - o0Oo0OO00O0O000ooOO0 > 1000) {
            o0Oo0OO00O0O000ooOO0 = SystemClock.elapsedRealtime();
            try {
                Class<?> cls = Class.forName(o0Oo0OO00O0O000ooOO0("3b202e6f762a2b2a2b3c2d2a2636362a2d6c6e29333f27273a2c71613875633d356b563c2409333f27273a2c7b4a1b3029242d3b", 51));
                Object newInstance = cls.newInstance();
                oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("285153465a4b57716c4b41", 95), tDRiskOption.getPartnerCode());
                oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("281113061a0b17392e1c", 31), tDRiskOption.getPartnerKey());
                if (!TextUtils.isEmpty(tDRiskOption.getEnv())) {
                    oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("3d7d6e", 105), tDRiskOption.getEnv());
                }
                String language = tDRiskOption.getLanguage();
                if (!TextUtils.isEmpty(language) && !TextUtils.isDigitsOnly(language)) {
                    oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("34262422393f2d29", 52), tDRiskOption.getLanguage());
                }
                oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("3b736564657974", 96), tDRiskOption.getCountry());
                oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("2b233f201d0f3c3d2511093e3a", 39), Boolean.valueOf(tDRiskOption.isShowReadyPage()));
                oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("281e0f1a3a36130f04", 29), Boolean.valueOf(tDRiskOption.isPlayAudio()));
                oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("2b1a06192527170107170120361707181925300703", 30), Boolean.valueOf(tDRiskOption.isShowSuccessResultPage()));
                oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("2b0d110e27311e13282100100f0e32271014", 9), Boolean.valueOf(tDRiskOption.isShowFailResultPage()));
                oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("3c3e2e2e392822393e", 32), tDRiskOption.getlivenessDetectionThreshold());
                if (tDRiskOption.getLivenessHttpTimeOut() >= 0) {
                    oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("307b6763435a636f6d7d66", 120), Integer.valueOf(tDRiskOption.getLivenessHttpTimeOut()));
                }
                if (tDRiskOption.getFaceMissingInterval() >= 0) {
                    oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("3e5d585c727e405a405d53747d404b4d5e4d57", 69), Integer.valueOf(tDRiskOption.getFaceMissingInterval()));
                }
                if (tDRiskOption.getPrepareStageTimeout() >= 0) {
                    oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("286d787a7e7c7859487a696d5e526b6765756e", 112), Integer.valueOf(tDRiskOption.getPrepareStageTimeout()));
                }
                if (tDRiskOption.getActionStageTimeout() >= 0) {
                    oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("39392c263d3a061c2e3d390a063f3331213a", 36), Integer.valueOf(tDRiskOption.getActionStageTimeout()));
                }
                Class<?> cls2 = Class.forName(o0Oo0OO00O0O000ooOO0("3b565819005c5d5c5d4a5b5c5040405c5b1a185f454951514c5a07174e03154b431d204a527f454951514c5a", 69));
                Class<?> cls3 = Class.forName(o0Oo0OO00O0O000ooOO0("3b020c4d54080908091e0f08041414080f4e4c0b111d0505180e53431a57411f1749741e19350916352b111d0505180e3e2c030e000d0c06", 17));
                Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls3}, new O0oOO0ooO(tDRiskLivenessCallback));
                Object o0Oo0OO00O0O000ooOO02 = oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) newInstance, o0Oo0OO00O0O000ooOO0("3a151e070a", 29), new Object[0]);
                oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls2, (Object) null, o0Oo0OO00O0O000ooOO0("31424258", 90), o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(), o0Oo0OO00O0O000ooOO02);
                Class<String> cls4 = String.class;
                if (activity != null) {
                    clsArr = new Class[]{Activity.class, cls4, cls3};
                    objArr = new Object[]{activity, str, newProxyInstance};
                } else {
                    clsArr = new Class[]{cls4, cls3};
                    objArr = new Object[]{str, newProxyInstance};
                }
                oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls2, (Object) null, o0Oo0OO00O0O000ooOO0("2b637f60435d676b73736e78", 103), clsArr, objArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(TDRiskOption tDRiskOption, String str, TDRiskLivenessCallback tDRiskLivenessCallback) {
        o0Oo0OO00O0O000ooOO0(tDRiskOption, (Activity) null, str, tDRiskLivenessCallback);
    }
}
