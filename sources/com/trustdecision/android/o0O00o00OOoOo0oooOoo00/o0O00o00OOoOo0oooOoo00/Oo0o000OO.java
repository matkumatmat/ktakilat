package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import java.util.Comparator;
import java.util.Map;

class Oo0o000OO implements Comparator {
    final /* synthetic */ Map o0Oo0OO00O0O000ooOO0;

    public Oo0o000OO(Map map) {
        this.o0Oo0OO00O0O000ooOO0 = map;
    }

    public int compare(Object obj, Object obj2) {
        if (((Integer) this.o0Oo0OO00O0O000ooOO0.get(obj)).intValue() < ((Integer) this.o0Oo0OO00O0O000ooOO0.get(obj2)).intValue()) {
            return 1;
        }
        return this.o0Oo0OO00O0O000ooOO0.get(obj) == this.o0Oo0OO00O0O000ooOO0.get(obj2) ? 0 : -1;
    }
}
