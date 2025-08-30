package com.ktakilat.loan.face_login_onoff;

import android.app.Activity;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.ktakilat.loan.face_login_onoff.FaceLoginOnOffActivity;
import com.ktakilat.loan.web.CommonWebActivity;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ FaceLoginOnOffActivity.AnonymousClass1 c;
    public final /* synthetic */ Activity d;

    public /* synthetic */ a(FaceLoginOnOffActivity.AnonymousClass1 r1, Activity activity) {
        this.c = r1;
        this.d = activity;
    }

    public final Object invoke() {
        this.c.getClass();
        Activity activity = this.d;
        DialogUtils.e(activity, new Runnable(activity) {
            public final /* synthetic */ Activity c;

            {
                this.c = r1;
            }

            public final void run() {
                CommonWebActivity.C(this.c, (String) null, "/UserCenter/PusatBantuan", false, 0);
            }
        });
        FirebaseCrashlytics.getInstance().recordException(new Throwable("百度sdk初始化失败"));
        return null;
    }
}
