package defpackage;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.input_code.InputCodeActivity;
import com.ktakilat.loan.input_mobile.InputMobileActivity;
import com.ktakilat.loan.input_pwd.InputPwdActivity;
import com.ktakilat.loan.login_otp.LoginOtpActivity;
import com.ktakilat.loan.login_pwd.LoginPwdActivity;
import com.ktakilat.loan.mobile_check.MobileCheckV2Activity;
import com.ktakilat.loan.normal_ui.GoogleMapActivity;
import com.ktakilat.loan.normal_ui.SearchAddressActivity;
import com.ktakilat.loan.regist_otp.RegistOtpActivity;

/* renamed from: y9  reason: default package */
public final /* synthetic */ class y9 implements View.OnClickListener {
    public final /* synthetic */ int c;

    public /* synthetic */ y9(int i) {
        this.c = i;
    }

    public final void onClick(View view) {
        switch (this.c) {
            case 0:
                int i = GoogleMapActivity.q;
                KtaCollect.n_google_address_clc_address();
                return;
            case 1:
                int i2 = InputCodeActivity.r;
                KtaCollect.n_change_pho_type_otp();
                return;
            case 2:
                int i3 = InputMobileActivity.o;
                KtaCollect.n_change_pho_update_pho_clc_type();
                return;
            case 3:
                int i4 = InputPwdActivity.p;
                KtaCollect.n_change_pho_pwd_page_type_pwd();
                return;
            case 4:
                boolean z = LoginOtpActivity.t;
                KtaCollect.n_login_otp_tybe_otp();
                return;
            case 5:
                int i5 = LoginPwdActivity.r;
                KtaCollect.n_login_password_type_password();
                return;
            case 6:
                int i6 = MobileCheckV2Activity.g;
                KtaCollect.n_ojk_disclaimer_pop_up(ExifInterface.GPS_MEASUREMENT_2D);
                KtakilatApplication.m.getClass();
                KtakilatApplication.c();
                return;
            case 7:
                int i7 = MobileCheckV2Activity.g;
                KtaCollect.n_phone_judge_page_type_phone();
                return;
            case 8:
                int i8 = RegistOtpActivity.s;
                KtaCollect.n_register_otp_page_type_otp();
                return;
            default:
                int i9 = SearchAddressActivity.t;
                KtaCollect.n_company_search_clc_type();
                return;
        }
    }
}
