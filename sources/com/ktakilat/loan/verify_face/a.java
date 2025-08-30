package com.ktakilat.loan.verify_face;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.verify.VerifyOtpResp;
import com.ktakilat.loan.weiget.GpsUtil;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;

public final /* synthetic */ class a implements GpsUtil.GpsIgnoreCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseVerifyFaceActivity f563a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ a(BaseVerifyFaceActivity baseVerifyFaceActivity, String str, String str2) {
        this.f563a = baseVerifyFaceActivity;
        this.b = str;
        this.c = str2;
    }

    public final void a(double d, double d2) {
        int i = BaseVerifyFaceActivity.s;
        ActivityEvent activityEvent = ActivityEvent.DESTROY;
        BaseVerifyFaceActivity baseVerifyFaceActivity = this.f563a;
        AppHttp.trustDecisionVerification(RxLifecycle.a(baseVerifyFaceActivity.c, activityEvent), baseVerifyFaceActivity.p, baseVerifyFaceActivity.q, d, d2, this.b, this.c).subscribe(new ApiObserver<BaseResponse<VerifyOtpResp>>() {
            public final void a(BaseResponse baseResponse) {
                d dVar = new d(this, baseResponse, 0);
                BaseVerifyFaceActivity baseVerifyFaceActivity = BaseVerifyFaceActivity.this;
                baseVerifyFaceActivity.runOnUiThread(dVar);
                KtaCollect.n_face_verification_page_result(baseVerifyFaceActivity.G(), ExifInterface.GPS_MEASUREMENT_2D);
            }

            public final void b(BaseResponse baseResponse) {
                e eVar = new e(this);
                BaseVerifyFaceActivity baseVerifyFaceActivity = BaseVerifyFaceActivity.this;
                baseVerifyFaceActivity.runOnUiThread(eVar);
                if (((VerifyOtpResp) baseResponse.getData()).getResult() == 1) {
                    KtaCollect.n_face_verification_page_result(baseVerifyFaceActivity.G(), AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    baseVerifyFaceActivity.E(((VerifyOtpResp) baseResponse.getData()).getSuccessfulValidationToken(), ((VerifyOtpResp) baseResponse.getData()).getAuthStatusList(), ((VerifyOtpResp) baseResponse.getData()).getLoginResp());
                } else if (((VerifyOtpResp) baseResponse.getData()).getResult() == 2) {
                    KtaCollect.n_face_verification_page_result(baseVerifyFaceActivity.G(), AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    baseVerifyFaceActivity.runOnUiThread(new d(this, baseResponse, 1));
                } else {
                    KtaCollect.n_face_verification_page_result(baseVerifyFaceActivity.G(), AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
            }
        });
    }
}
