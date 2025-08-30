package com.trustdecision.android.oO00o0OooO0OO0o0000o;

import android.text.TextUtils;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONException;
import org.json.JSONObject;

public class O0oOO0ooO {
    public String O00OO0oOOooooO00000Oo;
    public String O0oOO0ooO;
    public long OO0000O0Ooo0OO000oo;
    private final boolean OoOOooOoooOoo = false;
    public String o00ooooooO00OO0O00;
    public String o0O00o00OOoOo0oooOoo00;
    public String o0Oo0OO00O0O000ooOO0;
    public String oO00o0OooO0OO0o0000o;

    private O0oOO0ooO(com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.O0oOO0ooO o0oOO0ooO, long j) {
        this.o0Oo0OO00O0O000ooOO0 = o0oOO0ooO.o00ooooooO00OO0O00();
        this.O0oOO0ooO = o0oOO0ooO.OO0000O0Ooo0OO000oo();
        this.O00OO0oOOooooO00000Oo = o0oOO0ooO.o0O00o00OOoOo0oooOoo00();
        this.o00ooooooO00OO0O00 = o0oOO0ooO.o0Oo0OO00O0O000ooOO0();
        this.OO0000O0Ooo0OO000oo = j;
    }

    public static O0oOO0ooO o0Oo0OO00O0O000ooOO0(com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.O0oOO0ooO o0oOO0ooO, long j) {
        return new O0oOO0ooO(o0oOO0ooO, j);
    }

    public boolean o0O00o00OOoOo0oooOoo00() {
        return (this.o0Oo0OO00O0O000ooOO0 == null && this.o0O00o00OOoOo0oooOoo00 == null && this.oO00o0OooO0OO0o0000o == null) ? false : true;
    }

    public JSONObject oO00o0OooO0OO0o0000o() {
        if (o0Oo0OO00O0O000ooOO0()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(o0Oo0OO00O0O000ooOO0("68434540", 122), this.o0Oo0OO00O0O000ooOO0);
            jSONObject.put(o0Oo0OO00O0O000ooOO0("652a293530", 13), this.O0oOO0ooO);
            jSONObject.put(o0Oo0OO00O0O000ooOO0("71606472697572", 68), this.O00OO0oOOooooO00000Oo);
            jSONObject.put(o0Oo0OO00O0O000ooOO0("6a617f697b6f6b", 94), this.o00ooooooO00OO0O00);
            jSONObject.put(o0Oo0OO00O0O000ooOO0("731d0408262c1c07", 55), this.OO0000O0Ooo0OO000oo);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(o0Oo0OO00O0O000ooOO0("6a444040", 122), jSONObject);
            return jSONObject2;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private O0oOO0ooO(String str, long j) {
        this.o00ooooooO00OO0O00 = str;
        this.OO0000O0Ooo0OO000oo = j;
    }

    public static O0oOO0ooO o0Oo0OO00O0O000ooOO0(String str, long j) {
        return new O0oOO0ooO(str, j);
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
            byte b2 = (byte) (bArr[0] ^ 7);
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

    public boolean o0Oo0OO00O0O000ooOO0() {
        return this.o0Oo0OO00O0O000ooOO0 == null && this.o0O00o00OOoOo0oooOoo00 == null && this.oO00o0OooO0OO0o0000o == null && TextUtils.isEmpty(this.O00OO0oOOooooO00000Oo) && TextUtils.isEmpty(this.o00ooooooO00OO0O00);
    }
}
