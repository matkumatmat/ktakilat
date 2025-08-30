package com.trustdecision.android.shell.o0Oo0OO00O0O000ooOO0;

import android.text.TextUtils;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class o0Oo0OO00O0O000ooOO0 {
    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 8);
            byte b2 = (byte) (bArr[0] ^ 81);
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

    public static String o0Oo0OO00O0O000ooOO0(JSONObject jSONObject, int i) {
        int length = (jSONObject.toString().length() * 4) / 3;
        if (length >= i) {
            String optString = jSONObject.optString(o0Oo0OO00O0O000ooOO0("3c3c36", 42));
            if (TextUtils.isEmpty(optString)) {
                return jSONObject.toString();
            }
            try {
                JSONArray jSONArray = new JSONArray(optString);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        optJSONObject.remove(o0Oo0OO00O0O000ooOO0("232d3e28263b", 50));
                    }
                }
                try {
                    jSONObject.put(o0Oo0OO00O0O000ooOO0("3c0c06", 26), jSONArray);
                } catch (JSONException unused) {
                }
                if (length > i) {
                    jSONObject.remove(o0Oo0OO00O0O000ooOO0("3c4c46", 90));
                }
            } catch (JSONException unused2) {
                return jSONObject.toString();
            }
        }
        return jSONObject.toString();
    }
}
