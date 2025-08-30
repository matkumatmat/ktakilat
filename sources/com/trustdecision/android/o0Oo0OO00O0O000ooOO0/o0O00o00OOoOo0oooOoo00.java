package com.trustdecision.android.o0Oo0OO00O0O000ooOO0;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import org.apache.commons.lang3.CharEncoding;

class o0O00o00OOoOo0oooOoo00 implements HostnameVerifier {
    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 110);
            byte b2 = (byte) (bArr[0] ^ 6);
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

    public boolean verify(String str, SSLSession sSLSession) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.endsWith(o0Oo0OO00O0O000ooOO0("284908121a10020853531802", 125)) && !str.endsWith(o0Oo0OO00O0O000ooOO0("282d737b7f7228226973", 12)) && !str.endsWith(o0Oo0OO00O0O000ooOO0("280849535b514349121f5f", 60))) {
            return false;
        }
        String peerHost = sSLSession.getPeerHost();
        return peerHost.endsWith(o0Oo0OO00O0O000ooOO0("282869737b71636932327963", 28)) || peerHost.endsWith(o0Oo0OO00O0O000ooOO0("28376961656832387369", 22)) || str.endsWith(o0Oo0OO00O0O000ooOO0("285918020a001218434e0e", 109));
    }
}
