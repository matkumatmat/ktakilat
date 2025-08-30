package defpackage;

import android.view.View;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.loan.input_code.InputCodeActivity;
import com.ktakilat.loan.input_pwd.InputPwdActivity;
import com.ktakilat.loan.login_otp.LoginOtpActivity;
import com.ktakilat.loan.login_pwd.LoginPwdActivity;
import com.ktakilat.loan.mobile_check.MobileCheckV2Activity;
import com.ktakilat.loan.new_pwd.NewPasswordActivity;
import com.ktakilat.loan.normal_ui.GoogleMapActivity;
import com.ktakilat.loan.regist_otp.RegistOtpActivity;

/* renamed from: w9  reason: default package */
public final /* synthetic */ class w9 implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f843a;

    public /* synthetic */ w9(int i) {
        this.f843a = i;
    }

    public final void onFocusChange(View view, boolean z) {
        switch (this.f843a) {
            case 0:
                int i = GoogleMapActivity.q;
                if (z) {
                    KtaCollect.n_google_address_clc_address();
                    return;
                }
                return;
            case 1:
                int i2 = InputCodeActivity.r;
                if (z) {
                    KtaCollect.n_change_pho_type_otp();
                    return;
                }
                return;
            case 2:
                int i3 = InputPwdActivity.p;
                if (z) {
                    KtaCollect.n_change_pho_pwd_page_type_pwd();
                    return;
                }
                return;
            case 3:
                boolean z2 = LoginOtpActivity.t;
                if (z) {
                    KtaCollect.n_login_otp_tybe_otp();
                    return;
                }
                return;
            case 4:
                int i4 = LoginPwdActivity.r;
                if (z) {
                    KtaCollect.n_login_password_type_password();
                    return;
                }
                return;
            case 5:
                int i5 = MobileCheckV2Activity.g;
                if (z) {
                    KtaCollect.n_phone_judge_page_type_phone();
                    return;
                }
                return;
            case 6:
                int i6 = NewPasswordActivity.f;
                if (z) {
                    KtaCollect.n_set_password_clc_input();
                    return;
                }
                return;
            default:
                int i7 = RegistOtpActivity.s;
                if (z) {
                    KtaCollect.n_register_otp_page_type_otp();
                    return;
                }
                return;
        }
    }
}
