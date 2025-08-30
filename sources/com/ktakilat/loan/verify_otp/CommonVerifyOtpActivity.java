package com.ktakilat.loan.verify_otp;

import android.content.Intent;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.verify_face.VerifyMgr;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ktakilat/loan/verify_otp/CommonVerifyOtpActivity;", "Lcom/ktakilat/loan/verify_otp/BaseVerifyOtpActivity;", "<init>", "()V", "Companion", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonVerifyOtpActivity extends BaseVerifyOtpActivity {
    public static final /* synthetic */ int x = 0;
    public int w = -1;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ktakilat/loan/verify_otp/CommonVerifyOtpActivity$Companion;", "", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
    }

    public final Intent C(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("processType", 109);
        return intent;
    }

    public final void F() {
    }

    public final void G(int i) {
    }

    public final void H(boolean z) {
    }

    public final PhoneCodeType J() {
        return new PhoneCodeType(this.w);
    }

    public final String L() {
        String string = getString(R.string.application_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final void O(String str) {
        VerifyMgr.e(this, str, this.n, this.o);
    }

    public final void P(Intent intent) {
        int i = 0;
        if (intent != null) {
            i = intent.getIntExtra("SMS_TYPE", 0);
        }
        this.w = i;
    }

    public final void Q() {
    }

    public final void S() {
        KtaCollect.n_type_otp_sms_auto("19");
    }

    public final void T() {
    }
}
