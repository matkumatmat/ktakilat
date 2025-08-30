package com.ktakilat.loan.utils;

import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.http.login.LoginMoreResp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.BooleanUtils;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001¨\u0006\u0005"}, d2 = {"com/ktakilat/loan/utils/TrustLivenessUtil$Companion$checkLiveness$1", "Lcom/ktakilat/cbase/http/ApiObserver;", "Lcom/ktakilat/cbase/http/BaseResponse;", "", "Lcom/ktakilat/loan/http/login/LoginMoreResp;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TrustLivenessUtil$Companion$checkLiveness$1 extends ApiObserver<BaseResponse<List<? extends LoginMoreResp>>> {
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function0 d;

    public TrustLivenessUtil$Companion$checkLiveness$1(Function0 function0, Function0 function02) {
        this.c = function0;
        this.d = function02;
    }

    public final void a(BaseResponse baseResponse) {
        this.c.invoke();
    }

    public final void b(BaseResponse baseResponse) {
        Function0 function0 = this.c;
        if (baseResponse == null) {
            function0.invoke();
        } else if (baseResponse.getData() == null) {
            function0.invoke();
        } else {
            Object data = baseResponse.getData();
            Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
            LoginMoreResp loginMoreResp = (LoginMoreResp) CollectionsKt.firstOrNull((List) data);
            if (loginMoreResp == null) {
                function0.invoke();
            } else if (Intrinsics.a(loginMoreResp.getValue(), BooleanUtils.FALSE)) {
                this.d.invoke();
            } else {
                function0.invoke();
            }
        }
    }
}
