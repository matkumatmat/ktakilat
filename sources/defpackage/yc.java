package defpackage;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.new_pwd.NewPasswordActivity;
import com.ktakilat.loan.new_pwd.NewPasswordViewModel;
import com.ktakilat.loan.new_pwd.NewPasswordViewModel$updatePassword$1;
import com.trello.rxlifecycle2.LifecycleTransformer;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: yc  reason: default package */
public final /* synthetic */ class yc implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ NewPasswordActivity d;

    public /* synthetic */ yc(NewPasswordActivity newPasswordActivity, int i) {
        this.c = i;
        this.d = newPasswordActivity;
    }

    public final void onClick(View view) {
        NewPasswordActivity newPasswordActivity = this.d;
        switch (this.c) {
            case 0:
                int i = NewPasswordActivity.f;
                NewPasswordViewModel o = newPasswordActivity.o();
                if (((MutableLiveData) o.c.getValue()).getValue() != null) {
                    Lazy lazy = o.c;
                    Object value = ((MutableLiveData) lazy.getValue()).getValue();
                    Intrinsics.c(value);
                    ((MutableLiveData) lazy.getValue()).setValue(Boolean.valueOf(!((Boolean) value).booleanValue()));
                    return;
                }
                return;
            default:
                int i2 = NewPasswordActivity.f;
                KtaCollect.n_set_password_clc_submit();
                String obj = newPasswordActivity.n().newPassword.getText().toString();
                NewPasswordViewModel o2 = newPasswordActivity.o();
                String str = newPasswordActivity.d;
                if (str != null) {
                    o2.getClass();
                    Intrinsics.checkNotNullParameter(obj, "password");
                    Intrinsics.checkNotNullParameter(str, "token");
                    ((MutableLiveData) o2.d.getValue()).setValue(Boolean.TRUE);
                    AppHttp.userSetPasswordNeedLogin((LifecycleTransformer<BaseResponse<Boolean>>) null, str, obj, (String) null).subscribe(new NewPasswordViewModel$updatePassword$1(o2));
                    return;
                }
                Intrinsics.k("token");
                throw null;
        }
    }
}
