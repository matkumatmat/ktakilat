package com.trustdecision.liveness.cw.api.il111liilil;

import android.util.Base64;
import org.json.JSONException;
import org.json.JSONObject;

class ilii1liii11i1iii1l1 implements Runnable {
    private final String i11iliil1li1;
    private final int iill11lliiil1l1i11l11;
    private final String il111liilil;
    private final il111liilil illill1ll1;

    public ilii1liii11i1iii1l1(String str, String str2, il111liilil il111liilil2, int i) {
        this.illill1ll1 = il111liilil2;
        this.i11iliil1li1 = str2;
        this.il111liilil = str;
        this.iill11lliiil1l1i11l11 = i;
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
            byte b = (byte) (i ^ 15);
            byte b2 = (byte) (bArr[0] ^ 60);
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

    public void run() {
        JSONObject jSONObject;
        String illill1ll12 = il11iii11l11i1.illill1ll1(this.il111liilil, this.i11iliil1li1, this.iill11lliiil1l1i11l11);
        if (this.illill1ll1 != null) {
            try {
                jSONObject = new JSONObject(illill1ll12);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject.optInt(illill1ll1("AgEzLA==")) == 200) {
                this.illill1ll1.onSuccess(jSONObject.optString(illill1ll1("4e0464027d1a", 28)));
            } else {
                this.illill1ll1.onError(jSONObject.optString(illill1ll1("EwskPAUi")));
            }
        }
    }

    private static String illill1ll1(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            int length = decode.length;
            byte[] bytes = "anWIiVR".getBytes();
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
