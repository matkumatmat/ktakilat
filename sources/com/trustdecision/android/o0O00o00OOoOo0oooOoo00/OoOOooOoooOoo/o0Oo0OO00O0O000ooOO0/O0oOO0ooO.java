package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0;

import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class O0oOO0ooO extends oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00 {
    private final o00ooooooO00OO0O00 O0o0o0O0OOOooOo0OOoOOO;

    public O0oOO0ooO(boolean z, o00ooooooO00OO0O00 o00ooooooo00oo0o00) throws IOException {
        this.o0Oo0OO00O0O000ooOO0 = z;
        this.O0o0o0O0OOOooOo0OOoOOO = o00ooooooo00oo0o00;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.o0O00o00OOoOo0oooOoo00 = o00ooooooo00oo0o00.O00OO0oOOooooO00000Oo(allocate, 16);
        this.oO00o0OooO0OO0o0000o = o00ooooooo00oo0o00.o0O00o00OOoOo0oooOoo00(allocate, 32);
        this.O00OO0oOOooooO00000Oo = o00ooooooo00oo0o00.o0O00o00OOoOo0oooOoo00(allocate, 40);
        this.O0oOO0ooO = o00ooooooo00oo0o00.O00OO0oOOooooO00000Oo(allocate, 54);
        this.o00ooooooO00OO0O00 = o00ooooooo00oo0o00.O00OO0oOOooooO00000Oo(allocate, 56);
        this.OO0000O0Ooo0OO000oo = o00ooooooo00oo0o00.O00OO0oOOooooO00000Oo(allocate, 58);
        this.OoOOooOoooOoo = o00ooooooo00oo0o00.O00OO0oOOooooO00000Oo(allocate, 60);
        this.O0OoOo00O000 = o00ooooooo00oo0o00.O00OO0oOOooooO00000Oo(allocate, 62);
    }

    public oO00o0OooO0OO0o0000o.O00OO0oOOooooO00000Oo o0Oo0OO00O0O000ooOO0(int i) throws IOException {
        return new O0o0o0O0OOOooOo0OOoOOO(this.O0o0o0O0OOOooOo0OOoOOO, this, i);
    }

    public oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO0(long j, int i) throws IOException {
        return new o0O00o00OOoOo0oooOoo00(this.O0o0o0O0OOOooOo0OOoOOO, this, j, i);
    }

    public oO00o0OooO0OO0o0000o.C0018oO00o0OooO0OO0o0000o o0Oo0OO00O0O000ooOO0(long j) throws IOException {
        return new OoOOooOoooOoo(this.O0o0o0O0OOOooOo0OOoOOO, this, j);
    }
}
