package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00;
import org.apache.commons.lang3.CharEncoding;

public class OoOOooOoooOoo extends o0O00o00OOoOo0oooOoo00 {
    private static o0Oo0OO00O0O000ooOO0 oO00o0OooO0OO0o0000o;

    public OoOOooOoooOoo(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
        super(context, o00ooooooo00oo0o00);
    }

    private String O0OoOo00O000() {
        return com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("35401c1f54565c44441c1f475b03054e4a5c475b5c", 112));
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
            byte b = (byte) (i ^ 45);
            byte b2 = (byte) (bArr[0] ^ 71);
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

    public String OO0000O0Ooo0OO000oo() {
        return o0Oo0OO00O0O000ooOO0("0b7072786060", 84);
    }

    public boolean OoOOooOoooOoo() {
        o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0 = oO00o0OooO0OO0o0000o;
        if (o0oo0oo00o0o000oooo0 == null) {
            return false;
        }
        try {
            return o0oo0oo00o0o000oooo0.oO00o0OooO0OO0o0000o();
        } catch (Throwable unused) {
            return false;
        }
    }

    public String o00ooooooO00OO0O00() {
        o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0 = oO00o0OooO0OO0o0000o;
        if (o0oo0oo00o0o000oooo0 == null) {
            return null;
        }
        try {
            return o0oo0oo00o0o000oooo0.o0Oo0OO00O0O000ooOO0();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public String o0O00o00OOoOo0oooOoo00() {
        return O0OoOo00O000();
    }

    public Intent oO00o0OooO0OO0o0000o() {
        try {
            Intent intent = new Intent();
            intent.setClassName(o0Oo0OO00O0O000ooOO0("24414f0e1942510a074c5e52474b41405a5b5a4952474b", 96), o0Oo0OO00O0O000ooOO0("24383677603b28737e35272b3e323839232223302b3e327f5e15272b3e323839030223302b3e32", 25));
            return intent;
        } catch (Exception unused) {
            return null;
        }
    }

    public void o0Oo0OO00O0O000ooOO0(ComponentName componentName, IBinder iBinder) {
        oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0.C0004o0Oo0OO00O0O000ooOO0.a(iBinder);
        this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(this);
    }
}
