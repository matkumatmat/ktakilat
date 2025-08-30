package com.ktakilat.loan.weiget;

import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ FaceLoginOnOffUtil.AnonymousClass19 d;

    public /* synthetic */ c(FaceLoginOnOffUtil.AnonymousClass19 r1, int i) {
        this.c = i;
        this.d = r1;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                FaceLoginOnOffUtil.this.g();
                return;
            default:
                ToastUtil.b(FaceLoginOnOffUtil.this.f584a, R.string.face_login_open_fail);
                return;
        }
    }
}
