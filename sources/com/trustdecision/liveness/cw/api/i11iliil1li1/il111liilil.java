package com.trustdecision.liveness.cw.api.i11iliil1li1;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64;

public class il111liilil {
    private static final HandlerThread i11iliil1li1;
    private static final Handler iill11lliiil1l1i11l11;
    private static final Handler il111liilil = new Handler(Looper.getMainLooper());
    private static final String illill1ll1;

    static {
        String illill1ll12 = illill1ll1("IRUmPi0RHQst");
        illill1ll1 = illill1ll12;
        HandlerThread handlerThread = new HandlerThread(illill1ll12);
        i11iliil1li1 = handlerThread;
        handlerThread.start();
        iill11lliiil1l1i11l11 = new Handler(handlerThread.getLooper());
    }

    public static void illill1ll1(Runnable runnable) {
        il111liilil.post(runnable);
    }

    private static String illill1ll1(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            int length = decode.length;
            byte[] bytes = "uqn_C".getBytes();
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
