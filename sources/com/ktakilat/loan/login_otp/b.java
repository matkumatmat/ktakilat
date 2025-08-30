package com.ktakilat.loan.login_otp;

import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.http.user.OtpTypeEnum;
import com.ktakilat.loan.login_otp.LoginOtpActivity;
import com.ktakilat.loan.weiget.dialog.DialogUtils;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ LoginOtpActivity.AnonymousClass3 c;
    public final /* synthetic */ LoginOtpActivity d;

    public /* synthetic */ b(LoginOtpActivity.AnonymousClass3 r1, LoginOtpActivity loginOtpActivity) {
        this.c = r1;
        this.d = loginOtpActivity;
    }

    public final void run() {
        LoginOtpActivity.AnonymousClass3 r0 = this.c;
        r0.getClass();
        boolean z = LoginOtpActivity.t;
        LoginOtpActivity loginOtpActivity = LoginOtpActivity.this;
        if (z && LoginOtpActivity.u) {
            DialogUtils.g(this.d, loginOtpActivity.p, new c(r0, 0), new c(r0, 1));
        } else if (LoginOtpActivity.u) {
            OtpTypeEnum otpTypeEnum = OtpTypeEnum.WA;
            loginOtpActivity.F(otpTypeEnum);
            LoginOtpPresenter loginOtpPresenter = loginOtpActivity.n;
            loginOtpPresenter.c.a(loginOtpActivity.p, PhoneCodeType.LOGIN, otpTypeEnum);
        } else {
            OtpTypeEnum otpTypeEnum2 = OtpTypeEnum.NORMAL;
            loginOtpActivity.F(otpTypeEnum2);
            LoginOtpPresenter loginOtpPresenter2 = loginOtpActivity.n;
            String str = loginOtpActivity.p;
            loginOtpPresenter2.getClass();
            loginOtpPresenter2.c.a(str, PhoneCodeType.LOGIN, otpTypeEnum2);
        }
    }
}
