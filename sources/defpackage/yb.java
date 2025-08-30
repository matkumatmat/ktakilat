package defpackage;

import android.view.View;
import com.ktakilat.cbase.utils.FastClickUtil;
import com.ktakilat.loan.login_face.LoginFaceActivity;
import com.ktakilat.loan.utils.TrustLivenessUtil;

/* renamed from: yb  reason: default package */
public final /* synthetic */ class yb implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ LoginFaceActivity d;

    public /* synthetic */ yb(LoginFaceActivity loginFaceActivity, int i) {
        this.c = i;
        this.d = loginFaceActivity;
    }

    public final void onClick(View view) {
        LoginFaceActivity loginFaceActivity = this.d;
        switch (this.c) {
            case 0:
                int i = LoginFaceActivity.r;
                loginFaceActivity.finish();
                return;
            default:
                int i2 = LoginFaceActivity.r;
                loginFaceActivity.getClass();
                if (FastClickUtil.a(view)) {
                    loginFaceActivity.d.show();
                    TrustLivenessUtil.Companion.a(new ac(loginFaceActivity, 1), new ac(loginFaceActivity, 2));
                    return;
                }
                return;
        }
    }
}
