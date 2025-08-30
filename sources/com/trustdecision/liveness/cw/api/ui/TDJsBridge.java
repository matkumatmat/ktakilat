package com.trustdecision.liveness.cw.api.ui;

import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.google.common.base.Ascii;
import com.trustdecision.liveness.cw.api.TDLiveness;
import com.trustdecision.liveness.cw.api.i11iliil1li1.illill1ll1;
import org.json.JSONException;
import org.json.JSONObject;

public class TDJsBridge {
    private JSCallBack mJsCallBack;

    public interface JSCallBack {
        void jsLiveResult(String str, String str2);

        void jsLog(String str);
    }

    public TDJsBridge(JSCallBack jSCallBack) {
        this.mJsCallBack = jSCallBack;
    }

    private static String i1i1iI1I11iI(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            int length = decode.length;
            byte[] bytes = "bPUArFv".getBytes();
            int length2 = bytes.length;
            for (int i = 0; i < length; i++) {
                decode[i] = (byte) (decode[i] ^ bytes[i % length2]);
            }
            return new String(decode, "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }

    private static String linkxxxxx(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 35);
            byte b2 = (byte) (bArr[0] ^ Ascii.VT);
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

    @JavascriptInterface
    public String jsGet() {
        return illill1ll1.illill1ll1(TDLiveness.mContext);
    }

    @JavascriptInterface
    public String jsLiveResult(String str) {
        if (this.mJsCallBack == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mJsCallBack.jsLiveResult(jSONObject.optString(i1i1iI1I11iI("AT8xJA==")), jSONObject.optString(i1i1iI1I11iI("ESQ0NRc=")));
            return "";
        } catch (JSONException unused) {
            return "";
        }
    }

    @JavascriptInterface
    public String jsLog(String str) {
        JSCallBack jSCallBack = this.mJsCallBack;
        if (jSCallBack == null) {
            return "";
        }
        jSCallBack.jsLog(str);
        return "";
    }
}
