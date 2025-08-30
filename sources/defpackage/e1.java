package defpackage;

import android.view.View;
import android.widget.EditText;
import com.ktakilat.loan.normal_ui.SearchAddressActivity;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpActivity;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpSms;

/* renamed from: e1  reason: default package */
public final /* synthetic */ class e1 implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f650a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e1(Object obj, int i) {
        this.f650a = i;
        this.b = obj;
    }

    public final void onFocusChange(View view, boolean z) {
        Object obj = this.b;
        switch (this.f650a) {
            case 0:
                BaseVerifyOtpSms baseVerifyOtpSms = BaseVerifyOtpActivity.s;
                ((BaseVerifyOtpActivity) obj).H(z);
                return;
            case 1:
                x4.a((EditText[]) obj, view, z);
                return;
            default:
                int i = SearchAddressActivity.t;
                ((SearchAddressActivity) obj).getClass();
                return;
        }
    }
}
