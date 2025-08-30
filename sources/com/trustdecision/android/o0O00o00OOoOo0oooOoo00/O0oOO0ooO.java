package com.trustdecision.android.o0O00o00OOoOo0oooOoo00;

import android.os.SystemClock;
import android.text.TextUtils;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.shell.TDOption;
import com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0;
import org.apache.commons.lang3.CharEncoding;

class O0oOO0ooO implements Runnable {
    final /* synthetic */ o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo;
    final /* synthetic */ o0Oo0OO00O0O000ooOO0 o0O00o00OOoOo0oooOoo00;
    final /* synthetic */ o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO0;
    final /* synthetic */ TDOption oO00o0OooO0OO0o0000o;

    public O0oOO0ooO(o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0, o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00, o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo02, TDOption tDOption) {
        this.O00OO0oOOooooO00000Oo = o0oo0oo00o0o000oooo0;
        this.o0Oo0OO00O0O000ooOO0 = o0o00o00ooooo0oooooo00;
        this.o0O00o00OOoOo0oooOoo00 = o0oo0oo00o0o000oooo02;
        this.oO00o0OooO0OO0o0000o = tDOption;
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
            byte b2 = (byte) (bArr[0] ^ 5);
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

    public void run() {
        o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o;
        String message;
        try {
            boolean unused = this.O00OO0oOOooooO00000Oo.o0Oo0O0o0ooOOo0oO0 = true;
            long unused2 = this.O00OO0oOOooooO00000Oo.o0ooOoo0Oo00oOOO = SystemClock.elapsedRealtime();
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0);
            this.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o();
            oOO0OooO0 unused3 = this.O00OO0oOOooooO00000Oo.OO0000O0Ooo0OO000oo = oOO0OooO0.o0Oo0OO00O0O000ooOO0(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(), this.o0O00o00OOoOo0oooOoo00);
            String domain = TextUtils.isEmpty(this.oO00o0OooO0OO0o0000o.getDomain()) ? this.o0O00o00OOoOo0oooOoo00.oO0OOO00 : this.oO00o0OooO0OO0o0000o.getDomain();
            if (this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.equals(o0Oo0OO00O0O000ooOO0("76190b19", 10))) {
                this.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(domain);
            }
            this.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0());
            o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0 = this.O00OO0oOOooooO00000Oo;
            o0oo0oo00o0o000oooo0.O0oOO0ooO = this.oO00o0OooO0OO0o0000o;
            o0oo0oo00o0o000oooo0.o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("695f5259515b55", 93);
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O0oOO0ooO, o0Oo0OO00O0O000ooOO0("51013a7569213d273c6e733d202b2d3e2d3776783d2b39283a3174733d3d276e7b35307e753b1109293120", 59));
            this.O00OO0oOOooooO00000Oo.oO00o0OooO0OO0o0000o(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0());
            oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("51097d4a0e1652501e1e044d4a1f0f191f0f19", 24));
            if (this.O00OO0oOOooooO00000Oo.O0o0o0O0ooOooOoo != null) {
                this.O00OO0oOOooooO00000Oo.O0o0o0O0ooOooOoo.countDown();
            }
        } catch (Throwable th) {
            boolean unused4 = this.O00OO0oOOooooO00000Oo.o0Oo0O0o0ooOOo0oO0 = false;
            throw th;
        }
        boolean unused5 = this.O00OO0oOOooooO00000Oo.o0Oo0O0o0ooOOo0oO0 = false;
    }
}
