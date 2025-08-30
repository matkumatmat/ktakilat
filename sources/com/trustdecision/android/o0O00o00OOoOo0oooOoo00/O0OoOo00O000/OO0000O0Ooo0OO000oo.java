package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.O00OO0oOOooooO00000Oo;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONArray;
import org.json.JSONObject;

public class OO0000O0Ooo0OO000oo {
    public static final String O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0("04342c", 119);
    public static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("0706", 66);
    public static final String OO0000O0Ooo0OO000oo = o0Oo0OO00O0O000ooOO0("4541111a4944050a4a57000656471511", 70);
    private static volatile OO0000O0Ooo0OO000oo OoOOooOoooOoo;
    public static final String o00ooooooO00OO0O00 = o0Oo0OO00O0O000ooOO0("197c65", 63);
    public static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("1755", 7);
    public static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("17", 123);
    public static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("0705", 82);

    private OO0000O0Ooo0OO000oo() {
    }

    public static OO0000O0Ooo0OO000oo o0Oo0OO00O0O000ooOO0() {
        if (OoOOooOoooOoo == null) {
            synchronized (OO0000O0Ooo0OO000oo.class) {
                try {
                    if (OoOOooOoooOoo == null) {
                        OoOOooOoooOoo = new OO0000O0Ooo0OO000oo();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return OoOOooOoooOoo;
    }

    private String oO00o0OooO0OO0o0000o(String str) {
        try {
            return new String(Base64.decode(str, 0), o0Oo0OO00O0O000ooOO0("0176653c62", 48));
        } catch (Throwable unused) {
            return "";
        }
    }

    public O00OO0oOOooooO00000Oo o0O00o00OOoOo0oooOoo00(Context context) {
        try {
            String oO00o0OooO0OO0o0000o2 = oO00o0OooO0OO0o0000o(o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO0("070e", 89), ""));
            if (TextUtils.isEmpty(oO00o0OooO0OO0o0000o2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(oO00o0OooO0OO0o0000o2);
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
            CopyOnWriteArrayList copyOnWriteArrayList3 = new CopyOnWriteArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray(o0Oo0OO00O0O000ooOO0("04435b", 0));
            JSONArray optJSONArray2 = jSONObject.optJSONArray(o0Oo0OO00O0O000ooOO0("0706", 66));
            JSONArray optJSONArray3 = jSONObject.optJSONArray(o0Oo0OO00O0O000ooOO0("191009", 83));
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        copyOnWriteArrayList.add(optString);
                    }
                }
            }
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    String string = optJSONArray2.getString(i2);
                    if (!TextUtils.isEmpty(string)) {
                        copyOnWriteArrayList2.add(string);
                    }
                }
            }
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    String optString2 = optJSONArray3.optString(i3);
                    if (!TextUtils.isEmpty(optString2)) {
                        copyOnWriteArrayList3.add(optString2);
                    }
                }
            }
            return new O00OO0oOOooooO00000Oo(copyOnWriteArrayList, copyOnWriteArrayList2, copyOnWriteArrayList3);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String o0O00o00OOoOo0oooOoo00(Context context, String str, String str2) {
        return com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO0(str), str2);
    }

    @NonNull
    public String o0Oo0OO00O0O000ooOO0(Context context) {
        return o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO0("1706", 84), o0Oo0OO00O0O000ooOO0("44", 32));
    }

    private String o0O00o00OOoOo0oooOoo00(String str) {
        try {
            return new String(Base64.encode(str.getBytes(o0Oo0OO00O0O000ooOO0("0121326b35", 103)), 0), o0Oo0OO00O0O000ooOO0("0127346d33", 97));
        } catch (Throwable unused) {
            return "";
        }
    }

    @NonNull
    private String o0Oo0OO00O0O000ooOO0(String str) {
        o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo2 = o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        return ba.r(ba.v(str), o0Oo0OO00O0O000ooOO0("59", 86), oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(O00OO0oOOooooO00000Oo2.oO0OOO00 + o0Oo0OO00O0O000ooOO0("59", 65) + O00OO0oOOooooO00000Oo2.O0oOO0ooO));
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
            byte b = (byte) (i ^ 71);
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

    private void o0Oo0OO00O0O000ooOO0(Context context, String str, String str2) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0(str), str2);
    }

    public void o0Oo0OO00O0O000ooOO0(Context context, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(o0Oo0OO00O0O000ooOO0("17", 73));
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(o0Oo0OO00O0O000ooOO0("1751", 3));
                String optString2 = optJSONObject.optString(o0Oo0OO00O0O000ooOO0("0740", 23));
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    String o0Oo0OO00O0O000ooOO02 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(optString2, o0Oo0OO00O0O000ooOO0("456a3a31626f2e21617c2b2d7d6c3e3a", 109));
                    if (!TextUtils.isEmpty(o0Oo0OO00O0O000ooOO02)) {
                        o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("174c", 30), optString);
                        o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("0709", 94), o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO02));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
