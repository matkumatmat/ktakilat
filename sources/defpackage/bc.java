package defpackage;

import com.ktakilat.loan.R;
import com.ktakilat.loan.face_login_onoff.FaceLoginOnOffActivity;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.login_face.LoginFaceActivity;
import com.ktakilat.loan.weiget.GestureUtil;
import com.ktakilat.loan.weiget.WebCookieManager;
import com.ktakilat.loan.weiget.dialog.DialogUtils;

/* renamed from: bc  reason: default package */
public final /* synthetic */ class bc implements WebCookieManager.CookieCallback, DialogUtils.CommonOkClickListern, FaceLoginOnOffActivity.PermissionCallback {
    public final /* synthetic */ int c;
    public final /* synthetic */ LoginFaceActivity d;

    public /* synthetic */ bc(LoginFaceActivity loginFaceActivity, int i) {
        this.c = i;
        this.d = loginFaceActivity;
    }

    public void b() {
        this.d.q.moreTv.performClick();
    }

    public void c(boolean z) {
        int i = LoginFaceActivity.r;
        LoginFaceActivity loginFaceActivity = this.d;
        if (!z) {
            DialogUtils.h(loginFaceActivity, loginFaceActivity.getText(R.string.camera).toString(), (DialogUtils.SettingStatusCall) null);
        } else {
            loginFaceActivity.getClass();
        }
    }

    public void d() {
        LoginFaceActivity loginFaceActivity = this.d;
        switch (this.c) {
            case 0:
                int i = LoginFaceActivity.r;
                loginFaceActivity.getClass();
                if (!AppKv.j().contains("5")) {
                    loginFaceActivity.A(GestureUtil.GestureSetEnum.LOGIN_FACE);
                    return;
                } else {
                    loginFaceActivity.B();
                    return;
                }
            default:
                int i2 = LoginFaceActivity.r;
                loginFaceActivity.getClass();
                if (!AppKv.j().contains("5")) {
                    loginFaceActivity.A(GestureUtil.GestureSetEnum.LOGIN_FACE);
                    return;
                } else {
                    loginFaceActivity.B();
                    return;
                }
        }
    }
}
