package com.ktakilat.loan.mobile_check;

import androidx.lifecycle.MutableLiveData;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.http.ojk.OjkStatementResp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ktakilat/loan/mobile_check/MobileCheckViewModel$startOjkStatement$1", "Lcom/ktakilat/cbase/http/ApiObserver;", "Lcom/ktakilat/cbase/http/BaseResponse;", "Lcom/ktakilat/loan/http/ojk/OjkStatementResp;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MobileCheckViewModel$startOjkStatement$1 extends ApiObserver<BaseResponse<OjkStatementResp>> {
    public final /* synthetic */ MobileCheckViewModel c;

    public MobileCheckViewModel$startOjkStatement$1(MobileCheckViewModel mobileCheckViewModel) {
        this.c = mobileCheckViewModel;
    }

    public final void a(BaseResponse baseResponse) {
    }

    public final void b(BaseResponse baseResponse) {
        OjkStatementResp ojkStatementResp;
        MutableLiveData mutableLiveData = (MutableLiveData) this.c.d.getValue();
        if (baseResponse != null) {
            ojkStatementResp = (OjkStatementResp) baseResponse.getData();
        } else {
            ojkStatementResp = null;
        }
        mutableLiveData.setValue(ojkStatementResp);
    }
}
