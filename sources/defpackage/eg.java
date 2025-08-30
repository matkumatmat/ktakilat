package defpackage;

import android.content.Context;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.loan.utils.TrustLivenessUtil$Companion$startLiveness$1$1;
import com.tongdun.mobox.sdk.TongdunSdk;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* renamed from: eg  reason: default package */
public final /* synthetic */ class eg implements Function2 {
    public final /* synthetic */ long c;
    public final /* synthetic */ Function2 d;
    public final /* synthetic */ Function0 e;
    public final /* synthetic */ Context f;

    public /* synthetic */ eg(long j, Function2 function2, Function0 function0, Context context) {
        this.c = j;
        this.d = function2;
        this.e = function0;
        this.f = context;
    }

    public final Object invoke(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        Function2 function2 = this.d;
        Function0 function0 = this.e;
        long j = this.c;
        if (str == null) {
            KtaCollect.n_face_result("-3", e.B("license is empty: ", str2), Long.valueOf(System.currentTimeMillis() - j), (String) null);
            function2.invoke((Object) null, str2);
            function0.invoke();
        } else {
            TongdunSdk.a(this.f, str, new TrustLivenessUtil$Companion$startLiveness$1$1(j, function0, function2));
        }
        return Unit.f696a;
    }
}
