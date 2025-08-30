package com.ktakilat.loan.mobile_check;

import androidx.lifecycle.MutableLiveData;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.http.login.MobileCheckResp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ktakilat/loan/mobile_check/MobileCheckViewModel$checkMobile$1", "Lcom/ktakilat/cbase/http/ApiObserver;", "Lcom/ktakilat/cbase/http/BaseResponse;", "Lcom/ktakilat/loan/http/login/MobileCheckResp;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MobileCheckViewModel$checkMobile$1 extends ApiObserver<BaseResponse<MobileCheckResp>> {
    public final /* synthetic */ MobileCheckViewModel c;

    public MobileCheckViewModel$checkMobile$1(MobileCheckViewModel mobileCheckViewModel) {
        this.c = mobileCheckViewModel;
    }

    public final void a(BaseResponse baseResponse) {
        String str;
        MobileCheckViewModel mobileCheckViewModel = this.c;
        ((MutableLiveData) mobileCheckViewModel.f529a.getValue()).setValue(Boolean.FALSE);
        MutableLiveData mutableLiveData = (MutableLiveData) mobileCheckViewModel.b.getValue();
        if (baseResponse != null) {
            str = baseResponse.getMsg();
        } else {
            str = null;
        }
        mutableLiveData.setValue(str);
    }

    public final void b(BaseResponse baseResponse) {
        MobileCheckResp mobileCheckResp;
        MobileCheckViewModel mobileCheckViewModel = this.c;
        ((MutableLiveData) mobileCheckViewModel.f529a.getValue()).setValue(Boolean.FALSE);
        MutableLiveData mutableLiveData = (MutableLiveData) mobileCheckViewModel.c.getValue();
        if (baseResponse != null) {
            mobileCheckResp = (MobileCheckResp) baseResponse.getData();
        } else {
            mobileCheckResp = null;
        }
        mutableLiveData.setValue(mobileCheckResp);
    }
}
