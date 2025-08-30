package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OoOOooOoooOoo;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.OO0000O0Ooo0OO000oo;
import java.security.MessageDigest;
import org.apache.commons.lang3.CharEncoding;

public class O0o0o0O0ooOooOoo extends o0O00o00OOoOo0oooOoo00 {
    /* access modifiers changed from: private */
    public static String O00OO0oOOooooO00000Oo = "";
    private static String O0oOO0ooO;
    private static OO0000O0Ooo0OO000oo oO00o0OooO0OO0o0000o;

    public O0o0o0O0ooOooOoo(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
        super(context, o00ooooooo00oo0o00);
    }

    private String O0o0o0O0OOOooOo0OOoOOO() {
        return OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("513965683338212c6e7c3733253e222564653b243b393926", 38));
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String o0Oo0OO00O0O000ooOO0(Context context, String str) {
        Signature[] signatureArr;
        try {
            if (TextUtils.isEmpty(O00OO0oOOooooO00000Oo)) {
                O00OO0oOOooooO00000Oo = context.getPackageName();
            }
            if (TextUtils.isEmpty(O0oOO0ooO) && (signatureArr = ((PackageInfo) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00.O00OO0oOOooooO00000Oo(com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00.O0oOO0ooO[1], new Oo0O0Oo0OO0OOOoOO0O0(context))).signatures) != null && signatureArr.length > 0) {
                byte[] digest = MessageDigest.getInstance(o0Oo0OO00O0O000ooOO0("7045572e", 92)).digest(signatureArr[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & UnsignedBytes.MAX_VALUE) | Ascii.NUL).substring(1, 3));
                }
                O0oOO0ooO = sb.toString();
            }
            String o0Oo0OO00O0O000ooOO0 = ((OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0.C0022o0Oo0OO00O0O000ooOO0) oO00o0OooO0OO0o0000o).o0Oo0OO00O0O000ooOO0(O00OO0oOOooooO00000Oo, O0oOO0ooO, str);
            if (TextUtils.isEmpty(o0Oo0OO00O0O000ooOO0)) {
                return null;
            }
            return o0Oo0OO00O0O000ooOO0;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String OO0000O0Ooo0OO000oo() {
        return o0Oo0OO00O0O000ooOO0("6c1708176a760f180505", 10);
    }

    public boolean OoOOooOoooOoo() {
        return !TextUtils.isEmpty(o00ooooooO00OO0O00());
    }

    public String o00ooooooO00OO0O00() {
        return o0O00o00OOoOo0oooOoo00(this.o0Oo0OO00O0O000ooOO0, o0Oo0OO00O0O000ooOO0("6c101607", 8));
    }

    @Nullable
    public String o0O00o00OOoOo0oooOoo00() {
        return O0o0o0O0OOOooOo0OOoOOO();
    }

    public Intent oO00o0OooO0OO0o0000o() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(o0Oo0OO00O0O000ooOO0("40474908064748485656571608455b", 73), o0Oo0OO00O0O000ooOO0("40525c1d1f414247580303594e53531439735f55444351417468495a415458", 92)));
        intent.setAction(o0Oo0OO00O0O000ooOO0("4204111b0007464b0a044547191a1f005b5b01160b0b4c610b1d0a101102190c00", 4));
        return intent;
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
            byte b = (byte) (i ^ 2);
            byte b2 = (byte) (bArr[0] ^ 35);
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

    public String o0O00o00OOoOo0oooOoo00(Context context, String str) {
        if (oO00o0OooO0OO0o0000o == null) {
            return null;
        }
        return o0Oo0OO00O0O000ooOO0(context, str);
    }

    public void o0Oo0OO00O0O000ooOO0(ComponentName componentName, IBinder iBinder) {
        oO00o0OooO0OO0o0000o = OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(iBinder);
        this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(this);
    }
}
