package defpackage;

import android.view.View;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.loan.login_pwd.LoginPwdActivity;
import com.ktakilat.loan.login_pwd.b;
import com.ktakilat.loan.weiget.GpsUtil;

/* renamed from: dc  reason: default package */
public final /* synthetic */ class dc implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ LoginPwdActivity d;

    public /* synthetic */ dc(LoginPwdActivity loginPwdActivity, int i) {
        this.c = i;
        this.d = loginPwdActivity;
    }

    public final void onClick(View view) {
        LoginPwdActivity loginPwdActivity = this.d;
        switch (this.c) {
            case 0:
                int i = LoginPwdActivity.r;
                loginPwdActivity.getClass();
                KtaCollect.n_login_password_clc_back();
                loginPwdActivity.finish();
                return;
            default:
                int i2 = LoginPwdActivity.r;
                loginPwdActivity.getClass();
                KtaCollect.n_login_password_clc_login();
                GpsUtil.b(loginPwdActivity, new b(loginPwdActivity));
                return;
        }
    }
}
