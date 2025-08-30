package com.ktakilat.loan.input_pwd;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.WindowInsetsCompat;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.BaseDialog;
import com.ktakilat.cbase.ui.OnSafeClickListener;
import com.ktakilat.cbase.utils.KeybordUtils;
import com.ktakilat.loan.R;
import com.ktakilat.loan.input_mobile.InputMobileActivity;
import com.ktakilat.loan.input_pwd.InputPwdContact;
import com.ktakilat.loan.weiget.PwdHideShowUtil;
import com.pendanaan.kta.databinding.ActivityInputPwdBinding;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;

@SuppressLint({"NonConstantResourceId"})
public class InputPwdActivity extends BaseActivity implements InputPwdContact.View {
    public static final /* synthetic */ int p = 0;
    public InputPwdPresenter i;
    public int j;
    public String k;
    public boolean l = false;
    public EditText m;
    public BaseDialog n;
    public ActivityInputPwdBinding o;

    /* renamed from: com.ktakilat.loan.input_pwd.InputPwdActivity$3  reason: invalid class name */
    class AnonymousClass3 implements View.OnFocusChangeListener {
        public final void onFocusChange(View view, boolean z) {
            if (z) {
                KtaCollect.n_change_pho_ektp_pop_type_ektp();
            }
        }
    }

    /* renamed from: com.ktakilat.loan.input_pwd.InputPwdActivity$4  reason: invalid class name */
    class AnonymousClass4 extends OnSafeClickListener {
        public final void a(View view) {
            KtaCollect.n_change_pho_ektp_pop_type_ektp();
        }
    }

    public static void B(Context context, String str, int i2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, InputPwdActivity.class);
            intent.putExtra("oldPhone", str);
            intent.putExtra("inputType", i2);
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, 100);
            } else {
                context.startActivity(intent);
            }
        }
    }

    public final void A() {
        BaseDialog baseDialog = this.n;
        if (baseDialog != null && baseDialog.isShowing()) {
            this.n.dismiss();
        }
        int i2 = this.j;
        Intent intent = new Intent(this, InputMobileActivity.class);
        intent.putExtra("processRequestCode", 100);
        intent.putExtra("inputType", i2);
        startActivityForResult(intent, 100);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100) {
            if (i3 == -1) {
                z = true;
            } else {
                z = false;
            }
            this.l = z;
            if (z) {
                onBackPressed();
            }
        }
    }

    public final void onBackPressed() {
        int i2;
        Intent intent = new Intent();
        if (this.l) {
            i2 = -1;
        } else {
            i2 = 0;
        }
        setResult(i2, intent);
        super.onBackPressed();
    }

    /* JADX WARNING: type inference failed for: r4v4, types: [com.ktakilat.loan.input_pwd.InputPwdPresenter, java.lang.Object] */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityInputPwdBinding inflate = ActivityInputPwdBinding.inflate(getLayoutInflater());
        this.o = inflate;
        setContentView((View) inflate.getRoot());
        ? obj = new Object();
        obj.f504a = this;
        this.i = obj;
        this.j = getIntent().getIntExtra("inputType", 0);
        this.k = getIntent().getStringExtra("oldPhone");
        this.o.pageTitle.title.setText(R.string.application_name);
        ActivityInputPwdBinding activityInputPwdBinding = this.o;
        PwdHideShowUtil.a(activityInputPwdBinding.edtPassword, activityInputPwdBinding.showPassword, R.drawable.icon_pass_gone_gray, R.drawable.icon_pass_visible_gray);
        this.o.edtPassword.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppCompatButton appCompatButton = InputPwdActivity.this.o.passSubmit;
                if (charSequence.length() < 6) {
                    appCompatButton.setEnabled(false);
                } else {
                    appCompatButton.setEnabled(true);
                }
            }
        });
        this.o.edtPassword.setOnFocusChangeListener(new w9(2));
        KeybordUtils.c(this.o.edtPassword);
        KtaCollect.n_change_pho_pwd_page_exp();
        this.o.passSubmit.setOnClickListener(new a(this));
        this.o.pageTitle.backward.setOnClickListener(new t0(this, 8));
        this.o.edtPassword.setOnClickListener(new y9(3));
    }

    public final void onDestroy() {
        KeybordUtils.a(this);
        InputPwdPresenter inputPwdPresenter = this.i;
        if (inputPwdPresenter != null) {
            inputPwdPresenter.getClass();
        }
        super.onDestroy();
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 114 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResume() {
        /*
            r4 = this;
            super.onResume()
            java.lang.Class<com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil> r0 = com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil.class
            monitor-enter(r0)
            com.ktakilat.cbase.cache.KvSave r1 = com.ktakilat.loan.global.AppKv.g()     // Catch:{ all -> 0x001c }
            com.tencent.mmkv.MMKV r1 = r1.f465a     // Catch:{ all -> 0x001c }
            java.lang.String r2 = "entry_is_loggined_cq"
            r3 = 1
            boolean r1 = r1.getBoolean(r2, r3)     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            if (r1 != 0) goto L_0x0019
            com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil.a()
        L_0x0019:
            return
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            throw r1
        L_0x001c:
            r1 = move-exception
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.input_pwd.InputPwdActivity.onResume():void");
    }

    public final int r() {
        return WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.navigationBars();
    }

    public final LifecycleTransformer z() {
        return RxLifecycle.a(this.c, ActivityEvent.DESTROY);
    }
}
