package com.ktakilat.loan.verify_otp;

import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.verify_face.VerifyMgr;

public class ModifyPwdVerifyOtpActivity extends BaseVerifyOtpActivity {
    public static final /* synthetic */ int x = 0;
    public int w;

    public final Intent C(Intent intent) {
        intent.putExtra("processType", this.w);
        return intent;
    }

    public final void F() {
        KtaCollect.n_forget_pwd_otp_clc_back();
    }

    public final void G(int i) {
        if (i >= 2) {
            ToastUtil.c(this, R.string.forget_pwd_input_code_resend_tip);
        }
        KtaCollect.n_forget_pwd_otp_retry();
    }

    public final void H(boolean z) {
        if (z) {
            KtaCollect.n_forget_pwd_otp_type();
        }
    }

    public final PhoneCodeType J() {
        KtakilatApplication.m.getClass();
        if (KtakilatApplication.h()) {
            return PhoneCodeType.EDIT_PWD;
        }
        return PhoneCodeType.FORGET_PWD;
    }

    public final String L() {
        return getString(R.string.application_name);
    }

    public final void O(String str) {
        VerifyMgr.f(this.n, this.w, this, str, this.o);
    }

    public final void P(Intent intent) {
        this.w = intent.getIntExtra("processType", -1);
    }

    public final void Q() {
        KtaCollect.n_forget_pwd_otp_clc_commit(AppEventsConstants.EVENT_PARAM_VALUE_YES);
    }

    public final void S() {
        KtaCollect.n_type_otp_sms_auto("9");
    }

    public final void T() {
        int i = this.w;
        if (i == 101 || i == 102) {
            KtaCollect.n_forget_pwd_otp_exposure(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else {
            KtaCollect.n_forget_pwd_otp_exposure(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }
}
