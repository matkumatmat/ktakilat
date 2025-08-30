package com.ktakilat.loan.input_code;

import com.ktakilat.loan.R;
import com.ktakilat.loan.http.kta_face.FaceEnableResp;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;
import com.ktakilat.loan.weiget.dialog.DialogUtils;

public final /* synthetic */ class b implements FaceLoginOnOffUtil.ScenceEnableCall {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InputCodeActivity f500a;

    public /* synthetic */ b(InputCodeActivity inputCodeActivity) {
        this.f500a = inputCodeActivity;
    }

    public final void a(FaceEnableResp faceEnableResp, boolean z, boolean z2, boolean z3) {
        int i = InputCodeActivity.r;
        InputCodeActivity inputCodeActivity = this.f500a;
        inputCodeActivity.getClass();
        if (faceEnableResp == null || !z || z2) {
            inputCodeActivity.A();
        } else if (z3) {
        } else {
            if (inputCodeActivity.q) {
                inputCodeActivity.A();
            } else {
                DialogUtils.h(inputCodeActivity, inputCodeActivity.getText(R.string.camera).toString(), new DialogUtils.SettingStatusCall() {
                    public final void a() {
                        InputCodeActivity.this.q = true;
                    }

                    public final void cancel() {
                        InputCodeActivity.this.A();
                    }
                });
            }
        }
    }
}
