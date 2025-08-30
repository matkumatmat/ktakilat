package com.trustdecision.liveness.cw.api.il111liilil;

import android.util.Base64;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class i11iliil1li1 {
    private static ExecutorService il111liilil;
    /* access modifiers changed from: private */
    public static final String illill1ll1 = illill1ll1("FhcsOhUbBg==");

    public static synchronized void illill1ll1() {
        synchronized (i11iliil1li1.class) {
            if (il111liilil == null) {
                il111liilil = new ThreadPoolExecutor(3, 10, 8, TimeUnit.SECONDS, new LinkedBlockingDeque(), new iill11lliiil1l1i11l11());
            }
        }
    }

    public static void illill1ll1(String str, String str2, int i, il111liilil il111liilil2) {
        if (il111liilil != null) {
            il111liilil.submit(new ilii1liii11i1iii1l1(str, str2, il111liilil2, i));
        }
    }

    private static String illill1ll1(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            int length = decode.length;
            byte[] bytes = "bssRaov".getBytes();
            int length2 = bytes.length;
            for (int i = 0; i < length; i++) {
                decode[i] = (byte) (decode[i] ^ bytes[i % length2]);
            }
            return new String(decode, "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }
}
