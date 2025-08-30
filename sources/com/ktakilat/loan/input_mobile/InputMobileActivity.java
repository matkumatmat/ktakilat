package com.ktakilat.loan.input_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.KeybordUtils;
import com.ktakilat.loan.R;
import com.ktakilat.loan.input_mobile.InputMobileContact;
import com.pendanaan.kta.databinding.ActivityInputMobileBinding;
import org.apache.commons.lang3.StringUtils;

@SuppressLint({"NonConstantResourceId"})
public class InputMobileActivity extends BaseActivity implements InputMobileContact.View {
    public static final /* synthetic */ int o = 0;
    public InputMobilePresenter i;
    public int j;
    public int k;
    public boolean l = false;
    public Intent m = null;
    public ActivityInputMobileBinding n;

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        boolean z = false;
        if (i2 == this.j) {
            if (i3 == -1) {
                z = true;
            }
            this.l = z;
            this.m = intent;
        } else if (i2 == 301) {
            if (i3 == -1) {
                z = true;
            }
            this.l = z;
        } else if (i2 == 302) {
            if (i3 == -1) {
                z = true;
            }
            this.l = z;
        }
        if (i3 == 1) {
            setResult(1);
            finish();
        } else if (this.l) {
            onBackPressed();
        }
    }

    public final void onBackPressed() {
        int i2;
        if (this.l) {
            i2 = -1;
        } else {
            i2 = 0;
        }
        setResult(i2, this.m);
        super.onBackPressed();
    }

    /* JADX WARNING: type inference failed for: r3v4, types: [java.lang.Object, com.ktakilat.loan.input_mobile.InputMobilePresenter] */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityInputMobileBinding inflate = ActivityInputMobileBinding.inflate(getLayoutInflater());
        this.n = inflate;
        setContentView((View) inflate.getRoot());
        ? obj = new Object();
        obj.f502a = this;
        this.i = obj;
        this.j = getIntent().getIntExtra("processRequestCode", 0);
        this.k = getIntent().getIntExtra("inputType", 0);
        this.n.pageTitle.title.setText(R.string.application_name);
        this.n.phoneInputEdit.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int length = charSequence.length();
                InputMobileActivity inputMobileActivity = InputMobileActivity.this;
                if (length > 24) {
                    CharSequence subSequence = charSequence.subSequence(0, 24);
                    inputMobileActivity.n.phoneInputEdit.setText(subSequence);
                    inputMobileActivity.n.phoneInputEdit.setSelection(subSequence.length());
                    return;
                }
                InputMobilePresenter inputMobilePresenter = inputMobileActivity.i;
                String charSequence2 = charSequence.toString();
                inputMobilePresenter.getClass();
                StringBuilder sb = new StringBuilder();
                for (char c2 : charSequence2.toCharArray()) {
                    if (c2 >= '0' && c2 <= '9') {
                        sb.append(c2);
                        if (sb.length() % 5 == 4) {
                            sb.append(StringUtils.SPACE);
                        }
                    }
                }
                if (sb.length() > 0 && sb.lastIndexOf(StringUtils.SPACE) == sb.length() - 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                String sb2 = sb.toString();
                if (sb2.length() != charSequence.length()) {
                    inputMobileActivity.n.phoneInputEdit.setText(sb2);
                    inputMobileActivity.n.phoneInputEdit.setSelection(sb2.length());
                } else if (charSequence.length() >= 11) {
                    inputMobileActivity.n.passSubmit.setEnabled(true);
                } else {
                    inputMobileActivity.n.passSubmit.setEnabled(false);
                }
            }
        });
        this.n.phoneInputEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z && InputMobileActivity.this.j == 100) {
                    KtaCollect.n_change_pho_update_pho_clc_type();
                }
            }
        });
        if (this.j == 100) {
            KtaCollect.n_change_pho_update_pho_exp();
            this.n.top1Tv.setVisibility(0);
            this.n.tipIvChangeMobile.setVisibility(0);
            this.n.tipIvForgetPwd.setVisibility(8);
            this.n.top2Tv.setText(R.string.change_phone_input_mobile_tip);
        } else {
            finish();
        }
        if (this.n.phoneInputEdit.isEnabled()) {
            KeybordUtils.c(this.n.phoneInputEdit);
        }
        this.n.pageTitle.backward.setOnClickListener(new t0(this, 7));
        this.n.passSubmit.setOnClickListener(new a(this));
        this.n.phoneInputEdit.setOnClickListener(new y9(2));
    }

    public final void onDestroy() {
        InputMobilePresenter inputMobilePresenter = this.i;
        if (inputMobilePresenter != null) {
            inputMobilePresenter.getClass();
        }
        super.onDestroy();
    }
}
