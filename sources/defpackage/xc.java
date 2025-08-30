package defpackage;

import android.graphics.drawable.Drawable;
import android.widget.EditText;
import androidx.appcompat.content.res.AppCompatResources;
import com.ktakilat.loan.R;
import com.ktakilat.loan.new_pwd.NewPasswordActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: xc  reason: default package */
public final /* synthetic */ class xc implements Function1 {
    public final /* synthetic */ int c;
    public final /* synthetic */ NewPasswordActivity d;

    public /* synthetic */ xc(NewPasswordActivity newPasswordActivity, int i) {
        this.c = i;
        this.d = newPasswordActivity;
    }

    public final Object invoke(Object obj) {
        Drawable drawable;
        int i;
        NewPasswordActivity newPasswordActivity = this.d;
        switch (this.c) {
            case 0:
                int i2 = NewPasswordActivity.f;
                newPasswordActivity.n().nextOperation.setEnabled(((Boolean) obj).booleanValue());
                return Unit.f696a;
            case 1:
                int i3 = NewPasswordActivity.f;
                newPasswordActivity.n().newPasswordHint.setText((String) obj);
                return Unit.f696a;
            case 2:
                int i4 = NewPasswordActivity.f;
                if (((Boolean) obj).booleanValue()) {
                    newPasswordActivity.setResult(-1);
                    newPasswordActivity.finish();
                }
                return Unit.f696a;
            case 3:
                int i5 = NewPasswordActivity.f;
                if (((Boolean) obj).booleanValue()) {
                    newPasswordActivity.n().loading.setVisibility(0);
                    newPasswordActivity.n().nextOperation.setEnabled(false);
                    newPasswordActivity.n().newPassword.setEnabled(false);
                    newPasswordActivity.n().visibilityToggle.setEnabled(false);
                } else {
                    newPasswordActivity.n().loading.setVisibility(8);
                    newPasswordActivity.n().nextOperation.setEnabled(true);
                    newPasswordActivity.n().newPassword.setEnabled(true);
                    newPasswordActivity.n().visibilityToggle.setEnabled(true);
                }
                return Unit.f696a;
            default:
                Boolean bool = (Boolean) obj;
                int i6 = NewPasswordActivity.f;
                if (bool.booleanValue()) {
                    drawable = AppCompatResources.getDrawable(newPasswordActivity, R.drawable.visibility_rounded);
                } else {
                    drawable = AppCompatResources.getDrawable(newPasswordActivity, R.drawable.visibility_off_rounded);
                }
                if (drawable != null) {
                    float f = (float) 24;
                    drawable.setBounds(0, 0, (int) (newPasswordActivity.getResources().getDisplayMetrics().density * f), (int) (f * newPasswordActivity.getResources().getDisplayMetrics().density));
                }
                newPasswordActivity.n().visibilityToggle.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                EditText editText = newPasswordActivity.n().newPassword;
                if (bool.booleanValue()) {
                    i = 145;
                } else {
                    i = 129;
                }
                editText.setInputType(i);
                return Unit.f696a;
        }
    }
}
