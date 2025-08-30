package com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.text.TextUtils;
import com.trustdecision.mobrisk.TDErrorCodeCallback;
import com.trustdecision.mobrisk.TDRiskCallback;
import com.trustdecision.mobrisk.TDRiskOption;
import com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00;
import com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONObject;

public class O00OO0oOOooooO00000Oo {
    public static String o0Oo0OO00O0O000ooOO0() {
        try {
            return (String) oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("5e353b7a633f3e3f3e29383f3323233f38797636332f243f347364223430397b5132351f3b3223", 15), (Object) null, o0Oo0OO00O0O000ooOO0("527d574f6f7766", 74), o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0());
        } catch (Throwable th) {
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(th);
            String valueOf = String.valueOf(o0Oo0OO00O0O000ooOO0(th));
            o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("5a6172554d6e616b4a4e742179", 85) + valueOf);
            return valueOf;
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
            byte b = (byte) (i ^ 54);
            byte b2 = (byte) (bArr[0] ^ 61);
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

    private static JSONObject o0Oo0OO00O0O000ooOO0(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(o0Oo0OO00O0O000ooOO0("4f6477616f72", 69), th.getLocalizedMessage());
            jSONObject.put(o0Oo0OO00O0O000ooOO0("4925213d", 30), th.getClass().getName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (stackTraceElement.getClassName().contains(o0Oo0OO00O0O000ooOO0("5e575918015d5c5d5c4b5a5d5141415d5a1b1859564b404143", 109))) {
                    jSONObject.put(o0Oo0OO00O0O000ooOO0("4e6577606a", 84), stackTraceElement.toString());
                    break;
                }
                i++;
            }
            return jSONObject;
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(TDErrorCodeCallback tDErrorCodeCallback) {
        Object obj;
        try {
            Class<?> cls = Class.forName(o0Oo0OO00O0O000ooOO0("5e0f014059050405041302050919190502434c0c09151e050e495e180e0a03416b080f25010819", 53));
            Class<?> cls2 = Class.forName(o0Oo0OO00O0O000ooOO0("5e6e602138646564657263646878786463222d6d68747f646f283f796f6b622025657873753e0a69684073544c6f606a4b4f75594e696344406f626c61606a", 84));
            if (tDErrorCodeCallback != null) {
                obj = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls2}, new com.trustdecision.mobrisk.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(tDErrorCodeCallback));
            } else {
                obj = null;
            }
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) null, o0Oo0OO00O0O000ooOO0("4e56517b616b77405d5d716c4b4169655a47514b4b57", 118), new Class[]{cls2}, new Object[]{obj});
        } catch (Throwable th) {
            o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("4e0e092339332f18050529341319313d021f0913130f5002", 46) + String.valueOf(o0Oo0OO00O0O000ooOO0(th)));
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(TDRiskCallback tDRiskCallback) {
        Object obj;
        try {
            Class<?> cls = Class.forName(o0Oo0OO00O0O000ooOO0("5e4e400118444544455243444858584443020d4d48545f444f081f594f4b42002a494e64404958", 116));
            Class<?> cls2 = Class.forName(o0Oo0OO00O0O000ooOO0("5e2f216079252425243322252939392522636c2c29353e252e697e382e2a236164243932347f4b282d012e232d20212b", 21));
            if (tDRiskCallback != null) {
                obj = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls2}, new com.trustdecision.mobrisk.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o(tDRiskCallback));
            } else {
                obj = null;
            }
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) null, o0Oo0OO00O0O000ooOO0("521c362e0e1607", 43), new Class[]{Context.class, cls2}, new Object[]{o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(), obj});
        } catch (Throwable th) {
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(th);
            if (tDRiskCallback != null) {
                String valueOf = String.valueOf(o0Oo0OO00O0O000ooOO0(th));
                o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("5a5a496e76555a5071754f1a42", 110) + valueOf);
                tDRiskCallback.onEvent(valueOf);
            }
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(TDRiskOption tDRiskOption) {
        String o0Oo0OO00O0O000ooOO0;
        String o0Oo0OO00O0O000ooOO02;
        String o0Oo0OO00O0O000ooOO03;
        Boolean bool;
        String o0Oo0OO00O0O000ooOO04;
        Boolean bool2;
        String o0Oo0OO00O0O000ooOO05;
        Boolean bool3;
        String o0Oo0OO00O0O000ooOO06;
        Boolean bool4;
        try {
            Class<?> cls = Class.forName(o0Oo0OO00O0O000ooOO0("5e060849500c0d0c0d1a0b0c0010100c0b4a4505001c170c0740571107030a486201062c080110", 60));
            HashMap hashMap = new HashMap();
            hashMap.put(o0Oo0OO00O0O000ooOO0("4d43415443457f6e5e5953", 100), tDRiskOption.getPartnerCode());
            hashMap.put(o0Oo0OO00O0O000ooOO0("5e001617160a07", 58), tDRiskOption.getCountry());
            hashMap.put(o0Oo0OO00O0O000ooOO0("5c61705f447e6c", 70), tDRiskOption.getAppKey());
            hashMap.put(o0Oo0OO00O0O000ooOO0("50515e4348494b677a404452495552", 101), o0Oo0OO00O0O000ooOO0("0843474744", 110));
            if (o0Oo0OO00O0O000ooOO0("4e392b39", 29).equals(tDRiskOption.getPlatform())) {
                o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("4d73627a7d667270", 89);
                o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("4e1a081a", 62);
            } else {
                o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("4d16071f18031715", 60);
                o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("4d5c4d5f", 123);
            }
            hashMap.put(o0Oo0OO00O0O000ooOO0, o0Oo0OO00O0O000ooOO02);
            if (!TextUtils.isEmpty(tDRiskOption.getEnterpriseUrl())) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("5e3121203c25150d2039", 17), tDRiskOption.getEnterpriseUrl());
            }
            if (!TextUtils.isEmpty(tDRiskOption.getDomain())) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("593e37393d32", 3), tDRiskOption.getDomain());
            }
            if (!TextUtils.isEmpty(tDRiskOption.getAppName())) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("7c43525d435d5e5a", 100), tDRiskOption.getAppName());
            }
            if (!TextUtils.isEmpty(tDRiskOption.getClientKey())) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("5c11001c050a02151d060131360d", 54), tDRiskOption.getClientKey());
            }
            if (!TextUtils.isEmpty(tDRiskOption.getCustomProcessName())) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("5e6e7e7f53577a65747e6e78", 78), tDRiskOption.getCustomProcessName());
            }
            if (!TextUtils.isEmpty(tDRiskOption.getChannel())) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("5e232127282321", 30), tDRiskOption.getChannel());
            }
            if (!TextUtils.isEmpty(tDRiskOption.getCollectLevel())) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("5e737c7f767968544c766c6c76", 73), tDRiskOption.getCollectLevel());
            }
            if (tDRiskOption.getHttpTimeOut() != 0) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("553a2622090d3b222e1c163c27", 16), Integer.valueOf(tDRiskOption.getHttpTimeOut()));
            }
            if (tDRiskOption.getBlackBoxMaxSize() != 0) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("5f41424d47464258687d435644555c50", 121), Integer.valueOf(tDRiskOption.getBlackBoxMaxSize()));
            }
            if (tDRiskOption.getWaitTime() != 0) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("4a130d182e2e18010d", 51), Integer.valueOf(tDRiskOption.getWaitTime()));
            }
            if (tDRiskOption.getForceTLSVersion()) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("5b75616d7a4657646350556f6b7d667a7d4d4677737f7275", 74), Boolean.FALSE);
            }
            if (tDRiskOption.getDebugger()) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("56050207343c061715070510", 49), Boolean.TRUE);
            }
            if (tDRiskOption.getRunningTasks()) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("4f766a71767678495a646369454b7a7e727f78", 71), Boolean.FALSE);
            }
            if (tDRiskOption.getInstallPackageList()) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("54776d77657d704c4172787a767266465b7f737e79", 70), Boolean.FALSE);
            }
            if (tDRiskOption.getGPS()) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("4e4a504b7d6a4551", 100), Boolean.TRUE);
            }
            if (tDRiskOption.getReadPhone()) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("4f455657697d4a5553596868595d515c5b", 100), Boolean.FALSE);
            }
            if (tDRiskOption.getSensor()) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("6e5e637574755f43676b6661", 94), Boolean.FALSE);
            }
            if (tDRiskOption.getAlwaysDemotion()) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("5c4f59545a486e79434a40595f4443", 116), Boolean.valueOf(tDRiskOption.getAlwaysDemotion()));
            }
            if (tDRiskOption.getUseDemotionData()) {
                hashMap.put(o0Oo0OO00O0O000ooOO0("484b5b77764c454f56504b4c", 123), Boolean.valueOf(tDRiskOption.getUseDemotionData()));
            }
            if (tDRiskOption.isWifiMacDisable()) {
                o0Oo0OO00O0O000ooOO03 = o0Oo0OO00O0O000ooOO0("4a3726260d052b0f02262a2720", 31);
                bool = Boolean.FALSE;
            } else {
                o0Oo0OO00O0O000ooOO03 = o0Oo0OO00O0O000ooOO0("4a786969424a64404d6965686f", 80);
                bool = Boolean.TRUE;
            }
            hashMap.put(o0Oo0OO00O0O000ooOO03, bool);
            if (tDRiskOption.isGoogleAidDisable()) {
                o0Oo0OO00O0O000ooOO04 = o0Oo0OO00O0O000ooOO0("5a444c44474576724441777647434f4245", 122);
                bool2 = Boolean.FALSE;
            } else {
                o0Oo0OO00O0O000ooOO04 = o0Oo0OO00O0O000ooOO0("5a404840434172764045737243474b4641", 126);
                bool2 = Boolean.TRUE;
            }
            hashMap.put(o0Oo0OO00O0O000ooOO04, bool2);
            if (tDRiskOption.isOaidDisable()) {
                o0Oo0OO00O0O000ooOO05 = o0Oo0OO00O0O000ooOO0("521e181d2b2a1b1f131e19", 38);
                bool3 = Boolean.FALSE;
            } else {
                o0Oo0OO00O0O000ooOO05 = o0Oo0OO00O0O000ooOO0("527b7d784e4f7e7a767b7c", 67);
                bool3 = Boolean.TRUE;
            }
            hashMap.put(o0Oo0OO00O0O000ooOO05, bool3);
            if (tDRiskOption.isStorageIdDisable()) {
                o0Oo0OO00O0O000ooOO06 = o0Oo0OO00O0O000ooOO0("4e2a36303e2b2f171b20161726222e2324", 27);
                bool4 = Boolean.FALSE;
            } else {
                o0Oo0OO00O0O000ooOO06 = o0Oo0OO00O0O000ooOO0("4e3d2127293c38000c3701003135393433", 12);
                bool4 = Boolean.TRUE;
            }
            hashMap.put(o0Oo0OO00O0O000ooOO06, bool4);
            hashMap.put(o0Oo0OO00O0O000ooOO0("52756e776c6b5b58667872", 92), Integer.valueOf(tDRiskOption.getOptionsMask()));
            hashMap.put(o0Oo0OO00O0O000ooOO0("5e2b3b3a263f0f0f352b3d2f3b3f", 11), tDRiskOption.getCustomMessage());
            hashMap.put(o0Oo0OO00O0O000ooOO0("4e585b5e4143587567574373624f495f5343", 104), Boolean.valueOf(tDRiskOption.getSupportForCredit()));
            String str = "";
            if (!TextUtils.isEmpty(tDRiskOption.getEnv())) {
                str = tDRiskOption.getEnv();
            }
            o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("52504b52494e520655", 121) + hashMap.toString());
            Class<Map> cls2 = Map.class;
            Class<Context> cls3 = Context.class;
            if (tDRiskOption.getProductType() == 0) {
                oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) null, o0Oo0OO00O0O000ooOO0("5445455f617c5f5e657d465f44435f", 116), new Class[]{cls3, String.class, cls2}, new Object[]{o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(), str, hashMap});
                return;
            }
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) null, o0Oo0OO00O0O000ooOO0("5410100a300105290a0b3028130a11160a", 33), new Class[]{cls3, cls2}, new Object[]{o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(), hashMap});
        } catch (Throwable th) {
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(th);
        }
    }
}
