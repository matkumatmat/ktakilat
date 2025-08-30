package com.ktakilat.loan.new_pwd;

import androidx.lifecycle.MutableLiveData;
import com.ktakilat.cbase.datacollect.KtaEvent;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.loan.global.AppKv;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ktakilat/loan/new_pwd/NewPasswordViewModel$updatePassword$1", "Lcom/ktakilat/cbase/http/ApiObserver;", "Lcom/ktakilat/cbase/http/BaseResponse;", "", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewPasswordViewModel$updatePassword$1 extends ApiObserver<BaseResponse<Boolean>> {
    public final /* synthetic */ NewPasswordViewModel c;

    public NewPasswordViewModel$updatePassword$1(NewPasswordViewModel newPasswordViewModel) {
        this.c = newPasswordViewModel;
    }

    public final void a(BaseResponse baseResponse) {
        String str;
        ((MutableLiveData) this.c.d.getValue()).setValue(Boolean.FALSE);
        if (baseResponse != null) {
            str = baseResponse.getMsg();
        } else {
            str = null;
        }
        KtaEvent.Companion.a(str, false);
        ResponseCodeDeal.b(baseResponse);
    }

    public final void b(BaseResponse baseResponse) {
        boolean z;
        NewPasswordViewModel newPasswordViewModel = this.c;
        Boolean bool = Boolean.TRUE;
        ((MutableLiveData) newPasswordViewModel.d.getValue()).setValue(bool);
        if (baseResponse != null) {
            z = Intrinsics.a(baseResponse.getData(), bool);
        } else {
            z = false;
        }
        String str = null;
        if (z) {
            AppKv.g().f465a.putBoolean("has-login", true);
            ((MutableLiveData) newPasswordViewModel.e.getValue()).setValue(bool);
            KtaEvent.Companion.a((String) null, true);
            return;
        }
        if (baseResponse != null) {
            str = baseResponse.getMsg();
        }
        KtaEvent.Companion.a(str, false);
    }
}
