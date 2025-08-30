package com.tongdun.mobox.sdk;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.google.gson.Gson;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.utils.LivenessResult;
import com.ktakilat.loan.utils.TrustLivenessUtil$Companion$startLiveness$1$1;
import com.trustdecision.mobrisk.TDRisk;
import com.trustdecision.mobrisk.TDRiskLivenessCallback;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public class TongdunSdk {

    public interface TDErrorCallback {
    }

    public interface TDLivenessCallback {
    }

    public static void a(Context context, String str, final TrustLivenessUtil$Companion$startLiveness$1$1 trustLivenessUtil$Companion$startLiveness$1$1) {
        try {
            TDRisk.Builder builder = new TDRisk.Builder();
            builder.partnerCode("kilat_id").appName("kilat_and").appKey("ef494b7ac2898cee08a2062630f9d763").showReadyPage(false);
            builder.country(TDRisk.COUNTRY_IDNA).language("id").disableDebugger();
            TDRisk.initWithOptions(context, builder);
        } catch (Exception unused) {
        }
        TDRisk.showLiveness(str, new TDRiskLivenessCallback() {
            /* JADX WARNING: type inference failed for: r13v3, types: [io.reactivex.Observer, java.lang.Object] */
            public final void onError(String str, String str2, String str3) {
                int i;
                Integer intOrNull;
                TrustLivenessUtil$Companion$startLiveness$1$1 trustLivenessUtil$Companion$startLiveness$1$1 = TrustLivenessUtil$Companion$startLiveness$1$1.this;
                try {
                    if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
                        i = -1;
                    } else {
                        i = intOrNull.intValue();
                    }
                    LivenessResult livenessResult = new LivenessResult(i, str2, (String) null, str3, (String) null, 20, (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(livenessResult, "result");
                    AppHttp.uploadFaceLog(livenessResult).subscribe(new Object());
                } catch (Throwable unused) {
                }
                KtaCollect.n_face_result("-3", str, Long.valueOf(System.currentTimeMillis() - trustLivenessUtil$Companion$startLiveness$1$1.f552a), (String) null);
                trustLivenessUtil$Companion$startLiveness$1$1.c.invoke((Object) null, str);
                if (!StringsKt.q(str, "20711", false) && !StringsKt.q(str, "20712", false)) {
                    trustLivenessUtil$Companion$startLiveness$1$1.b.invoke();
                }
            }

            /* JADX WARNING: type inference failed for: r4v5, types: [io.reactivex.Observer, java.lang.Object] */
            public final void onSuccess(String str) {
                TrustLivenessUtil$Companion$startLiveness$1$1 trustLivenessUtil$Companion$startLiveness$1$1 = TrustLivenessUtil$Companion$startLiveness$1$1.this;
                long currentTimeMillis = System.currentTimeMillis();
                LivenessResult livenessResult = (LivenessResult) new Gson().fromJson(str, LivenessResult.class);
                Intrinsics.c(livenessResult);
                Intrinsics.checkNotNullParameter(livenessResult, "result");
                try {
                    AppHttp.uploadFaceLog(livenessResult).subscribe(new Object());
                } catch (Throwable unused) {
                }
                int code = livenessResult.getCode();
                long j = trustLivenessUtil$Companion$startLiveness$1$1.f552a;
                if (code == 200) {
                    KtaCollect.n_face_result(AppEventsConstants.EVENT_PARAM_VALUE_YES, (String) null, Long.valueOf(currentTimeMillis - j), livenessResult.getLiveness_id());
                } else {
                    if (!(livenessResult.getCode() == 20711 || livenessResult.getCode() == 20712)) {
                        trustLivenessUtil$Companion$startLiveness$1$1.b.invoke();
                    }
                    KtaCollect.n_face_result("-3", String.valueOf(livenessResult.getCode()), Long.valueOf(currentTimeMillis - j), livenessResult.getLiveness_id());
                }
                trustLivenessUtil$Companion$startLiveness$1$1.c.invoke(livenessResult, (Object) null);
            }
        });
    }
}
