package com.trustdecision.liveness.cw.api.il111liilil;

import android.text.TextUtils;
import android.util.Base64;
import com.trustdecision.liveness.cw.api.TDLiveness;
import org.json.JSONException;
import org.json.JSONObject;

public class illill1ll1 {
    private static String il111liilil(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            int length = decode.length;
            byte[] bytes = "MfaG".getBytes();
            int length2 = bytes.length;
            for (int i = 0; i < length; i++) {
                decode[i] = (byte) (decode[i] ^ bytes[i % length2]);
            }
            return new String(decode, "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }

    public static void illill1ll1(String str) {
        com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1.ilii1liii11i1iii1l1 = str;
    }

    public static void illill1ll1(String str, int i, String str2, boolean z, boolean z2, il111liilil il111liilil) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(il111liilil("IQcPIDgHBiI="), str2);
            jSONObject.put(illill1ll1("1065706876", 68), z);
            jSONObject.put(il111liilil("PRQENywUBBg9BwYi"), z2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        i11iliil1li1.illill1ll1(str, jSONObject.toString(), i, il111liilil);
    }

    public static void illill1ll1(String str, String str2, int i, il111liilil il111liilil) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(il111liilil("OQkKIiM="), str2).put(il111liilil("OwMTNCQJDw=="), TDLiveness.getSDKVersion()).put(il111liilil("LwoAJCY5Ayg1"), com.trustdecision.liveness.cw.api.i11iliil1li1.illill1ll1.illill1ll1(TDLiveness.mContext)).put(il111liilil("PQoAMysJEyo="), il111liilil("LAgFNSIPBQ=="));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        i11iliil1li1.illill1ll1(str, jSONObject.toString(), i, il111liilil);
    }

    public static void illill1ll1(String str, String str2, String str3, String str4, String str5, int i, il111liilil il111liilil) {
        if (!TextUtils.isEmpty(str5)) {
            String format = String.format(com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1.ilii1liii11i1iii1l1 + com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1.iill11l11, new Object[]{str5});
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject put = jSONObject.put(il111liilil("PQcTJiA="), str3).put(illill1ll1("123b683a", 2), str).put(illill1ll1("1c797b79697f6b", 68), str2);
                String il111liilil2 = il111liilil("OwMTNCQJDw==");
                put.put(il111liilil2, TDLiveness.getSDKVersion() + il111liilil("YCoIMyg=")).put(illill1ll1("01297d3c6f35722a", 0), il111liilil("LAgFNSIPBQ==")).put(illill1ll1("022c652c7f2a7e1b4816", 15), str4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            i11iliil1li1.illill1ll1(format, jSONObject.toString(), i, il111liilil);
        }
    }

    private static String illill1ll1(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 53);
            byte b2 = (byte) (bArr[0] ^ 113);
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
}
