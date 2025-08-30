package com.ktakilat.loan.verify_face;

import android.content.Intent;
import com.ktakilat.loan.R;

public class ModifyPwdVerifyFaceActivity extends BaseVerifyFaceActivity {
    public static final /* synthetic */ int u = 0;
    public int t;

    public final Intent C(Intent intent) {
        intent.putExtra("processType", this.t);
        return intent;
    }

    public final String H() {
        return getString(R.string.application_name);
    }

    public final void I(String str) {
        VerifyMgr.g(this.q, this.t, this, str, this.r);
    }

    public final void J(Intent intent) {
        this.t = intent.getIntExtra("processType", -1);
    }
}
