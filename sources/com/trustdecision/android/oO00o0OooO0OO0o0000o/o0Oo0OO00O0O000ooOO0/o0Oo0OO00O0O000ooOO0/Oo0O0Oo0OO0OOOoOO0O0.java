package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.trustdecision.android.shell.inter.InvokeHandler;

class Oo0O0Oo0OO0OOOoOO0O0 implements InvokeHandler {
    final /* synthetic */ Context o0Oo0OO00O0O000ooOO0;

    public Oo0O0Oo0OO0OOOoOO0O0(Context context) {
        this.o0Oo0OO00O0O000ooOO0 = context;
    }

    /* renamed from: o0Oo0OO00O0O000ooOO0 */
    public PackageInfo invoke() {
        try {
            return this.o0Oo0OO00O0O000ooOO0.getPackageManager().getPackageInfo(O0o0o0O0ooOooOoo.O00OO0oOOooooO00000Oo, 64);
        } catch (Exception unused) {
            return null;
        }
    }
}
