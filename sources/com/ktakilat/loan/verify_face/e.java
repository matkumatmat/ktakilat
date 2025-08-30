package com.ktakilat.loan.verify_face;

import com.ktakilat.cbase.weight.LoadingDialog;
import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ BaseVerifyFaceActivity.AnonymousClass7 c;

    public /* synthetic */ e(BaseVerifyFaceActivity.AnonymousClass7 r1) {
        this.c = r1;
    }

    public final void run() {
        BaseVerifyFaceActivity.AnonymousClass7 r0 = this.c;
        r0.getClass();
        int i = BaseVerifyFaceActivity.s;
        BaseVerifyFaceActivity baseVerifyFaceActivity = BaseVerifyFaceActivity.this;
        baseVerifyFaceActivity.e = 0;
        try {
            LoadingDialog loadingDialog = baseVerifyFaceActivity.d;
            if (loadingDialog != null && loadingDialog.isShowing()) {
                baseVerifyFaceActivity.d.dismiss();
            }
        } catch (Exception unused) {
        }
    }
}
