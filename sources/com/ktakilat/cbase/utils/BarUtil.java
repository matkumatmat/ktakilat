package com.ktakilat.cbase.utils;

import android.view.Window;
import com.ktakilat.cbase.ui.BaseActivity;

public class BarUtil {

    /* renamed from: com.ktakilat.cbase.utils.BarUtil$1  reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        public final void run() {
            throw null;
        }
    }

    public static void a(BaseActivity baseActivity, int i) {
        try {
            Window window = baseActivity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            window.setBackgroundDrawableResource(i);
        } catch (Exception unused) {
        }
    }
}
