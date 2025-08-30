package com.ktakilat.loan.verify_face;

import android.content.Intent;
import com.ktakilat.loan.R;

public class SafeVerifyFaceActivity extends BaseVerifyFaceActivity {
    public static final /* synthetic */ int u = 0;
    public boolean t = false;

    public final Intent C(Intent intent) {
        intent.putExtra("processType", 106);
        intent.putExtra("safe_device", this.t);
        return intent;
    }

    public final String H() {
        return getString(R.string.application_name);
    }

    public final void I(String str) {
        VerifyMgr.i(this, str, this.q, this.r, this.t);
    }

    public final void J(Intent intent) {
        this.t = intent.getBooleanExtra("safe_device", true);
    }
}
