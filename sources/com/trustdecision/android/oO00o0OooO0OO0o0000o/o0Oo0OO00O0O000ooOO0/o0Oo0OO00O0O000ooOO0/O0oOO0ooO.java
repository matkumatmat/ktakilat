package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OoOOooOoooOoo;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00;
import org.apache.commons.lang3.CharEncoding;

public class O0oOO0ooO extends o0O00o00OOoOo0oooOoo00 {
    private static final char[] O0oOO0ooO = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] o00ooooooO00OO0O00 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("077a63616e77", 105);
    private o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo;

    public O0oOO0ooO(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
        super(context, o00ooooooo00oo0o00);
    }

    private o0Oo0OO00O0O000ooOO0 O0OoOo00O000() {
        return this.O00OO0oOOooooO00000Oo;
    }

    private String O0o0o0O0OOOooOo0OOoOOO() {
        return OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("22613d306b60797436246f6b7d667a7d3c37746460", 113));
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
            byte b = (byte) (i ^ 13);
            byte b2 = (byte) (bArr[0] ^ 80);
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
        return o0Oo0OO00O0O000ooOO0("182a2321253b", 58);
    }

    public boolean OoOOooOoooOoo() {
        return !TextUtils.isEmpty(o00ooooooO00OO0O00());
    }

    public String o00ooooooO00OO0O00() {
        try {
            o0Oo0OO00O0O000ooOO0 O0OoOo00O000 = O0OoOo00O000();
            if (O0OoOo00O000 != null) {
                return O0OoOo00O000.b();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public String o0O00o00OOoOo0oooOoo00() {
        return O0o0o0O0OOOooOo0OOoOOO();
    }

    public Intent oO00o0OooO0OO0o0000o() {
        Intent intent = new Intent(o0Oo0OO00O0O000ooOO0("33727c3d2564757364233f616b75747f6d617478351f616b75797369727268697a617478", 115));
        intent.setPackage(o0Oo0OO00O0O000ooOO0("334d4302075c5557534d06075e5f4c", 76));
        return intent;
    }

    public void o0Oo0OO00O0O000ooOO0(ComponentName componentName, IBinder iBinder) {
        this.O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0.C0006o0Oo0OO00O0O000ooOO0.a(iBinder);
        this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(this);
    }
}
