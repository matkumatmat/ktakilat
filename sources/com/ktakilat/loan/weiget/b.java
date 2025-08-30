package com.ktakilat.loan.weiget;

import android.widget.TextView;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.loan.R;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                FaceLoginOnOffUtil.this.g();
                ResponseCodeDeal.b((BaseResponse) this.e);
                return;
            default:
                TextView textView = (TextView) this.e;
                GestureUtil gestureUtil = GestureUtil.this;
                if (gestureUtil.h()) {
                    try {
                        textView.setEnabled(true);
                        textView.setText(gestureUtil.g().getString(R.string.set_now));
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                } else {
                    return;
                }
        }
    }
}
