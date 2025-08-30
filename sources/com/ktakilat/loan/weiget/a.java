package com.ktakilat.loan.weiget;

import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.kta_face.FaceOpenResp;
import com.ktakilat.loan.utils.LivenessResult;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class a implements Function2 {
    public final /* synthetic */ FaceLoginOnOffUtil c;
    public final /* synthetic */ FaceLoginOnOffUtil.ScenceEnum d;

    public /* synthetic */ a(FaceLoginOnOffUtil faceLoginOnOffUtil, FaceLoginOnOffUtil.ScenceEnum scenceEnum) {
        this.c = faceLoginOnOffUtil;
        this.d = scenceEnum;
    }

    public final Object invoke(Object obj, Object obj2) {
        LivenessResult livenessResult = (LivenessResult) obj;
        String str = (String) obj2;
        FaceLoginOnOffUtil faceLoginOnOffUtil = this.c;
        FaceLoginOnOffUtil.ScenceEnum scenceEnum = this.d;
        if (str != null) {
            faceLoginOnOffUtil.o(scenceEnum);
            return null;
        }
        if (livenessResult != null) {
            faceLoginOnOffUtil.getClass();
            if (livenessResult.getImage() != null) {
                y6 y6Var = new y6(faceLoginOnOffUtil, 0);
                BaseActivity baseActivity = faceLoginOnOffUtil.f584a;
                baseActivity.runOnUiThread(y6Var);
                AppHttp.enableTrustDecisionFace(RxLifecycle.a(baseActivity.c, ActivityEvent.DESTROY), livenessResult.getImage(), livenessResult.getLiveness_id()).subscribe(new ApiObserver<BaseResponse<FaceOpenResp>>(scenceEnum) {
                    public final /* synthetic */ ScenceEnum c;

                    {
                        this.c = r2;
                    }

                    public final void a(BaseResponse baseResponse) {
                        KtaCollect.n_face_login_set_fail(baseResponse.getCode());
                        FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                        if (faceLoginOnOffUtil.k()) {
                            faceLoginOnOffUtil.f584a.runOnUiThread(new b(0, this, baseResponse));
                        }
                    }

                    public final void b(BaseResponse baseResponse) {
                        FaceOpenResp faceOpenResp;
                        KtaCollect.n_face_login_set_suc();
                        FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                        if (faceLoginOnOffUtil.k()) {
                            faceLoginOnOffUtil.f584a.runOnUiThread(new c(this, 0));
                            ResponseCodeDeal.a(baseResponse);
                            if (baseResponse.isSuccess() && (faceOpenResp = (FaceOpenResp) baseResponse.getData()) != null) {
                                int enableFaceLoginResult = faceOpenResp.getEnableFaceLoginResult();
                                ScenceEnum scenceEnum = this.c;
                                if (enableFaceLoginResult == 1) {
                                    faceLoginOnOffUtil.o(scenceEnum);
                                } else if (faceOpenResp.getEnableFaceLoginResult() == 2) {
                                    faceLoginOnOffUtil.f584a.runOnUiThread(new d(this, faceOpenResp, scenceEnum));
                                } else {
                                    faceLoginOnOffUtil.f584a.runOnUiThread(new c(this, 1));
                                }
                            }
                        }
                    }
                });
                return null;
            }
        }
        faceLoginOnOffUtil.o(scenceEnum);
        return null;
    }
}
