package com.ktakilat.loan.reset_pwd;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.WindowInsetsCompat;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.BarUtil;
import com.ktakilat.cbase.utils.KeybordUtils;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.main.EventHomeAct;
import com.ktakilat.loan.main.HomeActivity;
import com.ktakilat.loan.reset_pwd.ResetPwdContact;
import com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;
import com.ktakilat.loan.weiget.PwdHideShowUtil;
import com.pendanaan.kta.databinding.ActivityResetPwdBinding;
import org.greenrobot.eventbus.EventBus;

@SuppressLint({"NonConstantResourceId"})
public class ResetPwdActivity extends BaseActivity implements ResetPwdContact.View {
    public static final /* synthetic */ int n = 0;
    public ResetPwdPresenter i;
    public boolean j = false;
    public final FaceLoginOnOffUtil k = new FaceLoginOnOffUtil(this);
    public ActivityResetPwdBinding l;
    public boolean m = false;

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 500) {
            z();
        } else if (i2 == 10001) {
            z();
        } else if (i2 == 20000 && this.m) {
            this.k.l(FaceLoginOnOffUtil.ScenceEnum.EDIT_PWD_SUC, new ce(this));
        }
    }

    public final void onBackPressed() {
        int i2;
        if (this.j) {
            i2 = -1;
        } else {
            i2 = 0;
        }
        setResult(i2);
        super.onBackPressed();
    }

    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.Object, com.ktakilat.loan.reset_pwd.ResetPwdPresenter] */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityResetPwdBinding inflate = ActivityResetPwdBinding.inflate(getLayoutInflater());
        this.l = inflate;
        setContentView((View) inflate.getRoot());
        ? obj = new Object();
        obj.f541a = this;
        this.i = obj;
        this.l.pageTitle.title.setText(R.string.reset_password);
        this.l.pageTitle.backward.setOnClickListener(new t0(this, 13));
        this.l.passSubmit.setOnClickListener(new a(this));
        String string = AppKv.g().f465a.getString("commonconfigkey_password_verification_key", "");
        if (!TextUtils.isEmpty(string)) {
            this.l.tvSetPassWordTip.setText(string);
        }
        ActivityResetPwdBinding activityResetPwdBinding = this.l;
        PwdHideShowUtil.a(activityResetPwdBinding.edtPassword, activityResetPwdBinding.showPassword, R.drawable.visibility_off_rounded, R.drawable.visibility_rounded);
        ActivityResetPwdBinding activityResetPwdBinding2 = this.l;
        PwdHideShowUtil.a(activityResetPwdBinding2.edtPassword2, activityResetPwdBinding2.showPassword2, R.drawable.visibility_off_rounded, R.drawable.visibility_rounded);
        this.l.edtPassword.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                boolean z;
                ResetPwdActivity resetPwdActivity = ResetPwdActivity.this;
                AppCompatButton appCompatButton = resetPwdActivity.l.passSubmit;
                if (charSequence.length() < 6 || resetPwdActivity.l.edtPassword2.getText().toString().length() < 6) {
                    z = false;
                } else {
                    z = true;
                }
                appCompatButton.setEnabled(z);
            }
        });
        this.l.edtPassword2.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                boolean z;
                ResetPwdActivity resetPwdActivity = ResetPwdActivity.this;
                AppCompatButton appCompatButton = resetPwdActivity.l.passSubmit;
                if (charSequence.length() < 6 || resetPwdActivity.l.edtPassword.getText().toString().length() < 6) {
                    z = false;
                } else {
                    z = true;
                }
                appCompatButton.setEnabled(z);
            }
        });
        KeybordUtils.c(this.l.edtPassword);
    }

    public final void onDestroy() {
        ResetPwdPresenter resetPwdPresenter = this.i;
        if (resetPwdPresenter != null) {
            resetPwdPresenter.getClass();
        }
        ChangeMobileAndForgotPwdTmpLoginUtil.a();
        super.onDestroy();
    }

    public final int r() {
        return WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.navigationBars();
    }

    public final void v() {
        BarUtil.a(this, R.drawable.scaffold_white);
    }

    public final void z() {
        this.m = false;
        HomeActivity.B(this);
        EventBus.b().e(new EventHomeAct());
        finish();
        KtakilatApplication.m.getClass();
        KtakilatApplication.d();
    }
}
