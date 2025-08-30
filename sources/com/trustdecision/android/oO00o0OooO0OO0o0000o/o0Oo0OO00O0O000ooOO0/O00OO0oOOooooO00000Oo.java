package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;

import android.content.ComponentName;
import android.os.IBinder;

class O00OO0oOOooooO00000Oo implements Runnable {
    final /* synthetic */ IBinder o0O00o00OOoOo0oooOoo00;
    final /* synthetic */ ComponentName o0Oo0OO00O0O000ooOO0;
    final /* synthetic */ oO00o0OooO0OO0o0000o oO00o0OooO0OO0o0000o;

    public O00OO0oOOooooO00000Oo(oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o, ComponentName componentName, IBinder iBinder) {
        this.oO00o0OooO0OO0o0000o = oo00o0oooo0oo0o0000o;
        this.o0Oo0OO00O0O000ooOO0 = componentName;
        this.o0O00o00OOoOo0oooOoo00 = iBinder;
    }

    public void run() {
        try {
            this.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(this.o0Oo0OO00O0O000ooOO0, this.o0O00o00OOoOo0oooOoo00);
        } catch (Throwable unused) {
            o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00 = this.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;
            if (o0o00o00ooooo0oooooo00.o0O00o00OOoOo0oooOoo00 != null) {
                o0o00o00ooooo0oooooo00.O0OoOo00O000();
            }
        }
    }
}
