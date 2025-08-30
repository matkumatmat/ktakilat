package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class oO00o0OooO0OO0o0000o implements ServiceConnection {
    final /* synthetic */ o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO0;

    public oO00o0OooO0OO0o0000o(o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00) {
        this.o0Oo0OO00O0O000ooOO0 = o0o00o00ooooo0oooooo00;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((Runnable) new O00OO0oOOooooO00000Oo(this, componentName, iBinder));
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
