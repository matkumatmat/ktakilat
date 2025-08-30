package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.trustdecision.android.shell.inter.InvokeHandler;

class Oo0O00OooOO00 implements InvokeHandler {
    final /* synthetic */ String o0O00o00OOoOo0oooOoo00;
    final /* synthetic */ Context o0Oo0OO00O0O000ooOO0;

    public Oo0O00OooOO00(Context context, String str) {
        this.o0Oo0OO00O0O000ooOO0 = context;
        this.o0O00o00OOoOo0oooOoo00 = str;
    }

    /* renamed from: o0Oo0OO00O0O000ooOO0 */
    public PackageInfo invoke() {
        try {
            return this.o0Oo0OO00O0O000ooOO0.getPackageManager().getPackageInfo(this.o0O00o00OOoOo0oooOoo00, 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
