package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import com.google.common.base.Ascii;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00;
import org.apache.commons.lang3.CharEncoding;

public class oOOO00oO00o0oOoOo extends o0O00o00OOoOo0oooOoo00 {
    private o0Oo0OO00O0O000ooOO0 oO00o0OooO0OO0o0000o;

    public oOOO00oO00o0oOoOo(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
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
            byte b = (byte) (i ^ 11);
            byte b2 = (byte) (bArr[0] ^ Ascii.DLE);
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
        return o0Oo0OO00O0O000ooOO0("432f31233b2634", 54);
    }

    public boolean OoOOooOoooOoo() {
        return this.oO00o0OooO0OO0o0000o != null;
    }

    @Nullable
    public String o00ooooooO00OO0O00() {
        o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0 = this.oO00o0OooO0OO0o0000o;
        if (o0oo0oo00o0o000oooo0 == null) {
            return null;
        }
        try {
            return o0oo0oo00o0o000oooo0.b();
        } catch (Throwable unused) {
            o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("56103f323e3673632c787035266378393f3a7371232a357a64212033283d31", 60));
            return null;
        }
    }

    public Intent oO00o0OooO0OO0o0000o() {
        Intent intent = new Intent();
        intent.setClassName(o0Oo0OO00O0O000ooOO0("73131d5c420d1301190416565010150902191255551e0c00151913120809081b001519", 20), o0Oo0OO00O0O000ooOO0("733937766827392b332e3c7c7a3a3f232833387f7f34262a3f333938222322312a3f337e5f14262a3f331918020322312a3f33", 62));
        return intent;
    }

    public void o0Oo0OO00O0O000ooOO0(ComponentName componentName, IBinder iBinder) {
        this.oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0.C0002o0Oo0OO00O0O000ooOO0.a(iBinder);
        this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(this);
    }
}
