package com.ktakilat.loan.weiget;

import android.widget.TextView;
import com.ktakilat.loan.R;
import com.ktakilat.loan.weiget.GestureUtil;

public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ GestureUtil.AnonymousClass7 c;
    public final /* synthetic */ TextView d;
    public final /* synthetic */ long e;

    public /* synthetic */ h(GestureUtil.AnonymousClass7 r1, TextView textView, long j) {
        this.c = r1;
        this.d = textView;
        this.e = j;
    }

    public final void run() {
        TextView textView = this.d;
        long j = this.e;
        GestureUtil gestureUtil = GestureUtil.this;
        if (gestureUtil.h()) {
            try {
                textView.setEnabled(false);
                textView.setText(gestureUtil.g().getString(R.string.set_now) + "(" + (j / 1000) + "s)");
            } catch (Exception unused) {
            }
        }
    }
}
