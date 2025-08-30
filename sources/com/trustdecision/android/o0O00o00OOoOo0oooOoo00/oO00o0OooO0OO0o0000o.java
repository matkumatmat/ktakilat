package com.trustdecision.android.o0O00o00OOoOo0oooOoo00;

import com.trustdecision.android.shell.inter.FMCallback;

class oO00o0OooO0OO0o0000o implements Runnable {
    final /* synthetic */ String o0O00o00OOoOo0oooOoo00;
    final /* synthetic */ FMCallback o0Oo0OO00O0O000ooOO0;
    final /* synthetic */ o0Oo0OO00O0O000ooOO0 oO00o0OooO0OO0o0000o;

    public oO00o0OooO0OO0o0000o(o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0, FMCallback fMCallback, String str) {
        this.oO00o0OooO0OO0o0000o = o0oo0oo00o0o000oooo0;
        this.o0Oo0OO00O0O000ooOO0 = fMCallback;
        this.o0O00o00OOoOo0oooOoo00 = str;
    }

    public void run() {
        this.o0Oo0OO00O0O000ooOO0.onEvent(this.o0O00o00OOoOo0oooOoo00);
    }
}
