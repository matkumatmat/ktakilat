package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0;

import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class o0O00o00OOoOo0oooOoo00 extends oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0 {
    public o0O00o00OOoOo0oooOoo00(o00ooooooO00OO0O00 o00ooooooo00oo0o00, oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00, long j, int i) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(o0o00o00ooooo0oooooo00.o0Oo0OO00O0O000ooOO0 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = (((long) i) * 16) + j;
        this.o0Oo0OO00O0O000ooOO0 = o00ooooooo00oo0o00.o0O00o00OOoOo0oooOoo00(allocate, j2);
        this.o0O00o00OOoOo0oooOoo00 = o00ooooooo00oo0o00.o0O00o00OOoOo0oooOoo00(allocate, j2 + 8);
    }
}
