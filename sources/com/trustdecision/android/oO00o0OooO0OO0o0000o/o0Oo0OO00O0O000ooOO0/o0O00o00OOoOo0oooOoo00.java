package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class o0O00o00OOoOo0oooOoo00 extends o0Oo0OO00O0O000ooOO0 {
    private ThreadPoolExecutor O00OO0oOOooooO00000Oo = null;
    private ServiceConnection oO00o0OooO0OO0o0000o;

    public o0O00o00OOoOo0oooOoo00(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
        super(context, o00ooooooo00oo0o00);
    }

    /* access modifiers changed from: private */
    public void O0OoOo00O000() {
        o00ooooooO00OO0O00 o00ooooooo00oo0o00 = this.o0O00o00OOoOo0oooOoo00;
        if (o00ooooooo00oo0o00 != null) {
            o00ooooooo00oo0o00.o0Oo0OO00O0O000ooOO0(this);
        }
    }

    public ServiceConnection O00OO0oOOooooO00000Oo() {
        return new oO00o0OooO0OO0o0000o(this);
    }

    public void O0oOO0ooO() {
        try {
            Intent oO00o0OooO0OO0o0000o2 = oO00o0OooO0OO0o0000o();
            ServiceConnection O00OO0oOOooooO00000Oo2 = O00OO0oOOooooO00000Oo();
            this.oO00o0OooO0OO0o0000o = O00OO0oOOooooO00000Oo2;
            if (!this.o0Oo0OO00O0O000ooOO0.bindService(oO00o0OooO0OO0o0000o2, O00OO0oOOooooO00000Oo2, 1)) {
                O0OoOo00O000();
            }
        } catch (Throwable unused) {
        }
    }

    public abstract void o0Oo0OO00O0O000ooOO0(ComponentName componentName, IBinder iBinder);

    public abstract Intent oO00o0OooO0OO0o0000o();

    /* access modifiers changed from: private */
    public void o0Oo0OO00O0O000ooOO0(Runnable runnable) {
        if (this.O00OO0oOOooooO00000Oo == null) {
            this.O00OO0oOOooooO00000Oo = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors());
        }
        this.O00OO0oOOooooO00000Oo.submit(runnable);
    }

    public void o0Oo0OO00O0O000ooOO0(ThreadPoolExecutor threadPoolExecutor) {
        this.O00OO0oOOooooO00000Oo = threadPoolExecutor;
        O0oOO0ooO();
    }
}
