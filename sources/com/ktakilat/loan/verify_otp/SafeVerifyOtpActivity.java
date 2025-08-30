package com.ktakilat.loan.verify_otp;

import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.verify_face.VerifyMgr;

public class SafeVerifyOtpActivity extends BaseVerifyOtpActivity {
    public static final /* synthetic */ int x = 0;
    public boolean w = false;

    public final Intent C(Intent intent) {
        intent.putExtra("processType", 106);
        intent.putExtra("safe_device", this.w);
        return intent;
    }

    public final void F() {
        KtaCollect.n_forget_pwd_otp_clc_back();
    }

    public final void G(int i) {
        if (i >= 2) {
            ToastUtil.c(this, R.string.forget_pwd_input_code_resend_tip);
        }
    }

    public final void H(boolean z) {
    }

    public final PhoneCodeType J() {
        KtakilatApplication.m.getClass();
        if (KtakilatApplication.h()) {
            return PhoneCodeType.DEVICE_CHANGE_PHONE_VEIRIFY;
        }
        return PhoneCodeType.FORGET_PWD;
    }

    public final String L() {
        return getString(R.string.application_name);
    }

    public final void O(String str) {
        VerifyMgr.h(this, str, this.n, this.o, this.w);
    }

    public final void P(Intent intent) {
        this.w = intent.getBooleanExtra("safe_device", true);
    }

    public final void Q() {
    }

    public final void S() {
        KtaCollect.n_type_otp_sms_auto(ExifInterface.GPS_MEASUREMENT_2D);
    }

    public final void T() {
    }
}
