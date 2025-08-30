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
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00;
import java.security.MessageDigest;
import org.apache.commons.lang3.CharEncoding;

public class o0ooOoo0Oo00oOOO extends o0O00o00OOoOo0oooOoo00 {
    /* access modifiers changed from: private */
    public static String O00OO0oOOooooO00000Oo = "";
    private static String O0oOO0ooO;
    private static o00ooooooO00OO0O00 oO00o0OooO0OO0o0000o;

    public o0ooOoo0Oo00oOOO(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
        super(context, o00ooooooo00oo0o00);
    }

    private String O0o0o0O0OOOooOo0OOoOOO() {
        return OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("7f015d500b00191456440f0b1d061a1d5c5d031c0301011e", 29));
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String o0Oo0OO00O0O000ooOO0(Context context, String str) {
        Signature[] signatureArr;
        try {
            if (TextUtils.isEmpty(O00OO0oOOooooO00000Oo)) {
                O00OO0oOOooooO00000Oo = context.getPackageName();
            }
            if (TextUtils.isEmpty(O0oOO0ooO) && (signatureArr = ((PackageInfo) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00.O00OO0oOOooooO00000Oo(com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00.O0oOO0ooO[1], new o0oOO0oO00OoO0(context))).signatures) != null && signatureArr.length > 0) {
                byte[] digest = MessageDigest.getInstance(o0Oo0OO00O0O000ooOO0("5e4a5821", 80)).digest(signatureArr[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & UnsignedBytes.MAX_VALUE) | Ascii.NUL).substring(1, 3));
                }
                O0oOO0ooO = sb.toString();
            }
            String o0Oo0OO00O0O000ooOO0 = ((o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.C0023o0Oo0OO00O0O000ooOO0) oO00o0OooO0OO0o0000o).o0Oo0OO00O0O000ooOO0(O00OO0oOOooooO00000Oo, O0oOO0ooO, str);
            if (TextUtils.isEmpty(o0Oo0OO00O0O000ooOO0)) {
                return null;
            }
            return o0Oo0OO00O0O000ooOO0;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String OO0000O0Ooo0OO000oo() {
        return o0Oo0OO00O0O000ooOO0("42534c53", 77);
    }

    public boolean OoOOooOoooOoo() {
        return !TextUtils.isEmpty(o00ooooooO00OO0O00());
    }

    public String o00ooooooO00OO0O00() {
        return o0O00o00OOoOo0oooOoo00(this.o0Oo0OO00O0O000ooOO0, o0Oo0OO00O0O000ooOO0("42757362", 110));
    }

    @Nullable
    public String o0O00o00OOoOo0oooOoo00() {
        return O0o0o0O0OOOooOo0OOoOOO();
    }

    public Intent oO00o0OooO0OO0o0000o() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(o0Oo0OO00O0O000ooOO0("6e0709484d0617061e1a554a141e000c06", 10), o0Oo0OO00O0O000ooOO0("6e010f4e4b001100181c534c1218060a00476a200c0617100212273b1a0912070b", 12)));
        intent.setAction(o0Oo0OO00O0O000ooOO0("6c0a1f150e094845040a4b4e0514051d195649171d030f054269171d03191e0513041e1f0c17020e", 9));
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
            byte b = (byte) (i ^ 1);
            byte b2 = (byte) (bArr[0] ^ Ascii.CR);
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
        oO00o0OooO0OO0o0000o = o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(iBinder);
        this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(this);
    }
}
