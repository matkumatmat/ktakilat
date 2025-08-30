package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.trustdecision.android.shell.inter.InvokeHandler;

class o0oOO0oO00OoO0 implements InvokeHandler {
    final /* synthetic */ Context o0Oo0OO00O0O000ooOO0;

    public o0oOO0oO00OoO0(Context context) {
        this.o0Oo0OO00O0O000ooOO0 = context;
    }

    /* renamed from: o0Oo0OO00O0O000ooOO0 */
    public PackageInfo invoke() {
        try {
            return this.o0Oo0OO00O0O000ooOO0.getPackageManager().getPackageInfo(o0ooOoo0Oo00oOOO.O00OO0oOOooooO00000Oo, 64);
        } catch (Exception unused) {
            return null;
        }
    }
}
