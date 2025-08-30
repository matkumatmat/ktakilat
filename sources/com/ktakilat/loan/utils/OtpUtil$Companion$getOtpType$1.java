package com.ktakilat.loan.utils;

import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.http.user.OtpTypeResp;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ktakilat/loan/utils/OtpUtil$Companion$getOtpType$1", "Lcom/ktakilat/cbase/http/ApiObserver;", "Lcom/ktakilat/cbase/http/BaseResponse;", "Lcom/ktakilat/loan/http/user/OtpTypeResp;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OtpUtil$Companion$getOtpType$1 extends ApiObserver<BaseResponse<OtpTypeResp>> {
    public final /* synthetic */ BaseVerifyOtpActivity c;
    public final /* synthetic */ z0 d;
    public final /* synthetic */ a e;

    public OtpUtil$Companion$getOtpType$1(BaseVerifyOtpActivity baseVerifyOtpActivity, z0 z0Var, a aVar) {
        this.c = baseVerifyOtpActivity;
        this.d = z0Var;
        this.e = aVar;
    }

    public final void a(BaseResponse baseResponse) {
        BaseVerifyOtpActivity baseVerifyOtpActivity = this.c;
        baseVerifyOtpActivity.u();
        baseVerifyOtpActivity.runOnUiThread(new ib(5, this.e, baseResponse));
    }

    public final void b(BaseResponse baseResponse) {
        OtpTypeResp otpTypeResp;
        BaseVerifyOtpActivity baseVerifyOtpActivity = this.c;
        baseVerifyOtpActivity.u();
        ArrayList arrayList = new ArrayList();
        if (baseResponse != null) {
            otpTypeResp = (OtpTypeResp) baseResponse.getData();
        } else {
            otpTypeResp = null;
        }
        if (otpTypeResp != null) {
            List<String> list = otpTypeResp.methods;
            Intrinsics.checkNotNullExpressionValue(list, "methods");
            arrayList.addAll(list);
        }
        boolean contains = arrayList.contains("NORMAL");
        baseVerifyOtpActivity.runOnUiThread(new ad(this.d, arrayList.contains("WA"), contains));
    }
}
