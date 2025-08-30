package com.ktakilat.loan.utils;

import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.http.login.LoginFaceLicenseResp;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ktakilat/loan/utils/TrustLivenessUtil$Companion$getLivenessLicense$1", "Lio/reactivex/Observer;", "Lcom/ktakilat/cbase/http/BaseResponse;", "Lcom/ktakilat/loan/http/login/LoginFaceLicenseResp;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TrustLivenessUtil$Companion$getLivenessLicense$1 implements Observer<BaseResponse<LoginFaceLicenseResp>> {
    public final /* synthetic */ eg c;

    public TrustLivenessUtil$Companion$getLivenessLicense$1(eg egVar) {
        this.c = egVar;
    }

    public final void onComplete() {
    }

    public final void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        this.c.invoke((Object) null, "network error");
    }

    public final void onNext(Object obj) {
        BaseResponse baseResponse = (BaseResponse) obj;
        Intrinsics.checkNotNullParameter(baseResponse, "t");
        Object data = baseResponse.getData();
        eg egVar = this.c;
        if (data != null) {
            egVar.invoke(((LoginFaceLicenseResp) baseResponse.getData()).getLicense(), (Object) null);
        } else {
            egVar.invoke((Object) null, baseResponse.getMsg());
        }
    }

    public final void onSubscribe(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
    }
}
