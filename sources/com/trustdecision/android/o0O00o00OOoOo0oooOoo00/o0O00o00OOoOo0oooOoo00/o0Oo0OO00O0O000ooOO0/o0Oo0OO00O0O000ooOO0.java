package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.CharEncoding;

public class o0Oo0OO00O0O000ooOO0 implements oO00o0OooO0OO0o0000o, Callable {
    private static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("40182a2a2c3c07163a230509262b262825221d0c2d383e3a2935", 58);
    private long O00OO0oOOooooO00000Oo;
    private final ThreadPoolExecutor O0oOO0ooO;
    /* access modifiers changed from: private */
    public String o00ooooooO00OO0O00;
    private oO00o0OooO0OO0o0000o o0O00o00OOoOo0oooOoo00;
    private boolean oO00o0OooO0OO0o0000o;

    public o0Oo0OO00O0O000ooOO0() {
        this((oO00o0OooO0OO0o0000o) null);
    }

    public Object call() throws Exception {
        try {
            return this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0();
        } catch (Throwable th) {
            throw new Exception(th);
        }
    }

    public void o0O00o00OOoOo0oooOoo00() {
        ThreadPoolExecutor threadPoolExecutor = this.O0oOO0ooO;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }

    public oO00o0OooO0OO0o0000o o0Oo0OO00O0O000ooOO0(oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o) {
        this.o0O00o00OOoOo0oooOoo00 = oo00o0oooo0oo0o0000o;
        return this;
    }

    public o0Oo0OO00O0O000ooOO0(oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o) {
        this(oo00o0oooo0oo0o0000o, (ThreadPoolExecutor) null);
    }

    public Object o0Oo0OO00O0O000ooOO0() throws Throwable {
        if (this.o0O00o00OOoOo0oooOoo00 == null || this.O0oOO0ooO == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(this);
        this.O0oOO0ooO.execute(futureTask);
        return this.oO00o0OooO0OO0o0000o ? futureTask.get(this.O00OO0oOOooooO00000Oo, TimeUnit.MILLISECONDS) : futureTask.get();
    }

    public o0Oo0OO00O0O000ooOO0(oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o, ThreadPoolExecutor threadPoolExecutor) {
        this.oO00o0OooO0OO0o0000o = true;
        this.O00OO0oOOooooO00000Oo = 500;
        this.o00ooooooO00OO0O00 = o0Oo0OO00O0O000ooOO0("72383938392e3f38342424383f", 47);
        this.o0O00o00OOoOo0oooOoo00 = oo00o0oooo0oo0o0000o;
        if (threadPoolExecutor == null) {
            this.O0oOO0ooO = new ThreadPoolExecutor(1, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(1), new o0O00o00OOoOo0oooOoo00(this));
        } else {
            this.O0oOO0ooO = threadPoolExecutor;
        }
    }

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 17);
            byte b2 = (byte) (bArr[0] ^ 6);
            bArr[0] = b2;
            for (int i4 = 1; i4 < length; i4++) {
                b2 = (byte) ((b2 ^ bArr[i4]) ^ b);
                bArr[i4] = b2;
            }
            return new String(bArr, CharEncoding.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void o0Oo0OO00O0O000ooOO0(String str) {
        this.o00ooooooO00OO0O00 = str;
    }
}
