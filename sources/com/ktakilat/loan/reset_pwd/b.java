package com.ktakilat.loan.reset_pwd;

import com.ktakilat.loan.R;
import com.ktakilat.loan.http.kta_face.FaceEnableResp;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;
import com.ktakilat.loan.weiget.dialog.DialogUtils;

public final /* synthetic */ class b implements FaceLoginOnOffUtil.ScenceEnableCall {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ResetPwdActivity f542a;

    public /* synthetic */ b(ResetPwdActivity resetPwdActivity) {
        this.f542a = resetPwdActivity;
    }

    public final void a(FaceEnableResp faceEnableResp, boolean z, boolean z2, boolean z3) {
        int i = ResetPwdActivity.n;
        ResetPwdActivity resetPwdActivity = this.f542a;
        resetPwdActivity.getClass();
        if (faceEnableResp == null || !z || z2) {
            resetPwdActivity.z();
        } else if (z3) {
        } else {
            if (resetPwdActivity.m) {
                resetPwdActivity.z();
            } else {
                DialogUtils.h(resetPwdActivity, resetPwdActivity.getText(R.string.camera).toString(), new DialogUtils.SettingStatusCall() {
                    public final void a() {
                        ResetPwdActivity.this.m = true;
                    }

                    public final void cancel() {
                        int i = ResetPwdActivity.n;
                        ResetPwdActivity.this.z();
                    }
                });
            }
        }
    }
}
