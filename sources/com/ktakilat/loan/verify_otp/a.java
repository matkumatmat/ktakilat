package com.ktakilat.loan.verify_otp;

import com.ktakilat.loan.verify_face.VerifyType;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpActivity;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import java.util.ArrayList;

public final /* synthetic */ class a implements DialogUtils.SingleSelectCallback {
    public final /* synthetic */ BaseVerifyOtpActivity c;
    public final /* synthetic */ ArrayList d;

    public /* synthetic */ a(BaseVerifyOtpActivity baseVerifyOtpActivity, ArrayList arrayList) {
        this.c = baseVerifyOtpActivity;
        this.d = arrayList;
    }

    public final void a(int i, String str) {
        BaseVerifyOtpSms baseVerifyOtpSms = BaseVerifyOtpActivity.s;
        BaseVerifyOtpActivity baseVerifyOtpActivity = this.c;
        baseVerifyOtpActivity.getClass();
        if (BaseVerifyOtpActivity.AnonymousClass4.b[((VerifyType) this.d.get(i)).ordinal()] == 1) {
            baseVerifyOtpActivity.O(baseVerifyOtpActivity.m);
        }
    }
}
