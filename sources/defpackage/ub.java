package defpackage;

import android.content.Intent;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.katkilat.baidu_face.LivenessBaiduActivity;
import com.ktakilat.loan.normal_ui.LivenessGuideActivity;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* renamed from: ub  reason: default package */
public final /* synthetic */ class ub implements Function0 {
    public final /* synthetic */ int c;
    public final /* synthetic */ LivenessGuideActivity d;

    public /* synthetic */ ub(LivenessGuideActivity livenessGuideActivity, int i) {
        this.c = i;
        this.d = livenessGuideActivity;
    }

    public final Object invoke() {
        LivenessGuideActivity livenessGuideActivity = this.d;
        switch (this.c) {
            case 0:
                int i = LivenessGuideActivity.e;
                livenessGuideActivity.d.launch(new Intent(livenessGuideActivity, LivenessBaiduActivity.class));
                return Unit.f696a;
            default:
                int i2 = LivenessGuideActivity.e;
                DialogUtils.e(livenessGuideActivity, new x0(livenessGuideActivity, 26));
                FirebaseCrashlytics.getInstance().recordException(new Throwable("百度sdk初始化失败"));
                return Unit.f696a;
        }
    }
}
