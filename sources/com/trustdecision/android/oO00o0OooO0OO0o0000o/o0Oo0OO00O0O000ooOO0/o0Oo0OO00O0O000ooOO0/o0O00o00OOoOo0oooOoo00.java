package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00;
import org.apache.commons.lang3.CharEncoding;

public class o0O00o00OOoOo0oooOoo00 extends com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00 {
    private Context O00OO0oOOooooO00000Oo;
    private o0Oo0OO00O0O000ooOO0 oO00o0OooO0OO0o0000o;

    public o0O00o00OOoOo0oooOoo00(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
        super(context, o00ooooooo00oo0o00);
        this.O00OO0oOOooooO00000Oo = context;
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
            byte b = (byte) (i ^ 100);
            byte b2 = (byte) (bArr[0] ^ 73);
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
        return o0Oo0OO00O0O000ooOO0("0a507c7f606d79", 24);
    }

    public boolean OoOOooOoooOoo() {
        return !TextUtils.isEmpty(o00ooooooO00OO0O00());
    }

    @Nullable
    public String o00ooooooO00OO0O00() {
        Context context;
        o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0 = this.oO00o0OooO0OO0o0000o;
        if (o0oo0oo00o0o000oooo0 == null || (context = this.O00OO0oOOooooO00000Oo) == null) {
            return null;
        }
        try {
            return o0oo0oo00o0o000oooo0.o0O00o00OOoOo0oooOoo00(context.getPackageName());
        } catch (Throwable unused) {
            return null;
        }
    }

    public Intent oO00o0OooO0OO0o0000o() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(o0Oo0OO00O0O000ooOO0("2a222c6d63222e2d323f2b64642f3d312428222339282b2e313328", 74), o0Oo0OO00O0O000ooOO0("2a5c52131d5c50534c41551a1a51434f5a565c5d475655504f4d560a3a71434f5a567c7d676647544f5a56", 52)));
        return intent;
    }

    public void o0Oo0OO00O0O000ooOO0(ComponentName componentName, IBinder iBinder) {
        this.oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0.C0000o0Oo0OO00O0O000ooOO0.a(iBinder);
        this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(this);
    }
}
