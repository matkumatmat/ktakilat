package com.ktakilat.loan.utils;

import android.content.Context;
import com.facebook.places.model.PlaceFields;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.login.LoginFaceLicenseResp;
import com.ktakilat.loan.http.login.LoginMoreResp;
import com.trello.rxlifecycle2.LifecycleTransformer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ktakilat/loan/utils/TrustLivenessUtil;", "", "Companion", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TrustLivenessUtil {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ktakilat/loan/utils/TrustLivenessUtil$Companion;", "", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public static void a(Function0 function0, Function0 function02) {
            Intrinsics.checkNotNullParameter(function0, "onTrustDecision");
            Intrinsics.checkNotNullParameter(function02, "onBaidu");
            AppHttp.loginMore((LifecycleTransformer<BaseResponse<List<LoginMoreResp>>>) null, "trustdecision.face.switch").subscribe(new TrustLivenessUtil$Companion$checkLiveness$1(function0, function02));
        }

        public static void b(Context context, Function2 function2, Function0 function0) {
            Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
            Intrinsics.checkNotNullParameter(function2, "onResult");
            Intrinsics.checkNotNullParameter(function0, "onUserRetryCallback");
            AppHttp.getFaceLicense((LifecycleTransformer<BaseResponse<LoginFaceLicenseResp>>) null).subscribe(new TrustLivenessUtil$Companion$getLivenessLicense$1(new eg(System.currentTimeMillis(), function2, function0, context)));
        }
    }
}
