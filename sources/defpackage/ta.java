package defpackage;

import android.view.View;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.utils.FastClickUtil;
import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.http.user.OtpTypeEnum;
import com.ktakilat.loan.input_code.InputCodeActivity;
import com.ktakilat.loan.input_code.InputCodePresenter;
import com.ktakilat.loan.weiget.PhoneCodeUtil;

/* renamed from: ta  reason: default package */
public final /* synthetic */ class ta implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ InputCodeActivity d;

    public /* synthetic */ ta(InputCodeActivity inputCodeActivity, int i) {
        this.c = i;
        this.d = inputCodeActivity;
    }

    public final void onClick(View view) {
        InputCodeActivity inputCodeActivity = this.d;
        switch (this.c) {
            case 0:
                int i = InputCodeActivity.r;
                inputCodeActivity.finish();
                return;
            default:
                int i2 = InputCodeActivity.r;
                inputCodeActivity.getClass();
                if (FastClickUtil.a(view)) {
                    int i3 = inputCodeActivity.n;
                    if (i3 < Integer.MAX_VALUE) {
                        inputCodeActivity.n = i3 + 1;
                    }
                    KtaCollect.n_change_pho_type_otp_clc_resend();
                    if (inputCodeActivity.k == 3) {
                        InputCodePresenter inputCodePresenter = inputCodeActivity.i;
                        String str = inputCodeActivity.l;
                        PhoneCodeType phoneCodeType = PhoneCodeType.LOAN_EDIT_PHONE_NUM;
                        PhoneCodeUtil phoneCodeUtil = inputCodePresenter.b;
                        phoneCodeUtil.getClass();
                        phoneCodeUtil.a(str, phoneCodeType, OtpTypeEnum.NORMAL);
                        return;
                    }
                    InputCodePresenter inputCodePresenter2 = inputCodeActivity.i;
                    String str2 = inputCodeActivity.l;
                    PhoneCodeType phoneCodeType2 = PhoneCodeType.EDIT_PHONE_NUM;
                    PhoneCodeUtil phoneCodeUtil2 = inputCodePresenter2.b;
                    phoneCodeUtil2.getClass();
                    phoneCodeUtil2.a(str2, phoneCodeType2, OtpTypeEnum.NORMAL);
                    return;
                }
                return;
        }
    }
}
