package com.trustdecision.android.oO00o0OooO0OO0o0000o;

import java.util.ArrayList;
import java.util.List;

public class O00OO0oOOooooO00000Oo {
    private boolean o0O00o00OOoOo0oooOoo00 = false;
    private List o0Oo0OO00O0O000ooOO0 = new ArrayList();

    public boolean o0O00o00OOoOo0oooOoo00() {
        return this.o0O00o00OOoOo0oooOoo00;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        r1 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject o0Oo0OO00O0O000ooOO0() {
        /*
            r4 = this;
            java.util.List r0 = r4.o0Oo0OO00O0O000ooOO0
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            java.util.List r0 = r4.o0Oo0OO00O0O000ooOO0
            java.util.Iterator r0 = r0.iterator()
        L_0x0010:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r0.next()
            com.trustdecision.android.oO00o0OooO0OO0o0000o.O0oOO0ooO r2 = (com.trustdecision.android.oO00o0OooO0OO0o0000o.O0oOO0ooO) r2
            if (r2 == 0) goto L_0x0010
            boolean r3 = r4.o0O00o00OOoOo0oooOoo00()
            if (r3 == 0) goto L_0x0029
            java.lang.String r3 = r2.o0Oo0OO00O0O000ooOO0
            if (r3 == 0) goto L_0x0029
            goto L_0x0033
        L_0x0029:
            boolean r3 = r4.o0O00o00OOoOo0oooOoo00()
            if (r3 != 0) goto L_0x0010
            java.lang.String r3 = r2.O00OO0oOOooooO00000Oo
            if (r3 == 0) goto L_0x0010
        L_0x0033:
            r1 = r2
        L_0x0034:
            if (r1 == 0) goto L_0x003b
            org.json.JSONObject r0 = r1.oO00o0OooO0OO0o0000o()
            goto L_0x0040
        L_0x003b:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.oO00o0OooO0OO0o0000o.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0():org.json.JSONObject");
    }

    public void o0Oo0OO00O0O000ooOO0(O0oOO0ooO o0oOO0ooO) {
        if (o0oOO0ooO != null && !o0oOO0ooO.o0Oo0OO00O0O000ooOO0()) {
            if (o0oOO0ooO.o0O00o00OOoOo0oooOoo00()) {
                this.o0Oo0OO00O0O000ooOO0.add(0, o0oOO0ooO);
            } else {
                this.o0Oo0OO00O0O000ooOO0.add(o0oOO0ooO);
            }
            this.o0O00o00OOoOo0oooOoo00 = o0oOO0ooO.o0O00o00OOoOo0oooOoo00() | this.o0O00o00OOoOo0oooOoo00;
        }
    }
}
