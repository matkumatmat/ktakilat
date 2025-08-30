package defpackage;

import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.login_face.LoginFaceActivity;

/* renamed from: zb  reason: default package */
public final /* synthetic */ class zb implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ LoginFaceActivity d;

    public /* synthetic */ zb(LoginFaceActivity loginFaceActivity, int i) {
        this.c = i;
        this.d = loginFaceActivity;
    }

    public final void run() {
        LoginFaceActivity loginFaceActivity = this.d;
        switch (this.c) {
            case 0:
                int i = LoginFaceActivity.r;
                loginFaceActivity.d.hide();
                return;
            case 1:
                int i2 = LoginFaceActivity.r;
                loginFaceActivity.d.hide();
                return;
            case 2:
                int i3 = LoginFaceActivity.r;
                loginFaceActivity.d.hide();
                return;
            default:
                int i4 = LoginFaceActivity.r;
                loginFaceActivity.getClass();
                ToastUtil.b(loginFaceActivity, R.string.liveness_retry_toast);
                return;
        }
    }
}
