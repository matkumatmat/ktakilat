package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo;

public class o0O00o00OOoOo0oooOoo00 {
    private static volatile o0O00o00OOoOo0oooOoo00 O0oOO0ooO;
    private volatile int O00OO0oOOooooO00000Oo;
    private final Object o0O00o00OOoOo0oooOoo00 = new Object();
    private final Object o0Oo0OO00O0O000ooOO0 = new Object();
    private byte[] oO00o0OooO0OO0o0000o;

    private o0O00o00OOoOo0oooOoo00() {
    }

    public static o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO0() {
        if (O0oOO0ooO == null) {
            synchronized (o0O00o00OOoOo0oooOoo00.class) {
                try {
                    if (O0oOO0ooO == null) {
                        O0oOO0ooO = new o0O00o00OOoOo0oooOoo00();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return O0oOO0ooO;
    }

    public byte[] O00OO0oOOooooO00000Oo() {
        byte[] bArr;
        synchronized (this.o0Oo0OO00O0O000ooOO0) {
            bArr = this.oO00o0OooO0OO0o0000o;
        }
        return bArr;
    }

    public void O0oOO0ooO() {
        synchronized (this.o0Oo0OO00O0O000ooOO0) {
            this.oO00o0OooO0OO0o0000o = null;
        }
        synchronized (this.o0O00o00OOoOo0oooOoo00) {
            this.O00OO0oOOooooO00000Oo = 0;
        }
    }

    public boolean o0O00o00OOoOo0oooOoo00() {
        boolean z;
        synchronized (this.o0O00o00OOoOo0oooOoo00) {
            z = this.O00OO0oOOooooO00000Oo == 0;
        }
        return z;
    }

    public boolean oO00o0OooO0OO0o0000o() {
        boolean z;
        synchronized (this.o0O00o00OOoOo0oooOoo00) {
            z = this.O00OO0oOOooooO00000Oo == 2;
        }
        return z;
    }

    public void o0Oo0OO00O0O000ooOO0(int i) {
        synchronized (this.o0O00o00OOoOo0oooOoo00) {
            this.O00OO0oOOooooO00000Oo = i;
        }
    }

    public boolean o0Oo0OO00O0O000ooOO0(int i, int i2) {
        boolean z;
        synchronized (this.o0O00o00OOoOo0oooOoo00) {
            try {
                z = this.O00OO0oOOooooO00000Oo == i;
                if (z) {
                    this.O00OO0oOOooooO00000Oo = i2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
