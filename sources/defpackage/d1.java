package defpackage;

import android.content.DialogInterface;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseDialog;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpActivity;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpSms;

/* renamed from: d1  reason: default package */
public final /* synthetic */ class d1 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ int c = 0;
    public final /* synthetic */ Object d;

    public /* synthetic */ d1(u9 u9Var, BaseDialog baseDialog) {
        this.d = u9Var;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        Object obj = this.d;
        switch (this.c) {
            case 0:
                BaseVerifyOtpSms baseVerifyOtpSms = BaseVerifyOtpActivity.s;
                KtaCollect.n_safe_auth_otp_select_popup_cancel(((BaseVerifyOtpActivity) obj).K());
                return;
            default:
                ((u9) obj).getClass();
                KtaCollect.n_pattern_guide_clc_cancel();
                return;
        }
    }

    public /* synthetic */ d1(BaseVerifyOtpActivity baseVerifyOtpActivity) {
        this.d = baseVerifyOtpActivity;
    }
}
