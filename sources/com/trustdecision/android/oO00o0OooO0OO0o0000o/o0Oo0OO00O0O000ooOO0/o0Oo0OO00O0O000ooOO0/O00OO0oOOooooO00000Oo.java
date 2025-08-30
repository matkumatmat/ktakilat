package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00;
import org.apache.commons.lang3.CharEncoding;

public class O00OO0oOOooooO00000Oo extends o0O00o00OOoOo0oooOoo00 {
    private o0Oo0OO00O0O000ooOO0 oO00o0OooO0OO0o0000o;

    public O00OO0oOOooooO00000Oo(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
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
            byte b = (byte) (i ^ 89);
            byte b2 = (byte) (bArr[0] ^ 115);
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
        return o0Oo0OO00O0O000ooOO0("356e4d5a5252", 3);
    }

    public boolean OoOOooOoooOoo() {
        o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0 = this.oO00o0OooO0OO0o0000o;
        if (o0oo0oo00o0o000oooo0 == null) {
            return false;
        }
        try {
            return o0oo0oo00o0o000oooo0.o0Oo0OO00O0O000ooOO0();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Nullable
    public String o00ooooooO00OO0O00() {
        o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0 = this.oO00o0OooO0OO0o0000o;
        if (o0oo0oo00o0o000oooo0 == null) {
            return null;
        }
        try {
            return o0oo0oo00o0o000oooo0.o0O00o00OOoOo0oooOoo00();
        } catch (Throwable unused) {
            return null;
        }
    }

    public Intent oO00o0OooO0OO0o0000o() {
        Intent intent = new Intent(o0Oo0OO00O0O000ooOO0("127f7a666d767d3a2d6667746f7a763b3f72676d767130336e62", 41));
        intent.setPackage(o0Oo0OO00O0O000ooOO0("105856171b5b5e424952591e19454350414f49", 13));
        return intent;
    }

    public void o0Oo0OO00O0O000ooOO0(ComponentName componentName, IBinder iBinder) {
        this.oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0.C0010o0Oo0OO00O0O000ooOO0.a(iBinder);
        this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(this);
    }
}
