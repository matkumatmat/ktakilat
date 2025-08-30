package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.lang3.CharEncoding;

public class oO0oOOOOoo extends o0Oo0OO00O0O000ooOO0 {
    private static final Uri oO00o0OooO0OO0o0000o = Uri.parse(o0Oo0OO00O0O000ooOO0("59020f141f0514401b0e42034e4e151905064149030f05141313035848030f0514131303", 34));
    private boolean O00OO0oOOooooO00000Oo;

    public oO0oOOOOoo(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
        super(context, o00ooooooo00oo0o00);
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
            byte b = (byte) (i ^ 44);
            byte b2 = (byte) (bArr[0] ^ 58);
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

    private boolean oO00o0OooO0OO0o0000o() {
        String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("5362585e7d7867657e", 84);
        String o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("5343595f5c5946445f", 117);
        try {
            int i = Build.VERSION.SDK_INT;
            ContentProviderClient acquireUnstableContentProviderClient = this.o0Oo0OO00O0O000ooOO0.getContentResolver().acquireUnstableContentProviderClient(oO00o0OooO0OO0o0000o);
            Bundle bundle = null;
            if (acquireUnstableContentProviderClient != null) {
                bundle = acquireUnstableContentProviderClient.call(o0Oo0OO00O0O000ooOO0, (String) null, (Bundle) null);
                if (i >= 24) {
                    acquireUnstableContentProviderClient.release();
                } else {
                    acquireUnstableContentProviderClient.release();
                }
            }
            if (bundle == null || bundle.getInt(o0Oo0OO00O0O000ooOO0("5901060c", 33), -1) != 0) {
                return false;
            }
            return bundle.getBoolean(o0Oo0OO00O0O000ooOO02, true);
        } catch (Exception e) {
            o0Oo0OO00O0O000ooOO0(e);
            return false;
        }
    }

    public String OO0000O0Ooo0OO000oo() {
        return o0Oo0OO00O0O000ooOO0("74303c2023", 7);
    }

    public boolean OoOOooOoooOoo() {
        return oO00o0OooO0OO0o0000o();
    }

    @Nullable
    public String o00ooooooO00OO0O00() {
        if (!this.O00OO0oOOooooO00000Oo) {
            return null;
        }
        return o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("5d1d0e24111712", 51), o0Oo0OO00O0O000ooOO0("5357", 118), (String) null);
    }

    private String o0Oo0OO00O0O000ooOO0(String str, String str2, String str3) {
        Bundle bundle;
        try {
            int i = Build.VERSION.SDK_INT;
            ContentProviderClient acquireUnstableContentProviderClient = this.o0Oo0OO00O0O000ooOO0.getContentResolver().acquireUnstableContentProviderClient(oO00o0OooO0OO0o0000o);
            if (acquireUnstableContentProviderClient != null) {
                bundle = acquireUnstableContentProviderClient.call(str, str3, (Bundle) null);
                if (i >= 24) {
                    acquireUnstableContentProviderClient.release();
                } else {
                    acquireUnstableContentProviderClient.release();
                }
            } else {
                bundle = null;
            }
            if (bundle != null && bundle.getInt(o0Oo0OO00O0O000ooOO0("59151218", 53), -1) == 0) {
                return bundle.getString(str2);
            }
        } catch (Exception e) {
            o0Oo0OO00O0O000ooOO0(e);
        }
        return null;
    }

    public void o0Oo0OO00O0O000ooOO0(ThreadPoolExecutor threadPoolExecutor) {
        this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(this);
    }
}
