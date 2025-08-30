package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import org.apache.commons.lang3.CharEncoding;

public class o0Oo0O0o0ooOOo0oO0 {
    public static boolean o0O00o00OOoOo0oooOoo00(Context context) {
        return o0Oo0OO00O0O000ooOO0(context) != 0;
    }

    public static int o0Oo0OO00O0O000ooOO0(Context context) {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService(o0Oo0OO00O0O000ooOO0("44565b5a515c4d4745454757", 0))) == null) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Network k = connectivityManager.getActiveNetwork();
                if (k == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(k)) == null) {
                    return 0;
                }
                if (networkCapabilities.hasTransport(0)) {
                    return 2;
                }
                if (networkCapabilities.hasTransport(1)) {
                    return 1;
                }
                if (networkCapabilities.hasTransport(3)) {
                    return 3;
                }
                if (networkCapabilities.hasTransport(4)) {
                    return 4;
                }
                networkCapabilities.getTransportInfo();
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.getType() == 1) {
                        return 1;
                    }
                    if (activeNetworkInfo.getType() == 0) {
                        return 2;
                    }
                    if (activeNetworkInfo.getType() == 9) {
                        return 3;
                    }
                    if (activeNetworkInfo.getType() == 17) {
                        return 4;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return 0;
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
            byte b = (byte) (i ^ 90);
            byte b2 = (byte) (bArr[0] ^ 39);
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
}
