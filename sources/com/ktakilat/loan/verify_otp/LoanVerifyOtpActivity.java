package com.ktakilat.loan.verify_otp;

import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.verify_face.VerifyMgr;

public class LoanVerifyOtpActivity extends BaseVerifyOtpActivity {
    public static final /* synthetic */ int w = 0;

    public final Intent C(Intent intent) {
        intent.putExtra("processType", 108);
        return intent;
    }

    public final void F() {
    }

    public final void G(int i) {
    }

    public final void H(boolean z) {
    }

    public final PhoneCodeType J() {
        return PhoneCodeType.LOAN_VERIFY;
    }

    public final String L() {
        return getString(R.string.application_name);
    }

    public final void O(String str) {
        VerifyMgr.e(this, str, this.n, this.o);
    }

    public final void P(Intent intent) {
    }

    public final void Q() {
    }

    public final void S() {
        KtaCollect.n_type_otp_sms_auto(ExifInterface.GPS_MEASUREMENT_2D);
    }

    public final void T() {
    }
}
