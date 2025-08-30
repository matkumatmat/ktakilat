package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0;

import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class OoOOooOoooOoo extends oO00o0OooO0OO0o0000o.C0018oO00o0OooO0OO0o0000o {
    public OoOOooOoooOoo(o00ooooooO00OO0O00 o00ooooooo00oo0o00, oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00, long j) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(o0o00o00ooooo0oooooo00.o0Oo0OO00O0O000ooOO0 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = (j * ((long) o0o00o00ooooo0oooooo00.O0oOO0ooO)) + o0o00o00ooooo0oooooo00.oO00o0OooO0OO0o0000o;
        this.o0Oo0OO00O0O000ooOO0 = o00ooooooo00oo0o00.oO00o0OooO0OO0o0000o(allocate, j2);
        this.o0O00o00OOoOo0oooOoo00 = o00ooooooo00oo0o00.o0O00o00OOoOo0oooOoo00(allocate, 8 + j2);
        this.oO00o0OooO0OO0o0000o = o00ooooooo00oo0o00.o0O00o00OOoOo0oooOoo00(allocate, 16 + j2);
        this.O00OO0oOOooooO00000Oo = o00ooooooo00oo0o00.o0O00o00OOoOo0oooOoo00(allocate, j2 + 40);
    }
}
