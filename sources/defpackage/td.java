package defpackage;

import android.view.View;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.http.user.OtpTypeEnum;
import com.ktakilat.loan.regist_otp.RegistOtpActivity;
import com.ktakilat.loan.regist_otp.RegistOtpPresenter;
import com.ktakilat.loan.regist_otp.a;
import com.ktakilat.loan.weiget.GpsUtil;

/* renamed from: td  reason: default package */
public final /* synthetic */ class td implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ RegistOtpActivity d;

    public /* synthetic */ td(RegistOtpActivity registOtpActivity, int i) {
        this.c = i;
        this.d = registOtpActivity;
    }

    public final void onClick(View view) {
        int i;
        RegistOtpActivity registOtpActivity = this.d;
        switch (this.c) {
            case 0:
                int i2 = RegistOtpActivity.s;
                registOtpActivity.getClass();
                KtaCollect.n_register_otp_page_clc_switch(2);
                registOtpActivity.r.changeAnotherOtp.setVisibility(8);
                RegistOtpPresenter registOtpPresenter = registOtpActivity.i;
                String str = registOtpActivity.l;
                OtpTypeEnum otpTypeEnum = OtpTypeEnum.WA;
                registOtpPresenter.f537a.a(str, PhoneCodeType.REGISTER, otpTypeEnum);
                registOtpActivity.D(otpTypeEnum);
                return;
            case 1:
                int i3 = RegistOtpActivity.s;
                registOtpActivity.getClass();
                KtaCollect.n_register_otp_page_clc_back();
                registOtpActivity.finish();
                return;
            case 2:
                int i4 = RegistOtpActivity.s;
                registOtpActivity.getClass();
                int i5 = RegistOtpActivity.s;
                if (i5 < Integer.MAX_VALUE) {
                    RegistOtpActivity.s = i5 + 1;
                }
                if (RegistOtpActivity.s >= 2 && ((i = registOtpActivity.m) == 301 || i == 302)) {
                    ToastUtil.c(registOtpActivity, R.string.forget_pwd_input_code_resend_tip);
                }
                KtaCollect.n_register_otp_page_clc_resend();
                RegistOtpActivity.v = null;
                registOtpActivity.r.changeAnotherOtp.setVisibility(8);
                registOtpActivity.B();
                return;
            case 3:
                int i6 = RegistOtpActivity.s;
                registOtpActivity.getClass();
                KtaCollect.n_register_otp_page_clc_continue();
                GpsUtil.b(registOtpActivity, new a(registOtpActivity));
                return;
            default:
                int i7 = RegistOtpActivity.s;
                registOtpActivity.getClass();
                KtaCollect.n_register_otp_page_clc_switch(1);
                registOtpActivity.r.changeAnotherOtp.setVisibility(8);
                RegistOtpPresenter registOtpPresenter2 = registOtpActivity.i;
                String str2 = registOtpActivity.l;
                OtpTypeEnum otpTypeEnum2 = OtpTypeEnum.NORMAL;
                registOtpPresenter2.f537a.a(str2, PhoneCodeType.REGISTER, otpTypeEnum2);
                registOtpActivity.D(otpTypeEnum2);
                return;
        }
    }
}
