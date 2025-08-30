package com.trustdecision.android.o0Oo0OO00O0O000ooOO0;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.common.base.Ascii;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.CharEncoding;

public final class oO00o0OooO0OO0o0000o {
    private static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("78787978796e7f78746464787f", 33);
    private final ThreadPoolExecutor O00OO0oOOooooO00000Oo;
    private final HandlerThread O0oOO0ooO;
    private final ThreadPoolExecutor o0O00o00OOoOo0oooOoo00;
    private final ThreadPoolExecutor oO00o0OooO0OO0o0000o;

    public static class o0O00o00OOoOo0oooOoo00 implements ThreadFactory {
        private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
            try {
                int length = str.length() / 2;
                char[] charArray = str.toCharArray();
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 2;
                    bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
                }
                byte b = (byte) (i ^ 74);
                byte b2 = (byte) (bArr[0] ^ 90);
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

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(o0Oo0OO00O0O000ooOO0("2e6f6e6f6e79686f6373736f68", 35));
            return thread;
        }
    }

    public static class o0Oo0OO00O0O000ooOO0 {
        static final oO00o0OooO0OO0o0000o o0Oo0OO00O0O000ooOO0 = new oO00o0OooO0OO0o0000o();
    }

    private oO00o0OooO0OO0o0000o() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.o0O00o00OOoOo0oooOoo00 = new ThreadPoolExecutor(availableProcessors, availableProcessors + 3, 0, timeUnit, new LinkedBlockingQueue(), new o0O00o00OOoOo0oooOoo00());
        TimeUnit timeUnit2 = timeUnit;
        this.oO00o0OooO0OO0o0000o = new ThreadPoolExecutor(2, 4, 0, timeUnit2, new LinkedBlockingQueue(4), new o0O00o00OOoOo0oooOoo00(), new ThreadPoolExecutor.DiscardOldestPolicy());
        this.O00OO0oOOooooO00000Oo = new ThreadPoolExecutor(1, Integer.MAX_VALUE, 5000, timeUnit2, new SynchronousQueue(), new o0O00o00OOoOo0oooOoo00());
        this.O0oOO0ooO = new HandlerThread(o0Oo0OO00O0O000ooOO0("78696869687f6e69657575696e", 48));
    }

    public static void o0O00o00OOoOo0oooOoo00(Runnable runnable) {
        o0Oo0OO00O0O000ooOO0().O00OO0oOOooooO00000Oo.execute(runnable);
    }

    public static oO00o0OooO0OO0o0000o o0Oo0OO00O0O000ooOO0() {
        return o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
    }

    public static void oO00o0OooO0OO0o0000o(Runnable runnable) {
        if (o0Oo0OO00O0O000ooOO0().O0oOO0ooO != null) {
            if (!o0Oo0OO00O0O000ooOO0().O0oOO0ooO.isAlive()) {
                o0Oo0OO00O0O000ooOO0().O0oOO0ooO.start();
            }
            new Handler(o0Oo0OO00O0O000ooOO0().O0oOO0ooO.getLooper()).post(runnable);
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
            byte b = (byte) (i ^ 95);
            byte b2 = (byte) (bArr[0] ^ Ascii.FF);
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

    public static void o0Oo0OO00O0O000ooOO0(Runnable runnable) {
        o0Oo0OO00O0O000ooOO0().o0O00o00OOoOo0oooOoo00.execute(runnable);
    }
}
