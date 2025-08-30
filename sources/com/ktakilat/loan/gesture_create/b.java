package com.ktakilat.loan.gesture_create;

import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.gesture_create.GestureCreateActivity;
import com.ktakilat.loan.main.EventHomeAct;
import com.ktakilat.loan.main.HomeActivity;
import com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil;
import com.ktakilat.loan.weiget.GestureUtil;
import com.ktakilat.loan.weiget.WebCookieManager;
import org.apache.commons.lang3.BooleanUtils;
import org.greenrobot.eventbus.EventBus;

public final /* synthetic */ class b implements GestureUtil.SetGestureCallback, WebCookieManager.CookieCallback {
    public final /* synthetic */ GestureCreateActivity.AnonymousClass2 c;

    public /* synthetic */ b(GestureCreateActivity.AnonymousClass2 r1) {
        this.c = r1;
    }

    public void a(boolean z) {
        String str;
        GestureCreateActivity.AnonymousClass2 r0 = this.c;
        String str2 = GestureCreateActivity.this.k;
        if (z) {
            str = "true";
        } else {
            str = BooleanUtils.FALSE;
        }
        KtaCollect.n_pattern_pwd_result(str2, str);
        if (z) {
            ToastUtil.c(GestureCreateActivity.this, R.string.gesture_create_success);
            if (ChangeMobileAndForgotPwdTmpLoginUtil.f557a != null) {
                ChangeMobileAndForgotPwdTmpLoginUtil.b(new b(r0));
                return;
            }
            GestureCreateActivity.this.setResult(-1);
            GestureCreateActivity.this.finish();
        }
    }

    public void d() {
        GestureCreateActivity gestureCreateActivity = GestureCreateActivity.this;
        HomeActivity.B(gestureCreateActivity);
        EventBus.b().e(new EventHomeAct());
        gestureCreateActivity.finish();
        KtakilatApplication.m.getClass();
        KtakilatApplication.d();
    }
}
