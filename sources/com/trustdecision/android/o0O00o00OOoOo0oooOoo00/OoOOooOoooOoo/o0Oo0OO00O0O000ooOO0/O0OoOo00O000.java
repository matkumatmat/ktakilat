package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0;

import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class O0OoOo00O000 extends oO00o0OooO0OO0o0000o.O00OO0oOOooooO00000Oo {
    public O0OoOo00O000(o00ooooooO00OO0O00 o00ooooooo00oo0o00, oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00, int i) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(o0o00o00ooooo0oooooo00.o0Oo0OO00O0O000ooOO0 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.o0Oo0OO00O0O000ooOO0 = o00ooooooo00oo0o00.oO00o0OooO0OO0o0000o(allocate, (((long) i) * ((long) o0o00o00ooooo0oooooo00.OO0000O0Ooo0OO000oo)) + o0o00o00ooooo0oooooo00.O00OO0oOOooooO00000Oo + 28);
    }
}
