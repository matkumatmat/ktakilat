package com.ktakilat.loan.weiget;

import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.loan.http.kta_face.FaceOpenResp;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ FaceLoginOnOffUtil.AnonymousClass19 c;
    public final /* synthetic */ FaceOpenResp d;
    public final /* synthetic */ FaceLoginOnOffUtil.ScenceEnum e;

    public /* synthetic */ d(FaceLoginOnOffUtil.AnonymousClass19 r1, FaceOpenResp faceOpenResp, FaceLoginOnOffUtil.ScenceEnum scenceEnum) {
        this.c = r1;
        this.d = faceOpenResp;
        this.e = scenceEnum;
    }

    public final void run() {
        FaceLoginOnOffUtil.AnonymousClass19 r0 = this.c;
        r0.getClass();
        FaceOpenResp faceOpenResp = this.d;
        FaceLoginOnOffUtil.this.b(faceOpenResp.getTwoFactorVerificationToken(), faceOpenResp.getEktp(), true, new FaceLoginOnOffUtil.EktpCall(this.e) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ScenceEnum f586a;

            {
                this.f586a = r2;
            }

            public final void a(boolean z, BaseResponse baseResponse) {
                ScenceEnum scenceEnum = this.f586a;
                AnonymousClass19 r1 = AnonymousClass19.this;
                if (z) {
                    FaceLoginOnOffUtil.this.f584a.runOnUiThread(new e(this, 0));
                    FaceLoginOnOffUtil faceLoginOnOffUtil = FaceLoginOnOffUtil.this;
                    faceLoginOnOffUtil.o(scenceEnum);
                    faceLoginOnOffUtil.f584a.onBackPressed();
                } else if (baseResponse == null) {
                    FaceLoginOnOffUtil.this.o(scenceEnum);
                } else if (baseResponse.isSuc() || baseResponse.getCode().equals("A000030") || baseResponse.getCode().equals("A000031") || baseResponse.getCode().equals("A000293") || baseResponse.getCode().equals("A000306")) {
                    FaceLoginOnOffUtil.this.f584a.onBackPressed();
                } else {
                    ResponseCodeDeal.a(baseResponse);
                }
            }
        });
    }
}
