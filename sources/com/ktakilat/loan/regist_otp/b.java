package com.ktakilat.loan.regist_otp;

import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.http.user.OtpTypeEnum;
import com.ktakilat.loan.regist_otp.RegistOtpActivity;
import com.ktakilat.loan.weiget.dialog.DialogUtils;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ RegistOtpActivity.AnonymousClass3 c;
    public final /* synthetic */ RegistOtpActivity d;

    public /* synthetic */ b(RegistOtpActivity.AnonymousClass3 r1, RegistOtpActivity registOtpActivity) {
        this.c = r1;
        this.d = registOtpActivity;
    }

    public final void run() {
        RegistOtpActivity.AnonymousClass3 r0 = this.c;
        r0.getClass();
        boolean z = RegistOtpActivity.t;
        RegistOtpActivity registOtpActivity = RegistOtpActivity.this;
        if (z && RegistOtpActivity.u) {
            DialogUtils.g(this.d, registOtpActivity.l, new c(r0, 0), new c(r0, 1));
        } else if (RegistOtpActivity.u) {
            OtpTypeEnum otpTypeEnum = OtpTypeEnum.WA;
            registOtpActivity.D(otpTypeEnum);
            RegistOtpPresenter registOtpPresenter = registOtpActivity.i;
            registOtpPresenter.f537a.a(registOtpActivity.l, PhoneCodeType.REGISTER, otpTypeEnum);
        } else {
            OtpTypeEnum otpTypeEnum2 = OtpTypeEnum.NORMAL;
            registOtpActivity.D(otpTypeEnum2);
            RegistOtpPresenter registOtpPresenter2 = registOtpActivity.i;
            String str = registOtpActivity.l;
            registOtpPresenter2.getClass();
            registOtpPresenter2.f537a.a(str, PhoneCodeType.REGISTER, otpTypeEnum2);
        }
    }
}
