package defpackage;

import android.view.View;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.utils.FastClickUtil;
import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.http.user.OtpTypeEnum;
import com.ktakilat.loan.login_otp.LoginOtpActivity;
import com.ktakilat.loan.login_otp.LoginOtpPresenter;
import com.ktakilat.loan.login_otp.a;
import com.ktakilat.loan.weiget.GpsUtil;

/* renamed from: cc  reason: default package */
public final /* synthetic */ class cc implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ LoginOtpActivity d;

    public /* synthetic */ cc(LoginOtpActivity loginOtpActivity, int i) {
        this.c = i;
        this.d = loginOtpActivity;
    }

    public final void onClick(View view) {
        LoginOtpActivity loginOtpActivity = this.d;
        switch (this.c) {
            case 0:
                boolean z = LoginOtpActivity.t;
                loginOtpActivity.getClass();
                KtaCollect.n_login_otp_clc_switch(2);
                loginOtpActivity.s.changeAnotherOtp.setVisibility(8);
                LoginOtpPresenter loginOtpPresenter = loginOtpActivity.n;
                String str = loginOtpActivity.p;
                OtpTypeEnum otpTypeEnum = OtpTypeEnum.WA;
                loginOtpPresenter.c.a(str, PhoneCodeType.LOGIN, otpTypeEnum);
                loginOtpActivity.F(otpTypeEnum);
                return;
            case 1:
                boolean z2 = LoginOtpActivity.t;
                loginOtpActivity.getClass();
                KtaCollect.n_login_otp_clc_back();
                loginOtpActivity.finish();
                return;
            case 2:
                boolean z3 = LoginOtpActivity.t;
                loginOtpActivity.getClass();
                if (FastClickUtil.a(view)) {
                    if (!loginOtpActivity.q) {
                        KtaCollect.n_login_otp_clc_obtain_otp();
                    } else {
                        KtaCollect.n_login_otp_clc_resend();
                    }
                    LoginOtpActivity.v = null;
                    loginOtpActivity.s.changeAnotherOtp.setVisibility(8);
                    loginOtpActivity.E();
                    return;
                }
                return;
            case 3:
                boolean z4 = LoginOtpActivity.t;
                loginOtpActivity.getClass();
                if (FastClickUtil.a(view)) {
                    KtaCollect.n_login_otp_clc_login();
                    GpsUtil.b(loginOtpActivity, new a(loginOtpActivity));
                    return;
                }
                return;
            default:
                boolean z5 = LoginOtpActivity.t;
                loginOtpActivity.getClass();
                KtaCollect.n_login_otp_clc_switch(1);
                loginOtpActivity.s.changeAnotherOtp.setVisibility(8);
                LoginOtpPresenter loginOtpPresenter2 = loginOtpActivity.n;
                String str2 = loginOtpActivity.p;
                OtpTypeEnum otpTypeEnum2 = OtpTypeEnum.NORMAL;
                loginOtpPresenter2.c.a(str2, PhoneCodeType.LOGIN, otpTypeEnum2);
                loginOtpActivity.F(otpTypeEnum2);
                return;
        }
    }
}
