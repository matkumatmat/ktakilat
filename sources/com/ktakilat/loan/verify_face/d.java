package com.ktakilat.loan.verify_face;

import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.weight.LoadingDialog;
import com.ktakilat.loan.http.verify.VerifyOtpResp;
import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;
import org.greenrobot.eventbus.EventBus;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ BaseVerifyFaceActivity.AnonymousClass7 d;
    public final /* synthetic */ BaseResponse e;

    public /* synthetic */ d(BaseVerifyFaceActivity.AnonymousClass7 r1, BaseResponse baseResponse, int i) {
        this.c = i;
        this.d = r1;
        this.e = baseResponse;
    }

    public final void run() {
        BaseResponse baseResponse = this.e;
        BaseVerifyFaceActivity.AnonymousClass7 r1 = this.d;
        int i = this.c;
        r1.getClass();
        switch (i) {
            case 0:
                int i2 = BaseVerifyFaceActivity.s;
                BaseVerifyFaceActivity baseVerifyFaceActivity = BaseVerifyFaceActivity.this;
                baseVerifyFaceActivity.e = 0;
                try {
                    LoadingDialog loadingDialog = baseVerifyFaceActivity.d;
                    if (loadingDialog != null && loadingDialog.isShowing()) {
                        baseVerifyFaceActivity.d.dismiss();
                    }
                } catch (Exception unused) {
                }
                ResponseCodeDeal.b(baseResponse);
                if ("A100322".equals(baseResponse.getCode())) {
                    try {
                        baseVerifyFaceActivity.r.remove(Integer.valueOf(VerifyType.FACE.type));
                        EventBus.b().e(new EventVerifyMethodUpdate(baseVerifyFaceActivity.r));
                    } catch (Exception unused2) {
                    }
                    if (baseVerifyFaceActivity.r.contains(Integer.valueOf(VerifyType.OTP.type))) {
                        baseVerifyFaceActivity.I(baseVerifyFaceActivity.p);
                        return;
                    } else {
                        baseVerifyFaceActivity.finish();
                        return;
                    }
                } else {
                    return;
                }
            default:
                BaseVerifyFaceActivity.this.D(((VerifyOtpResp) baseResponse.getData()).getTwoFactorVerificationToken(), ((VerifyOtpResp) baseResponse.getData()).getEktp());
                return;
        }
    }
}
