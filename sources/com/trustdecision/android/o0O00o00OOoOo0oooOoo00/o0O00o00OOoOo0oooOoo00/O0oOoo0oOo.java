package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.trustdecision.android.shell.inter.InvokeHandler;

class O0oOoo0oOo implements InvokeHandler {
    final /* synthetic */ Context o0Oo0OO00O0O000ooOO0;

    public O0oOoo0oOo(Context context) {
        this.o0Oo0OO00O0O000ooOO0 = context;
    }

    /* renamed from: o0Oo0OO00O0O000ooOO0 */
    public PackageInfo invoke() {
        try {
            return this.o0Oo0OO00O0O000ooOO0.getApplicationContext().getPackageManager().getPackageInfo(this.o0Oo0OO00O0O000ooOO0.getPackageName(), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
