package com.ktakilat.loan.weiget;

import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.weiget.PhoneCodeUtil;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ToastUtil.b(FaceLoginOnOffUtil.this.f584a, R.string.face_onoff_opened);
                return;
            default:
                PhoneCodeUtil phoneCodeUtil = PhoneCodeUtil.this;
                if (phoneCodeUtil.e) {
                    int i = phoneCodeUtil.d;
                    if (i <= 0) {
                        phoneCodeUtil.e = false;
                    }
                    PhoneCodeUtil.PhoneCodeCallback phoneCodeCallback = phoneCodeUtil.h;
                    if (phoneCodeCallback != null) {
                        phoneCodeCallback.a(i);
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
