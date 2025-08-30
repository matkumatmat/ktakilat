package com.trustdecision.android.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.trustdecision.android.shell.inter.InvokeHandler;

class OO0000O0Ooo0OO000oo implements InvokeHandler {
    final /* synthetic */ o0Oo0OO00O0O000ooOO0 o0O00o00OOoOo0oooOoo00;
    final /* synthetic */ Context o0Oo0OO00O0O000ooOO0;

    public OO0000O0Ooo0OO000oo(o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0, Context context) {
        this.o0O00o00OOoOo0oooOoo00 = o0oo0oo00o0o000oooo0;
        this.o0Oo0OO00O0O000ooOO0 = context;
    }

    /* renamed from: o0Oo0OO00O0O000ooOO0 */
    public PackageInfo invoke() {
        try {
            return this.o0Oo0OO00O0O000ooOO0.getPackageManager().getPackageInfo(this.o0Oo0OO00O0O000ooOO0.getPackageName(), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
