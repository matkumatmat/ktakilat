package com.ktakilat.loan.login_gesture;

import android.view.LayoutInflater;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.user.UserLoginResp;
import com.ktakilat.loan.login_gesture.LoginGestureActivity;
import com.ktakilat.loan.verify_face.VerifyMgr;
import com.ktakilat.loan.verify_face.VerifyScence;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;
import com.ktakilat.loan.weiget.GestureUtil;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import com.ktakilat.loan.weiget.gesture.PatternLockerView;
import com.pendanaan.kta.databinding.DialogGestureLimitBinding;

public final /* synthetic */ class b implements GestureUtil.LoginGestureCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginGestureActivity.AnonymousClass1 f517a;

    public /* synthetic */ b(LoginGestureActivity.AnonymousClass1 r1) {
        this.f517a = r1;
    }

    public final void a(boolean z, UserLoginResp userLoginResp, Boolean bool) {
        VerifyScence verifyScence;
        LoginGestureActivity loginGestureActivity = LoginGestureActivity.this;
        PatternLockerView patternLockerView = loginGestureActivity.r.touchView;
        patternLockerView.a();
        patternLockerView.k = false;
        patternLockerView.invalidate();
        if (bool != null) {
            String str = loginGestureActivity.q;
            if (bool.booleanValue()) {
                verifyScence = VerifyScence.SAFE_DEVICE;
            } else {
                verifyScence = VerifyScence.SAFE_PHONE;
            }
            VerifyMgr.j(loginGestureActivity, str, verifyScence);
        } else if (z) {
            DialogGestureLimitBinding inflate = DialogGestureLimitBinding.inflate(LayoutInflater.from(loginGestureActivity));
            DialogUtils.b(loginGestureActivity, inflate.getRoot(), inflate.nextTv, new lb(loginGestureActivity, 4), (u9) null).show();
        } else if (userLoginResp == null) {
        } else {
            if (!AppKv.j().contains("4")) {
                loginGestureActivity.z(FaceLoginOnOffUtil.ScenceEnum.LOGIN_GESTURE);
            } else {
                loginGestureActivity.B();
            }
        }
    }
}
