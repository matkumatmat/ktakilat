package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo;

import java.io.File;
import java.io.FilenameFilter;

class o00ooooooO00OO0O00 implements FilenameFilter {
    final /* synthetic */ O00OO0oOOooooO00000Oo o0O00o00OOoOo0oooOoo00;
    final /* synthetic */ String o0Oo0OO00O0O000ooOO0;

    public o00ooooooO00OO0O00(O00OO0oOOooooO00000Oo o00OO0oOOooooO00000Oo, String str) {
        this.o0O00o00OOoOo0oooOoo00 = o00OO0oOOooooO00000Oo;
        this.o0Oo0OO00O0O000ooOO0 = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.o0Oo0OO00O0O000ooOO0);
    }
}
