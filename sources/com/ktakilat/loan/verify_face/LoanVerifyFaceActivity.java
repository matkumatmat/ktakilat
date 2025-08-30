package com.ktakilat.loan.verify_face;

import android.content.Intent;
import com.google.logging.type.LogSeverity;
import com.ktakilat.loan.R;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpActivity;
import com.ktakilat.loan.verify_otp.LoanVerifyOtpActivity;
import java.util.ArrayList;

public class LoanVerifyFaceActivity extends BaseVerifyFaceActivity {
    public static final /* synthetic */ int t = 0;

    public final Intent C(Intent intent) {
        intent.putExtra("processType", 108);
        return intent;
    }

    public final String H() {
        return getString(R.string.application_name);
    }

    public final void I(String str) {
        int i = this.q;
        ArrayList arrayList = this.r;
        Class<LoanVerifyOtpActivity> cls = LoanVerifyOtpActivity.class;
        if (VerifyMgr.b(cls)) {
            finish();
        } else {
            startActivityForResult(BaseVerifyOtpActivity.I(this, cls, str, i, new ArrayList(arrayList)), LogSeverity.EMERGENCY_VALUE);
        }
    }

    public final void J(Intent intent) {
    }
}
