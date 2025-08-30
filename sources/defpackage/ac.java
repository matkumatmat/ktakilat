package defpackage;

import com.ktakilat.loan.face_login_onoff.FaceLoginOnOffActivity;
import com.ktakilat.loan.login_face.LoginFaceActivity;
import com.ktakilat.loan.utils.TrustLivenessUtil;
import kotlin.jvm.functions.Function0;

/* renamed from: ac  reason: default package */
public final /* synthetic */ class ac implements Function0 {
    public final /* synthetic */ int c;
    public final /* synthetic */ LoginFaceActivity d;

    public /* synthetic */ ac(LoginFaceActivity loginFaceActivity, int i) {
        this.c = i;
        this.d = loginFaceActivity;
    }

    public final Object invoke() {
        LoginFaceActivity loginFaceActivity = this.d;
        switch (this.c) {
            case 0:
                int i = LoginFaceActivity.r;
                loginFaceActivity.getClass();
                loginFaceActivity.runOnUiThread(new zb(loginFaceActivity, 3));
                return null;
            case 1:
                int i2 = LoginFaceActivity.r;
                loginFaceActivity.getClass();
                loginFaceActivity.runOnUiThread(new zb(loginFaceActivity, 0));
                loginFaceActivity.d.show();
                TrustLivenessUtil.Companion.b(loginFaceActivity, new z0(loginFaceActivity, 3), new ac(loginFaceActivity, 0));
                return null;
            default:
                FaceLoginOnOffActivity.A(10000, loginFaceActivity, new bc(loginFaceActivity, 3), loginFaceActivity.p, "face_login");
                return null;
        }
    }
}
