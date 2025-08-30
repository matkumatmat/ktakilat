package com.ktakilat.cbase.utils;

import android.view.ViewTreeObserver;

public class AndroidBug5497Workaround {

    /* renamed from: com.ktakilat.cbase.utils.AndroidBug5497Workaround$1  reason: invalid class name */
    class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
        public final void onGlobalLayout() {
            throw null;
        }
    }
}
